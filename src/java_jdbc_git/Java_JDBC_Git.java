/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package java_jdbc_git;

import Conector.UsuarioConection;
import Entities.Usuario;

/**
 *
 * @author diego
 */
public class Java_JDBC_Git {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        UsuarioConection Usuarioconexion = new UsuarioConection();
        Usuarioconexion.conectar();
        Usuario fabricante = new Usuario(100, "Diego");
        Usuarioconexion.guardarUsuario(fabricante);
        Usuarioconexion.consultarUsuarioId(100);
        
        
        Usuarioconexion.desconectar();
    }
    
}
