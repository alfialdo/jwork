package alfialdo.jwork.source;

import java.io.Serializable;

/**
 * Class untuk bonus fee
 * @author Muhammad Alfi A
 * @version Modul 4 - 30 March 2021

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
     * @return int
     */
    public int getId() {
        return id;
    }

    
    /** 
     */
    public void setId(int id) {
        this.id = id;
    }

    
    /** 
     * @return int
     */
    public int getExtraFee() {
        return extraFee;
    }

    
    /** 
     */
    public void setExtraFee(int extraFee) {
        this.extraFee = extraFee;
    }

    
    /** 
     * @return int
     */
    public int getMinTotalFee() {
        return minTotalFee;
    }

    
    /** 
     */
    public void setMinTotalFee(int minTotalFee) {
        this.minTotalFee = minTotalFee;
    }

    
    /** 
     * @return String
     */
    public String getReferralCode() {
        return referralCode;
    }

    
    /** 
     */
    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    
    /** 
     * @return Boolean
     */
    public Boolean getActive() {
        return active;
    }

    
    /** 
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    public String toString (){
        return "=======Bonus=======\n" +
         "Id= " + id +
        "\nReferral Code= " + referralCode + 
        "\nExtra Fee= " + extraFee + 
        "\nMin Total Fee= " + minTotalFee + 
        "\nActive Status= " + active;
    }
}
