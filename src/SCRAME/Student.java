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
            if(tempCourse.getCourseID().equals(courseID))
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
        System.out.println("StudentID: " +  this.studentID + "   " + "Name: " + this.getName());
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