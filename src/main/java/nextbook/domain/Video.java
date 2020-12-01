package nextbook.domain;

public class Video extends Clue {
    private int id;
    private String name;
    private String link;
    private int time;

    public Video(String name, String link, int time) {
        this.name = name;
        this.link = link;
        this.time = time;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "name=" + name + ", link=" + link + ", time=" + time;
    }
    
    @Override
    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }

        if (!(compared instanceof Video)) {
            return false;
        }

        Video comparedVideo = (Video) compared;

        if (this.name.equals(comparedVideo.name) &&
            this.link.equals(comparedVideo.link) &&
            this.time == comparedVideo.time) {
            return true;
        }

        return false;
    }
}

