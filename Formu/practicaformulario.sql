/*
LÓPEZ ESQUIVEL ANDRÉS
5IM8
Base de datos del formulario
*/
drop Database if exists practicaformulario;
create database practicaformulario;

use practicaformulario;

create table datosformulario(
	IdUsario int not null primary key auto_increment,
    Nombre varchar(200),
    App varchar(200),
    Apm varchar(200),
    Escuela varchar(200)    
);