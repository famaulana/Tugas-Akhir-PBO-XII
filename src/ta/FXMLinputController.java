/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class FXMLinputController implements Initializable {
    
    ObservableList<String> list1 = FXCollections.observableArrayList("Laundry","Berobat","Perabot","Alat Tulis");
    ObservableList<String> list2 = FXCollections.observableArrayList("Laundry","Berobat","Perabot","Alat Tulis");
    ObservableList<String> list3 = FXCollections.observableArrayList("Laundry","Berobat","Perabot","Alat Tulis");

    @FXML
    private JFXTextField g;
    @FXML
    private JFXTextField b;
    @FXML
    private JFXTextField u;
    @FXML
    private JFXTextField t;
    @FXML
    private JFXButton Reset;
    @FXML
    private JFXButton Proses;
    @FXML
    private JFXTextArea result;
    @FXML
    private JFXTextField c1;
    @FXML
    private JFXComboBox<String> combo1;
     @FXML
    private JFXButton back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        combo1.setItems(list1);
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
    private void reset(ActionEvent event) {
        g.setText("");
        b.setText("");
        u.setText("");
        t.setText("");
        result.setText("");
        c1.setText("");
        combo1.setValue("category");
    }

    @FXML
    private void proses(ActionEvent event) {
    int total, makan, sisa;
    int gaji = Integer.parseInt(g.getText());
    int belanja = Integer.parseInt(b.getText());
    int unex = Integer.parseInt(u.getText());
    int tabungan = Integer.parseInt(t.getText());
    int cat1 = Integer.parseInt(c1.getText());
    String ca1 = combo1.getValue();
    
    if (cat1 == 0){
        total = belanja+unex+tabungan;
        sisa = gaji-total;
        makan = sisa/31;
    
    result.setText("Hasil Perhitungan :\nGaji : " + gaji + "\nBelanja : " + belanja + "\nTidak Terprediksi : " + unex +
            "\nTabungan : " + tabungan + "\nTotal Pengeluaran : " + total + "\nBiaya Makan 1 Bulan : " + sisa + 
            "\nBiaya Makan 1 Hari : " + makan);
    }
    else {
        total = belanja+unex+tabungan+cat1;
        sisa = gaji-total;
        makan = sisa/31;
    
    result.setText("Hasil Perhitungan :\nGaji : " + gaji + "\nBelanja : " + belanja + "\nTidak Terprediksi : " + unex +
            "\nTabungan : " + tabungan + "\n" + ca1 + " : " + cat1 +
            "\nTotal Pengeluaran : " + total + "\nBiaya Makan 1 Bulan : " + sisa + 
            "\nBiaya Makan 1 Hari : " + makan);
        
    }
  }
}
