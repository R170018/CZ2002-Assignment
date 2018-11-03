// package SCRAME;

public class Grade{
	private Course course;
	private AssessmentMark assessmentMark;

	public Grade(Course course){
		this.course = course;
	}

	public void createAssessmentMarks(){
		assessmentMark = new AssessmentMark(course.getAssessment());
		AssessmentMarkManager.createSubAssessmentMarks(assessmentMark);
		calGrade();
	}

	public void calGrade(){
		assessmentMark.calGrade();
	}

	public Course getCourse(){
		return course;
	}

	public AssessmentMark getAssessmentMark(){
		return assessmentMark;
	}
	
}