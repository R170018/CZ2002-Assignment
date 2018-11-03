// package SCRAME;

public class Course{
	private String name;
	private String courseID;
	private Assessment assessment;

	public Course(String courseID){
		this.courseID = courseID;
		this.assessment = new Assessment("Overall assessment");
	}

	public void setAssessment(){
		assessment.setSubAssessments();	
	}

	public String getCourseId(){
		return courseID;
	}

	public void printAssessment(){
		System.out.println("//Course structure-------------------------");
		assessment.printAssessment(0);
	}


	public Assessment getAssessment(){
		return assessment;
	}
}