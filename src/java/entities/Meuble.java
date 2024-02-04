package entities;

import java.sql.Connection;
import java.util.ArrayList;

import base.FonctionsDb;

public class Meuble {
    int id;
    String nommeuble;

    public Meuble(){}
    
    public Meuble(String id, String nom){
        setId(id);
        setNommeuble(nom);
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

    public String getNommeuble() {
        return nommeuble;
    }

    public void setNommeuble(String nommeuble) {
        this.nommeuble = nommeuble;
    }
    
    public void insert(Connection c) throws Exception{
        FonctionsDb fdb = new FonctionsDb();
        fdb.saveObject(c, this);
    }

    public static ArrayList selectAll(Connection c) throws Exception {
        FonctionsDb fdb = new FonctionsDb();
        return fdb.getObject(c, "Meuble", "entities");
    }
}
