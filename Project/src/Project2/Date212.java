package Project2;

public class Date212 {
	private int year;
	private int month;
	private int day;

	public Date212(String s){
		//substring(beginning, end), picked the values form the length
		//Separate the String into date, month and year
		year = Integer.parseInt(s.substring(0, 4));
		month = Integer.parseInt(s.substring(4, 6));
		day = Integer.parseInt(s.substring(6, 8));
	} //Constructor

	public void setDate212(String s) {
		//Set String to a Date212 object
		year = Integer.parseInt(s.substring(0, 4));
		month = Integer.parseInt(s.substring(4,6));
		day = Integer.parseInt(s.substring(6, 8));
	} // close setDate212

	public String getDate212() {
		String date = "" + year;
		//if the month and day is single digit, add a 0 before it.
		if (month < 10) date = date + "0" + month;
		else date += month;
		if(day < 10) date = date + "0" + day;
		else date += day;
		return date;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public void setYear(int y) {
		year = y;
	}

	public void setMonth(int m) {
		month = m;
	}

	public void setDay(int d) {
		day = d;
	}

	public String toString(Date212 date) {
		//Take Date212 object
		//Assigns the name of months as String
		String[]monthArray = {"January", "February", "March", "April", "May", "June",
				"July", "August", "September", "October", "November",
		"December"};
		String output = monthArray[month - 1] + " " + day + ", " + year;
		return output;
	}
	
	//Check if two string are equal
	public boolean same(Object other) {
		return (other != null &&
				getClass() == other.getClass() &&
				getDate212().equals(((Date212) other).getDate212()));
	}
	//Compares this and other by convert them into String
	public int comapreTo(Date212 other) {
		String s = this.getDate212();
		return s.compareTo(other.getDate212());
	}

}
