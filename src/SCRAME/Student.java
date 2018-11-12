//package SCRAME;

import java.util.*;
//import java.io.Serializable;

/**
 * Student class that contains all the information of a student
 *
 * @author MMZ
 * @version 1.0
 * @since 2018-11-12
 */
public class Student extends Person {
    /**
     * List of grades of the student
     */
    private ArrayList<Grade> grade = new ArrayList<Grade>();
    /**
     * Type of study, whether the student is full-time or part-time student
     */
    private String typeOfStudy = null;

    /**
     * Type of student, whether the student is graduate or undergraduate
     */
    private String studentType = null; //Graduate / Undergraduate

    /**
     * Study year of the student
     */
    private int studyYear = 0;

    /**
     * Creates a student with the given id and name
     * @param studentID id of student
     * @param studentName name of student
     */
    public Student(String studentID, String studentName) {
        super(studentID, studentName);
    }

    /**
     * Create the grade of given course for the student
     * @param course course for the grade
     */
    public void createGrade(Course course) {
        grade.add(new Grade(course));
    }

    /**
     * Get the grade by index
     * @param index index of the array in grades arraylist
     * @return the grade
     */
    public Grade getGradeByIndex(int index) {
        if (index < 0 || index >= getNumOfGrade()) {
            return null;
        } else {
            return grade.get(index);
        }
    }

    /**
     * Get the number of grades
     * @return number of grades
     */
    public int getNumOfGrade() {
        return grade.size();
    }

    /**
     * Get the type of student
     * @return studentType
     */
    public String getStudentType() {
        return studentType;
    }

    /**
     * Get the study year of the student
     * @return StudyYear
     */
    public int getStudyYear() {
        return studyYear;
    }

    /**
     * Set the student type of the student
     * @param undergraduate true if the student is undergraduate
     */
    public void setStudentType(boolean undergraduate) {
        if (undergraduate) {
            studentType = "undergraduate";
        } else studentType = "graduate";
    }

    /**
     * Set the study year of the student
     * @param studyYear study year of the student
     */
    public void setStudyYear(int studyYear) {
        this.studyYear = studyYear;
    }

    /**
     * Set the type of study for the student
     * @param fullTime true if the student is full-time
     */
    public void setTypeOfStudy(boolean fullTime) {
        if (fullTime) {
            typeOfStudy = "full-time";
        } else typeOfStudy = "part-time";
    }

    /**
     * Get the type of study for the student
     * @return typeofStudy
     */
    public String getTypeOfStudy() {
        return typeOfStudy;
    }

    //!!!

    /**
     * Get the grade by inputting in course id
     * @param courseID id of given course
     * @return grade of the student's course
     */
    public Grade getGradeByCourse(String courseID) {
        Course tempCourse;
        for (int i = 0; i < grade.size(); i++) {
            tempCourse = grade.get(i).getCourse();
            if (tempCourse.getCourseID().equals(courseID)) {
                return grade.get(i);
            }
        }
        return null;
    }

}