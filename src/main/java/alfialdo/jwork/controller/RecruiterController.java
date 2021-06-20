package alfialdo.jwork.controller;
import alfialdo.jwork.database.DatabaseInvoicePostgre;
import alfialdo.jwork.database.DatabaseRecruiterPostgre;
import alfialdo.jwork.exception.EmailAlreadyExistsException;
import alfialdo.jwork.exception.InvoiceNotFoundException;
import alfialdo.jwork.exception.RecruiterNotFoundException;
import alfialdo.jwork.source.Location;
import alfialdo.jwork.source.Recruiter;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

/**
 * Controller Recruiter sebagai API penghubung antara aplikasi
 * dengan database Recruiter PostgreSQL
 * @author Muhammad Alfi A
 * @version Final Project - 20 June 2021
 */
@RequestMapping("/recruiter")
@RestController
public class RecruiterController {

    /**
     * Method yang digunakan untuk fetch seluruh database Recruiter
     * @return ArrayList<Recruiter>
     *
     */
    @RequestMapping("")
    public ArrayList<Recruiter> getAllRecruiter() {
        return DatabaseRecruiterPostgre.getRecruiterDatabase();
    }

    /**
     * Method yang digunakan untuk fetch Recruiter berdasarkan id
     * @param id
     * @return
     */
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

    /**
     * Method yang digunakan untuk menambahkan Jobseeker ke database
     * @param name
     * @param email
     * @param phoneNumber
     * @param province
     * @param city
     * @param description
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Recruiter addRecruiter(@RequestParam(value = "name") String name,
                      @RequestParam(value = "email") String email,
                      @RequestParam(value = "phoneNumber") String phoneNumber,
                      @RequestParam(value = "province") String province,
                      @RequestParam(value = "city") String city,
                      @RequestParam(value = "description") String description) {

        Recruiter recruiter;

        try{
            Location loc = new Location(province, city, description);
            recruiter = new Recruiter(DatabaseRecruiterPostgre.getLastId()+1, name, email, phoneNumber, loc);
            DatabaseRecruiterPostgre.addRecruiter(recruiter);
        } catch (EmailAlreadyExistsException e) {
            System.out.println(e.getMessage());
            recruiter = null;
        }

        return recruiter;
    }

    /**
     * Method yang digunakan untuk menghapus Recruiter pada database
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean removeRecruiter(@PathVariable int id){

        try {
            DatabaseRecruiterPostgre.removeRecruiter(id);
            return true;
        } catch (RecruiterNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
}
