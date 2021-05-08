public class OngoingInvoiceAlreadyExistsException extends Exception {
    private Invoice invoice_error;

    public OngoingInvoiceAlreadyExistsException(Invoice invoice_input) {
        super("Referral ID: ");
        this.invoice_error = invoice_input;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + invoice_error.getJobseeker().getId() + " is still ongoing";
    }
}
