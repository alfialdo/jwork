package alfialdo.jwork.source;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.GregorianCalendar;

/**
 * Class jobseeker digunakan untuk membuat object Jobseeker
 * dengan attribute id, name, password, dan joinDate.
 *
 * @author Muhammad Alfi A
 * @version Final Project - 20 June 2021
 */

public class Jobseeker implements Serializable
{
    private int id;
    private String name, email, password;
    public Calendar joinDate;

    public Jobseeker(int id, String name, String email, String password, Calendar joinDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = Hash.hashMd5(password);
        this.joinDate = joinDate;
    }
    
    public Jobseeker(int id, String name, String email, String password, int year, int month, int dayOfMonth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = Hash.hashMd5(password);
        this.joinDate = new GregorianCalendar(year, month, dayOfMonth);

    }

    public Jobseeker(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = Hash.hashMd5(password);
        this.joinDate = new GregorianCalendar();
    }
    /** 
     * Getter untuk attribute id
     * @return int
     */
    public int getId() {
        return id;
    }

    
    /** 
     * Setter untuk attribute id
     */
    public void setId(int id) {
        this.id = id;
    }

    
    /** 
     * Getter untuk attribute name
     * @return String
     */
    public String getName() {
        return name;
    }

    
    /** 
     * Setter untuk attribute name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * Getter untuk attribute email
     * @return String
     */
    public String getEmail() {
        return email;
    }

    
    /** 
     * Setter untuk attribute email
     */
    public void setEmail(String email) {
        String pattern = "(?!.*\\.{2,})(?!\\.)[0-9A-z.&*_~]+@(?!-)[0-9A-z&*_~.-]+";
        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(email);
        if (m.find()) {
            this.email = email;
            // System.out.println("Email Diterima!");
        }
    }


    /** 
     * Getter untuk attribute password
     * @return String
     */
    public String getPassword() {
        return password;
    }


    /**
     * Setter untuk attribute password
     */
    public void setPassword(String password) {
        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";
        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(password);
        if (m.find()) {
            this.password = password;
        }
    }

    
    /** 
     * Getter untuk attribute joinDate
     * @return String
     */
    public Calendar getJoinDate() {
        return joinDate;
    }

    
    /** 
     * Setter untuk attribute joinDate
     */
    public void setJoinDate(Calendar joinDate) {
        this.joinDate = joinDate;
    }

    public void setJoinDate(int year, int month, int dayOfMonth) {
        this.joinDate = new GregorianCalendar(year, month, dayOfMonth);
    }
    
    /**
     * Method untuk print data dari object Jobseeker
     */
    public String toString (){
        SimpleDateFormat dateFormat = new SimpleDateFormat ("dd MMMM yyyy");
        dateFormat.setTimeZone(joinDate.getTimeZone());
        return "\nId= " + id + 
        "\nNama= " + name + 
        "\nEmail= " + email + 
        "\nPassword= " + password +
        "\nJoin Date= " + dateFormat.format(joinDate.getTime());
    }
}