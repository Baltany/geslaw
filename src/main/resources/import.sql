-- Insertar tipo de usuario
INSERT INTO tipo_usuario (nombre) VALUES ('director');
INSERT INTO tipo_usuario (nombre) VALUES ('cliente');

-- Insertar tipo de sede
INSERT INTO tipo_sede (nombre) VALUES ('Nombre del tipo de sede');

-- Insertar empresa
INSERT INTO empresa (nombre) VALUES ('Nombre de la empresa');

-- Insertar usuario/password:Secreto123
INSERT INTO usuario (usuario_obligado_cumplimiento_id, apellidos, dni, email, nombre, password, username,habilitar) VALUES (NULL, 'Apellidos Usuario', 'DNI Usuario', 'email@usuario.com', 'Balbino', '$2a$10$PMDCjYqXJxGsVlnve1t9Jug2DkDDckvUDl8.vF4Dc6yg0FMjovsXO', 'username',1);

-- Insertar territorio
INSERT INTO territorio (sede_id, territorio_obligado_cumplimiento_id, nombre) VALUES (NULL, NULL, 'Nombre Territorio');

-- Insertar sede
INSERT INTO sede (habilitar, empresa_id, empresa_sedes_id, sede_factura_id, sede_territorio_id, usuario_id, usuario_sede_id, cp, direccion, localidad, nombre, provincia, telefono, tipo_centro) VALUES (NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'CP', 'Dirección', 'Localidad', 'Nombre Sede', 'Provincia', 'Teléfono', 'Tipo Centro');

-- Insertar factura
INSERT INTO factura (estado, visto, sede_id, usuario_facturas_id, usuario_id, concepto, fecha_va, nombre, observaciones, proveedor) VALUES (NULL, NULL, NULL, NULL, NULL, 'Concepto Factura', 'Fecha Factura', 'Nombre Factura', 'Observaciones Factura', 'Proveedor Factura');

-- Insertar obligado de cumplimiento
INSERT INTO obligado_cumplimiento (aplica, borrar, favorable, empresa_id, empresa_obligado_cumplimiento_id, sede_id, territorio_id, usuario_id, fecha_validez, fichero, observaciones,tipo) VALUES (NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Fecha Validez', 'Fichero', 'Observaciones','Tipo de obligado');

-- Insertar relación usuario-tipo_usuario
INSERT INTO usuario_tipo_usuario (tipo_usuario_id, usuario_id) VALUES (1, 1);

-- Insertar relación sede-tipo_sede
INSERT INTO sede_tipo_sede (sede_id, tipo_sede_id) VALUES (1, 1);
