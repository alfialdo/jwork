 
 /**
 * Class untuk deskripsi job / pekerjaan
 * @author Muhammad Alfi A
 * @version Modul 4 - 30 March 2021
 */
 public enum JobCategory {
    WebDeveloper("Web Developer"),
    FrontEnd("Front End"),
    BackEnd("Back End"),
    UI("UI"),
    UX("UX"),
    Devops("Devops"),
    DataScientist("Data Scientist"),
    DataAnalyst("Data Analyst");

    private String jobCategory;

    JobCategory (String jobCategory) {
        this.jobCategory = jobCategory;
    }
   
    @Override
    public String toString() {
        return this.jobCategory.toString();
    }
}

 
