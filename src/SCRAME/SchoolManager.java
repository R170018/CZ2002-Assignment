// package SCRAME;
import java.io.Serializable;
public class SchoolManager implements Serializable
{
	private CourseManager courseManager = new CourseManager();
	private	StudentManager studentManager = new StudentManager();
	private	ProfessorManager professorManager = new ProfessorManager();

	public void start()
	{
		int choice;
		// Student tempStudent;
		// Professor tempProf;
		// Course tempCourse;
		// String tempStudentID, tempStudentName;
		// String tempProfID, tempProfName;
		// String tempCourseID, tempCourseName;
		String tempStudentID;
		String tempProfID;
		String tempCourseID;
		

		do
		{
			System.out.println("(1)Add a student;");
			System.out.println("(2)Add a professor;");
			System.out.println("(3)Add a course;");
			System.out.println("(4)Enter course assessment components;");
			System.out.println("(5)Print course list;");
			System.out.println("(6)Print course structure;");
			System.out.println("(7)Print student list;");
			System.out.println("(8)Print student list for a course;");
			System.out.println("(9)Print professor list;");
			System.out.println("(10)Register student for a course;");
			//change
			System.out.println("(11)Assign professor to a course;");

			System.out.println("(12)Enter mark for a student;");
			System.out.println("(13)Print grade of a student;");

			System.out.println("(14)Print course statistics;");

			System.out.println("(15)Check available slot in a class (vacancy in a class);");
			System.out.println("(16)Exit;");
			System.out.println("Please enter your choice:");
			
			choice = InputHandler.getInt();

			switch(choice)
			{
				case 1:
					addStudent();
					break;

				case 2:
					addProf();
					break;

				case 3:
					addCourse();
					break;

				case 4:
					System.out.println("Enter the target course ID:");
					tempCourseID = InputHandler.getLine();
					addCourseComponent(tempCourseID);
					break;

				case 5:
					courseManager.printCourseList();
					break;

				case 6:
					System.out.println("Enter course ID: ");
	        		tempCourseID = InputHandler.getLine();
					printCourseComponent(tempCourseID);
					break;

				case 7:
					studentManager.printStudentList();
					break;

				case 8:
					System.out.println("Enter course ID: ");
	        		tempCourseID = InputHandler.getLine();
					printStudentListForCourse(tempCourseID);
					break;

				case 9:
					professorManager.printProfList();
					break;

				case 10:
					assignStudentToCourse();
					break;
				case 11:
					assignProfToCourse();
		        	break;

				case 12:
					System.out.println("Enter student ID:");
					tempStudentID = InputHandler.getLine();
					enterStudentMark(tempStudentID);
					break;

				case 13:
					System.out.println("Enter student ID: ");
					tempStudentID = InputHandler.getLine();
					printStudentGrade(tempStudentID);
					break;

				// 9. print course stats
				case 14:
					System.out.println("Enter course ID: ");
                    tempCourseID = InputHandler.getLine();
                    printCourseStatistic(tempCourseID);
					break;
				// 4
				case 15:
                    System.out.println("Enter course ID: ");
                    tempCourseID = InputHandler.getLine();
                    checkCourseVacancy(tempCourseID);
                    break;

                case 16:
                	break;					

				default:
					System.out.println("Please enter a valid choice.");
			}

		}while(choice != 16);
		
	}

	public void addStudent(){
		String tempStudentID;
		String tempStudentName;

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
	}

	public void addProf(){
		String tempProfID, tempProfName;

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
	}

	public void addCourse(){
		String tempCourseID, tempCourseName;
		String tempProfID, tempProfName;
		Professor tempProf;

		System.out.println("Input course ID: ");
		tempCourseID = InputHandler.getLine();
		if(!courseManager.haveCourse(tempCourseID))
		{
			System.out.println("Input course Name: ");
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
				boolean firstProfEntered = true;
				if(!professorManager.haveProf(tempProfID)){
					firstProfEntered = false;
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
								//firstProfEntered = false;
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
	}

	public void addCourseComponent(String tempCourseID){
		if(courseManager.haveCourse(tempCourseID)){
			courseManager.setAssessment(tempCourseID);
			courseManager.printAssessment(tempCourseID);
		}
		else{
			System.out.println("Course does not exist!");
		}
	}

	public void printCourseComponent(String tempCourseID){
		if(courseManager.haveCourse(tempCourseID)){
			courseManager.printAssessment(tempCourseID);
		}
		else{
			System.out.println("Course does not exist!");
		}
	}

	public void printStudentListForCourse(String courseID){
		try{
	        if (!courseManager.haveCourse(courseID)){
	            throw new Exception("Error: Course does not exist!");
	        }

	        System.out.println("Print student list according to a group type: Lecture / Tutorial / Lab : ");
			GroupType groupType=GroupType.valueOf(InputHandler.getLine()); 
			courseManager.printStudentList(courseID,groupType);

	    }
	    catch (Exception e){
	        System.out.println(e.getMessage());
	    }
	}

	public void assignStudentToCourse(){
		String tempStudentID, tempCourseID;
		Student tempStudent;

		//change
		System.out.println("Enter student ID: ");
		tempStudentID = InputHandler.getLine();
		if(studentManager.haveStudent(tempStudentID) == false)
		{
			System.out.println("Student does not exist!");
			return;
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
			return;
		}
	
		courseManager.addStudentToCourse(tempCourseID, tempStudent);
		
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
	}

	public void assignProfToCourse(){
		String tempCourseID, tempProfID;
		Professor tempProf;

		System.out.println("Enter course ID:");
		tempCourseID = InputHandler.getLine();
		if(!courseManager.haveCourse(tempCourseID)){
			System.out.println("Course does not exist!");
			return;
		}
		
		System.out.println("Enter professor ID:");
		tempProfID = InputHandler.getLine();
		if(!professorManager.haveProf(tempProfID)){
			System.out.println("Professor does not exist!");
			return;
		}
		else{
			tempProf = professorManager.getProf(tempProfID);
		}
		
		tempProf = professorManager.getProf(tempProfID);
		courseManager.addProfToCourse(tempCourseID, tempProf);
	}

	public void enterStudentMark(String tempStudentID){
		String tempCourseID;

		if(!studentManager.haveStudent(tempStudentID)){
			System.out.println("Student doesn't exist!");
			return;
		}

		System.out.println("Enter course ID:");
		tempCourseID = InputHandler.getLine();
		if(!courseManager.haveCourse(tempCourseID)){
			System.out.println("Course doesn't exist!");
			return;
		}

		studentManager.setMark(tempStudentID, tempCourseID);
	}

	public void printStudentGrade(String tempStudentID){
		if(studentManager.haveStudent(tempStudentID)){
			studentManager.printGrade(tempStudentID);
		}
		else{
			System.out.println("Student doesn't exist!");
		}
	}

	public void printCourseStatistic(String courseID){
		try{
                        
            if (!courseManager.haveCourse(courseID)){
                throw new Exception("Error: Course does not exist!");
            }

            System.out.println("Print course statistics according to a group type: Lecture / Tutorial / Lab : ");
			GroupType groupType=GroupType.valueOf(InputHandler.getLine()); 
			courseManager.printGrade(courseID,groupType);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
	}

	public void checkCourseVacancy(String courseID){
		try{
            //check if the course exists
            if (!courseManager.haveCourse(courseID)){
                throw new Exception("Error: Course does not exist!");
            }

            System.out.println("Enter class type: Lecture / Tutorial / Lab ");
			//enum groupType
			
            GroupType groupType=GroupType.valueOf(InputHandler.getLine()); 
            // check if the course has the group type
            if (!courseManager.haveGroupType(courseID, groupType)){
                throw new Exception("Error: The course does not have any " + groupType + " class!" );
            }


            System.out.println("Enter the group ID: ");
            String groupID=InputHandler.getLine();
            //check if the course has the group ID for that group type
            if(!courseManager.haveGroup(courseID, groupType, groupID)){
                throw new Exception("Error: The course does not have the "+ groupType + " group "+ groupID);
            }

            // check vacancy
            System.out.println("Group vacancy for " + groupType + " group "+ groupID+ " :" + courseManager.getGroupVacancy(courseID, groupType, groupID)+ "/" +courseManager.getGroupSize(courseID, groupType, groupID));
            
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
	}
}