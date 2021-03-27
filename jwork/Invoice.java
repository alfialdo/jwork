
/**
 * Class untuk bukti invoice
 * @author Muhammad Alfi A
 * @version Modul 2 - 18 March 2021

 */
public class Invoice
{
    private int id, idJob, totalFee;
    private String date;
    private Jobseeker jobseeker;
    private PaymentType paymentType;
    private InvoiceStatus status;


    public Invoice(int id, int idJob, int totalFee, String date, Jobseeker jobseeker, PaymentType paymentType, InvoiceStatus status) {
        this.id = id;
        this.idJob = idJob;
        this.totalFee = totalFee;
        this.date = date;
        this.jobseeker = jobseeker;
        this.paymentType = paymentType;
        this.status = status;
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
     * @return int
     */
    public int getIdJob() {
        return idJob;
    }

    
    /** 
     * Setter untuk attribute idJob
     * @param idJob
     */
    public void setIdJob(int idJob) {
        this.idJob = idJob;
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
    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    
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

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public void setStatus(InvoiceStatus status) {
        this.status = status;
    }

    /**
     * Method untuk print data
     */
    public void printData(){
        System.out.println("ID : " + id);
        System.out.println("ID Job : " + idJob);
        System.out.println("Date : " + date);
        System.out.println("Seeker : " + jobseeker.getName());
        System.out.println("Fee : " + totalFee);
        System.out.println("Payment Type : " + paymentType);
        System.out.println("Status : " + status);
    }
}