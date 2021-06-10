package alfialdo.jwork.deprecated;
import alfialdo.jwork.source.Invoice;
import alfialdo.jwork.source.InvoiceStatus;
import alfialdo.jwork.exception.InvoiceNotFoundException;
import alfialdo.jwork.exception.OngoingInvoiceAlreadyExistsException;

import java.util.ArrayList;


@Deprecated
public class DatabaseInvoice {
    public static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<>();
    public static int lastId = 0;

    public static ArrayList<Invoice> getInvoiceDatabase(){
        return INVOICE_DATABASE;
    }

    public static int getLastId() {
        return lastId;
    }

    public static Invoice getInvoiceById(int id) throws InvoiceNotFoundException {
        for(Invoice invoices : INVOICE_DATABASE) {
            if (invoices.getId() == id) {
                return invoices;
            }
        }
        throw new InvoiceNotFoundException(id);
    }

    public static ArrayList<Invoice> getInvoiceByJobseeker(int jobseekerId) {
        ArrayList<Invoice> tempJob = new ArrayList<>();
        for(Invoice invoices : INVOICE_DATABASE) {
            if (invoices.getJobseeker().getId() == jobseekerId) {
                tempJob.add(invoices);
            }
        }
        return tempJob;
    }

    public static Boolean addInvoice(Invoice invoice) throws OngoingInvoiceAlreadyExistsException {

        for(Invoice invoices : INVOICE_DATABASE) {
            if (invoices.getInvoiceStatus() == InvoiceStatus.Ongoing && invoices.getJobseeker().getId() == invoice.getJobseeker().getId()) {
                throw new OngoingInvoiceAlreadyExistsException(invoice);
            }
        }

        INVOICE_DATABASE.add(invoice);
        lastId = invoice.getId();
        return true;

    }

    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus) {

        for(Invoice invoices : DatabaseInvoice.getInvoiceDatabase()) {
            if (invoices.getId() == id && invoices.getInvoiceStatus() == InvoiceStatus.Ongoing) {
                invoices.setInvoiceStatus(invoiceStatus);
                return true;
            }
        }
        return false;
    }

    public static boolean removeInvoice(int id) throws InvoiceNotFoundException {
        for(Invoice invoices : INVOICE_DATABASE) {
            if (invoices.getId() == id) {
                INVOICE_DATABASE.remove(id);
                return true;
            }
        }
        throw new InvoiceNotFoundException(id);
    }
}
