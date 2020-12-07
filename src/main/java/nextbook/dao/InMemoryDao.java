package nextbook.dao;

import java.util.ArrayList;
import nextbook.domain.Clue;
import nextbook.domain.Tag;

public class InMemoryDao implements ClueDao {
    ArrayList<Clue> clues;
    ArrayList<Clue> filter;

    public InMemoryDao() {
        clues = new ArrayList();
    }
    
    @Override
    public void create(Clue clue) {
        clues.add(clue);
    }

    @Override
    public ArrayList getAll() {
        return clues;
    }

    @Override
    public ArrayList filterClue(String type) {
        return filter;
    }
  
    public void remove(Clue clue) {
        clues.remove(clue);
    }

    @Override
    public void update(Clue clue) {
    }
    
}
