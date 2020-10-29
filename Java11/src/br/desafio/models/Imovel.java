package br.desafio.models;

import org.json.JSONObject;

public class Imovel {

    private String cidade;
    private String bairro;
    private Integer num;
    private JSONObject planta;
    private JSONObject location;
    private String nome;
    private String fachada;
    private Integer cep;
    private String rua;

    // informações da planta
    private Float preco;
    private Integer vagas;
    private Integer dormitorios;
    private Float metragem;

    // informações da localização
    private Float _long;
    private Float _lat;

    public Imovel(String cidade, String bairro, Integer num, JSONObject planta, JSONObject location, String nome, String fachada, Integer cep, String rua, Float preco, Integer vagas, Integer dormitorios, Float metragem, Float _long, Float _lat) {
        this.cidade = cidade;
        this.bairro = bairro;
        this.num = num;
        this.planta = planta;
        this.location = location;
        this.nome = nome;
        this.fachada = fachada;
        this.cep = cep;
        this.rua = rua;
        this.preco = preco;
        this.vagas = vagas;
        this.dormitorios = dormitorios;
        this.metragem = metragem;
        this._long = _long;
        this._lat = _lat;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public Integer getNum() {
        return num;
    }

    public JSONObject getPlanta() {
        return planta;
    }

    public JSONObject getLocation() {
        return location;
    }

    public String getNome() {
        return nome;
    }

    public String getFachada() {
        return fachada;
    }

    public Integer getCep() {
        return cep;
    }

    public String getRua() {
        return rua;
    }

    public Float getPreco() {
        return preco;
    }

    public Integer getVagas() {
        return vagas;
    }

    public Integer getDormitorios() {
        return dormitorios;
    }

    public Float getMetragem() {
        return metragem;
    }

    public Float get_long() {
        return _long;
    }

    public Float get_lat() {
        return _lat;
    }

    @Override
    public String toString() {
        return "Imovel{" +
                "cidade='" + cidade + '\'' +
                ", bairro='" + bairro + '\'' +
                ", num=" + num +
                ", planta=" + planta +
                ", location=" + location +
                ", nome='" + nome + '\'' +
                ", fachada='" + fachada + '\'' +
                ", cep=" + cep +
                ", rua='" + rua + '\'' +
                ", preco=" + preco +
                ", vagas=" + vagas +
                ", dormitorios=" + dormitorios +
                ", metragem=" + metragem +
                ", _long=" + _long +
                ", _lat=" + _lat +
                '}';
    }
}
