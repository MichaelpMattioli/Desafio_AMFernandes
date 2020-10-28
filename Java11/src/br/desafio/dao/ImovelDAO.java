package br.desafio.dao;

import br.desafio.models.Imovel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImovelDAO implements DAO<Imovel>, DAOFields {

    private Connection connection;
    private final String myDBConnectionString = "jdbc:sqlite:imoveis.db";
    private int statusErroCreate;

    public ImovelDAO() {
        try {
            connection = DriverManager.getConnection(myDBConnectionString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Imovel> get(String condition) {
        List<Imovel> listaImoveis = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectConditionalString(getTableName()) + condition);
            while(result.next()){
                Imovel imovel = new Imovel(
                        result.getInt("id"),
                        result.getString("nome"),
                        result.getString("bairro"),
                        result.getString("cep"),
                        result.getString("cidade"),
                        result.getString("fachada"),
                        result.getString("rua"),
                        result.getString("planta")
                );
                listaImoveis.add(imovel);
            }
            result.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaImoveis;
    }

    @Override
    public List<Imovel> getAll() {
        List<Imovel> listaImoveis = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectAllString(getTableName()));
            while(result.next()){
                Imovel imovel = new Imovel(
                        result.getInt("id"),
                        result.getString("nome"),
                        result.getString("bairro"),
                        result.getString("cep"),
                        result.getString("cidade"),
                        result.getString("fachada"),
                        result.getString("rua"),
                        result.getString("planta")
                );
                listaImoveis.add(imovel);
            }
            result.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return listaImoveis;
    }

    @Override
    public void update(Imovel imovel){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getUpdateString(getTableName()));
            preparedStatement.setInt(1, imovel.getId());
            preparedStatement.setString(2, imovel.getNome());
            preparedStatement.setString(3, imovel.getBairro());
            preparedStatement.setString(4, imovel.getCep());
            preparedStatement.setString(5, imovel.getCidade());
            preparedStatement.setString(6, imovel.getFachada());
            preparedStatement.setString(7, imovel.getRua());
            preparedStatement.setString(8, imovel.getPlanta());

            int retorno = preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Imovel imovel) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getDeleteString(getTableName()));
            preparedStatement.setInt(1, imovel.getId());
            preparedStatement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void create(Imovel imovel){

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getInsertString(getTableName()));
            preparedStatement.setInt(1, imovel.getId());
            preparedStatement.setString(2, imovel.getNome());
            preparedStatement.setString(3, imovel.getBairro());
            preparedStatement.setString(4, imovel.getCep());
            preparedStatement.setString(5, imovel.getCidade());
            preparedStatement.setString(6, imovel.getFachada());
            preparedStatement.setString(7, imovel.getRua());
            preparedStatement.setString(8, imovel.getPlanta());

            int retorno = preparedStatement.executeUpdate();

            int statusErroCreate = 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public String getTableName() {
        return "imoveis";
    }

    @Override
    public String getDeleteString(String table) {
        return "DELETE FROM "+ table +" WHERE id = ?";
    }

    @Override
    public String getUpdateString(String table) {
        return "UPDATE "+ table +" SET id = ?, nome = ?, bairro = ?, cep = ?, cidade = ?, fachada = ?, rua = ?, planta = ? WHERE id = ?;";
    }

    @Override
    public String getInsertString(String table) {
        return "INSERT INTO "+ table + " (id, nome, bairro, cep, cidade, fachada, rua, planta) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    }

    @Override
    public String getSelectAllString(String table) {
        return "SELECT * FROM " + table;
    }

    @Override
    public String getSelectConditionalString(String table) {
        return "SELECT * FROM " + table + " WHERE ";
    }

}
