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


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdJob() {
        return this.idJob;
    }

    public void setIdJob(int idJob) {
        this.idJob = idJob;
    }

    public int getTotalFee() {
        return this.totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Jobseeker getJobseeker() {
        return this.jobseeker;
    }

    public void setJobseeker(Jobseeker jobseeker) {
        this.jobseeker = jobseeker;
    }

    public void printData(){
        
    }
}