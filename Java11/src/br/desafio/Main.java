package br.desafio;

import br.desafio.API.ImobiliariaAPI;
import br.desafio.filtroJSON.TratamentoJson;
import br.desafio.testes.TratamentoJsonTeste;

public class Main {

    public static void main(String[] args) {
        TratamentoJsonTeste tratamentoJsonTeste = new TratamentoJsonTeste();
        tratamentoJsonTeste.run();
    }
}
