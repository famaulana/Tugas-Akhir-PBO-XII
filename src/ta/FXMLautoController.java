/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Farhan
 */
public class FXMLautoController implements Initializable {
    
    @FXML
    private JFXTextField g;
    @FXML
    private JFXTextField b;
    @FXML
    private JFXTextField t;
    @FXML
    private JFXButton Proses;
    @FXML
    private JFXButton Reset;
    @FXML
    private JFXTextArea result;
    @FXML
    private JFXButton back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    

    @FXML
    void kembali(ActionEvent event) {
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
    
    @FXML
    private void proses(ActionEvent event) {
    int dana,dana1;
    int gaji = Integer.parseInt(g.getText());
    int belanja = Integer.parseInt(b.getText());
    int target = Integer.parseInt(t.getText());
    dana = gaji-(belanja+target);
    dana1 = dana/31;
    result.setText("Gaji : " + gaji + "\nBelanja Bulanan : " + belanja + "\nTarget Tabungan : " + target +
                "\nAnda memiliki dana makan sebesar : " + dana + "\nDana makan per hari : " + dana1);
    }

    @FXML
    private void reset(ActionEvent event) {
        g.setText("");
        b.setText("");
        t.setText("");
        result.setText("");
    }
    
}
