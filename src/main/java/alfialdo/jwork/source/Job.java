package alfialdo.jwork.source;

import java.io.Serializable;

/**
 * Class untuk deskripsi job / pekerjaan
 * @author Muhammad Alfi A
 * @version Modul 4 - 30 March 2021
 */
public class Job implements Serializable
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
     */
    public void setCategory(JobCategory category) {
        this.category = category;
    }

    
    /** 
     * Getter untuk object recruiter
     * @return Recruiter
     */
    public Recruiter getRecruiter() {
        return recruiter;
    }

    
    /** 
     * Setter untuk object recruiter
     */
    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    /**
     * Method untuk print data
     */
    public String toString (){
        return "Id= " + id + 
        "\nName= " + name + 
        "\nRecruiter= " + recruiter.getName() + 
        "\nCity= " + recruiter.getLocation().getCity() + 
        "\nFee= " + fee + 
        "\nCategory= " + category;
    }

}