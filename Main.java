import java.util.*;
public class Main{
    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);
        LibrarySystem library = new LibrarySystem();
		
        while(true){
			try{
            System.out.println("=== Welcome To Library! ===");
            System.out.println("1. Admin Login");
            System.out.println("2. Student");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(input.nextLine());

            switch(choice) {
                case 1:
                    System.out.print("Enter Admin Name: ");
                    String adminName = input.nextLine();
                    System.out.print("Enter Admin ID: ");
                    int adminId = Integer.parseInt(input.nextLine());

                    if (library.admin.isValidAdmin(adminName, adminId)) {
                        System.out.println("Admin Login Successful!");
                        boolean back = false;
                        while (!back) {
                            System.out.println("--- Admin Panel ---");
                            System.out.println("1. Add Book");
                            System.out.println("2. Delete Book");
                            System.out.println("3. Update Book");
                            System.out.println("4. Display Books");
                            System.out.println("5. Show Issued Books");
                            System.out.println("6. Show Students");
                            System.out.println("7. Logout ");
							
                            System.out.print("Choice: ");
                            int adminChoice = Integer.parseInt(input.nextLine());

                            switch (adminChoice) {
                                case 1:
                                    System.out.print("Book Name: ");
                                    String name = input.nextLine();
                                    System.out.print("Book ID: ");
                                    int id = Integer.parseInt(input.nextLine());
                                    System.out.print("Author: ");
                                    String author = input.nextLine();
                                    library.addBook(new Book(name, id, author));
                                    break;
                                case 2:
                                    System.out.print("Enter Book ID to delete: ");
                                    int deleteId = Integer.parseInt(input.nextLine());
                                    library.deleteBook(deleteId);
                                    break;
                                case 3:
                                    System.out.print("Enter Book ID to update: ");
                                    int updateId = Integer.parseInt(input.nextLine());
                                    System.out.print("New Name: ");
                                    String newName = input.nextLine();
                                    System.out.print("New ID: ");
                                    int newBookId = Integer.parseInt(input.nextLine());
                                    System.out.print("New Author: ");
                                    String newAuthor = input.nextLine();
                                    library.updateBook(updateId, newName, newBookId, newAuthor);
                                    break;
                                case 4:
                                    library.displayBooks();
                                    break;
                                case 5:
                                    library.showIssuedBooks();
                                    break;
								case 6:
									library.showStudentInfo();
									break;

                                case 7:
                                    back = true;
                                    break;
                                default:
                                    System.out.println("Invalid option.");
                            }
                        }
                    } else {
                        System.out.println("Invalid Admin Id Or Name!.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Student Name: ");
                    String stuName = input.nextLine().toUpperCase();
                    System.out.print("Enter Roll No: ");
                    int roll = Integer.parseInt(input.nextLine());

					Student student = library.registerStudent(stuName, roll); 
					
					if (student == null) break; 

                    boolean exitStudent = false;
                    while (!exitStudent) {
                        System.out.println("\n--- Student Panel ---");
                        System.out.println("1. Issue Book");
                        System.out.println("2. Return Book");
                        System.out.println("3. Back");
                        System.out.print("Choice: ");
                        int stuChoice = Integer.parseInt(input.nextLine());

                        switch (stuChoice) {
                            case 1:
                                System.out.print("Enter Book ID to issue: ");
                                int issueId = Integer.parseInt(input.nextLine());
                                library.issueBook(issueId, student.getName());
                                break;
                            case 2:
                                System.out.print("Enter Book ID to return: ");
                                int returnId = Integer.parseInt(input.nextLine());
                                library.returnBook(returnId, student.getName());
                                break;
                            case 3:
                                exitStudent = true;
                                break;
                            default:
                                System.out.println("Invalid option.");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Exiting Library. Thank you!");
                    return;

                default:
                    System.out.println("Invalid input. Try again.");
					}
				}catch(NumberFormatException e){
				System.out.println("Invlaid Choice Have Choice In Number 1 to 3.\n");
				continue;
			}
        }
    }
}
