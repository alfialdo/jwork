public class Bonus {
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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExtraFee() {
        return extraFee;
    }

    public void setExtraFee(int extraFee) {
        this.extraFee = extraFee;
    }

    public int getMinTotalFee() {
        return minTotalFee;
    }

    public void setMinTotalFee(int minTotalFee) {
        this.minTotalFee = minTotalFee;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void printData() {
        System.out.println("ID : " + id);
        System.out.println("Extra Fee : " + extraFee);
        System.out.println("Min Total Fee : " + minTotalFee);
        System.out.println("Referral Code : " + referralCode);
        System.out.println("Status : " + active);
    }
}
