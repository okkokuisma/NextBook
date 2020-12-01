
package nextbook;

import java.util.ArrayList;
import java.util.List;
import nextbook.dao.ClueDao;
import nextbook.domain.Clue;

public class ClueDaoForTests implements ClueDao {
    
    ArrayList<Clue> clues;

    public ClueDaoForTests() {
        this.clues = new ArrayList();
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
    public void remove(Clue clue) {
        clues.remove(clue);
    }

    @Override
    public void update(Clue clue) {
        //
    }
    
}
