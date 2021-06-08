package alfialdo.jwork.controller;
import alfialdo.jwork.*;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RequestMapping("/job")
@RestController
public class JobController {

    @RequestMapping("")
    public ArrayList<Job> getAllJob() {
        return DatabaseJob.getJobDatabase();
    }

    @RequestMapping("/{id}")
    public Job getJobById(@PathVariable int id) {
        Job job = null;

        try {
            job =  DatabaseJob.getJobById(id);
        } catch (JobNotFoundException e) {
            System.out.println(e.getMessage());;
        }

        return job;
    }

    @RequestMapping("/recruiter/{recruiterId}")
    public ArrayList<Job> getJobByRecruiter(@PathVariable int recruiterId) {
        ArrayList<Job> jobs = null;
        jobs = DatabaseJob.getJobByRecruiter(recruiterId);
        return jobs;
    }

    @RequestMapping("/category/{category}")
    public ArrayList<Job> getJobByCategory(@PathVariable JobCategory category) {
        return DatabaseJob.getJobByCategory(category);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Job addJob(@RequestParam(value = "name") String name,
                            @RequestParam(value = "fee") int fee,
                            @RequestParam(value = "category") JobCategory category,
                            @RequestParam(value = "recruiterId") int recruiterId) {

        Job job = null;

        try {
            job = new Job(DatabaseJob.getLastId()+1, fee, name, category, DatabaseRecruiter.getRecruiterById(recruiterId));
            DatabaseJob.addJob(job);
        } catch (RecruiterNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return job;
    }
}
