package br.desafio.testes;

import br.desafio.tratamentosJson.OrdenacaoJsonArray;

public class OrdenacaoJsonArrayTeste {

    public void run(){
        OrdenacaoJsonArray ordenacaoJsonArray = new OrdenacaoJsonArray();

//        System.out.println(ordenacaoJsonArray.jsonArraySortCamposAlfabetic("nome"));

//        System.out.println(ordenacaoJsonArray.jsonArraySortCamposNumber(0, "planta", "preco"));

        System.out.println(ordenacaoJsonArray.jsonArraySortCamposNumberRange(3.0,3.0, 1, "planta", "vagas"));

    }
}
