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
public class ProcesoDetail {
    int id;
    Funcionario funcionario;
    ProcesoValidacion procesoValidacion;
    String observacion, estado;

    public ProcesoDetail() {
    }

    public ProcesoDetail(int id, Funcionario funcionario, ProcesoValidacion procesoValidacion, String observacion, String estado) {
        this.id = id;
        this.funcionario = funcionario;
        this.procesoValidacion = procesoValidacion;
        this.observacion = observacion;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public ProcesoValidacion getProcesoValidacion() {
        return procesoValidacion;
    }

    public void setProcesoValidacion(ProcesoValidacion procesoValidacion) {
        this.procesoValidacion = procesoValidacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
