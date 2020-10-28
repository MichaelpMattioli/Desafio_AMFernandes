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

    public int getId() {
        return Id;
    }

    public String getNome() {
        return nome;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
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

    public String getPlanta() {
        return planta;
    }

    @Override
    public String toString() {
        return "Imovel{" +
                "Id=" + Id +
                ", nome='" + nome + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", fachada='" + fachada + '\'' +
                ", rua='" + rua + '\'' +
                ", planta='" + planta + '\'' +
                '}';
    }
}
