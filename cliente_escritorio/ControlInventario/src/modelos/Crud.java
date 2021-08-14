/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.List;

public interface Crud {
    List <Funcionario> listarFuncionarios();
    List <Activo> activosDeFuncionario(String idFuncionario);
}
