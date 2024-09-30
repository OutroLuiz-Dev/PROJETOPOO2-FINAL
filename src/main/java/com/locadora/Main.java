package com.locadora;

import com.locadora.models.*;
import com.locadora.service.AgenciaService;
import com.locadora.service.ClienteService;
import com.locadora.service.VeiculoService;
import com.locadora.utils.FirebaseUtil;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        FirebaseUtil.initFirebase();  // Inicializa o Firebase
        Scanner scanner = new Scanner(System.in);
        int opcao;

        VeiculoService veiculoService = new VeiculoService();
        AgenciaService agenciaService = new AgenciaService();
        ClienteService clienteService = new ClienteService();

        do {
            System.out.println("1. Cadastrar Veículo");
            System.out.println("2. Alterar Veículo");
            System.out.println("3. Buscar Veículo");
            System.out.println("4. Deletar Veículo");
            System.out.println("5. Cadastrar Agência");
            System.out.println("6. Alterar Agência");
            System.out.println("7. Buscar Agência");
            System.out.println("8. Deletar Agência");
            System.out.println("9. Cadastrar Cliente");
            System.out.println("10. Alterar Cliente");
            System.out.println("11. Buscar Cliente");
            System.out.println("12. Deletar Cliente");
            System.out.println("0. Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.println("Digite o ID do Veículo: ");
                    String idVeiculo = scanner.nextLine();
                    System.out.println("Digite o tipo de Veículo: ");
                    String tipoVeiculo = scanner.nextLine();
                    System.out.println("Digite o nome do Veículo: ");
                    String nomeVeiculo = scanner.nextLine();
                    Veiculo veiculo = new Veiculo(idVeiculo, tipoVeiculo, nomeVeiculo, true);
                    veiculoService.cadastrarVeiculo(veiculo);
                    break;

                case 2:
                    System.out.println("Digite o ID do Veículo que deseja alterar: ");
                    String idAlterarVeiculo = scanner.nextLine();
                    System.out.println("Digite o novo tipo de Veículo: ");
                    String novoTipoVeiculo = scanner.nextLine();
                    System.out.println("Digite o novo nome do Veículo: ");
                    String novoNomeVeiculo = scanner.nextLine();
                    Veiculo veiculoAlterado = new Veiculo(idAlterarVeiculo, novoTipoVeiculo, novoNomeVeiculo, true);
                    veiculoService.alterarVeiculo(idAlterarVeiculo, veiculoAlterado);
                    break;

                case 3:
                    System.out.println("Digite parte do nome do Veículo para buscar: ");
                    String parteNomeVeiculo = scanner.nextLine();
                    veiculoService.buscarVeiculo(parteNomeVeiculo);
                    break;

                case 4:
                    System.out.println("Digite o ID do Veículo para deletar: ");
                    String idDeletarVeiculo = scanner.nextLine();
                    veiculoService.deletarVeiculo(idDeletarVeiculo);
                    break;

                case 5:
                    System.out.println("Digite o ID da Agência: ");
                    String idAgencia = scanner.nextLine();
                    System.out.println("Digite o nome da Agência: ");
                    String nomeAgencia = scanner.nextLine();
                    System.out.println("Digite o endereço da Agência: ");
                    String enderecoAgencia = scanner.nextLine();
                    Agencia agencia = new Agencia(idAgencia, nomeAgencia, enderecoAgencia);
                    agenciaService.cadastrarAgencia(agencia);
                    break;

                case 6:
                    System.out.println("Digite o ID da Agência que deseja alterar: ");
                    String idAlterarAgencia = scanner.nextLine();
                    System.out.println("Digite o novo nome da Agência: ");
                    String novoNomeAgencia = scanner.nextLine();
                    System.out.println("Digite o novo endereço da Agência: ");
                    String novoEnderecoAgencia = scanner.nextLine();
                    Agencia agenciaAlterada = new Agencia(idAlterarAgencia, novoNomeAgencia, novoEnderecoAgencia);
                    agenciaService.alterarAgencia(idAlterarAgencia, agenciaAlterada);
                    break;

                case 7:
                    System.out.println("Digite parte do nome ou logradouro da Agência para buscar: ");
                    String parteNomeAgencia = scanner.nextLine();
                    agenciaService.buscarAgencia(parteNomeAgencia);
                    break;

                case 8:
                    System.out.println("Digite o ID da Agência para deletar: ");
                    String idDeletarAgencia = scanner.nextLine();
                    agenciaService.deletarAgencia(idDeletarAgencia);
                    break;

                case 9:
                    System.out.println("Digite o ID do Cliente: ");
                    String idCliente = scanner.nextLine();
                    System.out.println("Digite o nome do Cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.println("Digite o tipo do Cliente (Pessoa Física/Jurídica): ");
                    String tipoCliente = scanner.nextLine();
                    Cliente cliente = new Cliente(idCliente, nomeCliente, tipoCliente);
                    clienteService.cadastrarCliente(cliente);
                    break;

                case 10:
                    System.out.println("Digite o ID do Cliente que deseja alterar: ");
                    String idAlterarCliente = scanner.nextLine();
                    System.out.println("Digite o novo nome do Cliente: ");
                    String novoNomeCliente = scanner.nextLine();
                    System.out.println("Digite o novo tipo do Cliente: ");
                    String novoTipoCliente = scanner.nextLine();
                    Cliente clienteAlterado = new Cliente(idAlterarCliente, novoNomeCliente, novoTipoCliente);
                    clienteService.alterarCliente(idAlterarCliente, clienteAlterado);
                    break;

                case 11:
                    System.out.println("Digite parte do nome do Cliente para buscar: ");
                    String parteNomeCliente = scanner.nextLine();
                    clienteService.buscarCliente(parteNomeCliente);
                    break;

                case 12:
                    System.out.println("Digite o ID do Cliente para deletar: ");
                    String idDeletarCliente = scanner.nextLine();
                    clienteService.deletarCliente(idDeletarCliente);
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
