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
		list = new ArrayList<String>();
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
	public String getComp() {
		return comp;
	}
	public void setComp(String comp) {
		this.comp = comp;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
}
