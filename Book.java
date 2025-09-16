import java.util.*;
public class Book{
	String bookName;
	int bookId;
	String bookAuthor;
	boolean bookAvailable;
	private String issuedTo;
	
	
	public Book(String bookName, int bookId, String bookAuthor){
		this.bookName=bookName;
		this.bookId=bookId;
		this.bookAuthor=bookAuthor;
		this.bookAvailable=true;
		this.issuedTo=null;
	}
	public void setBookName(String bookName){
		this.bookName=bookName;
	}
	public void setBookId(int bookId){
		this.bookId=bookId;
	}
	public void setBookAuthor(String bookAuthor){
		this.bookAuthor=bookAuthor;
	}
	public void setBookAvailable(boolean bookAvailable) {
    this.bookAvailable = bookAvailable;
	}
	public String getBookName(){
		return bookName;
	}
	public int getBookId(){
		return bookId;
	}
	public String getBookAuthor(){
		return bookAuthor;
	}
	public boolean getBookAvailable(){
		return bookAvailable;
	}
	public void setIssuedTo(String name) {
    this.issuedTo = name;
	}
    public String getIssuedTo() {
        return issuedTo;
    }

	public void display() {
        System.out.println("Book Name: " + bookName +
                           ", Book ID: " + bookId +
                           ", Author: " + bookAuthor +
                           ", Available: " + bookAvailable);
    }
}