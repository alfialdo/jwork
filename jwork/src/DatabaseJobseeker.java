import java.util.ArrayList;

/**
 * Class untuk database jobseeker
 * @author Muhammad Alfi A
 * @version Modul 4 - 30 March 2021

 */
public class DatabaseJobseeker{
    private static ArrayList<Jobseeker> JOBSEEKER_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    public static ArrayList<Jobseeker> getJobseekerDatabase() {
        return JOBSEEKER_DATABASE;
    }

    public static int getLastId() {
        return lastId;
    }

    public static Jobseeker getJobseekerById(int id) throws JobSeekerNotFoundException {

        for(Jobseeker jobseekers : JOBSEEKER_DATABASE) {
            if (jobseekers.getId() == id) {
                return jobseekers;
            }
        }
        throw new JobSeekerNotFoundException(id);
    }

    /**
     * @return Boolean
     */
    public static boolean addJobseeker(Jobseeker jobseeker) throws EmailAlreadyExistsException {
        for(Jobseeker jobseekers : JOBSEEKER_DATABASE) {
            if(jobseekers.getEmail() == jobseeker.getEmail()) {
                throw new EmailAlreadyExistsException(jobseeker);
            }
        }

        JOBSEEKER_DATABASE.add(jobseeker);
        lastId = jobseeker.getId();
        return true;
    }

    public static boolean removeJobseeker(int id) throws JobSeekerNotFoundException {
        for(Jobseeker jobseekers : JOBSEEKER_DATABASE) {
            if (jobseekers.getId() == id) {
                JOBSEEKER_DATABASE.remove(id);
                return true;
            }
        }

        throw new JobSeekerNotFoundException(id);
    }
}