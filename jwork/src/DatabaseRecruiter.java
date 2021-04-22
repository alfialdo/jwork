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

    public static Recruiter getBonusById(int id) {
        int i=0;
        while(i < RECRUITER_DATABASE.size()) {
            if (RECRUITER_DATABASE.get(i).getId() == id) {
                return RECRUITER_DATABASE.get(i);
            }
            i++;
        }
        return null;
    }

    /**
     * @return Boolean
     */
    public static boolean addRecruiter(Recruiter recruiter) {
        RECRUITER_DATABASE.add(recruiter);
        lastId = RECRUITER_DATABASE.size()-1;
        return true;
    }

    public static boolean removeRecruiter(int id) {
        int i=0;
        while(i < RECRUITER_DATABASE.size()) {
            if (RECRUITER_DATABASE.get(i).getId() == id) {
                RECRUITER_DATABASE.remove(i);
                return true;
            }
            i++;
        }
        return false;
    }
}