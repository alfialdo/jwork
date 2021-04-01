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
        Job job1 = new Job(2, 10000, "Shasa" ,JobCategory.DataScientist, recruiter1);
        Jobseeker jobseeker1 = new Jobseeker(1, "Charlie", "yeyelala@gmail.com", "1234", "20-3-2021");
        // Invoice invoice1 = new Invoice(1, job1.getId(), job1.getFee(), "27/3/2021", jobseeker1, InvoiceStatus.Finished);
        Bonus bonus1 = new Bonus(1, 10000, 3000, "#yukbisayuk", true);
        Bonus bonus2 = new Bonus(1, 10000, 15000, "#yukbisayuk", true);
        EwalletPayment ewallet1 = new EwalletPayment(1, job1, "20-4-2021", jobseeker1, InvoiceStatus.Finished);
        EwalletPayment ewallet2 = new EwalletPayment(2, job1, "20-4-2021", jobseeker1, InvoiceStatus.Cancelled, bonus1);
        EwalletPayment ewallet3 = new EwalletPayment(3, job1, "20-5-2021", jobseeker1, InvoiceStatus.Ongoing, bonus2);
        // Statement program        
        ewallet1.setTotalFee(10000);
        ewallet2.setTotalFee(10000);
        ewallet3.setTotalFee(10000);

        ewallet1.printData();
        ewallet2.printData();
        ewallet3.printData();
                      
    }
}