package br.desafio.models;

import org.json.JSONObject;

/**
 * Classe responsável por estruturar um imóvel. Variáveis são específicas e da estrutura da API do desafio. Ela apresenta todos os campos que a API do desafio tem.
 *  * @author Michael Pedroza Mattioli Leite - michael.pmattioli@gmail.com
 *  * @since 02/11/2020
 *  * @version 1.0
 */

public class Imovel {

    private String cidade;
    private String bairro;
    private String num;
    private JSONObject planta;
    private JSONObject location;
    private String nome;
    private String fachada;
    private String cep;
    private String rua;

    // informações da planta
    private Double preco;
    private Integer vagas;
    private Integer dormitorios;
    private Double metragem;

    // informações da localização
    private Double _long;
    private Double _lat;

    /**
     * Construtor que cria um imóvel, com todas as características adquiridas pela API.
     * @param cidade String que contém a cidade em que o imóvel está localizado
     * @param bairro String que contém  a bairro em que o imóvel está localizado
     * @param num String que contém  o numero do endereço do imóvel.
     * @param planta JSONObject que contém  todos os dados da planta do imóvel.
     * @param location JSONObject que contém  os dados da latitude e longitude do imóvel.
     * @param nome String que contém  o nome do condôminio do imóvel.
     * @param fachada String que contém  a URL da fachada do imóvel.
     * @param cep String que contém  o cep onde o imóvel está localizado
     * @param rua String que contém  a rua do endereço do imóvel.
     * @param preco Double que contém o preço do imóvel.
     * @param vagas Integer que contém o número de vagas que aquele imóvel tem.
     * @param dormitorios Integer que contém o número de dormitórios daquele imóvel.
     * @param metragem Double que contém a metragem daquele imóvel.
     * @param _long Double que contém a longitude daquele imóvel.
     * @param _lat Double que contém a latitude daquele imóvel.
     */

    public Imovel(String cidade, String bairro, String num, JSONObject planta, JSONObject location, String nome, String fachada, String cep, String rua, Double preco, Integer vagas, Integer dormitorios, Double metragem, Double _long, Double _lat) {
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

    public String getNum() {
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

    public String getCep() {
        return cep;
    }

    public String getRua() {
        return rua;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getVagas() {
        return vagas;
    }

    public Integer getDormitorios() {
        return dormitorios;
    }

    public Double getMetragem() {
        return metragem;
    }

    public Double get_long() {
        return _long;
    }

    public Double get_lat() {
        return _lat;
    }

    @Override
    public String toString() {
        return "Imóvel{" +
                "cidade='" + cidade + '\'' +
                ", bairro='" + bairro + '\'' +
                ", num='" + num + '\'' +
                ", planta=" + planta +
                ", location=" + location +
                ", nome='" + nome + '\'' +
                ", fachada='" + fachada + '\'' +
                ", cep='" + cep + '\'' +
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
