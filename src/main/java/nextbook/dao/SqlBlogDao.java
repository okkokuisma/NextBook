
package nextbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import nextbook.domain.Blog;

public class SqlBlogDao {
    Connection dbconn;
    DbUtil dbUtil;

    public SqlBlogDao(DbUtil dbUtil) {
        this.dbUtil = dbUtil;
    }
    
    public void create(Blog blog) {
        try {
            connect();
            PreparedStatement ps = dbconn.prepareStatement("INSERT INTO blogs (name,author,url,comment) VALUES (?,?,?,?)");
            ps.setString(1, blog.getName());
            ps.setString(2, blog.getAuthor());
            ps.setString(3, blog.getLink());
            ps.setString(4, blog.getComment());
            ps.execute();
            
            dbconn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SqlBlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList getAll() {
        try {
            connect();
            Statement ps = dbconn.createStatement();
            ResultSet queryResults = ps.executeQuery("SELECT id, name, author, url, comment FROM blogs");
            
            ArrayList<Blog> blogs = getQueryResultAsListOfClues(queryResults);
            
            dbconn.close();
            return blogs;
        } catch (SQLException ex) {
            Logger.getLogger(SqlBlogDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }
    
    public void remove(int id) {
        try {
            connect();
            PreparedStatement ps = dbconn.prepareStatement("DELETE FROM blogs WHERE id = ?");
            ps.setInt(1, id);
            ps.execute();
            
            dbconn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SqlBlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(Blog blog) {
        try {
            connect();
            PreparedStatement ps = dbconn.prepareStatement("UPDATE blogs SET "
                    + "name = ?, "
                    + "author = ?, "
                    + "url = ?, "
                    + "comment = ? "
                    + "WHERE id = ?");
            ps.setString(1, blog.getName());
            ps.setString(2, blog.getAuthor());
            ps.setString(3, blog.getLink());
            ps.setString(4, blog.getComment());
            ps.setInt(5, blog.getId());
            ps.execute();
            
            dbconn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SqlBlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected static ArrayList getQueryResultAsListOfClues(ResultSet queryResults) {
        ArrayList<Blog> blogs = new ArrayList<>();
        
        try {
            while (queryResults.next()) {
                Blog blog = new Blog(queryResults.getString(2),
                        queryResults.getString(3),
                        queryResults.getString(4),
                        queryResults.getString(5));
                blog.setId(queryResults.getInt(1));
                blogs.add(blog);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlBlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return blogs;
    }
    
    private void connect() {
        dbconn = dbUtil.connect();
    }
}
