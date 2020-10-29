package br.desafio.tratamentosJson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class TratamentoJson {

    public ArrayList arrayListInfoCamposSemRepeticao(JSONArray jsonArray, String campo){ // Vale resaltar que existem vários imoveis sem condominio e planta.

        ArrayList listaCampos = new ArrayList();
        ArrayList listaCamposConteudo = new ArrayList();

        int i, j;

        for ( i = 0; i < jsonArray.length(); i++){
            if( i == 0){
                try{
                    jsonArray.getJSONObject(i).get(campo);
                }catch (Exception e){
                    continue;
                }
                listaCamposConteudo.add(jsonArray.getJSONObject(i).get(campo));
            }else{
                for( j = 0; j < listaCamposConteudo.size(); j++){
                    try{
                        jsonArray.getJSONObject(i).get(campo);
                    }catch (Exception e){
                        continue;
                    }

                    JSONObject jsonObjectAux = jsonArray.getJSONObject(i);
                    if(!listaCamposConteudo.contains(jsonObjectAux.get(campo))){
                        listaCamposConteudo.add(jsonObjectAux.get(campo));
                    }

                }
            }
        }

        listaCampos.add(campo);
        listaCampos.add(listaCamposConteudo.size());
        listaCampos.add(listaCamposConteudo);

        return listaCampos;
    }

    public JSONArray jsonArrayImoveisOrdenacao(JSONArray jsonArray, String campo){

        ArrayList arrayListInfoCampo = arrayListInfoCamposSemRepeticao(jsonArray, campo);
        ArrayList arrayListValoresCampo = (ArrayList) arrayListInfoCampo.get(2);

        JSONArray jsonArrayOrganizado = null;

        int seNumero = 0;
        int seString = 1;

        int i;

        for ( i = 0; i < jsonArray.length(); i++){

        }

        return jsonArrayOrganizado;

    }

    public ArrayList sortStringOrdemAlfabetica (ArrayList arrayListString){

        String stringValores[] = new String[arrayListString.size()];
        String stringAux;
        ArrayList arrayListRetorno = new ArrayList();

        for ( int i = 0; i < arrayListString.size(); i++){
            stringValores[i] = (String) arrayListString.get(i);
        }

        for (int i = 0; i < arrayListString.size(); i++) {
            for (int j = i + 1; j < arrayListString.size(); j++) {
                if (stringValores[i].compareTo(stringValores[j]) > 0) {
                    stringAux = stringValores[i];
                    stringValores[i] = stringValores[j];
                    stringValores[j] = stringAux;
                }
            }
        }

        for ( int i = 0; i < stringValores.length; i++){
            arrayListRetorno.add(stringValores[i]);
        }

        return arrayListRetorno;

    }

    public JSONArray jsonArrayImoveisFiltrados(JSONArray jsonArray, String valorDeCampo ,String campo, String subCampo){

        JSONArray jsonArrayFiltrado = new JSONArray();

        int i,j;

        for ( i = 0; i < jsonArray.length(); i++){

            try{
                jsonArray.getJSONObject(i).get(campo);
            }catch (Exception e){
                continue;
            }

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
