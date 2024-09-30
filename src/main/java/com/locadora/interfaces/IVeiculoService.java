package com.locadora.interfaces;

import com.locadora.models.Veiculo;

public interface IVeiculoService {
    void cadastrarVeiculo(Veiculo veiculo);
    void alterarVeiculo(String id, Veiculo veiculo);
    void buscarVeiculo(String nome);
    void deletarVeiculo(String id);
}
