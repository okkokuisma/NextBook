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
    Connection dbconn;
    
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
            ResultSet queryResults = ps.executeQuery("SELECT name, url, time FROM videos");
            
            ArrayList<Video> videos = new ArrayList<>();
            while (queryResults.next()) {
                Video video = new Video(queryResults.getString(1),
                        queryResults.getString(2),
                        queryResults.getInt(3));
                videos.add(video);
            }
            
            dbconn.close();
            return videos;
        } catch (SQLException ex) {
            Logger.getLogger(SqlBookDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }     
    }
    
    private void connect() {
        try {
            dbconn = DriverManager.getConnection("jdbc:sqlite:NextBook.db");
        } catch (SQLException ex) {
            Logger.getLogger(SqlBookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
