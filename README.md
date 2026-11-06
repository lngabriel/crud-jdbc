# Cadastro de Clientes com JDBC

Aplicação de console em Java que faz o cadastro e a busca de clientes em um banco PostgreSQL, usando **JDBC puro**. Projeto de estudo para consolidar os fundamentos de acesso a banco de dados antes de migrar para Spring Boot.

## Funcionalidades

- [x] Cadastrar cliente (nome e e-mail)
- [x] Buscar cliente por ID
- [x] Atualizar cliente
- [x] Deletar cliente
- [x] Listar clientes

## Tecnologias

- Java (JDK 25 ou superior, pelo uso de `void main()` e `IO`)
- PostgreSQL
- JDBC (driver `org.postgresql:postgresql`)
- Maven

## Conceitos praticados

- Conexão com banco via `DriverManager`
- `PreparedStatement` com parâmetros (prevenção de SQL injection)
- `ResultSet` para leitura de resultados
- `try-with-resources` para fechar recursos
- Singleton para a conexão com o banco
- Separação em camadas simples (conexão, serviço, interface de console)
- Credenciais fora do código, em arquivo de configuração ignorado pelo Git

## Estrutura

```
src/main/java/
├── Main.java                  # Menu de console
├── Cliente.java               # Modelo de cliente
├── ClienteService.java        # Operações de banco para clientes
└── connection/
    └── ConexaoBD.java         # Conexão com o PostgreSQL (Singleton)
```

## Como rodar

### 1. Pré-requisitos

- JDK instalado
- PostgreSQL rodando localmente
- Maven

### 2. Criar o banco e a tabela

No `psql`:

```sql
CREATE DATABASE pizzaria;

\c pizzaria

CREATE TABLE clientes (
    id    SERIAL PRIMARY KEY,
    nome  VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL
);
```

### 3. Configurar a conexão

Copie o arquivo de exemplo e preencha com seus dados:

```bash
cp config.example.properties config.properties
```

```properties
db.url=jdbc:postgresql://localhost:5432/pizzaria
db.user=postgres
db.password=sua_senha
```

O `config.properties` está no `.gitignore` e **não deve ser commitado**.

### 4. Executar

Rode a classe `Main` pela IDE (a partir da raiz do projeto, para que o `config.properties` seja encontrado) ou compile com Maven:

```bash
mvn compile
```

## Exemplo de uso

```
1 - Cadastrar cliente
2 - Buscar por ID
3 - Atualizar cliente
4 - Deletar cliente
5 - Listar clientes
6 - Sair
Opção: 1
Nome: Gabriel
Email: gabriel@email.com
Cliente cadastrado!
```