package Project1;

import java.util.StringTokenizer;
import java.io.*; 

public class Project1 {
	static DateGUI myGUI;

	public static void main(String[] args) throws IOException {
		DateGUI.printDatesToGUI(myGUI, readFile(args[0]));

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
}//close project1

