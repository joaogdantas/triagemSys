# TriagemSys Backend

O **TriagemSys Backend** é um projeto de uma ideia de uma arquitetura de sistemas para sistemas de anamnese e atendimento prévio em hospitais.

#### Tecnologias necessárias
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Postgres](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)

## Funcionalidades

- **Criação, Retorno, Edição e Remoção de dados de Pacientes:**
- **Criação, Retorno, Edição e Remoção de dados de Atendimentos:**
- **Autenticação de usuários (cadastro e login):**

## Documentação
Importe o arquivo TriagemSysRotas no Insomnnia para checar a documentação das rotas possíveis, com exceção das rotas de login e cadastro, todas as outras necessitam do usuário estar logado no sistema.

## Configuração do Banco de Dados

Antes de executar o projeto, é necessário configurar o banco de dados no arquivo application.properties. Certifique-se de ajustar as configurações de acordo com o seu ambiente:

```
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/picpaybackend
spring.datasource.username=postgres
spring.datasource.password=admin
spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

spring.flyway.baselineOnMigrate=true

spring.mvc.pathmatch.matching-strategy=ant_path_matcher
```

## Como Executar o Projeto

- Clonar o Repositório:

```git clone https://github.com/joaogdantas/triagemSys```

- Instalar Dependências:

```mvn clean install```

- Executar a Aplicação:

```mvn spring-boot:run```

- Testes: Para rodar os testes, use:

```mvn test```

## Contribuição
Este projeto foi desenvolvido tem como base um teste técnico real e pode conter áreas que podem ser melhoradas ou otimizadas. Sinta-se à vontade para explorar, modificar e contribuir. Busco sempre evoluir como desenvolvedor e ouvir outras opiniões e ideias.