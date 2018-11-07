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
	private ArrayList<Professor> profList = new ArrayList<Professor>();
	private Assessment assessment;

	public Course(String courseID, String courseName)
	{
		this.courseName = courseName;
		this.courseID = courseID;
	}

	public String getCourseID()
	{
		return courseID;
	}

	public int getProfNum()
	{
		return profNum;
	}

	public void setCourseSize(int courseSize)
	{
		this.courseSize = courseSize;
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

	public void setLecGroupSize()
	{
		this.lecGroupSize = courseSize / lecGroupNum + 1;
	}

	public void setLabGroupSize()
	{
		this.labGroupSize = courseSize / labGroupNum + 1;
	}

	public void setTutGroupSize()
	{
		this.tutGroupSize = courseSize / tutGroupNum + 1;
	}

	public void setLecGroupList()
	{
		this.lecGroupList = new Group[lecGroupNum];
		for(int i = 1; i <= lecGroupNum; i++)
		{
			System.out.println("input ID of lecture group" + i + ": ");
			String tempID = InputHandler.getLine();
			lecGroupList[i - 1] = new Group(lecGroupSize, tempID, "Lecture");
		}
	}

	public void setLabGroupList()
	{
		this.labGroupList = new Group[labGroupNum];
		for(int i = 1; i <= labGroupNum; i++)
		{
			System.out.println("input ID of laboratory group" + i + ": ");
			String tempID = InputHandler.getLine();
			labGroupList[i - 1] = new Group(labGroupSize, tempID, "Laboratory");
		}
	}

	public void setTutGroupList()
	{
		this.tutGroupList = new Group[tutGroupNum];
		for(int i = 1; i <= tutGroupNum; i++)
		{
			System.out.println("input ID of tutorial group" + i + ": ");
			String tempID = InputHandler.getLine();
			tutGroupList[i - 1] = new Group(tutGroupSize, tempID, "Tutorial");
		}
	}

	public void setAssessment()
	{
		assessment = new Assessment(courseID);
		AssessmentManager.setSubAssessments(assessment);
	}

	public void printCourse()
	{
		System.out.println("Course ID: " + this.courseID + "          " + "Course Name: " + this.courseName);
	}

	public void printAssessment()
	{
		AssessmentManager.printAssessment(assessment, 0);
	}

	public Assessment getAssessment()
	{
		return assessment;
	}

	public boolean addProf(Professor prof)
	{
		for(Professor temp : profList)
		{
			if(temp.getProfID() == prof.getProfID())
			{
				return false;
			}
		}
		profList.add(prof);
		return true;
	}

	public String[] addStudent(Student student)
	{
		String groupArr[] = new String[3];
		groupArr[0] = "FULL";
		groupArr[1] = null;
		groupArr[2] = null;

		for(int i = 0; i < lecGroupNum; i++)
		{
			if(lecGroupList[i].getVacancy() != 0)
			{
				if(lecGroupList[i].searchStudent(student) == false)
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
}