package br.desafio.filtroJSON;

import br.desafio.API.ImobiliariaAPI;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Optional;

public class TratamentoJson {
    ImobiliariaAPI imobiliariaAPI = new ImobiliariaAPI();

    JSONArray jsonArrayImoveis; // 587 imoveis

    {
        try {
            jsonArrayImoveis = imobiliariaAPI.imoveisJsonArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ArrayList arrayListCamposSemRepeticao(String campo){ // Vale resaltar que existem vários imoveis sem condominio.

        ArrayList listaCampos = new ArrayList();
        ArrayList listaCamposConteudo = new ArrayList();

        int i, j;

        for ( i = 0; i < jsonArrayImoveis.length(); i++){
            if( i == 0){
                listaCamposConteudo.add(jsonArrayImoveis.getJSONObject(i).get(campo));
            }else{
                for( j = 0; j < listaCamposConteudo.size(); j++){
//                    if(jsonArrayImoveis.getJSONObject(0).getClass() == jsonArrayImoveis.getJSONObject(i).get(campo)){
//
//                    }
                    if(!listaCamposConteudo.contains(jsonArrayImoveis.getJSONObject(i).get(campo))){
                        listaCamposConteudo.add(jsonArrayImoveis.getJSONObject(i).get(campo));
                    }
                }
            }
        }

        listaCampos.add(campo);
        listaCampos.add(listaCamposConteudo.size());
        listaCampos.add(listaCamposConteudo);

        return listaCampos;
    }

}
