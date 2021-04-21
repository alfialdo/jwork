import java.util.Calendar;
import java.util.Date;

/*
    Main class yang digunakan untuk compile program bernama Jwork
*/
public class JWork
{
    public static void main(String[] args)
    {
        // Inisiasi object class
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Location location1 = new Location("DKI Jakarta", "Jakarta Pusat", "Rumah Sakit");
        Recruiter recruiter1 = new Recruiter(1, "Muhammad Alfi A", "lalay   eye@gmail.com", "08218832277", location1);
        Job job1 = new Job(2, 10000, "Shasa" ,JobCategory.DataScientist, recruiter1);
        // Invoice invoice1 = new Invoice(1, job1.getId(), job1.getFee(), "27/3/2021", jobseeker1, InvoiceStatus.Finished);
        // Bonus bonus1 = new Bonus(1, 10000, 3000, "#yukbisayuk", true);
        // Bonus bonus2 = new Bonus(1, 10000, 15000, "#yukbisayuk", true);
        Jobseeker jobseeker1 = new Jobseeker(1, "Alpha", ".yeyelala@-gmail.com", "122a234", calendar);
        // Jobseeker jobseeker2 = new Jobseeker(2, "Beta", "yeyelala@gmail.com", "12a2Z4", 2021, 11, 8);
        EwalletPayment ewallet1 = new EwalletPayment(1, job1, jobseeker1, InvoiceStatus.Finished);
        BankPayment bank1 = new BankPayment(2, job1, jobseeker1, InvoiceStatus.Cancelled, 5000);
        
        // Jobseeker jobseeker3 = new Jobseeker(3, "Charlie", "lalayeye@-gmail.com", "122Z34", calendar);
        
        // Statement program
        ewallet1.setTotalFee();
        bank1.setTotalFee();
        System.out.println(ewallet1);
        System.out.println(bank1);
    }
}