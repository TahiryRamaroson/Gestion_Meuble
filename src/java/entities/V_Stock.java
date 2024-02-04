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
 * @author Amboara
 */
public class V_Stock {
    String nommatiere;
    int idmatiere;
    int totalqte;
    
    public int getIdmatiere() {
        return this.idmatiere;
    }

    public void setIdmatiere(int idmatiere) {
        this.idmatiere = idmatiere;
    }

    public void setIdmatiere(String idmatiere) {
        setIdmatiere(Integer.parseInt(idmatiere));
    }

    public String getNommatiere() {
        return nommatiere;
    }

    public void setNommatiere(String nommatiere) {
        this.nommatiere = nommatiere;
    }
    
    public int getTotalqte() {
        return this.totalqte;
    }

    public void setTotalqte(int qte) {
        this.totalqte = qte;
    }

    public void setTotalqte(String qte) {
        setTotalqte(Integer.parseInt(qte));
    }
    
     public static ArrayList getListById(Connection c, int idmatiere) throws Exception{
        FonctionsDb fdb = new FonctionsDb();
        String condition = " idmatiere="+idmatiere;
        return fdb.getObject(c, "V_Stock", "entities", condition);
    }
     
      public static ArrayList selectAll(Connection c ) throws Exception{
         FonctionsDb fdb = new FonctionsDb();
         return fdb.getObject(c, "V_Stock", "entities");
    }
      
    public static boolean checkQte(Connection connect, int qte, int idmatiere){
        boolean iscreated = false;
        try {
            if(connect == null) {
                ConnexionDb con = new ConnexionDb("postgres", "meuble");
                connect = con.getConnection();
                iscreated = true;
            }
            String req = "select totalQte from V_Stock where idmatiere="+idmatiere;
            Statement stat = connect.createStatement();
            ResultSet resultat = stat.executeQuery(req);
            int totalqte = 0;
            while (resultat.next()) {
                totalqte = resultat.getInt(1);
            }
            if(qte>totalqte) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(iscreated == true) connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    
    public static int getQte(Connection connect, int idmatiere){
        boolean iscreated = false;
        int totalqte = 0;
        try {
            if(connect == null) {
                ConnexionDb con = new ConnexionDb("postgres", "meuble");
                connect = con.getConnection();
                iscreated = true;
            }
            String req = "select totalQte from V_Stock where idmatiere="+idmatiere;
            Statement stat = connect.createStatement();
            ResultSet resultat = stat.executeQuery(req);
            
            while (resultat.next()) {
                totalqte = resultat.getInt(1);
            }
            return totalqte;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(iscreated == true) connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return totalqte;
    }
}
