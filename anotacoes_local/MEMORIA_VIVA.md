# Memoria Viva - apiusuarios

## Objetivo

Memoria local do projeto `apiusuarios`.

Use este arquivo para registrar contexto real, decisoes tecnicas, comportamento validado e pontos de atencao conforme o projeto evoluir.

## Snapshot atual

- Data e hora do snapshot: 2026-04-17 13:28:52 -03
- Projeto: `apiusuarios`
- Tipo: API Java com Spring Boot
- Build: Maven Wrapper
- Java configurado: 17
- Spring Boot: 3.5.13
- Aplicacao Spring: `br.com.edbruno.apiusuarios.ApiusuariosApplication`
- Nome configurado: `spring.application.name=apiusuarios`

## Dependencias principais

- `spring-boot-starter-web`
- `spring-boot-devtools`
- `lombok`
- `spring-boot-starter-data-jpa`
- `h2`
- `spring-boot-starter-security`
- `jjwt-api`
- `jjwt-impl`
- `jjwt-jackson`
- `spring-boot-starter-validation`
- `spring-boot-starter-test`

## Estrutura observada

```text
README.md
src/main/java/br/com/edbruno/apiusuarios/ApiusuariosApplication.java
src/main/java/br/com/edbruno/apiusuarios/config/SecurityConfig.java
src/main/java/br/com/edbruno/apiusuarios/controller/AuthController.java
src/main/java/br/com/edbruno/apiusuarios/controller/HelloController.java
src/main/java/br/com/edbruno/apiusuarios/controller/GlobalExceptionHandler.java
src/main/java/br/com/edbruno/apiusuarios/controller/UsuarioController.java
src/main/java/br/com/edbruno/apiusuarios/dto/ErroValidacaoDTO.java
src/main/java/br/com/edbruno/apiusuarios/dto/LoginRequestDTO.java
src/main/java/br/com/edbruno/apiusuarios/dto/LoginResponseDTO.java
src/main/java/br/com/edbruno/apiusuarios/dto/UsuarioRequestDTO.java
src/main/java/br/com/edbruno/apiusuarios/dto/UsuarioResponseDTO.java
src/main/java/br/com/edbruno/apiusuarios/model/Usuario.java
src/main/java/br/com/edbruno/apiusuarios/repository/UsuarioRepository.java
src/main/java/br/com/edbruno/apiusuarios/security/JwtAuthenticationFilter.java
src/main/java/br/com/edbruno/apiusuarios/service/AuthService.java
src/main/java/br/com/edbruno/apiusuarios/service/CustomUserDetailsService.java
src/main/java/br/com/edbruno/apiusuarios/service/JwtService.java
src/main/java/br/com/edbruno/apiusuarios/service/UsuarioService.java
src/main/java/br/com/edbruno/apiusuarios/util/GerarChave.java
src/main/resources/application.properties
src/test/java/br/com/edbruno/apiusuarios/ApiusuariosApplicationTests.java
pom.xml
```

## Comportamento atual

- A aplicacao sobe por `SpringApplication.run(ApiusuariosApplication.class, args)`.
- Existe um controller simples: `HelloController`.
- Endpoint atual de estudo: `GET /hello` retorna `Olá, Spring Boot!`.
- Endpoint atual de estudo: `GET /nome` retorna `Edbruno`.
- Endpoint atual de estudo: `GET /mensagem` retorna `Estou aprendendo Spring Boot`.
- Existe um controller de usuarios: `UsuarioController`.
- Existe um controller de autenticacao: `AuthController`.
- Existe uma configuracao de seguranca: `SecurityConfig`.
- Existe um service inicial de usuarios: `UsuarioService`.
- Existe um service de autenticacao: `AuthService`.
- Existe um service JWT: `JwtService`.
- Existe um service que carrega usuario para o Spring Security: `CustomUserDetailsService`.
- Existe um repository inicial de usuarios: `UsuarioRepository`.
- Existem DTOs iniciais de usuarios: `UsuarioRequestDTO` e `UsuarioResponseDTO`.
- Existem DTOs de login: `LoginRequestDTO` e `LoginResponseDTO`.
- Existe um DTO de erro de validacao: `ErroValidacaoDTO`.
- Existe um handler global de erro: `GlobalExceptionHandler`.
- Existe um filtro JWT: `JwtAuthenticationFilter`.
- Existe um utilitario para gerar chave secreta JWT: `GerarChave`.
- `UsuarioRequestDTO` agora possui validacoes com `@NotBlank`, `@Email` e `@Size`.
- Endpoint atual de estudo: `GET /usuarios` retorna uma lista de `UsuarioResponseDTO`.
- Endpoint atual de estudo: `GET /usuarios/{id}` retorna `200 OK` com `UsuarioResponseDTO` ou `404 NOT FOUND`.
- Endpoint atual de estudo: `POST /usuarios` recebe `UsuarioRequestDTO`, salva e retorna `201 CREATED` com `UsuarioResponseDTO`.
- Endpoint atual de estudo: `PUT /usuarios/{id}` recebe `UsuarioRequestDTO`, atualiza nome/email e retorna `200 OK` ou `404 NOT FOUND`.
- Endpoint atual de estudo: `DELETE /usuarios/{id}` remove usuario e retorna `204 NO CONTENT` ou `404 NOT FOUND`.
- Endpoint atual de estudo: `POST /auth/login` recebe email e senha e retorna token JWT e tipo `Bearer`.
- Modelo atual: `Usuario` com `id`, `nome`, `email` e `senha`.
- O modelo `Usuario` esta marcado como entidade JPA com `@Entity`.
- O campo `id` do `Usuario` esta marcado com `@Id` e `@GeneratedValue`.
- Existe apenas o teste de contexto `contextLoads()`.
- Observacao: o `UsuarioController` delega as operacoes de usuarios para o `UsuarioService`.
- Observacao: o `UsuarioService` segue cuidando do CRUD de usuarios.
- Observacao: o `AuthService` agora cuida do login/autenticacao.
- Observacao: o `UsuarioRepository` agora possui `findByEmail(String email)` para buscar usuario pelo email.
- Observacao: o `UsuarioRepository` agora possui `existsByEmail(String email)` para validar email duplicado.
- Observacao: o `UsuarioController` usa `ResponseEntity` para controlar status HTTP e corpo da resposta.
- Observacao: no fluxo atual, o service recebe `UsuarioRequestDTO`, trabalha internamente com `Usuario` e devolve `UsuarioResponseDTO`.
- Observacao: no fluxo de login, o `AuthController` chama `AuthService.login(...)`.
- Observacao: o `AuthService` usa `AuthenticationManager` e `JwtService` para autenticar e gerar token.
- Observacao: o `LoginResponseDTO` atual devolve `token` e `tipo`.
- Observacao: os DTOs ajudam a separar o que entra e o que sai da API do model interno.
- Observacao: o `UsuarioController` usa `@Valid` para pedir ao Spring a validacao do `UsuarioRequestDTO`.
- Observacao: com a dependencia de validation, o Spring pode bloquear requests invalidos antes de entrar no service.
- Observacao: quando a validacao falha, o `GlobalExceptionHandler` captura a excecao e devolve `400 BAD REQUEST`.
- Observacao: a resposta de erro de validacao agora e uma lista de `ErroValidacaoDTO`, com `campo` e `mensagem`.
- Observacao: configuracao atual aponta para H2 em memoria: `jdbc:h2:mem:apiusuarios`.
- Observacao: por enquanto, o H2 esta em memoria e os dados sao perdidos ao reiniciar a aplicacao.
- Observacao: `application.properties` agora possui `jwt.secret` e `jwt.expiration`.
- Observacao: o `SecurityConfig` libera `/auth/**`, `/h2-console/**` e `POST /usuarios` sem login.
- Observacao: as demais rotas exigem autenticacao.
- Observacao: o `JwtAuthenticationFilter` procura o token no cabecalho `Authorization: Bearer ...`.
- Observacao: o `CustomUserDetailsService` busca o usuario pelo email para o Spring Security.
- Observacao: o `SecurityConfig` registra `PasswordEncoder`, `DaoAuthenticationProvider`, `AuthenticationManager` e a `SecurityFilterChain`.
- Observacao: o service ainda usa `null` quando nao encontra usuario, mas o controller converte esse caso para `404 NOT FOUND`.
- Observacao importante: o model `Usuario` agora possui o campo `senha`.
- Observacao importante: no comportamento atual, a senha nao e mais salva em texto puro.
- Observacao importante: o `UsuarioService` agora usa `PasswordEncoder` para criptografar a senha antes de salvar.
- Observacao importante: a `senha` nao volta no `UsuarioResponseDTO`, entao nao e exposta na resposta da API.
- Observacao importante: agora o login passou a depender do Spring Security + JWT, em vez de comparacao manual simples no `UsuarioService`.
- Observacao importante: o login atual usa `AuthenticationManager`, entao a comparacao da senha passou a ser feita pelo Spring Security.
- Observacao importante: o cadastro e a atualizacao agora barram emails duplicados com `existsByEmail(...)`.
- Observacao importante: o `AuthService` gera o JWT usando o email como subject do token.
- Observacao importante: `.codex/` deve permanecer fora do versionamento.
- O `README.md` lista os endpoints atuais e deve evoluir junto com a API.

## Validacao conhecida

- `./mvnw test` passou em 2026-04-09 executando fora da sandbox restrita.
- Observacao: dentro da sandbox restrita, o Mockito/Byte Buddy pode falhar ao inicializar por bloqueio no mecanismo de attach da JVM.
- Essa falha de attach nao indicou problema na classe principal do Spring.
- Observacao: `LoginResponseDTO` esta limpo e documentado no padrao atual do projeto.

## Comandos uteis

Para executar a aplicacao:

```bash
mvn spring-boot:run
```

Durante os estudos, a dependencia `spring-boot-devtools` ajuda a reiniciar a aplicacao quando o codigo muda.

Observacao simples:

- O DevTools nao muda o codigo "ao vivo" dentro da JVM.
- Ele observa arquivos compilados e reinicia o Spring quando percebe alteracao.
- Se estiver rodando pelo terminal e nada reiniciar, salve o arquivo e compile novamente pelo editor/IDE.

Opcao equivalente usando o Maven Wrapper do projeto:

```bash
./mvnw spring-boot:run
```

Para rodar os testes:

```bash
./mvnw test
```

Para fazer uma verificacao mais completa depois de mexer em dependencias:

```bash
./mvnw clean install
```

## Resumo de estudo - Uso do Lombok

Neste projeto, usamos Lombok na classe `Usuario` para reduzir codigo repetitivo.

Dependencia adicionada no `pom.xml`:

- `org.projectlombok:lombok`

Anotacoes usadas em `Usuario`:

- `@Getter`: gera automaticamente os metodos `get`.
- `@Setter`: gera automaticamente os metodos `set`.
- `@NoArgsConstructor`: cria o construtor vazio `Usuario()`.
- `@AllArgsConstructor`: cria o construtor com todos os atributos.

Configuracao recomendada no VS Code:

- Instalar a extensao `Lombok Annotations Support for VS Code`.
- Se a IDE continuar acusando erro em `@Getter`, `@Setter` etc., reiniciar o VS Code depois da instalacao.

O que aconteceu na pratica:

- Antes, os getters, setters e construtores eram escritos manualmente.
- Agora, o Lombok gera esse codigo automaticamente em tempo de compilacao.
- O Jackson continua conseguindo converter JSON em objeto `Usuario`.

Regra importante:

- Lombok nao substitui Jackson.
- Lombok automatiza codigo Java repetitivo.
- Jackson converte JSON em objeto e objeto em JSON.

Fluxo mental do POST JSON:

```json
{
  "id": 1,
  "nome": "Edbruno",
  "email": "ed@email.com"
}
```

Na pratica, o Spring/Jackson consegue fazer algo equivalente a:

```text
new Usuario()
setId(...)
setNome(...)
setEmail(...)
```

Frase para lembrar:

> Lombok escreve o codigo que eu nao quero repetir, mas o Spring continua usando ele normalmente.

## Arquitetura pretendida para evolucao

Decisao atual:

- Seguir com Java e Spring Boot.
- Nao usar Django neste projeto por enquanto.
- Manter `ApiusuariosApplication` apenas como bootstrap da aplicacao.

Preferencia de estudo:

- Usar linguagem simples nas explicacoes e comentarios.
- Nos arquivos Java de estudo, preferir comentarios curtos logo acima da linha importante.
- Explicar termos tecnicos quando eles aparecerem pela primeira vez.
- Preferir passos pequenos, com objetivo claro e validacao.
- Evitar abstrações avancadas antes de existir uma necessidade concreta.

Quando o projeto crescer, manter responsabilidades separadas:

- Controllers: entrada HTTP, validacao simples, orquestracao e resposta.
- Services: regras de aplicacao/casos de uso.
- Repositories: acesso a dados, se persistencia for adicionada.
- DTOs: contrato de entrada e saida da API.
- Mappers/Adapters: transformacao entre modelos quando houver ganho claro.
- Error handlers: padronizacao de erros HTTP e mensagens.

## Regras de manutencao

- Nao assumir persistencia antes de existir configuracao, repository ou banco validado.
- Nao assumir endpoint antes de existir controller ou teste.
- Priorizar mensagens reais de erro quando houver integracao externa.
- Preservar simplicidade: adicionar camadas conforme necessidade real.
- Atualizar esta memoria quando uma decisao mudar o desenho do projeto.

## Proximos pontos naturais

- Definir o primeiro recurso da API, por exemplo `usuarios`.
- Definir contrato HTTP: endpoint, payload de entrada, payload de saida e status.
- Escolher estrategia de persistencia: memoria, H2, PostgreSQL, MySQL ou outra.
- Adicionar testes focados para seguranca, login JWT e CRUD autenticado.
