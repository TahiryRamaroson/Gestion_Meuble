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
public class CommandeMeuble {
    int id;
    int idmeuble;
    int idstyle ;
    int idvolume;
    LocalDateTime datecommande;
    int qte ;
    int idclient;
    
    public CommandeMeuble(String id, String idm, String ids, String idv, String date, String qte, String idc){
        setId(id);
        setIdmeuble(idm);
        setIdstyle(ids);
        setIdvolume(idv);
        setDatecommande(date);
        setQte(qte);
        setIdclient(idc);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setId(String id) {
        setId(Integer.parseInt(id));
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
    
    public int getQte() {
        return this.qte;
    }

    public void setQte(int qte) {
        if (qte > 0) {
            this.qte = qte;
        }
    }

    public void setQte(String qte) {
        setQte(Integer.parseInt(qte));
    }
    
    public LocalDateTime getDatecommande() {
        return datecommande;
    }

    public void setDatecommande(LocalDateTime dateinsertion) {
        this.datecommande = dateinsertion;
    }
    
    public void setDatecommande(String dateinsertion) {
        this.datecommande = LocalDateTime.parse(dateinsertion);
    }
    
    public int getIdclient() {
        return this.idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public void setIdclient(String idclient) {
        setIdclient(Integer.parseInt(idclient));
    }
    
    public void insert(Connection c) throws Exception{
        FonctionsDb fdb = new FonctionsDb();
        fdb.saveObject(c, this);
    }
    
    
}
