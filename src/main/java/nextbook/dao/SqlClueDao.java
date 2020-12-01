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
import nextbook.domain.Video;

public class SqlClueDao implements ClueDao {
    SqlBookDao bookDao;
    SqlVideoDao videoDao;
    
    public SqlClueDao() {
        bookDao = new SqlBookDao();
        videoDao = new SqlVideoDao();
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
            System.out.println("Opened database successfully");
        } catch (Exception e) {
            System.out.println("Error while opening the database");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }   
    }

    @Override
    public void create(Clue clue) {
        if (clue instanceof Book) {
            bookDao.create((Book) clue);
        } else if (clue instanceof Video) {
            videoDao.create((Video) clue);
        }
    }

    @Override
    public ArrayList getAll() {
        ArrayList<Clue> clues = new ArrayList<>();
        clues.addAll(bookDao.getAll());
        clues.addAll(videoDao.getAll());
        
        return clues;
    }

    @Override
    public ArrayList filterClue(String type) {
        ArrayList<Clue> clues = new ArrayList<>();
        if (type.equals("Book")) {
            clues.addAll(bookDao.getAll());
        }
        if (type.equals("Video")) {
            clues.addAll(videoDao.getAll());
        }
        return clues;
    }
    
    @Override
    public void remove(Clue clue) {
        if (clue instanceof Book) {
            bookDao.remove(((Book) clue).getId());
        } else if (clue instanceof Video) {
            videoDao.remove(((Video) clue).getId());
        }
    }
    
    @Override
    public void update(Clue clue) {
        if (clue instanceof Book) {
            bookDao.update((Book) clue);
        } else if (clue instanceof Video) {
            videoDao.update((Video) clue);
        }
    }
  
}
