-- Insertar tipo de usuario
INSERT INTO tipo_usuario (nombre) VALUES ('Admin');
INSERT INTO tipo_usuario (nombre) VALUES ('Coordinador');
INSERT INTO tipo_usuario (nombre) VALUES ('Director');
INSERT INTO tipo_usuario (nombre) VALUES ('Trabajador');

-- Insertar tipo de sede
INSERT INTO tipo_sede (nombre) VALUES ('SIERRA OESTE 101');
INSERT INTO tipo_sede (nombre) VALUES ('SIERRA ESTE 102');
INSERT INTO tipo_sede (nombre) VALUES ('CUENCA MINERA 104');
INSERT INTO tipo_sede (nombre) VALUES ('CONDADO NORTE 106');
INSERT INTO tipo_sede (nombre) VALUES ('RIBERA DEL TINTO 1 108');
INSERT INTO tipo_sede (nombre) VALUES ('RIBERA DEL TINTO 2 109');
INSERT INTO tipo_sede (nombre) VALUES ('CONDADO SUR 110');
INSERT INTO tipo_sede (nombre) VALUES ('SAD LINARES 3');
INSERT INTO tipo_sede (nombre) VALUES ('SAD MARTOS 55');
INSERT INTO tipo_sede (nombre) VALUES ('SAD ALCALÁ LA REAL 58');
INSERT INTO tipo_sede (nombre) VALUES ('SAD DIPUTACIÓN CÁDIZ 62');
INSERT INTO tipo_sede (nombre) VALUES ('SAD DIPUTACION JAEN OCCIDENTAL 200');
INSERT INTO tipo_sede (nombre) VALUES ('SAD DIPUTACION JAEN ORIENTAL 201');
INSERT INTO tipo_sede (nombre) VALUES ('SAD SERCOVAL 4');
INSERT INTO tipo_sede (nombre) VALUES ('SAD ALHAMA DE MURCIA 80');
INSERT INTO tipo_sede (nombre) VALUES ('SAD TORRE-PACHECO 81');
INSERT INTO tipo_sede (nombre) VALUES ('SAD GUADALAJARA. NUEVOS 87');
INSERT INTO tipo_sede (nombre) VALUES ('OFICINA CENTRAL 1');
INSERT INTO tipo_sede (nombre) VALUES ('SAD CAMAS 48');
INSERT INTO tipo_sede (nombre) VALUES ('SAD CASTILLEJA 51');
INSERT INTO tipo_sede (nombre) VALUES ('RES. MAYORES USERA 84');
INSERT INTO tipo_sede (nombre) VALUES ('SAD GUADALAJARA SUBROGADOS 86');
INSERT INTO tipo_sede (nombre) VALUES ('ESTRUCTURA 112');
INSERT INTO tipo_sede (nombre) VALUES ('RES. MAYORES PEAL DE BECERRO 21');
INSERT INTO tipo_sede (nombre) VALUES ('RES. MAYORES "ANGELES COBO" ALCAUDETE 22');
INSERT INTO tipo_sede (nombre) VALUES ('RES. MAYORES EL RONQUILLO 27');
INSERT INTO tipo_sede (nombre) VALUES ('RES. "SAN CRISTOBAL" LAS GABIAS 32');
INSERT INTO tipo_sede (nombre) VALUES ('RES. MAYORES "POZO DE LA NIEVE" GENAVE 41');
INSERT INTO tipo_sede (nombre) VALUES ('U.E.D. "SANTA MARTA" MARTOS 56');
INSERT INTO tipo_sede (nombre) VALUES ('RESIDENCIA ARROYO DE LA MIEL 66');
INSERT INTO tipo_sede (nombre) VALUES ('UED AGUADULCE 69');
INSERT INTO tipo_sede (nombre) VALUES ('UED ATARFE 76');
INSERT INTO tipo_sede (nombre) VALUES ('UED DARRO 77');
INSERT INTO tipo_sede (nombre) VALUES ('RES. ALMADEN DE LA PLATA 83');
INSERT INTO tipo_sede (nombre) VALUES ('RES. MAYORES SAN SEBASTIAN DE LOS REYES 85');
INSERT INTO tipo_sede (nombre) VALUES ('E.I. "LAS CARMELAS" GINES 16');
INSERT INTO tipo_sede (nombre) VALUES ('E.I. "EL PATRIARCA" MAIRENA DEL ALCOR 17');
INSERT INTO tipo_sede (nombre) VALUES ('E.I. "NUEVA SEVILLA" CASTILLEJA DE LA CUESTA 18');
INSERT INTO tipo_sede (nombre) VALUES ('E.I. "LA MOTA" ALCALA LA REAL 19');
INSERT INTO tipo_sede (nombre) VALUES ('E.I. BALANEGRA 44');
INSERT INTO tipo_sede (nombre) VALUES ('E.I. "ARRAYANES" 63');
INSERT INTO tipo_sede (nombre) VALUES ('CAIT BAEZA 70');
INSERT INTO tipo_sede (nombre) VALUES ('CAIT MARCHENA 72');
INSERT INTO tipo_sede (nombre) VALUES ('RESIDENCIA LOS BALCONES 1');
INSERT INTO tipo_sede (nombre) VALUES ('E.I. PATACONA 001');
INSERT INTO tipo_sede (nombre) VALUES ('SAD SEVILLA 90');
INSERT INTO tipo_sede (nombre) VALUES ('SAD DOS HERMANAS 94');
INSERT INTO tipo_sede (nombre) VALUES ('SAD PRIVADO BIZKAIA 8');
INSERT INTO tipo_sede (nombre) VALUES ('CENTRO DE DÍA LA AMISTAD 1');
INSERT INTO tipo_sede (nombre) VALUES ('CENTRO DE DIA FUENTE SAN LUIS 2');
INSERT INTO tipo_sede (nombre) VALUES ('CENTRO OCUPACIONAL XIRIVELLA 3');
INSERT INTO tipo_sede (nombre) VALUES ('SAD XIRIVELLA 4');
INSERT INTO tipo_sede (nombre) VALUES ('CENTRO OCUPACIONAL MISLATA 2');
INSERT INTO tipo_sede (nombre) VALUES ('SAD ALBAL 6');
INSERT INTO tipo_sede (nombre) VALUES ('CENTRO OCUPACIONAL VICENTE PEREZ 15');
INSERT INTO tipo_sede (nombre) VALUES ('E.I. "MIRADOR DE LA VEGA" HUETOR VEGA 15');
INSERT INTO tipo_sede (nombre) VALUES ('CENTRO EMERGENCIAS GANDIA 10');
INSERT INTO tipo_sede (nombre) VALUES ('CENT. CONVIV. ANTONIA CERDA Y PEDRO GARCIA 12');
INSERT INTO tipo_sede (nombre) VALUES ('SAD AZNALCAZAR 61');
INSERT INTO tipo_sede (nombre) VALUES ('SAD MEJORADA DEL CAMPO. 68');
INSERT INTO tipo_sede (nombre) VALUES ('SAD SAN FERNANDO DE HENARES 79');
INSERT INTO tipo_sede (nombre) VALUES ('SAD BIZKAIA 1');
INSERT INTO tipo_sede (nombre) VALUES ('E.I. PORTUGALETE 3');
INSERT INTO tipo_sede (nombre) VALUES ('SAD ALMENSILLA 91');



-- Insertar empresa
INSERT INTO empresa (nombre) VALUES ('MACROSAD, S. COOP. AND');
INSERT INTO empresa (nombre) VALUES ('ASOCIACION SERCOVAL');
INSERT INTO empresa (nombre) VALUES ('MACROSAD SENIOR S.C.A');
INSERT INTO empresa (nombre) VALUES ('CHACOLINES, S.C.A.');
INSERT INTO empresa (nombre) VALUES ('SUPERCAIT, S.C.A.');
INSERT INTO empresa (nombre) VALUES ('TOSANDE, S. COOP. MAD');
INSERT INTO empresa (nombre) VALUES ('UTE SAD VALENCIA');
INSERT INTO empresa (nombre) VALUES ('POVINET, S.C.V.');
INSERT INTO empresa (nombre) VALUES ('FUNDACION AGEING SOCIAL LAB');
INSERT INTO empresa (nombre) VALUES ('FUNDACION NTRA SRA DOLORES');
INSERT INTO empresa (nombre) VALUES ('PATACONA, UTE');
INSERT INTO empresa (nombre) VALUES ('EDER ARRETAK, S.L.');
INSERT INTO empresa (nombre) VALUES ('LA TERRETA, SERVEIS SOCIALS, COOP. VAL.');
INSERT INTO empresa (nombre) VALUES ('MACROTOUR, SCA');
INSERT INTO empresa (nombre) VALUES ('PLENIMUS, S.L.');

-- Insertar usuario/password:Secreto123
INSERT INTO usuario (usuario_obligado_cumplimiento_id, apellidos, dni, email, nombre, password, username,habilitar) VALUES (NULL, 'Apellidos Usuario', 'DNI Usuario', 'email@usuario.com', 'Balbino', '$2a$10$PMDCjYqXJxGsVlnve1t9Jug2DkDDckvUDl8.vF4Dc6yg0FMjovsXO', 'username',1);

-- Insertar territorio
INSERT INTO territorio (sede_id, territorio_obligado_cumplimiento_id, nombre) VALUES (NULL, NULL, 'DT1');
INSERT INTO territorio (sede_id, territorio_obligado_cumplimiento_id, nombre) VALUES (NULL, NULL, 'DT2');
INSERT INTO territorio (sede_id, territorio_obligado_cumplimiento_id, nombre) VALUES (NULL, NULL, 'DT3');
INSERT INTO territorio (sede_id, territorio_obligado_cumplimiento_id, nombre) VALUES (NULL, NULL, 'DT4');
INSERT INTO territorio (sede_id, territorio_obligado_cumplimiento_id, nombre) VALUES (NULL, NULL, 'DT5');
INSERT INTO territorio (sede_id, territorio_obligado_cumplimiento_id, nombre) VALUES (NULL, NULL, 'DT6');
INSERT INTO territorio (sede_id, territorio_obligado_cumplimiento_id, nombre) VALUES (NULL, NULL, 'DT7');

-- Insertar sede
INSERT INTO sede (habilitar, empresa_id, empresa_sedes_id, sede_factura_id, sede_territorio_id, usuario_id, usuario_sede_id, cp, direccion, localidad, nombre, provincia, telefono, tipo_centro) VALUES (NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'CP', 'Dirección', 'Localidad', 'Nombre Sede', 'Provincia', 'Teléfono', 'Tipo Centro');

-- Insertar factura
INSERT INTO factura (estado, visto, sede_id, usuario_facturas_id, usuario_id, concepto, fecha_va, nombre, observaciones, proveedor,fichero) VALUES (NULL, NULL, NULL, NULL, NULL, 'Concepto Factura', 'Fecha Factura', 'Nombre Factura', 'Observaciones Factura', 'Proveedor Factura','ficherito.pdf');

-- Insertar obligado de cumplimiento
INSERT INTO obligado_cumplimiento (aplica, borrar, favorable, empresa_id, empresa_obligado_cumplimiento_id, sede_id, territorio_id, usuario_id, fecha_validez, fichero, observaciones,tipo) VALUES (NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Fecha Validez', 'Fichero', 'Observaciones','Tipo de obligado');

-- Insertar relación usuario-tipo_usuario
INSERT INTO usuario_tipo_usuario (tipo_usuario_id, usuario_id) VALUES (1, 1);

-- Insertar relación sede-tipo_sede
INSERT INTO sede_tipo_sede (sede_id, tipo_sede_id) VALUES (1, 1);
