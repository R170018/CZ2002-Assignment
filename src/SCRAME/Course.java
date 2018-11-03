// package SCRAME;

public class Course{
	private String name;
	private String courseID;
	private Assessment assessment;

	public Course(String courseID){
		this.courseID = courseID;
		this.assessment = new Assessment(courseID);
	}

	public void setAssessment(){
		AssessmentManager.setSubAssessments(assessment);	
	}

	public String getCourseId(){
		return courseID;
	}

	public void printAssessment(){
		AssessmentManager.printAssessment(assessment, 0);
	}


	public Assessment getAssessment(){
		return assessment;
	}
}