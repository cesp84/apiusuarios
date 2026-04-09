# Memoria Viva - apiusuarios

## Objetivo

Memoria local do projeto `apiusuarios`.

Use este arquivo para registrar contexto real, decisoes tecnicas, comportamento validado e pontos de atencao conforme o projeto evoluir.

## Snapshot atual

- Data do snapshot: 2026-04-09
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
- `spring-boot-starter-test`

## Estrutura observada

```text
README.md
src/main/java/br/com/edbruno/apiusuarios/ApiusuariosApplication.java
src/main/java/br/com/edbruno/apiusuarios/controller/HelloController.java
src/main/java/br/com/edbruno/apiusuarios/controller/UsuarioController.java
src/main/java/br/com/edbruno/apiusuarios/model/Usuario.java
src/main/java/br/com/edbruno/apiusuarios/repository/UsuarioRepository.java
src/main/java/br/com/edbruno/apiusuarios/service/UsuarioService.java
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
- Existe um service inicial de usuarios: `UsuarioService`.
- Existe um repository inicial de usuarios: `UsuarioRepository`.
- Endpoint atual de estudo: `GET /usuarios` retorna a lista de usuarios pelo service/repository.
- Endpoint atual de estudo: `GET /usuarios/{id}` busca um usuario pelo id usando service/repository.
- Endpoint atual de estudo: `POST /usuarios` recebe um usuario em JSON e salva pelo service/repository.
- Endpoint atual de estudo: `PUT /usuarios/{id}` atualiza nome e email de um usuario.
- Endpoint atual de estudo: `DELETE /usuarios/{id}` remove um usuario.
- Modelo atual: `Usuario` com `id`, `nome` e `email`.
- O modelo `Usuario` esta marcado como entidade JPA com `@Entity`.
- O campo `id` do `Usuario` esta marcado com `@Id` e `@GeneratedValue`.
- Existe apenas o teste de contexto `contextLoads()`.
- Observacao: o `UsuarioController` delega as operacoes de usuarios para o `UsuarioService`.
- Observacao: o `UsuarioService` delega acesso a dados para `UsuarioRepository`.
- Observacao: configuracao atual aponta para H2 em memoria: `jdbc:h2:mem:apiusuarios`.
- Observacao: por enquanto, o H2 esta em memoria e os dados sao perdidos ao reiniciar a aplicacao.
- Observacao: busca por id ainda retorna `null` quando nao encontra usuario; mais tarde trocar por resposta HTTP adequada.
- O `README.md` lista os endpoints atuais e deve evoluir junto com a API.

## Validacao conhecida

- `./mvnw test` passou em 2026-04-09 executando fora da sandbox restrita.
- Observacao: dentro da sandbox restrita, o Mockito/Byte Buddy pode falhar ao inicializar por bloqueio no mecanismo de attach da JVM.
- Essa falha de attach nao indicou problema na classe principal do Spring.

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
- Adicionar testes focados quando o primeiro controller/service surgir.
