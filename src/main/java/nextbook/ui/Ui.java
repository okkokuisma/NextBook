package nextbook.ui;

import java.util.HashMap;
import nextbook.domain.ClueService;
import nextbook.domain.TagService;

import nextbook.io.IO;

public class Ui {

    private IO io;
    private ClueService clueService;
    private TagService tagService;
    private HashMap<String, Command> commands;

    public Ui(IO io, ClueService clueService, TagService tagService) {
        this.io = io;
        this.clueService = clueService;
        this.tagService = tagService;
        this.commands = new HashMap<>();
        commands.put("add", new Add(io, clueService));
        commands.put("list", new List(io, clueService));
        commands.put("update", new Update(io, clueService));
        commands.put("filter", new Filter(io, clueService, tagService));
        commands.put("remove", new Remove(io, clueService));
        commands.put("set tag", new SetTag(io, clueService, tagService));
        commands.put("create tag", new CreateTag(io, tagService));
        commands.put("list tags", new ListTags(io, tagService));
        commands.put("remove tag", new RemoveTag(io, clueService, tagService));
        commands.put("delete tag", new DeleteTag(io, tagService));
    }

    public void start() {
        io.print("Give 'add' to add book, video or blog post");
        io.print("Give 'list' to list all recommendations");
        io.print("Give 'filter' to filter recommendations by type");
        io.print("Give 'update' to update information of recommendation");
        io.print("Give 'remove' to delete recommendation");
        io.print("Give 'create tag' to add new tag");
        io.print("Give 'list tags' to show all tags");
        io.print("Give 'set tag' to give tag to recommendation");
        io.print("Give 'remove tag' to remove tag from recommendation");
        io.print("Give 'delete tag' to delete tag");
        io.print("Give empty line to exit program");

        while (true) {
            io.print("");
            String command = io.nextLine();
            if (command.isEmpty()) {
                break;
            }
            
            if (commands.containsKey(command)) {
                commands.get(command).execute();
            }

        }
    }

}
