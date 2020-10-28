package br.desafio.filtroJSON;

import br.desafio.API.ImobiliariaAPI;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TratamentoJson {
    ImobiliariaAPI imobiliariaAPI = new ImobiliariaAPI();

    JSONArray jsonArrayImoveis;

    {
        try {
            jsonArrayImoveis = imobiliariaAPI.imoveisJsonArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ArrayList listaTiposCampos(String campo){

        campo = "cidade";
        ArrayList<String> listaCampos = new ArrayList<String>();
        int i, j;

        for ( i = 0; i < jsonArrayImoveis.length(); i++){
            if( i == 0){
                listaCampos.add((String) jsonArrayImoveis.getJSONObject(i).get(campo));
            }else{
                for( j = 0; j < listaCampos.size(); j++){
                    if(!listaCampos.toString().contains((String) jsonArrayImoveis.getJSONObject(i).get(campo))){
                        listaCampos.add((String) jsonArrayImoveis.getJSONObject(i).get(campo));
                    }
                }
            }
        }

        return listaCampos;
    }
}
