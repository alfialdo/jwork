package alfialdo.jwork.database;

import alfialdo.jwork.exception.EmailAlreadyExistsException;
import alfialdo.jwork.exception.JobseekerNotFoundException;
import alfialdo.jwork.source.Hash;
import alfialdo.jwork.source.Jobseeker;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Class untuk melakukan metode CRUD pada database
 * Jobseeker PostgreSQL
 * @author Muhammad Alfi A
 * @version Final Project
 */
public class DatabaseJobseekerPostgre {
    public static int lastId = 0;

    /**
     * Method melakukan query seluruh isi Database Jobseeker
     * @return Databae Jobseeker
     */
    public static  ArrayList<Jobseeker> getJobseekerDatabase () {
        ArrayList<Jobseeker> jobseekers = new ArrayList<>();
        String query = "SELECT * FROM jobseeker";
        Connection conn = DatabaseConnectionPostgre.connection();

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(query);

            while(rs.next()) {
                Jobseeker jobseeker = new Jobseeker(rs.getInt("id"), rs.getString("name"),
                        rs.getString("email"), rs.getString("password"), rs.getInt("year"),
                        rs.getInt("month"), rs.getInt("day"));
                jobseekers.add(jobseeker);
            }

            rs.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return jobseekers;
    }

    /**
     * Method yang digunakan untuk INSERT data baru ke
     * Database Jobseeker
     * @param jobseeker
     * @throws EmailAlreadyExistsException
     */
    public static void addJobseeker(Jobseeker jobseeker) throws EmailAlreadyExistsException {
        Connection conn = DatabaseConnectionPostgre.connection();
        PreparedStatement p;
        String query;

        query = "SELECT * FROM jobseeker WHERE email = ?";

        try {
            p = conn.prepareStatement(query);
            p.setString(1, jobseeker.getEmail());
            ResultSet rs = p.executeQuery();
            if(rs.next()) {
                rs.close();
                throw new EmailAlreadyExistsException(jobseeker.getEmail());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        query = "INSERT INTO jobseeker VALUES(?, ?, ?, ?, ?, ?, ?)";

        try {
            p = conn.prepareStatement(query);
            p.setInt(1, jobseeker.getId());
            p.setString(2, jobseeker.getName());
            p.setString(3, jobseeker.getEmail());
            p.setString(4, jobseeker.getPassword());
            p.setInt(5, jobseeker.getJoinDate().get(Calendar.DAY_OF_MONTH));
            p.setInt(6, jobseeker.getJoinDate().get(Calendar.MONTH));
            p.setInt(7, jobseeker.getJoinDate().get(Calendar.YEAR));
            p.executeUpdate();
            p.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        lastId = jobseeker.getId();
    }

    /**
     * Method yang digunakan untuk mendapatkan id terakhir pada database
     * @return Id terakhir yang ada pada database
     */
    public static int getLastId() {
        String query = "SELECT id FROM jobseeker ORDER BY id DESC LIMIT 1";
        Connection conn = DatabaseConnectionPostgre.connection();

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(query);
            if(rs.next()) {
                lastId = rs.getInt("id");
            }
            rs.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return lastId;
    }

    /**
     * Method yang digunakan untuk query data Jobseeker
     * berdasarkan id pada PostgreSQL
     * @param id
     * @return
     * @throws JobseekerNotFoundException
     */
    public static Jobseeker getJobseekerById(int id) throws JobseekerNotFoundException {
        Jobseeker jobseeker = null;
        String query = "SELECT * FROM jobseeker WHERE id = " + id;
        Connection conn = DatabaseConnectionPostgre.connection();

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(query);

            if(rs.next()) {
                jobseeker = new Jobseeker(rs.getInt("id"), rs.getString("name"),
                        rs.getString("email"), rs.getString("password"), rs.getInt("year"),
                        rs.getInt("month"), rs.getInt("day"));
            }
            else {
                throw new JobseekerNotFoundException(id);
            }
            rs.close();
            conn.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return jobseeker;
    }

//    public static boolean removeJobseeker(int id) throws JobseekerNotFoundException {
//        int row = 0;
//        String query = "DELETE FROM jobseeker where id = " + id;
//        Connection conn = DatabaseConnectionPostgre.connection();
//
//        try {
//            Statement s = conn.createStatement();
//            row = s.executeUpdate(query);
//            conn.close();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        if(row == 0) {
//            throw new JobseekerNotFoundException(id);
//        }
//        else {
//            return true;
//        }
//
//    }

    /**
     * Method yang digunakan untuk verifikasi login pada input
     * aplikasi dengan database
     * @param email
     * @param password
     * @return
     */
    public static Jobseeker jobseekerLogin(String email, String password) {
        Jobseeker jobseeker = null;
        PreparedStatement p;

        Connection conn = DatabaseConnectionPostgre.connection();
        String query = "SELECT * FROM jobseeker WHERE email = ? AND password = ?";

        try {
            p = conn.prepareStatement(query);
            p.setString(1, email);
            p.setString(2, Hash.hashMd5(password));
            ResultSet rs = p.executeQuery();
            if(rs.next()) {
                jobseeker = new Jobseeker(rs.getInt("id"), rs.getString("name"),
                        rs.getString("email"), rs.getString("password"), rs.getInt("year"),
                        rs.getInt("month"), rs.getInt("day"));
            }
            p.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return jobseeker;
    }

}
