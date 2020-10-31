package br.desafio.models;

import java.util.List;

public class ListaImoveis {
    private List<Imovel> listImovel;
    private int imovelAtual;

    public ListaImoveis(List<Imovel> listImovel) {
        this.listImovel = listImovel;
        this.imovelAtual = 0;
    }

    public final Imovel getlistImovelAtual(){
        return listImovel.get(imovelAtual);
    }

    public boolean switchToPreviousCard(){
        if(imovelAtual > 0){
            imovelAtual--;
            return true;
        }
        return false;
    }

    public boolean switchToNextCard(){
        if(imovelAtual < listImovel.size() - 1){
            imovelAtual++;
            return true;
        }
        return false;
    }

    public int getImovelAtual() {
        return imovelAtual;
    }
}
