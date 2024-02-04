package base;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.ArrayList;

import base.Operations;
import base.ConnexionDb;

public class FonctionsDb {
    public void saveObject(Connection c, Object objet) throws Exception{
        Operations op = new Operations();
        String nameTable = objet.getClass().getSimpleName();
        try {
            String[] attributeNames = getColumnNames(c, nameTable);
            String[] types = getColumnTypes(c, nameTable);
            String[] values = new String[attributeNames.length];
            for (int i = 0; i < values.length; i++) {
                if (types[i].equalsIgnoreCase("varchar") ||
                    types[i].equalsIgnoreCase("char") || 
                    types[i].equalsIgnoreCase("date") ||
                    types[i].equalsIgnoreCase("timestamp")) {
                    values[i] = "'"+op.getAttribute(objet, attributeNames[i])+"'";
                } else if(types[i].equalsIgnoreCase("serial")){
                    values[i] = "default";
                }else{
                    values[i] =""+op.getAttribute(objet, attributeNames[i]);
                }
            }

            String query = buildInsertQuery(nameTable, values);
            setQuery(c, query);
        } catch (Exception e) {
            throw e;
        }
    }

    public void saveObject(Connection c, Object objet, String objectName) throws Exception{
        Operations op = new Operations();
        try {
            String[] attributeNames = getColumnNames(c, objectName);
            String[] values = new String[attributeNames.length];
            String[] types = getColumnTypes(c, objectName);
            for (int i = 0; i < values.length; i++) {
                if (types[i].equalsIgnoreCase("varchar") ||
                    types[i].equalsIgnoreCase("char") || 
                    types[i].equalsIgnoreCase("date") ||
                    types[i].equalsIgnoreCase("timestamp")) {
                    values[i] = "'"+op.getAttribute(objet, attributeNames[i])+"'";
                } else{
                    values[i] =""+op.getAttribute(objet, attributeNames[i]);
                }
            }

            String query = buildInsertQuery(objectName, values);
            setQuery(c, query);
        } catch (Exception e) {
            throw e;
        }
    }

    public void setQuery(Connection c, String query) throws Exception{
        try {
            Statement st = c.createStatement();
            st.execute(query);
            System.out.println("Query done");
            st.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public String buildInsertQuery( String nameTable, String[] values){
       String query ="";
       for (int i = 0; i < values.length-1; i++) {
        query+=values[i]+",";
       }
       query+=values[values.length-1];
        System.out.println(query);
       return "INSERT INTO "+nameTable+" VALUES ("+query+")";
    }

    public String[] getTableNames(Connection c) throws Exception{
        try {
            DatabaseMetaData dbmt = c.getMetaData();
            ArrayList nomsTables = new ArrayList<String>();

            //satria mila an'io ilay fonction maka tables
            String[] types = new String[/* 2*/1];
            types[0] = "TABLE";
            // types[1] = "VIEW";

            ResultSet rs = null;
            // tsy maintsy atao anzao sinon mandray tables bdb tsy ilaina ilay izy
            if (dbmt.getDatabaseProductName().equals("Oracle")) {
                // veut dire toutes les tables de cet user
                rs = dbmt.getTables(null, dbmt.getUserName() , null, types);
            } else{
                //% veut dire toutes les tables hono
                rs = dbmt.getTables(null, "%" , null, types);
            }

            while (rs.next()) {
                //ilay tables tsotra fa reto tsy ilaina
                if (!rs.getString("TABLE_NAME").startsWith("pma")) {
                    nomsTables.add(rs.getString("TABLE_NAME"));
                }
            }

            String[] finalList = new String[nomsTables.size()];
            for (int i = 0; i < finalList.length; i++) {
                finalList[i]=(String)nomsTables.get(i);
            }
            rs.close();

            return finalList;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public String[] getColumnNames(Connection c,String nameTable) throws Exception{
        String[] liste ;
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM "+nameTable);
            ResultSetMetaData mt = rs.getMetaData();
            liste = new String[mt.getColumnCount()];
            for (int i = 0; i < liste.length; i++) {
                liste[i]= mt.getColumnName(i+1);
                // System.out.println(liste[i]+ " is added");
            }
            st.close();
            rs.close();
        } catch (Exception e) {
            throw e;
        }
        return liste;
    }

    public String[] getColumnTypes(Connection c,String nameTable) throws Exception{
        String[] liste ;
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM "+nameTable);
            ResultSetMetaData mt = rs.getMetaData();
            liste = new String[mt.getColumnCount()];
            for (int i = 0; i < liste.length; i++) {
                liste[i]= mt.getColumnTypeName(i+1);
                // System.out.println(liste[i]+ " is added");
            }
            st.close();
            rs.close();
        } catch (Exception e) {
            throw e;
        }
        return liste;
    }

    public ArrayList getObject(Connection c, String nameTable) throws Exception{
        Operations op = new Operations();
        ArrayList lsObjects = new ArrayList();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM "+nameTable);
            String[] nomColonnes = getColumnNames(c, nameTable);

            while (rs.next()) {
                Object o = Class.forName(nameTable).getConstructor().newInstance();
                for (int i = 0; i < nomColonnes.length; i++) {
                    op.invokeSetterDb(o, nomColonnes[i], rs.getString(nomColonnes[i]));
                }
                lsObjects.add(o);
                System.out.println(rs.getRow()+" successfully created");
            }
            st.close();
            rs.close();

            return lsObjects;
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList getObject(Connection c, String nameTable, String packageName) throws Exception{
        Operations op = new Operations();
        ArrayList lsObjects = new ArrayList();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM "+nameTable);
            String[] nomColonnes = getColumnNames(c, nameTable);

            while (rs.next()) {
                Object o = Class.forName(packageName+"."+nameTable).getConstructor().newInstance();
                for (int i = 0; i < nomColonnes.length; i++) {
                    op.invokeSetterDb(o, nomColonnes[i], rs.getString(nomColonnes[i]));
                }
                lsObjects.add(o);
                System.out.println(rs.getRow()+" "+nameTable+" successfully created");
            }
            st.close();
            rs.close();

            return lsObjects;
        } catch (Exception e) {
            throw e;
        }
    }

    private String findTypeColumnName(ResultSet rs) throws Exception {
        // Assume that the type column name starts with "type"
        for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
            if (rs.getMetaData().getColumnName(i).startsWith("type")) {
                return rs.getMetaData().getColumnName(i);
            }
        }
        return null;
    }

    public Object loadChildObject(Connection c, Object toCreate, String conditions) throws Exception{
        Operations op = new Operations();
        String nameTable = toCreate.getClass().getSimpleName();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM "+nameTable+" WHERE "+conditions);
            String[] nomColonnes = getColumnNames(c, nameTable);
            if (rs.next()) {
                String typeColumnName = findTypeColumnName(rs);

                if (typeColumnName != null && rs.getString(typeColumnName) != null) {
                    String typePopulation = rs.getString(typeColumnName);
                    Class<?> objectClass = Class.forName(toCreate.getClass().getPackageName()+"."+typePopulation);
                    Object specificObject = objectClass.getConstructor().newInstance();

                    // // Set specific attributes for the superclass
                    // setAttributes(toCreate, rs);
                    for (int i = 0; i < nomColonnes.length; i++) {
                        op.invokeSuperSetterDb(specificObject, nomColonnes[i], rs.getString(nomColonnes[i]));
                    }
                    System.out.println(specificObject.getClass().getSimpleName()+" loaded");
                    return specificObject;
                } else {
                    throw new Exception("Invalid type information in the database");
                }
            } else {
                throw new Exception("No data found for the given conditions");
            }
        } catch (Exception e) {
           throw e;
        }
     }

    public ArrayList getObject(Connection c, String nameTable, String packageName, String conditions) throws Exception{
        Operations op = new Operations();
        ArrayList lsObjects = new ArrayList();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM "+nameTable+" WHERE "+conditions);
            String[] nomColonnes = getColumnNames(c, nameTable);

            while (rs.next()) {
                Object o = Class.forName(packageName+"."+nameTable).getConstructor().newInstance();
                for (int i = 0; i < nomColonnes.length; i++) {
                    op.invokeSetterDb(o, nomColonnes[i], rs.getString(nomColonnes[i]));
                }
                lsObjects.add(o);
                System.out.println(rs.getRow()+" "+nameTable+" successfully created");
            }
            st.close();
            rs.close();

            return lsObjects;
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList getObject(Connection c, Object toCreate, String conditions) throws Exception{
        // Operations op = new Operations();

        String nameTable = toCreate.getClass().getSimpleName();
        // String packageName = toCreate.getClass().getPackageName();

        ArrayList lsObjects = new ArrayList();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM "+nameTable+" WHERE "+conditions);

            while (rs.next()) {
                String nameIdentification= "id"+nameTable.toLowerCase();
                conditions = nameIdentification+"="+rs.getString(nameIdentification);
                Object o = loadChildObject(c, toCreate, conditions);
                lsObjects.add(o);
                
                System.out.println(rs.getRow()+" "+nameTable+" successfully created");
            }
            st.close();
            rs.close();

            return lsObjects;
        } catch (Exception e) {
            throw e;
        }
    }

    public Object[][] getData(Connection c, String nameTable) throws Exception{
        // Operations op = new Operations();
        ArrayList lsData = new ArrayList();
        try {
            Statement st = c.createStatement();
            String[] nomColonnes = getColumnNames(c, nameTable);
            ResultSet rs = st.executeQuery("SELECT * FROM "+nameTable);

            while (rs.next()) {
                Object[] ligne = new Object[nomColonnes.length];
                for (int i = 0; i < nomColonnes.length; i++) {
                    ligne[i]=rs.getString(nomColonnes[i]);
                }
                lsData.add(ligne);
                System.out.println(rs.getRow() + "e "+nameTable+" successfully added");
            }
        Object[][] dataTable = new Object[lsData.size()][];
            for (int i = 0; i < lsData.size(); i++) {
                dataTable[i] = (Object[]) lsData.get(i);
            }
            st.close();
            rs.close();

            System.out.println("Results are loaded");

            return dataTable;
        } catch (Exception e) {
            throw e;
        }
    }
    
}