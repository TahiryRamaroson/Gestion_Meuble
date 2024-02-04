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
public class V_stat_complet {
          int nbvente;
          int idgenre;
          String nomgenre;
          int idmeuble;
          String nommeuble;
          int idstyle;
          String nomstyle;
          int idvolume;
          String nomvolume;

          public V_stat_complet() {
          }

          public V_stat_complet(int nbvente, int idgenre, String nomgenre, int idmeuble, String nommeuble, int idstyle, String nomstyle, int idvolume, String nomvolume) {
                    setNbvente(nbvente);
                    setIdgenre(idgenre);
                    setNomgenre(nomgenre);
                    setIdmeuble(idmeuble);
                    setNommeuble(nommeuble);
                    setIdstyle(idstyle);
                    setNomstyle(nomstyle);
                    setIdvolume(idvolume);
                    setNomvolume(nomvolume);
          }
          
          public V_stat_complet(String nbvente, String idgenre, String nomgenre, String idmeuble, String nommeuble, String idstyle, String nomstyle, String idvolume, String nomvolume) {
                    setNbvente(nbvente);
                    setIdgenre(idgenre);
                    setNomgenre(nomgenre);
                    setIdmeuble(idmeuble);
                    setNommeuble(nommeuble);
                    setIdstyle(idstyle);
                    setNomstyle(nomstyle);
                    setIdvolume(idvolume);
                    setNomvolume(nomvolume);
          }
          

          public int getNbvente() {
                    return nbvente;
          }

          public void setNbvente(int nbvente) {
                    this.nbvente = nbvente;
          }
          
          public void setNbvente(String nbvente) {
                    setNbvente(Integer.parseInt(nbvente));
          }

          public int getIdgenre() {
                    return idgenre;
          }

          public void setIdgenre(int idgenre) {
                    this.idgenre = idgenre;
          }
          
          public void setIdgenre(String idgenre) {
                    setIdgenre(Integer.parseInt(idgenre));
          }

          public String getNomgenre() {
                    return nomgenre;
          }

          public void setNomgenre(String nomgenre) {
                    this.nomgenre = nomgenre;
          }

          public int getIdmeuble() {
                    return idmeuble;
          }

          public void setIdmeuble(int idmeuble) {
                    this.idmeuble = idmeuble;
          }
          
          public void setIdmeuble(String idmeuble) {
                    setIdmeuble(Integer.parseInt(idmeuble));
          }

          public String getNommeuble() {
                    return nommeuble;
          }

          public void setNommeuble(String nommeuble) {
                    this.nommeuble = nommeuble;
          }

          public int getIdstyle() {
                    return idstyle;
          }

          public void setIdstyle(int idstyle) {
                    this.idstyle = idstyle;
          }
          
          public void setIdstyle(String idstyle) {
                    setIdstyle(Integer.parseInt(idstyle));
          }

          public String getNomstyle() {
                    return nomstyle;
          }

          public void setNomstyle(String nomstyle) {
                    this.nomstyle = nomstyle;
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

          public String getNomvolume() {
                    return nomvolume;
          }

          public void setNomvolume(String nomvolume) {
                    this.nomvolume = nomvolume;
          }
          
          public static ArrayList selectAll(Connection c) throws Exception {
                    FonctionsDb fdb = new FonctionsDb();
                    return fdb.getObject(c, "V_stat_complet", "entities");
          }
          
          public static ArrayList getListByProduit(Connection c, String idmeuble, String idstyle, String idvolume) throws Exception{
        FonctionsDb fdb = new FonctionsDb();
        String condition = " idmeuble="+idmeuble+" and idstyle="+idstyle+" and idvolume="+idvolume;
        return fdb.getObject(c, "V_stat_complet", "entities", condition);
    }
          
          
}
