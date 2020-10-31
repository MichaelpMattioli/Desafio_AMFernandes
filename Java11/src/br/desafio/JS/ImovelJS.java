package br.desafio.JS;

import br.desafio.ImobiliariaAPI;
import br.desafio.JS.tratamentosJson.OrdenacaoJsonArray;
import org.json.JSONArray;

public class ImovelJS {

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

}
