// package SCRAME;

public class SchoolApp
{
	public static void main(String args[])
	{
		int choice;
		Boolean tempBoolean;
		Student tempStudent;
		Professor tempProf;
		Course tempCourse;
		String tempStudentID;
		CourseManager courseManager = new CourseManager();
		StudentManager studentManager = new StudentManager();
		ProfessorManager professorManager = new ProfessorManager();

		do
		{
			System.out.println("(1)Add a student;");
			System.out.println("(2)Add a professor;");
			System.out.println("(3)Add a course;");
			System.out.println("(4)Enter course assessment components weightage;");
			System.out.println("(5)Print course list;");
			System.out.println("(6)Print course structure;");
			System.out.println("(7)Print student list;");
			System.out.println("(8)Print professor list;");
			System.out.println("(9)Register a student for a course;");
			System.out.println("(10)Enter mark for a student;");
			System.out.println("(11)Print grade of a student;");
			System.out.println("(12)Exit;");
			System.out.println("Please enter your choice:");
			choice = InputHandler.getInt();

			switch(choice)
			{
				case 1:
					System.out.println("Enter student ID: ");
			        tempStudentID = InputHandler.getLine();
			        if(studentManager.haveStudent(tempStudentID) == false)
			        {
			        	System.out.println("Enter student name: ");
			        	String tempStudentName = InputHandler.getLine();
			        	tempStudent = studentManager.addStudent(tempStudentID, tempStudentName);
						System.out.println("Add detail information for this student?(1 : yes ; 0 : no): ");
						if(InputHandler.getInt() == 1)
						{
							studentManager.addStudentDetails(tempStudent);
						}
						System.out.println("Student successfully added!");
			        }
			        else
			        {
			        	System.out.println("Student exists!");
			        }
					break;

				case 2:
					System.out.println("Enter professor ID: ");
			        String tempProfID = InputHandler.getLine();
			        if(professorManager.haveProf(tempProfID) == false)
			        {
			        	System.out.println("Enter professor name: ");
			        	String tempProfName = InputHandler.getLine();
			        	tempProf = professorManager.addProf(tempProfID, tempProfName);
						System.out.println("Add detail information for this professor?(1 : yes ; 0 : no): ");
						if(InputHandler.getInt() == 1)
						{
							professorManager.addProfDetails(tempProf);
						}
						System.out.println("Professor successfully added!");
			        }
			        else
			        {
			        	System.out.println("Professor exists!");
			        }
					break;

				case 3:
					System.out.println("Input the course ID: ");
					String tempCourseID = InputHandler.getLine();
					if(courseManager.haveCourse(tempCourseID) == false)
					{
						System.out.println("Input the course Name: ");
						String tempCourseName = InputHandler.getLine();
						tempCourse = courseManager.addCourse(tempCourseID, tempCourseName);
						courseManager.addCourseDetails(tempCourse);
						int control = 1;
						while(control != 0)
						{
							System.out.println("Enter the professor ID for the instructor: ");
							tempProfID = InputHandler.getLine();
							if(professorManager.haveProf(tempProfID))
							{
								tempProf = professorManager.getProf(tempProfID);
								if(courseManager.addProfInCourse(tempCourse, tempProf) == false)
								{
									System.out.println("Instructor exists!");
								}
							}
							else
							{
								System.out.println("Professor not exists!");
							}
							System.out.println("Enter another instructor?(1:yes ; 0:no): ");
							control = InputHandler.getInt();
						}
					}
					else
					{
						System.out.println("Course exists!");
					}
					
					break;

				case 4:
					System.out.println("Enter the target course ID:");
					courseManager.setAssessment(InputHandler.getLine());
					break;

				case 5:
					courseManager.printCourseList();
					break;

				case 6:
					do
					{
						System.out.println("Enter course ID:");

					}while(!courseManager.printAssessment(InputHandler.getLine()));
					break;

				case 7:
					studentManager.printStudentList();
					break;

				case 8:
					professorManager.printProfList();
					break;

				case 9:
					while(true)
					{
						System.out.println("Enter student ID: ");
						tempStudentID = InputHandler.getLine();
						if(studentManager.haveStudent(tempStudentID) == false)
						{
							System.out.println("Student not exist! Please enter again!");
						}
						else
						{
							tempStudent = studentManager.getStudent(tempStudentID);
							break;
						}
					}

					while(true)
					{
						System.out.println("Enter course ID: ");
						tempCourseID = InputHandler.getLine();
						if(courseManager.haveCourse(tempCourseID) == false)
						{
							System.out.println("Course not exist! Please enter again!");
						}
						else
						{
							tempCourse = courseManager.getCourse(tempCourseID);
							break;
						}
					}

					String groupArr[] = new String[3];
					groupArr = courseManager.addStudentInCourse(tempCourse, tempStudent);

					if(groupArr[0].equals("EXIST"))
					{
						System.out.println("This student already registered!");
					}
					else if(groupArr[0].equals("FULL"))
					{
						System.out.println("This course has no vacancy!");
					}
					else
					{
						System.out.println("Successfully registered!");
						System.out.println("Assigned to lecture Group: " + groupArr[0]);
						System.out.println("Assigned to laboratary Group: " + groupArr[1]);
						System.out.println("Assigned to tutorial Group: " + groupArr[2]);
					}
					break;

				case 10:
					System.out.println("Enter student ID:");
					tempStudentID = InputHandler.getLine();
					do
					{
						System.out.println("Enter course ID:");
						tempCourseID = InputHandler.getLine();
						tempBoolean = courseManager.haveCourse(tempCourseID);
						if(!tempBoolean)
						{
							System.out.println("Course doesn't exist!");
							System.out.println("Do you want to print course list? 0/1");
							if(InputHandler.getInt() == 1)
							{
								courseManager.printCourseList();
							}
						}
					}while(!tempBoolean);
					studentManager.setMark(tempStudentID, tempCourseID);
					break;

				case 11:
					System.out.println("Enter student ID: ");
					studentManager.printGrade(InputHandler.getLine());
					break;
			}

		}while(choice != 12);
		
	}
}