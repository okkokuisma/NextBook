/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nextbook.dao;

/**
 *
 * @author pate
 */
import java.sql.*;
import java.util.ArrayList;
import nextbook.domain.Book;
import nextbook.domain.Clue;

public class SqlClueDao implements ClueDao {
    SqlBookDao bookDao;
    
    public SqlClueDao() {
        bookDao = new SqlBookDao();
        Connection dbconn = null;
        try {
            dbconn = DriverManager.getConnection("jdbc:sqlite:NextBook.db");
            Statement s = dbconn.createStatement();

            s.execute("CREATE TABLE IF NOT EXISTS books ("
                    + "id INTEGER PRIMARY KEY,"
                    + "name TEXT,"
                    + "author TEXT,"
                    + "isbn TEXT,"
                    + "comment TEXT,"
                    + "year INTEGER)");
            s.execute("CREATE TABLE IF NOT EXISTS videos ("
                    + "id INTEGER PRIMARY KEY,"
                    + "name TEXT,"
                    + "url TEXT,"
                    + "time TEXT)");

            dbconn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }  
        
        System.out.println("Opened database successfully");
    }

    @Override
    public void create(Clue clue) {
        if (clue instanceof Book) {
            bookDao.create((Book) clue);
        }
    }

    @Override
    public ArrayList getAll() {
        return bookDao.getAll();
    }

}
