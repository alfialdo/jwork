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

/**
 * Controller Job sebagai API penghubung antara aplikasi
 * dengna database Job PostgreSQL
 * @author Muhammad Alfi A
 * @version Final Project - 20 June 2021
 */
@RequestMapping("/job")
@RestController
public class JobController {

    /**
     * Method yang digunakan untuk fetch seluruh database Job
     * @return
     */
    @RequestMapping("")
    public ArrayList<Job> getAllJob() {
        return DatabaseJobPostgre.getJobDatabase();
    }

    /**
     * Method yang digunakan untuk fetch data Job berdasarkan id
     * @param id
     * @return
     */
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

    /**
     * Method yang digunakan untuk fetch data Job berdasarkan
     * Recruiter tertentu
     * @param recruiterId
     * @return
     */
    @RequestMapping("/recruiter/{recruiterId}")
    public ArrayList<Job> getJobByRecruiter(@PathVariable int recruiterId) {
        return DatabaseJobPostgre.getJobByRecruiter(recruiterId);
    }

    /**
     * Method yang digunakan untuk fetch data JOb berdasarkan category
     * @param category
     * @return
     */
    @RequestMapping("/category/{category}")
    public ArrayList<Job> getJobByCategory(@PathVariable JobCategory category) {
        return DatabaseJobPostgre.getJobByCategory(category);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Job addJob(@RequestParam(value = "name") String name,
                            @RequestParam(value = "fee") int fee,
                            @RequestParam(value = "category") JobCategory category,
                            @RequestParam(value = "recruiterId") int recruiterId) {

        Job job;

        try {
            job = new Job(DatabaseJobPostgre.getLastId()+1, fee, name, category, DatabaseRecruiterPostgre.getRecruiterById(recruiterId));
            DatabaseJobPostgre.addJob(job);
        } catch (RecruiterNotFoundException e) {
            System.out.println(e.getMessage());
            job = null;
        }

        return job;
    }

    /**
     * Method yang digunakan untuk menambahkan Job baru ke database
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean removeJob(@PathVariable int id){

        try {
            DatabaseJobPostgre.removeJob(id);
            return true;
        } catch (JobNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
}
