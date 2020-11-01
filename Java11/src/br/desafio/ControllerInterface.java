package br.desafio;

import br.desafio.JS.ImovelJS;
import br.desafio.models.Imovel;
import br.desafio.models.ListaImoveis;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerInterface implements Initializable{


    private ImobiliariaAPI imobiliariaAPI = new ImobiliariaAPI();

    {
        try {
            jsonArrayImoveisInicial = imobiliariaAPI.imoveisJsonArray();
        } catch (Exception e) {
            jsonArrayImoveisInicial = new JSONArray();
        }
    }

    private JSONArray jsonArrayImoveisInicial; // 587 imoveis
    private JSONArray jsonArrayImoveisAtual = jsonArrayImoveisInicial;

    ImovelJS imovelJS = new ImovelJS();

    private List<Imovel> imovelList = imovelJS.imovelListInicial();
    private ListaImoveis listaImoveis = new ListaImoveis(imovelList);


    @FXML
    private ListView<JSONObject> lvImoveisAtual;

    @FXML
    private TextField txtPrecoMinValor, txtPrecoMaxValor, txtMetragemMinValor, txtMetragemMaxValor, txtVagasMinValor, txtVagasMaxValor, txtDormsMinValor, txtDormsMaxValor;

    @FXML
    private Label lblIdNome, lblIdPreco, lblIdDorms, lblIdVagas, lblIdMetragem, lblIdRua, lblIdNum, lblIdBairro, lblIdCidade, lblIdCep, lblTotalPesquisa , lblIndiceAtual;

    @FXML
    private ImageView imgFachada;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        previewPhoto();
        exibirDadosDoImovel();
    }

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
    }

    @FXML
    public void proximoImovel(){
        listaImoveis.switchToNext();
        exibirDadosDoImovel();
    }

    @FXML
    public void AnteriorImovel(){
        listaImoveis.switchToPrevious();
        exibirDadosDoImovel();
    }

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

    public void busca(){

        filtraImoveisSortRangeVagas(jsonArrayImoveisAtual);
        filtraImoveisSortRangeMetragem(jsonArrayImoveisAtual);
        filtraImoveisSortRangePreco(jsonArrayImoveisAtual);
        filtraImoveisSortRangeDorms(jsonArrayImoveisAtual);

        lvImoveisAtual.getItems().clear();
        jsonArrayImoveisAtual.forEach(item -> lvImoveisAtual.getItems().add((JSONObject) item));


        jsonArrayImoveisAtual = jsonArrayImoveisInicial;

        if(txtPrecoMinValor.getText().trim().isBlank() && txtPrecoMaxValor.getText().trim().isBlank() && txtMetragemMinValor.getText().trim().isBlank() && txtMetragemMaxValor.getText().trim().isBlank() && txtVagasMinValor.getText().trim().isBlank() && txtVagasMaxValor.getText().trim().isBlank() && txtDormsMinValor.getText().trim().isBlank() && txtDormsMaxValor.getText().trim().isBlank()){
            imovelList = imovelJS.imovelListInicial();
            exibirDadosDoImovel();
        }
    }

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
}
