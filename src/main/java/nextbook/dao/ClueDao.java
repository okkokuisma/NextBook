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
public interface ClueDao {
    public void create(Clue clue);
    public ArrayList getAll();
    public ArrayList filterClue(String type);
    public void remove(Clue clue);
    public void update(Clue clue);
}
