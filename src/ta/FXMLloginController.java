/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Farhan
 */
public class FXMLloginController implements Initializable {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXTextField password;
    @FXML
    private JFXButton login;
    @FXML
    private JFXButton signup;
    
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        conn = koneksi.konek.koneksi();
    }    

    @FXML
    private void log(ActionEvent event) {
        String user = username.getText();
        String pass = password.getText();
        String sql = "select * from login where username = ? && password = ?";
        
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            stmt.setString(2, pass);
            rs = stmt.executeQuery();
            while(rs.next()){
                JOptionPane.showMessageDialog(null, "Hello "+rs.getString(4));
                if (user.equalsIgnoreCase("admin")){
                    try {
                     // Hide this current window (if this is what you want)
                    ((Node)(event.getSource())).getScene().getWindow().hide();
            
                    // Load the new fxml
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("FXMLadmin.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            
                    // Create new stage (window), then set the new Scene
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setTitle("My Money");
                    stage.show();
            
                    } catch (IOException e) {
                        System.out.println("Failed to create new Window." + e);
                    }
                }else {
                   try {
                     // Hide this current window (if this is what you want)
                    ((Node)(event.getSource())).getScene().getWindow().hide();
            
                    // Load the new fxml
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("FXMLindex.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 478, 229);
            
                    // Create new stage (window), then set the new Scene
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setTitle("My Money");
                    stage.show();
            
                    } catch (IOException e) {
                         System.out.println("Failed to create new Window." + e);
                    } 
                }
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }

    @FXML
    private void sign(ActionEvent event) {
        try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLdaftar.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 431, 330);
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("My Money");
            stage.show();
            
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }
    }
}
