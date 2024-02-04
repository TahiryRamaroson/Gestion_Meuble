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
 * @author Amboara
 */
public class V_SumPrix {
    String nommeuble;
    String nomstyle;
    String nomvolume;
    double prixtotal;
    
    public String getNommeuble() {
        return nommeuble;
    }

    public void setNommeuble(String nommeuble) {
        this.nommeuble = nommeuble;
    }
    
    public String getNomstyle() {
        return nomstyle;
    }

    public void setNomstyle(String style) {
        this.nomstyle = style;
    }
    
    public String getNomvolume() {
        return nomvolume;
    }

    public void setNomvolume(String nomvolume) {
        this.nomvolume = nomvolume;
    }
    
    public double getPrixtotal() {
        return this.prixtotal;
    }

    public void setPrixtotal(double prix) {
        this.prixtotal = prix;
    }

    public void setPrixtotal(String p) {
        setPrixtotal(Double.parseDouble(p));
    }
    
    public static ArrayList getListByPrix(Connection c, String min, String max) throws Exception{
        FonctionsDb fdb = new FonctionsDb();
        String condition = " prixtotal>="+min+" and prixtotal<="+max;
        return fdb.getObject(c, "V_SumPrix", "entities", condition);
    }
}
