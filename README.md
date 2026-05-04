# 🚀 API de Usuários com Spring Boot

API REST desenvolvida em Java com Spring Boot, estruturada com base em boas práticas de arquitetura em camadas, validação de entrada e tratamento padronizado de erros.

O projeto evolui de forma incremental, consolidando conceitos essenciais de desenvolvimento backend moderno, com foco em organização, clareza de código e manutenibilidade.

---

## 📌 Status

🟡 Em desenvolvimento contínuo

Atualmente implementa um CRUD completo de usuários com persistência em banco H2, validação de dados e tratamento global de exceções.

---

## 🎯 Objetivo

Construir uma API REST robusta e bem estruturada, aplicando:

* separação de responsabilidades
* boas práticas do ecossistema Spring
* evolução incremental orientada a aprendizado e qualidade

---

## 🧠 O Que Este Projeto Demonstra

* Criação de APIs REST com Spring Boot
* Arquitetura em camadas (Controller, Service, Repository)
* Uso de DTOs para desacoplamento da entidade
* Validação de entrada com Bean Validation
* Tratamento global de erros com `@RestControllerAdvice`
* Persistência com Spring Data JPA
* Organização de código voltada à manutenção
* Testes básicos com JUnit

---

## 🏗️ Arquitetura

O projeto segue separação clara de responsabilidades:

* **Controller** → entrada HTTP e exposição dos endpoints
* **Service** → regras de negócio
* **Repository** → acesso a dados
* **DTOs** → comunicação entre camadas
* **Exception Handler** → padronização de erros

Essa abordagem facilita evolução, testes e manutenção.

---

## ⚙️ Tecnologias

* Java 17
* Spring Boot 3.5.13
* Spring Web
* Spring Data JPA
* Spring Validation
* H2 Database
* Lombok
* Maven
* JUnit / Spring Boot Test

---

## 🚀 Como Executar

### Executar com Maven

```bash
mvn spring-boot:run
```

### Ou com Maven Wrapper

```bash
./mvnw spring-boot:run
```

Aplicação disponível em:

```text
http://localhost:8080
```

---

## 🔗 Endpoints

### Listar usuários

```http
GET /usuarios
```

### Criar usuário

```http
POST /usuarios
```

### Buscar por ID

```http
GET /usuarios/{id}
```

### Atualizar usuário

```http
PUT /usuarios/{id}
```

### Remover usuário

```http
DELETE /usuarios/{id}
```

---

## 🧪 Testes

```bash
./mvnw test
```

Build completo:

```bash
./mvnw clean install
```

---

## 🗄️ Banco de Dados

O projeto utiliza H2 em memória para fins de desenvolvimento.

Acesso ao console:

```text
http://localhost:8080/h2-console
```

Configuração:

```text
JDBC URL: jdbc:h2:mem:apiusuarios
User: sa
Password: (vazio)
```

---

## ⚠️ Validação e Tratamento de Erros

* Validação com `@NotBlank`, `@Email`, `@Size`
* Respostas padronizadas via `@RestControllerAdvice`
* Retorno de erros com status `400 BAD REQUEST`

Exemplo:

```json
[
  {
    "campo": "email",
    "mensagem": "O email informado é inválido."
  }
]
```

---

## 📈 Roadmap

* [x] Estrutura inicial Spring Boot
* [x] Controllers REST
* [x] CRUD de usuários
* [x] Camada de service
* [x] Persistência com JPA
* [x] Validação de entrada
* [x] Tratamento global de erros
* [ ] Ampliação de testes automatizados
* [ ] Autenticação com JWT
* [ ] Integração com banco relacional (PostgreSQL)

---

## 💬 Autor

Desenvolvido por **Edbruno Prestes**
📧 [edbruno.prestes@gmail.com](mailto:edbruno.prestes@gmail.com)

Projeto focado na consolidação de práticas modernas de desenvolvimento backend com Spring Boot.
