import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class untuk database bonus
 * @author Muhammad Alfi A
 * @version Modul 4 - 30 March 2021

 */
public class DatabaseBonus {
    private static ArrayList<Bonus> BONUS_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    public static ArrayList<Bonus> getBonusDatabase() {
        return BONUS_DATABASE;
    }

    public static int getLastId() {
        return lastId;
    }

    public static Bonus getBonusById(int id) {
        int i=0;
        while(i < BONUS_DATABASE.size()) {
            if (BONUS_DATABASE.get(i).getId() == id) {
                return BONUS_DATABASE.get(i);
            }
            i++;
        }
        return null;
    }

    public static Bonus getBonusByReferralCode(String referralCode) {
        int i=0;
        while(i < BONUS_DATABASE.size()) {
            if (BONUS_DATABASE.get(i).getReferralCode() == referralCode) {
                return BONUS_DATABASE.get(i);
            }
            i++;
        }
        return null;
    }

    /**
     * @return Boolean
     */
    public static boolean addBonus(Bonus bonus) {
        BONUS_DATABASE.add(bonus);
        lastId = BONUS_DATABASE.size()-1;
        return true;
    }
    public static boolean activeBonus(int id) {
        int i=0;
        while(i < BONUS_DATABASE.size()) {
            if (BONUS_DATABASE.get(i).getId() == id) {
                BONUS_DATABASE.get(i).setActive(true);
                return true;
            }
            i++;
        }
        return false;
    }

    public static boolean deactiveBonus(int id) {
        int i=0;
        while(i < BONUS_DATABASE.size()) {
            if (BONUS_DATABASE.get(i).getId() == id) {
                BONUS_DATABASE.get(i).setActive(false);
                return true;
            }
            i++;
        }
        return false;
    }

    public static boolean removeBonus(int id) {
        int i=0;
        while(i < BONUS_DATABASE.size()) {
            if (BONUS_DATABASE.get(i).getId() == id) {
                BONUS_DATABASE.remove(i);
                return true;
            }
            i++;
        }
        return false;
    }
}
