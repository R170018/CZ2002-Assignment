//package SCRAME;

import java.util.*;
import java.io.Serializable;

public class Course implements Serializable
{	
	private String courseID;
	private String courseName;
	private int courseCapacity;
	private int lecGroupNum;
	private int labGroupNum;
	private int tutGroupNum;
	private Group[] lecGroupList;
	private Group[] labGroupList;
	private Group[] tutGroupList;
	private ArrayList<Professor> profList = new ArrayList<Professor>();
	private Assessment assessment;

	public Course(String courseID, String courseName)
	{
		this.courseName = courseName;
		this.courseID = courseID;
		assessment = new Assessment("Overall"); 
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

	public void setCourseCapacity(int courseCapacity)
	{
		this.courseCapacity = courseCapacity;
	}

	public int getCourseCapacity(){
		return this.courseCapacity;
	}

	public int getGroupNum(GroupType type){
		switch(type){
			case LECTURE:
				return lecGroupNum;
			case LAB:
				return labGroupNum;
			case TUTORIAL:
				return tutGroupNum;
		}
		return 0;
	}

	public void setGroup(int index, Group group, GroupType type){
		if(index >= getGroupNum(type) || index < 0){
			return;
		}
		switch(type){
			case LECTURE:
				lecGroupList[index] = group;
				break;
			case LAB:
				labGroupList[index] = group;
				break;
			case TUTORIAL:
				tutGroupList[index] = group;
				break;
		}
	}

	public void createGroupList(int groupNum, GroupType type){
		switch(type){
			case LECTURE:
				this.lecGroupNum = groupNum;
				if(groupNum != 0){
					this.lecGroupList = new Group[lecGroupNum];
				}
				break;
			case LAB:
				this.labGroupNum = groupNum;
				if(groupNum != 0){
					this.labGroupList = new Group[labGroupNum];
				}
				break;
			case TUTORIAL:
				this.tutGroupNum = groupNum;
				if(groupNum != 0){
					this.tutGroupList = new Group[tutGroupNum];
				}
				break;
		}
		
	}

	public Group getGroupByIndex(GroupType type, int index){
		if(index >= getGroupNum(type) || index < 0){
			return null;
		}
		switch(type){
			case LECTURE:
				return lecGroupList[index];
			case LAB:
				return labGroupList[index];
			case TUTORIAL:
				return tutGroupList[index];
			default:
				return null;
		}
	}

	public Boolean haveGroup(GroupType groupType, String groupID)
	{
		//get the target groupList from the target course 
		Group grp;
		for (int i=0; i<getGroupNum(groupType); i++){
			grp = getGroupByIndex(groupType, i);
			if (groupID.equals(grp.getGroupID())) return true;
		}
		return false;
	}

	public Group getGroupByID(GroupType groupType, String groupID)
	{
		//get the target groupList from the target course 
		Group grp;
		for (int i=0; i<getGroupNum(groupType); i++){
			grp = getGroupByIndex(groupType, i);
			if (groupID.equals(grp.getGroupID())) return grp;
		}
		return null;
	}

	public Boolean haveGroupType(GroupType groupType)
	{	
		return (getGroupNum(groupType) > 0);
	}

	public int getGroupVacancy(GroupType groupType, String groupID){
		Group grp = getGroupByID(groupType, groupID);

		if (grp != null){
			return grp.getVacancy();
		}
		return -1;
	}

	public int getGroupSize(GroupType groupType, String groupID){
		Group group = getGroupByID(groupType, groupID);
		if(group != null){
			return group.getGroupSize();
		}
		return -1;
	}
}