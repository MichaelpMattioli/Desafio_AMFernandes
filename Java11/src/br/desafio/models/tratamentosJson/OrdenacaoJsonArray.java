package br.desafio.models.tratamentosJson;


import br.desafio.models.sorts.Sorts;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class OrdenacaoJsonArray {


    InfoCamposJsonArray infoCamposJsonArray = new InfoCamposJsonArray();

    Sorts sorts = new Sorts();



    public JSONArray jsonArraySortCamposAlfabetic(JSONArray jsonArray, String campo){

        JSONArray jsonArrayRetorno = new JSONArray();

        String subCampo = null;

        ArrayList arrayListValorCampoInfo = infoCamposJsonArray.arrayListInfoCamposSemRepeticao(jsonArray, campo, subCampo);

        ArrayList arrayListValorCampo = (ArrayList) arrayListValorCampoInfo.get(arrayListValorCampoInfo.size()-1);

        ArrayList arrayListCampoOrganizada = sorts.sortStringOrdemAlfabetica(arrayListValorCampo);

        arrayListCampoOrganizada.forEach(cidade -> {
            JSONArray jsonArrayFiltrado = jsonArrayImoveisFiltrados(jsonArray, cidade.toString(), campo, subCampo );

            jsonArrayFiltrado.forEach(jsonObject ->{
                jsonArrayRetorno.put(jsonObject);
            });
        });

        return jsonArrayRetorno;

    }

    public JSONArray jsonArraySortCamposNumber(JSONArray jsonArray,int cresc_0_decres_1, String campo, String subCampo){
        JSONArray jsonArrayRetorno = new JSONArray();

        ArrayList arrayListValorCampoInfo = infoCamposJsonArray.arrayListInfoCamposSemRepeticao(jsonArray, campo, subCampo);

        ArrayList arrayListValorCampo = (ArrayList) arrayListValorCampoInfo.get(arrayListValorCampoInfo.size()-1);

        ArrayList arrayListCampoOrganizada = (ArrayList) sorts.sortNumber(cresc_0_decres_1, arrayListValorCampo);

        arrayListCampoOrganizada.forEach(cidade -> {
            JSONArray jsonArrayFiltrado = jsonArrayImoveisFiltrados(jsonArray, cidade.toString(), campo, subCampo );

            jsonArrayFiltrado.forEach(jsonObject ->{
                jsonArrayRetorno.put(jsonObject);
            });
        });

        return jsonArrayRetorno;
    }

    public JSONArray jsonArraySortCamposNumberRange(JSONArray jsonArray, Double valorMin, Double valorMax,int cresc_0_decres_1, String campo, String subCampo){

        JSONArray jsonArrayRetorno = new JSONArray();

        JSONArray jsonArrayNumerosOrdenados = jsonArraySortCamposNumber(jsonArray ,cresc_0_decres_1, campo, subCampo);

        ArrayList arrayListValorCampoInfo = infoCamposJsonArray.arrayListInfoCamposSemRepeticao(jsonArrayNumerosOrdenados, campo, subCampo);

        ArrayList arrayListValorCampo = (ArrayList) arrayListValorCampoInfo.get(arrayListValorCampoInfo.size()-1);

        ArrayList arrayListValorCampoFiltradoNumber = new ArrayList();

        arrayListValorCampo.forEach(valor -> {
            if ( valor.getClass() == Integer.class){
                if ( (Integer) valor >= valorMin &&  (Integer) valor <= valorMax){
                    arrayListValorCampoFiltradoNumber.add(valor);
                }
            }else if( valor.getClass() == Double.class) {
                if ((Double) valor >= valorMin && (Double) valor <= valorMax) {
                    arrayListValorCampoFiltradoNumber.add(valor);
                }
            }

        });

        arrayListValorCampoFiltradoNumber.forEach(cidade -> {
            JSONArray jsonArrayFiltrado = jsonArrayImoveisFiltrados(jsonArray, cidade.toString(), campo, subCampo );

            jsonArrayFiltrado.forEach(jsonObject ->{
                jsonArrayRetorno.put(jsonObject);
            });
        });

        return jsonArrayRetorno;
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
