import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class untuk database bonus
 * @author Muhammad Alfi A
 * @version Modul 4 - 30 March 2021

 */
public class DatabaseRecruiter{
    private static ArrayList<Recruiter> RECRUITER_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    public static ArrayList<Recruiter> getRecruiterDatabase() {
        return RECRUITER_DATABASE;
    }

    public static int getLastId() {
        return lastId;
    }

    public static Recruiter getRecruiterById(int id) throws RecruiterNotFoundException {
        for(Recruiter recruiters : RECRUITER_DATABASE) {
            if (recruiters.getId() == id) {
                return recruiters;
            }
        }
        throw new RecruiterNotFoundException(id);
    }

    /**
     * @return Boolean
     */
    public static boolean addRecruiter(Recruiter recruiter) {
        RECRUITER_DATABASE.add(recruiter);
        lastId = recruiter.getId();
        return true;
    }

    public static boolean removeRecruiter(int id) throws RecruiterNotFoundException {
        for(Recruiter recruiters : RECRUITER_DATABASE) {
            if (recruiters.getId() == id) {
                RECRUITER_DATABASE.remove(id);
                return true;
            }
        }
        throw new RecruiterNotFoundException(id);
    }
}