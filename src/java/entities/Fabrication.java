package entities;

import java.sql.Connection;
import java.util.ArrayList;

import base.FonctionsDb;

public class Fabrication {
    int idfabrication;
    int idmeuble;
    int idstyle;
    int idvolume;
    int idmatiere;
    int qte;

    public Fabrication(){}

    public Fabrication(String id, String idmeuble, String idvol, String idmat, String idst, String qte){
        setIdfabrication(id);
        setIdmeuble(idmeuble);
        setIdvolume(idvol);
        setIdmatiere(idmat);
        setIdstyle(idst);
        setQte(qte);
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
        if (qte > 0) {
            this.qte = qte;
        }
    }

    public void setQte(String qte) {
        setQte(Integer.parseInt(qte));
    }
    
    public void insert(Connection c) throws Exception{
        FonctionsDb fdb = new FonctionsDb();
        fdb.saveObject(c, this);
    }

    public static ArrayList selectAll(Connection c) throws Exception {
        FonctionsDb fdb = new FonctionsDb();
        return fdb.getObject(c, "Fabrication", "entities");
    }
    
    public static ArrayList getListById(Connection c, String idvolume, String idmeuble, String idstyle) throws Exception{
        FonctionsDb fdb = new FonctionsDb();
        String condition = " idmeuble="+idmeuble+" and idvolume="+idvolume+" and idstyle="+idstyle;
        return fdb.getObject(c, "Fabrication", "entities", condition);
    }
}
