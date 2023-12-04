package agit_uts;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksiAgit {
   public static Connection sambungDB(){
       try{
           MysqlDataSource m = new MysqlDataSource();
           m.setUser("root");
           m.setPassword("");
           m.setPortNumber(3306);
           m.setServerName("localhost");
           m.setServerTimezone("Asia/Jakarta");
           m.setDatabaseName("mahasiswa");
           
           Connection k = m.getConnection();
           System.out.println("Sukses terhubung ke database");
           return k;
       } catch (SQLException e){
           System.out.println("GAGAL terhubung ke database");
           System.out.println("Error: "+e.getMessage());
           
       }
       return null;
   }
   
   public static void main(String[] args) {
        Connection connection = koneksiAgit.sambungDB();
        
        if (connection != null) {
            try {
                connection.createStatement().execute("SELECT * FROM mhs");
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Gagal terhubung ke database");
        }
    }
}

