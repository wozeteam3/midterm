package com.t3.midterm;

public class Attendance {
	int emp_id;
	int tardys;
	int absents;
	int excusedAbsent;
	int excusedTardy;
	
	public Attendance(int id, int tardys, int absents, int eAbsents, int eTardys) {
		this.emp_id=id;
		this.tardys=tardys;
		this.absents=absents;
		this.excusedAbsent=eAbsents;
		this.excusedTardy=eTardys;
	}
	
	public int getTardys() {
		return tardys;
	}
	public void setTardys(int tardys) {
		this.tardys = tardys;
	}
	public int getAbsents() {
		return absents;
	}
	public void setAbsents(int absents) {
		this.absents = absents;
	}
	public int getExcusedAbsent() {
		return excusedAbsent;
	}
	public void setExcusedAbsent(int excusedAbsent) {
		this.excusedAbsent = excusedAbsent;
	}
	public int getExcusedTardy() {
		return excusedTardy;
	}
	public void setExcusedTardy(int excusedTardy) {
		this.excusedTardy = excusedTardy;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
}
