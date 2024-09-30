package com.locadora.interfaces;

import com.locadora.models.Agencia;

public interface IAgenciaService {
    void cadastrarAgencia(Agencia agencia);
    void alterarAgencia(String id, Agencia agencia);
    void buscarAgencia(String nome);
    void deletarAgencia(String id);
}
