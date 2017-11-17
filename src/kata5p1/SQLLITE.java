/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5p1;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
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
        
        query = "CREATE TABLE IF NOT EXISTS MAIL ('Id' INTEGER PRIMARY KEY AUTOINCREMENT , 'Mail' TEXT NOT NULL)";
        statement.execute(query);
        
        String fileString = "C:/Users/usuario/Downloads/SQLiteDatabaseBrowserPortable/Data/emailsfile.txt";
        
        BufferedReader reader = new BufferedReader(new FileReader(new File (fileString)));
        String mail;
        
        while((mail=reader.readLine()) != null){
            if(!mail.contains("@")) continue;
            query = "INSERT INTO MAIL (mail) VALUES ('"+ mail +"')";
            statement.executeUpdate(query);
        }
        
        rs.close();
    }
}
