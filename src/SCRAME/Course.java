//package SCRAME;

import java.util.*;

public class Course
{	
	private String courseID;
	private String courseName;
	private int courseCapacity;
	//change
	// private int lecGroupSize;
	// private int labGroupSize;
	// private int tutGroupSize;
	private int lecGroupNum;
	private int labGroupNum;
	private int tutGroupNum;
	private Group[] lecGroupList;
	private Group[] labGroupList;
	private Group[] tutGroupList;
	private int profNum;
	private ArrayList<Professor> profList = new ArrayList<Professor>();
	private Assessment assessment;

	public Course(String courseID, String courseName)
	{
		this.courseName = courseName;
		this.courseID = courseID;
		assessment = new Assessment(courseID); 
	}

	public String getCourseID()
	{
		return courseID;
	}

	public int getProfNum()
	{
		return profNum;
	}

	public void setCourseCapacity(int courseCapacity)
	{
		this.courseCapacity = courseCapacity;
	}

	public void setLecGroupNum(int lecGroupNum)
	{
		this.lecGroupNum = lecGroupNum;
	}

	public void setLabGroupNum(int labGroupNum)
	{
		this.labGroupNum = labGroupNum;
	}

	public void setTutGroupNum(int tutGroupNum)
	{
		this.tutGroupNum = tutGroupNum;
	}

	//change
	// public void setLecGroupSize()
	// {
	// 	this.lecGroupSize = courseCapacity / lecGroupNum + 1;
	// }

	// public void setLabGroupSize()
	// {
	// 	this.labGroupSize = courseCapacity / labGroupNum + 1;
	// }

	// public void setTutGroupSize()
	// {
	// 	this.tutGroupSize = courseCapacity / tutGroupNum + 1;
	// }


	public void setLecGroupList()
	{
		this.lecGroupList = new Group[lecGroupNum];
		int size = courseCapacity / lecGroupNum;
		for(int i = 1; i <= lecGroupNum; i++)
		{	
			if(i == lecGroupNum){
				size = courseCapacity - (lecGroupNum-1) * size;
			}
			System.out.println("Lecture group " + i + ":");
			lecGroupList[i - 1] = GroupManager.createGroup(size, "lecture");
		}
	}

	public void setLabGroupList()
	{
		this.labGroupList = new Group[labGroupNum];
		int size = courseCapacity / labGroupNum;
		for(int i = 1; i <= labGroupNum; i++)
		{	
			if(i == labGroupNum){
				size = courseCapacity - (labGroupNum-1) * size;
			}
			System.out.println("Lab group " + i + ":");
			labGroupList[i - 1] = GroupManager.createGroup(size, "lab");
		}
	}

	public void setTutGroupList()
	{
		this.tutGroupList = new Group[tutGroupNum];
		int size = courseCapacity / tutGroupNum;
		for(int i = 1; i <= tutGroupNum; i++)
		{	
			if(i == tutGroupNum){
				size = courseCapacity - (tutGroupNum-1) * size;
			}
			System.out.println("Tutorial group " + i + ":");
			tutGroupList[i - 1] = GroupManager.createGroup(size, "tutorial");
		}
	}

	public void setAssessment()
	{
		AssessmentManager.setSubAssessments(assessment);
	}

	//change
	public void printCourse()
	{
		System.out.println("Course ID: " + this.courseID);
		System.out.println("Course Name: " + this.courseName);
		System.out.println("Professor in charge: ");
		for(int i=0; i<profList.size(); i++){
			System.out.println("	ID:" + profList.get(i).getProfID() + "	Name:" + profList.get(i).getName());
		}
		System.out.println("---------------------------------------------");
	}

	public void printAssessment()
	{
		AssessmentManager.printAssessment(assessment, 0);
	}

	public Assessment getAssessment()
	{
		return assessment;
	}

	//change
	public void addProf(Professor prof)
	{
		for(Professor temp : profList)
		{
			if(temp.getProfID().equals(prof.getProfID()))
			{	
				System.out.println("Unsuccessful! Professor " + prof.getProfID() + " is already teaching course " + courseID + "!" );
				return;
			}
		}
		profList.add(prof);
		System.out.println("Professor " + prof.getProfID() + " has been successfully assigned to course " + courseID + ".");
	}

	public void addStudent(Student student){
		boolean hasVacancy = false;
		//check if student's already taking the course
		for(int i=0; i<lecGroupNum; i++){
			if(lecGroupList[i].haveStudent(student)){
				System.out.println("Unsuccessful! Student " + student.getStudentID() + " is already taking course " + courseID + ".");
				break;
			}
		}
		//check vacancy and add student
		for(int i=0; i<lecGroupNum; i++){
			if(lecGroupList[i].getVacancy() != 0){
				lecGroupList[i].addStudent(student);
				System.out.println("Student " + student.getStudentID() + " is assigned to lecture group " + lecGroupList[i].getGroupID() + ".");
				hasVacancy = true;
				break;
			}
		}
		if(!hasVacancy){
			System.out.println("Unsuccessful! Course " + courseID + " has no vacancy.");
		}
		else{
			for(int i=0; i<tutGroupNum; i++){
				if(tutGroupList[i].getVacancy() != 0){
					tutGroupList[i].addStudent(student);
					System.out.println("Student " + student.getStudentID() + " is assigned to tutorial group " + tutGroupList[i].getGroupID() + ".");
					break;
				}
			}
			for(int i=0; i<labGroupNum; i++){
				if(labGroupList[i].getVacancy() != 0){
					labGroupList[i].addStudent(student);
					System.out.println("Student " + student.getStudentID() + " is assigned to lab group " + labGroupList[i].getGroupID() + ".");
					break;
				}
			}
			//Pass course reference to student
			student.createGrade(this);
		}
	}

	//change
	// public String[] addStudent(Student student)
	// {
	// 	String groupArr[] = new String[3];
	// 	groupArr[0] = "FULL";
	// 	groupArr[1] = null;
	// 	groupArr[2] = null;

	// 	for(int i = 0; i < lecGroupNum; i++)
	// 	{
	// 		if(lecGroupList[i].getVacancy() != 0)
	// 		{
	// 			if(lecGroupList[i].searchStudent(student) == false)
	// 			{
	// 				lecGroupList[i].addStudent(student);
	// 				groupArr[0] = lecGroupList[i].getGroupID();
	// 				break;
	// 			}
	// 			else
	// 			{
	// 				groupArr[0] = "EXIST";
	// 				break;
	// 			}
	// 		}
	// 		else if(lecGroupList[i].searchStudent(student))
	// 		{
	// 			groupArr[0] = "EXIST";
	// 			break;
	// 		}
	// 	}

	// 	if(groupArr[0] == "FULL" || groupArr[0] == "EXIST");
	// 	else
	// 	{	for(int i = 0; i < labGroupNum; i++)
	// 		{
	// 			if(labGroupList[i].getVacancy() != 0)
	// 			{
	// 				labGroupList[i].addStudent(student);
	// 				groupArr[1] = labGroupList[i].getGroupID();
	// 				break;
	// 			}
	// 		}

	// 		for(int i = 0; i < tutGroupNum; i++)
	// 		{
	// 			if(tutGroupList[i].getVacancy() != 0)
	// 			{
	// 				tutGroupList[i].addStudent(student);
	// 				groupArr[2] = tutGroupList[i].getGroupID();
	// 			}
	// 		}
	// 	}
	// 	return groupArr;
	// }
}