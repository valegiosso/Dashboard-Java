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
    
    public void eliminarUsuario(int idUsuario) throws SQLException {
        String query = "DELETE FROM users WHERE id = ?";
        try{
            conex = conexion.getConnect();
            PreparedStatement pstm = conex.prepareStatement(query);
            pstm.setInt(1, idUsuario);
            pstm.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error en UsersDAO:" + e.toString());
        }
    }

    public void actualizarUsuario(int idUsuario, String nombre, String apellido, String dni, String contacto) throws SQLException {
        String sql = "UPDATE users SET Nombre = ?, Apellido = ?, DNI = ?, contacto = ?  WHERE id = ?";
        try{
            conex = conexion.getConnect();
            PreparedStatement statement = conex.prepareStatement(sql);
            statement.setString(1, nombre);
            // Establecer otros parámetros para los campos adicionales que estás actualizando
            statement.setString(2, apellido);
            statement.setString(3, dni);
            statement.setString(4, contacto);
            
            statement.setInt(5, idUsuario);
            
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error en UsersDAO:" + e.toString());
        }
    }
    }
