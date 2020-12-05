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
    DbUtil dbUtil;

    public SqlBookDao(DbUtil dbUtil) {
        this.dbUtil = dbUtil;
    }
    
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
            
            Statement s = dbconn.createStatement();
            
            dbconn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SqlBookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList getAll() {
        try {
            connect();
            Statement ps = dbconn.createStatement();
            ResultSet queryResults = ps.executeQuery("SELECT id, name, author, isbn, comment, year FROM books");
            
            ArrayList<Book> books = getQueryResultAsListOfClues(queryResults);
            
            dbconn.close();
            return books;
        } catch (SQLException ex) {
            Logger.getLogger(SqlBookDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }     
    }
    
    public void remove(int id) {
        try {
            connect();
            PreparedStatement ps = dbconn.prepareStatement("DELETE FROM books WHERE id = ?");
            ps.setInt(1, id);
            ps.execute();
            
            dbconn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SqlBookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(Book book) {
        try {
            connect();
            PreparedStatement ps = dbconn.prepareStatement("UPDATE books SET "
                + "name = ?, "
                + "author = ?, "
                + "isbn = ?, "
                + "comment = ?, "
                + "year = ? "
                + "WHERE id = ?");
            ps.setString(1, book.getName());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getIsbn());
            ps.setString(4, book.getComment());
            ps.setInt(5, book.getYearPublished());
            ps.setInt(6, book.getId());
            ps.execute();
            
            dbconn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SqlBookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected static ArrayList getQueryResultAsListOfClues(ResultSet queryResults) {
        ArrayList<Book> books = new ArrayList<>();
        
        try {
            while (queryResults.next()) {
                Book book = new Book(queryResults.getString(2),
                        queryResults.getString(3),
                        queryResults.getString(4),
                        queryResults.getString(5),
                        queryResults.getInt(6));
                book.setId(queryResults.getInt(1));
                books.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlBookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return books;
    }
    
    private void connect() {
        dbconn = dbUtil.connect();
    }
}
