//package SCRAME;

public class Group
{
	private int vacancy;
	private String groupID;
	private int size;
	private String groupType;
	private Student[] studentList;

	public Group(int size, String groupID, String groupType)
	{
		this.size = size;
		this.groupID = groupID;
		this.groupType = groupType;
		this.studentList = new Student[this.size];
	}

	public void addStudent(Student student)
	{
		studentList[size - vacancy] = student;
		vacancy --;
	}

	public boolean searchStudent(Student student)
	{
		for(int i = 0; i < size; i++)
		{
			if(studentList[i] == student)
				return true;
		}
		return false;
	}

	public void printList()
	{
		System.out.println("Info about" + groupType + groupID);
		System.out.println("=========================================");
		System.out.printf("Studetent ID\t\tStudent Name\n");
		for(int i = 0; i < size - vacancy; i++)
		{
			System.out.printf("%s\t\t%s\n", studentList[i].getStudentID(), studentList[i].getName());
		}
		System.out.println("=========================================");
	}

	public int getVacancy()
	{
		return vacancy;
	}

	public String getGroupID()
	{
		return groupID;
	}

}