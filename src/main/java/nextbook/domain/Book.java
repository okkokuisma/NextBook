package nextbook.domain;

public class Book extends Clue {
    private String name;
    private String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return author + ": " + name;
    }

}
