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
	private ArrayList<Professor> profList = new ArrayList<Professor>();
	private Assessment assessment;
	private String[] groupType = {"lecture", "lab", "tutorial"};

	public Course(String courseID, String courseName)
	{
		this.courseName = courseName;
		this.courseID = courseID;
		assessment = new Assessment(courseID); 
	}

	public String getGroupType(int index){
		if(index >= 0 && index <= 3){
			return groupType[index];
		}
		else{
			return "null";
		}
	}

	public String getCourseID()
	{
		return courseID;
	}

	public String getCourseName(){
		return courseName;
	}

	public int getProfNum()
	{
		return profList.size();
	}

	public Professor getProf(int index)
	{
		return profList.get(index);
	}

	public void setCourseCapacity(int courseCapacity)
	{
		this.courseCapacity = courseCapacity;
	}

	public int getCourseCapacity(){
		return this.courseCapacity;
	}

	public int getGroupNum(int type){
		switch(type){
			case 0:
				return lecGroupNum;
			case 1:
				return labGroupNum;
			case 2:
				return tutGroupNum;
		}
		return 0;
	}

	public void setGroup(int index, Group group, int type){
		if(index >= getGroupNum(type) || index < 0){
			return;
		}
		switch(type){
			case 0:
				lecGroupList[index] = group;
				break;
			case 1:
				labGroupList[index] = group;
				break;
			case 2:
				tutGroupList[index] = group;
				break;
		}
	}

	public void createGroupList(int groupNum, int type){
		switch(type){
			case 0:
				this.lecGroupNum = groupNum;
				if(groupNum != 0){
					this.lecGroupList = new Group[lecGroupNum];
				}
				break;
			case 1:
				this.labGroupNum = groupNum;
				if(groupNum != 0){
					this.labGroupList = new Group[labGroupNum];
				}
				break;
			case 2:
				this.tutGroupNum = groupNum;
				if(groupNum != 0){
					this.tutGroupList = new Group[tutGroupNum];
				}
				break;
		}
		
	}

	public Group getGroup(int type, int index){
		if(index >= getGroupNum(type) || index < 0){
			return null;
		}
		switch(type){
			case 0:
				return lecGroupList[index];
			case 1:
				return labGroupList[index];
			case 2:
				return tutGroupList[index];
			default:
				return null;
		}
	}

	public void setAssessment()
	{
		AssessmentManager.setSubAssessments(assessment);
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
		if(prof != null){
			profList.add(prof);
		}
	}

	public int getLecGroupNum()
	{
		return lecGroupNum;
	}
	public int getTutGroupNum()
	{
		return tutGroupNum;
	}
	
	public int getLabGroupNum()
	{
		return labGroupNum;
	}

	public Group[] getLecGroupList(){
		return lecGroupList;
	}
	public Group[] getTutGroupList(){
		return tutGroupList;
	}
	public Group[] getLabGroupList(){
		return labGroupList;
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

	// public void setLecGroupNum(int lecGroupNum)
	// {
	// 	this.lecGroupNum = lecGroupNum;
	// }

	// public void setLabGroupNum(int labGroupNum)
	// {
	// 	this.labGroupNum = labGroupNum;
	// }

	// public void setTutGroupNum(int tutGroupNum)
	// {
	// 	this.tutGroupNum = tutGroupNum;
	// }

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


	// public void setLecGroupList()
	// {
	// 	this.lecGroupList = new Group[lecGroupNum];
	// 	int size = courseCapacity / lecGroupNum;
	// 	for(int i = 1; i <= lecGroupNum; i++)
	// 	{	
	// 		if(i == lecGroupNum){
	// 			size = courseCapacity - (lecGroupNum-1) * size;
	// 		}
	// 		System.out.println("Lecture group " + i + ":");
	// 		lecGroupList[i - 1] = GroupManager.createGroup(size, "lecture");
	// 	}
	// }

	// public void setLabGroupList()
	// {
	// 	this.labGroupList = new Group[labGroupNum];
	// 	int size = courseCapacity / labGroupNum;
	// 	for(int i = 1; i <= labGroupNum; i++)
	// 	{	
	// 		if(i == labGroupNum){
	// 			size = courseCapacity - (labGroupNum-1) * size;
	// 		}
	// 		System.out.println("Lab group " + i + ":");
	// 		labGroupList[i - 1] = GroupManager.createGroup(size, "lab");
	// 	}
	// }

	// public void setTutGroupList()
	// {
	// 	this.tutGroupList = new Group[tutGroupNum];
	// 	int size = courseCapacity / tutGroupNum;
	// 	for(int i = 1; i <= tutGroupNum; i++)
	// 	{	
	// 		if(i == tutGroupNum){
	// 			size = courseCapacity - (tutGroupNum-1) * size;
	// 		}
	// 		System.out.println("Tutorial group " + i + ":");
	// 		tutGroupList[i - 1] = GroupManager.createGroup(size, "tutorial");
	// 	}
	// }
}