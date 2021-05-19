package alfialdo.jwork;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class untuk database bonus
 * @author Muhammad Alfi A
 * @version Modul 4 - 30 March 2021

 */
public class DatabaseJob {
    private static ArrayList<Job> JOB_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    public static ArrayList<Job> getJobDatabase() {
        return JOB_DATABASE;
    }

    public static int getLastId() {
        return lastId;
    }

    public static Job getJobById(int id) throws JobNotFoundException {
        for(Job jobs : JOB_DATABASE) {
            if (jobs.getId() == id) {
                return jobs;
            }
        }
        throw new JobNotFoundException(id);
    }

    public static ArrayList<Job> getJobByRecruiter(int recruiterId) {
        ArrayList<Job> tempJob = new ArrayList<>();
        for(Job jobs : JOB_DATABASE) {
            if (jobs.getRecuiter().getId() == recruiterId) {
                tempJob.add(jobs);
                return tempJob;
            }
        }
        return null;
    }


    public static ArrayList<Job> getJobByCategory(JobCategory jobCategory) {

        ArrayList<Job> tempJob = new ArrayList<>();
        for(Job jobs : JOB_DATABASE) {
            if (jobs.getCategory() == jobCategory) {
                tempJob.add(jobs);
                return tempJob;
            }
        }
        return null;
    }

    public static boolean addJob(Job job) {
        JOB_DATABASE.add(job);
        lastId = job.getId();
        return true;
    }

    public static boolean removeJob(int id) throws JobNotFoundException {
        for(Job jobs : JOB_DATABASE) {
            if (jobs.getId() == id) {
                JOB_DATABASE.remove(id);
                return true;
            }
        }
        throw new JobNotFoundException(id);
    }
}