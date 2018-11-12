import java.util.*;

/**
 * Control class for the professor class
 *
 * @author MMZ
 * @version 1.0
 * @since 2018-11-12
 */
public class ProfessorManager extends PeopleManager {
    //private ArrayList<Professor> personList = new ArrayList<Professor>();

    // public boolean haveProf(String profID)
    // {
    // 	for (Professor professor : profList)
    //        {
    //            if (profID.equals(professor.getProfID()))
    //            {
    //                return true;
    //            }
    //        }
    //        return false;
    // }

    // public Professor getProf(String profID)
    // {
    // 	for (Professor professor : profList)
    //        {
    //            if (profID.equals(professor.getProfID()))
    //            {
    //                return professor;
    //            }
    // 	}
    // 	return null;
    // }

    /**
     * Get the person of the professor by providing id of the professor
     *
     * @param profID id of the professor
     * @return professorObject
     */
    public Professor getPerson(String profID) {
        if (super.getPerson(profID) instanceof Professor) {
            return (Professor) super.getPerson(profID);
        }
        return null;
    }

    /**
     * Add a professor into the group of professor
     *
     * @param profID   id of the professor
     * @param profName name of the professor
     */
    public void addPerson(String profID, String profName) {
        Professor prof = new Professor(profID, profName);
        personList.add(prof);
        System.out.println("Add detail information for this professor?(1 : yes, 0 : no): ");
        if (InputHandler.getInt() == 1) {
            addProfDetails(profID);
        }
        System.out.println("Professor " + profID + " successfully added!");
    }

    /**
     * Add the details of the professor
     *
     * @param profID id of the professor
     */
    public void addProfDetails(String profID/*change: Professor prof*/) {
        Professor prof = getPerson(profID);
        System.out.println("Enter gender(male: M; female: F): ");
        prof.setGender(InputHandler.getLine().charAt(0));

        System.out.println("Enter nationality: ");
        prof.setNationality(InputHandler.getLine());

        System.out.println("Enter address: ");
        prof.setAddress(InputHandler.getLine());

        System.out.println("Enter contact number: ");
        prof.setContactNum(InputHandler.getLine());

        System.out.println("Enter email: ");
        prof.setEmail(InputHandler.getLine());

        System.out.println("Enter rank: ");
        prof.setRank(InputHandler.getLine());
    }

    /**
     * Print the list of professors
     */
    public void printList() {
        System.out.println("Professor list------------------------------------------------");
        super.printList();
    }
}