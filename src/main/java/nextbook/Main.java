package nextbook;

import nextbook.ui.Ui;
import nextbook.domain.ClueService;
import nextbook.dao.ClueDao;
import java.util.Scanner;
import nextbook.dao.SqlClueDao;
import nextbook.dao.DbUtil;
import nextbook.io.ConsoleIO;
import nextbook.io.IO;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DbUtil dbUtil = new DbUtil(false);
        ClueDao dao = new SqlClueDao(dbUtil);
        IO io = new ConsoleIO();
        ClueService clueService = new ClueService(dao);

        //Ui commandlineUi = new Ui(sc, clueService);
        Ui commandlineUi = new Ui(io, clueService);
        commandlineUi.start();
    }

}

