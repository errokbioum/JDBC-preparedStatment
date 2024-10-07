/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.connexion;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OUMAIMA
 */
public class Connexion {
     private static  Connection cn;

    static {
        try {
    
    FileInputStream f = new FileInputStream("cfgg.properties");
    Properties p = new Properties();
    p.load(f);
    String url = p.getProperty("jdbc.url");
    String driver =p.getProperty("jdbc.driver");
    String username =p.getProperty("jdbc.username");
    String password =p.getProperty("jdbc.password");
    Class.forName(driver);
    cn= DriverManager.getConnection(url, username, password);
   
}      catch (IOException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
     public static Connection getCn() {
         return cn;
     }
    
}
