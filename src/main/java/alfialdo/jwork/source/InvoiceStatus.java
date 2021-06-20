package alfialdo.jwork.source;
/**
 * Enu, untuk Status Invoice
 * @author Muhammad Alfi A
 * @version Final Project - 20 June 2021
 */
public enum InvoiceStatus {
    Ongoing("Ongoing"),
    Finished("Finished"),
    Cancelled("Cancelled");

    private final String invoiceStatus;

    InvoiceStatus (String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }
   
    @Override
    public String toString() {
        return this.invoiceStatus;
    }
}