package alfialdo.jwork;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class BankPayment extends Invoice{
    private final static PaymentType PAYMENT_TYPE = PaymentType.BankPayment;
    private int adminFee = 0;

    public BankPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker, InvoiceStatus invoiceStatus) {
        super(id, jobs, jobseeker);
    }

    public BankPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker, InvoiceStatus invoiceStatus, int adminFee) {
        super(id, jobs, jobseeker);
        this.adminFee = adminFee;
    }

    @Override
    public PaymentType getPaymentType() {
        return PAYMENT_TYPE;
    }

    public int getAdminFee() {
        return adminFee;
    }

    public void setAdminFee(int adminFee) {
        this.adminFee = adminFee;
    }
    
    @Override
    public void setTotalFee() {
        for(Job jobs : super.getJobs())
        if(adminFee != 0) {
            super.totalFee = jobs.getFee() - adminFee;
        }
        else {
            super.totalFee = jobs.getFee();
        }
    }

    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat ("dd MMMM yyyy");
        StringBuilder allJobs = null;
        dateFormat.setTimeZone(getDate().getTimeZone());
        for (Job jobs : super.getJobs()) {
            allJobs.append(jobs.getName());
        }

        return "Id= " + getId() + 
        "\nJob= " + allJobs +
        "\nDate= " + dateFormat.format(getDate().getTime()) + 
        "\nJob Seeker= " + getJobseeker().getName() + 
        "\nAdmin Fee= " + adminFee + 
        "\nTotal Fee= " + super.totalFee + 
        "\nStatus= " + getInvoiceStatus()+ 
        "\nPayment Type= " + PAYMENT_TYPE;
    }
}
