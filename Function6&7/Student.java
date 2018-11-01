public class Student{
	private String studentID;
	private Grade grade;

	public Student(String studentID){
		this.studentID = studentID;
	}

	public String getStudentID(){
		return studentID;
	}

	public void createGrade(Course course){
		this.grade = new Grade(course);
	}

	public void calGrade(){
		grade.calGrade();
	}

	public void printGrade(){
		grade.printGrade();
	}
}