public class Location {
    private String province, city, description;

    public Location(String province, String city, String description) {
        this.province = province;
        this.city = city;
        this.description = description;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void printData (){
        System.out.println("Provinsi : " + getProvince());
    }
}
