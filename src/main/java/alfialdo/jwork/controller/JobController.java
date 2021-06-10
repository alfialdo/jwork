package alfialdo.jwork.controller;
import alfialdo.jwork.database.DatabaseJobPostgre;
import alfialdo.jwork.database.DatabaseRecruiterPostgre;
import alfialdo.jwork.deprecated.DatabaseJob;
import alfialdo.jwork.exception.JobNotFoundException;
import alfialdo.jwork.exception.RecruiterNotFoundException;
import alfialdo.jwork.source.Job;
import alfialdo.jwork.source.JobCategory;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RequestMapping("/job")
@RestController
public class JobController {

    @RequestMapping("")
    public ArrayList<Job> getAllJob() {
        return DatabaseJobPostgre.getJobDatabase();
    }

    @RequestMapping("/{id}")
    public Job getJobById(@PathVariable int id) {
        Job job = null;

        try {
            job =  DatabaseJobPostgre.getJobById(id);
        } catch (JobNotFoundException e) {
            System.out.println(e.getMessage());;
        }

        return job;
    }

    @RequestMapping("/recruiter/{recruiterId}")
    public ArrayList<Job> getJobByRecruiter(@PathVariable int recruiterId) {
        return DatabaseJobPostgre.getJobByRecruiter(recruiterId);
    }

    @RequestMapping("/category/{category}")
    public ArrayList<Job> getJobByCategory(@PathVariable JobCategory category) {
        return DatabaseJobPostgre.getJobByCategory(category);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Job addJob(@RequestParam(value = "name") String name,
                            @RequestParam(value = "fee") int fee,
                            @RequestParam(value = "category") JobCategory category,
                            @RequestParam(value = "recruiterId") int recruiterId) {

        Job job = null;

        try {
            job = new Job(DatabaseJob.getLastId()+1, fee, name, category, DatabaseRecruiterPostgre.getRecruiterById(recruiterId));
            DatabaseJobPostgre.addJob(job);
        } catch (RecruiterNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return job;
    }
}
