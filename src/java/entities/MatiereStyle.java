/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.sql.Connection;

import base.FonctionsDb;

/**
 *
 * @author Amboara
 */
public class MatiereStyle {
    int id;
    int idmatiere;
    int idstyle;
    
    public MatiereStyle(){}
    
    public MatiereStyle(String id, String idm, String ids){
        setId(id);
        setIdmatiere(idm);
        setIdstyle(ids);
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

    public int getIdmatiere() {
        return idmatiere;
    }

    public void setIdmatiere(int id) {
        this.idmatiere = id;
    }
    
    public void setIdmatiere(String id) {
        setIdmatiere(Integer.parseInt(id));
    }

    public int getIdstyle() {
        return idstyle;
    }

    public void setIdstyle(int id) {
        this.idstyle = id;
    }
    
    public void setIdstyle(String id) {
        setIdstyle(Integer.parseInt(id));
    }

    public void insert(Connection c) throws Exception{
        FonctionsDb fdb = new FonctionsDb();
        fdb.saveObject(c, this);
    }

}
