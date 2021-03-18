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

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFee() {
        return this.fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Recruiter getRecuiter() {
        return this.recuiter;
    }

    public void setRecuiter(Recruiter recuiter) {
        this.recuiter = recuiter;
    }
    
    public void printData (){

    }

}