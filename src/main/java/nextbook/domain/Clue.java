package nextbook.domain;

public class Clue implements Comparable<Clue> {

    @Override
    public int compareTo(Clue other) {
        if (other instanceof Book) {
            if (this instanceof Book) {
                return ((Book) this).getAuthor().compareTo( ((Book) other).getAuthor() );
            }
            return 1;
        }
        if (other instanceof Video) {
            if (this instanceof Video) {
                return ((Video) this).getName().compareTo( ((Video) other).getName() );
            }
            return 1;
        }
        return 0;
    }
    
}
