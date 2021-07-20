/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Usuario
 */
public class Funcionario {
    String id, nombre, apellido;
    int numeroActivos;

    public Funcionario() {
    }

    public Funcionario(String id, String nombre, String apellido, int numeroActivos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroActivos = numeroActivos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNumeroActivos() {
        return numeroActivos;
    }

    public void setNumeroActivos(int numeroActivos) {
        this.numeroActivos = numeroActivos;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
    
    
    
}
