/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.sql.Connection;
import java.util.ArrayList;

import base.FonctionsDb;
import java.time.LocalDateTime;


public class OuvrierSalaire {
      int id;
      int idouvrier;
      double salairecoeff;
      LocalDateTime dateinsertion;
      
    public OuvrierSalaire(){}

    public OuvrierSalaire(String id, String idouvrier, String salaire, String dateinsertion){
        setId(id);
        setIdouvrier(idouvrier);
        setSalairecoeff(salaire);
        setDateinsertion(dateinsertion);
    }
      
    public OuvrierSalaire(String id, int idouvrier, String salaire, LocalDateTime dateinsertion){
        setId(id);
        setIdouvrier(idouvrier);
        setSalairecoeff(salaire);
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

    public int getIdouvrier() {
       return idouvrier;
    }

    public void setIdouvrier(int idouvrier) {
        this.idouvrier = idouvrier;
    }
    
    public void setIdouvrier(String idouvrier) {
        this.idouvrier = Integer.parseInt(idouvrier);
    }

    public double getSalairecoeff() {
        return salairecoeff;
    }

    public void setSalairecoeff(double salaire) {
        if (salaire<0) {
            throw new IllegalArgumentException("Salaire doit etre positif");
        }
        this.salairecoeff = salaire;
    }
    
    public void setSalairecoeff(String salaire) {
        if (Double.parseDouble(salaire)<0) {
            throw new IllegalArgumentException("Salaire doit etre positif");
        }
        this.salairecoeff = Double.parseDouble(salaire);
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
