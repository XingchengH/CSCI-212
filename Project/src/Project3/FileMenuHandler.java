package Project3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class FileMenuHandler implements ActionListener {
   Date212GUI dategui;
   TextArea sorted;
   TextArea unsorted;
   TextArea invalid;
   
   public FileMenuHandler (Date212GUI dg, TextArea s, TextArea us, TextArea iv) { // constructor
      dategui = dg;
      sorted = s;
      unsorted = us;
      invalid = iv;
   }
   
   public void actionPerformed(ActionEvent event) {
      String menuName = event.getActionCommand();
      // if open is clicked, it will open a file menu
      if (menuName.equals("Open"))
			openFile(dategui);
      
	else if (menuName.equals("Quit"))
         // if quit is clicked, the program will end
          System.exit(0); 
      
   } //actionPerformed
   
   public void openFile(Date212GUI dg){
	      JFileChooser chooser = new JFileChooser();
	      chooser.showOpenDialog(null);
	      String filename = (chooser.getSelectedFile()).getName();
	      // it will read the chosen file and send it to print it onto the gui
			try {
				Date212GUI.printFileToGUI(readFile(filename), dg, sorted, unsorted, invalid);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  
	   }
   
	public static String[] readFile(String filename) throws IOException {
		//method will read am inputed file and
		//use StringTokenizer class to read dates
		int counter = 0;
		int tokenCounter = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));	
		String line = br.readLine();
		while (line != null) {
			//count the amount tokens in file
			StringTokenizer token = new StringTokenizer(line, ",");
			tokenCounter += token.countTokens();
			line = br.readLine();
		}
		
		String[]dates = new String[tokenCounter];
		BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));	
		String line2 = file.readLine();

		while(line2 != null) {
			// takes each token on a given line and puts it in a string array
			StringTokenizer token2 = new StringTokenizer(line2, ",");
			while (token2.hasMoreTokens()) {
				dates[counter++] = token2.nextToken();
			} 
			line2 = file.readLine();
		} 

		return dates;
	}

}