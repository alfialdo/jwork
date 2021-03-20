
/**
 * Class untuk deskripsi job / pekerjaan
 * @author Muhammad Alfi A
 * @version Modul 2 - 18 March 2021
 */
public class Job
{
    private int id, fee;
    private String name, category;
    private Recruiter recuiter;

    public Job(int id, int fee, String name, String category, Recruiter recuiter) {
        this.id = id;
        this.fee = fee;
        this.name = name;
        this.category = category;
        this.recuiter = recuiter;
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
     * Getter untuk attribute fee
     * @return int
     */
    public int getFee() {
        return this.fee;
    }

    
    /** 
     * Setter untuk attribute fee
     * @param fee
     */
    public void setFee(int fee) {
        this.fee = fee;
    }

    
    /** 
     * Getter untuk attribute name
     * @return String
     */
    public String getName() {
        return this.name;
    }

    
    /** 
     * Setter untuk attribute name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * Getter untuk attribute category
     * @return String
     */
    public String getCategory() {
        return this.category;
    }

    
    /** 
     * Setter untuk attribute category
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    
    /** 
     * Getter untuk object recruiter
     * @return Recruiter
     */
    public Recruiter getRecuiter() {
        return this.recuiter;
    }

    
    /** 
     * Setter untuk object recruiter
     * @param recuiter
     */
    public void setRecuiter(Recruiter recuiter) {
        this.recuiter = recuiter;
    }

    /**
     * Method untuk print data
     */
    public void printData (){
        System.out.println("Nama Pekerjaan : " + getName());
    }

}