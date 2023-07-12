package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection connect;

    public Conexion() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cac2023?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true","root","");
        }catch (SQLException | ClassNotFoundException e){
            System.out.println("Error en Conexion:" + e.toString());
        }
    }

    public Connection getConnect() {
        return connect;
    }
    
}
