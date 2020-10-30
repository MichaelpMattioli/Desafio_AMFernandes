package br.desafio.testes;

import br.desafio.tratamentosJson.InfoCamposJsonArray;

public class OrdenacaoJsonArrayTeste {

    public void run(){
        InfoCamposJsonArray infoCamposJsonArray = new InfoCamposJsonArray();

//        System.out.println(ordenacaoJsonArray.jsonArraySortCamposAlfabetic("nome"));

//        System.out.println(ordenacaoJsonArray.jsonArraySortCamposNumber(0, "planta", "preco"));

        System.out.println(infoCamposJsonArray.jsonArraySortCamposNumberRange(3.0,3.0, 1, "planta", "vagas"));

    }
}
