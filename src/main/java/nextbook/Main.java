package nextbook;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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

