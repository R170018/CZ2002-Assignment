//package SCRAME;

import java.io.Serializable;

/**
 * Represents a person with all the relevant information of the person
 *
 * @author MMZ
 * @version 1.0
 * @since 2018-11-12
 */

public class Person implements Serializable {
    /**
     * The ID of the user
     */
    private String ID = null;

    /**
     * The first and last name of the person
     */
    private String name = null;

    /**
     * The gender of the person
     */
    private char gender = 'N';

    /**
     *  The nationaity of the person
     */
    private String nationality = null;

    /**
     * The residential address of the person
     */
    private String address = null;

    /**
     * The contact phone number of the person
     */
    private String contactNum = null;

    /**
     * The email of the person
     */
    private String email = null;

    /**
     * Creates a new person with the given ID and name
     *
     * @param ID The ID of the person
     * @param name The name of the person
     */
    public Person(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    /**
     * Gets the ID of the person
     * @return ID of the person
     */
    public String getID() {
        return ID;
    }

    /**
     * Sets the name of the person
     * @param name name of the person
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the name of the person
     * @return the name of person
     */
    public String getName() {
        return name;
    }

    /**
     * Set the ID of the person
     * @param ID new ID of the person
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Set the gender of the person
     * @param gender new gender of the person
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

    /**
     * Set the nationality of the person
     * @param nationality nationality of the person
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     *  Set the address of the person
     * @param address residential address of the person
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Set the contact number of the person
     * @param contactNum contact number of the person
     */
    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    /**
     * Set the email of the person
     * @param email email of the person
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the gender of the person
     * @return gender of the person
     */
    public char getGender() {
        return gender;
    }

    /**
     * Get the nationality of the person
     * @return nationality of the person
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Get the residential address of the person
     * @return residential address of the person
     */
    public String getAddress() {
        return address;
    }

    /**
     * Get the contact number of the person
     * @return contact number of the person
     */
    public String getContactNum() {
        return contactNum;
    }

    /**
     * Get the email of the person
     * @return email of the person
     */
    public String getEmail() {
        return email;
    }


}
