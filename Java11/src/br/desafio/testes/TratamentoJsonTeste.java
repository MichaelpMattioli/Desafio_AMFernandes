package br.desafio.testes;

import br.desafio.API.ImobiliariaAPI;
import br.desafio.filtroJSON.TratamentoJson;

public class TratamentoJsonTeste {

    public void run(){
        ImobiliariaAPI imobiliariaAPI = new ImobiliariaAPI();

        TratamentoJson tratamentoJson = new TratamentoJson();

//        System.out.println(tratamentoJson.listaCamposSemRepeticao("cidade"));
        System.out.println(tratamentoJson.jsonArrayImoveisFiltrados("planta", "preco", "670000"));




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
