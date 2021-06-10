package alfialdo.jwork.database;



import alfialdo.jwork.source.Bonus;
import alfialdo.jwork.exception.BonusNotFoundException;
import alfialdo.jwork.exception.ReferralCodeAlreadyExistsException;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseBonusPostgre {
    public static int lastId = 0;

    public static  ArrayList<Bonus> getBonusDatabase () {
        ArrayList<Bonus> jobseekers = new ArrayList<>();
        String query = "SELECT * FROM bonus";
        Connection conn = DatabaseConnectionPostgre.connection();

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(query);

            while(rs.next()) {
                Bonus bonus = new Bonus(rs.getInt("id"), rs.getInt("extra_fee"),
                        rs.getInt("min_total_fee"), rs.getString("referral_code"),
                        rs.getBoolean("active"));
                jobseekers.add(bonus);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return jobseekers;
    }

    public static void addBonus(Bonus bonus) throws ReferralCodeAlreadyExistsException {
        Connection conn = DatabaseConnectionPostgre.connection();
        PreparedStatement p;
        String query;

        query = "SELECT referral_code FROM bonus WHERE referral_code = ?";

        try {
            p = conn.prepareStatement(query);
            p.setString(1, bonus.getReferralCode());
            ResultSet rs = p.executeQuery();

            if(rs.next()) {
                throw new ReferralCodeAlreadyExistsException(bonus);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        query = "INSERT INTO bonus VALUES(?, ?, ?, ?, ?)";

        try {
            p = conn.prepareStatement(query);
            p.setInt(1, bonus.getId());
            p.setInt(2, bonus.getExtraFee());
            p.setInt(3, bonus.getMinTotalFee());
            p.setString(4, bonus.getReferralCode());
            p.setBoolean(5, bonus.getActive());
            p.executeUpdate();
            p.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        lastId = bonus.getId();
    }

    public static int getLastId() {
        String query = "SELECT id FROM bonus ORDER BY id DESC LIMIT 1";
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

    public static Bonus getBonusById(int id) throws BonusNotFoundException {
        Bonus bonus = null;
        String query = "SELECT * FROM bonus WHERE id = " + id;
        Connection conn = DatabaseConnectionPostgre.connection();

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(query);
            conn.close();

            if(rs == null) {
                throw new BonusNotFoundException(id);
            }
            else {
                rs.next();
                bonus = new Bonus(rs.getInt("id"), rs.getInt("extra_fee"),
                        rs.getInt("min_total_fee"), rs.getString("referral_code"),
                        rs.getBoolean("active"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return bonus;
    }

    public static Bonus getBonusByReferralCode(String referralCode) {
        Bonus bonus = null;
        String query = "SELECT * FROM bonus WHERE referral_code = ?";
        Connection conn = DatabaseConnectionPostgre.connection();

        try {
            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, referralCode);
            ResultSet rs = p.executeQuery();
            conn.close();

            if(rs.next()) {
                bonus = new Bonus(rs.getInt("id"), rs.getInt("extra_fee"),
                        rs.getInt("min_total_fee"), rs.getString("referral_code"),
                        rs.getBoolean("active"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return bonus;
    }

    public static boolean removeJobseeker(int id) throws BonusNotFoundException {
        int row = 0;
        String query = "DELETE FROM bonus where id = " + id;
        Connection conn = DatabaseConnectionPostgre.connection();

        try {
            Statement s = conn.createStatement();
            row = s.executeUpdate(query);
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if(row == 0) {
            throw new BonusNotFoundException(id);
        }
        else {
            return true;
        }

    }

}
