package com.locadora.repository;

import com.locadora.models.Cliente;

import java.util.List;

public interface ClienteRepository {
    void cadastrarCliente(Cliente cliente);
    void alterarCliente(Cliente cliente);
    List<Cliente> listarClientes();
}
