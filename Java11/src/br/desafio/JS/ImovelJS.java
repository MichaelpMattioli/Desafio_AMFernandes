package br.desafio.JS;

import br.desafio.ImobiliariaAPI;
import br.desafio.JS.tratamentosJson.OrdenacaoJsonArray;
import br.desafio.models.Imovel;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por transformar um JSONArray em uma lista de imoveis (tipo List de Imovel), ou criar um imóvel (tipo Imovel) a partir de um JSONObject.
 *  * @author Michael Pedroza Mattioli Leite - michael.pmattioli@gmail.com
 *  * @since 02/11/2020
 *  * @version 1.0
 */

public class ImovelJS {

    OrdenacaoJsonArray ordenacaoJsonArray = new OrdenacaoJsonArray();
    ImobiliariaAPI imobiliariaAPI = new ImobiliariaAPI();
    JSONArray jsonArrayAtual = new JSONArray();

    /**
     * Método responsável por inicializar uma lista de imoveis com suas informações já em uma variável específica. Ela faz uma requisição pela API através da classe ImobiliariaAPI e transforma em JSONArray, assim com os dados informados da API ela separa cada dado em uma variavel específica e constroe um Imovel Object, e por final adiciona cada imóvel na lista. (IMPORTANTE!) Restrito apenas para o modelo informado no desafio.
     * @return Retorna um List de Imovel.
     */

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

            imovelList.add(createImovel((JSONObject) jsonObject));
        });

        return imovelList;
    }

    /**
     * * Método responsável por criar uma lista de imoveis ordenado em ordem numérica. A partir dos valores informados, ele transforma um JSONArray em uma lista de imoveis (tipo List de Imovel) ordenados em ordem numérica, crescente ou decrescente, a partir de uma faixa de valor específicada.(IMPORTANTE!) Restrito apenas para o modelo informado no desafio.
     * @param jsonArrayImoveis JSONArray que será transformado em uma lista de imoveis ordenados (tipo List de Imovel).
     * @param valorMin Double do valor mínimo da faixa.
     * @param valorMax Double do valor máximo da faixa.
     * @param cresc_0_decres_1 Integer que deve ser informado 0 (crescente) ou 1 (decrescente).
     * @param campo String que representa o campo que queira ordenar em ordem numérica.
     * @param subCampo String que representa o sub campo que queira ordenar. Informar nulo caso nao apresente.
     * @return Retorna uma lista de imoveis (tipo List de Imovel).
     */

    public List<Imovel> imoveisListSortCamposNumberRange (JSONArray jsonArrayImoveis, Double valorMin, Double valorMax, int cresc_0_decres_1, String campo, String subCampo){
        List<Imovel> imovelList = new ArrayList<>();

        JSONArray jsonArray = ordenacaoJsonArray.jsonArraySortCamposNumberRange(jsonArrayImoveis, valorMin, valorMax, cresc_0_decres_1, campo, subCampo);

        jsonArrayAtual = jsonArray;

        jsonArray.forEach(jsonObject ->{

            imovelList.add(createImovel((JSONObject) jsonObject));
        });

        return imovelList;

    }

    /**
     * Método responsável por criar uma lista de imoveis filtrado a partir de um nome específico. A partir dos valores informados, ele transforma um JSONArray em uma lista de imoveis (tipo List de Imovel) filtrado.
     * @param jsonArrayImoveis JSONArray que será transformado em uma lista de imoveis ordenados (tipo List de Imovel).
     * @param campo String que representa o campo que queira ordenar em ordem alfabética.
     * @param valorDeCampo String que representa o valor específico do campo a ser filtrado.
     * @return Retorna uma lista de imoveis (tipo List de Imovel).
     */

    public List<Imovel> imoveisListSortAlfabetic (JSONArray jsonArrayImoveis,String campo, String valorDeCampo){
        List<Imovel> imovelList = new ArrayList<>();

        JSONArray jsonArray = ordenacaoJsonArray.jsonArraySortCamposAlfabetic(jsonArrayImoveis, campo);

        JSONArray jsonArray1 = ordenacaoJsonArray.jsonArrayImoveisFiltrados(jsonArray, valorDeCampo, campo,null);

        jsonArrayAtual = jsonArray1;

        jsonArray1.forEach(jsonObject ->{

            imovelList.add(createImovel((JSONObject) jsonObject));
        });

        return imovelList;

    }

    /**
     * Método responsável por transformar um JSONObject em um imóvel. Ele retirar os dados de JSONObject e introduzir tais variáveis nas características do imóvel.
     * @param jsonObject JSONObject a ser transformado em imóvel.
     * @return Retorna um imóvel (tipo Imovel) com as caracteristica do JSONOBject. (RESTRITO APENAS PARA O DESAFIO!)
     */

    public Imovel createImovel(JSONObject jsonObject){

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


        try{
            cidade = jsonObject1.getString("cidade");
        }catch (Exception e){
            cidade = null;
        }
        try{
            bairro = jsonObject1.getString("bairro");
        }catch (Exception e){
            bairro = null;
        }
        try{
            num = jsonObject1.getString("num");
        }catch (Exception e){
            num = null;
        }
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

        try{
            nome = jsonObject1.getString("nome");
        }catch (Exception e){
            nome = null;
        }

        try{
            fachada = jsonObject1.getString("fachada");
        }catch (Exception e){
            fachada = null;
        }

        try{
            cep = jsonObject1.getString("cep");
        }catch (Exception e){
            cep = null;
        }

        try{
            rua = jsonObject1.getString("rua");
        }catch (Exception e){
            rua = null;
        }

        Imovel imovel = new Imovel(cidade,bairro,num,planta,location,nome,fachada,cep,rua,preco,vagas,dormitorios,metragem,_long,_lat);

        return imovel;
    }

    /**
     * Método responsável para retornar o ultimo JSONArray tratado pelos métodos dessa classe, caso as classes não tratem o JSONArray ele ficara como o inicializado, que seria o adquirido pela API.
     * @return JSONArray tratado ou não.
     */

    public JSONArray getJsonArrayImoveis () { return jsonArrayAtual;}

}
