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
public class V_benefice_affichage {
         String nommeuble;
         String nomstyle;
         String nomvolume;
         double prixvente;
         double salairetotal;
         double prixmatiere;
         double benefice;

          public V_benefice_affichage() {
          }

          public V_benefice_affichage(String nommeuble, String nomstyle, String nomvolume, double prixvente, double salairetotal, double prixmatiere, double benefice) {
                    setNommeuble(nommeuble);
                    setNomstyle(nomstyle);
                    setNomvolume(nomvolume);
                    setPrixvente(prixvente);
                    setSalairetotal(salairetotal);
                    setPrixmatiere(prixmatiere);
                    setBenefice(benefice);
          }
          
          public V_benefice_affichage(String nommeuble, String nomstyle, String nomvolume, String prixvente, String salairetotal, String prixmatiere, String benefice) {
                    setNommeuble(nommeuble);
                    setNomstyle(nomstyle);
                    setNomvolume(nomvolume);
                    setPrixvente(prixvente);
                    setSalairetotal(salairetotal);
                    setPrixmatiere(prixmatiere);
                    setBenefice(benefice);
          }
         
           public String getNommeuble() {
                    return nommeuble;
          }

          public void setNommeuble(String nommeuble) {
                    this.nommeuble = nommeuble;
          }
          
          public String getNomstyle() {
                    return nomstyle;
          }

          public void setNomstyle(String nomstyle) {
                    this.nomstyle = nomstyle;
          }
          
          public String getNomvolume() {
                    return nomvolume;
          }

          public void setNomvolume(String nomvolume) {
                    this.nomvolume = nomvolume;
          }

          public double getPrixvente() {
                    return prixvente;
          }

          public void setPrixvente(double prixvente) {
                    this.prixvente = prixvente;
          }
          
          public void setPrixvente(String prixvente) {
                    setPrixvente(Double.parseDouble(prixvente));
          }

          public double getSalairetotal() {
                    return salairetotal;
          }

          public void setSalairetotal(double salairetotal) {
                    this.salairetotal = salairetotal;
          }
          
          public void setSalairetotal(String salairetotal) {
                    setSalairetotal(Double.parseDouble(salairetotal));
          }

          public double getPrixmatiere() {
                    return prixmatiere;
          }

          public void setPrixmatiere(double prixmatiere) {
                    this.prixmatiere = prixmatiere;
          }
          
          public void setPrixmatiere(String prixmatiere) {
                    setPrixmatiere(Double.parseDouble(prixmatiere));
          }

          public double getBenefice() {
                    return benefice;
          }

          public void setBenefice(double benefice) {
                    this.benefice = benefice;
          }
          
          public void setBenefice(String benefice) {
                    setBenefice(Double.parseDouble(benefice));
          }
          
          public static ArrayList getListByBenefice(Connection c, String min, String max) throws Exception{
                    FonctionsDb fdb = new FonctionsDb();
                    String condition = " benefice>="+min+" and benefice<="+max;
                    return fdb.getObject(c, "V_benefice_affichage", "entities", condition);
          }
          
}
