package bookmanagement;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		BookInterface access = new AccessBook();
		
		
		System.out.println("Welcome to your personal book management application");
		
		while(true) {
			System.out.println("- Type 1 to Add a book ");
			System.out.println("- Type 2 to Show all books");
			System.out.println("- Type 3 to View a book based on its ID ");
			System.out.println("- Type 4 to Delete a book ");
			System.out.println("- Type 5 to Update a book ");
			System.out.println("- Type 6 to Exit from the application ");
			System.out.println("Enter a number:");
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1: 
					System.out.println("Add a book");
					
					sc.nextLine();
					System.out.println("Enter book name");
					String bookName=sc.nextLine();
				
					System.out.println("Enter book author name");
					String authorName=sc.nextLine();
					
					System.out.println("Enter book genre");
					String bookGenre=sc.nextLine();
					
					System.out.println("Enter the your reading progress (from 0 to 100)");
					double progress = sc.nextDouble();
					
					//sc.nextLine();
					
					Book book = new Book(bookName, authorName, bookGenre, progress);
					boolean ans=access.insertBook(book);
					
					
					if(ans) {
						System.out.println("Record inserted successfully!");
					} else {
						System.out.println("Something went wrong, please try again!");
					}

					break;
				case 2: 
					System.out.println("Show all books");
					access.showAllBook();
					break;
				case 3: 
					System.out.println("View a book based on its ID");
					System.out.println("Enter book ID");
					int id = sc.nextInt();
					boolean f = access.showBookById(id);
					
					if (!f)
						System.out.println("This book is not available in the system");
					break;
				case 4: 
					System.out.println("Delete a book");
					System.out.println("Enter ID of the book to delete");
					int bookID = sc.nextInt();
					boolean ff=access.delete(bookID);
					if (ff) {
						System.out.println("Record deleted successfully");
						
					}
					else {
						System.out.println("Something went wrong!");
					}
					break;
				case 5: 
					System.out.println("Update a book ");
					System.out.println("- Type 1 to Update book name");
					System.out.println("- Type 2 to Update author name");
					System.out.println("- Type 3 to Update your progress");
					System.out.println("Enter your choice:");
					int option = sc.nextInt();
					if(option == 1) {
						System.out.println("Enter ID of the book that you want to update:");
						int idToUpdate = sc.nextInt(); 
						sc.nextLine();
						System.out.println("Enter new name for the book:");
						String title = sc.nextLine();
						Book std = new Book();
						std.setBookName(title);
						boolean success = access.update(idToUpdate, title, option, std);
						if (success) {
							System.out.println("Name updated successfully!");
						}else {
							System.out.println("Something went wrong!");								
						}
					} else if (option == 2) {
						System.out.println("Enter ID of the book that you want to update:");
						int idToUpdate = sc.nextInt();
						sc.nextLine();
						System.out.println("Enter new author name for the book:");
						String author = sc.nextLine();
						Book std = new Book();
						std.setAuthorName(author);
						boolean success = access.update(idToUpdate, author, option, std);
						if (success) {
							System.out.println("Name updated successfully!");
						}else {
							System.out.println("Something went wrong!");								
						}
					} else if (option == 3) {
						System.out.println("Enter ID of the book that you want to update:");
						int idToUpdate = sc.nextInt();
						sc.nextLine();
						System.out.println("Enter new progress for the book:");
						String myprogress = sc.nextLine();
						Book std = new Book();
						std.setProgress(Double.parseDouble(myprogress));
						boolean success = access.update(idToUpdate, myprogress, option, std);
						if (success) {
							System.out.println("Progress updated successfully!");
						}else {
							System.out.println("Something went wrong!");								
						}
					}
					
					break;
				case 6: 
					System.out.println("See you again!");
					System.exit(0);
				default:
					System.out.println("Please enter valid choice!");
				
			}

		}

	}

}
