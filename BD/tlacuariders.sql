create database tlacuaRiders;
use tlacuaRidersprueba;

create table codigo_postal(
id int not null,
estado varchar(255) not null,
municipio varchar(255) not null,
ciudad varchar(255) not null,
constraint pk_codigo_postal primary key(id)
);

create table usuarios(
id int not null,
nombre varchar(255) not null,
alias varchar(255) not null,
correo varchar(255) not null,
contra varchar(255) not null,
direccion varchar(255) not null, 
telefono int(12) not null,
genero int(1) not null, 
codigo_postal int(6) not null,
constraint pk_usuarios primary key(id)
);

create table articulos(
id int not null,
nombre varchar(255) not null,
descripcion varchar(255) not null,
talla varchar(255) not null,
colores varchar(255) not null,
categoria int not null,
precio int not null,
constraint pk_articulos primary key(id)
);

create table ventas (
id int not null,
usuario_id int not null,
num_pedido int not null,
precio_total int not null,
constraint pk_ventas primary key(id)
);

create table pedidos (
id int not null,
num_pedido int not null,
articulo_id int not null,
cantidad int not null,
precio_total int not null,
constraint pk_pedido primary key(id)
);

create table rodadas(
id int not null,
usuario_id int not null,
nombre varchar(255) not null,
descripcion varchar(255) not null, 
condicion int not null,
direccion_inicio varchar(255) not null, 
direccion_fin varchar(255) not null, 
hora_encuentro time not null,
bicis int not null,
compania int not null,
usuarios_confirmados int null,
usuarios_interesados int null,
turno int not null,
constraint pk_rodadas primary key(id)
);

alter table usuarios add FOREIGN key(codigo_postal) references codigo_postal(id);
alter table rodadas add FOREIGN key(usuario_id) references usuarios(id);
alter table ventas add FOREIGN key(usuario_id) references usuarios(id);
alter table pedidos add FOREIGN key(articulo_id) references articulos(id);
alter table pedidos add FOREIGN key(num_pedido) references ventas(id);
