# Padrão Integração: Chain of Responsibility + Strategy + Template Method

## Objetivo
Sistema de reembolso de despesas, baseado no exemplo enviado.

## Funcionamento
1. Template Method define a elegibilidade por contrato; 2. Chain of Responsibility solicita aprovação a Supervisor, Gerente ou Diretor; 3. Strategy calcula o pagamento por Pix, transferência ou cartão. Sem elegibilidade ou aprovação, o pagamento não acontece.

## Tecnologias
- Java 11 ou superior
- Maven
- JUnit 5

## Estrutura
```text
integracaoChainStrategyTemplateMethod/
├── pom.xml
├── README.md
├── docs/
│   └── diagrama.png
└── src/
    ├── main/java/sistemaReembolsoDespesas/ (classes + Main.java)
    └── test/java/sistemaReembolsoDespesas/ (testes JUnit)
```

## Como executar no terminal
No diretório do projeto, execute:
```bash
mvn clean test
mvn compile exec:java
```

Também é possível abrir diretamente o `pom.xml` no IntelliJ IDEA ou Eclipse e executar a classe `sistemaReembolsoDespesas.Main`.

## Exemplo
Execute `Main.java` para ver o padrão em funcionamento.
A pasta `docs/` contém um diagrama ilustrativo das classes e/ou do fluxo.
