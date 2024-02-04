/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import base.ConnexionDb;
import base.FonctionsDb;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author tahir
 */
public class Poste {
          int id;
          String nomposte;

    public Poste(){}

    public Poste(String id, String nom){
        setId(id);
        setNomposte(nom);
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

    public String getNomposte() {
        return nomposte;
    }

    public void setNomposte(String nomposte) {
        this.nomposte = nomposte;
    }

    public void insert(Connection c) throws Exception{
        FonctionsDb fdb = new FonctionsDb();
        fdb.saveObject(c, this);
    }
    
    public static ArrayList selectAll(Connection c ) throws Exception{
         FonctionsDb fdb = new FonctionsDb();
         return fdb.getObject(c, "Poste", "entities");
    }
    
    public static int getLastId(Connection connect){
        boolean iscreated = false;
        try {
            if(connect == null) {
                ConnexionDb con = new ConnexionDb("postgres", "meuble");
                connect = con.getConnection();
                iscreated = true;
            }
            String req = "select max(id) from Poste";
            Statement stat = connect.createStatement();
            ResultSet resultat = stat.executeQuery(req);
            int lastid = 0;
            while (resultat.next()) {
                lastid = resultat.getInt(1);
            }
            return lastid;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(iscreated == true) connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
