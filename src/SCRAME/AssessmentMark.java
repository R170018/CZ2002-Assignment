// package SCRAME;

import java.io.Serializable;

/**
 * Assessment marks of the assessment
 *
 * @author MMZ
 * @version 1.0
 * @since 2018-11-12
 */
public class AssessmentMark implements Serializable {
    /**
     * Given assessment
     */
    private Assessment assessment;

    /**
     * Assesssment marks of any sub components
     */
    private AssessmentMark[] subAssessmentMark = new AssessmentMark[Assessment.MAX_SUBASSESSMENT];

    /**
     * The marks of assessment
     */
    private int mark = -1;

    /**
     * Constructor of assessment mark
     *
     * @param assessment given assessment object
     */
    public AssessmentMark(Assessment assessment) {
        this.assessment = assessment;
    }

    /**
     * Set the sub assessment
     *
     * @param index      index of sub assessment
     * @param assessment main assessment containing sub assessment
     */
    public void setSubAssessmentMark(int index, Assessment assessment) {
        subAssessmentMark[index] = new AssessmentMark(assessment);
    }

    /**
     * Set marks of the assessment
     *
     * @param mark marks of the assessment
     */
    public void setMark(int mark) {
        this.mark = mark;
    }

    /**
     * Get the marks of the assessment
     *
     * @return marks of the assessment
     */
    public int getMark() {
        return mark;
    }

    /**
     * Get the number of subassessment
     *
     * @return number of subassessment
     */
    public int getNumOfSubAssessmentMarks() {
        return assessment.getNumOfSubAssessments();
    }

    /**
     * Get the subassessment mark of a certain sub assessment
     *
     * @param index index of the sub assessment
     * @return marks of the sub assessment
     */
    public AssessmentMark getSubAssessmentMark(int index) {
        if (index >= 0 && index < assessment.getNumOfSubAssessments()) {
            return subAssessmentMark[index];
        }
        return null;
    }

    /**
     * Get assessment
     *
     * @return assessment object
     */
    public Assessment getAssessment() {
        return assessment;
    }

    /**
     * Get the weightage of the assessment
     *
     * @return weight of assessment
     */
    public int getPercentage() {
        return assessment.getPercentage();
    }

}