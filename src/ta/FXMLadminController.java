/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import koneksi.konek;
import model.tabeldata;

/**
 * FXML Controller class
 *
 * @author Farhan
 */
public class FXMLadminController implements Initializable {

    
    @FXML
    private TableView<tabeldata> tabeluser;
    
    @FXML
    private TableColumn<tabeldata, String> tabelid;

    @FXML
    private TableColumn<tabeldata, String> tabelusername;

    @FXML
    private TableColumn<tabeldata, String> tabelpassword;

    @FXML
    private TableColumn<tabeldata, String> tabelnama;

    @FXML
    private TableColumn<tabeldata, String> tabelemail;
    
    @FXML
    private JFXButton back;
    
     @FXML
    private JFXButton update;
     
    private ObservableList<tabeldata> data;
    private konek dc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dc = new konek();
    }
    
    @FXML
    void update(ActionEvent event) {
        try {
            Connection conn = dc.koneksi();
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM login");
            while (rs.next()) {
                //get string from db,whichever way 
                data.add(new tabeldata(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }

        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        }
        
        //Set cell value factory to tableview.
        //NB.PropertyValue Factory must be the same with the one set in model class.
        tabelid.setCellValueFactory(new PropertyValueFactory<>("id"));
        tabelusername.setCellValueFactory(new PropertyValueFactory<>("username"));
        tabelpassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        tabelnama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        tabelemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        
        tabeluser.setItems(null);
        tabeluser.setItems(data);
    }

    @FXML
    private void kembali(ActionEvent event) {
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
    }
}
