package alfialdo.jwork.source;

/**
 * Class untuk data location
 * @author Muhammad Alfi A
 * @version Modul 4 - 30 March 2021
 */
public class Location {
    private String province, city, description;

    public Location(String province, String city, String description) {
        this.province = province;
        this.city = city;
        this.description = description;
    }

    
    /** 
     * Getter untuk attribute province
     * @return String
     */
    public String getProvince() {
        return province;
    }

    
    /** 
     * Setter untuk attribute province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    
    /** 
     * Getter untuk attribute city
     * @return String
     */
    public String getCity() {
        return city;
    }

    
    /** 
     * Setter untuk attribute city
     */
    public void setCity(String city) {
        this.city = city;
    }

    
    /** 
     * Getter untuk attribute desciption
     * @return String
     */
    public String getDescription() {
        return description;
    }

    
    /** 
     * Setter untuk attribute description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Method untuk print data
     */
    public void printData (){
        System.out.println("====Location====");
        System.out.println("Province : " + province);
        System.out.println("City : " + city);
        System.out.println("Description : " + description);
    }

    public String toString (){
        return "Province= " + province + 
        "\nCity= " + city + 
        "\nDescription " + description;
    }
}
