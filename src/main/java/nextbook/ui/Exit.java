package nextbook.ui;

import nextbook.io.IO;

public class Exit extends Command {

    public Exit(IO io) {
        super(io);
    }

    @Override
    public void execute() {
        io.print("Thanks, bye!");
        System.exit(0);
    }

}

