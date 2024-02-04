/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import base.ConnexionDb;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;

import base.FonctionsDb;

/**
 *
 * @author Amboara
 */
public class Matiere {
    int id;
    String nommatiere;

    public Matiere(){}

    public Matiere(String id, String nom){
        setId(id);
        setNommatiere(nom);
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

    public String getNommatiere() {
        return nommatiere;
    }

    public void setNommatiere(String nommatiere) {
        this.nommatiere = nommatiere;
    }

    public void insert(Connection c) throws Exception{
        FonctionsDb fdb = new FonctionsDb();
        fdb.saveObject(c, this);
    }
    
    public static ArrayList selectAll(Connection c ) throws Exception{
         FonctionsDb fdb = new FonctionsDb();
         return fdb.getObject(c, "Matiere", "entities");
    }
    
    public static int getLastId(Connection connect){
        boolean iscreated = false;
        try {
            if(connect == null) {
                ConnexionDb con = new ConnexionDb("postgres", "meuble");
                connect = con.getConnection();
                iscreated = true;
            }
            String req = "select max(id) from Matiere";
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
    
    public static String getNom(Connection connect, int idmatiere){
        boolean iscreated = false;
        String valiny = "";
        try {
            if(connect == null) {
                ConnexionDb con = new ConnexionDb("postgres", "meuble");
                connect = con.getConnection();
                iscreated = true;
            }
            String req = "select nommatiere from Matiere where id="+idmatiere;
            Statement stat = connect.createStatement();
            ResultSet resultat = stat.executeQuery(req);
            
            while (resultat.next()) {
                valiny = resultat.getString(1);
            }
            return valiny;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(iscreated == true) connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return valiny;
    }
}
