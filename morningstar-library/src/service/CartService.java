package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import constant.CartAttribute;
import database.DBConnector;
import model.Book;
import model.Cart;
import model.Pair;

public class CartService {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null; 
	 
	public boolean addItem(String userID, String ISBN, int bookCount) {
		Cart cart = getCart(userID);
		
		for(Pair<Book, Integer, Integer> book : cart.getBooks()) {
			if(book.getFirst().getIsbn().equals(ISBN)) {
				updateCount(userID, ISBN, book.getSecond() + bookCount);
				return true;
			}
		}
		
		try {
			con = DBConnector.getConnection();
			pstmt = con.prepareStatement(String.join(" ", "INSERT INTO", CartAttribute.TABLE_NAME, "values (?, ?, ?);"));
			
			pstmt.setString(1, userID);
			pstmt.setString(2, ISBN);
			pstmt.setInt(3, bookCount);
			
			int isSucces = pstmt.executeUpdate();
			if(isSucces > 0) {
				return true;
			} else {
				return false;
			}
			
		} catch (SQLException ex) {
			System.err.println("Database error in CartService" + ex.getMessage());			
			
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { /* ignored */ }
			try { if (pstmt != null) pstmt.close(); } catch (SQLException e) { /* ignored */ }
			try { if (con != null) con.close(); } catch (SQLException e) { /* ignored */ }
		}
		return false;
	}
	
	public Cart getCart(String userID) {
		try {
			Vector<Pair<Book, Integer, Integer>> books = new Vector<Pair<Book, Integer, Integer>>();
			BookService bookService = new BookService();
			InventoryService inventoryService = new InventoryService();
			int totalBookCount = 0;
			int totalAmount = 0;
			
			con = DBConnector.getConnection();
			pstmt = con.prepareStatement(String.join(" ", "SELECT", CartAttribute.ISBN, ",", CartAttribute.BOOKCOUNT, "FROM", CartAttribute.TABLE_NAME, "WHERE", CartAttribute.USER_ID, "=?;"));
			pstmt.setString(1, userID);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String ISBN = rs.getString(CartAttribute.ISBN);
				int bookCount = rs.getInt(CartAttribute.BOOKCOUNT);
				int bookPrice = inventoryService.getPrice(ISBN);
				
				books.add(new Pair<>(bookService.loadBook(ISBN), bookCount, bookPrice));
				totalBookCount += bookCount;
				totalAmount += bookCount * bookPrice;
			}
			
			return new Cart(userID, books, totalBookCount, totalAmount);
			
		} catch (SQLException ex) {
			System.err.println("Database error in CartService" + ex.getMessage());			
			
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { /* ignored */ }
			try { if (pstmt != null) pstmt.close(); } catch (SQLException e) { /* ignored */ }
			try { if (con != null) con.close(); } catch (SQLException e) { /* ignored */ }
		}
		
		return null;
	}
	
	public void updateCount(String userID, String isbn, int count) {
		try {
			con = DBConnector.getConnection();

			pstmt = con.prepareStatement(String.join(" ", "UPDATE", CartAttribute.TABLE_NAME, "SET", CartAttribute.BOOKCOUNT, "=? WHERE", CartAttribute.USER_ID, "=? AND", CartAttribute.ISBN, "=?;"));
			pstmt.setInt(1, count);
			pstmt.setString(2, userID);
			pstmt.setString(3, isbn);
			
			pstmt.executeUpdate();
			
		} catch (SQLException ex) {
			System.err.println("Database error in CartService" + ex.getMessage());			
			
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { /* ignored */ }
			try { if (pstmt != null) pstmt.close(); } catch (SQLException e) { /* ignored */ }
			try { if (con != null) con.close(); } catch (SQLException e) { /* ignored */ }
		}		
	}
	
	public void removeBook(String userID, String isbn) {
		try {
			con = DBConnector.getConnection();
			pstmt = con.prepareStatement(String.join(" ", "DELETE FROM", CartAttribute.TABLE_NAME, "WHERE", CartAttribute.USER_ID, "=? AND", CartAttribute.ISBN, "=?;"));
			pstmt.setString(1, userID);
			pstmt.setString(2, isbn);
			
			pstmt.executeUpdate();
			
		} catch (SQLException ex) {
			System.err.println("Database error in CartService" + ex.getMessage());			
			
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { /* ignored */ }
			try { if (pstmt != null) pstmt.close(); } catch (SQLException e) { /* ignored */ }
			try { if (con != null) con.close(); } catch (SQLException e) { /* ignored */ }
		}
	}
	
	public void deleteCart(String userID) {
		try {
			con = DBConnector.getConnection();
			pstmt = con.prepareStatement(String.join(" ", "DELETE FROM", CartAttribute.TABLE_NAME, "WHERE", CartAttribute.USER_ID, "=?;"));
			pstmt.setString(1, userID);
			
			pstmt.executeUpdate();
			
		} catch (SQLException ex) {
			System.err.println("Database error in CartService" + ex.getMessage());			
			
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { /* ignored */ }
			try { if (pstmt != null) pstmt.close(); } catch (SQLException e) { /* ignored */ }
			try { if (con != null) con.close(); } catch (SQLException e) { /* ignored */ }
		}
	}
}
