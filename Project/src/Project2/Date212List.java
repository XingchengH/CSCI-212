package Project2;

public class Date212List {
	//variables
	protected Date212Node first = new Date212Node(null);
	protected Date212Node last = first;
	protected int length = 0;
	
	public Date212List() { //parameterless constructor
		
	}
	
	public int getLength() {
		//return length to DateList
		return length;
	}
	
	public void append(Date212 d) {
		//append the DateNode to the end of the DateLists
		Date212Node n = new Date212Node(d);
		last.next = n;
		last = n;
		n.next = null;
		length++;
	}
	
}
