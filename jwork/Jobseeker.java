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

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJoinDate() {
        return this.joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }
    
    public void printData (){
        System.out.println("Nama : " + getName());
    }

}