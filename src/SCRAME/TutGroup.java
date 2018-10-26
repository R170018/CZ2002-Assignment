package SCRAME;

public class TutGroup {
	private String groupName;
	private int vacancy;
	private Student[] student=new Student[15];
	int studentIndex=0;
	
	public TutGroup(String groupName) {
		this.groupName=groupName;
		vacancy=10;
	}
	
	public String getTutGroupName() {
		return groupName;
	}
	
	public void registerForTutGroup(Student student) {
		if (vacancy>0) {
			this.student[studentIndex]=student;
		}
		vacancy--;
		
	}
	public void getVacancy() {
		System.out.println("Vacancy for utorial class "+groupName+": "+vacancy+"/10");
	}
	

}
