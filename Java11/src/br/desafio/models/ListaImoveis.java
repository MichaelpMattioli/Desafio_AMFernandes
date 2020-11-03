package br.desafio.models;

import java.util.List;

/**
 * Classe responsável por construir uma lista de imóveis a partir das informações da classe Imovel e poder navegar de maneira fixa entre os imoveis da lista.
 *  * @author Michael Pedroza Mattioli Leite - michael.pmattioli@gmail.com
 *  * @since 02/11/2020
 *  * @version 1.0
 */

public class ListaImoveis {
    private List<Imovel> listImovel;
    private int imovelAtual;

    /**
     * Construtor da lista. Cria uma lista de imóveis que contem vários Imovel.
     * @param listImovel
     */

    public ListaImoveis(List<Imovel> listImovel) {
        this.listImovel = listImovel;
        this.imovelAtual = 0;
    }

    /**
     * Método que retorna o imóvel do indice que atualmente está. Importante para que se navegue na lista.
     * @return Retorna um Imovel da lista no indice que atualmente está registrado na classe.
     */

    public final Imovel getlistImovelAtual(){
        return listImovel.get(imovelAtual);
    }

    /**
     * Método que muda o indice da lista, aumentando-o para que mude para o próximo imóvel.
     * @return boolean
     */

    public boolean switchToPrevious(){
        if(imovelAtual > 0){
            imovelAtual--;
            return true;
        }
        return false;
    }

    /**
     * Método que muda o indice da lista, diminuindo-o para que mude para o imóvel anterior.
     * @return boolean
     */

    public boolean switchToNext(){
        if(imovelAtual < listImovel.size() - 1){
            imovelAtual++;
            return true;
        }
        return false;
    }

    /**
     * Retorna o indice do imóvel atual.
     * @return Integer do indice do imóvel que está atualmente.
     */

    public int getImovelAtual() {
        return imovelAtual;
    }
}
