package nextbook.io;

import nextbook.domain.Clue;
import nextbook.domain.Tag;

public interface IO {
    void print(String toPrint);
    void print(Clue toPrint);
    void print(Tag toPrint);
    String nextLine();
    int readInt(String prompt);
    String readLine(String prompt);
}
