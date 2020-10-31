package br.desafio.testes;

import br.desafio.ImobiliariaAPI;
import br.desafio.models.tratamentosJson.OrdenacaoJsonArray;
import org.json.JSONArray;

public class OrdenacaoJsonArrayTeste {

    public void run(){
        OrdenacaoJsonArray ordenacaoJsonArray = new OrdenacaoJsonArray();

        ImobiliariaAPI imobiliariaAPI = new ImobiliariaAPI();

        JSONArray jsonArrayImoveis; // 587 imoveis

        {
            try {
                jsonArrayImoveis = imobiliariaAPI.imoveisJsonArray();
            } catch (Exception e) {
                jsonArrayImoveis = new JSONArray();
            }
        }

//        System.out.println(ordenacaoJsonArray.jsonArraySortCamposAlfabetic("nome"));

//        System.out.println(ordenacaoJsonArray.jsonArraySortCamposNumber(0, "planta", "preco"));

//        System.out.println(ordenacaoJsonArray.jsonArraySortCamposNumberRange(3.0,3.0, 1, "planta", "vagas"));

//        System.out.println(ordenacaoJsonArray.jsonArrayImoveisFiltrados(jsonArrayImoveis ,"Santo André", "cidade", null));

//        JSONArray jsonArray = ordenacaoJsonArray.jsonArrayImoveisFiltrados(jsonArrayImoveis ,"Santo André", "cidade", null);
        JSONArray jsonArray = ordenacaoJsonArray.jsonArrayImoveisFiltrados(jsonArrayImoveis ,"Santo Antônio", "bairro", null);
//        JSONArray jsonArray = ordenacaoJsonArray.jsonArrayImoveisFiltrados(jsonArrayImoveis ,"São Bernardo do Campo", "cidade", null);

        JSONArray jsonArray1 = ordenacaoJsonArray.jsonArraySortCamposNumberRange(jsonArray, 0.0 , 1.0, 0, "planta", "vagas" );

        System.out.println(jsonArray1);


    }
}
