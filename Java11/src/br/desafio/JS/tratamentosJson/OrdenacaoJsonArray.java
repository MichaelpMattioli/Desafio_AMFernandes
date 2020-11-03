package br.desafio.JS.tratamentosJson;


import br.desafio.sorts.Sorts;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Classe responsável por ordenar o Array de JSON em ordem alfabética, numérica crescente ou descrescente, ou filtrar um valor específico, especificando o campo que queira ordenar.
 *  * @author Michael Pedroza Mattioli Leite - michael.pmattioli@gmail.com
 *  * @since 02/11/2020
 *  * @version 1.0
 */

public class OrdenacaoJsonArray {

    InfoCamposJsonArray infoCamposJsonArray = new InfoCamposJsonArray();

    Sorts sorts = new Sorts();

    /**
     * Método responsável por ordenar o Array de JSON em ordem alfabética, onde deve informar o Array de JSON, e o campo que queira organizar.
     * @param jsonArray JSONArray que será ordenado.
     * @param campo String que representa o campo a ser ordenado.
     * @return JSONArray ordenado em ordem alfabética.
     */

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

    /**
     * Método responsável por ordenar o Array de JSON em ordem numérica crescente ou descrescente, onde deve informar o Array de JSON que deve ser ordenado, o campo a ser ordenado, e caso apresente um sub campo dentro de um campo, informar o sub campo a ser ordenado, caso contrário informe nulo.
     * @param jsonArray JSONArray a ser ordenado.
     * @param cresc_0_decres_1 Integer que deve ser informado 0 (crescente) ou 1 (decrescente).
     * @param campo String que representa o campo que queira ordenar em ordem numérica.
     * @param subCampo String que representa o sub campo que queira ordenar. Informar nulo caso nao apresente.
     * @return Retorna um JSONArray ordenado em ordem numérica.
     */

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

    /**
     * Método responsável por ordenar o Array de JSON em ordem numérica crescente ou descrescente, a partir de uma faixa de valores informados, onde deve informar o Array de JSON que deve ser ordenado, a faixa de valor, o campo a ser ordenado, e caso apresente um sub campo dentro de um campo, informar o sub campo a ser ordenado, caso contrário informe nulo.
     * @param jsonArray JSONArray que será ordenado.
     * @param valorMin Double do valor mínimo da faixa.
     * @param valorMax Double do valor máximo da faixa.
     * @param cresc_0_decres_1 Integer que deve ser informado 0 (crescente) ou 1 (decrescente).
     * @param campo String que representa o campo que queira ordenar em ordem numérica.
     * @param subCampo String que representa o sub campo que queira ordenar. Informar nulo caso nao apresente.
     * @return Retorna um JSONArray ordenado em ordem numérica.
     */

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

    /**
     * Método responsável por filtrar o Array de JSON através de um valor específico. Deve informar o JSONArray que será filtrado, o valor do campo que queira filtrar, o campo no qual o valor esteja, e caso apresente um sub campo dentro de um campo, informar o sub campo que será filtrado, caso contrário informe nulo.
     * @param jsonArray JSONArray que será filtrado.
     * @param valorDeCampo String que representa o valor de campo a ser filtrado. caso o valor de campo seja numérico, transforma-lo para String.
     * @param campo String que representa o valor de campo.
     * @param subCampo String que representa o valor do sub campo, caso não exista, informar nulo.
     * @return Retorna um JSONArray filtrado.
     */

    public JSONArray jsonArrayImoveisFiltrados(JSONArray jsonArray, String valorDeCampo ,String campo, String subCampo){

        JSONArray jsonArrayFiltrado = new JSONArray();

        int i,j;

        for ( i = 0; i < jsonArray.length(); i++){

            //Verifica se existe um campo
            try{
                jsonArray.getJSONObject(i).get(campo);
                // Verifica se o valor do campo é um JSONObject
                if(jsonArray.getJSONObject(i).get(campo).getClass() == JSONObject.class){

                    JSONObject jsonObjectValorDeCampo = (JSONObject) jsonArray.getJSONObject(i).get(campo);

                    //Verifica se existe um campo
                    try{
                        jsonObjectValorDeCampo.get(subCampo);
                        if(valorDeCampo.equals(jsonObjectValorDeCampo.get(subCampo).toString())) {
                            jsonArrayFiltrado.put(jsonArray.getJSONObject(i));
                        }
                    }catch (Exception e){
                    }


                }

                //Verifica se o valor do campo é uma String
                if(jsonArray.getJSONObject(i).get(campo).getClass() == String.class && subCampo == null){
                    String valorNoJson = (String) jsonArray.getJSONObject(i).get(campo);
                    if(valorDeCampo.equals(valorNoJson)) {
                        jsonArrayFiltrado.put(jsonArray.getJSONObject(i));
                    }
                }

            }catch (Exception e){
            }

        }

        return jsonArrayFiltrado;
    }
}
