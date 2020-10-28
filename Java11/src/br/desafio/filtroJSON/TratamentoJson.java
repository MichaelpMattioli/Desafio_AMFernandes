package br.desafio.filtroJSON;

import br.desafio.API.ImobiliariaAPI;
import org.json.JSONArray;

import java.util.ArrayList;

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


    public ArrayList listaCampos(String campo){

        ArrayList listaCampos = new ArrayList();
        ArrayList<String> listaCamposConteudo = new ArrayList<>();

        int i, j;

        for ( i = 0; i < jsonArrayImoveis.length(); i++){
            if( i == 0){
                listaCamposConteudo.add((String) jsonArrayImoveis.getJSONObject(i).get(campo));
            }else{
                for( j = 0; j < listaCamposConteudo.size(); j++){
                    if(!listaCamposConteudo.toString().contains((String) jsonArrayImoveis.getJSONObject(i).get(campo))){
                        listaCamposConteudo.add((String) jsonArrayImoveis.getJSONObject(i).get(campo));
                    }
                }
            }
        }

        listaCampos.add(campo);
        listaCampos.add(listaCamposConteudo);

        return listaCampos;
    }



}
