package SCRAME;
import java.util.Arrays; 
public class Course {
	private String courseName;
	private String lecGroup;
	private TutGroup[] tutGroup=new TutGroup[2];
	private LabGroup[] labGroup=new LabGroup[2];  
	private CourseCoordinator professor = new CourseCoordinator();
	//private Student[] student=new Student[15];
	private Student[] student=new Student[15];
	int studentIndex=0;
	
	public Course(String courseName, String lecGroup){
	         this.courseName =  courseName;
	         this.lecGroup=lecGroup;
	}  
	public Course(String courseName, String lecGroup, String tut1,String tut2){
        this.courseName =  courseName;
        this.lecGroup=lecGroup;
        tutGroup[0]=new TutGroup(tut1);
        tutGroup[1]=new TutGroup(tut2);
        
    }  
	
	public Course(String courseName, String lecGroup, String tut1,String tut2, String lab1, String lab2){
        this.courseName =  courseName;
        this.lecGroup=lecGroup;
        tutGroup[0]=new TutGroup(tut1);
        tutGroup[1]=new TutGroup(tut2);
        labGroup[0]=new LabGroup(lab1);
        labGroup[1]=new LabGroup(lab2);
        
    }  
	
	public void register(Student student,String tutGroup, String labGroup) {
		// implement exception handling
		for (int i=0;i<=studentIndex;i++) {
			if (this.student[i]==student) {
				System.out.println("The student has already been added!");
			}
		}

		this.student[studentIndex]=student;
		for (int i=0;i<2;i++) {
			if (this.tutGroup[i].getTutGroupName()==tutGroup) {
				this.tutGroup[i].registerForTutGroup(student);
			}
		}
		for (int i=0;i<2;i++) {
			if (this.labGroup[i].getLabGroupName()==labGroup) {
				this.tutGroup[i].registerForTutGroup(student);
			}
		}
		
	}
	

}
