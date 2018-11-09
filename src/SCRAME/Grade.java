// package SCRAME;

public class Grade{
	private Course course;
	private AssessmentMark assessmentMark;
	private String grade;

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
		switch((assessmentMark.getMark()*2)/10){
			case 20:
			case 19:
				grade = "A+";
				break;
			case 18:
				grade = "A";
				break;
			case 17:
				grade = "A-";
				break;
			case 16:
				grade = "B+";
				break;
			case 15:
				grade = "B";
				break;
			case 14:
				grade = "B-";
				break;
			case 13:
				grade = "C+";
				break;
			case 12:
				grade = "C";
				break;
			case 11:
				grade = "C-";
				break;
			default:
				grade = "F";
		}
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