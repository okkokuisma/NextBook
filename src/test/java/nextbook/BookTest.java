/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nextbook;

import nextbook.domain.Book;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author pate
 */
public class BookTest {

    private String name;
    private String author;

    @Test
    public void nameEqualWhenBookAdded() {
        Book b1 = new Book("name", "author");

        assertEquals("name", b1.getName());
    }

    @Test
    public void authorEqualWhenBookAdded() {
        Book b1 = new Book("name", "author");

        assertEquals("author", b1.getAuthor());
    }

    @Test
    public void nonEqualWhenDifferentName() {
        Book b1 = new Book("name", "author");
        Book b2 = new Book("namers", "author");
        assertFalse(b1.equals(b2));
    }

    @Test
    public void nonEqualWhenDifferentType() {
        Book b = new Book("name", "author");
        Object o = new Object();
        assertFalse(b.equals(o));
    }

}
