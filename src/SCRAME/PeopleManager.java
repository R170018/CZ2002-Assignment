import java.util.*;
import java.io.Serializable;

/**
 * Control class for Person
 *
 * @author MMZ
 * @version 1.0
 * @since 2018-11-12
 */
public class PeopleManager implements Serializable {

    /**
     * List of Person
     */
    protected ArrayList<Person> personList = new ArrayList<Person>();

    /**
     * Get the person object based on the id of the person
     *
     * @param ID id of person
     * @return PersonObject of the id
     */
    public Person getPerson(String ID) {
        for (Person person : personList) {
            if (ID.equals(person.getID())) {
                return person;
            }
        }
        return null;
    }

    /**
     * Check if the array of people contains the person identified by id
     *
     * @param ID id of the person
     * @return boolean, true if the array contains the person
     */
    public boolean havePerson(String ID) {
        for (Person person : personList) {
            if (ID.equals(person.getID())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Add person into the array of person
     *
     * @param ID   id of the person
     * @param Name name of the person
     */
    public void addPerson(String ID, String Name) {
        Person person = new Person(ID, Name);
        personList.add(person);
    }

    /**
     * Print the array of person
     */
    public void printList() {
        Person person;
        for (int i = 0; i < personList.size(); i++) {
            person = personList.get(i);
            System.out.println("ID: " + person.getID() + "   " + "Name: " + person.getName());
        }
    }

}