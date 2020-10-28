package br.desafio.testes;

import br.desafio.dao.ImovelDAO;
import br.desafio.models.Imovel;

import java.util.List;

public class aplicacaoDAO {

    private List<Imovel> listaImoveisDB;
    private ImovelDAO imovelDAO = new ImovelDAO();

    public void exibirImoveis() {
        listaImoveisDB = imovelDAO.getAll();
        System.out.println("Animes:");
        listaImoveisDB.forEach( imovel -> System.out.println(imovel));
    }



}
