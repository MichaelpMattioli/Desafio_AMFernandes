package br.desafio.tratamentosJson;

import br.desafio.sorts.Sorts;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class TratamentoJson {

    public ArrayList arrayListInfoCamposSemRepeticao(JSONArray jsonArray, String campo, String subCampo){ // Vale resaltar que existem vários imoveis sem condominio e planta.

        ArrayList listaCampos = new ArrayList();
        ArrayList listaCamposConteudo = new ArrayList();
        ArrayList arrayListAux = new ArrayList();

        int i, j; // pior caso O(n^2)

        if(subCampo == null){
            for ( i = 0; i < jsonArray.length(); i++){

                //Verifica se existe um campo
                try{
                    jsonArray.getJSONObject(i).get(campo);
                }catch (Exception e){
                    continue;
                }

                //Filtragem de valor de campo repetidos
                if( i == 0){
                    listaCamposConteudo.add(jsonArray.getJSONObject(i).get(campo));
                }else{
                    for( j = 0; j < listaCamposConteudo.size(); j++){

                        JSONObject jsonObjectAux = jsonArray.getJSONObject(i);
                        if(!listaCamposConteudo.contains(jsonObjectAux.get(campo))){
                            listaCamposConteudo.add(jsonObjectAux.get(campo));
                        }

                    }
                }
            }
        }else{

            for ( i = 0; i < jsonArray.length(); i++){

                //Verifica se existe um campo
                try{
                    jsonArray.getJSONObject(i).get(campo);
                }catch (Exception e){
                    continue;
                }

                JSONObject jsonObjectAux = (JSONObject) jsonArray.getJSONObject(i).get(campo);

                for( j = 0; j < jsonObjectAux.length(); j++){

                    if(!listaCamposConteudo.contains(jsonObjectAux.get(subCampo))) {
                        listaCamposConteudo.add(jsonObjectAux.get(subCampo));
                    }
                }
            }

        }



        // Adciona no array as seguintes informações:
        // indice(0) = o campo utilizado
        // indice(1) = o subCampo utilizado
        // indice(2) = Numero de quantos valores encontrado
        // indice(3) = O arrayList contendo os valores

        listaCampos.add(campo); // Adicion
        listaCampos.add(subCampo);
        listaCampos.add(listaCamposConteudo.size());
        listaCampos.add(listaCamposConteudo);

        return listaCampos;
    }

    public JSONArray jsonArrayImoveisFiltrados(JSONArray jsonArray, String valorDeCampo ,String campo, String subCampo){

        JSONArray jsonArrayFiltrado = new JSONArray();

        int i,j;

        for ( i = 0; i < jsonArray.length(); i++){

            //Verifica se existe um campo
            try{
                jsonArray.getJSONObject(i).get(campo);
            }catch (Exception e){
                continue;
            }

            // Verifica se o valor do campo é um JSONObject
            if(jsonArray.getJSONObject(i).get(campo).getClass() == JSONObject.class){

                JSONObject jsonObjectValorDeCampo = (JSONObject) jsonArray.getJSONObject(i).get(campo);

                for( j = 0; j < jsonObjectValorDeCampo.length(); j++ ){

                    //Verifica se existe um campo
                    try{
                        jsonObjectValorDeCampo.get(subCampo);
                    }catch (Exception e){
                        continue;
                    }
                    if(valorDeCampo.equals(jsonObjectValorDeCampo.get(subCampo).toString())) {
                        jsonArrayFiltrado.put(jsonArray.getJSONObject(i));
                    }
                }
            }

            //Verifica se o valor do campo é uma String
            if(jsonArray.getJSONObject(i).get(campo).getClass() == String.class && subCampo == null){
                String valorNoJson = (String) jsonArray.getJSONObject(i).get(campo);
                if(valorDeCampo.equals(valorNoJson)) {
                    jsonArrayFiltrado.put(jsonArray.getJSONObject(i));
                }
            }
        }

        return jsonArrayFiltrado;
    }

}
