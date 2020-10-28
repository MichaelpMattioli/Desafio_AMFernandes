package br.desafio.dao;

import java.util.List;

public interface DAO <T> {
    List<T> get(String condition);
    List<T> getAll();
    void create(T t);
}
