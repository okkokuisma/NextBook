/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nextbook.domain;

import java.util.ArrayList;
import nextbook.dao.TagDao;

/**
 *
 * @author okkokuisma
 */
public class TagService {
    TagDao dao;

    public TagService(TagDao dao) {
        this.dao = dao;
    }
    
    public void createTag(Tag tag) {
        dao.create(tag);
    }
    
    public ArrayList readTags() {
        return dao.getAll();
    }
    
    public void remove(int id) {
        dao.remove(id);
    }
    
    public ArrayList filterCluesByTag(Clue clue, Tag tag) {
        return dao.filterByTag(tag);
    }
    
    public void setTag(Clue clue, Tag tag) {
        dao.setTag(clue, tag);
    }
    
    public void removeTagFromClue(Clue clue, Tag tag) {
        dao.removeTagFromClue(clue, tag);
    }
}
