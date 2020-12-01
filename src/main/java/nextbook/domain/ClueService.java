package nextbook.domain;

import java.util.ArrayList;
import nextbook.dao.ClueDao;

public class ClueService {
    ClueDao dao;
    
    public ClueService(ClueDao dao) {
        this.dao = dao;
    }
    
    public void createClue(Clue clue) {
        dao.create(clue);
    }

    public ArrayList readClues() {
        return dao.getAll();
    }
    
    public ArrayList filterClues(String type) {
        return dao.filterClue(type);
    }
  
    public void remove(Clue clue) {
        dao.remove(clue);
    }
    
    public void update(Clue clue) {
        dao.update(clue);
    }
}
