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
public class FXMLdaftarController implements Initializable {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXTextField password;
    @FXML
    private JFXTextField nama;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXButton daftar;
    
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
    private void signup(ActionEvent event) {
        String user = username.getText();
        String pass = password.getText();
        String nama1 = nama.getText();
        String email1 = email.getText();
        String sql = "INSERT INTO `login`(`username`, `password`, `nama`, `email`) VALUES (?,?,?,?)";
        
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            stmt.setString(2, pass);
            stmt.setString(3, nama1);
            stmt.setString(4, email1);
            int i = stmt.executeUpdate();
            if (i == 1){
                JOptionPane.showMessageDialog(null, "Berhasil, Silahkan LogIn");
                try {
                     // Hide this current window (if this is what you want)
                    ((Node)(event.getSource())).getScene().getWindow().hide();
            
                    // Load the new fxml
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("FXMLlogin.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 431, 256);
            
                    // Create new stage (window), then set the new Scene
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setTitle("My Money");
                    stage.show();
            
                } catch (IOException e) {
                    System.out.println("Failed to create new Window." + e);
                }
            }else {
                JOptionPane.showMessageDialog(null, "Gagal, Mohon Coba Lagi!!");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        }
    }
