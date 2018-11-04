// package SCRAME;

public class SchoolApp{
	public static void main(String args[]){
		int choice;
		String tempStudentID;
		String tempCourseID;
		Boolean tempBoolean;
		CourseManager courseManager = new CourseManager();
		StudentManager studentManager = new StudentManager();
		do{
			System.out.println("(1)Add a course;");
			System.out.println("(2)Enter course assessment components weightage;");
			System.out.println("(3)Print courses;");
			System.out.println("(4)Print course structure;");
			System.out.println("(5)Add a student;");
			System.out.println("(6)Print student;");
			System.out.println("(7)Enter mark for a student;");
			System.out.println("(8)Print grade of a student;");
			System.out.println("(9)Exit;");
			System.out.println("Please enter your choice:");
			choice = InputHandler.getInt();

			switch(choice){
				case 1:
					System.out.println("Enter course ID:");
					courseManager.addCourse(InputHandler.getLine());
					break;
				case 2:
					System.out.println("Enter the target course ID:");
					courseManager.setAssessment(InputHandler.getLine());
					break;
				case 3:
					courseManager.printCourses();
					break;
				case 4:
					do{
						System.out.println("Enter course ID:");

					}while(!courseManager.printAssessment(InputHandler.getLine()));
					break;
				case 5:
					System.out.println("Enter student ID:");
					studentManager.addStudent(InputHandler.getLine());
					break;
				case 6:
					System.out.println("Student---------------------");
					studentManager.printStudent();
					break;
				case 7:
					System.out.println("Enter student ID:");
					tempStudentID = InputHandler.getLine();
					do{
						System.out.println("Enter course ID:");
						tempCourseID = InputHandler.getLine();
						tempBoolean = courseManager.haveCourse(tempCourseID);
						if(!tempBoolean){
							System.out.println("Course doesn't exist!");
							System.out.println("Do you want to print courses? 0/1");
							if(InputHandler.getInt() == 1){
								courseManager.printCourses();
							}
						}
					}while(!tempBoolean);
					studentManager.setMark(tempStudentID, tempCourseID);
					break;
				case 8:
					System.out.println("Enter student ID:");
					studentManager.printGrade(InputHandler.getLine());
					break;
			}

		}while(choice != 9);
		
	}
}