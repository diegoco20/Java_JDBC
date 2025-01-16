/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author diego
 */
public class Usuario {
    // Atributos privados
    private int codigo; 
    private String nombre; 
    
    public Usuario() {
    }
    
    public Usuario(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    // Getters and setters
    public int getCodigo() {
        return codigo;
    }
    
    public String getNombre(){
        return nombre;
    }
    public void setCodigo(int codigo) {
        if (codigo > 0) { // Validación opcional
            this.codigo = codigo;
        } else {
            throw new IllegalArgumentException("El código debe ser un número positivo.");
        }
    }
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) { // Validación opcional
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        }
    }
    
    @Override
    public String toString() {
        return "Usuario{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
