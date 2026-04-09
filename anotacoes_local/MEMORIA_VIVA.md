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
- `spring-boot-starter-test`

## Estrutura observada

```text
src/main/java/br/com/edbruno/apiusuarios/ApiusuariosApplication.java
src/main/java/br/com/edbruno/apiusuarios/controller/HelloController.java
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
- Existe apenas o teste de contexto `contextLoads()`.
- Nao ha entidade, DTO, service, repository ou configuracao de banco implementada.
- Nao ha contrato de API documentado neste projeto ate este snapshot.

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
