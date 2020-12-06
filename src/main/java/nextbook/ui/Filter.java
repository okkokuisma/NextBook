package nextbook.ui;

import nextbook.io.IO;
import nextbook.domain.ClueService;
import nextbook.domain.Clue;
import nextbook.domain.Book;
import nextbook.domain.Video;

import java.util.ArrayList;

public class Filter extends Command {

    private final static String BOOK = "Book";
    private final static String VIDEO = "Video";
    private final static String BLOG = "Blog";


    private ClueService clueService;

    public Filter(IO io, ClueService clueService) {
        super(io);
        this.clueService = clueService;
    }


    @Override
    public void execute() {
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

