//package SCRAME;

import java.util.*;
//import java.io.Serializable;

public class Student extends Person
{
    private ArrayList <Grade> grade = new ArrayList <Grade>();
    private String typeOfStudy=null;
    private String studentType = null; //Graduate / Undergraduate
    private int studyYear = 0;

    public Student(String studentID, String studentName)
    {
        super(studentID, studentName);
    }

    public void createGrade(Course course){
        grade.add(new Grade(course));
    }

    public Grade getGradeByIndex(int index){
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


    public String getStudentType() {
        return studentType;
    }

    public int getStudyYear() {
        return studyYear;
    }

    public void setStudentType(boolean undergraduate)
    {
        if (undergraduate){
            studentType="undergraduate";
        }
        else studentType="graduate"; 
    }

    public void setStudyYear(int studyYear)
    {
        this.studyYear = studyYear;
    }

    public void setTypeOfStudy(boolean fullTime)
    {
        if (fullTime){
            typeOfStudy="full-time";
        }
        else typeOfStudy="part-time";
    }

    public String getTypeOfStudy(){
        return typeOfStudy;
    }
    //!!!
    public Grade getGradeByCourse(String courseID)
    {
        Course tempCourse;
        for(int i = 0; i < grade.size(); i++){
            tempCourse = grade.get(i).getCourse();
            if(tempCourse.getCourseID().equals(courseID))
            {
                return grade.get(i);
            }
        }
        return null;   
    }

}