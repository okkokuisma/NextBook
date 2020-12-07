/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nextbook.dao;

import java.io.File;
import nextbook.domain.Book;
import nextbook.domain.Clue;
import nextbook.domain.Video;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SqlClueDaoTest {
    SqlClueDao dao;
    
    
    @Before
    public void setUp() {
        dao = new SqlClueDao(new DbUtil(true));
        dao.create(new Book("name", "author", "isbn", "comment", 2000));
        dao.create(new Video("name", "youtube.com", 20));
    }
    
    @After
    public void tearDown() {
        File testDb = new File("test.db");
        testDb.delete();
    }
    
    @Test
    public void updateBook() {
        Book updatedBook = new Book("enam", "rohtua", "nbsi", "tnemmoc", 0002);
        updatedBook.setId(1);
        dao.update(updatedBook);
        
        assertTrue(dao.getAll().get(0).equals(updatedBook));
    }
    
    @Test
    public void updateVideo() {
        Video updatedVideo = new Video("enam", "vimeo.com", 10);
        updatedVideo.setId(1);
        dao.update(updatedVideo);
        
        assertTrue(dao.getAll().get(1).equals(updatedVideo));
    }
    
    @Test
    public void removeBook() {
        Book book = new Book("this", "will", "be", "removed", 0);
        dao.create(book);
        
        book.setId(2);
        dao.remove(book);       
        
        for (Clue clue : dao.getAll()) {
            if (clue instanceof Book) {
                if (((Book) clue).equals(book)) {
                    fail("Book was not removed successfully from the database");
                }
            }
        }
    }
    
    @Test
    public void removeVideo() {
        Video video = new Video("remove", "this", 0);
        dao.create(video);
        
        video.setId(2);
        dao.remove(video);      
        
        for (Clue clue : dao.getAll()) {
            if (clue instanceof Video) {
                if (((Video) clue).equals(video)) {
                    fail("Video was not removed successfully from the database");
                }
            }
        }
    }
}
