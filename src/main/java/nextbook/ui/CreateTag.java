package nextbook.ui;

import nextbook.io.IO;
import nextbook.domain.Tag;

public class CreateTag extends Command {

    public CreateTag(IO io) {
        super(io);
    }

    @Override
    public void execute() {
        String name = io.readLine("Give name of tag");
        io.print("Tag is added in later implementation");
    }

}
