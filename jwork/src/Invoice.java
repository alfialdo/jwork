import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Class untuk bukti invoice
 * @author Muhammad Alfi A
 * @version Modul 4 - 30 March 2021

 */
public abstract class Invoice
{
    private int id;
    protected int totalFee;
    private Calendar date;
    private Jobseeker jobseeker;
    private Job job;
    private InvoiceStatus invoiceStatus;


    public Invoice(int id, Job job, Jobseeker jobseeker, InvoiceStatus invoiceStatus) {
        this.id = id;
        this.job = job;
        this.jobseeker = jobseeker;
        this.invoiceStatus = invoiceStatus;
        this.date = new GregorianCalendar();
    }

    /** 
     * Getter untuk attribute id
     * @return int
     */
    public int getId() {
        return id;
    }

    
    /** 
     * Setter untuk attribute id
     */
    public void setId(int id) {
        this.id = id;
    }

    
    /** 
     * Getter untuk attribute idJob
     * @return Job
     */
    public Job getJob() {
        return job;
    }

    
    /** 
     * Setter untuk attribute idJob
     */
    public void setJob(Job job) {
        this.job = job;
    }

    
    /** 
     * Getter untuk attribute totalFee
     * @return int
     */
    public int getTotalFee() {
        return totalFee;
    }

    
    /** 
     * Setter untuk attribute totalFee
     */
    public abstract void setTotalFee();
    
    /** 
     * Getter untuk attribute date
     * @return String
     */
    public Calendar getDate() {
        return date;
    }

    
    /** 
     * Setter untuk attribute date
     */
    public void setDate(Calendar date) {
        this.date = date;
    }

    public void setDate(int year, int month, int dayOfMonth) {
        this.date = new GregorianCalendar(year, month, dayOfMonth);
    }

    
    /** 
     * Getter untuk object jobseeker
     * @return Jobseeker
     */
    public Jobseeker getJobseeker() {
        return jobseeker;
    }

    
    /** 
     * Setter untuk object jobseeker
     *
     */
    public void setJobseeker(Jobseeker jobseeker) {
        this.jobseeker = jobseeker;
    }

    
    /**
     * @return PaymentType
     */
    public abstract PaymentType getPaymentType();

    
    /** 
     * @return InvoiceStatus
     */
    public InvoiceStatus getInvoiceStatus() {
        return invoiceStatus;
    }

    
    /** 
     */
    public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    /**
     * Method untuk print data
     */
    public abstract String toString();
}