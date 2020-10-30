package br.desafio.testes;

import br.desafio.tratamentosJson.OrdenacaoJsonArray;

public class OrdenacaoJsonArrayTeste {

    public void run(){
        OrdenacaoJsonArray ordenacaoJsonArray = new OrdenacaoJsonArray();

        System.out.println(ordenacaoJsonArray.jsonArraySortCamposAlfabetic("nome"));

//        System.out.println(ordenacaoJsonArray.jsonArraySortCamposNumber(0, "planta", "preco"));
    }
}
