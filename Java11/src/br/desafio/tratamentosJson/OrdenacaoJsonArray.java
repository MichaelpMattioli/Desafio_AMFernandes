package br.desafio.tratamentosJson;

import br.desafio.API.ImobiliariaAPI;
import org.json.JSONArray;

public class OrdenacaoJsonArray {

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
