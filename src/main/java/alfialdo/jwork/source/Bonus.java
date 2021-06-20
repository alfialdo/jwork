package alfialdo.jwork.source;

import java.io.Serializable;

/**
 * Class untuk bonus fee
 * @author Muhammad Alfi A
 * @version Final Project - 20 June 2021

 */
public class Bonus implements Serializable {
    private int id, extraFee, minTotalFee;
    private String referralCode;
    private Boolean active;

    public Bonus(int id, int extraFee, int minTotalFee, String referralCode, Boolean active) {
        this.id = id;
        this.extraFee = extraFee;
        this.minTotalFee = minTotalFee;
        this.referralCode = referralCode;
        this.active = active;
    }

    
    /**
     * Method getter untuk id
     * @return int
     */
    public int getId() {
        return id;
    }

    
    /**
     * Method setter untuk id
     */
    public void setId(int id) {
        this.id = id;
    }

    
    /**
     * Method getter untuk extra fee
     * @return int
     */
    public int getExtraFee() {
        return extraFee;
    }

    
    /**
     * Method setter untuk extra fee
     */
    public void setExtraFee(int extraFee) {
        this.extraFee = extraFee;
    }

    
    /**
     * Method getter untuk minimal total fee
     * @return int
     */
    public int getMinTotalFee() {
        return minTotalFee;
    }

    
    /**
     * Method setter untuk minimal total fee
     */
    public void setMinTotalFee(int minTotalFee) {
        this.minTotalFee = minTotalFee;
    }

    
    /**
     * Method getter untuk referral code
     * @return String
     */
    public String getReferralCode() {
        return referralCode;
    }

    
    /**
     * Method setter untuk referral code
     */
    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    
    /**
     * Method getter untuk active
     * @return Boolean
     */
    public Boolean getActive() {
        return active;
    }

    
    /**
     * Method setter untuk active
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * Method untuk mengubah informasi object Bonus
     * menjadi String
     * @return String
     */
    public String toString (){
        return "=======Bonus=======\n" +
         "Id= " + id +
        "\nReferral Code= " + referralCode + 
        "\nExtra Fee= " + extraFee + 
        "\nMin Total Fee= " + minTotalFee + 
        "\nActive Status= " + active;
    }
}
