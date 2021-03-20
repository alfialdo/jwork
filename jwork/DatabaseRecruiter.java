public class DatabaseRecruiter {
    private String[] listRecruiter;

    public DatabaseRecruiter(String[] listRecruiter) {
        this.listRecruiter = listRecruiter;
    }

    public static Boolean addRecruiter(Recruiter recruiter) {
        return false;
    }

    public Boolean removeRecruiter(Recruiter recruiter) {
        return false;
    }

    public Recruiter getRecruiter() {
        return null;
    }

    public String[] getListRecruiter() {
        return this.listRecruiter;
    }

    public void setListRecruiter(String[] listRecruiter) {
        this.listRecruiter = listRecruiter;
    }
    
    
}
