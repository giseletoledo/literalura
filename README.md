# <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-plain.svg"  width="6%" /> LiterAlura

## Descrição
OBJETIVO: Desenvolver um Catálogo de Livros que ofereça interação textual (via console) com os usuários, proporcionando no mínimo 5 opções de interação.
Os livros serão buscados através de uma API específica.

## Funcionalidades
- Consumo da API;

- Análise da Resposta JSON;

- Inserção e consulta no banco de dados;

- Exibição de resultados aos usuários;

## Pré-requisitos
Java 21 - Java Development Kit (JDK): Certifique-se de ter o JDK instalado em seu sistema. Você pode baixar a versão mais recente do site oficial do Java.

Maven (opcional, se você não tiver o Maven instalado, siga as instruções abaixo para compilar e executar o projeto manualmente).
Clone o repositório.

Abra o projeto em sua IDE (como IntelliJ IDEA ou Eclipse).
Configure o arquivo application.properties ou application.yml para incluir as configurações do banco PostgreSQL.

## Dependências do Projeto

O projeto utiliza as seguintes dependências:

xml
```
<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-core</artifactId>
			<version>2.16.0</version>
		</dependency>
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-annotations</artifactId>
			<version>2.16.0</version> </dependency>
	</dependencies>
```
