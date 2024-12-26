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
- Java 21 - Java Development Kit (JDK): Certifique-se de ter o JDK instalado em seu sistema. Você pode baixar a versão mais recente do site oficial do Java.

- Maven (opcional, se você não tiver o Maven instalado, siga as instruções abaixo para compilar e executar o projeto manualmente).
Clone o repositório.

- PostgreSQL 12 ou superior

- Abra o projeto em sua IDE (como IntelliJ IDEA ou Eclipse).
Configure o arquivo application.properties ou application.yml para incluir as configurações do banco PostgreSQL.

## Passos para Usar o Menu
1. Buscar e Salvar Livros da API
2. Listar Livros Registrados
3. Listar Livros por Idioma

## Passo 1: Buscar e Salvar Livros da API

Insira o termo de busca: Dom Casmurro

Escolha o número de sua opção:
1. Buscar livro pelo título
2. Listar Livros registrados
3. Listar Autores registrados
4. Listar autores vivos em um determinado ano
5. Listar Livros em um determinado idioma
6. Buscar e salvar livros da API
0. Sair
   
6
   
Insira o termo de busca: Dom Casmurro
Livros salvos com sucesso!

## Passo 2: Listar Livros Registrados

Escolha o número de sua opção:
1. Buscar livro pelo título
2. Listar Livros registrados
3. Listar Autores registrados
4. Listar autores vivos em um determinado ano
5. Listar Livros em um determinado idioma
6. Buscar e salvar livros da API
0. Sair
   
2
   
ID: 1, Título: Dom Casmurro, Idioma: pt

## Passo 3: Listar Livros por Idioma

### Listar livros em português

Escolha o número de sua opção:
1. Buscar livro pelo título
2. Listar Livros registrados
3. Listar Autores registrados
4. Listar autores vivos em um determinado ano
5. Listar Livros em um determinado idioma
6. Buscar e salvar livros da API
0. Sair
   
5
   
Insira o idioma (es, en, fr, pt): pt

ID: 1, Título: Dom Casmurro, Idioma: pt

## Listar livros em inglês

Escolha o número de sua opção:
1. Buscar livro pelo título
2. Listar Livros registrados
3. Listar Autores registrados
4. Listar autores vivos em um determinado ano
5. Listar Livros em um determinado idioma
6. Buscar e salvar livros da API
0. Sair
   
5
   
Insira o idioma (es, en, fr, pt): en
   
Nenhum livro encontrado no idioma: en

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
