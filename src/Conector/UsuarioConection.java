/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conector;

import Entities.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public final class UsuarioConection extends Conexion {
    
    
    public void guardarUsuario(Usuario usuario) {

        try {
            if (usuario == null) {
                throw new Exception("Debe indicar un usuario");
            }

            // Verifica si el usuario ya existe por medio del código 
            String checkSql = "SELECT COUNT(*) FROM fabricante WHERE codigo = " + usuario.getCodigo() + ";";
            consultarBase(checkSql);

            if (resultado.next()) {
                int count = resultado.getInt(1);
                
                if (count > 0) {
                    throw new Exception("El código ya existe en la base de datos.");
                }                   
            }
            
            
            // Si el usuario no existe, insertar el nuevo usuario
            String sql = "INSERT INTO fabricante (codigo, nombre)"
                    + "VALUES ('" + usuario.getCodigo() + "' , '" + usuario.getNombre() + "');";

            InstarModificarEliminar(sql);
            System.out.println("Usuario con código: " + usuario.getCodigo() + " agregado");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void modificarUsuario(Usuario usuario){
        
        try {
            if (usuario == null) {
                throw new Exception("Debe indicar un usuario para modificar");
            }
            
            String sql = "UPDATE fabricante SET "
                    + "codigo = '" + usuario.getCodigo() + "' WHERE nombre = '" + usuario.getNombre();
            
            InstarModificarEliminar(sql);
            
        } catch (Exception e) {
            
        }
    }
     
    public void eliminarUsuario(Usuario usuario){
        
        try {
            if (usuario == null) {
                throw new Exception("Debe indicar un usuario para eliminar");
            }
            
            String sql = "DELETE FROM fabricante  "
                    + "codigo = '" + usuario.getCodigo() + "' WHERE nombre = '" + usuario.getNombre();
            
            InstarModificarEliminar(sql);
            
        } catch (Exception e) {
            
        }
    }
    
    public void consultarUsuarios() {
    String sql = "SELECT * FROM fabricante;";
    try {
        // Conectar a la base de datos
        conectar();
        
        // Crear un Statement y ejecutar la consulta
        sentencia = cx.createStatement();
        resultado = sentencia.executeQuery(sql);

        // Procesar los resultados
        while (resultado.next()) {
            // Aquí puedes acceder a los resultados, por ejemplo:
            int codigo = resultado.getInt("codigo");
            String nombre = resultado.getString("nombre");
            System.out.println("Código: " + codigo + ", Nombre: " + nombre);
        }
    } catch (SQLException ex) {
        System.out.println("Error en la consulta: " + ex.getMessage());
        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        // Cerrar recursos
        desconectar();
    }
}
    
    public void consultarUsuarioId(int id) throws Exception {   

        try {
            String sql = "SELECT * FROM fabricante WHERE codigo = " + id + ";";
            
            consultarBase(sql);
            
            Usuario usuario = null;
            
            if (resultado.next()){
                System.out.println("Usuario encontrado");
                System.out.println("Id: " + id + ", Nombre: " + resultado.getString(2));
            } else {
                System.out.println("Usuario no encontrado");
            }

        } catch (SQLException e) {
            desconectar();
        }
    }
    
}
