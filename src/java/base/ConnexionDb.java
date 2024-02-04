package base;

import java.sql.*;

public class ConnexionDb {
    String db = null;
    //chemin anaty jar
    String nomDriver = null;
    //jdbc:nomSGBD://localhost:port:dbName
    String url = null;
    String user = null ;
    String password = null ; 
    Connection connection = null;

    public ConnexionDb() {
    }

    public ConnexionDb(String nomDb, String nomBase) throws Exception{
        if (nomDb.equalsIgnoreCase("oracle")) {
            this.db= nomDb;
            this.user = nomBase;
            this.password = nomBase;
            this.nomDriver = "oracle.jdbc.OracleDriver";
            this.url="jdbc:oracle:thin:@localhost:1521:orcl";
            // sqlplus scott/tiger
        }
        if (nomDb.equalsIgnoreCase("postgres")) {
            this.db= nomDb;
            this.user = "postgres";
            this.password = "Tahiry1849";
            this.nomDriver = "org.postgresql.Driver";
            this.url="jdbc:postgresql://localhost:5432/"+nomBase;
            //  psql -h localhost -p 5432 -U postgres -d postgres
        }
        if (nomDb.equalsIgnoreCase("mysql")) {
            this.db= nomDb;
            this.user = "root";
            this.password = "";
            this.nomDriver = "com.mysql.cj.jdbc.Driver";
            this.url="jdbc:mysql://localhost:3306/"+nomBase;
            //  cd \xampp\mysql\bin
            // ./mysql -u root -p
        }
        if (nomDb.isEmpty()) {
            throw new Exception("No database selected");
        }
    }

    public ConnexionDb(String nomDb) throws Exception{
        if (nomDb.equalsIgnoreCase("oracle")) {
            this.db= nomDb;
            this.user = "permis";
            this.password = "permis";
            this.nomDriver = "oracle.jdbc.OracleDriver";
            this.url="jdbc:oracle:thin:@localhost:1521:orcl";
            // sqlplus scott/tiger
        }
        if (nomDb.equalsIgnoreCase("postgres")) {
            this.db= nomDb;
            this.user = "postgres";
            this.password = "Tahiry1849";
            this.nomDriver = "org.postgresql.Driver";
            this.url="jdbc:postgresql://localhost:5432/sante";
            //  psql -h localhost -p 5432 -U postgres -d postgres
        }
        if (nomDb.equalsIgnoreCase("mysql")) {
            this.db= nomDb;
            this.user = "root";
            this.password = "";
            this.nomDriver = "com.mysql.cj.jdbc.Driver";
            this.url="jdbc:mysql://localhost:3306/restaurant";
            //  cd \xampp\mysql\bin
            // ./mysql -u root -p
        }
        if (nomDb.isEmpty()) {
            throw new Exception("No database selected");
        }
    }

    public Connection getConnection() throws Exception {
        Class.forName(nomDriver);
        connection = DriverManager.getConnection(url, user, password);
        if (connection != null) {
            System.out.println("Connected to "+ db);
            return connection;
        }
        if (connection == null) {
            throw new Exception("Erreur de connexion");
        }
        return connection;
    }

    public String getDb() {
        return this.db;
    }

}
