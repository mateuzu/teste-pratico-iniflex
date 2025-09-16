# Teste prático - Iniflex
>Solução desenvolvida para o teste técnico proposto pela Projectada, utilizando Java com foco em orientação a objetos e boas práticas de desenvolvimento.


## Objetivo do projeto
Desenvolver uma aplicação Java que gerencia uma lista de funcionários, realizando operações como:
- Inserção e remoção
- Agrupamento por função
- Cálculo de salários
- Ordenações
- Filtragens por aniversário e idade

## Estrutura do projeto
```bash
src/
└── org.mateuzu.teste/
    ├── Main.java                         # Classe principal que exibe o menu e interage com o serviço
    ├── model/
    │   ├── Pessoa.java                   # Classe base contendo nome e data de nascimento
    │   └── Funcionario.java              # Subclasse que adiciona salário e função
    ├── service/
    │   └── FuncionarioService.java      # Contém toda a lógica de negócio e manipulação dos funcionários
    └── utils/
        └── FormatadorMoeda.java              # Classe utilitária para formatar datas e valores monetários
```

## Funcionalidade implementadas
- ✅ Adição automática de funcionários com base em uma tabela fixa
- ✅ Remoção do funcionário "João"
- ✅ Impressão de todos os funcionários com:
    - Data no formato dd/MM/yyyy
    - Salário formatado com ponto para milhar e vírgula para decimal (ex: R$ 10.000,50)
- ✅ Aumento de salário em 10%
- ✅ Agrupamento de funcionários por função
- ✅ Impressão de funcionários por função
- ✅ Filtragem de aniversariantes dos meses 10 e 12
- ✅ Impressão do funcionário mais velho (nome e idade)
- ✅ Ordenação alfabética dos funcionários
- ✅ Cálculo e exibição do salário total
- ✅ Exibição de quantos salários mínimos cada funcionário recebe

## Como executar localmente
✅ Pré-requisitos
- Java 17 ou superior instalado
- IDE como IntelliJ IDEA, Eclipse ou VS Code (opcional)
- Maven (opcional, caso queira empacotar)

### Executando ⚙️
1. Clone o repositório:
```bash
git clone https://github.com/mateuzu/teste-pratico-iniflex.git
```
2. Compile e execute o projeto com sua IDE ou via terminal utilizando Maven:
```bash
mvn clean compile # na pasta raiz do projeto
mvn exec:java
```

## Autor
- Desenvolvido por `@mateuzu`
- [Linkedin](https://linkedin.com/in/mateus-ferreira-costa)