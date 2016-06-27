# Inf Academics by Bergamota Corp


Node 4.4+


Instalar o o MySQL e criar o schema infacadamics    

$ CREATE SCHEMA infacademics;  
$ CREATE USER 'root'@'localhost';  
$ GRANT ALL ON infacademics.* TO 'root'@'localhost';    


$ cd /projeto/inf-academics  
$ npm install  
$ node node_modules/bower/bin/bower install  
$ node node_modules/gulp/bin/gulp.js install  
$ gradle flywayMigrate  
$ gradle bootRun  

