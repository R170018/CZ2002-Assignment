// package SCRAME;
import java.io.Serializable;

public class Grade implements Serializable{
	private Course course;
	private AssessmentMark assessmentMark;
	private String grade;

	public Grade(Course course){
		this.course = course;
	}

	public void setAssessmentMark(AssessmentMark assessmentMark){
		this.assessmentMark = assessmentMark;
	}

	public void setGrade(String grade){
		this.grade = grade;
	}

	public String getGrade(){
		return grade;
	}

	public Course getCourse(){
		return course;
	}

	public AssessmentMark getAssessmentMark(){
		return assessmentMark;
	}
	
}