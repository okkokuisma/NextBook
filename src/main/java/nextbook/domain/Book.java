package nextbook.domain;

public class Book extends Clue {
    private int id;
    private String name;
    private String author;
    private String isbn;
    private String comment;
    private int yearPublished;
    
    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public Book(String name, String author, String isbn, String comment, int yearPublished) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.comment = comment;
        this.yearPublished = yearPublished;
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

    @Override
    public String toString() {
        return author + ": " + name + ", " + isbn + ", " + yearPublished;
    }

}
