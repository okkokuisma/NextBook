package nextbook.dao;

import java.sql.*;
import java.util.ArrayList;
import nextbook.domain.Blog;
import nextbook.domain.Book;
import nextbook.domain.Clue;
import nextbook.domain.Video;
import nextbook.domain.Tag;

public class SqlClueDao implements ClueDao {
    SqlBookDao bookDao;
    SqlVideoDao videoDao;
    SqlBlogDao blogDao;
    
    public SqlClueDao(DbUtil dbUtil) {
        bookDao = new SqlBookDao(dbUtil);
        videoDao = new SqlVideoDao(dbUtil);  
        blogDao = new SqlBlogDao(dbUtil);
    }

    @Override
    public void create(Clue clue) {
        if (clue instanceof Book) {
            bookDao.create((Book) clue);
        } else if (clue instanceof Video) {
            videoDao.create((Video) clue);
        } else if (clue instanceof Blog) {
            blogDao.create((Blog) clue);
        }
    }

    @Override
    public ArrayList<Clue> getAll() {
        ArrayList<Clue> clues = new ArrayList<>();
        clues.addAll(bookDao.getAll());
        clues.addAll(videoDao.getAll());
        clues.addAll(blogDao.getAll());
        
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
        if (type.equals("Blog")) {
            clues.addAll(blogDao.getAll());
        }
        return clues;
    }

    @Override
    public void remove(Clue clue) {
        if (clue instanceof Book) {
            bookDao.remove(((Book) clue).getId());
        } else if (clue instanceof Video) {
            videoDao.remove(((Video) clue).getId());
        } else if (clue instanceof Blog) {
            blogDao.remove(((Blog) clue).getId());
        }
    }
    
    @Override
    public void update(Clue clue) {
        if (clue instanceof Book) {
            bookDao.update((Book) clue);
        } else if (clue instanceof Video) {
            videoDao.update((Video) clue);
        } else if (clue instanceof Blog) {
            blogDao.update((Blog) clue);
        }
    }
  
}
