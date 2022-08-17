create database rh;
use rh;
create table empleados (
	id int AUTO_INCREMENT PRIMARY KEY,
	nombre varchar (50) ,
	apellido varchar (50) ,
    direccion varchar (50) ,
    correo varchar (50) ,
    idp int
);

create table departamentos (
	id int AUTO_INCREMENT PRIMARY KEY,
	depa varchar (50)
);
alter table empleados add constraint foreign key (idp)references departamentos(id);

insert into departamentos (depa) value ("TI"),("Marketing"),("Producccion");
insert into empleados (nombre,apellido,direccion,correo,idp) values ("Jared","Pineda","Nejapa","jared@gmail.com",1),
("Mathews","Molina","Tecla","mathews12@gmail.com",2),("Mateo","Rodriguez","Quezaltepeque","mateo@gmail.com",3);

select * from departamentos as d inner join empleados as e on (d.id=e.idp);
select * from empleados as e inner join departamentos as d on (e.idp=d.id);
 