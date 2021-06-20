package alfialdo.jwork.controller;
import alfialdo.jwork.database.DatabaseBonusPostgre;
import alfialdo.jwork.exception.BonusNotFoundException;
import alfialdo.jwork.exception.ReferralCodeAlreadyExistsException;
import alfialdo.jwork.source.Bonus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

/**
 * Controller class Bonus sebagai API penghubung antara aplikasi
 * dengan database PostgreSQL
 * @author Muhammad Alfi A
 * @version Final Project - 20 June 2021
 */
@RequestMapping("/bonus")
@RestController
public class BonusController {

    /**
     * Method yang digunakan fetch seluruh database bonus
     * @return ArrayList<Bonus>
     */
    @RequestMapping("")
    public ArrayList<Bonus> getAllBonus() {
        return DatabaseBonusPostgre.getBonusDatabase();
    }

    /**
     * Method yang digunakan untuk fetch data Bonus dengan Referral Code tertentu
     * @param referralCode
     * @return
     */
    @RequestMapping("/{referralCode}")
    public Bonus getBonusByReferralCode(@PathVariable String referralCode) {
        Bonus bonus = null;

        try {
            bonus = DatabaseBonusPostgre.getBonusByReferralCode(referralCode);
        } catch (Exception e) {
            System.out.println("Bonus can not be found!");
        }

        return bonus;
    }

    /**
     * Method yang digunakan untuk menambahkan Bonus ke database
     * @param referralCode
     * @param extraFee
     * @param minTotalFee
     * @param active
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Bonus addBonus(@RequestParam(value = "referralCode") String referralCode,
                          @RequestParam(value = "extraFee") int extraFee,
                          @RequestParam(value = "minTotalFee") int minTotalFee,
                          @RequestParam(value = "active") Boolean active) {

        Bonus bonus;

        try {
            bonus = new Bonus(DatabaseBonusPostgre.getLastId()+1, extraFee, minTotalFee, referralCode, active);
            DatabaseBonusPostgre.addBonus(bonus);
        } catch (ReferralCodeAlreadyExistsException e) {
            System.out.println(e.getMessage());
            bonus = null;
        }

        return bonus;
    }

    /**
     * Method yang digunakan untuk menghapus Bonus pada database
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean removeBonus(@PathVariable int id){

        try {
            DatabaseBonusPostgre.removeBonus(id);
            return true;
        } catch (BonusNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
}
