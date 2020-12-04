package nextbook.ui;

import nextbook.io.IO;
import nextbook.domain.ClueService;
import nextbook.domain.Clue;
import nextbook.domain.Book;
import nextbook.domain.Video;

public class Add extends Command {

    private static final int BOOK = 1;
    private static final int VIDEO = 2;

    private ClueService clueService;

    public Add(IO io, ClueService clueService) {
        super(io);
        this.clueService = clueService;
    }

    @Override
    public void execute() {
        int type = io.readInt("Give number to add, (1) book or (2) video");

        if (type == BOOK) {
            String name = io.readLine("Give name of the book");
            String author = io.readLine("Give author of the book");
            String isbn = io.readLine("Give ISBN of the book");
            String comment = io.readLine("Give comments to the book (all in one line)");
            int year = io.readInt("Give year of publish of the book");
            Clue book = new Book(name, author, isbn, comment, year);
            clueService.createClue(book);
            io.print("New book added");
        }

        if (type == VIDEO) {
            String name = io.readLine("Give name of the video");
            String link = io.readLine("Give link to the video");
            int startTime = io.readInt("Give starting time of part of the video (in seconds)");
            link = link + "&t=" + startTime;

            Clue video = new Video(name, link, startTime);
            clueService.createClue(video);
            io.print("New video added");
        }

    }

}

