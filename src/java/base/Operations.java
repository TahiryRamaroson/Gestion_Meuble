package base;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Vector;

public class Operations {

    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        } else {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }
    }

    public String capitalizeDb(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        } else {
            return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        }
    }

    public Object getAttribute(Object o, String nomAttribut) throws Exception {
        return o.getClass().getMethod("get" + capitalize(nomAttribut)).invoke(o);
    }

    public Object getSuperAttribute(Object o, String nomAttribut) throws Exception {
        return o.getClass().getSuperclass().getMethod("get" + capitalize(nomAttribut)).invoke(o);
    }

    public static String[] getAttributeNames(Object o){
        String[] names = new String[o.getClass().getDeclaredFields().length];
        for (int i = 0; i < names.length; i++) {
            names[i]= o.getClass().getDeclaredFields()[i].getName();
        }
        return names;
    }

    public double sumAttributes(Object[] lsObjects, String nomAttribut) throws Exception {
        double count = 0;
        // System.out.println(lsObjects.length);
        for (int i = 0; i < lsObjects.length; i++) {
            count += (double) getAttribute(lsObjects[i], nomAttribut);
            // System.out.println(count);
        }
        return count;
    }
    
    // public Object[] createTable(Vector lsObjets) throws Exception{
    //     Object[] tableObjets = new Object[lsObjets.size()];
    //     for (int i = 0; i < tableObjets.length; i++) {
    //         tableObjets[i] = lsObjets.get(i);
    //     }
    //     return tableObjets;
    // }
    //afaka tode mampiasa vector.toArray()

    public Vector getSpecifiedLsObjets(Vector lsObjets, String nameClass) throws Exception{
        if(lsObjets.isEmpty()){
            throw new Exception("No object saved yet");
        }
        Vector lsSpecifiedObjets = new Vector<>();
        for (int i = 0; i < lsObjets.size(); i++) {
            if(lsObjets.get(i).getClass().getSimpleName().equalsIgnoreCase(nameClass)){
                lsSpecifiedObjets.add(lsObjets.get(i));
            }
        }
        return lsSpecifiedObjets;
    }

    public static void invokeSetter(Object o, String nomAttribut, String valeur) throws Exception{
        Field[] attributs= o.getClass().getDeclaredFields();
        for (int i = 0; i < attributs.length; i++) {
            if(attributs[i].getName().compareToIgnoreCase(nomAttribut)==0){
                try {
                o.getClass().getMethod("set"+capitalize(nomAttribut), String.class).invoke(o, valeur);
                break;
                } catch (Exception e) {
                    // System.out.println(e.getLocalizedMessage()+"\n"+e.getMessage());
                    // e.printStackTrace();
                    // throw new Exception("Diso ilay saisie anao ");
                    e.printStackTrace();
                    throw new Exception(e.getCause()) ;
                }
            }
        }
    }

    public void invokeSetterDb(Object o, String nomAttribut, String valeur) throws Exception {
        Field[] attributs = o.getClass().getDeclaredFields();
        for (int i = 0; i < attributs.length; i++) {
            if (attributs[i].getName().compareToIgnoreCase(nomAttribut) == 0) {
                try {
                    o.getClass().getMethod("set" + capitalizeDb(nomAttribut), String.class).invoke(o, valeur);
                    break;
                } catch (Exception e) {
                    throw new Exception(e.getCause());
                }
            }
        }
    }

    public void invokeSuperSetterDb(Object o, String nomAttribut, String valeur) throws Exception{
        Field[] attributs = o.getClass().getSuperclass().getDeclaredFields();
        for (int i = 0; i < attributs.length; i++) {
            if (attributs[i].getName().compareToIgnoreCase(nomAttribut) == 0) {
                try {
                    o.getClass().getMethod("set" + capitalizeDb(nomAttribut), String.class).invoke(o, valeur);
                    break;
                } catch (Exception e) {
                    throw new Exception(e.getCause());
                }
            }
        }
    }

    // public boolean isLastAttributeOf(String nameAttribute,String className) throws Exception{
    //     Object o = Class.forName("actions."+ className).getDeclaredConstructor().newInstance();
    //     Field[] attributs = o.getClass().getDeclaredFields();
    //     if(nameAttribute.equals(attributs[attributs.length-1].getName())){
    //         return true;
    //     }
    //     return false;
    // }

}