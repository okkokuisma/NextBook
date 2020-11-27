package nextbook;

import nextbook.ui.Ui;
import nextbook.domain.ClueService;
import nextbook.dao.ClueDao;
import nextbook.dao.InMemoryDao;

import java.util.Scanner;
import nextbook.dao.SqlClueDao;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClueDao dao = new SqlClueDao();
        ClueService clueService = new ClueService(dao);

        Ui commandlineUi = new Ui(sc, clueService);
        commandlineUi.start();
    }

}

