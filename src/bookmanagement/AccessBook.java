package bookmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class AccessBook implements BookInterface{

	@Override
	public boolean insertBook(Book s) {
	
		boolean success=false;
		try {
			
			Connection con = DBConnection.createConnection();
			String query = "INSERT INTO book_details(title, author, genre, myprogress) value (?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, s.getBookName());
			pst.setString(2, s.getAuthorName());
			pst.setString(3, s.getBookGenre());
			pst.setDouble(4, s.getProgress());
			pst.executeUpdate();
			
			success = true;


		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return success;
	}

	@Override
	public boolean delete(int id) {
		boolean success = false;
		try {
			Connection con = DBConnection.createConnection();
			String query="DELETE FROM book_details WHERE id="+id;
			PreparedStatement pst = con.prepareStatement(query);
			pst.executeUpdate();
			success = true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
	
	@Override
	public boolean update(int id, String update, int choice, Book s) {
        boolean success = false;
        int option = choice;
        try {
            Connection con = DBConnection.createConnection();
            if (option == 1) {
                String query = "UPDATE book_details SET title = ? WHERE id = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, update);
                ps.setInt(2, id);
                ps.executeUpdate();
                success = true;
            } else if (option == 2) {
                String query = "UPDATE book_details SET author = ? WHERE id = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, update);
                ps.setInt(2, id);
                ps.executeUpdate();
                success = true;
            } else if (option == 3) {
                String query = "UPDATE book_details SET myprogress = ? WHERE id = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setDouble(1, Double.parseDouble(update));
                ps.setInt(2, id);
                ps.executeUpdate();
                success = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return success;
    }
	
	
	@Override
	public void showAllBook(){
		try {
			Connection con=DBConnection.createConnection();
			String query = "SELECT * FROM book_details";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			//System.out.println(rs.next());
			while(rs.next()) {
				
				System.out.println("ID: " + rs.getInt(1) +"\n" + 
						"Book Name: " + rs.getString(2) + "\n" + 
						"Author Name: " + rs.getString(3)+" \n" +
						"Book Genre: "+ rs.getString(4) + "\n" +
						"Progress: " + rs.getDouble(5));
				System.out.println("------------------------------------------------------");
			}
		}
		catch (Exception ex){
	            ex.printStackTrace();
		}
	}
	
	@Override
	public boolean showBookById(int id) {
		boolean success = false;
		try {
			Connection con=DBConnection.createConnection();
			String query = "SELECT * FROM book_details WHERE id=" +id;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			//System.out.println(rs.next());
			if(rs.next()==true) {
				
				System.out.println("ID: " + rs.getInt(1) +"\n" + 
						"Book Name: " + rs.getString(2) + "\n" + 
						"Author Name: " + rs.getString(3)+" \n" +
						"Book Genre: "+ rs.getString(4) + "\n" +
						"Progress: " + rs.getDouble(5));
				success = true;
			}
			
		}
		catch (Exception ex){
	            ex.printStackTrace();
		}
		return success;
	}
	
	

}
