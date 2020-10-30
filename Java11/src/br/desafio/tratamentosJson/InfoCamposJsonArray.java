package br.desafio.tratamentosJson;

import br.desafio.sorts.Sorts;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class InfoCamposJsonArray {

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

        listaCampos.add(campo);
        listaCampos.add(subCampo);
        listaCampos.add(listaCamposConteudo.size());
        listaCampos.add(listaCamposConteudo);

        return listaCampos;
    }

}
