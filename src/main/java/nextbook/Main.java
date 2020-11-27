package nextbook;

import nextbook.ui.Ui;
import nextbook.domain.ClueService;
import nextbook.dao.ClueDao;
import nextbook.dao.InMemoryDao;

import java.util.Scanner;
import static nextbook.dao.SqlClueDao.connect;
import nextbook.io.ConsoleIO;
import nextbook.io.IO;

public class Main {

    public static void main(String[] args) {
        connect();
        Scanner sc = new Scanner(System.in);
        IO io = new ConsoleIO();
        ClueDao dao = new InMemoryDao();
        ClueService clueService = new ClueService(dao);

        //Ui commandlineUi = new Ui(sc, clueService);
        Ui commandlineUi = new Ui(io, clueService);
        commandlineUi.start();
    }

}

