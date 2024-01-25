package bookmanagement;


public interface BookInterface {
	public boolean insertBook(Book s);
	public boolean delete(int id);
	public boolean update(int id, String update, int choice, Book s);
	public void showAllBook();
	public boolean showBookById(int id);

}
