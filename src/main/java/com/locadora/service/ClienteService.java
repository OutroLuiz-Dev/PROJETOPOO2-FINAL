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
        clienteRef.orderByChild("nome").startAt(nome).endAt(nome + "\uf8ff").addListenerForSingleValueEvent(new ValueEventListener() {
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

    @Override
    public void deletarCliente(String id) {
        clienteRef.child(id).removeValueAsync();
        System.out.println("Cliente deletado com sucesso!");
    }
}
