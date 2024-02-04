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
public class StockMatiere {
    int id;
    int idmatiere;
    int entree;
    int sortie;
    LocalDateTime dateachat;
    
    public StockMatiere(String id, String idmat, String entree, String sortie, String date){
        setId(id);
        setIdmatiere(idmat);
        setEntree(entree);
        setSortie(sortie);
        setDateachat(date);
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
    
    public LocalDateTime getDateachat() {
        return dateachat;
    }

    public void setDateachat(LocalDateTime dateinsertion) {
        this.dateachat = dateinsertion;
    }
    
    public void setDateachat(String dateinsertion) {
        this.dateachat = LocalDateTime.parse(dateinsertion);
    }
    
    public int getEntree() {
        return this.entree;
    }
    
    public int getSortie() {
        return this.sortie;
    }

    public void setEntree(int qte) {
        if (qte >= 0) {
            this.entree = qte;
        }
    }
    
    public void setSortie(int qte) {
        if (qte >= 0) {
            this.sortie = qte;
        }
    }

    public void setEntree(String qte) {
        setEntree(Integer.parseInt(qte));
    }
    
    public void setSortie(String qte) {
        setSortie(Integer.parseInt(qte));
    }
    
    public void insert(Connection c) throws Exception{
        FonctionsDb fdb = new FonctionsDb();
        fdb.saveObject(c, this);
    }
}
