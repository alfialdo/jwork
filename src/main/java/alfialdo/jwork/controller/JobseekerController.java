package alfialdo.jwork.controller;

import alfialdo.jwork.database.DatabaseJobseekerPostgre;
import alfialdo.jwork.exception.EmailAlreadyExistsException;
import alfialdo.jwork.exception.JobseekerNotFoundException;
import alfialdo.jwork.source.Jobseeker;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Controller Jobseeker sebagai API penghubung antara aplikasi
 * dengan database Jobseeker PostgreSQL
 * @author Muhammad Alfi A
 * @version Final Project - 20 June 2021
 */
@RequestMapping("/jobseeker")
@RestController
public class JobseekerController {

    /**
     * Method yang digunakan untuk fetch seluruh database Jobseeker
     * @return ArrayList<Jobseeker>
     */
    @RequestMapping("")
    public ArrayList<Jobseeker> getAllJobseeker() {
        return DatabaseJobseekerPostgre.getJobseekerDatabase();
    }

    /**
     * Method yang digunakan untuk fetch data Jobseeker berdasarkan id
     * @param id
     * @return
     */
    @RequestMapping("/{id}")
    public Jobseeker getJobseekerById(@PathVariable int id) {
        Jobseeker jobseeker = null;
        try {
            jobseeker = DatabaseJobseekerPostgre.getJobseekerById(id);
        } catch (JobseekerNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return jobseeker;
    }

    /**
     * Method yang digunakan registrasi Jobseeker baru ke database
     * @param name
     * @param email
     * @param password
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Jobseeker registerJobseeker(@RequestParam(value="name") String name,
                                       @RequestParam(value="email") String email,
                                       @RequestParam(value="password") String password)
    {
        Jobseeker jobseeker = new Jobseeker(DatabaseJobseekerPostgre.getLastId() + 1,name, email, password);
        try {
            DatabaseJobseekerPostgre.addJobseeker(jobseeker);
        } catch (EmailAlreadyExistsException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return jobseeker;
    }

    /**
     * Method yang digunakan untuk cek login dari Jobseeker pada aplikasi
     * @param email
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Jobseeker loginJobseeker(@RequestParam(value = "email") String email,
                                    @RequestParam(value = "password") String password)
    {
        return DatabaseJobseekerPostgre.jobseekerLogin(email, password);
    }


}