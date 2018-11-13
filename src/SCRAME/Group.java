import java.io.Serializable;

/**
 * Group object for each course that can be of various type, Lecture, Tutorial or Lab
 *
 * @author MMZ
 * @version 1.0
 * @since 2018-11-12
 */
public class Group implements Serializable {
    /**
     * The vacancy count of the Group
     */
    private int vacancy;
    /**
     * The ID of the group
     */
    private String groupID;
    /**
     * The size of the group, maximum capacity of the group
     */
    private int size;
    /**
     * The type of the group: Lecture, Tutorial or Lab
     */
    private String groupType;
    /**
     * The array of the students belongs in the Group
     */
    private Student[] studentList;

    /**
     * Constructor class for the group
     *
     * @param size      maximum capacity of the group
     * @param groupID   id of the group
     * @param groupType the type of the group: Lecture, Tutorial or Lab
     */
    public Group(int size, String groupID, String groupType) {
        this.size = size;
        this.vacancy = size;
        this.groupID = groupID;
        this.groupType = groupType;
        this.studentList = new Student[this.size];
    }

    /**
     * Adding a student into the group
     *
     * @param student student Object to be added
     */
    public void addStudent(Student student) {
        studentList[size - vacancy] = student;
        vacancy--;
    }

    /**
     * Check if the student is in the group
     *
     * @param student studentObject
     * @return boolean: true of the student is in the group
     */
    public boolean haveStudent(Student student) {
        for (int i = 0; i < (size - vacancy); i++) {
            //System.out.println(size - vacancy);
            if (studentList[i].getID().equals(student.getID()))
                return true;
        }
        return false;
    }

    /**
     * Get the vacancy count of the group
     *
     * @return vacancy count
     */
    public int getVacancy() {
        return vacancy;
    }

    /**
     * Get the id of the group
     *
     * @return id of the group
     */
    public String getGroupID() {
        return groupID;
    }

    /**
     * Get the size of the group
     *
     * @return maximum capacity of the group
     */
    public int getGroupSize() {
        return size;
    }

    /**
     * Get the student in the group with the index of the student
     *
     * @param studentIndex index of the student in the group
     * @return StudentObject
     */
    public Student getStudent(int studentIndex) {
        return studentList[studentIndex];
    }

}