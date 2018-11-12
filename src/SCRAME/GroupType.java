/**
 * Enum for Group Type: Lecture, Lab or Tutorial
 *
 * @author MMZ
 * @version 1.0
 * @since 2018-11-12
 */
public enum GroupType{
    LECTURE("lecture", 0), LAB("lab", 1),TUTORIAL("tutorial", 2);

    /**
     * name of GroupType
     */
    private String name;
    /**
     * Index of GroupType
     */
    private final int index;
    /*
    Constructor for groupType
     */
    private GroupType(String name, int index) {
    	this.index = index;
    	this.name = name;
    }
    /**
     * Get index of groupType
     * @return index of the groupType
     */
    public int getIndex() {
        return index;
    }

    /**
     * Get the name of group type
     * @return name of GroupType
     */
    public String toString() {
    	return name;
    }

}