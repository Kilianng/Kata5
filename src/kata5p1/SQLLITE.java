/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5p1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author usuario
 */
public class SQLLITE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        Class.forName("org.sqlite.JDBC");
        String urlConection = "jdbc:sqlite:C:/Users/usuario/Downloads/SQLiteDatabaseBrowserPortable/Data/katas.db";
        Connection conection = DriverManager.getConnection(urlConection);
        
        Statement statement = conection.createStatement();
        String query = "Select * from PEOPLE";
        ResultSet rs = statement.executeQuery(query);
        
        while(rs.next()){
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
        }
    }
}
