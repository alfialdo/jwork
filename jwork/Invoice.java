
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


    public Invoice(int id, int idJob, int totalFee, String date, Jobseeker jobseeker) {
        this.id = id;
        this.idJob = idJob;
        this.totalFee = totalFee;
        this.date = date;
        this.jobseeker = jobseeker;
    }

    
    /** 
     * Getter untuk attribute id
     * @return int
     */
    public int getId() {
        return this.id;
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
        return this.idJob;
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
        return this.totalFee;
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
        return this.date;
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
        return this.jobseeker;
    }

    
    /** 
     * Setter untuk object jobseeker
     * @param jobseeker
     * 
     */
    public void setJobseeker(Jobseeker jobseeker) {
        this.jobseeker = jobseeker;
    }

    /**
     * Method untuk print data
     */
    public void printData(){
        System.out.println("Jumlah Harga : " + getTotalFee());
    }
}