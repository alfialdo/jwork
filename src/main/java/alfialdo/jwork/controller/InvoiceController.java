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

/**
 * Controller Invoice sebagai API penghubung antara aplikasi
 * dengan database Inoice PostgreSQL
 * @author Muhammad Alfi A
 * @version Final Project - 20 June 2021
 */
@RequestMapping("/invoice")
@RestController
public class InvoiceController {

    /**
     * Method yang digunakan untuk fetch seluruh database Invoice
     * @return ArrayList<Invoice>
     *
     */
    @RequestMapping("")
    public ArrayList<Invoice> getAllInvoice() {
        return DatabaseInvoicePostgre.getInvoiceDatabase();
    }

    /**
     * Method untuk fetch data Invoice berdasarkan id
     * @param id
     * @return
     */
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

    /**
     * Method untuk fetch data Invoice berdasarkan Jobseeker
     * @param jobseekerId
     * @return
     */
    @RequestMapping("/jobseeker/{jobseekerId}")
    public ArrayList<Invoice> getInvoiceByJobseeker(@PathVariable int jobseekerId) {
        return DatabaseInvoicePostgre.getInvoiceByJobseeker(jobseekerId);
    }

    /**
     * Method yang digunakan untuk merubah status dari Invoice
     * dari Ongoing menjadi Cancelled atau Finished
     * @param id
     * @param status
     * @return
     */
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

    /**
     * Method yang digunakan untuk menghapus Invoice dari
     * database berdasarkan id
     * @param id
     * @return
     */
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

    /**
     * Method yang digunakan untuk menambahkan Invoice ke database
     * dengan tipe pembayaran Bank Payment
     * @param jobIdList
     * @param jobseekerId
     * @param adminFee
     * @return
     */
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

    /**
     * Method yang digunakan untuk menambahkan Invoice ke database
     * dengan tipe pembayaran E-wallet Payment
     * @param jobIdList
     * @param jobseekerId
     * @param referralCode
     * @return
     */
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
