# Proyecto Final - Aforo255

Desarrollo de microservicios utilizando el stack de Spring Framework, Spring Cloud, Kafka y Docker.

### Proyecto - Funcionalidades
- Invoice: Listar facturas de clientes y consume una cola del microservicio payment actualizando el estado de la factura,
- Payment: Registra pagos de facturas y publica un mensaje en la cola para actualizar la factura en el microservicio invoice            y  para registrar el movimiento en el microservicio transaction,
- Transaction: Listar las transacciones realizadas por factura y consume una cola para registrar una nueva transacción del microservicio payment,
- Config: Contiene la configuración centralizada de cada microservicio.

## Levantamiento de BD y Servicios (Kafka)
Dentro de la carpeta docker-compose ejecutar los siguientes comandos.
```sh
docker-compose -f .\compose-database-test.yml up -d
docker-compose -f .\compose-service-docker-test.yaml up -d
```
## Compilación y ejecución de MS
Pasos a ejecutar para cada microservicio dentro de la carpeta que contiene el microservicio.
#### MS Config:
```sh
 mvn clean install
 docker build -t appconfig .
docker run -p 8088:8888 --name app-config --network aforo255-test -d appconfig
```
#### MS Invoice:
```sh
 mvn clean install
docker build -t appinvoice .
docker run -p 5005:5005 --name app-appinvoice --network aforo255-test -d appinvoice 
```
#### MS Transaction:
```sh
 mvn clean install
docker build -t apptransaction .
docker run -p 5004:5004 --name app-transaction--network aforo255-test -d apptransaction
```
#### MS Payment:
```sh
 mvn clean install
docker build -t apppay .
docker run -p 5003:5003 --name app-pay--network aforo255-test -d apppay
```
#### Cloud Config - Credenciales:
GitHub que contiene las credenciales de la configuración centralizada.
https://github.com/Nemn120/configo-aforo255-test

URL para ver las credenciales de cada microservicio.
- http://localhost:8888/config/appsecurity
- http://localhost:8888/config/appinvoice
- http://localhost:8888/config/apptransaction

## Tecnologias
- Java 11
- Spring Framework
- Spring Boot
- Spring Data
- Spring Cloud Config
- Docker
- Kafka
- Maven
- MongoDB
- MySQL
- PostgreSQL
