//package SCRAME;

import java.util.*;

public class Course
{
	private String courseID;
	private String courseName;
	private int courseSize;
	private int lecGroupSize;
	private int labGroupSize;
	private int tutGroupSize;
	private int lecGroupNum;
	private int labGroupNum;
	private int tutGroupNum;
	private Group[] lecGroupList;
	private Group[] labGroupList;
	private Group[] tutGroupList;
	private int profNum;
	private Professor[] profList;
	private Assessment assessment;

	public Course(String courseID, String courseName, int courseSize, int lecGroupNum, int labGroupNum, int tutGroupNum, int profNum, Professor[] profArr)
	{
		this.courseID = courseID;
		this.courseName = courseName;
		this.courseSize = courseSize;
		this.lecGroupNum = lecGroupNum;
		this.labGroupNum = labGroupNum;
		this.tutGroupNum = tutGroupNum;
		this.lecGroupSize = courseSize / lecGroupNum + 1;
		this.labGroupSize = courseSize / labGroupNum + 1;
		this.tutGroupSize = courseSize / tutGroupNum + 1;
		this.lecGroupList = new Group[lecGroupNum];
		this.labGroupList = new Group[labGroupNum];
		this.tutGroupList = new Group[tutGroupNum];
		this.profNum = profNum;
		profList = new Professor[profNum];
		this.profList = profArr;
		this.assessment = new Assessment(courseID);


		String tempID;
		Scanner sc = new Scanner(System.in);

		for(int i = 0; i < lecGroupNum; i++)
		{
			System.out.println("input ID of lecture group" + i);
			tempID = InputHandler.getLine();
			lecGroupList[i] = new Group(lecGroupSize, tempID, "Lecture");
		}

		for(int i = 0; i < labGroupNum; i++)
		{
			System.out.println("input ID of laboratory group" + i);
			tempID = InputHandler.getLine();
			labGroupList[i] = new Group(labGroupSize, tempID, "Laboratory");
		}

		for(int i = 0; i < tutGroupNum; i++)
		{
			System.out.println("input ID of tutorial group" + i);
			tempID = InputHandler.getLine();
			tutGroupList[i] = new Group(tutGroupSize, tempID, "Lecture");
		}


	}

	public String[] addStudent(Student student)
	{
		String groupArr[] = new String[3];
		groupArr[0] = null;
		groupArr[1] = null;
		groupArr[2] = null;

		for(int i = 0; i < lecGroupNum; i++)
		{
			if(lecGroupList[i].getVacancy() != 0)
			{
				if(!lecGroupList[i].searchStudent(student))
				{
					lecGroupList[i].addStudent(student);
					groupArr[0] = lecGroupList[i].getGroupID();
					break;
				}
				else
				{
					groupArr[0] = "EXIST";
					break;
				}
			}
			else if(lecGroupList[i].searchStudent(student))
			{
				groupArr[0] = "EXIST";
				break;
			}
		}
		groupArr[0] = "FULL";

		if(groupArr[0] == "FULL" || groupArr[0] == "EXIST");
		else
		{	for(int i = 0; i < labGroupNum; i++)
			{
				if(labGroupList[i].getVacancy() != 0)
				{
					labGroupList[i].addStudent(student);
					groupArr[1] = labGroupList[i].getGroupID();
					break;
				}
			}

			for(int i = 0; i < tutGroupNum; i++)
			{
				if(tutGroupList[i].getVacancy() != 0)
				{
					tutGroupList[i].addStudent(student);
					groupArr[2] = tutGroupList[i].getGroupID();
				}
			}
		}
		return groupArr;
	}

	public void setAssessment(){
		AssessmentManager.setSubAssessments(assessment);
	}

	public String getCourseId(){
		return courseID;
	}

	public void printAssessment(){
		AssessmentManager.printAssessment(assessment, 0);
	}

	public Assessment getAssessment(){
		return assessment;
	}
}