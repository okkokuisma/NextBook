package nextbook.ui;

import nextbook.domain.ClueService;
import nextbook.domain.Clue;
import nextbook.domain.Book;

import java.util.Scanner;
import java.util.ArrayList;

public class Ui {

    private Scanner sc;
    private ClueService clueService;

    public Ui(Scanner sc, ClueService clueService) {
        this.sc = sc;
        this.clueService = clueService;
    }

    public void start() {
        System.out.println("Give 'add' to add book");
        System.out.println("Give 'list' to list books");
        System.out.println("Give empty line to exit program");

        while (true) {
            System.out.println("");
            String command = sc.nextLine();
            if (command.isEmpty()) {
                break;
            }

            if (command.equals("add")) {
                System.out.println("Give name of the book");
                String name = sc.nextLine();
                System.out.println("Give author of the book");
                String author = sc.nextLine();
                Clue book = new Book(name, author);
                clueService.createClue(book);
                System.out.println("New book added");
            }

            if (command.equals("list")) {
                ArrayList<Clue> clues = clueService.readClues();
                for (Clue c: clues) {
                    System.out.println(c);
                }
            }

        }
    }

}

