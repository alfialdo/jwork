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

    public static Job getJobById(int id) {
        int i=0;
        while(i < JOB_DATABASE.size()) {
            if (JOB_DATABASE.get(i).getId() == id) {
                return JOB_DATABASE.get(i);
            }
            i++;
        }
        return null;
    }

    public static ArrayList<Job> getJobByRecruiter(int recruiterId) {
        int i=0;
        ArrayList<Job> tempJob = new ArrayList<>();
        while(i < JOB_DATABASE.size()) {
            if (JOB_DATABASE.get(i).getRecuiter().getId() == recruiterId) {
                tempJob.add(JOB_DATABASE.get(i));
                return tempJob;
            }
            i++;
        }
        return null;
    }


    public static ArrayList<Job> getJobByCategory(JobCategory jobCategory) {
        int i=0;
        ArrayList<Job> tempJob = new ArrayList<>();
        while(i < JOB_DATABASE.size()) {
            if (JOB_DATABASE.get(i).getCategory() == jobCategory) {
                tempJob.add(JOB_DATABASE.get(i));
                return tempJob;
            }
            i++;
        }
        return null;
    }

    public static boolean addJob(Job job) {
        JOB_DATABASE.add(job);
        lastId = JOB_DATABASE.size()-1;
        return true;
    }

    public static boolean removeJob(int id) {
        int i=0;
        while(i < JOB_DATABASE.size()) {
            if (JOB_DATABASE.get(i).getId() == id) {
                JOB_DATABASE.remove(i);
                return true;
            }
            i++;
        }
        return false;
    }
}