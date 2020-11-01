package br.desafio.JS;

import br.desafio.ImobiliariaAPI;
import br.desafio.JS.tratamentosJson.OrdenacaoJsonArray;
import br.desafio.models.Imovel;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ImovelJS {

    OrdenacaoJsonArray ordenacaoJsonArray = new OrdenacaoJsonArray();

    ImobiliariaAPI imobiliariaAPI = new ImobiliariaAPI();

    JSONArray jsonArrayAtual = new JSONArray();

    public List<Imovel> imovelListInicial(){
        List<Imovel> imovelList = new ArrayList<>();

        JSONArray jsonArrayImoveisInicial; // 587 imoveis

        {
            try {
                jsonArrayImoveisInicial = imobiliariaAPI.imoveisJsonArray();
            } catch (Exception e) {
                jsonArrayImoveisInicial = new JSONArray();
            }
        }

        jsonArrayImoveisInicial.forEach(jsonObject ->{

            JSONObject jsonObject1 = (JSONObject) jsonObject;

            String cidade;
            String bairro;
            String num;
            JSONObject planta;
            JSONObject location;
            String nome;
            String fachada;
            String cep;
            String rua;
            Double preco;
            Integer vagas;
            Integer dormitorios;
            Double metragem;
            Double _long;
            Double _lat;


            cidade = jsonObject1.getString("cidade");
            bairro = jsonObject1.getString("bairro");
            num = jsonObject1.getString("num");
            try{
                planta = jsonObject1.getJSONObject("planta");
                try{
                    preco = Double.parseDouble(planta.getInt("preco")+"");
                }catch (Exception e){
                    preco = null;
                }

                try{
                    vagas = planta.getInt("vagas");
                }catch (Exception e){
                    vagas = null;
                }

                try{
                    dormitorios = planta.getInt("dorms");
                }catch (Exception e){
                    dormitorios = null;
                }

                try{
                    metragem = Double.parseDouble(planta.get("metragem").toString());
                }catch (Exception e){
                    metragem = null;
                }
            }catch (Exception e){
                planta = null;
                preco = null;
                vagas = null;
                dormitorios = null;
                metragem = null;
            }
            try {
                location = jsonObject1.getJSONObject("location");
                try{
                    _long = Double.parseDouble(location.get("_long").toString());
                }catch (Exception e){
                    _long = null;
                }

                try{
                    _lat = Double.parseDouble(location.get("_lat").toString());
                }catch (Exception e){
                    _lat = null;
                }
            }catch (Exception e){
                location = null;
                _long = null;
                _lat = null;
            }

            nome = jsonObject1.getString("nome");
            fachada = jsonObject1.getString("fachada");
            cep = jsonObject1.get("cep").toString();
            rua = jsonObject1.getString("rua");



            Imovel imovel = new Imovel(cidade,bairro,num,planta,location,nome,fachada,cep,rua,preco,vagas,dormitorios,metragem,_long,_lat);

            imovelList.add(imovel);
        });

        return imovelList;
    }

    public List<Imovel> imoveisListSortCamposNumberRange (JSONArray jsonArrayImoveis, Double valorMin, Double valorMax, int cresc_0_decres_1, String campo, String subCampo){
        List<Imovel> imovelList = new ArrayList<>();

        JSONArray jsonArray = ordenacaoJsonArray.jsonArraySortCamposNumberRange(jsonArrayImoveis, valorMin, valorMax, cresc_0_decres_1, campo, subCampo);

        jsonArrayAtual = jsonArray;

        jsonArray.forEach(jsonObject ->{

            JSONObject jsonObject1 = (JSONObject) jsonObject;


            String cidade;
            String bairro;
            String num;
            JSONObject planta;
            JSONObject location;
            String nome;
            String fachada;
            String cep;
            String rua;
            Double preco;
            Integer vagas;
            Integer dormitorios;
            Double metragem;
            Double _long;
            Double _lat;


            cidade = jsonObject1.getString("cidade");
            bairro = jsonObject1.getString("bairro");
            num = jsonObject1.getString("num");
            try{
                planta = jsonObject1.getJSONObject("planta");
                try{
                    preco = Double.parseDouble(planta.getInt("preco")+"");
                }catch (Exception e){
                    preco = null;
                }

                try{
                    vagas = planta.getInt("vagas");
                }catch (Exception e){
                    vagas = null;
                }

                try{
                    dormitorios = planta.getInt("dorms");
                }catch (Exception e){
                    dormitorios = null;
                }

                try{
                    metragem = Double.parseDouble(planta.get("metragem").toString());
                }catch (Exception e){
                    metragem = null;
                }
            }catch (Exception e){
                planta = null;
                preco = null;
                vagas = null;
                dormitorios = null;
                metragem = null;
            }
            try {
                location = jsonObject1.getJSONObject("location");
                try{
                    _long = Double.parseDouble(location.get("_long").toString());
                }catch (Exception e){
                    _long = null;
                }

                try{
                    _lat = Double.parseDouble(location.get("_lat").toString());
                }catch (Exception e){
                    _lat = null;
                }
            }catch (Exception e){
                location = null;
                _long = null;
                _lat = null;
            }

            nome = jsonObject1.getString("nome");
            fachada = jsonObject1.getString("fachada");
            cep = jsonObject1.get("cep").toString();
            rua = jsonObject1.getString("rua");

            Imovel imovel = new Imovel(cidade,bairro,num,planta,location,nome,fachada,cep,rua,preco,vagas,dormitorios,metragem,_long,_lat);

            imovelList.add(imovel);
        });

        return imovelList;

    }

    public JSONArray getJsonArrayImoveis () { return jsonArrayAtual;}

}
