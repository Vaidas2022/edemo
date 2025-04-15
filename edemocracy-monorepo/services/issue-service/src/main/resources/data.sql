-- Pradinės seniūnijos (elderships)
INSERT INTO eldership (id, code, name) VALUES 
  ('11111111-1111-1111-1111-111111111111', 'vilnius_oldtown', 'Vilniaus Senamiestis'),
  ('22222222-2222-2222-2222-222222222222', 'kaunas_centre', 'Kauno Centras'),
  ('33333333-3333-3333-3333-333333333333', 'klaipeda_north', 'Klaipėdos Šiaurinė');

-- Pradinės problemos
INSERT INTO issues (id, title, description, eldership_id, active) VALUES 
  ('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1', 'Šaligatvis duobėtas', 'Nuo Gedimino g. 15 iki 21, labai pavojinga vaikščioti.', '11111111-1111-1111-1111-111111111111', true),
  ('aaaaaaa2-aaaa-aaaa-aaaa-aaaaaaaaaaa2', 'Per mažai dviračių stovų', 'Kauno centre nėra kur palikti dviračio.', '22222222-2222-2222-2222-222222222222', true);
