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
public class OuvrierExp {
      int id;
      int idouvrier;
      int expdebut;
      int expfin;
      LocalDateTime dateinsertion;
      
    public OuvrierExp(){}

    public OuvrierExp(String id, String idouvrier, String expdebut, String expfin, String dateinsertion){
        setId(id);
        setIdouvrier(idouvrier);
        setExpdebut(expdebut);
        setExpfin(expfin);
        setDateinsertion(dateinsertion);
    }
      
    public OuvrierExp(String id, int idouvrier, String expdebut, String expfin, LocalDateTime dateinsertion){
        setId(id);
        setIdouvrier(idouvrier);
        setExpdebut(expdebut);
        setExpfin(expfin);
        setDateinsertion(dateinsertion);
    }
      

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setId(String id) {
        this.id = Integer.parseInt(id);
    }

    public int getIdouvrier() {
       return idouvrier;
    }

    public void setIdouvrier(int ouvrier) {
        this.idouvrier = ouvrier;
    }
    
    public void setIdouvrier(String idouvrier) {
        this.idouvrier = Integer.parseInt(idouvrier);
    }

    public int getExpdebut() {
        return expdebut;
    }

    public void setExpdebut(int exp) {
        if (exp<0) {
            throw new IllegalArgumentException("Experience doit etre positif");
        }
        this.expdebut = exp;
    }
    
    public void setExpdebut(String exp) {
        if (Integer.parseInt(exp)<0) {
            throw new IllegalArgumentException("Experience doit etre positif");
        }
        this.expdebut = Integer.parseInt(exp);
    }
    
    public int getExpfin() {
        return expfin;
    }

    public void setExpfin(int exp) {
        if (exp<0) {
            throw new IllegalArgumentException("Experience doit etre positif");
        }
        this.expfin = exp;
    }
    
    public void setExpfin(String exp) {
        if (Integer.parseInt(exp)<0) {
            throw new IllegalArgumentException("Experience doit etre positif");
        }
        this.expfin = Integer.parseInt(exp);
    }

    public LocalDateTime getDateinsertion() {
        return dateinsertion;
    }

    public void setDateinsertion(LocalDateTime dateinsertion) {
        this.dateinsertion = dateinsertion;
    }
    
    public void setDateinsertion(String dateinsertion) {
        this.dateinsertion = LocalDateTime.parse(dateinsertion);
    }
    
    public void insert(Connection c) throws Exception{
        FonctionsDb fdb = new FonctionsDb();
        fdb.saveObject(c, this);
    }
}
