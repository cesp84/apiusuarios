# API Usuarios

API REST em desenvolvimento com Java e Spring Boot.

Este projeto nasceu como um estudo pratico de backend, mas esta sendo organizado com cuidado para evoluir como projeto de portfolio: codigo simples, endpoints claros, documentacao objetiva e crescimento por etapas.

## Status

Em desenvolvimento.

No momento, a API possui endpoints simples para validar o funcionamento do Spring Boot e praticar os primeiros conceitos de controllers REST.
Tambem possui um CRUD inicial de usuarios com H2 em memoria, DTOs, validacao de entrada e tratamento global de erros.

## Objetivo do Projeto

Construir, passo a passo, uma API para usuarios usando o ecossistema Spring.

A evolucao planejada inclui cadastro, consulta, atualizacao e remocao de usuarios, mantendo separacao entre controller, service, repository, DTOs e tratamento de erros.

## Tecnologias

- Java 17
- Spring Boot 3.5.13
- Spring Web
- Spring Data JPA
- Spring Validation
- H2 Database
- Spring Boot DevTools
- Lombok
- Maven
- JUnit / Spring Boot Test

## O Que Este Projeto Demonstra

- Criacao de uma aplicacao Spring Boot
- Criacao de controllers REST
- Mapeamento de endpoints com `@GetMapping`
- Separacao entre controller, service, repository e DTOs
- Validacao de entrada com `@Valid`, `@NotBlank`, `@Email` e `@Size`
- Tratamento global de erro com `@RestControllerAdvice`
- Persistencia em banco H2
- Uso do Maven para executar e testar o projeto
- Documentacao progressiva enquanto o projeto evolui

## Estrutura Atual

```text
apiusuarios/
+-- pom.xml
+-- README.md
+-- src/
    +-- main/
    |   +-- java/br/com/edbruno/apiusuarios/
    |   |   +-- ApiusuariosApplication.java
    |   |   +-- controller/
    |   |       +-- HelloController.java
    |   |       +-- GlobalExceptionHandler.java
    |   |       +-- UsuarioController.java
    |   |   +-- dto/
    |   |       +-- ErroValidacaoDTO.java
    |   |       +-- UsuarioRequestDTO.java
    |   |       +-- UsuarioResponseDTO.java
    |   |   +-- model/
    |   |       +-- Usuario.java
    |   |   +-- repository/
    |   |       +-- UsuarioRepository.java
    |   |   +-- service/
    |   |       +-- UsuarioService.java
    |   +-- resources/
    |       +-- application.properties
    +-- test/
        +-- java/br/com/edbruno/apiusuarios/
            +-- ApiusuariosApplicationTests.java
```

## Como Executar

Com Maven instalado:

```bash
mvn spring-boot:run
```

Ou usando o Maven Wrapper do projeto:

```bash
./mvnw spring-boot:run
```

Por padrao, a aplicacao sobe em:

```text
http://localhost:8080
```

## Endpoints Atuais

### Listar usuarios

```http
GET /usuarios
```

Resposta quando houver usuarios:

```json
[
  {
    "id": 1,
    "nome": "Edbruno",
    "email": "edbruno@email.com"
  }
]
```

### Criar usuario

```http
POST /usuarios
Content-Type: application/json
```

Exemplo de corpo da requisicao:

```json
{
  "nome": "Edbruno",
  "email": "edbruno@email.com",
  "senha": "123456"
}
```

Resposta atual:

```json
{
  "id": 1,
  "nome": "Edbruno",
  "email": "edbruno@email.com"
}
```

### Buscar usuario por id

```http
GET /usuarios/1
```

Resposta quando encontrar:

```json
{
  "id": 1,
  "nome": "Edbruno",
  "email": "edbruno@email.com"
}
```

### Atualizar usuario

```http
PUT /usuarios/1
Content-Type: application/json
```

Exemplo de corpo da requisicao:

```json
{
  "nome": "Edbruno Silva",
  "email": "edbruno.silva@email.com",
  "senha": "12345678"
}
```

Resposta atual:

```json
{
  "id": 1,
  "nome": "Edbruno Silva",
  "email": "edbruno.silva@email.com"
}
```

### Remover usuario

```http
DELETE /usuarios/1
```

Resposta atual:

```text
204 No Content
```

### Verificar resposta do Spring Boot

```http
GET /hello
```

Resposta atual:

```text
Olá, Spring Boot!
```

### Exemplo retornando um nome

```http
GET /nome
```

Resposta atual:

```text
Edbruno
```

### Exemplo retornando uma mensagem

```http
GET /mensagem
```

Resposta atual:

```text
Estou aprendendo Spring Boot
```

## Como Testar

Execute:

```bash
./mvnw test
```

Para fazer uma verificacao completa, especialmente depois de alterar dependencias:

```bash
./mvnw clean install
```

## Banco H2

O projeto usa H2 em memoria para estudo.

Console do H2:

```text
http://localhost:8080/h2-console
```

Dados de conexao:

```text
JDBC URL: jdbc:h2:mem:apiusuarios
User: sa
Password: deixar vazio
```

Observacao:

- por estar em memoria, os dados somem quando a aplicacao reinicia

## Validacao e Erros

O projeto valida o `UsuarioRequestDTO` com:

- `@NotBlank`
- `@Email`
- `@Size`

Quando a validacao falha:

- o Spring bloqueia a requisicao
- o `GlobalExceptionHandler` captura o erro
- a API devolve `400 BAD REQUEST`

Exemplo de resposta:

```json
[
  {
    "campo": "email",
    "mensagem": "O email informado é inválido."
  }
]
```

## Observacao Sobre Desenvolvimento

O projeto usa `spring-boot-devtools`.

Essa dependencia ajuda durante o desenvolvimento porque pode reiniciar a aplicacao quando o codigo muda.

Se a aplicacao estiver rodando e uma alteracao nao aparecer no navegador, salve o arquivo e garanta que a IDE compilou o projeto novamente.

## Lombok

O projeto usa Lombok no modelo `Usuario` para reduzir codigo repetitivo.

Atualmente ele gera getters, setters, construtor vazio e construtor com todos os atributos.

O Lombok nao substitui o Jackson: ele apenas gera metodos e construtores que ajudam o objeto Java a continuar funcionando normalmente.

Para estudar/editar no VS Code, instale a extensao `Lombok Annotations Support for VS Code`.

## Roadmap

- [x] Criar projeto Spring Boot
- [x] Criar primeiro controller REST
- [x] Criar endpoints simples de estudo
- [x] Criar controller de usuarios
- [x] Criar modelo de usuario
- [x] Criar cadastro inicial de usuarios
- [x] Criar listagem de usuarios
- [x] Criar busca por id
- [x] Criar atualizacao
- [x] Criar remocao
- [x] Criar service inicial de usuarios
- [x] Mover regras iniciais do controller para o service
- [x] Criar repository de usuarios
- [x] Configurar persistencia
- [x] Implementar CRUD de usuarios
- [x] Adicionar validacoes de entrada
- [x] Padronizar respostas de erro
- [ ] Ampliar testes automatizados

## Nota

Este README sera atualizado conforme o projeto evoluir.

O objetivo e manter a documentacao alinhada ao comportamento real do codigo.
