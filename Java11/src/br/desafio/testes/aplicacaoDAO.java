//package br.desafio.testes;
//
//import br.desafio.API.ImobiliariaAPI;
//import br.desafio.dao.ImovelDAO;
//import br.desafio.models.Imovel;
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.util.List;
//
//public class AplicacaoDAO {
//
//    ImobiliariaAPI imobiliariaAPI = new ImobiliariaAPI();
//
//    private List<Imovel> listaImoveisDB;
//    private ImovelDAO imovelDAO = new ImovelDAO();
//
//
//    public void exibirImoveis() {
//        listaImoveisDB = imovelDAO.getAll();
//        System.out.println("Imoveis:");
//        listaImoveisDB.forEach( imovel -> System.out.println(imovel));
//    }
//
//    public void cadastramentoImoveis(){
//        try {
//            JSONArray jsonArrayImoveis = imobiliariaAPI.imoveisJsonArray();
//            int i = 0;
//
//            System.out.println(jsonArrayImoveis.length());
//
//            for ( i = 0; i < jsonArrayImoveis.length(); i++){
//                JSONObject jsonObjectImovel = jsonArrayImoveis.getJSONObject(i);
//                int id = i;
//                String nome = jsonObjectImovel.getString("nome");
//                String bairro = jsonObjectImovel.getString("bairro");
//                String cidade = jsonObjectImovel.getString("cidade");
//                String fachada = jsonObjectImovel.getString("fachada");
//                String rua = jsonObjectImovel.getString("rua");
//
//                imovelDAO.create(new Imovel(
//                        id, nome, bairro, cidade, fachada, rua
//                ));
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Algum erro ocorreu no cadastramento");
//        }
//    }
//
//
//
//}
