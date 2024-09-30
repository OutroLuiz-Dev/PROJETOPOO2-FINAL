package com.locadora.service;

import com.google.firebase.database.*;
import com.locadora.interfaces.IVeiculoService;
import com.locadora.models.Veiculo;

public class VeiculoService implements IVeiculoService {

    private final DatabaseReference veiculoRef = FirebaseDatabase.getInstance().getReference("veiculos");

    @Override
    public void cadastrarVeiculo(Veiculo veiculo) {
        veiculoRef.child(veiculo.getId()).setValueAsync(veiculo);
        System.out.println("Veículo cadastrado com sucesso!");
    }

    @Override
    public void alterarVeiculo(String id, Veiculo veiculo) {
        veiculoRef.child(id).setValueAsync(veiculo);
        System.out.println("Veículo alterado com sucesso!");
    }

    @Override
    public void buscarVeiculo(String nome) {
        veiculoRef.orderByChild("nome").startAt(nome).endAt(nome + "\uf8ff").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Veiculo veiculo = snapshot.getValue(Veiculo.class);
                    if (veiculo != null) {
                        System.out.println("Veículo encontrado: " + veiculo.getNome() + " (" + veiculo.getId() + ")");
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("Erro ao buscar veículo: " + databaseError.getMessage());
            }
        });
    }

    @Override
    public void deletarVeiculo(String id) {
        veiculoRef.child(id).removeValueAsync();
        System.out.println("Veículo deletado com sucesso!");
    }
}
