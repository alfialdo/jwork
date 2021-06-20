package alfialdo.jwork.source;
 /**
 * Class untuk deskripsi job / pekerjaan
 * @author Muhammad Alfi A
 * @version Final Project - 20 June 2021
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

    private final String jobCategory;

    JobCategory (String jobCategory) {
        this.jobCategory = jobCategory;
    }
   
    @Override
    public String toString() {
        return this.jobCategory;
    }
}

 
