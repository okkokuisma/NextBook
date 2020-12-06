package nextbook.ui;

import nextbook.io.IO;

import java.util.ArrayList;

public class ListTags extends Command {

    public ListTags(IO io) {
        super(io);
    }

    @Override
    public void execute() {
        io.print("This will list all tags");
    }

}

