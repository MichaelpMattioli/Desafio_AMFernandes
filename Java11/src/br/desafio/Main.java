package br.desafio;

import br.desafio.testes.OrdenacaoJsonArrayTeste;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    ControllerInterface controllerInterface = new ControllerInterface();

    public static void main(String[] args) {
        OrdenacaoJsonArrayTeste ordenacaoJsonArrayTeste = new OrdenacaoJsonArrayTeste();
        ordenacaoJsonArrayTeste.run();

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ViewInterface.fxml"));
        primaryStage.setTitle("Desafio Estágio - AMFernantes");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();

    }

}
