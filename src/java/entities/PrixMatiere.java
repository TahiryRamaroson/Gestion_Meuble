/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.sql.Connection;
import java.util.ArrayList;

import base.FonctionsDb;
import java.time.LocalDateTime;


public class PrixMatiere {
      int id;
      int idmatiere;
      double prix;
      LocalDateTime dateinsertion;
      
    public PrixMatiere(){}

    public PrixMatiere(String id, String idmatiere, String prix, String dateinsertion){
        setId(id);
        setIdmatiere(idmatiere);
        setPrix(prix);
        setDateinsertion(dateinsertion);
    }
      
    public PrixMatiere(String id, int idmatiere, String prix, LocalDateTime dateinsertion){
        setId(id);
        setIdmatiere(idmatiere);
        setPrix(prix);
        setDateinsertion(dateinsertion);
    }
      

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setId(String id) {
        this.id = Integer.parseInt(id);
    }

    public int getIdmatiere() {
       return idmatiere;
    }

    public void setIdmatiere(int idmatiere) {
        this.idmatiere = idmatiere;
    }
    
    public void setIdmatiere(String idmatiere) {
        this.idmatiere = Integer.parseInt(idmatiere);
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        if (prix<0) {
            throw new IllegalArgumentException("Prix doit etre positif");
        }
        this.prix = prix;
    }
    
    public void setPrix(String prix) {
        if (Double.parseDouble(prix)<0) {
            throw new IllegalArgumentException("Prix doit etre positif");
        }
        this.prix = Double.parseDouble(prix);
    }

    public LocalDateTime getDateinsertion() {
        return dateinsertion;
    }

    public void setDateinsertion(LocalDateTime dateinsertion) {
        this.dateinsertion = dateinsertion;
    }
    
    public void setDateinsertion(String dateinsertion) {
        this.dateinsertion = LocalDateTime.parse(dateinsertion);
    }
    
    public void insert(Connection c) throws Exception{
        FonctionsDb fdb = new FonctionsDb();
        fdb.saveObject(c, this);
    }
}
