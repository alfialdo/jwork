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

    public static Jobseeker getJobseekerById(int id) {
        int i=0;
        while(i < JOBSEEKER_DATABASE.size()) {
            if (JOBSEEKER_DATABASE.get(i).getId() == id) {
                return JOBSEEKER_DATABASE.get(i);
            }
                        i++;
        }
        return null;
    }

    /**
     * @return Boolean
     */
    public static boolean addJobseeker(Jobseeker jobseeker) {
        JOBSEEKER_DATABASE.add(jobseeker);
        lastId = JOBSEEKER_DATABASE.size()-1;
        return true;
    }

    public static boolean removeJobseeker(int id) {
        int i=0;
        while(i < JOBSEEKER_DATABASE.size()) {
            if (JOBSEEKER_DATABASE.get(i).getId() == id) {
                JOBSEEKER_DATABASE.remove(i);
                return true;
            }
            i++;
        }

        return false;
    }
}