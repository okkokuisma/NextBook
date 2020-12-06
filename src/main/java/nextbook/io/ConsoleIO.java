
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
        print(prompt);
        
        int x = 0;
        while (true) {
            String line = scanner.nextLine();

            try {
                x = Integer.parseInt(line);
                break;
            } catch (NumberFormatException e) {
                print("Invalid number format, try again!");
            }
        }
        return x;
    }

    public String readLine(String prompt) {
        print(prompt);
        return scanner.nextLine();
    }
}
