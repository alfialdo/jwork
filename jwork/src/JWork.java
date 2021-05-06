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

        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId()+1, "Muhammad Alfi A", "lalay   mantap@gmail.com", "08218832277", location1));

        try {
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Aplha", "mantap@gmail.com", "122a234", calendar));
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Beta", "mantap@gmail.com", "12aa24", calendar));
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Charlie", "djiwa@gmail.com", "12ab34", calendar));
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Ferlinda", "ferlinda@-gmail.com", "122Z34", calendar));
        } catch (EmailAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, 10000, "aaa" , JobCategory.DataScientist, DatabaseRecruiter.getRecruiterDatabase().get(0)));
        DatabaseJob.addJob(new Job(DatabaseJobseeker.getLastId()+1, 10000, "zzz" , JobCategory.DataScientist, DatabaseRecruiter.getRecruiterDatabase().get(0)));
        DatabaseJob.addJob(new Job(DatabaseJobseeker.getLastId()+1, 10000, "zzz" , JobCategory.FrontEnd, DatabaseRecruiter.getRecruiterDatabase().get(0)));

        try {
            DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId()+1, 10000, 3000, "#yukbisayuk", false));
            DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId()+1, 50000, 15000, "#yukbisayuk", true));
            DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId()+1, 10000, 3000, "#freeee", false));
            DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId()+1, 50000, 15000, "#huhuhu", true));
        } catch (ReferralCodeAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabaseJobseeker.getJobseekerById(50);
        } catch (JobSeekerNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabaseRecruiter.getRecruiterById(50);
        } catch (RecruiterNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabaseJob.getJobById(20);
        } catch (JobNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabaseBonus.getBonusById(100);
        } catch (BonusNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Statement program

        for(Bonus bonuses : DatabaseBonus.getBonusDatabase()) {
            System.out.println(bonuses.toString());
        }

        try {
            DatabaseInvoice.addInvoice(new EwalletPayment(DatabaseInvoice.getLastId()+1, DatabaseJob.getJobDatabase(), DatabaseJobseeker.getJobseekerById(1), InvoiceStatus.Finished, DatabaseBonus.getBonusById(1)));
            DatabaseInvoice.addInvoice(new EwalletPayment(DatabaseInvoice.getLastId()+1, DatabaseJob.getJobDatabase(), DatabaseJobseeker.getJobseekerById(1), InvoiceStatus.Cancelled, DatabaseBonus.getBonusById(1)));
            DatabaseInvoice.addInvoice(new EwalletPayment(DatabaseInvoice.getLastId()+1, DatabaseJob.getJobDatabase(), DatabaseJobseeker.getJobseekerById(1), InvoiceStatus.Finished, DatabaseBonus.getBonusById(1)));
        } catch (JobSeekerNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (BonusNotFoundException e) {
            System.out.println(e.getMessage());
        }

        for(Invoice invoices : DatabaseInvoice.getInvoiceDatabase()) {
            Thread thread = new Thread(new FeeCalculator(invoices));
            thread.start();
        }


//        DatabaseInvoice.getInvoiceByJobseeker(DatabaseJobseeker.getJobseekerById());

//        Invoice invoice1 = new Invoice(1, job1.getId(), job1.getFee(), "27/3/2021", jobseeker1, InvoiceStatus.Finished);
//        EwalletPayment ewallet1 = new EwalletPayment(1, job1, jobseeker1, InvoiceStatus.Finished);
//        BankPayment bank1 = new BankPayment(2, job1, jobseeker1, InvoiceStatus.Cancelled, 5000);
        

//




    }
}