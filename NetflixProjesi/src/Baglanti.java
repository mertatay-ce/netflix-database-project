
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mert Atay
 */
public class Baglanti {
       
    static Connection myConn=null;
    static Statement myStat;
    static ResultSet myRs;
    
     public static void yap(){
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            myConn = DriverManager.getConnection("jdbc:sqlite:Netflix.db");
            myStat=myConn.createStatement();
        } catch (SQLException ex) {
            System.out.println("Baglantı Saglanamadı");
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public static ResultSet sorgulama(String sql_sorgu){
         
        try {
            myRs=myStat.executeQuery(sql_sorgu);
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myRs;
     }
     
     public static void kapat(){
       
         try {
            myConn.close();
         } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     
     public static void kayit_ekle(String sql_sorgu1){
        try {
            myStat.executeUpdate(sql_sorgu1);
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
}
