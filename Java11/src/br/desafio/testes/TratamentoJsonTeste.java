package br.desafio.testes;

import br.desafio.API.ImobiliariaAPI;
import br.desafio.filtroJSON.TratamentoJson;
import org.json.JSONArray;

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

        TratamentoJson tratamentoJson = new TratamentoJson();

        System.out.println(tratamentoJson.arrayListCamposSemRepeticao(jsonArrayImoveis,"cep"));
        System.out.println(tratamentoJson.jsonArrayImoveisFiltrados(jsonArrayImoveis,"1", "num"));

        System.out.println(tratamentoJson.jsonArrayImoveisFiltrados(jsonArrayImoveis,"1", "num").length());




//        try {
//            System.out.println(imobiliariaAPI.imoveisJsonArray().getJSONObject(0));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//        ArrayList listaInfoCampo = tratamentoJson.listaCamposSemRepeticao("location");
//
//        ArrayList listaValorDeCampo = (ArrayList) listaInfoCampo.get(2);
//
//        JSONObject jsonObjectValorDeCampo = (JSONObject) listaValorDeCampo.get(0);
//
//        float longitude = jsonObjectValorDeCampo.getFloat("_long");
//        float latitude = jsonObjectValorDeCampo.getFloat("_lat");
//
//        System.out.println(longitude + " : " + latitude);
    }
}
