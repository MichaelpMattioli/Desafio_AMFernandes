package br.desafio.testes;

import br.desafio.API.ImobiliariaAPI;
import br.desafio.sorts.Sorts;
import br.desafio.tratamentosJson.TratamentoJson;
import org.json.JSONArray;

import java.util.ArrayList;

public class TratamentoJsonTeste {

    public void run(){

        ImobiliariaAPI imobiliariaAPI = new ImobiliariaAPI();

        JSONArray jsonArrayImoveis = null; // 587 imoveis

        {
            try {
                jsonArrayImoveis = imobiliariaAPI.imoveisJsonArray();
            } catch (Exception e) {
                return;
            }
        }

        String campo = "cidade";
        String subCampo = null;
        String valorDeCampo = "São Caetano do Sul";

        TratamentoJson tratamentoJson = new TratamentoJson();

        System.out.println(jsonArrayImoveis);

        ArrayList arrayListInfoCamposSemRepeticao = tratamentoJson.arrayListInfoCamposSemRepeticao(jsonArrayImoveis,campo,subCampo);

        System.out.println(arrayListInfoCamposSemRepeticao);

        ArrayList arrayList = (ArrayList) tratamentoJson.arrayListInfoCamposSemRepeticao(jsonArrayImoveis,campo,subCampo).get(arrayListInfoCamposSemRepeticao.size()-1);

        System.out.println(arrayList);
        System.out.println("Size: " + arrayList.size());

        // SORT

        Sorts sorts = new Sorts();

        // sort Alfanumerico
//        System.out.println(sorts.sortStringOrdemAlfabetica(arrayList));
//        System.out.println(sorts.sortStringOrdemAlfabetica(arrayList).size());


        // sort Numero
//        System.out.println(sorts.sortNumber(0, arrayList));
//        System.out.println(sorts.sortNumber(0,arrayList).size());

        // Filtro

        System.out.println(tratamentoJson.jsonArrayImoveisFiltrados(jsonArrayImoveis, valorDeCampo, campo,subCampo));
        System.out.println(tratamentoJson.jsonArrayImoveisFiltrados(jsonArrayImoveis, valorDeCampo, campo,subCampo).length());

    }
}
