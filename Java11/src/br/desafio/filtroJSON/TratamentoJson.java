package br.desafio.filtroJSON;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class TratamentoJson {

    public ArrayList arrayListInfoCamposSemRepeticao(JSONArray jsonArray, String campo){ // Vale resaltar que existem vários imoveis sem condominio.

        ArrayList listaCampos = new ArrayList();
        ArrayList listaCamposConteudo = new ArrayList();

        int i, j;

        for ( i = 0; i < jsonArray.length(); i++){
            if( i == 0){
                listaCamposConteudo.add(jsonArray.getJSONObject(i).get(campo));
            }else{
                for( j = 0; j < listaCamposConteudo.size(); j++){
                    if(jsonArray.getJSONObject(i) != null){
                        System.out.println(i);
                        if(!listaCamposConteudo.contains(jsonArray.getJSONObject(i).get(campo))){
                            listaCamposConteudo.add(jsonArray.getJSONObject(i).get(campo));
                        }
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
