import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Class untuk ewallet payment - subclass dari Invoice
 * @author Muhammad Alfi A
 * @version Modul 4 - 30 March 2021
 */
public class EwalletPayment extends Invoice {
    private final static PaymentType PAYMENT_TYPE = PaymentType.EwalletPayment;
    private Bonus bonus;

    public EwalletPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker, InvoiceStatus invoiceStatus) {
        super(id, jobs, jobseeker);
    }

    public EwalletPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker, InvoiceStatus invoiceStatus, Bonus bonus) {
        super(id, jobs, jobseeker);
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
     */
    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }

    

    public void setTotalFee() {
        for(Job job : super.getJobs()) {
            if(bonus != null && bonus.getActive() && totalFee > bonus.getMinTotalFee()) {
                super.totalFee = job.getFee() + bonus.getExtraFee();
            }
            else {
                System.out.println(totalFee);
                super.totalFee = job.getFee();
            }
        }

    }
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat ("dd MMMM yyyy");
        dateFormat.setTimeZone(getDate().getTimeZone());
        StringBuilder allJobs = null;
        for (Job jobs : super.getJobs()) {
            allJobs.append(jobs.getName());
        }
        if(bonus != null && bonus.getActive() && getTotalFee() > bonus.getMinTotalFee()) {
            return "Id= " + getId() + 
            "\nJob= " + allJobs +
            "\nDate= " + dateFormat.format(getDate().getTime()) + 
            "\nJob Seeker= " + getJobseeker().getName() + 
            "\nTotal Fee= " + super.totalFee + 
            "\nReferral Code= " + bonus.getReferralCode() +
            "\nStatus= " + getInvoiceStatus()+ 
            "\nStatus= " + PAYMENT_TYPE;
        }
        else {
            return "Id= " + getId() + 
            "\nJob= " + allJobs +
            "\nDate= " + dateFormat.format(getDate().getTime()) + 
            "\nJob Seeker= " + getJobseeker().getName() + 
            "\nTotal Fee= " + super.totalFee + 
            "\nStatus= " + getInvoiceStatus()+ 
            "\nStatus= " + PAYMENT_TYPE;  
        }
    }
    
}
