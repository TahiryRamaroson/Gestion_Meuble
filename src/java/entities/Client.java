/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import base.FonctionsDb;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author tahir
 */
public class Client {
          int id;
          String nomclient;
          int idgenre;

          public Client(int id, String nomclient, int idgenre) {
                    setId(id);
                    setNomclient(nomclient);
                    setIdgenre(idgenre);
          }
          
          public Client(String id, String nomclient, String idgenre) {
                    setId(id);
                    setNomclient(nomclient);
                    setIdgenre(idgenre);
          }

          public Client() {
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

          public String getNomclient() {
                    return nomclient;
          }

          public void setNomclient(String nomclient) {
                    this.nomclient = nomclient;
          }

          public int getIdgenre() {
                    return idgenre;
          }

          public void setIdgenre(int idgenre) {
                    this.idgenre = idgenre;
          }
          
          public void setIdgenre(String id) {
                    setIdgenre(Integer.parseInt(id));
          }
          
          public void insert(Connection c) throws Exception{
                    FonctionsDb fdb = new FonctionsDb();
                    fdb.saveObject(c, this);
          }
          
          public static ArrayList selectAll(Connection c) throws Exception {
                    FonctionsDb fdb = new FonctionsDb();
                    return fdb.getObject(c, "Client", "entities");
          }
}
