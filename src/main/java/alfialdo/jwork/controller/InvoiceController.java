package alfialdo.jwork.controller;
import alfialdo.jwork.*;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/jobseeker/{jobseekerId}")
    public ArrayList<Invoice> getJobByRecruiter(@PathVariable int jobseekerId) {
        ArrayList<Invoice> invoices = null;
        invoices = DatabaseInvoice.getInvoiceByJobseeker(jobseekerId);
        return invoices;
    }

    @RequestMapping(value = "/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id,
                                       @RequestParam(value = "status") InvoiceStatus status){
        Invoice invoice = null;

        try {
            invoice = DatabaseInvoice.getInvoiceById(id);
            DatabaseInvoice.changeInvoiceStatus(id, status);
        } catch (InvoiceNotFoundException e) {
            System.out.println(e.getMessage());
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

    @RequestMapping(value = "/createBankPayment", method = RequestMethod.POST)
    public Invoice addBankPayment(@RequestParam(value = "jobIdList") ArrayList<Integer> jobIdList,
                                  @RequestParam(value = "jobseekerId") int jobseekerId,
                                  @RequestParam(value = "adminFee") int adminFee) {

        BankPayment bankPayment = null;
        ArrayList<Job> jobs = new ArrayList<>();
        Jobseeker jobseeker = null;

        for(Integer jobId : jobIdList) {
            try {
                jobs.add(DatabaseJob.getJobById(jobId));
            } catch (JobNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            jobseeker = DatabaseJobseeker.getJobseekerById(jobseekerId);
        } catch (JobseekerNotFoundException e) {
            System.out.println(e.getMessage());
        }

        if(adminFee <= 0) {
            bankPayment = new BankPayment(DatabaseInvoice.getLastId()+1, jobs, jobseeker);
        }
        else {
            bankPayment = new BankPayment(DatabaseInvoice.getLastId()+1, jobs, jobseeker, adminFee);
        }

        try {
            bankPayment.setTotalFee();
            DatabaseInvoice.addInvoice(bankPayment);
        } catch (OngoingInvoiceAlreadyExistsException e) {
            System.out.println(e.getMessage());
            bankPayment = null;
        }

        return bankPayment;
    }

    @RequestMapping(value = "/createEwalletPayment", method = RequestMethod.POST)
    public Invoice addEwalletPayment(@RequestParam(value = "jobIdList") ArrayList<Integer> jobIdList,
                                     @RequestParam(value = "jobseekerId") int jobseekerId,
                                     @RequestParam(value = "referralCode") String referralCode) {

        EwalletPayment ewalletPayment = null;
        ArrayList<Job> jobs = new ArrayList<>();
        Jobseeker jobseeker = null;

        for(Integer jobId : jobIdList) {
            try {
                jobs.add(DatabaseJob.getJobById(jobId));
            } catch (JobNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            jobseeker = DatabaseJobseeker.getJobseekerById(jobseekerId);
        } catch (JobseekerNotFoundException e) {
            System.out.println(e.getMessage());
        }

        if(referralCode.equals("")) {
            ewalletPayment = new EwalletPayment(DatabaseInvoice.getLastId()+1, jobs, jobseeker);
            System.out.println("Pass 1");
        }
        else {
            ewalletPayment = new EwalletPayment(DatabaseInvoice.getLastId()+1, jobs, jobseeker, DatabaseBonus.getBonusByReferralCode(referralCode));
            System.out.println("Pass 2");
        }

        try {
            ewalletPayment.setTotalFee();
            DatabaseInvoice.addInvoice(ewalletPayment);
        } catch (OngoingInvoiceAlreadyExistsException e) {
            System.out.println(e.getMessage());
            ewalletPayment = null;
        }

        return ewalletPayment;
    }
}
