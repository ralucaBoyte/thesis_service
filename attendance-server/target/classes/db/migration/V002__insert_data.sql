insert into activity(type) values
('Laborator'),
('Curs'),
('Seminar');

insert into specialization(name, language ) values
('MLR0001', 'engleza'),
('MLR0002', 'engleza'),
('MLR0003', 'engleza');

insert into subject(name, credits, year, specialization_id) values
('FLP', 6, 1, 1),
('ASC', 6, 1, 1),
('AI', 6, 2, 2),
('VVSS', 6, 3, 3);
