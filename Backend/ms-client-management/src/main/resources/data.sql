/* -------- */
/* CLIENT 1 */
/* -------- */
insert into address(id, type, direction, number, stairs, floor, door, location, province, postal_code, country) 
values(1, 'Calle', 'Naranja', '6', '2', '0', 'A', 'Alicante', 'Alicante', '03001', 'España');

insert into address(id, type, direction, number, stairs, floor, door, location, province, postal_code, country) 
values(2, 'Calle', 'Naranja', '6', '2', '0', 'A', 'Alicante', 'Alicante', '03001', 'España');

insert into billing(id, entity, office, dc, account, address) 
values(1, 'ES26', '1465', '1465', '713182825355', 2);

insert into client(document, document_type, client_type, name, first_surname, second_surname, birth_date, email, online_invoice, due, limit_due, blacklist, address, billing) 
values('48640904K', 'NIF', 'RESIDENCIAL', 'Francisco José', 'Ferrer', 'Rodríguez', '1991-09-25', 'fran@correo.com', 1, 0, 2000, 0, 1, 1);

/* -------- */
/* CLIENT 2 */
/* -------- */
insert into address(id, type, direction, number, stairs, floor, door, location, province, postal_code, country) 
values(3, 'Avenida', 'Australia', '2', '4', '6', 'B', 'Alcobendas', 'Madrid', '28100', 'España');

insert into address(id, type, direction, number, stairs, floor, door, location, province, postal_code, country) 
values(4, 'Avenida', 'Australia', '2', '4', '6', 'B', 'Alcobendas', 'Madrid', '28100', 'España');

insert into billing(id, entity, office, dc, account, address) 
values(2, 'ES20', '2100', '2100', '512329869744', 4);

insert into client(document, document_type, client_type, name, first_surname, second_surname, birth_date, email, online_invoice, due, limit_due, blacklist, address, billing) 
values('48642837M', 'NIF', 'RESIDENCIAL', 'Alejandro', 'Ferrer', 'Rodríguez', '2002-02-04', 'alex@correo.com', 1, 0, 2000, 0, 1, 1);