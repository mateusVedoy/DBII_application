# Trabalho JDBC e Oracle

### Instanciando DB via docker no terminal
```
docker pull container-registry.oracle.com/database/free:latest
docker-compose up -d
```

### Conectando ao banco
```
Host: localhost
Usuário: system
Senha: db2
porta: 1521
banco: FREEPDB1
```
Considerações: O tópico acima vale para quem rodar o banco no container, do contrário, desconsiderar.

### Gerando tabelas
Arquivo: sql-trabalho.sql

### Gerando massa de dados
Arquivo: insert-trabalho.sql

### Gerando funções
Arquivo: funcoes-trabalho.sql

### Gerando procedures
Arquivo: procedures-trabalho.sql

### Considerações (AJUSTAR)
* Por não ter Oracle instalado na máquina,
realisei toda construção e execução do projeto pelo Intellij
e usando container docker para emular o banco.
* Utilizei arquitetura no padrão hexagonal,
pois estou mais acostumado assim por conta do trabalho.
A separação ficou:
  * Application
    * casos de uso.
    * views
  * Domain
    * entidades do sistema
    * port (interfaces)
  * Infraestructure 
    * Dao
    * conexão DB