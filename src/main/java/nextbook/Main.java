package nextbook;

import nextbook.ui.Ui;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ui commandlineUi = new Ui(sc);
        commandlineUi.start();
    }

}

