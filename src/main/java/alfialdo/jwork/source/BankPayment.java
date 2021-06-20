package alfialdo.jwork.source;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Class untuk metode pemabayaran Bank Payment yang merupakan
 * child dari class Invoice
 * @author Muhammad Alfi A
 * @version Final Project - 20 June 2021
 */
public class BankPayment extends Invoice{
    private final static PaymentType PAYMENT_TYPE = PaymentType.BankPayment;
    private int adminFee = 0;

    public BankPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker) {
        super(id, jobs, jobseeker);
    }

    public BankPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker, int adminFee) {
        super(id, jobs, jobseeker);
        this.adminFee = adminFee;
    }

    /**
     * Method getter untuk payment type
     * @return tipe pemabayaran
     */
    @Override
    public PaymentType getPaymentType() {
        return PAYMENT_TYPE;
    }

    /**
     * Method getter untuk admin fee
     * @return admin fee
     */
    public int getAdminFee() {
        return adminFee;
    }

    /**
     * Method setter untuk admin fee
     * @param adminFee
     */
    public void setAdminFee(int adminFee) {
        this.adminFee = adminFee;
    }

    /**
     * Method setter untuk total fee
     */
    @Override
    public void setTotalFee() {
        for(Job jobs : super.getJobs())
        if(adminFee != 0) {
            super.totalFee = jobs.getFee() - adminFee;
        }
        else {
            super.totalFee = jobs.getFee();
        }
    }

    /**
     * Method untuk mengubah informasi object Bank Payment
     * menjadi String
     * @return
     */
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat ("dd MMMM yyyy");
        StringBuilder allJobs = null;
        dateFormat.setTimeZone(getDate().getTimeZone());
        for (Job jobs : super.getJobs()) {
            allJobs.append(jobs.getName());
        }

        return "Id= " + getId() + 
        "\nJob= " + allJobs +
        "\nDate= " + dateFormat.format(getDate().getTime()) + 
        "\nJob Seeker= " + getJobseeker().getName() + 
        "\nAdmin Fee= " + adminFee + 
        "\nTotal Fee= " + super.totalFee + 
        "\nStatus= " + getInvoiceStatus()+ 
        "\nPayment Type= " + PAYMENT_TYPE;
    }
}
