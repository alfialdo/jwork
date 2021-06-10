package alfialdo.jwork.controller;
import alfialdo.jwork.database.DatabaseBonusPostgre;
import alfialdo.jwork.database.DatabaseInvoicePostgre;
import alfialdo.jwork.database.DatabaseJobPostgre;
import alfialdo.jwork.database.DatabaseJobseekerPostgre;
import alfialdo.jwork.exception.InvoiceNotFoundException;
import alfialdo.jwork.exception.JobNotFoundException;
import alfialdo.jwork.exception.JobseekerNotFoundException;
import alfialdo.jwork.exception.OngoingInvoiceAlreadyExistsException;
import alfialdo.jwork.source.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/invoice")
@RestController
public class InvoiceController {

    @RequestMapping("")
    public ArrayList<Invoice> getAllInvoice() {
        return DatabaseInvoicePostgre.getInvoiceDatabase();
    }

    @RequestMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable int id) {
        Invoice invoice = null;

        try {
            invoice =  DatabaseInvoicePostgre.getInvoiceById(id);
        } catch (InvoiceNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return invoice;
    }

    @RequestMapping("/jobseeker/{jobseekerId}")
    public ArrayList<Invoice> getInvoiceByJobseeker(@PathVariable int jobseekerId) {
        return DatabaseInvoicePostgre.getInvoiceByJobseeker(jobseekerId);
    }

    @RequestMapping(value = "/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id,
                                       @RequestParam(value = "status") InvoiceStatus status){
        Invoice invoice = null;

        try {
            invoice = DatabaseInvoicePostgre.getInvoiceById(id);
            DatabaseInvoicePostgre.changeInvoiceStatus(id, status);
        } catch (InvoiceNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return invoice;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean removeInvoice(@PathVariable int id){

        try {
            DatabaseInvoicePostgre.removeInvoice(id);
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

        BankPayment bankPayment;
        ArrayList<Job> jobs = new ArrayList<>();
        Jobseeker jobseeker = null;

        for(Integer jobId : jobIdList) {
            try {
                jobs.add(DatabaseJobPostgre.getJobById(jobId));
            } catch (JobNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            jobseeker = DatabaseJobseekerPostgre.getJobseekerById(jobseekerId);
        } catch (JobseekerNotFoundException e) {
            System.out.println(e.getMessage());
        }

        if(adminFee <= 0) {
            bankPayment = new BankPayment(DatabaseInvoicePostgre.getLastId()+1, jobs, jobseeker);
        }
        else {
            bankPayment = new BankPayment(DatabaseInvoicePostgre.getLastId()+1, jobs, jobseeker, adminFee);
        }

        try {
            bankPayment.setTotalFee();
            DatabaseInvoicePostgre.addInvoice(bankPayment);
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
                jobs.add(DatabaseJobPostgre.getJobById(jobId));
            } catch (JobNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            jobseeker = DatabaseJobseekerPostgre.getJobseekerById(jobseekerId);
        } catch (JobseekerNotFoundException e) {
            System.out.println(e.getMessage());
        }

        if(referralCode.equals("")) {
            ewalletPayment = new EwalletPayment(DatabaseInvoicePostgre.getLastId()+1, jobs, jobseeker);
            System.out.println("Pass 1");
        }
        else {
            ewalletPayment = new EwalletPayment(DatabaseInvoicePostgre.getLastId()+1, jobs, jobseeker, DatabaseBonusPostgre.getBonusByReferralCode(referralCode));
            System.out.println("Pass 2");
        }

        try {
            ewalletPayment.setTotalFee();
            DatabaseInvoicePostgre.addInvoice(ewalletPayment);
        } catch (OngoingInvoiceAlreadyExistsException e) {
            System.out.println(e.getMessage());
            ewalletPayment = null;
        }

        return ewalletPayment;
    }
}
