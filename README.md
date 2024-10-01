# Gerenciamento de Aluguel de Veículos

Trabalho do GRUPO 3 - SANTANDERCODERS 2024 - AULA: POO 2

Este projeto é uma aplicação para gerenciar o aluguel de veículos, permitindo o cadastro de veículos, agências, clientes e o gerenciamento das locações. A aplicação oferece funcionalidades robustas para administrar o processo de locação de forma eficiente, incluindo regras de negócio para veículos, agências e clientes.

## Funcionalidades Principais

1. **Cadastro de Veículos**   - Cadastrar, alterar e buscar veículos por parte do nome.   
2. **Gerenciamento de Agências**   - Cadastrar, alterar e buscar agências por parte do nome ou logradouro do endereço.
3. **Cadastro de Clientes**   - Cadastrar e alterar clientes, diferenciando entre pessoa física e jurídica.
4. **Aluguel e Devolução de Veículos**   - Alugar veículos para pessoa física e jurídica.   - Gerar comprovantes com detalhes do aluguel e devolução.

## Regras de Negócio

- **RN1**: Veículos não podem ser repetidos.
- **RN2**: Os tipos de veículos considerados são Carro, Moto e Caminhão.
- **RN3**: Aluguéis e devoluções devem incluir local, data e horário.
- **RN4**: Veículos alugados não podem estar disponíveis para novos aluguéis.
- **RN5**: Agências não podem ser duplicadas.
- **RN6**: Clientes não podem ser duplicados.
- **RN7**: Regras de devolução:
  - Pessoa física tem direito a **5% de desconto** se o aluguel for superior a 5 dias.
  - Pessoa jurídica tem direito a **10% de desconto** se o aluguel for superior a 3 dias.

## Valores Base por Tipo de Veículo

| Tipo de Veículo | Valor por Dia |
|-----------------|---------------|
| Moto            | R$ 100,00     |
| Carro           | R$ 150,00     |
| Caminhão        | R$ 200,00     |

## Itens Bônus

- Paginação das listas envolvidas.
- Gravação dos dados em arquivos, simulando uma base de dados.

## Estrutura do Projeto

```bash
Projeto
│
├── idea
│
└── src
    └── main
        └── java
            └── com.locadora
                ├── interfaces
                │   ├── IAgenciaService
                │   ├── IClienteService
                │   ├── ILocacao
                │   └── IVeiculo
                ├── models
                │   ├── AgenciaService
                │   ├── ClienteService
                │   ├── LocacaoService
                │   └── VeiculoService
                └── utils
                    └── FirebaseUtil
