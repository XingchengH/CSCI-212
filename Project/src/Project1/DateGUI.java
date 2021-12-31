package Project1;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.util.Arrays;
import javax.swing.*;

public class DateGUI extends JFrame { 
	public static int[] sortDates(String[] list) {
		//Sort the date
		int[] sortedDates = new int[list.length];
		for(int i = 0; i < list.length; i++) {
			sortedDates[i] = Integer.parseInt(list[i]);
		}
		Arrays.sort(sortedDates);
		return sortedDates;
	}


	public static void printDatesToGUI(DateGUI myGUI, String[] list) {
		//initialize the GUI and display the string of dates
		//and the dates converted by the toString()
		myGUI = new DateGUI();
		myGUI.setSize(500, 500);
		myGUI.setLocation(500, 200); //display the screen in the center
		myGUI.setLayout(new GridLayout(1, 2));
		myGUI.setTitle("Dates");
		myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container myContentPane = myGUI.getContentPane();
		TextArea myDates = new TextArea();
		TextArea mySubscripts = new TextArea();
		myContentPane.add(mySubscripts);
		myContentPane.add(myDates);
		
		//Array which will have the sorted Dates
		String[] sorted = new String[list.length];
		for (int i = 0; i < list.length; i++) {
			sorted[i] = String.valueOf(sortDates(list)[i]);
		}
		//Add the sorted Dates to the left of the GUI
		for (int i = 0; i < list.length; i++) {
			mySubscripts.append(sorted[i] + "\n");
		}
		//Add and converted toString to the right of GUI
		for (int i = 0; i < list.length; i++) {
			Date212 date = new Date212(sorted[i]);
			myDates.append(date.toString(date) + "\n");
		}

		myGUI.setVisible(true);
	}
}
