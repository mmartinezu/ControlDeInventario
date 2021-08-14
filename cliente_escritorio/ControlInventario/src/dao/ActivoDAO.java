/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import comMdf.devazt.networking.HttpClient;
import comMdf.devazt.networking.OnHttpRequestComplete;
import comMdf.devazt.networking.Response;
import java.util.ArrayList;
import java.util.List;
import modelos.Activo;
import modelos.Crud;
import modelos.Funcionario;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Usuario
 */
public class ActivoDAO implements Crud {

    @Override
    public List<Funcionario> listarFuncionarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Activo> activosDeFuncionario(String idFuncionario) {
        List<Activo> data = new ArrayList();
        
        HttpClient cliente = new HttpClient(new OnHttpRequestComplete() {
            @Override
            public void onComplete(Response status) {
                if (status.isSuccess()) {
                    try {
                        JSONObject activoObject = new JSONObject(status.getResult());
                        for (int i = 0;; i++) {
                            Object[] obj = new Object[5];
                            obj[0] = activoObject.getJSONObject(""+i+"").get("ID_ACT").toString();
                            obj[1] = activoObject.getJSONObject(""+i+"").get("NOM_ACT").toString();
                            obj[2] = activoObject.getJSONObject(""+i+"").get("EST_ACT").toString();
                            obj[3] = activoObject.getJSONObject(""+i+"").get("COD_BAR_ACT").toString();
                            obj[4] = activoObject.getJSONObject(""+i+"").get("ID_FUN_PER").toString();
                            data.add(new Activo(obj[0].toString(), obj[1].toString(), obj[2].toString(), obj[3].toString(), obj[4].toString()));
                        }
                        
                    } catch (JSONException mes) {
                        System.out.println(mes.getMessage());
                    }
                }
            }
        });
        cliente.excecute("http://localhost/servicios/cargarActivosDeFuncionario.php?funcionario=" + idFuncionario);
        return data;
    }

}
