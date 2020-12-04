
package nextbook.domain;

public class Blog extends Clue {
    private int id;
    private String name;
    private String author;
    private String link;
    private String comment;

    public Blog(String name, String author, String link, String comment) {
        this.name = name;
        this.author = author;
        this.link = link;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return author + ": " + name + ", " + link;
    }
    
    @Override
    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }

        if (!(compared instanceof Blog)) {
            return false;
        }

        Blog comparedBlog = (Blog) compared;

        if (this.name.equals(comparedBlog.name) &&
            this.author.equals(comparedBlog.author) &&
            this.link.equals(comparedBlog.link)) {
            return true;
        }
        
        return false;
    }
    
}
