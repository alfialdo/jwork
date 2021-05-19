import java.util.ArrayList;

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

    public static Bonus getBonusById(int id) throws BonusNotFoundException {
        for(Bonus bonus : BONUS_DATABASE) {
            if (bonus.getId() == id) {
                return bonus;
            }
        }

        throw new BonusNotFoundException(id);
    }

    public static Bonus getBonusByReferralCode(String referralCode) {
        for(Bonus bonus : BONUS_DATABASE) {
            if (bonus.getReferralCode().equals(referralCode)) {
                return bonus;
            }
        }

        return null;
    }

    /**
     * @return Boolean
     */
    public static boolean addBonus(Bonus bonus) throws ReferralCodeAlreadyExistsException {
        for(Bonus bonuses : BONUS_DATABASE) {
            if(bonuses.getReferralCode().equals(bonus.getReferralCode())) {
                throw new ReferralCodeAlreadyExistsException(bonus);
            }
        }

        BONUS_DATABASE.add(bonus);
        lastId = bonus.getId();
        return true;
    }

    public static boolean activeBonus(int id) {
        for(Bonus bonuses :BONUS_DATABASE) {
            if (bonuses.getId() == id) {
                bonuses.setActive(true);
                return true;
            }
        }

        return false;
    }

    public static boolean deactiveBonus(int id) {

        for(Bonus bonuses : BONUS_DATABASE) {
            if (bonuses.getId() == id) {
                bonuses.setActive(false);
                return true;
            }
        }
        return false;
    }

    public static boolean removeBonus(int id) throws BonusNotFoundException {
        for(Bonus bonuses : BONUS_DATABASE) {
            if (bonuses.getId() == id) {
                BONUS_DATABASE.remove(id);
                return true;
            }
        }
        throw new BonusNotFoundException(id);
    }
}
