package nextbook.ui;

import nextbook.io.IO;
import nextbook.domain.ClueService;
import nextbook.domain.Clue;
import nextbook.domain.Tag;

import java.util.ArrayList;
import nextbook.domain.TagService;

public class DeleteTag extends Command {

    private TagService tagService;

    public DeleteTag(IO io, TagService tagService) {
        super(io);
        this.tagService = tagService;
    }

    @Override
    public void execute() {
        ArrayList<Tag> tags = tagService.readTags();
        for (int id = 1; id <= tags.size(); id++) {
            io.print("id (" + id + "), " + tags.get(id - 1));;
        }
        int id = io.readInt("Give id of tag to delete");

        if (id < 1 || id > tags.size()) {
            io.print("Invalid index");
            return;
        }
        Tag tag = tags.get(id - 1);

        tagService.remove(tag.getId());
        io.print("Tag removed successfully");
    }

}

