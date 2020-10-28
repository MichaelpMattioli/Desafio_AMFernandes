package br.desafio.models;

public class Imovel {

    private int Id;
    private String nome;
    private String bairro;
    private String cidade;
    private String fachada;
    private String rua;

    public Imovel(int id, String nome, String bairro, String cidade, String fachada, String rua) {
        Id = id;
        this.nome = nome;
        this.bairro = bairro;
        this.cidade = cidade;
        this.fachada = fachada;
        this.rua = rua;
    }

    public int getId() {
        return Id;
    }

    public String getNome() {
        return nome;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getFachada() {
        return fachada;
    }

    public String getRua() {
        return rua;
    }


    @Override
    public String toString() {
        return "Imovel{" +
                "Id=" + Id +
                ", nome='" + nome + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", fachada='" + fachada + '\'' +
                ", rua='" + rua + '\'' +
                '}';
    }
}
