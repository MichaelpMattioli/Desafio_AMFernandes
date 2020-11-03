package br.desafio;

import org.json.JSONArray;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Classe responsável por fazer a requisição da API pelo link fornecido pelo desafio.
 *  * @author Michael Pedroza Mattioli Leite - michael.pmattioli@gmail.com
 *  * @since 02/11/2020
 *  * @version 1.0
 */

public class ImobiliariaAPI {

    /**
     * Método responsável por fazer a requisição da API pelo link fornecido pelo desafio.
     * @return Retorna um Array de JSON com as informações adquiridas pelo link.
     */
    public JSONArray imoveisJsonArray() {

        try{
            java.util.concurrent.TimeUnit.SECONDS.sleep(2);
            HttpClient client = HttpClient.newBuilder().build();
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("https://api.estagio.amfernandes.com.br/imoveis"))
                    .build();
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            JSONArray jsonArray = new JSONArray(response.body());

            return jsonArray;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("NAO FOI POSSIVEL ACESSAR A API!");
        }

        return null;

    }
}
