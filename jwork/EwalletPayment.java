/**
 * Class untuk ewallet payment - subclass dari Invoice
 * @author Muhammad Alfi A
 * @version Modul 4 - 30 March 2021
 */
public class EwalletPayment extends Invoice {
    private static PaymentType PAYMENT_TYPE = PaymentType.EwalletPayment;
    private Bonus bonus;

    public EwalletPayment(int id, Job job, String date, Jobseeker jobseeker, InvoiceStatus invoiceStatus) {
        super(id, job, date, jobseeker, invoiceStatus);
    }

    public EwalletPayment(int id, Job job, String date, Jobseeker jobseeker, InvoiceStatus invoiceStatus, Bonus bonus) {
        super(id, job, date, jobseeker, invoiceStatus);
        this.bonus = bonus;
    }
    
    /** 
     * @return PaymentType
     */
    public PaymentType getPaymentType() {
        return PAYMENT_TYPE;
    }

    
    /** 
     * @return Bonus
     */
    public Bonus getBonus() {
        return bonus;
    }

    
    /** 
     * @param bonus
     */
    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }

    
    /** 
     * @param totalFee
     */
    public void setTotalFee() {
        if(bonus != null && bonus.getActive() == true && totalFee > bonus.getMinTotalFee()) {
            super.totalFee = getJob().getFee() + bonus.getExtraFee();
        }
        else {
            System.out.println(totalFee);
            super.totalFee = getJob().getFee();
        }
    }
    public void printData() {
        System.out.println("==========INVOICE==========");
        System.out.println("ID : " + getId());
        System.out.println("Job : " + getJob().getCategory());
        System.out.println("Date : " + getDate());
        System.out.println("Job Seeker : " + getJobseeker().getName());
        System.out.println("Total Fee : " + super.totalFee);
        if(bonus != null && bonus.getActive() == true && getTotalFee() > bonus.getMinTotalFee()) {
            System.out.println("Referal Code : " + bonus.getReferralCode());
        }  
        System.out.println("Status : " + getInvoiceStatus());
        System.out.println("Payment Type : " + PAYMENT_TYPE);
    }
}
