public class GroupManager{
	public static Group createGroup(int size, String type){
		System.out.println("Input ID for " + type + " group: ");
		String tempID = InputHandler.getLine();
		return new Group(size, tempID, type);
	}
}