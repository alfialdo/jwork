/**
 * Enu, untuk Status Invoice
 * @author Muhammad Alfi A
 * @version Modul 4 - 30 March 2021
 */
public enum InvoiceStatus {
    Ongoing("Ongoing"),
    Finished("Finished"),
    Cancelled("Cancelled");

    private String invoiceStatus;

    InvoiceStatus (String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }
   
    @Override
    public String toString() {
        return this.invoiceStatus;
    }
}