/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import base.ConnexionDb;
import java.sql.Connection;
import java.util.ArrayList;

import base.FonctionsDb;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Amboara
 */
public class Volume {
     int id;
     String nomvolume;
     double coeff;

    public Volume(){}
    
     public Volume(int id, String nom, double coeff){
        setId(id);
        setNomvolume(nom);
        setCoeff(coeff);
    }
    
    public Volume(String id, String nom, String coeff){
        setId(id);
        setNomvolume(nom);
        setCoeff(coeff);
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

    public String getNomvolume() {
        return nomvolume;
    }

    public void setNomvolume(String nomvolume) {
        this.nomvolume = nomvolume;
    }
    
     public double getCoeff() {
        return coeff;
    }

    public void setCoeff(double coeff) {
        this.coeff = coeff;
    }
    
    public void setCoeff(String coeff) {
        setCoeff(Double.parseDouble(coeff));
    }
    
    public void insert(Connection c) throws Exception{
        FonctionsDb fdb = new FonctionsDb();
        fdb.saveObject(c, this);
    }

    public static ArrayList selectAll(Connection c ) throws Exception{
         FonctionsDb fdb = new FonctionsDb();
         return fdb.getObject(c, "Volume", "entities");
    }
    
    public static ArrayList<Volume> getOrdered(Connection connect, String ordre){
        boolean iscreated = false;
        ArrayList<Volume> all = new ArrayList<Volume>();
        try {
            if(connect == null) {
                ConnexionDb con = new ConnexionDb("postgres", "meuble");
                connect = con.getConnection();
                iscreated = true;
            }
            String req = "select * from Volume order by coeff " + ordre;
            Statement stat = connect.createStatement();
            ResultSet resultat = stat.executeQuery(req);
            int lastid = 0;
            while (resultat.next()) {
               Volume vol = new Volume(resultat.getInt(1), resultat.getString(2), resultat.getDouble(3));
               all.add(vol);
            }
            return all;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(iscreated == true) connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return all;
    }
}
