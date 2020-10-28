package br.desafio.models;

public class Imovel {

    private int Id;
    private String nome;
    private String bairro;
    private String cep;
    private String cidade;
    private String fachada;
    private String rua;
    private String planta;

    public Imovel(int id, String nome, String bairro, String cep, String cidade, String fachada, String rua, String planta) {
        Id = id;
        this.nome = nome;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.fachada = fachada;
        this.rua = rua;
        this.planta = planta;
    }
}
