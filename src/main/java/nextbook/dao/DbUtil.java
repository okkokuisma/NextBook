/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nextbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author okkokuisma
 */
public class DbUtil {
    private Connection dbconn;
    private String databasePath;
    
    public DbUtil(boolean test) {
        if (test) {
            databasePath = "jdbc:sqlite:test.db";
        } else {
            databasePath = "jdbc:sqlite:NextBook.db";
        }
        
        try {
            dbconn = DriverManager.getConnection(databasePath);
            Statement s = dbconn.createStatement();

            s.execute("CREATE TABLE IF NOT EXISTS books ("
                    + "id INTEGER PRIMARY KEY,"
                    + "name TEXT,"
                    + "author TEXT,"
                    + "isbn TEXT,"
                    + "comment TEXT,"
                    + "year INTEGER)");
            s.execute("CREATE TABLE IF NOT EXISTS videos ("
                    + "id INTEGER PRIMARY KEY,"
                    + "name TEXT,"
                    + "url TEXT,"
                    + "time TEXT)");
            s.execute("CREATE TABLE IF NOT EXISTS blogs ("
                    + "id INTEGER PRIMARY KEY,"
                    + "name TEXT,"
                    + "author TEXT,"
                    + "url TEXT,"
                    + "comment TEXT)");
            s.execute("CREATE TABLE IF NOT EXISTS tags ("
                    + "id INTEGER PRIMARY KEY,"
                    + "tag TEXT");
            s.execute("CREATE TABLE IF NOT EXISTS book_tags ("
                    + "book_id INTEGER,"
                    + "tag_id INTEGER");
            s.execute("CREATE TABLE IF NOT EXISTS video_tags ("
                    + "video_id INTEGER,"
                    + "tag_id INTEGER");
            s.execute("CREATE TABLE IF NOT EXISTS blog_tags ("
                    + "blog_id INTEGER,"
                    + "tag_id INTEGER");

            dbconn.close();
        } catch (Exception e) {
        }  
    }
    
    public Connection connect() {
        try {
            dbconn = DriverManager.getConnection(databasePath);
        } catch (SQLException ex) {
        }
        return dbconn;
    }
}
