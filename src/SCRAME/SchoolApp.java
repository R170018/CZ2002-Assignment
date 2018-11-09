// package SCRAME;

public class SchoolApp
{

	public static void main(String args[])
	{
		int choice;
		Boolean tempBoolean;
		Student tempStudent;
		Professor tempProf;
		//change
		Course tempCourse;
		String tempStudentID, tempStudentName;
		String tempProfID, tempProfName;
		String tempCourseID, tempCourseName;
		CourseManager courseManager = new CourseManager();
		StudentManager studentManager = new StudentManager();
		ProfessorManager professorManager = new ProfessorManager();

		do
		{
			System.out.println("(1)Add a student;");
			System.out.println("(2)Add a professor;");
			System.out.println("(3)Add a course;");
			System.out.println("(4)Enter course assessment components;");
			System.out.println("(5)Print course list;");
			System.out.println("(6)Print course structure;");
			System.out.println("(7)Print student list;");
			System.out.println("(8)Print professor list;");
			System.out.println("(9)Register student for a course;");
			//change
			System.out.println("(10)Assign professor to a course;");

			System.out.println("(11)Enter mark for a student;");
			System.out.println("(12)Print grade of a student;");
			System.out.println("(13)Exit;");
			System.out.println("Please enter your choice:");
			choice = InputHandler.getInt();

			switch(choice)
			{
				case 1:
					System.out.println("Enter student ID: ");
			        tempStudentID = InputHandler.getLine();
			        if(!studentManager.haveStudent(tempStudentID))
			        {
			        	System.out.println("Enter student name: ");
			        	tempStudentName = InputHandler.getLine();
			        	studentManager.addStudent(tempStudentID, tempStudentName);
						//change
						// System.out.println("Add detail information for this student?(1 : yes ; 0 : no): ");
						// if(InputHandler.getInt() == 1)
						// {
						// 	studentManager.addStudentDetails(tempStudent);
						// }
						// System.out.println("Student successfully added!");
						studentManager.printStudentList();
			        }
			        else
			        {
			        	System.out.println("Student exists!");
			        }
					break;

				case 2:
					System.out.println("Enter professor ID: ");
			        tempProfID = InputHandler.getLine();
			        if(!professorManager.haveProf(tempProfID))
			        {
			        	System.out.println("Enter professor name: ");
			        	tempProfName = InputHandler.getLine();
			        	professorManager.addProf(tempProfID, tempProfName);
						// System.out.println("Add detail information for this professor?(1 : yes ; 0 : no): ");
						// if(InputHandler.getInt() == 1)
						// {
						// 	professorManager.addProfDetails(tempProf);
						// }
						// System.out.println("Professor successfully added!");
						professorManager.printProfList();
			        }
			        else
			        {
			        	System.out.println("Professor exists!");
			        }
					break;

				case 3:
					System.out.println("Input the course ID: ");
					tempCourseID = InputHandler.getLine();
					if(!courseManager.haveCourse(tempCourseID))
					{
						System.out.println("Input the course Name: ");
						tempCourseName = InputHandler.getLine();
						//change
						// tempCourse = courseManager.addCourse(tempCourseID, tempCourseName);
						// courseManager.addCourseDetails(tempCourse);
						courseManager.addCourse(tempCourseID, tempCourseName);
						//enter prof
						//change
						// int control = 1;
						// while(control != 0)
						// {
						// 	System.out.println("Enter the professor ID for the instructor: ");
						// 	tempProfID = InputHandler.getLine();
						// 	if(professorManager.haveProf(tempProfID))
						// 	{
						// 		tempProf = professorManager.getProf(tempProfID);
						// 		if(courseManager.addProfInCourse(tempCourse, tempProf) == false)
						// 		{
						// 			System.out.println("Instructor exists!");
						// 		}
						// 	}
						// 	else
						// 	{
						// 		System.out.println("Professor not exists!");
						// 	}
						// 	System.out.println("Enter another instructor?(1:yes ; 0:no): ");
						// 	control = InputHandler.getInt();
						// }
						System.out.println("Assign professors to course " + tempCourseID + "---------------------------");
						System.out.println("Enter professor ID:");
						tempProfID = InputHandler.getLine();
						do{	
							boolean firstProfEntered = false;
							if(!professorManager.haveProf(tempProfID)){
								System.out.println("Professor " + tempProfID + " doesn't exist.");
								int tempInt;
								do{
									System.out.println("Your options:");
									System.out.println("(1)Add professor " + tempProfID + " to professor list;");
									System.out.println("(2)Enter professor ID again.");
									System.out.println("(3)Print professor list.");
									System.out.println("Please enter your choice:");
									tempInt = InputHandler.getInt();
									switch(tempInt){
										case 1:
											System.out.println("Enter professor name: ");
								        	tempProfName = InputHandler.getLine();
								        	professorManager.addProf(tempProfID, tempProfName);
								        	professorManager.printProfList();
								        	firstProfEntered = true;
								        	break;
								        case 2:
								        	System.out.println("Enter professor ID:");
											tempProfID = InputHandler.getLine();
											firstProfEntered = false;
											break;
										case 3:
											professorManager.printProfList();
											tempInt = 0;
											break;
									}
								}while(tempInt != 1 && tempInt != 2 && tempInt != 3);
							}
							if(firstProfEntered){
								tempProf = professorManager.getProf(tempProfID);
								courseManager.addProfToCourse(tempCourseID, tempProf);
								System.out.println("Enter next professor ID: (enter -1 to stop)");
								tempProfID = InputHandler.getLine();
							}
						}while(!tempProfID.equals("-1"));
						courseManager.printCourseList();
					}
					else{
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
					System.out.println("Enter course ID:");

					courseManager.printAssessment(InputHandler.getLine());
					break;

				case 7:
					studentManager.printStudentList();
					break;

				case 8:
					professorManager.printProfList();
					break;

				case 9:

					//change
					System.out.println("Enter student ID: ");
					tempStudentID = InputHandler.getLine();
					if(studentManager.haveStudent(tempStudentID) == false)
					{
						System.out.println("Student does not exist!");
						break;
					}
					else
					{
						tempStudent = studentManager.getStudent(tempStudentID);
					}


					//change
					System.out.println("Enter course ID: ");
					tempCourseID = InputHandler.getLine();
					if(courseManager.haveCourse(tempCourseID) == false)
					{
						System.out.println("Course does not exist!");
						break;
					}
				

					courseManager.addStudentToCourse(tempCourseID, tempStudent);
					break;
					// String groupArr[] = new String[3];
					// groupArr = courseManager.addStudentToCourse(tempCourse, tempStudent);

					// if(groupArr[0].equals("EXIST"))
					// {
					// 	System.out.println("This student already registered!");
					// }
					// else if(groupArr[0].equals("FULL"))
					// {
					// 	System.out.println("This course has no vacancy!");
					// }
					// else
					// {
					// 	System.out.println("Successfully registered!");
					// 	System.out.println("Assigned to lecture Group: " + groupArr[0]);
					// 	System.out.println("Assigned to laboratary Group: " + groupArr[1]);
					// 	System.out.println("Assigned to tutorial Group: " + groupArr[2]);
					// }

				case 10:
					System.out.println("Enter professor ID:");
					tempProfID = InputHandler.getLine();
					if(professorManager.haveProf(tempProfID)){
						System.out.println("Prof already exist!");
						break;
					}
					System.out.println("Enter professor name: ");
		        	tempProfName = InputHandler.getLine();
		        	professorManager.addProf(tempProfID, tempProfName);
		        	professorManager.printProfList();
		        	break;

				case 11:
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

				case 12:
					System.out.println("Enter student ID: ");
					studentManager.printGrade(InputHandler.getLine());
					break;
			}

		}while(choice != 13);
		
	}

}