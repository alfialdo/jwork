package alfialdo.jwork.database;

import alfialdo.jwork.exception.JobNotFoundException;
import alfialdo.jwork.exception.RecruiterNotFoundException;
import alfialdo.jwork.source.Job;
import alfialdo.jwork.source.JobCategory;
import alfialdo.jwork.source.Recruiter;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseJobPostgre {
    public static int lastId = 0;

    public static  ArrayList<Job> getJobDatabase () {
        ArrayList<Job> jobs = new ArrayList<>();
        String query = "SELECT * FROM job";
        Connection conn = DatabaseConnectionPostgre.connection();

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(query);

            while(rs.next()) {
                Recruiter recruiter = DatabaseRecruiterPostgre.getRecruiterById(rs.getInt("recruiter_id"));
                JobCategory category = JobCategory.valueOf(rs.getString("category").replaceAll("\\s+", ""));
                Job job = new Job(rs.getInt("id"), rs.getInt("fee"),
                        rs.getString("name"), category,
                        recruiter);
                jobs.add(job);
            }
        } catch (SQLException | RecruiterNotFoundException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables.getMessage());
        }

        return jobs;
    }

    public static void addJob(Job job) {
        Connection conn = DatabaseConnectionPostgre.connection();
        PreparedStatement p;
        String query = "INSERT INTO job VALUES(?, ?, ?, ?, ?::job_category)";

        try {
            p = conn.prepareStatement(query);
            p.setInt(1, job.getId());
            p.setInt(2, job.getFee());
            p.setString(3, job.getName());
            p.setInt(4, job.getRecruiter().getId());
            p.setString(5, job.getCategory().toString());
            p.executeUpdate();
            p.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        lastId = job.getId();
    }

    public static int getLastId() {
        String query = "SELECT id FROM job ORDER BY id DESC LIMIT 1";
        Connection conn = DatabaseConnectionPostgre.connection();

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(query);
            if(rs.next())
                lastId = rs.getInt("id");
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return lastId;
    }

    public static Job getJobById(int id) throws JobNotFoundException {
        Job job = null;
        String query = "SELECT * FROM job WHERE id = " + id;
        Connection conn = DatabaseConnectionPostgre.connection();

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(query);
            conn.close();

            if(rs.next()) {
                Recruiter recruiter = DatabaseRecruiterPostgre.getRecruiterById(rs.getInt("recruiter_id"));
                JobCategory category = JobCategory.valueOf(rs.getString("category").replaceAll("\\s+", ""));
                job = new Job(rs.getInt("id"), rs.getInt("fee"),
                        rs.getString("name"), category,
                        recruiter);
            }

        } catch (SQLException | RecruiterNotFoundException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables.getMessage());
            throw new JobNotFoundException(id);
        }

        return job;
    }

    public static ArrayList<Job> getJobByRecruiter(int recruiterId) {
        ArrayList<Job> jobs = new ArrayList<>();
        String query = "SELECT * FROM job WHERE recruiter_id = " + recruiterId;
        Connection conn = DatabaseConnectionPostgre.connection();

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(query);

            while(rs.next()) {
                Recruiter recruiter = DatabaseRecruiterPostgre.getRecruiterById(rs.getInt("recruiter_id"));
                JobCategory category = JobCategory.valueOf(rs.getString("category").replaceAll("\\s+", ""));
                Job job = new Job(rs.getInt("id"), rs.getInt("fee"),
                        rs.getString("name"), category,
                        recruiter);
                jobs.add(job);
            }

            conn.close();
        } catch (SQLException | RecruiterNotFoundException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables.getMessage());
        }

        return jobs;
    }

    public static ArrayList<Job> getJobByCategory(JobCategory jobCategory) {
        ArrayList<Job> jobs = new ArrayList<>();
        String query = "SELECT * FROM job WHERE category = ?::job_category";
        Connection conn = DatabaseConnectionPostgre.connection();

        try {
            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, jobCategory.toString());
            ResultSet rs = p.executeQuery();

            while(rs.next()) {
                Recruiter recruiter = DatabaseRecruiterPostgre.getRecruiterById(rs.getInt("recruiter_id"));
                JobCategory category = JobCategory.valueOf(rs.getString("category").replaceAll("\\s+", ""));
                Job job = new Job(rs.getInt("id"), rs.getInt("fee"),
                        rs.getString("name"), category,
                        recruiter);
                jobs.add(job);
            }

            conn.close();
        } catch (SQLException | RecruiterNotFoundException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables.getMessage());
        }

        return jobs;
    }

    public static boolean removeJob(int id) throws JobNotFoundException {
        int row = 0;
        String query = "DELETE FROM job where id = " + id;
        Connection conn = DatabaseConnectionPostgre.connection();

        try {
            Statement s = conn.createStatement();
            row = s.executeUpdate(query);
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if(row == 0) {
            throw new JobNotFoundException(id);
        }
        else {
            return true;
        }

    }

}
