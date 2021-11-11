package application;

import java.util.ArrayList;
import java.util.List;

public class Pharmacy {
	private String comp, add, num;
	private List<String> list;
	public Pharmacy() {
		comp = "";
		add = "";
		num = "";
	}
	public Pharmacy(String name, String address, String phoneNumber) {
		comp = name;
		add = address;
		num = phoneNumber;
		list = new ArrayList<String>();
	}
	public void setPrescription(String pres) {
		list.add(pres);
	}
}
