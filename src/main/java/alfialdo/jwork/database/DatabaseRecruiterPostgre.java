package alfialdo.jwork.database;

import alfialdo.jwork.exception.EmailAlreadyExistsException;
import alfialdo.jwork.source.Location;
import alfialdo.jwork.source.Recruiter;
import alfialdo.jwork.exception.RecruiterNotFoundException;

import java.sql.*;
import java.util.ArrayList;

/**
 * Class untuk melakukan metode CRUD pada database
 * Recruiter PostgreSQL
 * @author Muhammad Alfi A
 * @version Final Project
 */
public class DatabaseRecruiterPostgre {
    public static int lastId = 0;

    /**
     * Method melakukan query seluruh isi Database Recruiter yang diurutkan
     * berdasarkan nama Recruiter
     * @return Databae Recruiter
     */
    public static  ArrayList<Recruiter> getRecruiterDatabase () {
        ArrayList<Recruiter> recruiters = new ArrayList<>();
        String query = "SELECT *, (location).province, (location).city, (location).description " +
                "FROM recruiter ORDER BY name";
        Connection conn = DatabaseConnectionPostgre.connection();

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(query);


            while(rs.next()) {
                Location location = new Location(rs.getString("province"), rs.getString("city"), rs.getString("description"));
                Recruiter recruiter = new Recruiter(rs.getInt("id"), rs.getString("name"),
                        rs.getString("email"), rs.getString("phone_number"),
                        location);
                recruiters.add(recruiter);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return recruiters;
    }

    /**
     * Method yang digunakan untuk INSERT data baru ke
     * Database Recruiter
     * @param recruiter
     * @throws EmailAlreadyExistsException
     */
    public static void addRecruiter(Recruiter recruiter) throws EmailAlreadyExistsException {
        Connection conn = DatabaseConnectionPostgre.connection();
        PreparedStatement p;
        String query;

        query = "SELECT * FROM recruiter WHERE email = ?";

        try {
            p = conn.prepareStatement(query);
            p.setString(1, recruiter.getEmail());
            ResultSet rs = p.executeQuery();
            if(rs.next()) {
                rs.close();
                throw new EmailAlreadyExistsException(recruiter.getEmail());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        query = "INSERT INTO recruiter VALUES(?, ?, ?, ?, ROW(?, ?, ?))";

        try {
            p = conn.prepareStatement(query);
            p.setInt(1, recruiter.getId());
            p.setString(2, recruiter.getName());
            p.setString(3, recruiter.getEmail());
            p.setString(4, recruiter.getPhoneNumber());
            p.setString(5, recruiter.getLocation().getProvince());
            p.setString(6, recruiter.getLocation().getCity());
            p.setString(7, recruiter.getLocation().getDescription());
            p.executeUpdate();
            p.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        lastId = recruiter.getId();
    }

    /**
     * Method yang digunakan untuk mendapatkan id terakhir pada database
     * @return Id terakhir yang ada pada database
     */
    public static int getLastId() {
        String query = "SELECT id FROM recruiter ORDER BY id DESC LIMIT 1";
        Connection conn = DatabaseConnectionPostgre.connection();

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(query);
            rs.next();
            if(rs.next()) {
                lastId = rs.getInt("id");
            }
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return lastId;
    }

    /**
     * Method yang digunakan untuk query data Recruiter
     * berdasarkan id pada PostgreSQL
     * @param id
     * @return
     * @throws RecruiterNotFoundException
     */
    public static Recruiter getRecruiterById(int id) throws RecruiterNotFoundException {
        Recruiter recruiter = null;
        String query = "SELECT *, (location).province, (location).city, (location).description FROM recruiter WHERE id = " + id;
        Connection conn = DatabaseConnectionPostgre.connection();

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(query);
            conn.close();

            if(rs.next()) {
                Location location = new Location(rs.getString("province"), rs.getString("city"), rs.getString("description"));
                recruiter = new Recruiter(rs.getInt("id"), rs.getString("name"),
                        rs.getString("email"), rs.getString("phone_number"),
                        location);
            }
            else {
                throw new RecruiterNotFoundException(id);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return recruiter;
    }

    /**
     * Method yang digunakan untuk DELETE data Recruiter
     * pada database PostgreSQL
     * @param id
     * @return
     * @throws RecruiterNotFoundException
     */
    public static boolean removeRecruiter(int id) throws RecruiterNotFoundException {
        int row = 0;
        String query = "DELETE FROM recruiter where id = " + id;
        Connection conn = DatabaseConnectionPostgre.connection();

        try {
            Statement s = conn.createStatement();
            row = s.executeUpdate(query);
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if(row == 0) {
            throw new RecruiterNotFoundException(id);
        }
        else {
            return true;
        }

    }

}
