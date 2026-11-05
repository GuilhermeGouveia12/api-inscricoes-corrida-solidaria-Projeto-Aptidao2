# API de Inscrições — 5ª Corrida Solidária da Vila Esperança

## Sobre o projeto

Esta é uma API REST desenvolvida para gerenciar as inscrições da 5ª Corrida Solidária da Vila Esperança, permitindo cadastrar, consultar, atualizar e excluir participantes.

O projeto foi desenvolvido como parte de uma atividade acadêmica, utilizando Java e Spring Boot.

## Tecnologias utilizadas

- Java 25
- Spring Boot 4.1.2
- Maven
- Spring Web MVC
- Spring Validation

## Requisitos

Para executar o projeto, é necessário ter instalado:

- JDK 25 ou superior, compatível com a versão configurada no projeto.
- Git (opcional, para clonar o repositório).

## Como executar o projeto

1. Clone o repositório:

```bash
git clone https://github.com/GuilhermeGouveia12/api-inscricoes-corrida-solidaria-Projeto-Aptidao2.git
```

2. Entre na pasta do projeto:

```bash
cd api-inscricoes-corrida-solidaria-Projeto-Aptidao2
```

3. Execute a aplicação:

```bash
.\mvnw.cmd spring-boot:run
```

A API estará disponível em:

```text
http://localhost:8081
```

## Endpoints disponíveis

A API possui os seguintes endpoints:

| Método | Rota | Descrição |
|---|---|---|
| GET | `/inscricoes` | Lista todas as inscrições |
| POST | `/inscricoes` | Cadastra uma inscrição |
| PUT | `/inscricoes/{email}` | Atualiza uma inscrição |
| DELETE | `/inscricoes/{email}` | Exclui uma inscrição |

## Exemplo de cadastro

Para cadastrar uma inscrição, envie uma requisição POST para:

```text
http://localhost:8081/inscricoes
```

Exemplo de JSON:

```json
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "idade": 25,
  "distancia": "KM_5"
}
```

## Regras de validação

O sistema possui algumas regras para garantir a validade das inscrições:

- O nome é obrigatório.
- O e-mail é obrigatório e deve possuir um formato válido.
- Não é permitido cadastrar dois participantes com o mesmo e-mail.
- A idade mínima para participar é de 14 anos.
- Para participar do percurso de 10 km, é necessário ter pelo menos 18 anos.
- As distâncias aceitas são `KM_5` e `KM_10`.

## Respostas da API

A API utiliza códigos HTTP para indicar o resultado das operações:

- `200 OK`: operação realizada com sucesso.
- `201 Created`: inscrição cadastrada.
- `204 No Content`: inscrição excluída.
- `400 Bad Request`: dados inválidos ou regra de negócio não atendida.
- `404 Not Found`: inscrição não encontrada.
- `409 Conflict`: e-mail já cadastrado.

## Armazenamento dos dados

Os dados das inscrições são armazenados temporariamente em memória, utilizando uma lista (`ArrayList`).

Isso significa que as inscrições são perdidas quando a aplicação é encerrada ou reiniciada.

## Autor

Projeto acadêmico desenvolvido para a atividade de Projeto de Aptidão.

**GitHub:** [GuilhermeGouveia12](https://github.com/GuilhermeGouveia12)