package alfialdo.jwork.deprecated;
import alfialdo.jwork.source.Jobseeker;
import alfialdo.jwork.exception.EmailAlreadyExistsException;
import alfialdo.jwork.exception.JobseekerNotFoundException;

import java.util.ArrayList;

/**
 * Class untuk database jobseeker
 * @author Muhammad Alfi A
 * @version Modul 4 - 30 March 2021

 */

@Deprecated
public class DatabaseJobseeker{
    private static final ArrayList<Jobseeker> JOBSEEKER_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    public static ArrayList<Jobseeker> getJobseekerDatabase() {
        return JOBSEEKER_DATABASE;
    }

    public static int getLastId() {
        return lastId;
    }

    public static Jobseeker getJobseekerById(int id) throws JobseekerNotFoundException {

        for(Jobseeker jobseekers : JOBSEEKER_DATABASE) {
            if (jobseekers.getId() == id) {
                return jobseekers;
            }
        }
        throw new JobseekerNotFoundException(id);
    }

    /**
     * @return Boolean
     */
    public static boolean addJobseeker(Jobseeker jobseeker) throws EmailAlreadyExistsException {

        for(Jobseeker jobseekers : JOBSEEKER_DATABASE) {
            if (jobseekers.getEmail().equals(jobseeker.getEmail())) {
                throw new EmailAlreadyExistsException(jobseeker.getEmail());
            }
        }

        JOBSEEKER_DATABASE.add(jobseeker);
        lastId = jobseeker.getId();
        return true;

    }

    public static boolean removeJobseeker(int id) throws JobseekerNotFoundException {
        for(Jobseeker jobseekers : JOBSEEKER_DATABASE) {
            if (jobseekers.getId() == id) {
                JOBSEEKER_DATABASE.remove(id);
                return true;
            }
        }

        throw new JobseekerNotFoundException(id);
    }

    public static Jobseeker jobseekerLogin(String email, String password) {
        for(Jobseeker jobseekers : JOBSEEKER_DATABASE) {
            if(jobseekers.getEmail().equals(email) && jobseekers.getPassword().equals(password)) {
                return jobseekers;
            }
        }

        return null;
    }
}