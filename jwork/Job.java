
/**
 * Class untuk deskripsi job / pekerjaan
 * @author Muhammad Alfi A
 * @version Modul 2 - 18 March 2021
 */
public class Job
{
    private int id, fee;
    private String name;
    private Recruiter recruiter;
    private JobCategory category;

    public Job(int id, int fee, String name, JobCategory category, Recruiter recruiter) {
        this.id = id;
        this.fee = fee;
        this.name = name;
        this.category = category;
        this.recruiter = recruiter;
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
     * Getter untuk attribute fee
     * @return int
     */
    public int getFee() {
        return fee;
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
        return name;
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
    public JobCategory getCategory() {
        return category;
    }

    
    /** 
     * Setter untuk attribute category
     * @param category
     */
    public void setCategory(JobCategory category) {
        this.category = category;
    }

    
    /** 
     * Getter untuk object recruiter
     * @return Recruiter
     */
    public Recruiter getRecuiter() {
        return recruiter;
    }

    
    /** 
     * Setter untuk object recruiter
     * @param recuiter
     */
    public void setRecuiter(Recruiter recuiter) {
        this.recruiter = recuiter;
    }

    /**
     * Method untuk print data
     */
    public void printData (){
        System.out.println("====Job====");
        System.out.println("ID : " + id);
        System.out.println("Name : " + name);
        System.out.println("Recruiter : " + recruiter.getName());
        System.out.println("City : " + recruiter.getLocation().getCity());
        System.out.println("Fee : " + fee);
        System.out.println("Category : " + category);
    }

}