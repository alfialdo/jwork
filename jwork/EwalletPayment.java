import java.text.SimpleDateFormat;

/**
 * Class untuk ewallet payment - subclass dari Invoice
 * @author Muhammad Alfi A
 * @version Modul 4 - 30 March 2021
 */
public class EwalletPayment extends Invoice {
    private static PaymentType PAYMENT_TYPE = PaymentType.EwalletPayment;
    private Bonus bonus;

    public EwalletPayment(int id, Job job, Jobseeker jobseeker, InvoiceStatus invoiceStatus) {
        super(id, job, jobseeker, invoiceStatus);
    }

    public EwalletPayment(int id, Job job, Jobseeker jobseeker, InvoiceStatus invoiceStatus, Bonus bonus) {
        super(id, job, jobseeker, invoiceStatus);
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
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat ("dd MMMM yyyy");
        dateFormat.setTimeZone(getDate().getTimeZone());
        if(bonus != null && bonus.getActive() == true && getTotalFee() > bonus.getMinTotalFee()) {
            return "Id= " + getId() + 
            "\nJob= " + getJob().getCategory() + 
            "\nDate= " + dateFormat.format(getDate().getTime()) + 
            "\nJob Seeker= " + getJobseeker().getName() + 
            "\nTotal Fee= " + super.totalFee + 
            "\nReferral Code= " + bonus.getReferralCode() +
            "\nStatus= " + getInvoiceStatus()+ 
            "\nStatus= " + PAYMENT_TYPE;
        }
        else {
            return "Id= " + getId() + 
            "\nJob= " + getJob().getCategory() + 
            "\nDate= " + dateFormat.format(getDate().getTime()) + 
            "\nJob Seeker= " + getJobseeker().getName() + 
            "\nTotal Fee= " + super.totalFee + 
            "\nStatus= " + getInvoiceStatus()+ 
            "\nStatus= " + PAYMENT_TYPE;  
        }
    }
    
}
