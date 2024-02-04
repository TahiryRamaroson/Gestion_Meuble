/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import base.FonctionsDb;
import java.sql.Connection;
import java.time.LocalDateTime;

/**
 *
 * @author tahir
 */
public class Employe {
          int id;
          String nomemploye;
          int idposte;
          LocalDateTime dateembauche;

          public Employe(int id, String nomemploye, int idposte, LocalDateTime dateembauche) {
                    this.id = id;
                    this.nomemploye = nomemploye;
                    this.idposte = idposte;
                    this.dateembauche = dateembauche;
          }
          
          public Employe(String id, String nomemploye, String idposte, String dateembauche) {
                    setId(id);
                    setNomemploye(nomemploye);
                    setIdposte(idposte);
                    setDateembauche(dateembauche);
          }

          public Employe() {
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

          public String getNomemploye() {
                    return nomemploye;
          }

          public void setNomemploye(String nomemploye) {
                    this.nomemploye = nomemploye;
          }

          public int getIdposte() {
                    return idposte;
          }

          public void setIdposte(int idposte) {
                    this.idposte = idposte;
          }
          
          public void setIdposte(String id) {
                    setIdposte(Integer.parseInt(id));
          }

          public LocalDateTime getDateembauche() {
                    return dateembauche;
          }

          public void setDateembauche(LocalDateTime dateembauche) {
                    this.dateembauche = dateembauche;
          }
          
          public void setDateembauche(String dateembauche) {
                    this.dateembauche = LocalDateTime.parse(dateembauche);
          }
          
          public void insert(Connection c) throws Exception{
                    FonctionsDb fdb = new FonctionsDb();
                    fdb.saveObject(c, this);
          }
}
