package alfialdo.jwork;

import alfialdo.jwork.database.DatabaseConnectionPostgre;
import alfialdo.jwork.database.DatabaseJobseekerPostgre;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.SQLException;

/*
    Main class yang digunakan untuk compile program bernama Jwork
*/
@SpringBootApplication
public class JWork
{
    public static void main(String[] args) {

//        Location loc1 = new Location("Jakarta", "Jakarta Pusat", "Macet");
//        Location loc2 = new Location("Jawa Barat", "Depok", "Gerah");
        Location loc3 = new Location("Bali", "Denpasar", "UwU");

//        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId()+1, "Alpha", "mantap@gmail.com", "082135356767", loc1));
//        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId()+1, "Beta", "djiw@gmail.com", "082135786577", loc2));
        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId()+1, "Charlie", "mantapdjiwa@gmail.com", "082136868567", loc3));

        try {
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, 8000000, "Server Configurator", JobCategory.Devops, DatabaseRecruiter.getRecruiterById(1)));
        } catch (RecruiterNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, 2000000, "Business Intelligence", JobCategory.DataScientist, DatabaseRecruiter.getRecruiterById(1)));
        } catch (RecruiterNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId()+1, 500000, 3000000, "yukbisayuk", true));
        } catch (ReferralCodeAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }


        try {
            DatabaseJobseekerPostgre.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Remi", "remi@gmail.com", "Tes123"));
        } catch (EmailAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        SpringApplication.run(JWork.class, args);

    }
}