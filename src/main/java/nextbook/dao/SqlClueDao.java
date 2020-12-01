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
    
    public SqlClueDao(DbUtil dbUtil) {
        bookDao = new SqlBookDao(dbUtil);
        videoDao = new SqlVideoDao(dbUtil);     
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
    public ArrayList<Clue> getAll() {
        ArrayList<Clue> clues = new ArrayList<>();
        clues.addAll(bookDao.getAll());
        clues.addAll(videoDao.getAll());
        
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
