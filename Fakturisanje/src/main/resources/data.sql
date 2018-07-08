insert into Grad (ptt, naziv) values (21000, 'Novi Sad');

insert into Kompanija (naziv, pid, kontakt, adresa, broj_racuna, id_grada) values 
	('Erste Bank', 101626723, '0800201201', 'Bulevar Oslobodjenja 5', '11-1111-111', 1);

insert into Radnik (email, ime, prezime, lozinka, kontakt_telefon, adresa, id_grada, id_kompanije, role) values 
	('smiljana@gmail.com', 'Smiljana', 'Dragoljevic', 'smiljana', '12345', 'Bulevar Evrope 19', 1, 1, 'REGISTERED');
	
insert into Radnik (email, ime, prezime, lozinka, kontakt_telefon, adresa, id_grada, id_kompanije, role) values 
	('jelena@gmail.com', 'Jelena', 'Stanarevic', 'jelena', '12345', 'Banovic Strahinje 6', 1, 1, 'REGISTERED');