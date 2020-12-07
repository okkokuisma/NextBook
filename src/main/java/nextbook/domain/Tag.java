package nextbook.domain;

public class Tag {
    private int id;
    private String tag;

    public Tag(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Tag)) {  
            return false;
        }
        Tag other = (Tag) o;
        return this.tag.equals(other.tag);
    }

    @Override
    public String toString() {
        return "tag: " + tag;
    }

}
