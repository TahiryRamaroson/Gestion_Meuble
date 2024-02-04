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
public class V_Employe_profil_poste {
          int idposte;
          String nomposte;
          int idouvrier;
          String nomouvrier;
          int idemploye;
          String nomemploye;
          double salaire;

          public V_Employe_profil_poste() {
          }

          public V_Employe_profil_poste(int idposte, String nomposte, int idouvrier, String nomouvrier, int idemploye, String nomEmploye, double salaire) {
                    setIdposte(idposte);
                    setNomposte(nomposte);
                    setIdouvrier(idouvrier);
                    setNomouvrier(nomouvrier);
                    setIdemploye(idemploye);
                    setNomemploye(nomEmploye);
                    setSalaire(salaire);
          }
          
          public V_Employe_profil_poste(String idposte, String nomposte, String idouvrier, String nomouvrier, String idemploye, String nomEmploye, String salaire) {
                    setIdposte(idposte);
                    setNomposte(nomposte);
                    setIdouvrier(idouvrier);
                    setNomouvrier(nomouvrier);
                    setIdemploye(idemploye);
                    setNomemploye(nomEmploye);
                    setSalaire(salaire);
          }

          public int getIdposte() {
                    return idposte;
          }

          public void setIdposte(int idposte) {
                    this.idposte = idposte;
          }
          
          public void setIdposte(String idposte) {
                    setIdposte(Integer.parseInt(idposte));
          }

          public String getNomposte() {
                    return nomposte;
          }

          public void setNomposte(String nomposte) {
                    this.nomposte = nomposte;
          }

          public int getIdouvrier() {
                    return idouvrier;
          }

          public void setIdouvrier(int idouvrier) {
                    this.idouvrier = idouvrier;
          }
          
          public void setIdouvrier(String idouvrier) {
                    setIdouvrier(Integer.parseInt(idouvrier));
          }

          public String getNomouvrier() {
                    return nomouvrier;
          }

          public void setNomouvrier(String nomouvrier) {
                    this.nomouvrier = nomouvrier;
          }

          public int getIdemploye() {
                    return idemploye;
          }

          public void setIdemploye(int idemploye) {
                    this.idemploye = idemploye;
          }
          
          public void setIdemploye(String idemploye) {
                    setIdemploye(Integer.parseInt(idemploye));
          }

          public String getNomemploye() {
                    return nomemploye;
          }

          public void setNomemploye(String nomEmploye) {
                    this.nomemploye = nomEmploye;
          }

          public double getSalaire() {
                    return salaire;
          }

          public void setSalaire(double salaire) {
                    this.salaire = salaire;
          }
          
          public void setSalaire(String salaire) {
                    setSalaire(Double.parseDouble(salaire));
          }
          
          public static ArrayList selectAll(Connection c ) throws Exception{
                    FonctionsDb fdb = new FonctionsDb();
                    return fdb.getObject(c, "V_Employe_profil_poste", "entities");
          }
          
}
