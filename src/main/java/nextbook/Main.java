package nextbook;

import nextbook.ui.Ui;
import nextbook.domain.ClueService;
import nextbook.domain.TagService;
import nextbook.dao.ClueDao;
import nextbook.dao.TagDao;
import nextbook.dao.SqlClueDao;
import nextbook.dao.SqlTagDao;
import nextbook.dao.DbUtil;
import nextbook.io.ConsoleIO;
import nextbook.io.IO;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DbUtil dbUtil = new DbUtil(false);
        ClueDao clueDao = new SqlClueDao(dbUtil);
        TagDao tagDao = new SqlTagDao(dbUtil);
        IO io = new ConsoleIO();
        ClueService clueService = new ClueService(clueDao);
        TagService tagService = new TagService(tagDao);

        Ui commandlineUi = new Ui(io, clueService, tagService);
        commandlineUi.start();
    }

}

