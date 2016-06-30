# Inf Academics by Bergamota Corp

## Pré-Requisitos

Node 4.4+  
MySQL 5.5 (Criar usuário sem root sem senha para localhost)

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

