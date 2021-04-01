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
        return this.invoiceStatus.toString();
    }
}