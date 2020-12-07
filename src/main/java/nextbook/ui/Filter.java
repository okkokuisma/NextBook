package nextbook.ui;

import nextbook.io.IO;
import nextbook.domain.ClueService;
import nextbook.domain.TagService;
import nextbook.domain.Clue;
import nextbook.domain.Book;
import nextbook.domain.Video;
import nextbook.domain.Tag;

import java.util.ArrayList;

public class Filter extends Command {

    private final static String BOOK = "Book";
    private final static String VIDEO = "Video";
    private final static String BLOG = "Blog";
    private final static int TAG = 1;
    private final static int TYPE = 2;


    private ClueService clueService;
    private TagService tagService;

    public Filter(IO io, ClueService clueService, TagService tagService) {
        super(io);
        this.clueService = clueService;
        this.tagService = tagService;
    }


    @Override
    public void execute() {
        int type = io.readInt("Filter by tag (1), or type (2)");
        if (type == TAG) {
            filterByTag();
        } else if (type == TYPE) {
            filterByType();
        }
    }

    public void filterByTag() {
        ArrayList<Tag> tags = tagService.readTags();
        for (int id = 1; id <= tags.size(); id++) {
            io.print("id (" + id + "), " + tags.get(id - 1));;
        }
        int id = io.readInt("Give id of tag to set to clue");

        if (id < 1 || id > tags.size()) {
            io.print("Invalid index");
            return;
        }
        Tag tag = tags.get(id - 1);

        ArrayList<Clue> clues = tagService.filterCluesByTag(tag);
        for (Clue c: clues) {
            io.print(c);
        }
    }

    public void filterByType() {
        String type = io.readLine("List books, videos or blog posts (b/v/bp)?");
        ArrayList<Clue> clues = null;

        if (type.equals("b")) {
            clues = clueService.filterClues(BOOK);
        }
        if (type.equals("v")) {
            clues = clueService.filterClues(VIDEO);
        }
        if (type.equals("bp")) {
            clues = clueService.filterClues(BLOG);
        }

        if (clues == null) {
            io.print("Incorrect type");
        } else {
            for (Clue c: clues) {
                io.print(c);
            }
        }
    }

}

