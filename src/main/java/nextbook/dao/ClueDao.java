package nextbook.dao;

import java.util.ArrayList;
import nextbook.domain.Clue;
import nextbook.domain.Tag;

public interface ClueDao {
    public void create(Clue clue);
    public ArrayList getAll();
    public ArrayList filterClue(String type);
    public void remove(Clue clue);
    public void update(Clue clue);
}
