package com.locadora.service;

import com.google.firebase.database.*;
import com.locadora.interfaces.IClienteService;
import com.locadora.models.Cliente;

public class ClienteService implements IClienteService {

    private final DatabaseReference clienteRef = FirebaseDatabase.getInstance().getReference("clientes");

    @Override
    public void cadastrarCliente(Cliente cliente) {
        clienteRef.child(cliente.getId()).setValueAsync(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    @Override
    public void alterarCliente(String id, Cliente cliente) {
        clienteRef.child(id).setValueAsync(cliente);
        System.out.println("Cliente alterado com sucesso!");
    }

    @Override
    public void buscarCliente(String nome) {
        clienteRef.orderByChild("nome").startAt(nome.toLowerCase()).endAt(nome.toLowerCase()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Cliente cliente = snapshot.getValue(Cliente.class);
                    if (cliente != null) {
                        System.out.println("Cliente encontrado: " + cliente.getNome() + " (" + cliente.getId() + ")");
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("Erro ao buscar cliente: " + databaseError.getMessage());
            }
        });
    }

//    @Override
//    public void deletarCliente(String id) {
//        clienteRef.child(id).removeValueAsync();
//        System.out.println("Cliente deletado com sucesso!");
//    }

    public void deletarCliente(String id) {
        clienteRef.child(id).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // Se a agência existir, remover
                    clienteRef.child(id).removeValueAsync();
                    System.out.println("Cliente deletado com sucesso!");
                } else {
                    // Se não existir, exibir mensagem de erro
                    System.out.println("Cliente não encontrada!");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("Erro ao tentar deletar cliente: " + databaseError.getMessage());
            }
        });
    }
}
