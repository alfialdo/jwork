public class JWork
{
    public static void main(String[] args)
    {
        Location location1 = new Location("", "", "");
        Recruiter recruiter1 = new Recruiter(0, "", "", "", location1);
        Job job1 = new Job(0, 0, "", "", recruiter1);
        Jobseeker jobseeker1 = new Jobseeker(0, "", "", "", "");
        Invoice invoice1 = new Invoice(0, 0, 0, "", jobseeker1);

        location1.setProvince("Jakarta");
        recruiter1.setName("Aldo");
        job1.setFee(10000);
        jobseeker1.setName("Alfi");
        invoice1.setIdJob(20);

        location1.printData();
        recruiter1.printData    ();
        jobseeker1.printData();
    }
}