package Project3;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Date212GUI extends JFrame { 

	public static Date212GUI initiateGUI(Date212GUI myGUI) {
		//initialize the GUI and display the string of dates
		myGUI = new Date212GUI();
		myGUI.setSize(500, 500);
		myGUI.setLocation(500, 200); //display the screen in the center
		myGUI.setLayout(new GridLayout(1, 3));
		myGUI.setTitle("Dates");
		myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container myContentPane = myGUI.getContentPane();
		TextArea sorted = new TextArea();
		TextArea unsorted = new TextArea();
		TextArea invalid = new TextArea();
		myContentPane.add(sorted);
		myContentPane.add(unsorted);
		myContentPane.add(invalid);
		sorted.append("==Sorted Dates==" + "\n");
		unsorted.append("==Unsorted Dates==" + "\n");
		invalid.append("==Invalid Dates==" + "\n");
		
		JMenuBar menuBar = new JMenuBar();
		myGUI.createFileMenuBar(menuBar, sorted, unsorted, invalid);
		myGUI.setVisible(true);
		return myGUI;
	}
	
	   public void createFileMenuBar(JMenuBar menuBar, TextArea sorted, TextArea unsorted, TextArea invalid) {
		      // creates a file menuBar
		      JMenuItem item1;
		      JMenu fileMenu = new JMenu("File");
		      
		      // FileMenuHandler will pass the sorted and unsorted text areas so it
		      // can append the values once a file is picked
		     
		      FileMenuHandler fmh = new FileMenuHandler(this, sorted, unsorted, invalid);
		      item1 = new JMenuItem("Open");
		      item1.addActionListener(fmh);
		      fileMenu.add(item1);
		      fileMenu.addSeparator();
		      JMenuItem item2 = new JMenuItem("Quit");
		      item2.addActionListener(fmh);
		      fileMenu.add(item2);
		      
		      setJMenuBar(menuBar);
		      menuBar.add(fileMenu);
		   }	
	   
	public static void printFileToGUI(String[] list, Date212GUI dg, TextArea sorted, TextArea unsorted, TextArea invalid){
		
		TreeMap<Integer, Date212> mySortedDateMap = new TreeMap<Integer, Date212>();
		//UnsortedDate212List myUnsortedDateList = new UnsortedDate212List();
		
		for (int i = 0; i < list.length; i++) {
			if(isValid(list[i]))
			mySortedDateMap.put(Integer.parseInt(list[i]), new Date212(list[i]));
			//myUnsortedDateList.add(new Date212(list[i]));
		}
		
		sorted.setText("==Sorted Dates== " + "\n");
		//through the treemap and prints it on sorted Textarea
		Set<Entry<Integer, Date212>> set = mySortedDateMap.entrySet();
		Iterator<Entry<Integer, Date212>> i = set.iterator();
		Map.Entry<Integer, Date212> me;
		while(i.hasNext()) {
			me = (Entry<Integer, Date212>) i.next();
			sorted.append((me.getValue()).toString(me.getValue()) + "\n");
		}
		//appends the dates to unsorted/invalid textare on gui
		unsorted.setText("==Unsorted Dates== " + "\n");
		invalid.setText("==Invalid Dates== " + "\n");
		for (int c = 0; c < list.length; c++) {
			if(isValid(list[c]) == false) {
				invalid.append(list[c] + "\n");
			}else {
				unsorted.append(list[c] + "\n");
			}
		}		
		
	}
	
	private static boolean isValid(String s) {
		//See if a date is a valid date
		if(s.length() != 8) return false;
		int m = Integer.parseInt(s.substring(4,6));
		if(m < 1 || m > 12) return false;
		int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if (Integer.parseInt(s.substring(6, 8)) < 1 || Integer.parseInt(s.substring(6, 8)) > daysInMonth[m - 1]) return false;
		return true;
		}

}
