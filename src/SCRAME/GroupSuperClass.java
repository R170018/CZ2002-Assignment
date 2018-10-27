package SCRAME;

abstract class GroupSuperClass {
	private int vacancy;
	private int id;
	private int size;
	private Student[] studentList;

	public void init(int size, int id){
		this.size = size;
		this.id = id;
		this.studentList = new Student[this.size];
	}

	public int addStudent(Student student){
		if(vacancy != 0)
		{
			studentList[size - vacancy] = student;
			vacancy --;
			return 1;
		}
		else return 0;
	}

	public int deleteStudent(Student student){
		int i = 0;
		for(; i < size - vacancy; i++)
		{
			if(studentList[i] == student)
			{
				while(i < size - vacancy - 1)
					studentList[i] = studentList[++i];
				vacancy ++;
				return 1;
			}
		}
		return 0;
	}

	public void print(){
		System.out.printf("Studetent ID\t\tStudent Name\n");
		for(int i = 0; i < size - vacancy; i++)
		{
			System.out.println(studentList[i].getName() + "				" + studentList[i].getID());
		}
	}
}
