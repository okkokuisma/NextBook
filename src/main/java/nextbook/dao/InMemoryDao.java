/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nextbook.dao;

import java.util.ArrayList;
import nextbook.domain.Clue;

/**
 *
 * @author okkokuisma
 */
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
    
}
