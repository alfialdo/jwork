package alfialdo.jwork;

import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
    Main class yang digunakan untuk compile program bernama Jwork
*/
@SpringBootApplication
public class JWork
{
    public static void main(String[] args) {
        Location loc1 = new Location("Jakarta", "Jakarta Pusat", "Macet");
        Location loc2 = new Location("Jawa Barat", "Depok", "Gerah");
        Location loc3 = new Location("Bali", "Denpasar", "UwU");

        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId()+1, "Alpha", "mantap@gmail.com", "082135356767", loc1));
        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId()+1, "Beta", "djiw@gmail.com", "082135786577", loc1));
        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId()+1, "Charlie", "mantapdjiwa@gmail.com", "082136868567", loc1));

        try {
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, 8000000, "IT support", JobCategory.Devops, DatabaseRecruiter.getRecruiterById(1)));
        } catch (RecruiterNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, 2000000, "Analyst", JobCategory.DataScientist, DatabaseRecruiter.getRecruiterById(2)));
        } catch (RecruiterNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, 4000000, "Scientist", JobCategory.DataScientist, DatabaseRecruiter.getRecruiterById(3)));
        } catch (RecruiterNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, 400000, "Web Dev", JobCategory.UI, DatabaseRecruiter.getRecruiterById(1)));
        } catch (RecruiterNotFoundException e) {
            System.out.println(e.getMessage());
        }

        SpringApplication.run(JWork.class, args);

    }
}