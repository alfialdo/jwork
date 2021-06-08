package alfialdo.jwork;

public class FeeCalculator implements Runnable {
    Invoice invoice;

    public FeeCalculator (Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public void run() {
        System.out.println("Calculating Invoice ID : " + invoice.getId());
        invoice.setTotalFee();
        System.out.println("Finished calculating invoice ID : " + invoice.getId());
    }
}
