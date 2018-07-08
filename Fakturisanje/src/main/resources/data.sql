
insert into Tip_poslovnog_partnera(naziv) values ('dobavljac');
insert into Tip_poslovnog_partnera(naziv) values ('kupac');
insert into Tip_poslovnog_partnera(naziv) values ('kupacdobavljac');


insert into Grad (ptt, naziv) values (21000, 'Novi Sad');

insert into Kompanija (naziv, pid, kontakt, adresa, broj_racuna, id_grada) values 
	('Erste Bank', 101626723, '0800201201', 'Bulevar Oslobodjenja 5', '11-1111-111', 1);

insert into Poslovni_partner(id_kompanija, id_tipa, naziv,id_grada,adresa,kontakt_telefon) values (1,1,'Dobavljac1',1,'Bulevar Oslobodjenja 5','857156');	
insert into Poslovni_partner(id_kompanija, id_tipa, naziv,id_grada,adresa,kontakt_telefon) values (1,1,'Dobavljac2',1,'Bulevar Oslobodjenja 5','842588');	

insert into Poslovni_partner(id_kompanija, id_tipa, naziv,id_grada,adresa,kontakt_telefon) values (1,2,'Kupac1',1,'Bulevar Oslobodjenja 5','11111222');	
insert into Poslovni_partner(id_kompanija, id_tipa, naziv,id_grada,adresa,kontakt_telefon) values (1,2,'Kupac2',1,'Bulevar Oslobodjenja 5','857584222222');	

insert into Poslovni_partner(id_kompanija, id_tipa, naziv,id_grada,adresa,kontakt_telefon) values (1,3,'DobavljacKupac1',1,'Bulevar Oslobodjenja 5','0000258');	
insert into Poslovni_partner(id_kompanija, id_tipa, naziv,id_grada,adresa,kontakt_telefon) values (1,3,'DobavljacKupac2',1,'Bulevar Oslobodjenja 5','8585858');	

insert into jedinica_mere (naziv, oznaka) values ('komad', 'kom');
insert into jedinica_mere (naziv, oznaka) values ('kilogram', 'kg');
insert into jedinica_mere (naziv, oznaka) values ('litar', 'l');

insert into stopapdva (pdvu_procentima) values ('10%');
insert into stopapdva (pdvu_procentima) values ('20%');

insert into tippdva (naziv,id_stopepdva) values ('obican',2);
insert into tippdva (naziv,id_stopepdva) values ('povlasceni',1);

insert into grupa_artikala (naziv, id_tipapdva) values ('proizvodi1',1);
insert into grupa_artikala (naziv, id_tipapdva) values ('proizvodi2',2);




insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Patike', 'lepe patike', 1,1);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Majica', 'roza', 1,1);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Pantalone', 'dugacke', 1,1);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Voda', 'opis....', 3,2);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Sok', 'next', 3,2);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Krompir', 'mladi krompir', 2,1);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Paradajz', 'svez', 2,2);

insert into cenovnik (datum_pocetka_vazenja, id_kompanije, id_poslovnog_partnera, aktivan)
	values ('2016-11-29 21:00:00', null, 1, true);
insert into cenovnik (datum_pocetka_vazenja, id_kompanije, id_poslovnog_partnera, aktivan)
	values ('2016-11-29 21:00:00', null, 2, true);
insert into cenovnik (datum_pocetka_vazenja, id_kompanije, id_poslovnog_partnera, aktivan)
	values ('2016-11-29 21:00:00', null, 3, true);
	
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena) values (1, 1, 20);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena) values (2, 1, 10);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena) values (3, 1, 50);

insert into stavkaucenovniku (id_artikla, id_cenovnika, cena) values (4, 2, 2);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena) values (5, 2, 4);

insert into stavkaucenovniku (id_artikla, id_cenovnika, cena) values (6, 3, 12);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena) values (7, 3, 12);



	
insert into Radnik (email, ime, prezime, lozinka, kontakt_telefon, adresa, id_grada, id_kompanije, role) values 
	('smiljana@gmail.com', 'Smiljana', 'Dragoljevic', 'smiljana', '12345', 'Bulevar Evrope 19', 1, 1, 'REGISTERED');
	
insert into Radnik (email, ime, prezime, lozinka, kontakt_telefon, adresa, id_grada, id_kompanije, role) values 
	('jelena@gmail.com', 'Jelena', 'Stanarevic', 'jelena', '12345', 'Banovic Strahinje 6', 1, 1, 'REGISTERED');