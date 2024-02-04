/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.sql.Connection;
import java.util.ArrayList;

import base.FonctionsDb;

/**
 *
 * @author Amboara
 */
public class V_Fabrication {
    int idfabrication;
    int idmeuble;
    int idstyle;
    int idvolume;
    int idmatiere;
    int qte;
    String nommeuble;
    String nomstyle;
    String nomvolume;
    double prix;

    public double getPrix() {
        return this.prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setPrix(String p) {
        setPrix(Double.parseDouble(p));
    }

    public int getIdfabrication() {
        return this.idfabrication;
    }

    public void setIdfabrication(int idfabrication) {
        this.idfabrication = idfabrication;
    }

    public void setIdfabrication(String idfabrication) {
        setIdfabrication(Integer.parseInt(idfabrication));
    }

    public int getIdmeuble() {
        return this.idmeuble;
    }

    public void setIdmeuble(int idmeuble) {
        this.idmeuble = idmeuble;
    }

    public void setIdmeuble(String idmeuble) {
        setIdmeuble(Integer.parseInt(idmeuble));
    }

    public int getIdstyle() {
        return this.idstyle;
    }

    public void setIdstyle(int idstyle) {
        this.idstyle = idstyle;
    }

    public void setIdstyle(String idstyle) {
        setIdstyle(Integer.parseInt(idstyle));
    }

    public int getIdvolume() {
        return this.idvolume;
    }

    public void setIdvolume(int idvolume) {
        this.idvolume = idvolume;
    }

    public void setIdvolume(String idIdvolume) {
        setIdvolume(Integer.parseInt(idIdvolume));
    }

    public int getIdmatiere() {
        return this.idmatiere;
    }

    public void setIdmatiere(int idmatiere) {
        this.idmatiere = idmatiere;
    }

    public void setIdmatiere(String idmatiere) {
        setIdmatiere(Integer.parseInt(idmatiere));
    }

    public int getQte() {
        return this.qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public void setQte(String qte) {
        setQte(Integer.parseInt(qte));
    }
    
    public String getNommeuble() {
        return this.nommeuble;
    }

    public void setNommeuble(String nommeuble) {
        this.nommeuble = nommeuble;
    }

    public String getNomstyle() {
        return this.nomstyle;
    }

    public void setNomstyle(String nomstyle) {
        this.nomstyle = nomstyle;
    }

    public String getNomvolume() {
        return this.nomvolume;
    }

    public void setNomvolume(String nomvolume) {
        this.nomvolume = nomvolume;
    }

    public static ArrayList getListById(Connection c, int idmatiere) throws Exception{
        FonctionsDb fdb = new FonctionsDb();
        String condition = " idmatiere="+idmatiere;
        return fdb.getObject(c, "V_Fabrication", "entities", condition);
    }
}
