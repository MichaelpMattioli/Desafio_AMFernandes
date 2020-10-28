package br.desafio.filtroJSON;

import br.desafio.API.ImobiliariaAPI;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Optional;

public class TratamentoJson {

    public ArrayList arrayListCamposSemRepeticao(JSONArray jsonArray, String campo){ // Vale resaltar que existem vários imoveis sem condominio.

        ArrayList listaCampos = new ArrayList();
        ArrayList listaCamposConteudo = new ArrayList();

        int i, j;

        for ( i = 0; i < jsonArray.length(); i++){
            if( i == 0){
                listaCamposConteudo.add(jsonArray.getJSONObject(i).get(campo));
            }else{
                for( j = 0; j < listaCamposConteudo.size(); j++){
//                    if(jsonArrayImoveis.getJSONObject(0).getClass() == jsonArrayImoveis.getJSONObject(i).get(campo)){
//
//                    }
                    if(!listaCamposConteudo.contains(jsonArray.getJSONObject(i).get(campo))){
                        listaCamposConteudo.add(jsonArray.getJSONObject(i).get(campo));
                    }
                }
            }
        }

        listaCampos.add(campo);
        listaCampos.add(listaCamposConteudo.size());
        listaCampos.add(listaCamposConteudo);

        return listaCampos;
    }

    public JSONArray jsonArrayImoveisFiltrados(JSONArray jsonArray, String valorDeCampo ,String campo, String subCampo){

        JSONArray jsonArrayFiltrado = new JSONArray();

        int i,j;

        for ( i = 0; i < jsonArray.length(); i++){

            if(jsonArray.getJSONObject(i).get(campo).getClass() == JSONObject.class){

                JSONObject jsonObjectValorDeCampo = (JSONObject) jsonArray.getJSONObject(i).get(campo);

                for( j = 0; j < jsonObjectValorDeCampo.length(); j++ ){
                    if(valorDeCampo.equals(jsonObjectValorDeCampo.get(subCampo).toString())) {
                        jsonArrayFiltrado.put(jsonArray.getJSONObject(i));
                    }
                }
            }

            if(jsonArray.getJSONObject(i).get(campo).getClass() == String.class && subCampo == null){
                String valorNoJson = (String) jsonArray.getJSONObject(i).get(campo);
                if(valorDeCampo.equals(valorNoJson)) {
                    jsonArrayFiltrado.put(jsonArray.getJSONObject(i));
                }
            }
        }

        return jsonArrayFiltrado;
    }

    public JSONArray jsonArrayImoveisFiltrados(JSONArray jsonArray, String valorDeCampo ,String campo){
        return jsonArrayImoveisFiltrados(jsonArray, valorDeCampo, campo, null);
    }



}
