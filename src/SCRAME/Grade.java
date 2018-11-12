// package SCRAME;

import java.io.Serializable;

/**
 * Grade object of assessment
 *
 * @author MMZ
 * @version 1.0
 * @since 2018-11-12
 */
public class Grade implements Serializable {
    /**
     * Course object of grade
     */
    private Course course;
    /**
     * AssessmentMark of grade
     */
    private AssessmentMark assessmentMark;
    /**
     * Grade in text
     */
    private String grade;

    /**
     * Constructor of grade
     *
     * @param course course object
     */
    public Grade(Course course) {
        this.course = course;
    }

    /**
     * Set asssessment marks of grade
     *
     * @param assessmentMark assessmentMark Object
     */
    public void setAssessmentMark(AssessmentMark assessmentMark) {
        this.assessmentMark = assessmentMark;
    }

    /**
     * Set the grade
     *
     * @param grade string of the grade
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * Get the string text of the grade
     *
     * @return string form of the grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * Get the course of the grade is for
     *
     * @return course of the grade
     */
    public Course getCourse() {
        return course;
    }

    /**
     * Get the assessment mark of this course
     *
     * @return assessmentMark object
     */
    public AssessmentMark getAssessmentMark() {
        return assessmentMark;
    }

}