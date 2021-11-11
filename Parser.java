package application;

public class Parser {

	public static int stringToInt(String str) {
		int ret = Integer.parseInt(str);
		return ret;
	}
	public static String intToString(int num) {
		String ret = Integer.toString(num);
		return ret;
	}
	public static Boolean checkIfInt(String str) {
		try {
		       Integer.parseInt(str);
		       return true;
		    }
		    catch(NumberFormatException e){
		        return false;
		    }
	}
	public static Patient lineToPatient(String str) {
		String[] array = new String[6];
        array=str.split(",");
        return new Patient(array[0], array[1], array[2], array[3], array[4], array[5]);
	}
	public static String[] lineToHistoryArray(String str) {
		String[] array = new String[12];
		array=str.split(",");
		return array;
	}
}
