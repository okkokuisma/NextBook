package nextbook.ui;

import nextbook.io.IO;

import java.util.ArrayList;
import nextbook.domain.Tag;
import nextbook.domain.TagService;

public class ListTags extends Command {
    
    private TagService tagService;

    public ListTags(IO io, TagService tagService) {
        super(io);
        this.tagService = tagService;
    }

    @Override
    public void execute() {
        ArrayList<Tag> tags = tagService.readTags();
        
        for (Tag tag : tags) {
            io.print(tag);
        }
    }

}

