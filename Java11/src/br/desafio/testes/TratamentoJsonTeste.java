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

        TratamentoJson tratamentoJson = new TratamentoJson();

        System.out.println(jsonArrayImoveis);

        System.out.println(tratamentoJson.arrayListInfoCamposSemRepeticao(jsonArrayImoveis,campo));

        ArrayList arrayList = (ArrayList) tratamentoJson.arrayListInfoCamposSemRepeticao(jsonArrayImoveis,campo).get(2);

//        System.out.println(arrayList);
//        System.out.println(arrayList.size());

        System.out.println(tratamentoJson.jsonArrayImoveisFiltrados(jsonArrayImoveis, "1450000", "planta", "preco" ));

        // SORT

        Sorts sorts = new Sorts();


        System.out.println(sorts.sortStringOrdemAlfabetica(arrayList));

        System.out.println(sorts.sortNumber(arrayList));


    }
}
