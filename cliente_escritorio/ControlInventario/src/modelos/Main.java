/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import dao.ActivoDAO;
import formularios.Activos;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Main {

    public static void main(String[] args) {
        ActivoDAO dao = new ActivoDAO();
        List<Activo> activos = dao.activosDeFuncionario("1803");
        System.out.println(activos.get(0).getNombre());
        System.out.println(activos.get(1).getNombre());
        
    }
}
