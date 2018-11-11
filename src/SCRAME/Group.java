import java.io.Serializable;

public class Group implements Serializable
{
	private int vacancy;
	private String groupID;
	private int size;
	private String groupType;
	private Student[] studentList;	

	public Group(int size, String groupID, String groupType)
	{
		this.size = size;
		this.vacancy = size;
		this.groupID = groupID;
		this.groupType = groupType;
		this.studentList = new Student[this.size];
	}

	public void addStudent(Student student)
	{
		studentList[size - vacancy] = student;
		vacancy --;
	}

	public boolean haveStudent(Student student)
	{
		for(int i = 0; i < (size - vacancy); i++)
		{
			System.out.println(size - vacancy);
			if(studentList[i].getID().equals(student.getID()))
				return true;
		}
		return false;
	}

	public int getVacancy()
	{
		return vacancy;
	}

	public String getGroupID()
	{
		return groupID;
	}

	public int getGroupSize(){
		return size;
	}

	public Student getStudent(int studentIndex){
		return studentList[studentIndex];
	}

}