package nextbook.ui;

import nextbook.io.IO;
import nextbook.domain.ClueService;
import nextbook.domain.Clue;
import nextbook.domain.Tag;

import java.util.ArrayList;
import nextbook.domain.TagService;

public class RemoveTag extends Command {

    private ClueService clueService;
    private TagService tagService;

    public RemoveTag(IO io, ClueService clueService, TagService tagService) {
        super(io);
        this.clueService = clueService;
        this.tagService = tagService;
    }

    @Override
    public void execute() {
        ArrayList<Clue> clues = clueService.readClues();
        for (int id = 1; id <= clues.size(); id++) {
            io.print("id (" + id + "), " + clues.get(id - 1));;
        }
        int id1 = io.readInt("Give id of clue to remove tag");

        if (id1 < 1 || id1 > clues.size()) {
            io.print("Invalid index");
            return;
        }
        Clue clue = clues.get(id1 - 1);

        ArrayList<Tag> tags = tagService.readTags();
        for (int id = 1; id <= tags.size(); id++) {
            io.print("id (" + id + "), " + tags.get(id - 1));;
        }
        int id2 = io.readInt("Give id of tag to remove from clue");

        if (id2 < 1 || id2 > tags.size()) {
            io.print("Invalid index");
            return;
        }
        Tag tag = tags.get(id2 - 1);

        tagService.removeTagFromClue(clue, tag);
        io.print("Tag removed successfully");
    }

}

