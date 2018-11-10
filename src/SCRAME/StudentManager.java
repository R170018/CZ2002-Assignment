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

    // change
    // public Student addStudent(String studentID, String studentName)
    // {
    //     Student tempStudent = new Student(studentID, studentName);
    //     studentList.add(tempStudent);
    //     return tempStudent;
    // }

    public void addStudent(String studentID, String studentName)
    {
        Student tempStudent = new Student(studentID, studentName);
        studentList.add(tempStudent);
        System.out.println("Add detail information for this student?(1 : yes, 0 : no): ");
        if(InputHandler.getInt() == 1){
            addStudentDetails(studentID);
        }
        System.out.println("Student " + studentID + " successfully added!");
    }

    public void addStudentDetails(String studentID/*change: Student student*/)
    {   
        Student student = getStudent(studentID);
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
            System.out.println("StudentID: " +  student.getStudentID() + "   " + "Name: " + student.getName());
        }
    }

    public void setMark(String studentID, String courseID) 
    {
        Student student = getStudent(studentID);
        if(student != null)
        {   
            Grade tempGrade = null;
            Course tempCourse;
            for(int i = 0; i < student.getNumOfGrade(); i++)
            {
                tempCourse = student.getGrade(i).getCourse();

                if(tempCourse.getCourseID().equals(courseID))
                {
                    tempGrade = student.getGrade(i);
                }
            }
            if(tempGrade != null)
            {
                GradeManager.createAssessmentMarks(tempGrade);
            }
            else
            {
                System.out.println("Student " + studentID + " is not taking course " + courseID + ".");
            }
        }
    }

    public void printGrade(String studentID) 
    {
        Student student = getStudent(studentID);
        if (student != null) 
        {   
            if(student.getNumOfGrade() == 0)
            {
                System.out.println("Student has not taken any courses.");
            }
            else
            {
                for(int i=0; i<student.getNumOfGrade(); i++)
                {
                    GradeManager.printGrade(student.getGrade(i));
                }
            }
        } 
    }

}