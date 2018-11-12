import java.util.*;
import java.io.Serializable;

public class CourseManager implements Serializable
{
	private ArrayList<Course> courseList = new ArrayList<Course>();

	public void addCourse(String courseID, String courseName)
	{
		Course tempCourse = new Course(courseID, courseName);
		courseList.add(tempCourse); 
		addCourseDetails(courseID);
		System.out.println("Course " + courseID + " successfully added!");
	}

	public void addCourseDetails(String courseID)
	{
		Course course = getCourse(courseID);
		if(course == null){
			return;
		}
		System.out.println("Enter course capacity: ");
		course.setCourseCapacity(InputHandler.getInt());

		System.out.println("Enter number of lecture groups: ");
		course.createGroupList(InputHandler.getInt(), GroupType.LECTURE);
		setGroup(courseID, GroupType.LECTURE);

		System.out.println("Enter number of laborotary groups: ");
		course.createGroupList(InputHandler.getInt(), GroupType.LAB);
		setGroup(courseID, GroupType.LAB);

		System.out.println("Enter number of tutorial groups: ");
		course.createGroupList(InputHandler.getInt(), GroupType.TUTORIAL);
		setGroup(courseID, GroupType.TUTORIAL);
	}

	public void setGroup(String courseID, GroupType type){
		Course course = getCourse(courseID);
		if(course == null){
			return;
		}
		int groupNum = course.getGroupNum(type);
		String groupType = type.toString();
		int courseCapacity = course.getCourseCapacity();
		if(course != null){
			if(groupNum == 0){
				return;
			}
			int size = courseCapacity / groupNum;
			for(int i = 1; i <= groupNum; i++)
			{	
				if(i == groupNum){
					size = courseCapacity - (groupNum-1) * size;
				}
				System.out.println("Input ID for " + groupType + " group " + i + ": ");
				String tempID = InputHandler.getLine();
				Group newGroup = new Group(size, tempID, groupType);
				course.setGroup(i-1, newGroup, type);
			}
		}
	}

	//change
	public void addProfToCourse(String courseID, Professor prof){	
		Course tempCourse = getCourse(courseID);
		if(tempCourse != null){
			try{
				for(int i=0; i<tempCourse.getProfNum(); i++){
					if(tempCourse.getProf(i).getID().equals(prof.getID())){
						throw new Exception("Unsuccessful! Professor " + prof.getID() + " is already teaching course " + tempCourse.getCourseID() + "!");
					}
				}
				tempCourse.addProf(prof);
				System.out.println("Professor " + prof.getID() + " has been successfully assigned to course " + tempCourse.getCourseID() + ".");
			}
			catch (Exception e){
				System.out.println(e.getMessage());
			}
			
		}
	}

	//change
	public void addStudentToCourse(String courseID, Student student)
	{	
		Course course = getCourse(courseID);
		Group tempGroup;
		boolean hasVacancy = false;
		if(course == null){
			return;
		}
		//check if corresponding group exists
		int typeIndex;
		GroupType type = null;
		boolean hasGroup = false;
		for(typeIndex=0; typeIndex<3; typeIndex++){

			type = GroupType.values()[typeIndex];
			if(course.getGroupNum(type) > 0){
				hasGroup = true;
				break;
			}
		}
		try{
			if(!hasGroup){
				throw new Exception("Unsuccessful! Course " + course.getCourseID() + " has no group.");
			}
			//check if student's already taking the course
			for(int i=0; i<course.getGroupNum(type); i++){
				tempGroup = course.getGroupByIndex(type, i);
				if(tempGroup.haveStudent(student)){
					throw new Exception("Unsuccessful! Student " + student.getID() + " is already taking course " + course.getCourseID() + ".");
				}
			}
			//check vacancy and add student
			for(int i=0; i<course.getGroupNum(type); i++){
				tempGroup = course.getGroupByIndex(type, i);
				if(tempGroup.getVacancy() > 0){
					tempGroup.addStudent(student);
					System.out.println("Student " + student.getID() + " is assigned to lecture group " + tempGroup.getGroupID() + ".");
					hasVacancy = true;
					break;
				}
			}
			if(!hasVacancy){
				throw new Exception("Unsuccessful! Course " + course.getCourseID() + " has no vacancy.");
			}
			for(int i=typeIndex+1; i<3; i++){
				type = GroupType.values()[i];
				for(int j=0; j<course.getGroupNum(type); j++){
					tempGroup = course.getGroupByIndex(type, j);
					if(tempGroup.getVacancy() != 0){
						tempGroup.addStudent(student);
						System.out.println("Student " + student.getID() + " is assigned to lab group " + tempGroup.getGroupID() + ".");
						break;
					}
				}
			}
			
			//Pass course reference to student
			student.createGrade(course);

			System.out.println("Student " + student.getID() + " has been successfully assigned to course " + course.getCourseID() + ".");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}

	}

	public Boolean haveCourse(String courseID)
	{
		for(Course course : courseList)
		{
			if(courseID.equals(course.getCourseID()))
			{
				return true;
			}
		}
		return false;
	}

	public Course getCourse(String courseID)
	{
		for(Course course : courseList)
		{
			if(courseID.equals(course.getCourseID()))
			{
				return course;
			}
		}
		return null;
	}

	public void printCourseList()
	{
		System.out.println("Course List----------------------------------");
		for(Course course : courseList)
		{
			System.out.println("Course ID: " + course.getCourseID());
			System.out.println("Course Name: " + course.getCourseName());
			System.out.println("Professor in charge: ");
			for(int i=0; i<course.getProfNum(); i++){
				System.out.println("	ID:" + course.getProf(i).getID() + "	Name:" + course.getProf(i).getName());
			}
			System.out.println("---------------------------------------------");
		}
	}

	public void setAssessment(String courseID)
	{
		//find the target course to set assessments
		Course courseToSet = getCourse(courseID);
		if(courseToSet != null)
		{
			AssessmentManager.setSubAssessments(courseToSet.getAssessment());
		}
		
	}

	public void printAssessment(String courseID)
	{
		Course courseToPrint = getCourse(courseID);
		if(courseToPrint != null){
			System.out.println("Course structure---------------------------");
			System.out.println("Course ID: " + courseID);
			AssessmentManager.printAssessment(courseToPrint.getAssessment(), 0);
		}
	}

	public void checkVacancy(String courseID){
		Course course = getCourse(courseID);
		if(course == null){return;}
		System.out.println("Enter class type: LECTURE / TUTORIAL / LAB ");
		//enum groupType
		
        GroupType groupType = GroupType.valueOf(InputHandler.getLine()); 
        // check if the course has the group type
        try{
        	if (!course.haveGroupType(groupType)){
	            throw new Exception("Error: The course does not have any " + groupType + " class!" );
	        }

	        System.out.println("Enter the group ID: ");
	        String groupID = InputHandler.getLine();
	        //check if the course has the group ID for that group type
	        if(!course.haveGroup(groupType, groupID)){
	            throw new Exception("Error: The course does not have the "+ groupType + " group "+ groupID);
	        }

        	// check vacancy
        	System.out.println("Group vacancy for " + groupType + " group "+ groupID + " :" + course.getGroupVacancy(groupType, groupID) + "/" + course.getGroupSize(groupType, groupID));
		
        }catch (Exception e){
			System.out.println(e.getMessage());
		}
    }

	public void printStudentList(String courseID, GroupType groupType){
		Course course = getCourse(courseID);
		Group grp;
		
		if(course == null){return;}
		//for each group 
		System.out.println("Student list----------------------------");

		for (int i=0; i<course.getGroupNum(groupType); i++){
			grp = course.getGroupByIndex(groupType, i);
			System.out.println(groupType + " group " + grp.getGroupID() + ":");
			for (int j=0; j<grp.getGroupSize(); j++){
				// get the student name
				StudentManager.printStudentInfo(grp.getStudent(j));
			}
		}
	}

	void printStatistic(String courseID){
		Course course = getCourse(courseID);
		int[] studentNumber = new int[10];
		for(int i=0; i<10; i++){
			studentNumber[i] = 0;
		}
		if(course == null){return;}
		int typeIndex;
		GroupType type = null;
		boolean hasGroup = false;
		for(typeIndex=0; typeIndex<3; typeIndex++){
			type = GroupType.values()[typeIndex];
			if(course.getGroupNum(type) > 0){
				hasGroup = true;
				break;
			}
		}
		if(!hasGroup){
			System.out.println("Course " + course.getCourseID() + " has no group.");
			return;
		}
		
		System.out.println("Statistic of course " + course.getCourseID() + "------------------------------------------");
		
		System.out.println("Grade----------------------------------------------- ");
		//grade percentage
		for(int i=0; i<course.getGroupNum(type); i++){
			Group group = course.getGroupByIndex(type, i);
			for (int j=0; j<(group.getGroupSize() - group.getVacancy()); j++){
				// get the student name
				Student student = group.getStudent(j);
				Grade grade = student.getGradeByCourse(courseID);
				if(grade == null){
					break;
				}
				String strGrade = grade.getGrade();
				//grade
				System.out.println("Student " + student.getID() + ": " + strGrade);
				int index;
				switch(strGrade){
					case "A+":
						index = 0;
						break;
					case "A":
						index = 1;
						break;
					case "A-":
						index = 2;
						break;
					case "B+":
						index = 3;
						break;
					case "B":
						index = 4;
						break;
					case "B-":
						index = 5;
						break;
					case "C+":
						index = 6;
						break;
					case "C":
						index = 7;
						break;
					case "C-":
						index = 8;
						break;
					case "F":
						index = 9;
						break;
					default:
						index = -1;
				}
				if(index != -1){
					studentNumber[index]++;
				}
			}
		}
		int sum = 0;
		for(int i=0; i<10; i++){
			sum += studentNumber[i];
		}
		sum = (sum == 0) ? 1 : sum;
		System.out.println("A+: " + 100.0*studentNumber[0]/sum + "%");
		System.out.println("A:  " + 100.0*studentNumber[1]/sum + "%");
		System.out.println("A-: " + 100.0*studentNumber[2]/sum + "%");
		System.out.println("B+: " + 100.0*studentNumber[3]/sum + "%");
		System.out.println("B:  " + 100.0*studentNumber[4]/sum + "%");
		System.out.println("B-: " + 100.0*studentNumber[5]/sum + "%");
		System.out.println("C+: " + 100.0*studentNumber[6]/sum + "%");
		System.out.println("C:  " + 100.0*studentNumber[7]/sum + "%");
		System.out.println("C-: " + 100.0*studentNumber[8]/sum + "%");
		System.out.println("F:  " + 100.0*studentNumber[9]/sum + "%");
		System.out.println("------------------------------------------------");
		
		//assessment mark percentage
		Assessment assessment = course.getAssessment();
		printAssessmentStatistic(course, assessment, type, -1);
		
		for(int k=0; k<assessment.getNumOfSubAssessments(); k++){
			
			Assessment subAssessment = assessment.getSubAssessment(k);
			printAssessmentStatistic(course, subAssessment, type, k);
			
		}
	}
	public void printAssessmentStatistic(Course course, Assessment assessment, GroupType type, int k){
		int[] studentNumber = new int[10];
		for(int i=0; i<10; i++){
			studentNumber[i] = 0;
		}
		System.out.println(assessment.getName() + " mark ----------------------------------------------- ");
			int markSum = 0;
			for(int i=0; i<course.getGroupNum(type); i++){
				Group group = course.getGroupByIndex(type, i);
				for (int j=0; j<(group.getGroupSize() - group.getVacancy()); j++){
					// get the student name
					Student student = group.getStudent(j);
					Grade grade = student.getGradeByCourse(course.getCourseID());
					if(grade == null){
						break;
					}
					AssessmentMark assessmentMark = grade.getAssessmentMark();
					if(k > -1){
						assessmentMark = assessmentMark.getSubAssessmentMark(k);
					}
					int mark = assessmentMark.getMark();
					System.out.println("Student " + student.getID() + ": " + mark);
					//grade
					int index;
					markSum += mark;
					switch(mark/5){
						case 20:
						case 19:
							index = 0;
							break;
						case 18:
							index = 1;
							break;
						case 17:
							index = 2;
							break;
						case 16:
							index = 3;
							break;
						case 15:
							index = 4;
							break;
						case 14:
							index = 5;
							break;
						case 13:
							index = 6;
							break;
						case 12:
							index = 7;
							break;
						case 11:
							index = 8;
							break;
						default:
							index = 9;
							break;
					}
					studentNumber[index]++;
				}
			}
			int personSum = 0;
			for(int i=0; i<10; i++){
				personSum += studentNumber[i];
			}
			System.out.println("95: " + 100.0*studentNumber[0]/personSum + "%");
			System.out.println("90: " + 100.0*studentNumber[1]/personSum + "%");
			System.out.println("85: " + 100.0*studentNumber[2]/personSum + "%");
			System.out.println("80: " + 100.0*studentNumber[3]/personSum + "%");
			System.out.println("75: " + 100.0*studentNumber[4]/personSum + "%");
			System.out.println("70: " + 100.0*studentNumber[5]/personSum + "%");
			System.out.println("65: " + 100.0*studentNumber[6]/personSum + "%");
			System.out.println("60: " + 100.0*studentNumber[7]/personSum + "%");
			System.out.println("55: " + 100.0*studentNumber[8]/personSum + "%");
			System.out.println(" 0: " + 100.0*studentNumber[9]/personSum + "%");
			System.out.println("Averager: " + 1.0*markSum/personSum);
			System.out.println("----------------------------------------------------");
	}
}