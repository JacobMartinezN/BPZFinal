
INSERT INTO users (username, password, enabled) VALUES ('Analista','$2a$10$QodDkbTDP.4JzAcn0pnk9uROgR5Bf.tM1GCMp5Cn9AjzU4pHbSsI.',true);
INSERT INTO users (username, password, enabled) VALUES ('Contador','$2a$10$QodDkbTDP.4JzAcn0pnk9uROgR5Bf.tM1GCMp5Cn9AjzU4pHbSsI.',true);

INSERT INTO authorities (user_id, authority) VALUES (1,'ROLE_CUENTAS');
INSERT INTO authorities (user_id, authority) VALUES (2,'ROLE_CONTADOR');

INSERT INTO banco (razon_social, ruc ) VALUES ('INTERBANK', '20123456789');
INSERT INTO banco (razon_social, ruc ) VALUES ('BCP', '20123456432');
INSERT INTO banco (razon_social, ruc ) VALUES ('SCOTIABANK', '20345678987');
INSERT INTO banco (razon_social, ruc ) VALUES ('BANBIF', '20234990876');
INSERT INTO banco (razon_social, ruc ) VALUES ('BBVA CONTINENTAL', '20878908765');

