package nextbook.io;

import java.util.ArrayList;
import java.util.List;
import nextbook.domain.Clue;
import nextbook.domain.Tag;

public class StubIO implements IO {
    private List<String> lines;
    private int currentLine;
    private ArrayList<String> prints;

    public StubIO(List<String> values) {
        this.lines = values;
        prints = new ArrayList<>();
    }

    public void print(String toPrint) {
        //System.out.println("print " + toPrint);
        prints.add(toPrint);
    }

    public int readInt(String prompt) {
        print(prompt);
        //String i = lines.get(currentLine++);
        //System.out.println("readint" + i);
        //return Integer.parseInt(i);
        return Integer.parseInt(lines.get(currentLine++));
    }

    public ArrayList<String> getPrints() {
        return prints;
    }

    public String readLine(String prompt) {
        print(prompt);
        if (currentLine < lines.size()) {
            return lines.get(currentLine++);
        }
        return "";
    }

    public void print(Clue toPrint) {
        //System.out.println("clue " + toPrint);
        prints.add(toPrint.toString());
    }
    
    public void print(Tag toPrint) {
        prints.add(toPrint.toString());
    }

    public String nextLine() {
        if (currentLine < lines.size()) {
            return lines.get(currentLine++);
        }
        return "";
    }
}