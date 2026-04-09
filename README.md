# API Usuarios

API REST em desenvolvimento com Java e Spring Boot.

Este projeto nasceu como um estudo pratico de backend, mas esta sendo organizado com cuidado para evoluir como projeto de portfolio: codigo simples, endpoints claros, documentacao objetiva e crescimento por etapas.

## Status

Em desenvolvimento.

No momento, a API possui endpoints simples para validar o funcionamento do Spring Boot e praticar os primeiros conceitos de controllers REST.
Tambem possui um primeiro controller de usuarios com cadastro temporario em memoria.

## Objetivo do Projeto

Construir, passo a passo, uma API para usuarios usando o ecossistema Spring.

A evolucao planejada inclui cadastro, consulta, atualizacao e remocao de usuarios, mantendo separacao entre controller, service, repository, DTOs e tratamento de erros.

## Tecnologias

- Java 17
- Spring Boot 3.5.13
- Spring Web
- Spring Boot DevTools
- Maven
- JUnit / Spring Boot Test

## O Que Este Projeto Demonstra

- Criacao de uma aplicacao Spring Boot
- Criacao de controllers REST
- Mapeamento de endpoints com `@GetMapping`
- Organizacao inicial de uma API Java
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
    |   |       +-- UsuarioController.java
    |   |   +-- model/
    |   |       +-- Usuario.java
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

Resposta inicial:

```json
[]
```

### Criar usuario em memoria

```http
POST /usuarios
Content-Type: application/json
```

Exemplo de corpo da requisicao:

```json
{
  "id": 1,
  "nome": "Edbruno",
  "email": "edbruno@email.com"
}
```

Resposta atual:

```text
Usuário criado com sucesso
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

## Observacao Sobre Desenvolvimento

O projeto usa `spring-boot-devtools`.

Essa dependencia ajuda durante o desenvolvimento porque pode reiniciar a aplicacao quando o codigo muda.

Se a aplicacao estiver rodando e uma alteracao nao aparecer no navegador, salve o arquivo e garanta que a IDE compilou o projeto novamente.

## Roadmap

- [x] Criar projeto Spring Boot
- [x] Criar primeiro controller REST
- [x] Criar endpoints simples de estudo
- [x] Criar controller de usuarios
- [x] Criar modelo de usuario
- [x] Criar cadastro temporario em memoria
- [ ] Criar service de usuarios
- [ ] Criar repository de usuarios
- [ ] Configurar persistencia
- [ ] Implementar CRUD de usuarios
- [ ] Adicionar validacoes de entrada
- [ ] Padronizar respostas de erro
- [ ] Ampliar testes automatizados

## Nota

Este README sera atualizado conforme o projeto evoluir.

O objetivo e manter a documentacao alinhada ao comportamento real do codigo.
