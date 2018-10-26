package SCRAME;

public class Student extends PersonSuperClass{
    private Boolean fullTime; // Full time/ Part-time
    private String studentType; // Exchange/ Graduate / Undergraduate
    private int studyYear;

    public Student(String numberID, String name, char gender, String nationality, String address, int contactNo, String email, Boolean fullTime, String studentType, int studyYear) {
        super(numberID, name, gender, nationality, address, contactNo, email);
        this.fullTime = fullTime;
        this.studentType = studentType;
        this.studyYear = studyYear;
    }

    public Boolean getFullTime() {
        return fullTime;
    }

    public void setFullTime(Boolean fullTime) {
        this.fullTime = fullTime;
    }

    public String getStudentType() {
        return studentType;
    }

    public void setStudentType(String studentType) {
        this.studentType = studentType;
    }

    public int getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(int studyYear) {
        this.studyYear = studyYear;
    }
}
