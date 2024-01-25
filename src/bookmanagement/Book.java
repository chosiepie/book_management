package bookmanagement;

public class Book {
	private int bookID;
	private String bookName;
	private String authorName;
	private String bookGenre;
	private double progress;
	
	public Book(){
		
	}
	
	public Book(String bookName, String authorName, String bookGenre, double progress) {
		
		this.bookName = bookName;
		this.authorName = authorName;
		this.bookGenre = bookGenre;
		this.progress = progress;
	}
	public Book(int bookID, String bookName, String authorName, String bookGenre, double progress) {

		this.bookID = bookID;
		this.bookName = bookName;
		this.authorName = authorName;
		this.bookGenre = bookGenre;
		this.progress = progress;
	}
	

	
	
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getBookGenre() {
		return bookGenre;
	}
	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}
	public double getProgress() {
		return progress;
	}
	public void setProgress(double progress) {
		this.progress = progress;
	}
	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", bookName=" + bookName + ", authorName=" + authorName + ", bookGenre="
				+ bookGenre + ", progress=" + progress + "]";
	}

}
