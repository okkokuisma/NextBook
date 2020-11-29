package nextbook.io;

import nextbook.domain.Clue;

public interface IO {
    void print(String toPrint);
    void print(Clue toPrint);
    String nextLine();
    int readInt(String prompt);
    String readLine(String prompt);
}
