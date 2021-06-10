package alfialdo.jwork.database;

import alfialdo.jwork.exception.*;
import alfialdo.jwork.source.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

public class DatabaseInvoicePostgre {
    public static int lastId = 0;

    public static  ArrayList<Invoice> getInvoiceDatabase () {
        ArrayList<Invoice> invoices = new ArrayList<>();
        String query = "SELECT * FROM invoice";
        Connection conn = DatabaseConnectionPostgre.connection();

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(query);

            while(rs.next()) {
                ArrayList<Job> jobs = new ArrayList<>();
                Invoice invoice;
                Jobseeker jobseeker = DatabaseJobseekerPostgre.getJobseekerById(rs.getInt("jobseeker_id"));
                Array jobArray = rs.getArray("job_id");
                Integer[] jobIdList = (Integer[]) jobArray.getArray();

                for(int i : jobIdList) {
                    Job job = DatabaseJobPostgre.getJobById(i);
                    jobs.add(job);
                }

                if(rs.getString("type").equals("Bank Payment")) {
                    invoice = new BankPayment(
                            rs.getInt("id"),
                            jobs,
                            jobseeker,
                            0
                            );
                }
                else {
                    Bonus bonus = DatabaseBonusPostgre.getBonusById(rs.getInt("bonus_id"));
                    invoice = new EwalletPayment(
                            rs.getInt("id"),
                            jobs,
                            jobseeker,
                            bonus
                    );
                }

                invoices.add(invoice);
            }

        } catch (SQLException | JobseekerNotFoundException | BonusNotFoundException | JobNotFoundException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables.getMessage());
        }

        return invoices;
    }

    public static void addInvoice(Invoice invoice) throws OngoingInvoiceAlreadyExistsException {
        Connection conn = DatabaseConnectionPostgre.connection();
        ArrayList<Integer> jobIdList = new ArrayList<>();
        PreparedStatement p;
        String query;

        query = "SELECT * FROM invoice WHERE status = ?::invoice_status AND jobseeker_id = ?";

        try {
            p = conn.prepareStatement(query);
            p.setString(1, invoice.getInvoiceStatus().toString());
            p.setInt(2, invoice.getJobseeker().getId());
            ResultSet rs = p.executeQuery();

            if(rs.next()) {
                throw new OngoingInvoiceAlreadyExistsException(invoice);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String payment;

        if(invoice instanceof BankPayment) {
            payment = "admin_fee";
        }
        else {
            payment = "bonus_id";
        }

        query = String.format("INSERT INTO invoice(id, total_fee, date, jobseeker_id, job_id, status, type, %s)" +
                "VALUES(?, ?, ?, ?, ?, ?::invoice_status, ?::payment_type, ?)", payment);

        try {
            p = conn.prepareStatement(query);
            for(Job job : invoice.getJobs()) {
                jobIdList.add(job.getId());
            }
            Array jobArray = conn.createArrayOf("INT", jobIdList.toArray());
            p.setInt(1, invoice.getId());
            p.setInt(2, invoice.getTotalFee());
            p.setDate(3, new java.sql.Date(invoice.getDate().getTimeInMillis()));
            p.setInt(4, invoice.getJobseeker().getId());
            p.setArray(5, jobArray);
            p.setString(6, invoice.getInvoiceStatus().toString());
            p.setString(7, invoice.getPaymentType().toString());
            if(invoice instanceof BankPayment) {
                p.setInt(8, 0);
            } else {
                p.setInt(8, ((EwalletPayment) invoice).getBonus().getId());
            }
            p.executeUpdate();
            p.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        lastId = invoice.getId();
    }

    public static int getLastId() {
        String query = "SELECT id FROM invoice ORDER BY id DESC LIMIT 1";
        Connection conn = DatabaseConnectionPostgre.connection();

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(query);
            if(rs.next()) {
                lastId = rs.getInt("id");
            }
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return lastId;
    }

    public static Invoice getInvoiceById(int id) throws InvoiceNotFoundException {
        Invoice invoice = null;
        String query = "SELECT * FROM invoice WHERE id = " + id;
        Connection conn = DatabaseConnectionPostgre.connection();

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(query);
            conn.close();

            if(rs.next()) {
                ArrayList<Job> jobs = new ArrayList<>();
                Jobseeker jobseeker = DatabaseJobseekerPostgre.getJobseekerById(rs.getInt("jobseeker_id"));
                Array jobArray = rs.getArray("job_id");
                Integer[] jobIdList = (Integer[]) jobArray.getArray();

                for(Integer i : jobIdList) {
                    Job job = DatabaseJobPostgre.getJobById(i);
                    jobs.add(job);
                }

                if(rs.getString("type").equals("Bank Payment")) {
                     invoice = new BankPayment(
                            rs.getInt("id"),
                            jobs,
                            jobseeker,
                            0
                    );

                }
                else {
                    Bonus bonus = DatabaseBonusPostgre.getBonusById(rs.getInt("bonus_id"));
                    invoice = new EwalletPayment(
                            rs.getInt("id"),
                            jobs,
                            jobseeker,
                            bonus
                    );
                }
            }
            else {
                throw new InvoiceNotFoundException(id);
            }
        } catch (SQLException | JobseekerNotFoundException | JobNotFoundException | BonusNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return invoice;
    }

    public static  ArrayList<Invoice> getInvoiceByJobseeker (int jobseekerId) {
        ArrayList<Invoice> invoices = new ArrayList<>();
        String query = "SELECT * FROM invoice WHERE jobseeker_id = " + jobseekerId;
        Connection conn = DatabaseConnectionPostgre.connection();

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(query);

            while(rs.next()) {
                ArrayList<Job> jobs = new ArrayList<>();
                Invoice invoice;
                Jobseeker jobseeker = DatabaseJobseekerPostgre.getJobseekerById(rs.getInt("jobseeker_id"));
                Array jobArray = rs.getArray("job_id");
                Integer[] jobIdList = (Integer[]) jobArray.getArray();

                for(Integer i : jobIdList) {
                    Job job = DatabaseJobPostgre.getJobById(i);
                    jobs.add(job);
                }

                if(rs.getString("type").equals("Bank Payment")) {
                    invoice = new BankPayment(
                            rs.getInt("id"),
                            jobs,
                            jobseeker,
                            0
                    );
                }
                else {
                    Bonus bonus = DatabaseBonusPostgre.getBonusById(rs.getInt("bonus_id"));
                    invoice = new EwalletPayment(
                            rs.getInt("id"),
                            jobs,
                            jobseeker,
                            bonus
                    );
                }

                invoices.add(invoice);
            }

        } catch (SQLException | JobseekerNotFoundException | BonusNotFoundException | JobNotFoundException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables.getMessage());
        }

        return invoices;
    }

    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus) {
        Connection conn = DatabaseConnectionPostgre.connection();
        String query = "UPDATE invoice SET status = ?::invoice_status WHERE id = ? AND status = 'Ongoing'";
        int row = 0;
        try {
            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, invoiceStatus.toString());
            p.setInt(2, id);
            row = p.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return row != 0;

    }

    public static boolean removeInvoice(int id) throws InvoiceNotFoundException {
        int row = 0;
        String query = "DELETE FROM invoice where id = " + id;
        Connection conn = DatabaseConnectionPostgre.connection();

        try {
            Statement s = conn.createStatement();
            row = s.executeUpdate(query);
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if(row == 0) {
            throw new InvoiceNotFoundException(id);
        }
        else {
            return true;
        }

    }


}
