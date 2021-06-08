package alfialdo.jwork;
import java.util.ArrayList;
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
    private ArrayList<Job> jobs;
    private InvoiceStatus invoiceStatus;


    public Invoice(int id, ArrayList<Job> jobs, Jobseeker jobseeker) {
        this.id = id;
        this.jobs = jobs;
        this.jobseeker = jobseeker;
        this.invoiceStatus = InvoiceStatus.Ongoing;
        this.date = Calendar.getInstance();
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
    public ArrayList<Job> getJobs() {
        return jobs;
    }

    
    /** 
     * Setter untuk attribute idJob
     */
    public void setJobs(ArrayList<Job> jobs) {
        this.jobs = jobs;
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