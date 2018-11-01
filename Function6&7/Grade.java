public class Grade{
	private Course course;
	private int overallMark = -1;
	private AssessmentMark[] assessmentMark = new AssessmentMark[Course.MAX_ASSESSMENT];

	public Grade(Course course){
		this.course = course;
		createAssessmentMarks();
	}

	public void createAssessmentMarks(){
		for(int i=0; i<course.getNumOfAssessments(); i++){
			assessmentMark[i] = new AssessmentMark(course.getAssessment(i));
		}
	}

	public void calGrade(){
		int sum = 0;
		if(course.getNumOfAssessments() > 0){
			for(int i=0; i<course.getNumOfAssessments(); i++){
				sum += assessmentMark[i].calGrade();
			}
			overallMark = sum;
		}
		else{
			System.out.println("This course has no assessments!");
		}
	}

	public void printGrade(){
		System.out.println("Grade-------------------------------");
		System.out.printf(course.getCourseId() + ": ");
		System.out.println(overallMark);
		for(int i=0; i<course.getNumOfAssessments(); i++){
			assessmentMark[i].printMark(1);
		}
	}
	
}