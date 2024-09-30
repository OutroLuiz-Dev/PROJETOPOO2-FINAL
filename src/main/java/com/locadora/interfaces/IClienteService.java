package com.locadora.interfaces;

import com.locadora.models.Cliente;

public interface IClienteService {
    void cadastrarCliente(Cliente cliente);
    void alterarCliente(String id, Cliente cliente);
    void buscarCliente(String nome);
    void deletarCliente(String id);
}
