package br.desafio;

import br.desafio.JS.ImovelJS;
import br.desafio.JS.tratamentosJson.InfoCamposJsonArray;
import br.desafio.models.Imovel;
import br.desafio.models.ListaImoveis;
import br.desafio.sorts.Sorts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * .
 *  * @author Michael Pedroza Mattioli Leite - michael.pmattioli@gmail.com
 *  * @since 02/11/2020
 *  * @version 1.0
 */

public class ControllerInterface implements Initializable{

    private ImobiliariaAPI imobiliariaAPI = new ImobiliariaAPI();
    InfoCamposJsonArray infoCamposJsonArray = new InfoCamposJsonArray();
    Sorts sorts = new Sorts();

    {
        try {
            jsonArrayImoveisInicial = imobiliariaAPI.imoveisJsonArray();
        } catch (Exception e) {
            jsonArrayImoveisInicial = new JSONArray();
        }
    }

    private JSONArray jsonArrayImoveisInicial; // 587 imoveis
    private  JSONArray jsonArrayImoveisAnterior = jsonArrayImoveisInicial;
    private JSONArray jsonArrayImoveisAtual = jsonArrayImoveisInicial;

    ImovelJS imovelJS = new ImovelJS();

    private List<Imovel> imovelList = imovelJS.imovelListInicial();
    private ListaImoveis listaImoveis = new ListaImoveis(imovelList);


    @FXML
    private ListView<JSONObject> lvImoveisAtual;

    @FXML
    private ListView<String> lvBairro,lvCidade;

    ArrayList arrayListInfoCidade = infoCamposJsonArray.arrayListInfoCamposSemRepeticao(jsonArrayImoveisInicial, "cidade", null);
    ArrayList arrayListInfoBairro = infoCamposJsonArray.arrayListInfoCamposSemRepeticao(jsonArrayImoveisInicial, "bairro", null);

    private List<String> arrayListOfLVCidade = FXCollections.observableArrayList(sorts.sortStringOrdemAlfabetica( (ArrayList) arrayListInfoCidade.get(arrayListInfoCidade.size()-1)));
    private List<String> arrayListOfLVBairro = sorts.sortStringOrdemAlfabetica((ArrayList) arrayListInfoBairro.get(arrayListInfoBairro.size()-1));

    @FXML
    ObservableList<String> data = FXCollections.observableArrayList("List index 0", "List index 1");
    ListView<String> list = new ListView<>(data);


    @FXML
    private TextField txtPrecoMinValor, txtPrecoMaxValor, txtMetragemMinValor, txtMetragemMaxValor, txtVagasMinValor, txtVagasMaxValor, txtDormsMinValor, txtDormsMaxValor;

    @FXML
    private Label lblIdNome, lblIdPreco, lblIdDorms, lblIdVagas, lblIdMetragem, lblIdRua, lblIdNum, lblIdBairro, lblIdCidade, lblIdCep, lblTotalPesquisa , lblIndiceAtual, lblCidade, lblBairro;

    @FXML
    private ImageView imgFachada;

    public void initActions(){

        list.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(lvCidade.getSelectionModel().getSelectedIndex() == 0){
                    System.out.println("index 0");
                }

            }
        });
    }

    /**
     * Método responsável por iniciar as informações no programa.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        previewPhoto();
        exibirDadosDoImovel();
        exibirLVdeImoveis();
        exibirLVCidade();
        exibirLVBairro();
    }

    /**
     * Método responsável por exibir os dados em cada campo, os dados são extraidos do imóvel que atualmente está na lista de imóveis.
     */
    @FXML
    public void exibirDadosDoImovel(){


        int indexDoImovelAtual = listaImoveis.getImovelAtual();

        if(imovelList.size() == 0){
            String nome = "-";
            String preco = "-";
            String dormitorios = "-";
            String vagas = "-";
            String metragem = "-";

            String rua = "-";
            String num = "-";
            String bairro = "-";
            String cidade = "-";
            String cep = "-";

            lblIdNome.setText(nome);
            lblIdPreco.setText(preco);
            lblIdDorms.setText(dormitorios);
            lblIdVagas.setText(vagas);
            lblIdMetragem.setText(metragem);
            lblIdRua.setText(rua);
            lblIdNum.setText(num);
            lblIdBairro.setText(bairro);
            lblIdCidade.setText(cidade);
            lblIdCep.setText(cep);

            lblIndiceAtual.setText("-");
            lblTotalPesquisa.setText("de "+imovelList.size());
        }else {

            String nome = imovelList.get(indexDoImovelAtual).getNome() + "";
            String preco = imovelList.get(indexDoImovelAtual).getPreco() + "";
            String dormitorios = imovelList.get(indexDoImovelAtual).getDormitorios() + "";
            String vagas = imovelList.get(indexDoImovelAtual).getVagas() + "";
            String metragem = imovelList.get(indexDoImovelAtual).getMetragem() + "";

            String rua = imovelList.get(indexDoImovelAtual).getRua() + "";
            String num = imovelList.get(indexDoImovelAtual).getNum() + "";
            String bairro = imovelList.get(indexDoImovelAtual).getBairro() + "";
            String cidade = imovelList.get(indexDoImovelAtual).getCidade() + "";
            String cep = imovelList.get(indexDoImovelAtual).getCep() + "";

            lblIdNome.setText(nome);
            lblIdPreco.setText(preco);
            lblIdDorms.setText(dormitorios);
            lblIdVagas.setText(vagas);
            lblIdMetragem.setText(metragem);
            lblIdRua.setText(rua);
            lblIdNum.setText(num);
            lblIdBairro.setText(bairro);
            lblIdCidade.setText(cidade);
            lblIdCep.setText(cep);

            lblIndiceAtual.setText(listaImoveis.getImovelAtual() + 1 + "");
            lblTotalPesquisa.setText("de " + imovelList.size());
        }

        previewPhoto();

        exibirLVdeImoveis();
        exibirLVCidade();
        exibirLVBairro();
    }

    /**
     * Método que fará com que o usuario percorra pela lista de imoveis, passando para o próximo imóvel.
     */
    @FXML
    public void proximoImovel(){
        jsonArrayImoveisAtual = jsonArrayImoveisAnterior;
        listaImoveis.switchToNext();
        exibirDadosDoImovel();
    }

    /**
     * Método que fará com que o usuario percorra pela lista de imoveis, passando para o imóvel anterior.
     */

    @FXML
    public void AnteriorImovel(){
        jsonArrayImoveisAtual = jsonArrayImoveisAnterior;
        listaImoveis.switchToPrevious();
        exibirDadosDoImovel();
    }

    /**
     * Método que irá mostrar a fachada adquirida pela URL presente em cada imóvel.
     */

    @FXML
    public void previewPhoto(){
        Image image;
        try{
            image = new Image(imovelList.get(listaImoveis.getImovelAtual()).getFachada());
        }catch (Exception e){
            image = new Image("br/desafio/nullFachada.jpg");
        }
        imgFachada.setImage(image);
    }

    /**
     * Método que inicia a busca de imoveis que compreende aos dados de filtro que o usuario digitou, atualizando o programa para aquelas especificações.
     */

    public void busca(){

        if(txtPrecoMinValor.getText().trim().isBlank() && txtPrecoMaxValor.getText().trim().isBlank() && txtMetragemMinValor.getText().trim().isBlank() && txtMetragemMaxValor.getText().trim().isBlank() && txtVagasMinValor.getText().trim().isBlank() && txtVagasMaxValor.getText().trim().isBlank() && txtDormsMinValor.getText().trim().isBlank() && txtDormsMaxValor.getText().trim().isBlank() && lblCidade.getText().equals("-") && lblBairro.getText().equals("-")){
            imovelList = imovelJS.imovelListInicial();
            exibirDadosDoImovel();
        }

        filtraImoveisSortRangeVagas(jsonArrayImoveisAtual);
        filtraImoveisSortRangeMetragem(jsonArrayImoveisAtual);
        filtraImoveisSortRangePreco(jsonArrayImoveisAtual);
        filtraImoveisSortRangeDorms(jsonArrayImoveisAtual);
        filtrarImoveisSortCidade(jsonArrayImoveisAtual);

        jsonArrayImoveisAnterior = jsonArrayImoveisAtual;
        jsonArrayImoveisAtual = jsonArrayImoveisInicial;

        System.out.println(lvCidade.getItems());

    }

    /**
     * Método que realiza a busca de imoveis com uma faixa de preço específico.
     * @param jsonArray JSONArray que atualmente está sendo buscado e processado.
     */

    public void filtraImoveisSortRangePreco(JSONArray jsonArray){

        Double minPrecoValor;
        Double maxPrecoValor;

        if(txtPrecoMinValor.getText().equals("") && txtPrecoMaxValor.getText().equals("")){
            return;
        }else {
            if(txtPrecoMinValor.getText().equals("")){
                minPrecoValor = 0.0;

                try{
                    maxPrecoValor = Double.parseDouble(txtPrecoMaxValor.getText());
                }catch (Exception e){
                    txtPrecoMinValor.clear();
                    txtPrecoMaxValor.clear();
                    return;
                }

                maxPrecoValor = Double.parseDouble(txtPrecoMaxValor.getText());

                imovelList = imovelJS.imoveisListSortCamposNumberRange(jsonArray,minPrecoValor, maxPrecoValor, 0, "planta", "preco");


                listaImoveis = new ListaImoveis(imovelList);


                exibirDadosDoImovel();

            }else{
                maxPrecoValor = 1000000000000.0;

                try{
                    minPrecoValor = Double.parseDouble(txtPrecoMinValor.getText());
                }catch (Exception e){
                    txtPrecoMinValor.clear();
                    txtPrecoMaxValor.clear();
                    return;
                }

                minPrecoValor = Double.parseDouble(txtPrecoMinValor.getText());

                imovelList = imovelJS.imoveisListSortCamposNumberRange(jsonArray,minPrecoValor, maxPrecoValor, 0, "planta", "preco");

                listaImoveis = new ListaImoveis(imovelList);

                exibirDadosDoImovel();
            }

            if(!txtPrecoMinValor.getText().equals("") && !txtPrecoMaxValor.getText().equals("")) {

                try {
                    minPrecoValor = Double.parseDouble(txtPrecoMinValor.getText());
                    maxPrecoValor = Double.parseDouble(txtPrecoMaxValor.getText());
                } catch (Exception e) {
                    txtPrecoMinValor.clear();
                    txtPrecoMaxValor.clear();
                    return;
                }

                minPrecoValor = Double.parseDouble(txtPrecoMinValor.getText());
                maxPrecoValor = Double.parseDouble(txtPrecoMaxValor.getText());

                imovelList = imovelJS.imoveisListSortCamposNumberRange(jsonArray, minPrecoValor, maxPrecoValor, 0, "planta", "preco");

                listaImoveis = new ListaImoveis(imovelList);


            }

        }
        jsonArrayImoveisAtual = imovelJS.getJsonArrayImoveis();
        exibirDadosDoImovel();

    }

    /**
     * Método que realiza a busca de imoveis com uma faixa de metragem específico.
     * @param jsonArray JSONArray que atualmente está sendo buscado e processado.
     */

    public void filtraImoveisSortRangeMetragem(JSONArray jsonArray){

        Double minValor;
        Double maxValor;

        if(txtMetragemMinValor.getText().equals("") && txtMetragemMaxValor.getText().equals("")){
            return;
        }else {
            if(txtMetragemMinValor.getText().equals("")){
                minValor = 0.0;

                try{
                    maxValor = Double.parseDouble(txtMetragemMaxValor.getText());
                }catch (Exception e){
                    txtMetragemMinValor.clear();
                    txtMetragemMaxValor.clear();
                    return;
                }

                maxValor = Double.parseDouble(txtMetragemMaxValor.getText());

                imovelList = imovelJS.imoveisListSortCamposNumberRange(jsonArray,minValor, maxValor, 0, "planta", "metragem");


                listaImoveis = new ListaImoveis(imovelList);


                exibirDadosDoImovel();

            }else{
                maxValor = 1000000000000.0;

                try{
                    minValor = Double.parseDouble(txtMetragemMinValor.getText());
                }catch (Exception e){
                    txtMetragemMinValor.clear();
                    txtMetragemMaxValor.clear();
                    return;
                }

                minValor = Double.parseDouble(txtMetragemMinValor.getText());

                imovelList = imovelJS.imoveisListSortCamposNumberRange(jsonArray,minValor, maxValor, 0, "planta", "metragem");

                listaImoveis = new ListaImoveis(imovelList);

                exibirDadosDoImovel();
            }

            if(!txtMetragemMinValor.getText().equals("") && !txtMetragemMaxValor.getText().equals("")) {

                try {
                    minValor = Double.parseDouble(txtMetragemMinValor.getText());
                    maxValor = Double.parseDouble(txtMetragemMaxValor.getText());
                } catch (Exception e) {
                    txtMetragemMinValor.clear();
                    txtMetragemMaxValor.clear();
                    return;
                }

                minValor = Double.parseDouble(txtMetragemMinValor.getText());
                maxValor = Double.parseDouble(txtMetragemMaxValor.getText());

                imovelList = imovelJS.imoveisListSortCamposNumberRange(jsonArray, minValor, maxValor, 0, "planta", "metragem");

                listaImoveis = new ListaImoveis(imovelList);


            }

        }

        jsonArrayImoveisAtual = imovelJS.getJsonArrayImoveis();

        exibirDadosDoImovel();

    }

    /**
     * Método que realiza a busca de imoveis com uma faixa de vagas específico.
     * @param jsonArray JSONArray que atualmente está sendo buscado e processado.
     */

    public void filtraImoveisSortRangeVagas(JSONArray jsonArray){

        Double minValor;
        Double maxValor;

        if(txtVagasMinValor.getText().equals("") && txtVagasMaxValor.getText().equals("")){
            return;
        }else {
            if(txtVagasMinValor.getText().equals("")){
                minValor = 0.0;

                try{
                    maxValor = Double.parseDouble(txtVagasMaxValor.getText());
                }catch (Exception e){
                    txtVagasMinValor.clear();
                    txtVagasMaxValor.clear();
                    return;
                }

                maxValor = Double.parseDouble(txtVagasMaxValor.getText());

                imovelList = imovelJS.imoveisListSortCamposNumberRange(jsonArray,minValor, maxValor, 0, "planta", "vagas");


                listaImoveis = new ListaImoveis(imovelList);


                exibirDadosDoImovel();

            }else{
                maxValor = 1000000000000.0;

                try{
                    minValor = Double.parseDouble(txtVagasMinValor.getText());
                }catch (Exception e){
                    txtVagasMinValor.clear();
                    txtVagasMaxValor.clear();
                    return;
                }

                minValor = Double.parseDouble(txtVagasMinValor.getText());

                imovelList = imovelJS.imoveisListSortCamposNumberRange(jsonArray,minValor, maxValor, 0, "planta", "vagas");

                listaImoveis = new ListaImoveis(imovelList);

                exibirDadosDoImovel();
            }

            if(!txtVagasMinValor.getText().equals("") && !txtVagasMaxValor.getText().equals("")) {

                try {
                    minValor = Double.parseDouble(txtVagasMinValor.getText());
                    maxValor = Double.parseDouble(txtVagasMaxValor.getText());
                } catch (Exception e) {
                    txtVagasMinValor.clear();
                    txtVagasMaxValor.clear();
                    return;
                }

                minValor = Double.parseDouble(txtVagasMinValor.getText());
                maxValor = Double.parseDouble(txtVagasMaxValor.getText());

                imovelList = imovelJS.imoveisListSortCamposNumberRange(jsonArray, minValor, maxValor, 0, "planta", "vagas");

                listaImoveis = new ListaImoveis(imovelList);

            }

        }

        jsonArrayImoveisAtual = imovelJS.getJsonArrayImoveis();

        exibirDadosDoImovel();

    }

    /**
     * Método que realiza a busca de imoveis com uma faixa de dormitórios específico.
     * @param jsonArray JSONArray que atualmente está sendo buscado e processado.
     */

    public void filtraImoveisSortRangeDorms(JSONArray jsonArray){

        Double minValor;
        Double maxValor;

        if(txtDormsMinValor.getText().equals("") && txtDormsMaxValor.getText().equals("")){
            return;
        }else {
            if(txtDormsMinValor.getText().equals("")){
                minValor = 0.0;

                try{
                    maxValor = Double.parseDouble(txtDormsMaxValor.getText());
                }catch (Exception e){
                    txtDormsMinValor.clear();
                    txtDormsMaxValor.clear();
                    return;
                }

                maxValor = Double.parseDouble(txtDormsMaxValor.getText());

                imovelList = imovelJS.imoveisListSortCamposNumberRange(jsonArray,minValor, maxValor, 0, "planta", "dorms");


                listaImoveis = new ListaImoveis(imovelList);


                exibirDadosDoImovel();

            }else{
                maxValor = 1000000000000.0;

                try{
                    minValor = Double.parseDouble(txtDormsMinValor.getText());
                }catch (Exception e){
                    txtDormsMinValor.clear();
                    txtDormsMaxValor.clear();
                    return;
                }

                minValor = Double.parseDouble(txtDormsMinValor.getText());

                imovelList = imovelJS.imoveisListSortCamposNumberRange(jsonArray,minValor, maxValor, 0, "planta", "dorms");

                listaImoveis = new ListaImoveis(imovelList);

                exibirDadosDoImovel();
            }

            if(!txtDormsMinValor.getText().equals("") && !txtDormsMaxValor.getText().equals("")) {

                try {
                    minValor = Double.parseDouble(txtDormsMinValor.getText());
                    maxValor = Double.parseDouble(txtDormsMaxValor.getText());
                } catch (Exception e) {
                    txtDormsMinValor.clear();
                    txtDormsMaxValor.clear();
                    return;
                }

                minValor = Double.parseDouble(txtDormsMinValor.getText());
                maxValor = Double.parseDouble(txtDormsMaxValor.getText());

                imovelList = imovelJS.imoveisListSortCamposNumberRange(jsonArray, minValor, maxValor, 0, "planta", "dorms");

                listaImoveis = new ListaImoveis(imovelList);

            }

        }

        jsonArrayImoveisAtual = imovelJS.getJsonArrayImoveis();

        exibirDadosDoImovel();

    }

    /**
     * Método responsável por exibir a lista de imoveis num formato JSONObject, simplismente para conferir se o processo de busca está sendo realizado.
     */

    public void exibirLVdeImoveis(){
        lvImoveisAtual.getItems().clear();
        jsonArrayImoveisAtual.forEach(item -> lvImoveisAtual.getItems().add((JSONObject) item));
    }

    /**
     * Método responsável por exibir a lista de cidades que estão disponíveis na situação atual de busca do usuario.
     */

    public void exibirLVCidade(){
        InfoCamposJsonArray infoCamposJsonArray = new InfoCamposJsonArray();
        Sorts sorts = new Sorts();

        ArrayList arrayList = infoCamposJsonArray.arrayListInfoCamposSemRepeticao(jsonArrayImoveisAtual, "cidade", null);

        ArrayList cidadesExistentes = (ArrayList) arrayList.get(arrayList.size()-1);

        ArrayList cidadesExistentesOrganizadas = sorts.sortStringOrdemAlfabetica(cidadesExistentes);

        lvCidade.getItems().clear();
        cidadesExistentesOrganizadas.forEach(cidade -> lvCidade.getItems().add(cidade.toString()));
    }

    /**
     * Método responsável por exibir a lista de bairros que estão disponíveis na situação atual de busca do usuario.
     */

    public void exibirLVBairro(){
        InfoCamposJsonArray infoCamposJsonArray = new InfoCamposJsonArray();
        Sorts sorts = new Sorts();

        ArrayList arrayList = infoCamposJsonArray.arrayListInfoCamposSemRepeticao(jsonArrayImoveisAtual, "bairro", null);

        ArrayList bairrosExistentes = (ArrayList) arrayList.get(arrayList.size()-1);

        ArrayList bairrosExistentesOrganizadas = sorts.sortStringOrdemAlfabetica(bairrosExistentes);

        lvBairro.getItems().clear();
        bairrosExistentesOrganizadas.forEach(cidade -> lvBairro.getItems().add(cidade.toString()));
    }

    /**
     * Método responsável por limpar o campo de busca da cidade.
     */

    public void limparLblCidade(){
        lblCidade.setText("-");
    }

    /**
     * Método responsável por limpar o campo de busca do bairro.
     */

    public void limparLblBairro(){
        lblBairro.setText("-");
    }

    public void filtrarImoveisSortCidade(JSONArray jsonArray){

        String cidadeAtual = lblCidade.getText();

        if(cidadeAtual.equals("-")){
            return;
        }


        arrayListOfLVCidade = sorts.sortStringOrdemAlfabetica(infoCamposJsonArray.arrayListInfoCamposSemRepeticao(jsonArray, "cidade", null));


        imovelList = imovelJS.imoveisListSortAlfabetic(jsonArray, "cidade", cidadeAtual);

        listaImoveis = new ListaImoveis(imovelList);

        jsonArrayImoveisAtual = imovelJS.getJsonArrayImoveis();

        exibirDadosDoImovel();

    }
}
