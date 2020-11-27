/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nextbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import nextbook.domain.Book;

/**
 *
 * @author okkokuisma
 */
public class SqlBookDao {
    Connection dbconn;
    
    public void create(Book book) {
        try {
            connect();
            PreparedStatement ps = dbconn.prepareStatement("INSERT INTO books (name,author,isbn,comment,year) VALUES (?,?,?,?,?)");
            ps.setString(1, book.getName());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getIsbn());
            ps.setString(4, book.getComment());
            ps.setInt(5, book.getYearPublished());
            ps.execute();
            
            dbconn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SqlBookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList getAll() {
        try {
            connect();
            Statement ps = dbconn.createStatement();
            ResultSet queryResults = ps.executeQuery("SELECT books FROM Courses");
            
            ArrayList<Book> books = new ArrayList<>();
            while (queryResults.next()) {
                Book book = new Book(queryResults.getString(1),
                        queryResults.getString(2),
                        queryResults.getString(3),
                        queryResults.getString(4),
                        queryResults.getInt(5));
                books.add(book);
            }
            
            dbconn.close();
            return books;
        } catch (SQLException ex) {
            Logger.getLogger(SqlBookDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }     
    }
    
    private void connect() {
        try {
            dbconn = DriverManager.getConnection("jdbc:sqlite:NextBook.db");
        } catch (SQLException ex) {
            Logger.getLogger(SqlBookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
