/**
 * Professor Class that contains all the information pertaining to a professor
 *
 * @author MMZ
 * @version 1.0
 * @since 2018-11-12
 */
public class Professor extends Person {
    /**
     * The rank of the professor
     */
    private String rank;

    /**
     * Constructor class for professor
     *
     * @param profID   id of the professor
     * @param profName name of the professor
     */
    public Professor(String profID, String profName) {
        super(profID, profName);
    }

    /**
     * Set the rank of the professor
     *
     * @param rank rank to be picked
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     * Get the rank of the professor
     *
     * @return string rank of the professor
     */
    public String getRank() {
        return rank;
    }
}