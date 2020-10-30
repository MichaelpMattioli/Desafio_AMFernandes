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
                e.printStackTrace();
            }
        }

        String campo = "bairro";
        String subCampo = null;

        TratamentoJson tratamentoJson = new TratamentoJson();

        System.out.println(jsonArrayImoveis);

        ArrayList arrayListInfoCamposSemRepeticao = tratamentoJson.arrayListInfoCamposSemRepeticao(jsonArrayImoveis,campo,subCampo);

        System.out.println(arrayListInfoCamposSemRepeticao);

        ArrayList arrayList = (ArrayList) tratamentoJson.arrayListInfoCamposSemRepeticao(jsonArrayImoveis,campo,subCampo).get(arrayListInfoCamposSemRepeticao.size()-1);

//        System.out.println(arrayList);
//        System.out.println(arrayList.size());

//        System.out.println(tratamentoJson.jsonArrayImoveisFiltrados(jsonArrayImoveis, "1450000", "planta", "preco" ));

        // SORT

        Sorts sorts = new Sorts();


//        System.out.println(sorts.sortStringOrdemAlfabetica(arrayList));
//        System.out.println(sorts.sortStringOrdemAlfabetica(arrayList).size());



//        System.out.println(sorts.sortNumber(0, arrayList));
//        System.out.println(sorts.sortNumber(0,arrayList).size());

//        System.out.println(tratamentoJson.jsonArrayImoveisOrdenacao(jsonArrayImoveis, campo));
//        System.out.println(tratamentoJson.jsonArrayImoveisOrdenacao(jsonArrayImoveis, campo).length());

    }
}
