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
        System.out.println("Give 'add book' to add book");
        System.out.println("Give 'add video' to add video");
        System.out.println("Give 'list' to list books");
        System.out.println("Give empty line to exit program");

        while (true) {
            System.out.println("");
            String command = sc.nextLine();
            if (command.isEmpty()) {
                break;
            }

            if (command.equals("add book")) {
                System.out.println("Give name of the book");
                String name = sc.nextLine();
                System.out.println("Give author of the book");
                String author = sc.nextLine();
                System.out.println("Give ISBN of the book");
                String isbn = sc.nextLine();
                System.out.println("Give year of publish of the book");
                int year = Integer.parseInt(sc.nextLine());
                System.out.println("Give comments to the book (all in one line)");
                String comment = sc.nextLine();

                Clue book = new Book(name, author);
                clueService.createClue(book);
                System.out.println("New book added");
            }

            if (command.equals("add video")) {
                System.out.println("Give name of the video");
                String name = sc.nextLine();
                System.out.println("Give link to the video");
                String link = sc.nextLine();
                System.out.println("Give starting time of part of the video (in seconds)");
                int startTime= Integer.parseInt(sc.nextLine());

                Clue book = new Video(name, link, startTime);
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

