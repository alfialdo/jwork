
/**
 * Class untuk recruiter / data perekrut pekerjaan
 * @author Muhammad ALfi A
 * @version Modul 2 - 18 March 2021
 */
public class Recruiter
{
    private int id;
    private String name, email, phoneNumber;
    private Location location;

    public Recruiter(int id, String name, String email, String phoneNumber, Location location) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
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
     * Getter untuk attribute email
     * @return String
     */
    public String getEmail() {
        return email;
    }

    
    /** 
     * Setter untuk attribute email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
    /** 
     * Getter untuk attribute phoneNumber
     * @return String
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    
    /** 
     * Setter untuk attribute phoneNumber
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
    /** 
     * Getter untuk attribute location
     * @return Location
     */
    public Location getLocation() {
        return location;
    }

    
    /** 
     * Setter untuk attribute location
     * @param location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Method untuk print data
     */
    public void printData (){
        System.out.println("====Recruiter====");
        System.out.println("ID : " + id);
        System.out.println("Name : " + name);
        System.out.println("Email : " + email);
        System.out.println("Phone : " + phoneNumber);
        System.out.println("City : " + location.getCity());
    }

}