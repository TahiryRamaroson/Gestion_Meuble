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
public class TravailOuvrier {
    int id;
    int idmeuble;
    int idstyle;
    int idvolume;
    int idouvrier;
    int idposte;
    int nombre;
    double heuretravail;
    LocalDateTime dateinsertion;

          public TravailOuvrier() {
          }

          public TravailOuvrier(int id, int idmeuble, int idstyle, int idvolume, int idouvrier, int idposte, int nombre, double heuretravail, LocalDateTime dateinsertion) {
                    setId(id);
                    setIdmeuble(idmeuble);
                    setIdstyle(idstyle);
                    setIdvolume(idvolume);
                    setIdouvrier(idouvrier);
                    setIdposte(idposte);
                    setNombre(nombre);
                    setHeuretravail(heuretravail);
                    setDateinsertion(dateinsertion);
          }
          
          public TravailOuvrier(String id, String idmeuble, String idstyle, String idvolume, String idouvrier, String idposte, String nombre, String heuretravail, String dateinsertion) {
                    setId(id);
                    setIdmeuble(idmeuble);
                    setIdstyle(idstyle);
                    setIdvolume(idvolume);
                    setIdouvrier(idouvrier);
                    setIdposte(idposte);
                    setNombre(nombre);
                    setHeuretravail(heuretravail);
                    setDateinsertion(dateinsertion);
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

          public int getIdmeuble() {
                    return idmeuble;
          }

          public void setIdmeuble(int idmeuble) {
                    this.idmeuble = idmeuble;
          }
          
          public void setIdmeuble(String id) {
                    setIdmeuble(Integer.parseInt(id));
          }

          public int getIdstyle() {
                    return idstyle;
          }

          public void setIdstyle(int idstyle) {
                    this.idstyle = idstyle;
          }
          
          public void setIdstyle(String id) {
                    setIdstyle(Integer.parseInt(id));
          }
          
          public int getIdvolume() {
                    return idvolume;
          }

          public void setIdvolume(int idvolume) {
                    this.idvolume = idvolume;
          }
          
          public void setIdvolume(String id) {
                    setIdvolume(Integer.parseInt(id));
          }

          public int getIdouvrier() {
                    return idouvrier;
          }

          public void setIdouvrier(int idouvrier) {
                    this.idouvrier = idouvrier;
          }
          
          public void setIdouvrier(String id) {
                    setIdouvrier(Integer.parseInt(id));
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

          public int getNombre() {
                    return nombre;
          }

          public void setNombre(int nombre) {
                    this.nombre = nombre;
          }
          
          public void setNombre(String nombre) {
                    setNombre(Integer.parseInt(nombre));
          }

          public double getHeuretravail() {
                    return heuretravail;
          }

          public void setHeuretravail(double heuretravail) {
                    this.heuretravail = heuretravail;
          }
          
          public void setHeuretravail(String heuretravail) {
                    setHeuretravail(Double.parseDouble(heuretravail));
          }

          public LocalDateTime getDateinsertion() {
                    return dateinsertion;
          }

          public void setDateinsertion(LocalDateTime dateinsertion) {
                    this.dateinsertion = dateinsertion;
          }
          
          public void setDateinsertion(String dateinsertion) {
                    setDateinsertion(LocalDateTime.parse(dateinsertion));
          }
          
          public void insert(Connection c) throws Exception{
                    FonctionsDb fdb = new FonctionsDb();
                    fdb.saveObject(c, this);
          }
    
}
