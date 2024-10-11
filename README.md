
# Kafka Microservices Project
Este repositório contém dois microserviços baseados no Apache Kafka, desenvolvidos com Java e Spring Boot. Cada microserviço é responsável por uma parte diferente da comunicação via Kafka.

## Sumário
- [Descrição do Projeto](#descrição-do-projeto)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Executando o Projeto](#executando-o-projeto)
- [Docker](#docker)

## Descrição do Projeto
Este projeto implementa dois microserviços que utilizam o Apache Kafka para processar e transmitir mensagens de forma assíncrona.

![Alt text here](diagram.svg)

### Microserviço 1: `microservice-kafka`

Este microserviço é responsável por:
- Produzir mensagens de pedidos (`OrderData`) e enviá-las para o tópico Kafka.
- Consumir mensagens de confirmação.

### Microserviço 2: `rest-kafka`
Este microserviço oferece uma API REST que:
- Recebe requisições de criação de pedidos e envia os dados para o `microservice-kafka`.
- Confirma o recebimento de mensagens de confirmação enviadas pelo `microservice-kafka`.

## Estrutura do Projeto

O projeto está dividido em dois principais diretórios, cada um representando um microserviço:

```bash
Kafka/
├── docker-compose.yml     # Arquivo de configuração do Docker para subir o ambiente completo.
├── microservice-kafka/    # Microserviço responsável por enviar e consumir mensagens do Kafka.
└── rest-kafka/            # Microserviço REST que interage com o microservice-kafka.
```

Cada microserviço tem sua própria configuração e estrutura de código.

### Principais Arquivos

- **`application.properties`**: Configurações de conexão com Kafka e outras propriedades do Spring Boot.
- **`OrderController.java`**: Controlador que expõe endpoints para a API REST no `rest-kafka`.
- **`SaveOrderService.java`**: Serviço responsável pelo salvamento de pedidos no `microservice-kafka`.
- **`docker-compose.yml`**: Arquivo Docker para rodar o Kafka, Zookeeper, e os microserviços.

## Executando o Projeto

1. Clone este repositório:
   ```bash
   git clone https://github.com/jovicruz/microservices-kafka.git
   ```
2. Acesse o diretório do projeto:
   ```bash
   cd microservices-kafka
   ```
3. Inicie os serviços usando o Docker:
   ```bash
   docker-compose up
   ```

## Docker

Certifique-se de que o Docker esteja instalado e em execução. O arquivo `docker-compose.yml` irá subir os serviços necessários para o funcionamento do Kafka e do Zookeeper.

