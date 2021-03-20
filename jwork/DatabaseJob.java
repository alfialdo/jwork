
/**
 * Class untuk menyimpan data terkait job / pekerjaan
 * @author Muhammad ALfi A
 * @version Modul 2 - 18 March 2021
 */
public class DatabaseJob {
    private String[] listJob;
    
    public DatabaseJob(String[] listJob) {
        this.listJob = listJob;
    }

    
    /** 
     * Getter untuk attribute listJob
     * @return String[]
     */
    public String[] getListJob() {
        return null;
    }
    
    
    /** 
     * Method untuk menambahkan data job
     * @param job
     * @return Boolean
     */
    public static Boolean addJob(Job job) {
        return false;
    }

    
    /** 
     * Method untuk menghapus data job
     * @param job
     * @return Boolean
     */
    public Boolean removeJob(Job job) {
        return false;
    }

    
    /** 
     * Getter untuk attribute job
     * @return Job
     */
    public Job getJob(){
        return null;
    }

}
