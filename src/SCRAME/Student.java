//package SCRAME;

import java.util.*;

public class Student extends PersonSuperClass 
{
    private String studentID;
    private ArrayList <Grade> grade = new ArrayList <Grade>();
    private Boolean fullTime = true; // Full time/ Part-time
    private int studentType = 0; // Exchange/ Graduate / Undergraduate
    private int studyYear = 0;

    public Student(String studentID, String studentName)
    {
        super(studentName);
        this.studentID = studentID;
    }

    public void createGrade(Course course){
        grade.add(new Grade(course));
    }

    public Grade getGrade(int index){
        if(index < 0 || index >= getNumOfGrade()){
            return null;
        }
        else{
            return grade.get(index);
        }
    }

    public int getNumOfGrade(){
        return grade.size();
    }

    public String getStudentID()
    {
        return studentID;
    }

    public Boolean getFullTime() {
        return fullTime;
    }

    public int getStudentType() {
        return studentType;
    }

    public int getStudyYear() {
        return studyYear;
    }

    public void setStudentType(int studentType)
    {
        this.studentType = studentType;
    }

    public void setStudyYear(int studyYear)
    {
        this.studyYear = studyYear;
    }

    public void setFullTime(boolean fullTime)
    {
        this.fullTime = fullTime;
    }

}