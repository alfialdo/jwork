package alfialdo.jwork.controller;
import alfialdo.jwork.*;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.ArrayList;

@RequestMapping("/invoice")
@RestController
public class InvoiceController {

    @RequestMapping("")
    public ArrayList<Invoice> getAllInvoice() {
        return DatabaseInvoice.getInvoiceDatabase();
    }

    @RequestMapping("/{id}")
    public Invoice getJobById(@PathVariable int id) {
        Invoice invoice = null;

        try {
            invoice =  DatabaseInvoice.getInvoiceById(id);
        } catch (InvoiceNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return invoice;
    }

    @RequestMapping("/Jobseeker/{jobseekerId}")
    public ArrayList<Invoice> getJobByRecruiter(@PathVariable int jobseekerId) {
        ArrayList<Invoice> invoices = null;
        invoices = DatabaseInvoice.getInvoiceByJobseeker(jobseekerId);
        return invoices;
    }

    @RequestMapping(value = "invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id,
                                       @RequestParam(value = "status") InvoiceStatus status){
        Invoice invoice = null;

        try {
            DatabaseInvoice.changeInvoiceStatus(id, status);
            invoice = DatabaseInvoice.getInvoiceById(id);
        } catch (Exception e) {
            System.out.println("Something wrong!");
        }

        return invoice;

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean removeInvoice(@PathVariable int id){

        try {
            DatabaseInvoice.removeInvoice(id);
            return true;
        } catch (InvoiceNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

//    @RequestMapping(value = "createBankPayment", method = RequestMethod.POST)
//    public Invoice addBankPayment(@RequestParam(value = "jobIdList") ArrayList<int> jobIdList,
//                                  @RequestParam(value = "jobseekerId") int jobseekerId,
//                                  @RequestParam(value = "adminFee") int adminFee) {
//
////        Invoice invoice = null;
////        invoice
////        DatabaseInvoice.addInvoice();
//
//
//    }
}
