package Project2;

public class SortedDate212List extends Date212List {
	
	public SortedDate212List() {
		super();
	}

	public void add(Date212 d) {
		Date212Node current = first;
		Date212Node pointer = first.next;
		Date212Node date = new Date212Node(d);

		if (length == 0) {
			//if there is nothing in the linked list
			//append
			append(d);
			return;
		}
		else if(Integer.parseInt(d.getDate212()) >= Integer.parseInt((last.data).getDate212())) {
			//if d is the largest date, append
			append(d);
		}
		else {
			while (Integer.parseInt(d.getDate212()) >= Integer.parseInt((pointer.data).getDate212())) {
				//when d is larger than pointer
				//to the next pointer and move current
				current = pointer;
				pointer = pointer.next;
			}
			current.next = date;
			current.next.next = pointer;
			length++;
		}

	}
	
	

}