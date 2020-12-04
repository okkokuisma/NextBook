/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nextbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import nextbook.domain.Video;

/**
 *
 * @author okkokuisma
 */
public class SqlVideoDao {
    private Connection dbconn;
    private DbUtil dbUtil;

    public SqlVideoDao(DbUtil dbUtil) {
        this.dbUtil = dbUtil;
    }   
    
    public void create(Video video) {
        try {
            connect();
            PreparedStatement ps = dbconn.prepareStatement("INSERT INTO videos (name,url,time) VALUES (?,?,?)");
            ps.setString(1, video.getName());
            ps.setString(2, video.getLink());
            ps.setInt(3, video.getTime());
            ps.execute();
            
            dbconn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SqlBookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList getAll() {
        try {
            connect();
            Statement ps = dbconn.createStatement();
            ResultSet queryResults = ps.executeQuery("SELECT id, name, url, time FROM videos");
            
            ArrayList<Video> videos = new ArrayList<>();
            while (queryResults.next()) {
                Video video = new Video(queryResults.getString(2),
                        queryResults.getString(3),
                        queryResults.getInt(4));
                video.setId(queryResults.getInt(1));
                videos.add(video);
            }
            
            dbconn.close();
            return videos;
        } catch (SQLException ex) {
            Logger.getLogger(SqlBookDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }     
    }
    
    public void remove(int id) {
        try {
            connect();
            PreparedStatement ps = dbconn.prepareStatement("DELETE FROM videos WHERE id = ?");
            ps.setInt(1, id);
            ps.execute();
            
            dbconn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SqlBookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(Video video) {
        try {
            connect();
            PreparedStatement ps = dbconn.prepareStatement("UPDATE videos SET "
                + "name = ?, "
                + "url = ?, "
                + "time = ? "
                + "WHERE id = ?");
            ps.setString(1, video.getName());
            ps.setString(2, video.getLink());
            ps.setInt(3, video.getTime());
            ps.setInt(4, video.getId());
            ps.execute();
            
            dbconn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SqlBookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void connect() {
        dbconn = dbUtil.connect();
    }
}
