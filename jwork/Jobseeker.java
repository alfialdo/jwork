
/**
 * Class untuk mencari job / pekerjaan
 * @author Muhammad Alfi A
 * @version Modul 2 - 18 March 2021
 */
public class Jobseeker
{
    private int id;
    private String name, email, password, joinDate;

    public Jobseeker(int id, String name, String email, String password, String joinDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
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
     * Getter untuk attribute email
     * @return String
     */
    public String getEmail() {
        return this.email;
    }

    
    /** 
     * Setter untuk attribute email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
    /** 
     * Getter untuk attribute password
     * @return String
     */
    public String getPassword() {
        return this.password;
    }

    
    /** 
     * Setter untuk attribute password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    
    /** 
     * Getter untuk attribute joinDate
     * @return String
     */
    public String getJoinDate() {
        return this.joinDate;
    }

    
    /** 
     * Setter untuk attribute joinDate
     * @param joinDate
     */
    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }
    
    /**
     * Method untuk print data
     */
    public void printData (){
        System.out.println("Nama : " + getName());
    }

}