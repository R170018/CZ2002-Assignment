// package SCRAME;

public class Grade{
	private Course course;
	private AssessmentMark assessmentMark;

	public Grade(Course course){
		this.course = course;
	}

	public void createAssessmentMarks(){
		assessmentMark = new AssessmentMark(course.getAssessment());
		calGrade();
	}

	public void calGrade(){
		assessmentMark.calGrade();
	}

	public Course getCourse(){
		return course;
	}

	public void printGrade(){
		System.out.println("Grade-------------------------------");
		System.out.println(course.getCourseId() + ": ");
		assessmentMark.printMark(0);
	}
	
}