import java.util.*;
//import java.io.Serializable;

public class StudentManager extends PeopleManager
{   
    //private ArrayList<Student> studentList = new ArrayList<Student>();

    // public Student getStudent(String studentID) 
    // {
    //     for(Student student : studentList)
    //     {
    //         if(studentID.equals(student.getStudentID()))
    //         {
    //             return student;
    //         }
    //     }
    //     return null;
    // }

    // public boolean haveStudent(String studentID)
    // {
    //     for(Student student : studentList)
    //     {
    //         if(studentID.equals(student.getStudentID()))
    //         {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    public Student getPerson(String studentID){
        if(super.getPerson(studentID) instanceof Student){
            return (Student) super.getPerson(studentID);
        }
        return null;
    }

    public void addPerson(String studentID, String studentName)
    {
        Student student = new Student(studentID, studentName);
        personList.add(student);
    
        System.out.println("Add detail information for this student?(1 : yes, 0 : no): ");
        if(InputHandler.getInt() == 1){
            addStudentDetails(studentID);
        }
        System.out.println("Student " + studentID + " successfully added!");
    }

    public void addStudentDetails(String studentID/*change: Student student*/)
    {   
        Student student = getPerson(studentID);
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

        System.out.println("Is student studying full-time or part-time? (F/P)");
        student.setTypeOfStudy('F' == InputHandler.getLine().charAt(0));

        System.out.println("Is student a graduate or an undergraduate? (G/U)");
        student.setStudentType('U' == InputHandler.getLine().charAt(0));

        System.out.println("Student Year for Student? (e.g. 2018)");
        student.setStudyYear(InputHandler.getInt());
    }


    public void printList() 
    {
        System.out.println("Student list----------------------------");
        super.printList();
    }

    public void setMark(String studentID, String courseID) 
    {
        Student student = getPerson(studentID);
        if(student != null)
        {   
            Grade tempGrade = null;
            Course tempCourse;
            for(int i = 0; i < student.getNumOfGrade(); i++)
            {
                tempCourse = student.getGradeByIndex(i).getCourse();

                if(tempCourse.getCourseID().equals(courseID))
                {
                    tempGrade = student.getGradeByIndex(i);
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
        Student student = getPerson(studentID);
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
                    GradeManager.printGrade(student.getGradeByIndex(i));
                }
            }
        } 
    }

     // print 1 student info
    public static void printStudentInfo(Student student) 
    {   
        if(student == null){return;}
        System.out.println("StudentID: " +  student.getID() + "   " + "Name: " + student.getName()+" Type of study: "+student.getTypeOfStudy()+ "Type of Student:" +student.getStudentType()+ "Year of Study: "+student.getStudyYear());
    }

}