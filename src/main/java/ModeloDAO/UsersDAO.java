package ModeloDAO;

//JAVA BEAN

import Config.Conexion;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO {
    Conexion conexion = new Conexion();
    Connection conex;
    PreparedStatement ps;
    ResultSet result;
    
    //metodo para devolver la collecion de usuarios
    public List listarUsuarios(){
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        
        String sql = "SELECT * FROM users";
        
        try{
            conex = conexion.getConnect();
            
            ps = conex.prepareCall(sql);
            result = ps.executeQuery();
            
            while (result.next()){//se va a ejecutar mientras result siga teniendo un proximo registro
                Usuario user = new Usuario();
                user.setId(result.getInt("id"));
                user.setDni(result.getInt("DNI"));
                user.setNombre(result.getString("Nombre"));
                user.setApellido(result.getString("Apellido"));
                user.setContacto(result.getString("Contacto"));
                
                listaUsuarios.add(user);
            }
        }catch (SQLException e){
            System.out.println("Error en UsersDAO:" + e.toString());
        }
        
        return listaUsuarios;
    }
}
