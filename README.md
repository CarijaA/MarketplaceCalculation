📌 Marketplace Calculation API
📖 Descrição
A Marketplace Calculation API é um sistema desenvolvido em Spring Boot para calcular taxas e margens de lucro em vendas feitas em marketplaces.

🚀 Tecnologias Utilizadas
Java 17

Spring Boot 3.4.1

Spring Data JPA

MSSQL Server

H2 Database (para testes)

Lombok

Spring Boot Validation

⚙️ Configuração e Instalação

1️⃣ Clonando o repositório
```bash
git clone https://github.com/seu-usuario/MarketplaceCalculation.git
```
```bash
cd MarketplaceCalculation
```

2️⃣ Configurando o Banco de Dados

A API utiliza Microsoft SQL Server. No arquivo application.properties, substitua os valores pelos dados do seu ambiente local:

```bash
properties

spring.datasource.url=jdbc:sqlserver://SEU_SERVIDOR\\INSTANCIA:1433;databaseName=SEU_BANCO;trustServerCertificate=true;

spring.datasource.username=SEU_USUARIO

spring.datasource.password=SUA_SENHA
```

🔹 Se estiver usando outro banco de dados, ajuste a URL e o driver correspondente.

3️⃣ Instalando as dependências
```bash
mvn clean install
```


4️⃣ Executando o projeto
bash

Copiar

Editar

mvn spring-boot:run

A API será iniciada e estará acessível em:

👉 http://localhost:8080

📖 Endpoints

🔹 Calcular Taxas e Margens de Vendas

URL: /marketplaceCalculation

Método: POST

Exemplo de Requisição (JSON)
```json
{
  "marketplaceNome": "MERCADOLIVRE",
  "reputacao": 1,
  "tipoEnvio": 1,
  "regiao": 1,
  "custoProduto": 10,
  "precoVenda": 99,
  "promocaoVenda": 10,
  "marketplaceTaxa": 19.00,
  "notaFiscalTaxa": 5.00,
  "pesoProduto": 1
}

```
Exemplo de Resposta (JSON)
```json
{
"properties": 
  "marketplaceNome": "MERCADOLIVRE",
  "reputacao": 1,
  "tipoEnvio": 1,
  "regiao": 1,
  "precoVenda": 99.0,
  "promocaoVenda": 10.0,
  "precoVendaLiquida": 89.1,
  "custoProduto": 10.0,
  "taxaFixa": 0.0,
  "marketplaceTaxa": 19.0,
  "notaFiscalTaxa": 4.455,
  "valorFrete": 23.45,
  "sobraTotal": 32.19,
  "margemVenda": 36.13,
  "margemCusto": 321.95
}
```



🛠️ Estrutura do Projeto

graphql

Copiar

Editar

MarketplaceCalculation

│── src

│   ├── main

│   │   ├── java/com/example/MarketplaceCalculation

│   │   │   ├── Controller  # Controllers da API

│   │   │   ├── Domain

│   │   │   │   ├── Entity  # Entidades do banco de dados

│   │   │   │   ├── Dto  # Classes DTO para requisições e respostas

│   │   │   │   ├── Repository  # Interfaces JPA para comunicação com o banco

│   │   │   │   ├── Services  # Regras de negócio

│   │   │   ├── Application.java  # Classe principal da aplicação

│── pom.xml  # Dependências Maven

│── README.md  # Documentação do projeto


🛡️ Segurança
Atualmente, esta API não possui autenticação. Caso precise adicionar JWT, OAuth ou API Keys, será necessário implementar uma camada de segurança.


📌 Considerações Finais
Certifique-se de configurar corretamente o banco de dados antes de iniciar a aplicação.
Se necessário, altere a porta da API no application.properties (padrão: 8080).
Para sugestões ou dúvidas, sinta-se à vontade para abrir uma issue no repositório.
🚀 Agora é só rodar e testar! 🚀

