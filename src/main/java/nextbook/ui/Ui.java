package nextbook.ui;

import nextbook.domain.ClueService;
import nextbook.domain.Clue;
import nextbook.domain.Book;
import nextbook.domain.Video;

import java.util.Scanner;
import java.util.ArrayList;
import nextbook.io.IO;

public class Ui {
    
    private IO io;
    //private Scanner sc;
    private ClueService clueService;

    public Ui(IO io, ClueService clueService) {
        this.io = io;
        this.clueService = clueService;
    }

    public void start() {
        io.print("Give 'add book' to add book");
        io.print("Give 'add video' to add video");
        io.print("Give 'list' to list all recommendations");
        io.print("Give 'update book' to update information of book");
        io.print("Give 'update video' to update information of video");
        io.print("Give 'remove book' to delete book");
        io.print("Give 'remove video' to delete video");
        io.print("Give empty line to exit program");
        while (true) {
            io.print("");
            String command = io.nextLine();
            if (command.isEmpty()) {
                break;
            }

            if (command.equals("add book")) {
                String name = io.readLine("Give name of the book");
                String author = io.readLine("Give author of the book");
                String isbn = io.readLine("Give ISBN of the book");
                int year = io.readInt("Give year of publish of the book");
                String comment = io.readLine("Give comments to the book (all in one line)");

                Clue book = new Book(name, author);
                clueService.createClue(book);
                io.print("New book added");
            }

            if (command.equals("add video")) {
                String name = io.readLine("Give name of the video");
                String link = io.readLine("Give link to the video");
                int startTime = io.readInt("Give starting time of part of the video (in seconds)");

                Clue video = new Video(name, link, startTime);
                clueService.createClue(video);
                System.out.println("New video added");
            }

            if (command.equals("list")) {
                ArrayList<Clue> clues = clueService.readClues();
                for (Clue c: clues) {
                    io.print(c);
                }
            }

            if (command.equals("update book")) {
                String name = io.readLine("Give name of the book");
            }

            if (command.equals("update video")) {
                String name = io.readLine("Give name of the video");
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

