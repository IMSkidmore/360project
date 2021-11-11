package application;

public class Parser {

	public static int stringToInt(String str) {
		return 0;
	}
	public static String intToString(int num) {
		return "suace";
	}
	public static Boolean checkIfInt(String str) {
		return false;
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
