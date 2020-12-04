package nextbook.ui;

import nextbook.domain.ClueService;

import nextbook.io.IO;

public class Ui {

    private IO io;
    private ClueService clueService;
    private Command add;
    private Command list;
    private Command update;
    private Command remove;
    private Command filter;
    private Command exit;

    public Ui(IO io, ClueService clueService) {
        this.io = io;
        this.clueService = clueService;
        this.add = new Add(io, clueService);
        this.list = new List(io, clueService);
        this.update = new Update(io, clueService);
        this.filter = new Filter(io, clueService);
        this.remove = new Remove(io, clueService);
        this.exit = new Exit(io);
    }

    public void start() {
        io.print("Give 'add' to add book, video or blog post");
        io.print("Give 'list' to list all recommendations");
        io.print("Give 'filter' to filter recommendations by type");
        io.print("Give 'update' to update information of recommendation");
        io.print("Give 'remove' to delete recommendation");
        io.print("Give empty line to exit program");

        while (true) {
            io.print("");
            String command = io.nextLine();
            if (command.isEmpty()) {
                break;
            }

            if (command.equals("add")) {
                add.execute();
            }

            if (command.equals("list")) {
                list.execute();
            }

            if (command.equals("update")) {
                update.execute();
            }

            if (command.equals("filter")) {
                filter.execute();
            }
          
            if (command.equals("remove")) {
                remove.execute();
            }

        }
    }

}
