import java.util.*;
import java.io.Serializable;

public class PeopleManager implements Serializable{

	protected ArrayList<Person> personList = new ArrayList<Person>();

	public Person getPerson(String ID)
	{
		for(Person person : personList)
        {
            if(ID.equals(person.getID()))
            {
                return person;
            }
        }
        return null;
	}

	public boolean havePerson(String ID)
    {
        for(Person person : personList)
        {
            if(ID.equals(person.getID()))
            {
                return true;
            }
        }
        return false;
    }

	public void addPerson(String ID, String Name)
	{
		Person person = new Person(ID, Name);
        personList.add(person);
	}

	public void printList()
	{
		Person person;
        for (int i=0; i<personList.size(); i++){
        	person = personList.get(i);
            System.out.println("ID: " +  person.getID() + "   " + "Name: " + person.getName());
        }
	}

}