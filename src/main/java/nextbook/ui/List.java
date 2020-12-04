package nextbook.ui;

import nextbook.io.IO;
import nextbook.domain.ClueService;
import nextbook.domain.Clue;
import nextbook.domain.Book;
import nextbook.domain.Video;

import java.util.ArrayList;
import java.util.Collections;

public class List extends Command {

    private ClueService clueService;

    public List(IO io, ClueService clueService) {
        super(io);
        this.clueService = clueService;
    }

    @Override
    public void execute() {
        ArrayList<Clue> clues = clueService.readClues();
        Collections.sort(clues);
        for (Clue c: clues) {
            io.print(c);
        }
    }

}

