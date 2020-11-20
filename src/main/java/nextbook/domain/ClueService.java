/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nextbook.domain;

import java.util.ArrayList;
import nextbook.dao.ClueDao;

/**
 *
 * @author okkokuisma
 */
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
}
