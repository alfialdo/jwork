import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

/*
    Main class yang digunakan untuk compile program bernama Jwork
*/
public class JWork
{
    public static void main(String[] args)
    {
        // Inisiasi object class
        Calendar calendar = new GregorianCalendar();
        Location location1 = new Location("DKI Jakarta", "Jakarta Pusat", "Rumah Sakit");
        Recruiter recruiter1 = new Recruiter(1, "Muhammad Alfi A", "lalay   mantap@gmail.com", "08218832277", location1);
        DatabaseRecruiter.addRecruiter(recruiter1);

        Jobseeker jobseeker1 = new Jobseeker(1, "aldo", "aldo@gmail.com", "122a234", calendar);
        Jobseeker jobseeker2 = new Jobseeker(2, "aldo", "aldo@gmail.com", "12a2Z4", 2021, 11, 8);
        Jobseeker jobseeker3 = new Jobseeker(3, "ferlinda", "ferlinda@-gmail.com", "122Z34", calendar);

        DatabaseJobseeker.addJobseeker(jobseeker1);
        DatabaseJobseeker.addJobseeker(jobseeker2);
        DatabaseJobseeker.addJobseeker(jobseeker3);

        Job job1 = new Job(1, 10000, "aaa" , JobCategory.DataScientist, DatabaseRecruiter.getRecruiterDatabase().get(0));
        Job job2 = new Job(2, 10000, "zzz" , JobCategory.DataScientist, DatabaseRecruiter.getRecruiterDatabase().get(0));
        Job job3 = new Job(3, 10000, "zzz" , JobCategory.FrontEnd, DatabaseRecruiter.getRecruiterDatabase().get(0));

        DatabaseJob.addJob(job1);
        DatabaseJob.addJob(job2);
        DatabaseJob.addJob(job3);
//        Invoice invoice1 = new Invoice(1, job1.getId(), job1.getFee(), "27/3/2021", jobseeker1, InvoiceStatus.Finished);
//        Bonus bonus1 = new Bonus(1, 10000, 3000, "#yukbisayuk", true);
//        Bonus bonus2 = new Bonus(1, 10000, 15000, "#yukbisayuk", true);
//        EwalletPayment ewallet1 = new EwalletPayment(1, job1, jobseeker1, InvoiceStatus.Finished);
//        BankPayment bank1 = new BankPayment(2, job1, jobseeker1, InvoiceStatus.Cancelled, 5000);
        

//
//         Statement program

        for(Job jobs : DatabaseJob.getJobDatabase()) {
            if(jobs.getCategory() == JobCategory.DataScientist) {
                System.out.println(jobs.toString());
            }
        }

    }
}