package alfialdo.jwork.controller;
import alfialdo.jwork.database.DatabaseRecruiterPostgre;
import alfialdo.jwork.exception.RecruiterNotFoundException;
import alfialdo.jwork.source.Location;
import alfialdo.jwork.source.Recruiter;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RequestMapping("/recruiter")
@RestController
public class RecruiterController {

    @RequestMapping("")
    public ArrayList<Recruiter> getAllRecruiter() {
        return DatabaseRecruiterPostgre.getRecruiterDatabase();
    }

    @RequestMapping("/{id}")
    public Recruiter getRecruiterById(@PathVariable int id) {
        Recruiter recruiter = null;

        try {
            recruiter =  DatabaseRecruiterPostgre.getRecruiterById(id);
        } catch (RecruiterNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return recruiter;
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public Recruiter addRecruiter(@RequestParam(value = "name") String name,
                      @RequestParam(value = "email") String email,
                      @RequestParam(value = "phoneNumber") String phoneNumber,
                      @RequestParam(value = "province") String province,
                      @RequestParam(value = "city") String city,
                      @RequestParam(value = "description") String description) {

        Recruiter recruiter = null;

        try{
            Location loc = new Location(province, city, description);
            recruiter = new Recruiter(DatabaseRecruiterPostgre.getLastId()+1, name, email, phoneNumber, loc);
            DatabaseRecruiterPostgre.addRecruiter(recruiter);
        } catch (Exception e) {
            System.out.println("Cannot add recruiter to database!");
        }

        return recruiter;
    }
}
