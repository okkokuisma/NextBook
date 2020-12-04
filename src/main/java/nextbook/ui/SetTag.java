package nextbook.ui;

import nextbook.io.IO;
import nextbook.domain.ClueService;
import nextbook.domain.Clue;
import nextbook.domain.Tag;

import java.util.ArrayList;

public class SetTag extends Command {

    private ClueService clueService;

    public SetTag(IO io, ClueService clueService) {
        super(io);
        this.clueService = clueService;
    }

    @Override
    public void execute() {
        ArrayList<Clue> clues = clueService.readClues();
        for (int id = 1; id <= clues.size(); id++) {
            io.print("id (" + id + "), " + clues.get(id - 1));;
        }
        int id1 = io.readInt("Give id of clue to give tag");
        Clue clue = clues.get(id1 - 1);

        ArrayList<Tag> tags = new ArrayList(); // Change later
        for (int id = 1; id <= tags.size(); id++) {
            io.print("id (" + id + "), " + tags.get(id - 1));;
        }
        int id2 = io.readInt("Give id of tag to set to clue");
        Tag tag = tags.get(id2 - 1);

        io.print("Add tag " + tag + "to clue " + clue + " in later implementation");
    }

}

