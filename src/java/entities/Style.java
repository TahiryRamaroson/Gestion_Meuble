/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.sql.Connection;
import java.util.ArrayList;

import base.FonctionsDb;

/**
 *
 * @author Amboara
 */
public class Style {
     int id;
    String nomstyle;

    public Style(){}

    public Style(String id, String nom){
        setId(id);
        setNomstyle(nom);
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

    public String getNomstyle() {
        return nomstyle;
    }

    public void setNomstyle(String style) {
        this.nomstyle = style;
    }
    
    public void insert(Connection c) throws Exception{
        FonctionsDb fdb = new FonctionsDb();
        fdb.saveObject(c, this);
    }

    public static ArrayList selectAll(Connection c ) throws Exception{
         FonctionsDb fdb = new FonctionsDb();
         return fdb.getObject(c, "Style", "entities");
    }
}
