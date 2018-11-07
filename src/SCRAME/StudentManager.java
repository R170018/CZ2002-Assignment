import java.util.*;

public class StudentManager 
{
    private ArrayList<Student> studentList = new ArrayList<Student>();

    public Student getStudent(String studentID) 
    {
        for(Student student : studentList)
        {
            if(studentID.equals(student.getStudentID()))
            {
                return student;
            }
        }
        return null;
    }

    public boolean haveStudent(String studentID)
    {
        for(Student student : studentList)
        {
            if(studentID.equals(student.getStudentID()))
            {
                return true;
            }
        }
        return false;
    }

    public Student addStudent(String studentID, String studentName)
    {
        Student tempStudent = new Student(studentID, studentName);
        studentList.add(tempStudent);
        return tempStudent;
    }

    public void addStudentDetails(Student student)
    {
        System.out.println("Enter gender(male: M; female: F): ");
        student.setGender(InputHandler.getLine().charAt(0));

        System.out.println("Enter nationality: ");
        student.setNationality(InputHandler.getLine());

        System.out.println("Enter address: ");
        student.setAddress(InputHandler.getLine());

        System.out.println("Enter contact number: ");
        student.setContactNum(InputHandler.getLine());

        System.out.println("Enter email: ");
        student.setEmail(InputHandler.getLine());

        System.out.println("Is student studying fullTime? (Y/N)");
        student.setFullTime('Y' == InputHandler.getLine().charAt(0));

        System.out.println("Is student (1) Exchange/ (2) Graduate / (3) Undergraduate?");
        student.setStudentType(InputHandler.getInt());

        System.out.println("Student Year for Student? (e.g. 2018)");
        student.setStudyYear(InputHandler.getInt());
    }

    public void printStudentList() 
    {
        System.out.println("Student list----------------------------");
        for (Student student : studentList) 
        {
            student.printStudent();
        }
    }

    public void setMark(String studentID, String courseID) 
    {
        Student student = getStudent(studentID);
        if(student != null)
        {
            student.createMarks(courseID);
        }
    }

    public void printGrade(String studentID) 
    {
        Student student = getStudent(studentID);
        if (student != null) 
        {
            student.printGrade();
        } 
        else 
        {
            System.out.println("Student doesn't exist!");
        }
    }
}