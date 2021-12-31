package Project2;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JFrame;

public class Date212GUI extends JFrame { 

	public static void printDatesToGUI(Date212GUI myGUI, String[] list) {
		//initialize the GUI and display the string of dates
		myGUI = new Date212GUI();
		myGUI.setSize(500, 500);
		myGUI.setLocation(500, 200); //display the screen in the center
		myGUI.setLayout(new GridLayout(1, 2));
		myGUI.setTitle("Dates");
		myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container myContentPane = myGUI.getContentPane();
		TextArea sorted = new TextArea();
		TextArea unsorted = new TextArea();
		myContentPane.add(sorted);
		myContentPane.add(unsorted);
		sorted.append("Sorted Dates:" + "\n");
		unsorted.append("Unsorted Dates:" + "\n");

		Date212GUI.printDataToGui(list, sorted, unsorted);
		myGUI.setVisible(true);
	}
	
	public static void printDataToGui(String[] list, TextArea sorted, TextArea unsorted){
		//Through the list of dates
		//add to sorted and unsorted linked lists
		SortedDate212List mySortedDateList = new SortedDate212List();
		UnsortedDate212List myUnsortedDateList = new UnsortedDate212List();
		
		for (int i = 0; i < list.length; i++) {
			mySortedDateList.add(new Date212(list[i]));
			myUnsortedDateList.add(new Date212(list[i]));
		}

		//appends the linked list to the sorted textarea on the gui
		Date212Node pointer1 = mySortedDateList.first.next;
		while(pointer1 != null) {
			sorted.append((pointer1.data).toString(pointer1.data) + "\n");
			pointer1 = pointer1.next;
		}

		//appends the linked list to the unsorted textarea on the gui
		Date212Node pointer2 = myUnsortedDateList.first.next;
		while(pointer2 != null) {
			unsorted.append((pointer2.data).toString(pointer2.data) + "\n");
			pointer2 = pointer2.next;
		}

	}
	

}
