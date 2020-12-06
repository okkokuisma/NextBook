package nextbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import nextbook.domain.Book;
import nextbook.domain.Clue;
import nextbook.domain.Tag;
import nextbook.domain.Video;

public class SqlTagDao {
    private Connection dbconn;
    private DbUtil dbUtil;

    public SqlTagDao(DbUtil dbUtil) {
        this.dbUtil = dbUtil;
    }  

    public void create(Tag tag) {
        try {
            connect();
            PreparedStatement ps = dbconn.prepareStatement("INSERT INTO tags (tag) VALUES (?)");
            ps.setString(1, tag.getTag());
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
            ResultSet queryResults = ps.executeQuery("SELECT id, tag FROM tags");

            ArrayList<Tag> tags = new ArrayList<>();
            while (queryResults.next()) {
                Tag tag = new Tag(queryResults.getString(2));
                tag.setId(queryResults.getInt(1));
                tags.add(tag);
            }

            dbconn.close();
            return tags;
        } catch (SQLException ex) {
            Logger.getLogger(SqlBookDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }     
    }

    public void setTag(Clue clue, Tag tag) {
        try {
            connect();
            PreparedStatement ps = dbconn.prepareStatement("");

            if (clue instanceof Book) {
                ps = dbconn.prepareStatement("INSERT INTO book_tags (book_id, tag_id) VALUES (?,?)");
                ps.setInt(1, ((Book) clue).getId());
            } else if (clue instanceof Video) {
                ps = dbconn.prepareStatement("INSERT INTO video_tags (video_id, tag_id) VALUES (?,?)");
                ps.setInt(1, ((Video) clue).getId());
            }

            ps.setInt(2, tag.getId());
            ps.execute();

            dbconn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SqlBookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteTag(int id) {
        try {
            connect();

            PreparedStatement ps1 = dbconn.prepareStatement("DELETE FROM book_tags, video_tags WHERE tag_id = ?");
            ps1.setInt(1, id);
            ps1.execute();

            PreparedStatement ps2 = dbconn.prepareStatement("DELETE FROM tags WHERE id = ?");
            ps2.setInt(1, id);
            ps2.execute();

            dbconn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SqlBookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList filterAllByTag(Tag tag) {
        ArrayList<Clue> clues = new ArrayList<>();
        clues.addAll(filterBooksByTag(tag));
        clues.addAll(filterVideosByTag(tag));

        return clues;
    }

    private ArrayList filterBooksByTag(Tag tag) {
        try {
            connect();
            PreparedStatement ps = dbconn.prepareStatement("SELECT id, name, author, isbn, comment, year FROM books WHERE id IN (SELECT book_id FROM book_tags WHERE tag_id = ?)");
            ps.setInt(1, tag.getId());
            ResultSet queryResults = ps.executeQuery();

            ArrayList<Book> books = SqlBookDao.getQueryResultAsListOfClues(queryResults);

            dbconn.close();
            return books;
        } catch (SQLException ex) {
            Logger.getLogger(SqlBookDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }

    private ArrayList filterVideosByTag(Tag tag) {
        try {
            connect();
            PreparedStatement ps = dbconn.prepareStatement("SELECT id, name, url, time FROM videos WHERE id IN (SELECT video_id FROM video_tags WHERE tag_id = ?)");
            ps.setInt(1, tag.getId());
            ResultSet queryResults = ps.executeQuery();
            ArrayList<Video> videos = SqlVideoDao.getQueryResultAsListOfClues(queryResults);

            dbconn.close();
            return videos;
        } catch (SQLException ex) {
            Logger.getLogger(SqlBookDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }

    private void connect() {
        dbconn = dbUtil.connect();
    }
}
