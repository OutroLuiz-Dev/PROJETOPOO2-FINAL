package com.locadora.repository;

import com.locadora.models.Veiculo;

import java.util.List;

public interface VeiculoRepository {
    void cadastrarVeiculo(Veiculo veiculo);
    void alterarVeiculo(Veiculo veiculo);
    Veiculo buscarVeiculoPorParteDoNome(String parteNome);
    List<Veiculo> listarVeiculos();
}
