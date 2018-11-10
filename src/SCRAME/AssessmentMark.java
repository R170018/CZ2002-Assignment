// package SCRAME;
import java.io.Serializable;

public class AssessmentMark implements Serializable{
	private Assessment assessment;
	private AssessmentMark[] subAssessmentMark = new AssessmentMark[Assessment.MAX_SUBASSESSMENT];
	private int mark = -1;

	public AssessmentMark(Assessment assessment){
		this.assessment = assessment;
	}

	public void setSubAssessmentMark(int index, Assessment assessment){
		subAssessmentMark[index] = new AssessmentMark(assessment);
	}

	public void setMark(int mark){
		this.mark = mark;
	}

	public int getMark(){
		return mark;
	}

	public int getNumOfSubAssessmentMarks(){
		return assessment.getNumOfSubAssessments();
	}

	public AssessmentMark getSubAssessmentMark(int index){
		if(index >= 0 && index < assessment.getNumOfSubAssessments()){
			return subAssessmentMark[index];
		}
		return null;
	}

	public Assessment getAssessment(){
		return assessment;
	}

	public int getPercentage(){
		return assessment.getPercentage();
	}

}