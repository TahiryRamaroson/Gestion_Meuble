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
import java.time.LocalDateTime;

/**
 *
 * @author tahir
 */
public class FormuleOuvrier {
     int id;
     int idvolume;
     int ouvriermin;
     LocalDateTime dateinsertion;
     
     public FormuleOuvrier(){}
     

          public FormuleOuvrier(int id, int idvolume, int ouvriermin, LocalDateTime dateinsertion) {
                    this.id = id;
                    this.idvolume = idvolume;
                    this.ouvriermin = ouvriermin;
                    this.dateinsertion = dateinsertion;
          }
          
          public FormuleOuvrier(String id, String idvolume, String ouvriermin, String dateinsertion) {
                    setId(id);
                    setIdvolume(idvolume);
                    setOuvriermin(ouvriermin);
                    setDateinsertion(dateinsertion);
                    
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

          public int getIdvolume() {
                    return idvolume;
          }

          public void setIdvolume(int idvolume) {
                    this.idvolume = idvolume;
          }
          
          public void setIdvolume(String idvolume) {
                    setIdvolume(Integer.parseInt(idvolume));
          }

          public int getOuvriermin() {
                    return ouvriermin;
          }

          public void setOuvriermin(int ouvriermin) {
                    this.ouvriermin = ouvriermin;
          }
          
          public void setOuvriermin(String ouvriermin) {
                    setOuvriermin(Integer.parseInt(ouvriermin));
          }

          public LocalDateTime getDateinsertion() {
                    return dateinsertion;
          }

          public void setDateinsertion(LocalDateTime dateinsertion) {
                    this.dateinsertion = dateinsertion;
          }
          
          public void setDateinsertion(String dateinsertion) {
                    setDateinsertion(LocalDateTime.parse(dateinsertion));
          }
          
          public void insert(Connection c) throws Exception{
                    FonctionsDb fdb = new FonctionsDb();
                    fdb.saveObject(c, this);
          }
          
          public static int getNbouvrierbyIdvolume(Connection connect, int idvolume){
                    boolean iscreated = false;
                    int valiny=0;
                    try {
                              if(connect == null) {
                                        ConnexionDb con = new ConnexionDb("postgres", "meuble");
                                        connect = con.getConnection();
                                        iscreated = true;
                              }
                              String req = "select ouvriermin from formuleouvrier where idvolume=" + idvolume + " and dateinsertion=(select max(dateinsertion) from formuleouvrier where idvolume=" + idvolume + ")";
                              Statement stat = connect.createStatement();
                              ResultSet resultat = stat.executeQuery(req);
                              while (resultat.next()) {
                                        valiny = resultat.getInt(1);
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
