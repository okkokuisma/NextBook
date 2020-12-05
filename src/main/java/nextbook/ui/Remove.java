package nextbook.ui;

import nextbook.io.IO;
import nextbook.domain.ClueService;
import nextbook.domain.Clue;
import nextbook.domain.Book;
import nextbook.domain.Video;

import java.util.ArrayList;

public class Remove extends Command {

    private ClueService clueService;

    public Remove(IO io, ClueService clueService) {
        super(io);
        this.clueService = clueService;
    }

    @Override
    public void execute() {
        ArrayList<Clue> clues = clueService.readClues();
        for (int id = 1; id <= clues.size(); id++) {
            io.print("id (" + id + "), " + clues.get(id - 1));;
        }
        int id = 0;
        try {
            id = io.readInt("Give id of clue to update");;
        } catch (NumberFormatException ex) {
            System.out.println("Invalid input! You have to enter a number");
            return;
        }

        Clue clue = clues.get(id - 1);

        clueService.remove(clue);
        io.print("Removed successfully");
    }

}
