import java.util.*;

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

        DatabaseRecruiter.addRecruiter(new Recruiter(1, "Muhammad Alfi A", "lalay   mantap@gmail.com", "08218832277", location1));


        DatabaseJobseeker.addJobseeker(new Jobseeker(1, "aldo", "aldo@gmail.com", "122a234", calendar));
        DatabaseJobseeker.addJobseeker(new Jobseeker(2, "aldo", "aldo@gmail.com", "12a2Z4", 2021, 11, 8));
        DatabaseJobseeker.addJobseeker(new Jobseeker(3, "ferlinda", "ferlinda@-gmail.com", "122Z34", calendar));

        DatabaseJob.addJob(new Job(1, 10000, "aaa" , JobCategory.DataScientist, DatabaseRecruiter.getRecruiterDatabase().get(0)));
        DatabaseJob.addJob(new Job(2, 10000, "zzz" , JobCategory.DataScientist, DatabaseRecruiter.getRecruiterDatabase().get(0)));
        DatabaseJob.addJob(new Job(3, 10000, "zzz" , JobCategory.FrontEnd, DatabaseRecruiter.getRecruiterDatabase().get(0)));

        DatabaseBonus.addBonus(new Bonus(1, 10000, 3000, "#yukbisayuk", false));
        DatabaseBonus.addBonus(new Bonus(2, 50000, 15000, "#yukbisayuk", true));

        for(Bonus bonuses: DatabaseBonus.getBonusDatabase()) {
            System.out.println(bonuses.toString());
        }

        ArrayList<Job> jobs1 = new ArrayList<>();
        ArrayList<Job> jobs2 = new ArrayList<>();

        DatabaseInvoice.addInvoice(new BankPayment(2, asad, jobseeker1, InvoiceStatus.Cancelled, 5000));


//        Invoice invoice1 = new Invoice(1, job1.getId(), job1.getFee(), "27/3/2021", jobseeker1, InvoiceStatus.Finished);
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