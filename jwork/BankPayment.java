import java.text.SimpleDateFormat;

public class BankPayment extends Invoice{
    private static PaymentType PAYMENT_TYPE = PaymentType.BankPayment;
    private int adminFee = 0;

    public BankPayment(int id, Job job, Jobseeker jobseeker, InvoiceStatus invoiceStatus) {
        super(id, job, jobseeker, invoiceStatus);
    }

    public BankPayment(int id, Job job, Jobseeker jobseeker, InvoiceStatus invoiceStatus, int adminFee) {
        super(id, job, jobseeker, invoiceStatus);
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
        if(adminFee != 0) {
            super.totalFee = getJob().getFee() - adminFee;
        }
        else {
            super.totalFee = getJob().getFee();
        }
    }

    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat ("dd MMMM yyyy");
        dateFormat.setTimeZone(getDate().getTimeZone());
        return "Id= " + getId() + 
        "\nJob= " + getJob().getCategory() + 
        "\nDate= " + dateFormat.format(getDate().getTime()) + 
        "\nJob Seeker= " + getJobseeker().getName() + 
        "\nAdmin Fee= " + adminFee + 
        "\nTotal Fee= " + super.totalFee + 
        "\nStatus= " + getInvoiceStatus()+ 
        "\nPayment Type= " + PAYMENT_TYPE;
    }
}
