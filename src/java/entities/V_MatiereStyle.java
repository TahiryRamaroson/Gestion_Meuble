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
 * @author Amboara
 */
public class V_MatiereStyle {
    int id;
    int idmatiere;
    int idstyle;
    String nommatiere;
    String nomstyle;

    public V_MatiereStyle(){

    }

    public V_MatiereStyle(String id, String ids){
        setId(ids);
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
    
    public String getNommatiere() {
        return nommatiere;
    }

    public void setNommatiere(String nommatiere) {
        this.nommatiere = nommatiere;
    }
    
    public String getNomstyle() {
        return nomstyle;
    }

    public void setNomstyle(String style) {
        this.nomstyle = style;
    }

    public static ArrayList getListById(Connection c, int idstyle) throws Exception{
        FonctionsDb fdb = new FonctionsDb();
        String condition = " idstyle="+idstyle;
        return fdb.getObject(c, "V_MatiereStyle", "entities", condition);
    }

}
