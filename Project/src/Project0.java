//Xingcheng Huang, 23829649
//Lab Section: CSCI 212 11c

import javax.swing.JOptionPane;
public class Project0 {
	public static void main(String[] args) {
		String sentence;

		while(true) {
			sentence = JOptionPane.showInputDialog(null, "Please enter a sentence or word(s): ");
			if (sentence.equalsIgnoreCase("stop")) {
				JOptionPane.showMessageDialog(null,"Shutdown");
				System.exit(0);
			}


			int counterE = 0;
			int counter_e = 0;
			for (int i = 0; i < sentence.length(); i++) {
				if (sentence.charAt(i) == 'E') counterE += 1;
				if (sentence.charAt(i) == 'e') counter_e += 1;
				if (sentence.contains("stop")) System.exit(0);
			}
			JOptionPane.showMessageDialog(null, "Number of lower case e's: " + counter_e + "\n" + "Number of upper case E's: " + counterE);
		}

	}
}