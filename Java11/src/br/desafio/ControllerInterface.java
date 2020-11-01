package br.desafio;

import br.desafio.JS.ImovelJS;
import br.desafio.models.Imovel;
import br.desafio.models.ListaImoveis;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.JSONArray;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerInterface implements Initializable{

    ImovelJS imovelJS = new ImovelJS();

    private JSONArray jsonArrayAtual = imovelJS.getJsonArrayImoveis();

    private List<Imovel> imovelList = imovelJS.imovelListInicial();
    ListaImoveis listaImoveis = new ListaImoveis(imovelList);



    @FXML
    private TextField txtPrecoMinValor, txtPrecoMaxValor, txtMetragemMinValor, txtMetragemMaxValor;

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
}
