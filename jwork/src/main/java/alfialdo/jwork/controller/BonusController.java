package alfialdo.jwork.controller;
import alfialdo.jwork.*;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RequestMapping("/bonus")
@RestController
public class BonusController {

    @RequestMapping("")
    public ArrayList<Bonus> getAllBonus() {
        return DatabaseBonus.getBonusDatabase();
    }

    @RequestMapping("/{referralCode}")
    public Bonus getBonusByReferralCode(@PathVariable String referralCode) {
        Bonus bonus = null;

        try {
            bonus = DatabaseBonus.getBonusByReferralCode(referralCode);
        } catch (Exception e) {
            System.out.println("Bonus can not be found!");
        }

        return bonus;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Bonus addBonus(@RequestParam(value = "referralCode") String referralCode,
                          @RequestParam(value = "extraFee") int extraFee,
                          @RequestParam(value = "minTotalFee") int minTotalFee,
                          @RequestParam(value = "active") Boolean active) {

        Bonus bonus = null;

        try {
            bonus = new Bonus(DatabaseBonus.getLastId()+1, extraFee, minTotalFee, referralCode, active);
            DatabaseBonus.addBonus(bonus);
        } catch (ReferralCodeAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        return bonus;
    }
}
