package com.example.financasPessoais.persistencia;

import java.util.List;

public interface IcrudDAO<T> {
    boolean salvar(T item);
    boolean alterar(T item);
    boolean deletar(T item);
    List<T> listarTodos();


}
