package nextbook.ui;

import nextbook.io.IO;

public abstract class Command {
    protected IO io;
    public Command(IO io) {
        this.io = io;
    }

    public abstract void execute();
}
