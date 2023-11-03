
package databases;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.util.ArrayList;


public class koneksi_database {
    private final static String dbhost = "localhost"; // nama hostnya
    private final static String dbname = "pa_pbo"; // nama databasenya
    private final static String username = "root"; // username mysql
    private final static String password = ""; // password mysql
    
    public Connection connection = null;
    
    protected Statement statement;
    public PreparedStatement preparedStatement;
    public ResultSet resultSet;
    
    public final void openConnection() {
        try {
            // Bentuk stringnya: "jdbc:mysql://dbhost/dbname?user=username&password=password"
            this.connection = DriverManager.getConnection(
                "jdbc:mysql://"
                + koneksi_database.dbhost
                + "/"
                + koneksi_database.dbname
                + "?user="
                + koneksi_database.username
                + "&password="
                + koneksi_database.password
            );
        } catch (SQLException ex) {
            this.displayErrors(ex);
        }
    }
    
    public final void closeConnection() {
        try {
            if (this.resultSet != null) this.resultSet.close();
            if (this.statement != null) this.statement.close();
            if (this.preparedStatement != null) this.preparedStatement.close();
            if (this.connection != null) this.connection.close();
            
            this.resultSet = null;
            this.statement = null;
            this.preparedStatement = null;
            this.connection = null;
        } catch (SQLException ex) {
            this.displayErrors(ex);
        }
    }
    
     public final ArrayList<ArrayList> all(String query) {
        ArrayList<ArrayList> rows = new ArrayList();
        
        try {
            this.statement = this.connection.createStatement();
            this.resultSet = this.statement.executeQuery(query);
            
            while (this.resultSet.next()) {
                // mengambil jumlah kolom yang ada di tabel
                ResultSetMetaData rsMetaData = this.resultSet.getMetaData();
                int columnCount = rsMetaData.getColumnCount();
                
                ArrayList<String> columns = new ArrayList();
                
                for (int i = 1; i <= columnCount; i++) {
                    columns.add(this.resultSet.getString(i));
                }
                
                rows.add(columns);
            }
        } catch (SQLException ex) {
            this.displayErrors(ex);
        }
        
        return rows;
    }
    
    public final int generateLastId() {
        try {
            if (this.statement != null) {
                this.resultSet = this.statement.getGeneratedKeys();
            }
            
            if (this.preparedStatement != null) {
                this.resultSet = this.preparedStatement.getGeneratedKeys();
            }
            
            if (this.resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            this.displayErrors(ex);
        }
        
        return 0;
    }
    
    public final void displayErrors(SQLException ex) {
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
    }    
}
