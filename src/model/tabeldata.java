/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Farhan
 */
public class tabeldata {
    private final StringProperty id;
    private final StringProperty username;
    private final StringProperty password;
    private final StringProperty nama;
    private final StringProperty email;
    
    public tabeldata(String id, String username, String password, String nama, String email) {
        this.id = new SimpleStringProperty(id);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.nama = new SimpleStringProperty(nama);
        this.email = new SimpleStringProperty(email);
    }
    
    //Getters
    public String getId() {
        return id.get();
    }

    public String getUsername() {
        return username.get();
    }

    public String getPassword() {
        return password.get();
    }
    
    public String getNama() {
        return nama.get();
    }
    
    public String getEmail() {
        return email.get();
    }

    //Setters
    public void setId(String value) {
        id.set(value);
    }

    public void setUsername(String value) {
        username.set(value);
    }
    
    public void setPassword(String value) {
        password.set(value);
    }
    
    public void setNama(String value) {
        nama.set(value);
    }
    
    public void setEmail(String value) {
        email.set(value);
    }
    
    //Property values
    public StringProperty idProperty() {
        return id;
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public StringProperty passwordProperty() {
        return password;
    }
    
    public StringProperty namaProperty() {
        return nama;
    }
    
    public StringProperty emailProperty() {
        return email;
    }

}
