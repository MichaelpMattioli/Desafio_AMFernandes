package br.desafio.filtroJSON;

import br.desafio.API.ImobiliariaAPI;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TratamentoJson {
    ImobiliariaAPI imobiliariaAPI = new ImobiliariaAPI();

    JSONArray jsonArrayImoveis;

    {
        try {
            jsonArrayImoveis = imobiliariaAPI.imoveisJsonArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
