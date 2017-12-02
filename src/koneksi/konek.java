/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Farhan
 */
public class konek {
        static final String C_DRIVER = "com.mysql.jdbc.Driver";
        static final String C_URL = "jdbc:mysql://localhost/ta_pbo";
        
        static final String root = "root";
        static final String pass = "";
        
        public static Connection koneksi() {
            Connection conn = null;
            
        try {
            Class.forName(C_DRIVER);
            conn = DriverManager.getConnection(C_URL, root, pass);
        }catch (ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
        return conn;
        
        }
}
