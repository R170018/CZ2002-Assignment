import java.util.*;
public class StudentManager{
	private ArrayList<Student> student = new ArrayList<Student>();

	public void addStudent(String studentID){
		//TODO check if student exists
		student.add(new Student(studentID));
	}

	public void printStudent(){
		for(int i=0; i<student.size(); i++){
			System.out.println(student.get(i).getStudentID());
		}
	}

	public void setMark(String studentID, Course course){
		Student student = getStudent(studentID);
		student.createGrade(course);
		student.calGrade();
	}

	public Student getStudent(String studentID){
		for(int i=0; i<student.size(); i++){
			if(student.get(i).getStudentID().equals(studentID)){
				return student.get(i);
			}
		}
		return null;
	}

	public void printGrade(String studentID){
		Student student = getStudent(studentID);
		if(student != null){
			student.printGrade();
		}
		else{
			System.out.println("Student doesn't exist!");
		}
	}
}