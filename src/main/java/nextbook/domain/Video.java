package nextbook.domain;

public class Video extends Clue {

    private String name;
    private String link;
    private int time;

    public Video(String name, String link, int time) {
        this.name = name;
        this.link = link;
        this.time = time;
    }

    @Override
    public String toString() {
        return "name=" + name + ", link=" + link + ", time=" + time;
    }

}

