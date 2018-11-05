//package SCRAME;

import java.util.*;

public class Student extends PersonSuperClass 
{
    private String studentID;
    private ArrayList <Grade> grade = new ArrayList <Grade>();
    private Boolean fullTime; // Full time/ Part-time
    private int studentType; // Exchange/ Graduate / Undergraduate
    private int studyYear;

    public Student(String studentID, String name, char gender, String nationality, String address, String contactNum, String email, Boolean fullTime, int studentType, int studyYear) 
    {
        super(name, gender, nationality, address, contactNum, email);
        this.studentID = studentID;
        this.fullTime = fullTime;
        this.studentType = studentType;
        this.studyYear = studyYear;
    }

    public void createMarks(String courseID) 
    {
        Grade tempGrade;
        tempGrade = getGrade(courseID);
        if(tempGrade != null)
        {
            tempGrade.createAssessmentMarks();
        }
    }

    public Grade getGrade(String courseID)
    {
        Course tempCourse;
        for(int i = 0; i < grade.size(); i++)
        {
            tempCourse = grade.get(i).getCourse();
            if(tempCourse.getCourseId().equals(courseID))
            {
                return grade.get(i);
            }
        }
        System.out.println("Course is not taken by student " + this.studentID + ".");
        return null;
    }

    public void printGrade() 
    {
        if(grade.size() == 0)
        {
            System.out.println("Student has not taken any courses.");
        }
        else
        {
            for(int i=0; i<grade.size(); i++)
            {
                GradeManager.printGrade(grade.get(i));
            }
        }
    }

    public void printStudent() 
    {
        System.out.println("StudentID : " +  this.studentID);
        System.out.println("Name : " +  this.getName());
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

}