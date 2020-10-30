package br.desafio.tratamentosJson;

import br.desafio.API.ImobiliariaAPI;
import br.desafio.sorts.Sorts;
import org.json.JSONArray;

import java.util.ArrayList;

public class OrdenacaoJsonArray {

    ImobiliariaAPI imobiliariaAPI = new ImobiliariaAPI();
    TratamentoJson tratamentoJson = new TratamentoJson();
    Sorts sorts = new Sorts();

    JSONArray jsonArrayImoveis; // 587 imoveis

    {
        try {
            jsonArrayImoveis = imobiliariaAPI.imoveisJsonArray();
        } catch (Exception e) {
            jsonArrayImoveis = new JSONArray();
        }
    }

    public JSONArray jsonArraySortCamposAlfabetic(String campo){

        JSONArray jsonArrayRetorno = new JSONArray();

        String subCampo = null;

        ArrayList arrayListValorCampoInfo = tratamentoJson.arrayListInfoCamposSemRepeticao(jsonArrayImoveis, campo, subCampo);

        ArrayList arrayListValorCampo = (ArrayList) arrayListValorCampoInfo.get(arrayListValorCampoInfo.size()-1);

        ArrayList arrayListCampoOrganizada = sorts.sortStringOrdemAlfabetica(arrayListValorCampo);

        arrayListCampoOrganizada.forEach(cidade -> {
            JSONArray jsonArrayFiltrado = tratamentoJson.jsonArrayImoveisFiltrados(jsonArrayImoveis, cidade.toString(), campo, subCampo );

            jsonArrayFiltrado.forEach(jsonObject ->{
                jsonArrayRetorno.put(jsonObject);
            });
        });

        return jsonArrayRetorno;

    }

    public JSONArray jsonArraySortCamposNumber(int cresc_0_decres_1, String campo, String subCampo){
        JSONArray jsonArrayRetorno = new JSONArray();

        ArrayList arrayListValorCampoInfo = tratamentoJson.arrayListInfoCamposSemRepeticao(jsonArrayImoveis, campo, subCampo);

        ArrayList arrayListValorCampo = (ArrayList) arrayListValorCampoInfo.get(arrayListValorCampoInfo.size()-1);

        ArrayList arrayListCampoOrganizada = (ArrayList) sorts.sortNumber(cresc_0_decres_1, arrayListValorCampo);

        arrayListCampoOrganizada.forEach(cidade -> {
            JSONArray jsonArrayFiltrado = tratamentoJson.jsonArrayImoveisFiltrados(jsonArrayImoveis, cidade.toString(), campo, subCampo );

            jsonArrayFiltrado.forEach(jsonObject ->{
                jsonArrayRetorno.put(jsonObject);
            });
        });

        return jsonArrayRetorno;
    }

    public JSONArray jsonArraySortCamposNumberRange(Double valorMin, Double valorMax,int cresc_0_decres_1, String campo, String subCampo){

        JSONArray jsonArrayRetorno = new JSONArray();

        JSONArray jsonArrayNumerosOrdenados = jsonArraySortCamposNumber(cresc_0_decres_1, campo, subCampo);

        ArrayList arrayListValorCampoInfo = tratamentoJson.arrayListInfoCamposSemRepeticao(jsonArrayNumerosOrdenados, campo, subCampo);

        ArrayList arrayListValorCampo = (ArrayList) arrayListValorCampoInfo.get(arrayListValorCampoInfo.size()-1);

        ArrayList arrayListValorCampoFiltradoNumber = new ArrayList();

        ArrayList arrayListValorCampoFiltradoNotNumber = new ArrayList();

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
            JSONArray jsonArrayFiltrado = tratamentoJson.jsonArrayImoveisFiltrados(jsonArrayImoveis, cidade.toString(), campo, subCampo );

            jsonArrayFiltrado.forEach(jsonObject ->{
                jsonArrayRetorno.put(jsonObject);
            });
        });

        return jsonArrayRetorno;
    }
}
