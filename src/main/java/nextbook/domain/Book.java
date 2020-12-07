package nextbook.domain;

import java.util.ArrayList;

public class Book extends Clue {
    private int id;
    private String name;
    private String author;
    private String isbn;
    private String comment;
    private int yearPublished;
    private ArrayList<Tag> tags;
    
    public Book(String name, String author) {
        this(name, author, "123456789", "", 2000);
    }

    public Book(String name, String author, String isbn, String comment, int yearPublished) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.comment = comment;
        this.yearPublished = yearPublished;
        this.tags = new ArrayList();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public boolean hasTag(Tag tag) {
        if (tags.contains(tag)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return author + ": " + name + ", " + isbn + ", " + yearPublished;
    }
    
    @Override
    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }

        if (!(compared instanceof Book)) {
            return false;
        }

        Book comparedBook = (Book) compared;

        if (this.name.equals(comparedBook.name) &&
            this.author.equals(comparedBook.author) &&
            this.isbn.equals(comparedBook.isbn) &&
            this.yearPublished == comparedBook.yearPublished) {
            return true;
        }

        return false;
    }

}
