//package SCRAME;

import java.util.*;
import java.io.Serializable;

/**
 * Course class of certain course id
 *
 * @author MMZ
 * @version 1.0
 * @since 2018-11-12
 */
public class Course implements Serializable {
    /**
     * Id of the course
     */
    private String courseID;
    /**
     * Name of the course
     */
    private String courseName;
    /**
     * Number of students capacity for the course
     */
    private int courseCapacity;
    /**
     * Number of lecture groups
     */
    private int lecGroupNum;
    /**
     * Number of lab groups
     */
    private int labGroupNum;
    /**
     * Number of tutorial groups
     */
    private int tutGroupNum;
    /**
     * The List of lecture groups
     */
    private Group[] lecGroupList;
    /**
     * The List of Lab Groups
     */
    private Group[] labGroupList;
    /**
     * The list of tutorial group
     */
    private Group[] tutGroupList;
    /**
     * The arrayList of the professor
     */
    private ArrayList<Professor> profList = new ArrayList<Professor>();
    /**
     * The Assessment of the course
     */
    private Assessment assessment;

    /**
     * Constructor of the course
     *
     * @param courseID   id of the course
     * @param courseName name of the course
     */
    public Course(String courseID, String courseName) {
        this.courseName = courseName;
        this.courseID = courseID;
        assessment = new Assessment("Overall");
    }

    /**
     * Get the id of course
     *
     * @return id of course
     */
    public String getCourseID() {
        return courseID;
    }

    /**
     * Get name of course
     *
     * @return name of course
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Get number of professors
     *
     * @return number of professors in charge
     */
    public int getProfNum() {
        return profList.size();
    }

    /**
     * Get the professor of the course
     *
     * @param index index of professor
     * @return professor
     */
    public Professor getProf(int index) {
        return profList.get(index);
    }

    /**
     * Get the assessment of the course
     *
     * @return assessment object
     */
    public Assessment getAssessment() {
        return assessment;
    }

    //change

    /**
     * Add professor into the course
     *
     * @param prof professor object
     */
    public void addProf(Professor prof) {
        if (prof != null) {
            profList.add(prof);
        }
    }

    /**
     * Set the course capacity of course
     *
     * @param courseCapacity capacity of course
     */
    public void setCourseCapacity(int courseCapacity) {
        this.courseCapacity = courseCapacity;
    }

    /**
     * Get the capacity of the course
     *
     * @return capacity of the course
     */
    public int getCourseCapacity() {
        return this.courseCapacity;
    }

    /**
     * Get the number of a certain group
     *
     * @param type type of group
     * @return the group number
     */
    public int getGroupNum(GroupType type) {
        switch (type) {
            case LECTURE:
                return lecGroupNum;
            case LAB:
                return labGroupNum;
            case TUTORIAL:
                return tutGroupNum;
        }
        return 0;
    }

    /**
     * Set the group
     *
     * @param index index of group
     * @param group group object
     * @param type  type of group
     */
    public void setGroup(int index, Group group, GroupType type) {
        if (index >= getGroupNum(type) || index < 0) {
            return;
        }
        switch (type) {
            case LECTURE:
                lecGroupList[index] = group;
                break;
            case LAB:
                labGroupList[index] = group;
                break;
            case TUTORIAL:
                tutGroupList[index] = group;
                break;
        }
    }

    /**
     * Create the group list
     *
     * @param groupNum number of groups
     * @param type     type of group
     */
    public void createGroupList(int groupNum, GroupType type) {
        switch (type) {
            case LECTURE:
                this.lecGroupNum = groupNum;
                if (groupNum != 0) {
                    this.lecGroupList = new Group[lecGroupNum];
                }
                break;
            case LAB:
                this.labGroupNum = groupNum;
                if (groupNum != 0) {
                    this.labGroupList = new Group[labGroupNum];
                }
                break;
            case TUTORIAL:
                this.tutGroupNum = groupNum;
                if (groupNum != 0) {
                    this.tutGroupList = new Group[tutGroupNum];
                }
                break;
        }

    }

    /**
     * Get the group by index
     *
     * @param type  type of group
     * @param index index of group
     * @return group object
     */
    public Group getGroupByIndex(GroupType type, int index) {
        if (index >= getGroupNum(type) || index < 0) {
            return null;
        }
        switch (type) {
            case LECTURE:
                return lecGroupList[index];
            case LAB:
                return labGroupList[index];
            case TUTORIAL:
                return tutGroupList[index];
            default:
                return null;
        }
    }

    /**
     * Check if there is group of that id
     *
     * @param groupType type of group
     * @param groupID   Id of group
     * @return true if group of that index exists
     */
    public Boolean haveGroup(GroupType groupType, String groupID) {
        //get the target groupList from the target course
        Group grp;
        for (int i = 0; i < getGroupNum(groupType); i++) {
            grp = getGroupByIndex(groupType, i);
            if (groupID.equals(grp.getGroupID())) return true;
        }
        return false;
    }

    /**
     * Get the group by the group id
     *
     * @param groupType type of group
     * @param groupID   id of group
     * @return group object
     */
    public Group getGroupByID(GroupType groupType, String groupID) {
        //get the target groupList from the target course
        Group grp;
        for (int i = 0; i < getGroupNum(groupType); i++) {
            grp = getGroupByIndex(groupType, i);
            if (groupID.equals(grp.getGroupID())) return grp;
        }
        return null;
    }

    /**
     * Check if certain group type exist
     *
     * @param groupType type of group
     * @return true if the grouptype exists
     */
    public Boolean haveGroupType(GroupType groupType) {
        return (getGroupNum(groupType) > 0);
    }

    /**
     * Get the vacancy number of certain group
     *
     * @param groupType type of group
     * @param groupID   id of group
     * @return vacancy number of group
     */
    public int getGroupVacancy(GroupType groupType, String groupID) {
        Group grp = getGroupByID(groupType, groupID);

        if (grp != null) {
            return grp.getVacancy();
        }
        return -1;
    }

    /**
     * Get the Size of the group
     *
     * @param groupType type of group
     * @param groupID   id of group
     * @return size of the group
     */
    public int getGroupSize(GroupType groupType, String groupID) {
        Group group = getGroupByID(groupType, groupID);
        if (group != null) {
            return group.getGroupSize();
        }
        return -1;
    }
}