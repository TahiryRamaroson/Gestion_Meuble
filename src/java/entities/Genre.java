/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import base.FonctionsDb;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author tahir
 */
public class Genre {
        int id;
        String nomgenre;

    public Genre(){}
    
    public Genre(String id, String nom){
        setId(id);
        setNomgenre(nom);
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

    public String getNomgenre() {
        return nomgenre;
    }

    public void setNomgenre(String nomgenre) {
        this.nomgenre = nomgenre;
    }
    
    public void insert(Connection c) throws Exception{
        FonctionsDb fdb = new FonctionsDb();
        fdb.saveObject(c, this);
    }

    public static ArrayList selectAll(Connection c) throws Exception {
        FonctionsDb fdb = new FonctionsDb();
        return fdb.getObject(c, "Genre", "entities");
    }  
}
