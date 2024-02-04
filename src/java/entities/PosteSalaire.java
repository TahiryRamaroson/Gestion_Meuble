/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import base.FonctionsDb;
import java.sql.Connection;
import java.time.LocalDateTime;

/**
 *
 * @author tahir
 */
public class PosteSalaire {
      int id;
      int idposte;
      double salairebase;
      LocalDateTime dateinsertion;
      
    public PosteSalaire(){}

    public PosteSalaire(String id, String idposte, String salaire, String dateinsertion){
        setId(id);
        setIdposte(idposte);
        setSalairebase(salaire);
        setDateinsertion(dateinsertion);
    }
      
    public PosteSalaire(String id, int idposte, String salaire, LocalDateTime dateinsertion){
        setId(id);
        setIdposte(idposte);
        setSalairebase(salaire);
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

    public int getIdposte() {
       return idposte;
    }

    public void setIdposte(int poste) {
        this.idposte = poste;
    }
    
    public void setIdposte(String idposte) {
        this.idposte = Integer.parseInt(idposte);
    }

    public double getSalairebase() {
        return salairebase;
    }

    public void setSalairebase(double salaire) {
        if (salaire<0) {
            throw new IllegalArgumentException("Salaire doit etre positif");
        }
        this.salairebase = salaire;
    }
    
    public void setSalairebase(String salaire) {
        if (Double.parseDouble(salaire)<0) {
            throw new IllegalArgumentException("Salaire doit etre positif");
        }
        this.salairebase = Double.parseDouble(salaire);
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
