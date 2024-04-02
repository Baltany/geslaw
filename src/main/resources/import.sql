
-- Insertar datos en la tabla Empresa
INSERT INTO empresa (nombre) VALUES ('Nombre de la empresa');

-- Insertar datos en la tabla Factura
INSERT INTO factura (estado, visto, sede_id, usuario_facturas_id, usuario_id, concepto, fecha_va, nombre, observaciones, proveedor) 
VALUES (1, 1, 1, 1, 1, 'Concepto de la factura', '2024-04-02', 'Nombre de la factura', 'Observaciones de la factura', 'Proveedor de la factura');

-- Insertar datos en la tabla Obligado_cumplimiento
INSERT INTO obligado_cumplimiento (aplica, borrar, favorable, empresa_id, empresa_obligado_cumplimiento_id, sede_id, territorio_id, usuario_id, fecha_validez, fichero, observaciones) 
VALUES (1, 0, 1, 1, 1, 1, 1, 1, '2024-04-02', 'nombre_del_fichero', 'Observaciones del obligado de cumplimiento');

-- Insertar datos en la tabla Sede
INSERT INTO sede (habilitar, empresa_id, empresa_sedes_id, sede_factura_id, sede_territorio_id, usuario_id, usuario_sede_id, cp, direccion, localidad, nombre, provincia, telefono, tipo_centro) 
VALUES (1, 1, 1, 1, 1, 1, 1, 'CP de la sede', 'Dirección de la sede', 'Localidad de la sede', 'Nombre de la sede', 'Provincia de la sede', 'Teléfono de la sede', 'Tipo de centro');

-- Insertar datos en la tabla Sede_tipo_sede
INSERT INTO sede_tipo_sede (sede_id, tipo_sede_id) VALUES (1, 1);

-- Insertar datos en la tabla Territorio
INSERT INTO territorio (sede_id, territorio_obligado_cumplimiento_id, nombre) VALUES (1, 1, 'Nombre del territorio');

-- Insertar datos en la tabla Tipo_sede
INSERT INTO tipo_sede (nombre) VALUES ('Nombre del tipo de sede');

-- Insertar datos en la tabla Tipo_usuario
INSERT INTO tipo_usuario (nombre) VALUES ('Nombre del tipo de usuario');

-- Insertar datos en la tabla Usuario
INSERT INTO usuario (usuario_obligado_cumplimiento_id, apellidos, dni, email, nombre, password, username) 
VALUES (1, 'Apellidos del usuario', 'DNI del usuario', 'Email del usuario', 'Nombre del usuario', 'Contraseña del usuario', 'Nombre de usuario');

-- Insertar datos en la tabla Usuario_tipo_usuario
INSERT INTO usuario_tipo_usuario (tipo_usuario_id, usuario_id) VALUES (1, 1);
