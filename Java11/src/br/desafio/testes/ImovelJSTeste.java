package br.desafio.testes;

import br.desafio.ImobiliariaAPI;
import br.desafio.JS.ImovelJS;

public class ImovelJSTeste {

    ImovelJS imovelJS = new ImovelJS();
    ImobiliariaAPI imobiliariaAPI = new ImobiliariaAPI();

    public void run(){
//        System.out.println(imovelJS.imoveisListSortCamposNumberRange(0.0 , 1.0, 0, "planta", "vagas" ));
        System.out.println(imobiliariaAPI.imoveisJsonArray());
        System.out.println(imovelJS.imovelListPuro());
    }
}
