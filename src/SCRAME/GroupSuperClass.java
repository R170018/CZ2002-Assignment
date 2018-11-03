package SCRAME;

public class Group{
	private int vacancy;
	private String idid;
	private int size;
	private String groupType;
	private Student[] studentList;

	public Group(int size, String id, String groupType)
	{
		this.size = size;
		this.id = id;
		this.grouptype = groupType;
		this.studentList = new Student[this.size];
	}

	public void addStudent(Student student){
		studentList[size - vacancy] = student;
		vacancy --;
	}

	public boolean searchStudent(Student student)
	{
		for(int i = 0; i < size; i++)
		{
			if(studentList[i] == student())
				return true;
		}
		return false;
	}

	public void printList()
	{
		System.out,println("Info about" + groupType + id);
		System.out.printf("Studetent ID\t\tStudent Name\n");
		for(int i = 0; i < size - vacancy; i++)
		{
			System.out.printf("%s\t\t%s\n", studentList[i].getStudentID(), studentList.getName());
		}
	}

	public int getVacancy()
	{
		return vacancy;
	}

	public int getId()
	{
		return id;
	}

	public int getSize()
	{
		return size;
	}

	public String getGroupType()
	{
		return groupType;
	}
}
