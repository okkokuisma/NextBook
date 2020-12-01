
package nextbook.io;

import java.util.Scanner;
import nextbook.domain.Clue;

public class ConsoleIO implements IO {
    private Scanner scanner = new Scanner(System.in);
    
    public void print(String toPrint) {
        System.out.println(toPrint);
    }
    
    public void print(Clue toPrint) {
        System.out.println(toPrint);
    }
    
    public String nextLine() {
        return scanner.nextLine();
    }

    public int readInt(String prompt) {
        System.out.println(prompt);
        
        String line = scanner.nextLine();
        if (!line.isEmpty()) {
            return Integer.parseInt(line);
        }
        return -1;
    }

    public String readLine(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
}
