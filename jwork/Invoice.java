
/**
 * Class untuk bukti invoice
 * @author Muhammad Alfi A
 * @version Modul 2 - 18 March 2021

 */
public abstract class Invoice
{
    private int id;
    protected int totalFee;
    private String date;
    private Jobseeker jobseeker;
    private Job job;
    private InvoiceStatus invoiceStatus;


    public Invoice(int id, Job job, int totalFee, String date, Jobseeker jobseeker, InvoiceStatus invoiceStatus) {
        this.id = id;
        this.job = job;
        this.totalFee = totalFee;
        this.date = date;
        this.jobseeker = jobseeker;
        this.invoiceStatus = invoiceStatus;
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
     * @param id
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
     * @param idJob
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
     * @param totalFee
     */
    public abstract void setTotalFee(int totalFee);
    
    /** 
     * Getter untuk attribute date
     * @return String
     */
    public String getDate() {
        return date;
    }

    
    /** 
     * Setter untuk attribute date
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
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
     * @param jobseeker
     * 
     */
    public void setJobseeker(Jobseeker jobseeker) {
        this.jobseeker = jobseeker;
    }

    public abstract PaymentType getPaymentType();

    public InvoiceStatus getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    /**
     * Method untuk print data
     */
    public abstract void printData();
}