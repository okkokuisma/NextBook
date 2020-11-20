package nextbook.ui;

import java.util.Scanner;

public class Ui {

    private Scanner sc;

    public Ui(Scanner sc) {
        this.sc = sc;
    }

    public void start() {
        System.out.println("Give 'add' to add book");
        System.out.println("Give empty line to exit program");
        System.out.println("");

        while (true) {
            String command = sc.nextLine();
            if (command.isEmpty()) {
                break;
            }

            if (command.equals("add")) {
                System.out.println("Book added");
            }
            System.out.println("");
        }
    }

}

