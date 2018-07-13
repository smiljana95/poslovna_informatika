
insert into Tip_poslovnog_partnera(naziv) values ('dobavljac');
insert into Tip_poslovnog_partnera(naziv) values ('kupac');
insert into Tip_poslovnog_partnera(naziv) values ('kupacdobavljac');


insert into Grad (ptt, naziv) values (21000, 'Novi Sad');
insert into Grad (ptt, naziv) values (11000, 'Beograd');
insert into Grad (ptt, naziv) values (18000, 'Nis');
insert into Grad (ptt, naziv) values (24000, 'Subotica');
insert into Grad (ptt, naziv) values (23000, 'Zrenjanin');
insert into Grad (ptt, naziv) values (36210, 'Vrnjacka Banja');
insert into Grad (ptt, naziv) values (11300, 'Smederevo');


insert into Kompanija (naziv, pid, kontakt, adresa, broj_racuna, id_grada,poziv_na_broj) values 
	('Dynamic Pro', 101626723, '+381214809526', 'Zitni trg 4', '200-123456-00', 1, '23');

	
insert into Poslovni_partner(id_kompanija, id_tipa, naziv,id_grada,adresa,kontakt_telefon, poziv_na_broj, racun_za_uplatu) 
	values (1,1,'Medifit Max',2,'Sarajevska 42','+38111362557', '75', '121-856642-55');	
insert into Poslovni_partner(id_kompanija, id_tipa, naziv,id_grada,adresa,kontakt_telefon, poziv_na_broj, racun_za_uplatu) 
	values (1,1,'Lusa Pharm',2,'Dimitrija Tucovica 154','+38111241895', '36', '784-445136-00');	
insert into Poslovni_partner(id_kompanija, id_tipa, naziv,id_grada,adresa,kontakt_telefon, poziv_na_broj, racun_za_uplatu) 
	values (1,1,'Scholl',6,'Lipova 50','+38136584111', '92', '201-601485-90');	
insert into Poslovni_partner(id_kompanija, id_tipa, naziv,id_grada,adresa,kontakt_telefon, poziv_na_broj, racun_za_uplatu) 
	values (1,1,'Sport Vision',2,'Bulevar Nikole Tesle 21','+38111958444', '51', '032-307824-55');	

	
insert into Poslovni_partner(id_kompanija, id_tipa, naziv,id_grada,adresa,kontakt_telefon, poziv_na_broj, racun_za_uplatu) 
	values (1,2,'Tref Sport',2,'Bulevar Arsenija Carnojevica 69b','+38111452220', '66', '547-218650-912');	
insert into Poslovni_partner(id_kompanija, id_tipa, naziv,id_grada,adresa,kontakt_telefon, poziv_na_broj, racun_za_uplatu) 
	values (1,2,'GB Medic',7,'Karadjordjeva 12','+38164521982', '02', '751-258103-008');	
insert into Poslovni_partner(id_kompanija, id_tipa, naziv,id_grada,adresa,kontakt_telefon, poziv_na_broj, racun_za_uplatu) 
	values (1,2,'Medisport',2,'Pere Velimirovica 8b','+38139852642', '80', '999-554469-215');	
insert into Poslovni_partner(id_kompanija, id_tipa, naziv,id_grada,adresa,kontakt_telefon, poziv_na_broj, racun_za_uplatu) 
	values (1,2,'Planeta Sport',1,'Zeleznicka 12','+38165740002', '284', '782-180254-684');	

	
	
	
insert into Poslovni_partner(id_kompanija, id_tipa, naziv,id_grada,adresa,kontakt_telefon, poziv_na_broj, racun_za_uplatu) 
	values (1,3,'Medifit DOO',4,'Ive Lole Ribara 4','+38124551876', '92', '444-954120-77');	
insert into Poslovni_partner(id_kompanija, id_tipa, naziv,id_grada,adresa,kontakt_telefon, poziv_na_broj, racun_za_uplatu) 
	values (1,3,'Ortopom',3,'Knjazevacka 16','+38118571667', '21', '101-105876-84');	
insert into Poslovni_partner(id_kompanija, id_tipa, naziv,id_grada,adresa,kontakt_telefon, poziv_na_broj, racun_za_uplatu) 
	values (1,3,'INTERSPORT',1,'Bulevar Oslobodjenja 102','+381214808658', '82', '227-446205-64');	
insert into Poslovni_partner(id_kompanija, id_tipa, naziv,id_grada,adresa,kontakt_telefon, poziv_na_broj, racun_za_uplatu) 
	values (1,3,'Iron Sport',5,'Ive Andrica 48','+38123859774', '54', '554-459210-110');	

	
insert into jedinica_mere (naziv, oznaka) values ('komad', 'kom');
insert into jedinica_mere (naziv, oznaka) values ('kilogram', 'kg');
insert into jedinica_mere (naziv, oznaka) values ('litar', 'l');



insert into stopapdva (pdvu_procentima) values ('10');
insert into stopapdva (pdvu_procentima) values ('20');


insert into tippdva (naziv,id_stopepdva) values ('obican',2);
insert into tippdva (naziv,id_stopepdva) values ('povlasceni',1);


insert into grupa_artikala (naziv, id_tipapdva) values ('medicinska pomagala',2);
insert into grupa_artikala (naziv, id_tipapdva) values ('sportska oprema',1);
insert into grupa_artikala (naziv, id_tipapdva) values ('sprave',2);

--DOBAVLJACI
--medicinska pomagala - Medifit Max
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Ulosci za obucu', 'Ortopedski ulošci namenjeni su korekciji uzdužnog i poprečnog svoda stopala.', 1,1);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Carape za vene', 'Ekonomski isplativo rešenje za probleme sa venama.', 1,1);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Bandazer', 'Bandazer za skocni zglob', 1,1);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Cervikalni jastuk za spavanje', 'Jastuk od memorijske pene za laksi san.', 1,1);

--medicinska pomagala - Lusa Pharm
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Ortopedske papuce', 'Papuce sa anatomskim uloskom.', 1,1);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Ortopedske patika', 'Patika sa anatomskim uloskom.', 1,1);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Napitak sa kalcijumom', 'Odrzava snagu kostiju i zuba', 1,1);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Micelarna voda', 'Voda za ciscenje koze lica.', 1,1);

--medicinska pomagala - Scholl
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Ulosci za cipele', 'Ortopedski ulosci', 1,1);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Scholl carape', 'Pamucne carape bez elastina.', 1,1);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Flaster za kurje oko', 'Flaster za uklanjanje zuljeva i krujeg oka', 1,1);


--sportska oprema - Sport Vision
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Sportske helanke', 'Helanke za fitness i rekreaciju.', 1,2);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Sportske rukavice', 'Nike rukavice za teretanu.', 1,2);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Sportski top', 'Sportski grudnjak od pamuka i elastina za fitness.', 1,2);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Donji deo trenerke', 'Adidas donji deo sportske trenerke.', 1,2);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Lopta za pilates', 'Fitness lopta.', 1,2);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Flasica za vodu', 'Adida flasica PERF BOTTL od cvrste plastike, 750ml.', 1,2);


--DOBAVLJACI I KUPCI
--medicinska oprema - Medifit DOO
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Merac krvnog pritiska', 'Merac pritiska sa display-em', 1,1);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Kompresivni rukav', 'Rukav od lateksa za fiksiranje lakta.', 1,1);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Naocare za vid', 'Naocare za vid sa razlicitom dioptrijom.', 1,1);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Tronozni stap', 'Stap za potporu pri hodanju.', 1,1);


--medicinska oprema - Ortopom
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Kragna dvodelna', 'Dvodelna kragna za kontrolu kretanja pojedinih delova tela', 1,1);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Invalidska kolica', 'Kolica za pomoc pri kretanju.', 1,1);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Kragna jednodelna', 'Jednodelna kragna za rasterecenje kicmenog stuba.', 1,1);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Cipele', 'Za izradu se koriste iskljucivo prirodni materijali.', 1,1);

--sportska oprema - INTERSPORT
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Duks', 'Nike duks na raskopcavanje.', 1,2);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Jakna', 'Skijaska impregnirana jakna.', 1,2);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Whey protein', 'Protein za povecanje misicne mase.', 2,2);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Patike za trcanje', 'Adidas sportske patike.', 1,2);

--sprave - Iron Sport
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Dzak za box', 'Jaka pvc cirada, siveni i skoro neunistivi mehanizam.', 1,3);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Jednorucni teg', 'Izradjeni od ojacanog polipropilena.', 1,3);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Benc klupa', 'Izradjena od cvrste celicne konstrukcije.', 1,3);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Zidno vratilo', 'Vratilo sa rucicama za paralelni hvat.', 1,3);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Sobni trenazni bicikl', 'Mogucnost manuelnog podesavanja opterecenja i vremena.', 1,3);


--NASA ROBA
--medicinska oprema
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Bandazer za koleno', 'Bandazer od lateksa za potporu kolena pri treniranju.', 1,1);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Sprej za hladjenje', 'Omogućava brži oporavak, smanjuje otok i ublažava bol.', 1,1);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Traka za kinezi terapiju', 'Za sportske povrede i preventivu', 1,1);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Kesa za led', 'Napravljena od platna i postavlja se na mesto povrede', 1,1);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Antidekubikalni prsten', 'Sprečava pojavu dekubita na petama i laktovima za vreme dužeg ležanja', 1,1);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Protein - whey', 'Protein u pravu za odrzavanje i formiranje misicne mase', 2,1);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Hidrogen', 'Hidrogen u kolicinama po zelji, za dezinfekciju rana', 3,1);

--sprave
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Traka za trcanje', 'Motorna traka za trcanje sa manuelnim podesavanjima.', 1,3);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Medicinske lopte', 'Lopta za pobosljanje motorickih sposobnosti.', 1,3);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Pomicno kucno vratilo', 'Proizvod je namenjen vezbama istezanja', 1,3);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Klupa za vezbanje', 'Napravljene za hobi i polu-profesionalno vezbanje u kucnim uslovima', 1,3);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Vijaca', 'Kanap sa ruckama za vecu kontrolu.', 1,3);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Strunjaca', 'Punjene regeneratom koji je propisan standardom.', 1,3);


--sportska oprema
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Trenerka', 'Komplet trenerka za sport i rekreaciju.', 1,2);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Atlet majice', 'Majice od elastina i pamuka za trening.', 1,2);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Sportske carape', 'Pamucne carape sa ojacanjima na zglobovima.', 1,2);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Naocare za ronjenje', 'Gumene naocare sa plasticnim okularima.', 1,2);
insert into artikal  (naziv, opis, id_jedinice_mere,id_grupe_artikala) values ('Patike za kosarku', 'Nike kozne duboke patike za kosarku.', 1,2);


-- Medifit Max
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (500, null, 1, 1);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (600, null, 1, 2);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (1000, null, 1, 3);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (450, null, 1, 4);


--Lusa Pharm
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (700, null, 2, 5);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (600, null, 2, 6);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (800, null, 2, 7);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (450, null, 2, 8);


--Scholl
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (500, null, 3, 9);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (600, null, 3, 10);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (300, null, 3, 11);


--Sport Vision
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (500, null, 4, 12);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (600, null, 4, 13);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (300, null, 4, 14);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (500, null, 4, 15);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (600, null, 4, 16);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (700, null, 4, 17);


--Medifit DOO
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (300, null, 9, 18);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (500, null, 9, 19);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (600, null, 9, 20);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (700, null, 9, 21);


--Ortopom
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (300, null, 10, 22);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (500, null, 10, 23);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (600, null, 10, 24);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (700, null, 10, 25);


-- INTERSPORT
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (300, null, 11, 26);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (500, null, 10, 27);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (600, null, 11, 28);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (700, null, 11, 29);


--Iron Sport
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (300, null, 12, 30);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (500, null, 12, 31);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (600, null, 12, 32);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (700, null, 12, 33);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (700, null, 12, 34);


--nasa roba
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (300, 1, null, 35);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (500, 1, null, 36);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (600, 1, null, 37);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (700, 1, null, 38);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (700, 1, null, 39);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (300, 1, null, 40);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (500, 1, null, 41);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (600, 1, null, 42);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (700, 1, null, 43);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (700, 1, null, 44);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (300, 1, null, 45);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (500, 1, null, 46);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (600, 1, null, 47);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (700, 1, null, 48);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (700, 1, null, 49);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (600, 1, null, 50);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (700, 1, null, 51);
insert into magacinska_kartica (kolicna, id_kompanije, id_poslovnog_partnera, id_artikla) values (700, 1, null, 52);


--dobavljaci
insert into cenovnik (datum_pocetka_vazenja, id_kompanije, id_poslovnog_partnera, aktivan)
	values ('2018-01-21 21:00:00', null, 1, true);
insert into cenovnik (datum_pocetka_vazenja, id_kompanije, id_poslovnog_partnera, aktivan)
	values ('2017-05-12 21:00:00', null, 2, true);
insert into cenovnik (datum_pocetka_vazenja, id_kompanije, id_poslovnog_partnera, aktivan)
	values ('2017-07-17 21:00:00', null, 3, true);
insert into cenovnik (datum_pocetka_vazenja, id_kompanije, id_poslovnog_partnera, aktivan)
	values ('2018-02-22 21:00:00', null, 4, true);

	
--dobavljaci i kupci
insert into cenovnik (datum_pocetka_vazenja, id_kompanije, id_poslovnog_partnera, aktivan)
	values ('2018-05-23 21:00:00', null, 9, true);
insert into cenovnik (datum_pocetka_vazenja, id_kompanije, id_poslovnog_partnera, aktivan)
	values ('2017-12-30 21:00:00', null, 10, true);
insert into cenovnik (datum_pocetka_vazenja, id_kompanije, id_poslovnog_partnera, aktivan)
	values ('2018-06-24 21:00:00', null, 11, true);
insert into cenovnik (datum_pocetka_vazenja, id_kompanije, id_poslovnog_partnera, aktivan)
	values ('2017-11-11 21:00:00', null, 12, true);
	
--nasi cenovnici
insert into cenovnik (datum_pocetka_vazenja, id_kompanije, id_poslovnog_partnera, aktivan)
	values ('2016-10-18 00:00:00', 1, null, false);
insert into cenovnik (datum_pocetka_vazenja, id_kompanije, id_poslovnog_partnera, aktivan)
	values ('2017-11-29 00:00:00', 1, null, false);
insert into cenovnik (datum_pocetka_vazenja, id_kompanije, id_poslovnog_partnera, aktivan)
	values ('2017-11-27 00:00:00', 1, null, false);
insert into cenovnik (datum_pocetka_vazenja, id_kompanije, id_poslovnog_partnera, aktivan)
	values ('2015-11-27 00:00:00', 1, null, false);
-- Medifit Max
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (1, 1, 1200, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (2, 1, 500, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (3, 1, 1000, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (4, 1, 3200, 10);


--Lusa Pharm
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (5, 2, 3000, 20);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (6, 2, 5000, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (7, 2, 800, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (8, 2, 1000, 10);


--School
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (9, 3, 1600, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (10, 3, 1000, 10);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (11, 3, 700, 0);


--Sport vision
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (12, 4, 5500, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (13, 4, 2000, 10);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (14, 4, 3000, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (15, 4, 2200, 30);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (16, 4, 3500, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (17, 4, 300, 0);


--Medifit doo
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (18, 5, 2990, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (19, 5, 2000, 20);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (20, 5, 3000, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (21, 5, 1000, 0);


--Ortopom
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (22, 6, 1760, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (23, 6, 110000, 20);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (24, 6, 1260, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (25, 6, 4500, 10);


--Intersport
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (26, 7, 3000, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (27, 7, 12000, 10);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (28, 7, 5000, 10);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (29, 7, 4700, 0);


--Iron sport
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (30, 8, 4300, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (31, 8, 990, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (32, 8, 12500, 10);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (33, 8, 9900, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (34, 8, 15000, 20);


--nas cenovnik
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (35, 10, 500, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (36, 10, 300, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (37, 10, 600, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (38, 10, 200, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (39, 10, 1000, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (40, 10, 5000, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (41, 10, 100, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (42, 10, 21000, 10);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (43, 10, 4500, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (44, 10, 3000, 10);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (45, 10, 8400, 10);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (46, 10, 300, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (47, 10, 450, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (48, 10, 3500, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (49, 10, 1000, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (50, 10, 500, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (51, 10, 1200, 0);
insert into stavkaucenovniku (id_artikla, id_cenovnika, cena, popust) values (52, 10, 15000, 10);


insert into nacin_placanja (naziv_tipa_placanja) values ('racun');
insert into nacin_placanja (naziv_tipa_placanja) values ('kartica');
insert into nacin_placanja (naziv_tipa_placanja) values ('gotovina');


insert into fiskalna_godina (broj_godine, aktivna, id_kompanije) values ('2018', true, 1);

-- narudzbenice ka medifit max
insert into narudzbenica (datum_narudzbenice, broj_narudzbenice, ukupan_pdv, 
	ukupna_cena_bezpdva, racun_za_uplatu, poziv_na_broj, ukupna_cena,
	poslata, id_nacina_placanja, id_fiskalne_godine, id_kompanije, id_PP,od_kupca) values 
	('2018-01-29 21:00:00', 1, 3300, 33000, '121-856642-55', '75', 36300, false, 1, 1, 1, 1, false);

insert into stavkaunarudzbenici (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdv, id_narudzbenice, id_artikla)
	values (10, 1200, 0, 12000, 1200, 10, 13200, 1, 1);
insert into stavkaunarudzbenici (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdv, id_narudzbenice, id_artikla)
	values (12, 500, 0, 6000, 600, 10, 6600, 1, 2);
insert into stavkaunarudzbenici (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdv, id_narudzbenice, id_artikla)
	values (15, 1000, 0, 15000, 1500, 10, 16500, 1, 3);
	
	
-- narudzbenice ka lusa pharm
insert into narudzbenica (datum_narudzbenice, broj_narudzbenice, ukupan_pdv, 
	ukupna_cena_bezpdva, racun_za_uplatu, poziv_na_broj, ukupna_cena,
	poslata, id_nacina_placanja, id_fiskalne_godine, id_kompanije, id_PP, od_kupca) values 
	('2018-01-25 21:00:00', 2, 13120, 131200, '784-445136-00', '36', 144320, false, 1, 1, 1, 2, false);

insert into stavkaunarudzbenici (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdv, id_narudzbenice, id_artikla)
	values (13, 3000, 20, 31200, 3120, 10, 34320, 2, 5);
insert into stavkaunarudzbenici (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdv, id_narudzbenice, id_artikla)
	values (20, 5000, 0, 100000, 10000, 10, 110000, 2, 6);
	
	
insert into narudzbenica (datum_narudzbenice, broj_narudzbenice, ukupan_pdv, 
	ukupna_cena_bezpdva, racun_za_uplatu, poziv_na_broj, ukupna_cena,
	poslata, id_nacina_placanja, id_fiskalne_godine, id_kompanije, id_PP, od_kupca) values 
	('2018-02-25 21:00:00', 3, 13120, 131200, '784-445136-00', '36', 144320, false, 1, 1, 1, 2, false);

insert into stavkaunarudzbenici (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdv, id_narudzbenice, id_artikla)
	values (13, 3000, 20, 31200, 3120, 10, 34320, 3, 5);
insert into stavkaunarudzbenici (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdv, id_narudzbenice, id_artikla)
	values (20, 5000, 0, 100000, 10000, 10, 110000, 3, 6);
	
	
--narudzbenica ka medifit doo
insert into narudzbenica (datum_narudzbenice, broj_narudzbenice, ukupan_pdv, 
	ukupna_cena_bezpdva, racun_za_uplatu, poziv_na_broj, ukupna_cena,
	poslata, id_nacina_placanja, id_fiskalne_godine, id_kompanije, id_PP, od_kupca) values 
	('2018-03-21 21:00:00', 4, 4590, 45900, '444-954120-77', '92', 50490, false, 1, 1, 1, 9, false);

insert into stavkaunarudzbenici (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdv, id_narudzbenice, id_artikla)
	values (10, 2990, 0, 29900, 2990, 10, 32890, 4, 18);
insert into stavkaunarudzbenici (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdv, id_narudzbenice, id_artikla)
	values (10, 2000, 20, 16000, 1600, 10, 17600, 4, 19);
	
	
insert into narudzbenica (datum_narudzbenice, broj_narudzbenice, ukupan_pdv, 
	ukupna_cena_bezpdva, racun_za_uplatu, poziv_na_broj, ukupna_cena,
	poslata, id_nacina_placanja, id_fiskalne_godine, id_kompanije, id_PP, od_kupca) values 
	('2018-04-21 21:00:00', 5, 4000, 40000, '444-954120-77', '92', 44000, false, 1, 1, 1, 9, false);

insert into stavkaunarudzbenici (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdv, id_narudzbenice, id_artikla)
	values (10, 3000, 0, 30000, 3000, 10, 33000, 5, 20);
insert into stavkaunarudzbenici (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdv, id_narudzbenice, id_artikla)
	values (10, 1000, 0, 10000, 1000, 10, 11000, 5, 21);

	
	
insert into Radnik (email, ime, prezime, lozinka, kontakt_telefon, adresa, id_grada, id_kompanije, role) values 
	('tamara@gmail.com', 'Tamara', 'Perlinac', 'tamara', '12345', 'Vuka Karadzica 363', 1, 1, 'ADMIN');
	
	
insert into Radnik (email, ime, prezime, lozinka, kontakt_telefon, adresa, id_grada, id_kompanije, role) values 
	('smiljana@gmail.com', 'Smiljana', 'Dragoljevic', 'smiljana', '12345', 'Bulevar Evrope 19', 1, 1, 'REGISTERED');
	
insert into Radnik (email, ime, prezime, lozinka, kontakt_telefon, adresa, id_grada, id_kompanije, role) values 
	('jelena@gmail.com', 'Jelena', 'Stanarevic', 'jelena', '12345', 'Banovic Strahinje 6', 1, 1, 'REGISTERED');
	
	
-- pristigle od treff sporta
insert into Narudzbenica (broj_narudzbenice,datum_narudzbenice,poziv_na_broj,racun_za_uplatu,ukupan_pdv,
	ukupna_cena,ukupna_cena_bezpdva,id_fiskalne_godine,id_kompanije,id_nacina_placanja,id_pp,od_kupca, poslata)
	values (6,'2017-11-29 21:00:00','23','200-123456-00',800,8800,8000,1,1,1,5,true, false);

insert into stavkaunarudzbenici (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdv, id_narudzbenice, id_artikla)
	values (10, 500, 0, 5000, 500, 10, 5500, 6, 35);		
insert into stavkaunarudzbenici (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdv, id_narudzbenice, id_artikla)
	values (10, 300, 0, 3000, 300, 10, 3300, 6, 36);	
	
	
-- pristigle od gb medic
insert into Narudzbenica (broj_narudzbenice,datum_narudzbenice,poziv_na_broj,racun_za_uplatu,ukupan_pdv,
	ukupna_cena,ukupna_cena_bezpdva,id_fiskalne_godine,id_kompanije,id_nacina_placanja,id_pp,od_kupca, poslata)
	values (7,'2018-01-21 21:00:00','23','200-123456-00',800,8800,8000,1,1,1,6,true, false);

insert into stavkaunarudzbenici (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdv, id_narudzbenice, id_artikla)
	values (10, 600, 0, 6000, 600, 10, 6600, 7, 37);		
insert into stavkaunarudzbenici (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdv, id_narudzbenice, id_artikla)
	values (10, 200, 0, 2000, 200, 10, 2200, 7, 38);	
	
	
	
--ulazne fakture - Medifit MAX
	insert into Faktura (broj_fakture,datum_fakture,datum_valute,poziv_na_broj,racun_za_uplatu,ukupanpdv,
	ukupna_cena,ukupna_cena_bezpdva,id_fiskalne_godine,id_kompanije,id_nacina_placanja,id_pp,otpremljena,primljena)
	values (1,'2017-12-12 21:00:00','2019-02-21 21:00:00','75','121-856642-55',2900,29,29900,1,1,1,1,false,true);

insert into stavkaufakturi (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdva, id_fakture, id_artikla)
	values (20, 1200, 0, 24000, 2400, 10, 26400, 1, 1);		
insert into stavkaufakturi (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdva, id_fakture, id_artikla)
	values (10, 500, 0, 5000, 500, 10, 5500, 1, 2);
	
	
insert into Faktura (broj_fakture,datum_fakture,datum_valute,poziv_na_broj,racun_za_uplatu,ukupanpdv,
	ukupna_cena,ukupna_cena_bezpdva,id_fiskalne_godine,id_kompanije,id_nacina_placanja,id_pp,otpremljena,primljena)
	values (2,'2018-01-21 21:00:00','2019-02-21 21:00:00','75','121-856642-55',42000,42680,3880,1,1,1,1,false,true);

insert into stavkaufakturi (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdva, id_fakture, id_artikla)
	values (10, 1000, 0, 10000, 1000, 10, 11000, 2, 3);		
insert into stavkaufakturi (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdva, id_fakture, id_artikla)
	values (10, 3200, 10, 28800, 2880, 10, 31680, 2, 4);
	
--ulazne fakture - sport vision
	insert into Faktura (broj_fakture,datum_fakture,datum_valute,poziv_na_broj,racun_za_uplatu,ukupanpdv,
	ukupna_cena,ukupna_cena_bezpdva,id_fiskalne_godine,id_kompanije,id_nacina_placanja,id_pp,otpremljena,primljena)
	values (3,'2016-05-22 21:00:00','2018-03-12 21:00:00','51','032-307824-55',17000,102000,85000,1,1,1,4,false,true);

insert into stavkaufakturi (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdva, id_fakture, id_artikla)
	values (10, 5500, 0, 55000, 11000, 20, 66000, 3, 12);		
insert into stavkaufakturi (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdva, id_fakture, id_artikla)
	values (10, 3000, 0, 30000, 6000, 20, 36000, 3, 14);
	
--ulazne fakture - Medifit DOO
	insert into Faktura (broj_fakture,datum_fakture,datum_valute,poziv_na_broj,racun_za_uplatu,ukupanpdv,
	ukupna_cena,ukupna_cena_bezpdva,id_fiskalne_godine,id_kompanije,id_nacina_placanja,id_pp,otpremljena,primljena)
	values (4,'2018-01-21 21:00:00','2019-02-21 21:00:00','23','444-954120-77',5990,65890,32900,1,1,1,9,false,true);

insert into stavkaufakturi (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdva, id_fakture, id_artikla)
	values (10, 2990, 0, 29900, 2990, 10, 32890, 4, 18);		
insert into stavkaufakturi (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdva, id_fakture, id_artikla)
	values (10, 3000, 0, 30000, 3000, 10, 33000, 4, 20);
	
insert into Faktura (broj_fakture,datum_fakture,datum_valute,poziv_na_broj,racun_za_uplatu,ukupanpdv,
	ukupna_cena,ukupna_cena_bezpdva,id_fiskalne_godine,id_kompanije,id_nacina_placanja,id_pp,otpremljena,primljena)
	values (5,'2018-01-21 21:00:00','2019-02-21 21:00:00','23','444-954120-77',6990,75890,43900,1,1,1,9,false,true);

insert into stavkaufakturi (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdva, id_fakture, id_artikla)
	values (10, 2990, 0, 29900, 2990, 10, 32890, 5, 18);		
insert into stavkaufakturi (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdva, id_fakture, id_artikla)
	values (10, 3000, 0, 30000, 3000, 10, 33000, 5, 20);
insert into stavkaufakturi (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdva, id_fakture, id_artikla)
	values (10, 1000, 0, 10000, 1000, 10, 11000, 5, 21);
	
--ulazne fakture - Iron Sport
	insert into Faktura (broj_fakture,datum_fakture,datum_valute,poziv_na_broj,racun_za_uplatu,ukupanpdv,
	ukupna_cena,ukupna_cena_bezpdva,id_fiskalne_godine,id_kompanije,id_nacina_placanja,id_pp,otpremljena,primljena)
	values (6,'2018-01-21 21:00:00','2019-02-21 21:00:00','54','554-459210-100',1519,151900,153419,1,1,1,12,false,true);

insert into stavkaufakturi (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdva, id_fakture, id_artikla)
	values (10, 4300, 0, 43000, 430, 10, 43430, 6, 30);		
insert into stavkaufakturi (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdva, id_fakture, id_artikla)
	values (10, 990, 0, 9900, 99, 10, 9999, 6, 31);
insert into stavkaufakturi (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdva, id_fakture, id_artikla)
	values (10, 9900, 0, 99000, 990, 10, 99990, 6, 33);
	
--primljene narudzbine -Ortopom
	insert into Narudzbenica (broj_narudzbenice,datum_narudzbenice,poziv_na_broj,racun_za_uplatu,ukupan_pdv,
	ukupna_cena,ukupna_cena_bezpdva,id_fiskalne_godine,id_kompanije,id_nacina_placanja,id_pp,od_kupca, poslata)
	values (8,'2018-01-21 21:00:00','21','101-105876-84',3020,33220,36240,1,1,1,10,true, false);

insert into stavkaunarudzbenici (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdv, id_narudzbenice, id_artikla)
	values (10, 1760, 0, 17600, 1760, 10, 19360, 8, 22);		
insert into stavkaunarudzbenici (ukupna_kolicina, jedinicna_cena, 
	popust, osnovica, iznospdva, stopapdva, jedinicna_cena_sapdv, id_narudzbenice, id_artikla)
	values (10, 1260, 0, 12600, 1260, 10, 13860, 8, 24);	

