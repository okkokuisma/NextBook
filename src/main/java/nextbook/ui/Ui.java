package nextbook.ui;

import nextbook.domain.ClueService;
import nextbook.domain.Clue;
import nextbook.domain.Book;
import nextbook.domain.Video;

import java.util.ArrayList;
import nextbook.io.IO;

public class Ui {
    
    private IO io;
    private ClueService clueService;
    private Command add;
    private Command list;
    private Command update;
    private Command exit;

    public Ui(IO io, ClueService clueService) {
        this.io = io;
        this.clueService = clueService;
        this.add = new Add(io, clueService);
        this.list = new List(io, clueService);
        this.update = new Update(io, clueService);
        this.exit = new Exit(io);
    }

    public void start() {
        io.print("Give 'add' to add book or video");
        io.print("Give 'list' to list all recommendations");
        io.print("Give 'update' to update information of clue");
        io.print("Give 'remove book' to delete book");
        io.print("Give 'remove video' to delete video");
        io.print("Give empty line to exit program");

        while (true) {
            io.print("");
            String command = io.nextLine();
            if (command.isEmpty()) {
                exit.execute();
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

            if (command.equals("remove book")) {
                String name = io.readLine("Give name of the book");

            }

            if (command.equals("remove video")) {
                String name = io.readLine("Give name of the video");
            }

        }
    }

}

