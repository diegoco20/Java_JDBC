/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Conector.UsuarioConection;
import Entities.Usuario;

/**
 *
 * @author diego
 */
public class UsuarioService {
    private UsuarioConection usconnection;
    
    public UsuarioService(){
        this.usconnection = new UsuarioConection();
    }
    
    public void imprimirUsuario(Usuario usuario){
        
    }
    
    public void crearUsuario(int codigo, String nombre) throws Exception {
        Usuario usuario = new Usuario();
        try {
            //Validations
           
            if (codigo <= 0) {
                throw new Exception ("El código dese ser un número entero positivo");
            }
            
            if (nombre == null){
                throw new Exception ("Debe indicar el nombre");
            }
            
            usuario = usconnection.consultarUsuarioId(codigo);
            if (usuario != null) {
                throw new Exception ("Usuario ya existe");
            }
            
            
        } catch (Exception e) {
            
        }
        
        // User creation 
        usuario.setCodigo(codigo);
        usuario.setNombre(nombre);
        usconnection.guardarUsuario(usuario);
        
    }
    
   
}

