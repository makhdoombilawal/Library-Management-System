import java.util.*;
public class Student{
	private String name;
	private int rollNo;
		
	public Student(String name, int rollNo){
		this.name=name;
		this.rollNo=rollNo;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setRollno(int rollNo){
		this.rollNo=rollNo;
	}
	public String getName(){
		return name;
	}
	public int getRollNo(){
		return rollNo;
	}
	public void displayStudentInfo(){
		System.out.print("Name: " + name +
						"\nRoll No: "	+ rollNo);
	}
}