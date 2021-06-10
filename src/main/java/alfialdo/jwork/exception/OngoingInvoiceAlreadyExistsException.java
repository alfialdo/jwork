package alfialdo.jwork.exception;

import alfialdo.jwork.source.Invoice;

public class OngoingInvoiceAlreadyExistsException extends Exception {
    private Invoice invoice_error;

    public OngoingInvoiceAlreadyExistsException(Invoice invoice_input) {
        super("Jobseeker ID: ");
        this.invoice_error = invoice_input;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + invoice_error.getJobseeker().getId() + " is still ongoing";
    }
}
