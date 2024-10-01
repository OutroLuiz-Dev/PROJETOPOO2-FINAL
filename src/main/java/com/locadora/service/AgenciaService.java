package com.locadora.service;

import com.google.firebase.database.*;
import com.locadora.interfaces.IAgenciaService;
import com.locadora.models.Agencia;

import java.util.ArrayList;
import java.util.List;

public class AgenciaService implements IAgenciaService {

    private final DatabaseReference agenciaRef = FirebaseDatabase.getInstance().getReference("agencias");

    @Override
    public void cadastrarAgencia(Agencia agencia) {
        agencia.setNome(agencia.getNome().toLowerCase());
        agenciaRef.child(agencia.getId()).setValueAsync(agencia);
        System.out.println("Agência cadastrada com sucesso!");
    }


    @Override
    public void alterarAgencia(String id, Agencia agencia) {
        agenciaRef.child(id).setValueAsync(agencia);
        System.out.println("Agência alterada com sucesso!");
    }

    @Override
    public void buscarAgencia(String nome) {
        agenciaRef.orderByChild("nome").startAt(nome.toLowerCase()).endAt(nome.toLowerCase()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Agencia agencia = snapshot.getValue(Agencia.class);
                    if (agencia != null) {
                        System.out.println("Agência encontrada: " + agencia.getNome() + " (" + agencia.getId() + ")");
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("Erro ao buscar agência: " + databaseError.getMessage());
            }
        });
    }

    @Override
    public void deletarAgencia(String id) {
        agenciaRef.child(id).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // Se a agência existir, remover
                    agenciaRef.child(id).removeValueAsync();
                    System.out.println("Agência deletada com sucesso!");
                } else {
                    // Se não existir, exibir mensagem de erro
                    System.out.println("Agência não encontrada!");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("Erro ao tentar deletar agência: " + databaseError.getMessage());
            }
        });
    }
}

