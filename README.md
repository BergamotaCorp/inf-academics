# Inf Academics by Bergamota Corp

# Para publicação

## Pré-Requisitos

Docker Engine  
Git

## Instalação

$ git clone https://github.com/BergamotaCorp/inf-academics.git inf-academics && cd $_  
$ docker run --name mysql -e MYSQL_ROOT_PASSWORD=s3cr3t -d mysql:latest  && sleep 30  
$ docker exec $(docker ps -aqf "name=mysql") mysql -uroot -ps3cr3t -ne "CREATE SCHEMA infacademics;GRANT ALL ON infacademics.* TO 'root'@'%' IDENTIFIED BY '';"  
$ DB_HOST=$(docker inspect --format '{{ .NetworkSettings.IPAddress }}' $(docker ps -aqf "name=mysql"))  
$ docker build --build-arg DB_HOST=$DB_HOST -t infacademics .  
$ docker run -p 80:8080 -e "DB_HOST=$DB_HOST" --name infacademics -d infacademics  

# Para desenvolvimento

## Pré-Requisitos

Node 4.4+  
MySQL 5.5 (Criar usuário root sem senha para localhost)

## Instalação

Instalar o o MySQL e criar o schema infacadamics    

$ CREATE SCHEMA infacademics;  
$ CREATE USER 'root'@'localhost';  
$ GRANT ALL ON infacademics.* TO 'root'@'localhost';    

Depois de instalados o Node e MySQL, acessar a linha de comando e ir até o diretório em que fez o git clone  

$ cd /projeto/inf-academics  
$ npm install  
$ node node_modules/bower/bin/bower install  
$ node node_modules/gulp/bin/gulp.js install  
$ gradle flywayMigrate  
$ gradle bootRun  

