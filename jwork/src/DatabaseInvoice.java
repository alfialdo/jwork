import java.util.ArrayList;

public class DatabaseInvoice {
    public static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<>();
    public static int lastId = 0;

    public static ArrayList<Invoice> getInvoiceDatabase(){
        return INVOICE_DATABASE;
    }

    public static int getLastId() {
        return lastId;
    }

    public static Invoice getInvoiceById(int id) throws InvoiceNotFoundException{
        int i=0;
        while(i < INVOICE_DATABASE.size()) {
            if (INVOICE_DATABASE.get(i).getId() == id) {
                return INVOICE_DATABASE.get(i);
            }
            i++;
        }
        throw new InvoiceNotFoundException(id);
    }

    public static ArrayList<Invoice> getInvoiceByJobseeker(int jobseekerId) {
        int i=0;
        ArrayList<Invoice> tempJob = new ArrayList<>();
        while(i < INVOICE_DATABASE.size()) {
            if (INVOICE_DATABASE.get(i).getJobseeker().getId() == jobseekerId) {
                tempJob.add(INVOICE_DATABASE.get(i));
                return tempJob;
            }
            i++;
        }
        return null;
    }

    public static boolean addInvoice(Invoice invoice) throws OngoingInvoiceAlreadyExistsException {
        for(Invoice invoices : INVOICE_DATABASE) {
            if (invoice.getInvoiceStatus() != InvoiceStatus.Ongoing && invoice.getJobseeker().getId() != invoices.getJobseeker().getId()) {
                INVOICE_DATABASE.add(invoice);
                lastId = invoice.getId();
                return true;
            }
            else {
                throw new OngoingInvoiceAlreadyExistsException(invoice);
            }
        }


    }

    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus) {
        int i=0;
        while(i < INVOICE_DATABASE.size()) {
            if (INVOICE_DATABASE.get(i).getId() == id && INVOICE_DATABASE.get(i).getInvoiceStatus() == InvoiceStatus.Ongoing) {
                INVOICE_DATABASE.get(i).setInvoiceStatus(invoiceStatus);
                return true;
            }
            i++;
        }
        return false;
    }

    public static boolean removeInvoice(int id) throws InvoiceNotFoundException {
        int i=0;
        while(i < INVOICE_DATABASE.size()) {
            if (INVOICE_DATABASE.get(i).getId() == id) {
                INVOICE_DATABASE.remove(i);
                return true;
            }
            i++;
        }
        throw new InvoiceNotFoundException(id);
    }
}
