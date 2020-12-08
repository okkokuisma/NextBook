
package nextbook.domain;

import java.io.File;
import nextbook.dao.DbUtil;
import nextbook.dao.SqlTagDao;
import nextbook.dao.TagDao;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

public class TagServiceTest {
    TagDao tagDao;
    TagService tagService;
    Tag tag;
    Tag tag2;

    
    @Before
    public void setUp() {
        tagDao = new SqlTagDao(new DbUtil(true));
        tagService = new TagService(tagDao);
        
        this.tag = new Tag("Tietojenkäsittely");
        tag.setId(0);
        this.tag2 = new Tag("Tietoturva");
        tag.setId(1);
        
        tagService.createTag(tag);
        tagService.createTag(tag2);
    }
    
    @After
    public void tearDown() {
        File testDb = new File("test.db");
        testDb.delete();
    }
    
    @Test
    public void rightTagIsSaved() {
        assertEquals(tagService.readTags().get(0), tag);
        assertEquals(tagService.readTags().get(1), tag2);
    }
    
    @Test
    public void rightTagIsRemoved() {
        tagService.remove(tag.getId());
        assertEquals(tagService.readTags().get(0), tag2);
    }

    @Test
    public void settingTag() {
        Video video = new Video("name", "https://www.youtube.com/", 20);
        tagService.setTag(video, tag);
    }
    
}
