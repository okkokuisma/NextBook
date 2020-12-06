
package nextbook.dao;

import java.util.ArrayList;
import nextbook.domain.Clue;
import nextbook.domain.Tag;

public interface TagDao {
    public void create(Tag tag);
    public void setTag(Clue clue, Tag tag);
    public ArrayList getAll();
    public ArrayList filterByTag(Tag tag);
    public void remove(int id);
    public void removeTagFromClue(Clue clue, Tag tag);
}
