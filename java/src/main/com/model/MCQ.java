package com.model;


public class MCQ {
	private int Id;

private StringBuffer Question;
private String a;
private String b;
private String c;
private String d;
private String ans;

public StringBuffer getQuestion() {
	return Question;
}

public void setQuestion(StringBuffer question) {
	Question = question;
}
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public MCQ() {
	super();
}

public MCQ(int id, StringBuffer question, String a, String b, String c, String d, String ans) {
	super();
	Id = id;
	Question = question;
	this.a = a;
	this.b = b;
	this.c = c;
	this.d = d;
	this.ans = ans;
}

public String getA() {
	return a;
}
public void setA(String a) {
	this.a = a;
}
public String getB() {
	return b;
}
public void setB(String b) {
	this.b = b;
}
public String getC() {
	return c;
}
public void setC(String c) {
	this.c = c;
}
public String getD() {
	return d;
}
public void setD(String d) {
	this.d = d;
}
public String getAns() {
	return ans;
}
public void setAns(String ans) {
	this.ans = ans;
}
public MCQ(StringBuffer question, String a, String b, String c, String d, String ans) {
	super();
	Question = question;
	this.a = a;
	this.b = b;
	this.c = c;
	this.d = d;
	this.ans = ans;
}

}
