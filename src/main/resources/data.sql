INSERT INTO billing_info(producto, precio) VALUES ("ladrillos", "1.5");
INSERT INTO billing_info(producto, precio) VALUES ("cemento portland", "7.6");
INSERT INTO billing_info(producto, precio) VALUES ("cemento blanco", "5.2");

INSERT INTO users(nombre, apellido, dni, esta_activo, fecha_nacimiento, id_billinginfo) VALUES('Jacinto', 'benavente', '320000', 'Y', '1999/2/5', 1);
INSERT INTO users(nombre, apellido, dni, esta_activo, fecha_nacimiento, id_billinginfo) VALUES('Jesus', 'Ayala', '324444', 'N', '1986/3/15', 2);
INSERT INTO users(nombre, apellido, dni, esta_activo, fecha_nacimiento, id_billinginfo) VALUES('Carlos', 'Barden', '327777', 'Y', '1980/1/21', 3);

INSERT INTO tags(nombre, color) VALUES ('Aprobado', 'GREEN');
INSERT INTO tags(nombre, color) VALUES ('Suspenso', 'RED');
INSERT INTO tags(nombre, color) VALUES ('Libre', 'BLUE');
INSERT INTO tags(nombre, color) VALUES ('Ocupado', 'YELLOW');

INSERT INTO tasks(titulo, descripcion, esta_finalizada, fecha_entrega) VALUES ('deporte','futbol','Y','2021/8/1');
INSERT INTO tasks(titulo, descripcion, esta_finalizada, fecha_entrega) VALUES ('comida','paella','N','2021/2/3');
INSERT INTO tasks(titulo, descripcion, esta_finalizada, fecha_entrega) VALUES ('reforma','casa','Y','2022/1/10');
INSERT INTO tasks(titulo, descripcion, esta_finalizada, fecha_entrega) VALUES ('viajar','madrid','Y','2021/3/11');

INSERT INTO task_tag(id_task, id_tag) VALUES (1, 1);
INSERT INTO task_tag(id_task, id_tag) VALUES (1, 3);
INSERT INTO task_tag(id_task, id_tag) VALUES (3, 4);
INSERT INTO task_tag(id_task, id_tag) VALUES (2, 4);


INSERT INTO etiquetas(id, nombre) VALUES (1, "php");
INSERT INTO etiquetas(id, nombre) VALUES (2, "java");
INSERT INTO etiquetas(id, nombre) VALUES (3, "kotlin");

INSERT INTO expertos(id, nombre, telefono, email, modalidad, estado) VALUES (1, "antonio", "666 111 111", "antonio@gmail.com", "online", "pendiente");
INSERT INTO expertos(id, nombre, telefono, email, modalidad, estado) VALUES (2, "jose", "666 222 222", "jose@gmail.com", "presencial", "verificado");
INSERT INTO expertos(id, nombre, telefono, email, modalidad, estado) VALUES (3, "alberto", "666 333 333", "alberto@gmail.com", "online", "verificado");

INSERT INTO experto_etiqueta(experto_id, etiqueta_id) VALUES (1, 1);
INSERT INTO experto_etiqueta(experto_id, etiqueta_id) VALUES (1, 2);
INSERT INTO experto_etiqueta(experto_id, etiqueta_id) VALUES (2, 1);
INSERT INTO experto_etiqueta(experto_id, etiqueta_id) VALUES (2, 2);
INSERT INTO experto_etiqueta(experto_id, etiqueta_id) VALUES (2, 3);


INSERT INTO usuarios(email, password) VALUES ("admin", "admin");