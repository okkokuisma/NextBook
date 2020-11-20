package nextbook;

import nextbook.ui.Ui;
import nextbook.domain.ClueService;
import nextbook.dao.ClueDao;
import nextbook.dao.InMemoryDao;

import java.util.Scanner;
import static nextbook.dao.SqlClueDao.connect;

public class Main {

    public static void main(String[] args) {
        connect();
        Scanner sc = new Scanner(System.in);
        ClueDao dao = new InMemoryDao();
        ClueService clueService = new ClueService(dao);

        Ui commandlineUi = new Ui(sc, clueService);
        commandlineUi.start();
    }

}

