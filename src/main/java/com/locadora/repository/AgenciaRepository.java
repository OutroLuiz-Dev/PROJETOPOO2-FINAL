package com.locadora.repository;

import com.locadora.models.Agencia;

import java.util.List;

public interface AgenciaRepository {
    void cadastrarAgencia(Agencia agencia);
    void alterarAgencia(Agencia agencia);
    Agencia buscarAgenciaPorParteDoNome(String parteNome);
    List<Agencia> listarAgencias();
}
