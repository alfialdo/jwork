 
public enum JobCategory 
{
    WebDeveloper,
    FrontEnd,
    BackEnd,
    UI,
    UX,
    Devops,
    DataScientist,
    DataAnalyst;

    @Override
    public String toString() {
        switch(this) {
            case WebDeveloper : return "Web Developer";
            case FrontEnd : return "Front End";
            case BackEnd : return "Back End";
            case UI : return "UI";
            case UX : return "UX";
            case Devops : return "Devops";
            case DataScientist : return "Data Scientist";
            case DataAnalyst : return "Data Analyst";
            default : throw new IllegalArgumentException();
        }
    }

}
 