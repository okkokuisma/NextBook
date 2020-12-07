package nextbook.domain;

import java.util.Objects;

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
    public String toString() {
        return "tag: " + tag;
    }

    @Override
    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }
        if (compared == null) {
            return false;
        }
        if (!(compared instanceof Tag)) {
            return false;
        }
        Tag comparedTag = (Tag) compared;
        
        return this.tag.equals(comparedTag.tag);
    }
   
}

