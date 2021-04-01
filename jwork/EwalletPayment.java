public class EwalletPayment extends Invoice {
    private static PaymentType PAYMENT_TYPE;
    private Bonus bonus;

    public EwalletPayment(int id, Job job, String date, Jobseeker jobseeker, InvoiceStatus invoiceStatus) {
        super(id, job, 0, date, jobseeker, invoiceStatus);
    }

    public EwalletPayment(int id, Job job, String date, Jobseeker jobseeker, InvoiceStatus invoiceStatus, Bonus bonus) {
        super(id, job, 0, date, jobseeker, invoiceStatus);
        this.bonus = bonus;
    }

    public PaymentType getPaymentType() {
        return PAYMENT_TYPE;
    }

    public Bonus getBonus() {
        return bonus;
    }

    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }

    public void setTotalFee(int totalFee) {
        if(bonus != null && bonus.getActive() == true && super.getTotalFee() > bonus.getMinTotalFee()) {
            super.totalFee = totalFee + bonus.getExtraFee();
        }
        else {
            super.totalFee = super.getJob().getFee();
        }
    }

    public void printData() {
        if(bonus != null && bonus.getActive() == true && super.getTotalFee() > bonus.getMinTotalFee()) {
            System.out.println("==========INVOICE==========");
            System.out.println("ID : " + super.getId());
            System.out.println("Job : " + super.getJob().getCategory());
            System.out.println("Date : " + super.getDate());
            System.out.println("Job Seeker : " + super.getJobseeker().getName());
            System.out.println("Total Fee : " + super.totalFee);
            System.out.println("Status : " + super.getInvoiceStatus());
            System.out.println("Payment Type : " + PAYMENT_TYPE);
        }
    }
}
