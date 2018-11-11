public enum GroupType{
    LECTURE("lecture", 0), LAB("lab", 1),TUTORIAL("tutorial", 2);

    private String name;
    private final int index;
    private GroupType(String name, int index) {
    	this.index = index;
    	this.name = name;
    };
    public int getIndex() {
        return index;
    };
    public String toString() {
    	return name;
    };

}