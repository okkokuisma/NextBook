package nextbook.ui;

import nextbook.io.IO;
import nextbook.domain.Tag;
import nextbook.domain.TagService;

public class CreateTag extends Command {

    private TagService tagService;

    public CreateTag(IO io, TagService tagService) {
        super(io);
        this.tagService = tagService;
    }

    @Override
    public void execute() {
        String name = io.readLine("Give name of tag");
        Tag tag = new Tag(name);
        tagService.createTag(tag);
        io.print("New tag created");
    }

}
