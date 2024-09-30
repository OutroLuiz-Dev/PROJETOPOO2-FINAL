# **Locadora de Veículos**
## **Descrição do Projeto**
O projeto consiste em uma aplicação que gerencia o aluguel de veículos. Os usuários poderão realizar diversas operações, incluindo o cadastro de veículos, agências, clientes e o gerenciamento das locações.
### **Itens Obrigatórios**
- Cadastrar os veículos.
- Alterar um veículo cadastrado.
- Buscar um veículo por parte do nome.
- Cadastrar a agência onde o veículo será alugado/devolvido.
- Alterar a agência onde o veículo será alugado/devolvido.
- Buscar uma agência por parte do nome ou do logradouro do endereço.
- Cadastrar o cliente (pessoa física/jurídica).
- Alterar o cliente (pessoa física/jurídica).
- Alugar um veículo para pessoa física.
- Alugar um veículo para pessoa jurídica.
- Devolver um veículo para pessoa física.
- Devolver um veículo para pessoa jurídica.
- Gerar um comprovante com todos os dados do aluguel (aberto para o grupo decidir o que vai ser demonstrado).
- Gerar um comprovante com todos os dados da devolução (aberto para o grupo decidir o que vai ser demonstrado).
### **Itens Bônus**
- Paginar as listas envolvidas.
- Dados sendo gravados em arquivos, simulando uma base de dados.
### **Regras de Negócio**
- **RN1:** Os veículos não podem ser repetidos.
- **RN2:** Tipos de veículos que serão considerados: Carro, Moto, Caminhões.
- **RN3:** Os aluguéis e devoluções terão o local, data e horário.
- **RN4:** Os veículos que estiverem alugados não poderão estar disponíveis.
- **RN5:** Agências não podem estar duplicadas.
- **RN6:** Clientes não podem estar duplicados.
- **RN7:** Regras de devolução:
  - Caso pessoa física tenha ficado com o carro mais que 5 dias, terá direito a 5% de desconto.
  - Caso pessoa jurídica tenha ficado com o carro mais que 3 dias, terá direito a 10% de desconto.
### **Valores Base da Diária por Tipo de Veículo**

|**Tipo de Veículo**|**Valor por dia**|
| :-: | :-: |
|Moto|R$ 100,00|
|Carro|R$ 150,00|
|Caminhão|R$ 200,00|

-----
## **Diagrama de Classes**
### **Estrutura do Projeto**
css

![](Aspose.Words.bed29ca0-d1e4-4f9d-8c63-a6de1e81d7ba.001.png)Copiar código

Projeto

│

├── idea

│

└── src

`    `└── main

`        `└── java

`            `└── com.locadora

`                `├── interfaces

`                `│   ├── IAgenciaService

`                `│   ├── IClienteService

`                `│   ├── ILocacao

`                `│   └── IVeiculo

`                `│

`                `├── models

`                `│   ├── AgenciaService

`                `│   ├── ClienteService

`                `│   ├── LocacaoService

`                `│   └── VeiculoService

`                `│

`                `└── utils

`                    `└── FirebaseUtil

`    `└── main

-----
Você pode baixar o diagrama das classes usando o link abaixo:

Baixar Diagrama de Classes
