package com.model;

public class Student {
	
 private	String prn,name,lname;

public Student() {
	super();
}

public Student(String prn, String name, String lname) {
	super();
	this.prn = prn;
	this.name = name;
	this.lname = lname;
}

public String getPrn() {
	return prn;
}

public void setPrn(String prn) {
	this.prn = prn;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getLname() {
	return lname;
}

public void setLname(String lname) {
	this.lname = lname;
}
	
	
	

}
