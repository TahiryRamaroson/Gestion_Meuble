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
 * @author Amboara
 */
public class PrixVente {
    int id;
    int idmeuble;
    int idstyle;
    int idvolume;
    double prix;
    LocalDateTime dateinsertion;
    
    public PrixVente(){}
    
    public PrixVente(String id, String idmeuble, String idvol, String idst, String prix, String date){
        setId(id);
        setIdmeuble(idmeuble);
        setIdvolume(idvol);
        setIdstyle(idst);
        setPrix(prix);
        setDateinsertion(date);
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
    
    public int getIdmeuble() {
        return this.idmeuble;
    }

    public void setIdmeuble(int idmeuble) {
        this.idmeuble = idmeuble;
    }

    public void setIdmeuble(String idmeuble) {
        setIdmeuble(Integer.parseInt(idmeuble));
    }
    
    public int getIdstyle() {
        return this.idstyle;
    }

    public void setIdstyle(int idstyle) {
        this.idstyle = idstyle;
    }

    public void setIdstyle(String idstyle) {
        setIdstyle(Integer.parseInt(idstyle));
    }

    public int getIdvolume() {
        return this.idvolume;
    }

    public void setIdvolume(int idvolume) {
        this.idvolume = idvolume;
    }

    public void setIdvolume(String idIdvolume) {
        setIdvolume(Integer.parseInt(idIdvolume));
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
