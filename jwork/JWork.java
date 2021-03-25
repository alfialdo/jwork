/*
    Main class yang digunakan untuk compile program bernama Jwork
*/
public class JWork
{
    public static void main(String[] args)
    {
        // Inisiasi object class
        Location location1 = new Location("DKI Jakarta", "Jakarta Pusat", "Rumah Sakit");
        Recruiter recruiter1 = new Recruiter(1, "Muhammad Alfi A", "lalayeye@gmail.com", "08218832277", location1);
        Job job1 = new Job(1, 10000, "AI" ,JobCategory.DataScientist, recruiter1);
        Jobseeker jobseeker1 = new Jobseeker(1, "Charlie", "yeyelala@gmail.com", "1234", "20-3-2021");
        Invoice invoice1 = new Invoice(1, 1, 20000, "20-3-2021", jobseeker1);


        // Statement program        
        job1.printData();
                      
    }
}