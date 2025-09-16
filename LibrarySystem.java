import java.util.*;
class LibrarySystem{
	private Student[] students = new Student[10];
	private int studentCount=0;
	private Book[] books = new Book[10];
    private int count = 0;

    protected AdminPanel admin = new AdminPanel();

    public LibrarySystem() {
        books[count] = new Book("Java Basics", 1, "James Gosling");
        books[count+1] = new Book("C++ Primer", 2, "Stanley Lippman");
        books[count+2] = new Book("Python Crash Course", 3, "Eric Matthes");
		count=3;
    }
	
	public void addBook(Book book) {
        if (count < books.length) {
            books[count++] = book;
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Book storage full.");
        }
    }
	
	public void displayBooks() {
        if (count == 0) System.out.println("No books available.");
        else {
            for (int i = 0; i < count; i++){ 
					books[i].display();
			}
        }
    }
	
	 public void deleteBook(int id) {
        for (int i = 0; i < count; i++) {
            if (books[i].getBookId() == id) {
                for (int j = i; j < count - 1; j++){ 
						books[j] = books[j + 1];
				}
                books[count--] = null;
                System.out.println("Book deleted.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void updateBook(int id, String name, int newId, String author) {
        for (int i = 0; i < count; i++) {
            if (books[i].getBookId() == id) {
                books[i] = new Book(name, newId, author);
                System.out.println("Book updated.");
                return;
            }
        }
        System.out.println("Book not found.");
    }
	public void issueBook(int id, String studentName) {
        for (int i = 0; i < count; i++) {
            if (books[i].getBookId() == id) {
                if (books[i].getBookAvailable()) {
                    books[i].setBookAvailable(false);
                    books[i].setIssuedTo(studentName);
                    System.out.println("Book issued to: " + studentName);
                } else {
                    System.out.println("Already issued to: " + books[i].getIssuedTo());
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(int id, String studentName) {
        for (int i = 0; i < count; i++) {
            if (books[i].getBookId() == id) {
                if (!books[i].getBookAvailable()) {
                    books[i].setBookAvailable(true);
                    books[i].setIssuedTo(null);
                    System.out.println("Book returned successfully from: " + studentName);
                } else {
                    System.out.println("Book was not issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }
	public void showIssuedBooks() {
        boolean any = false;
        for (int i = 0; i < count; i++) {
            if (!books[i].getBookAvailable()) {
                books[i].display();
				System.out.println("Book Issued To: " + books[i].getIssuedTo());
				System.out.println("Book Id: " + books[i].getBookId());
                any = true;
            }
        }
        if (!any) System.out.println("No books issued.");
		System.out.println();
    }
	public Student registerStudent(String name, int rollno){
    Student student = null;
	
	if (name.isEmpty() || rollno < 0) {
		System.out.println("Invalid input.");
		return null;
	}

    for (int i = 0; i < studentCount; i++) {
        if (students[i].getRollNo() == rollno) {
            student = students[i];
            System.out.println("Student already registered.");
            return student;
        }
    }

    if (studentCount < 10) {
        student = new Student(name, rollno);
        students[studentCount++] = student;
        System.out.println("New student registered.");
        return student;
    } else {
        System.out.println("Student limit reached.");
        return null;
    }
}
	public void showStudentInfo() {
    System.out.println("\n--- Registered Students ---");
    if (studentCount == 0) {
        System.out.println("No students registered.");
        return;
    }

    for (int i = 0; i < studentCount; i++) {
        students[i].displayStudentInfo();
        System.out.println(); 
    }
	
}
 
}
