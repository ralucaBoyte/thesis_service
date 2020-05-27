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

insert into attendance_info (course_id, activity_id, professor_id, week, created_at, remaining_time) values
(1, 1, 'dana', 2, '2020-05-25 12:08:45.289179', 15),
(1, 2, 'dana', 2, '2020-05-25 12:08:45.289179', 15),
(1, 3, 'dana', 2, '2020-05-25 12:08:45.289179', 15),
(2, 1, 'profesor1', 3, '2020-05-25 12:08:45.289179', 10),
(2, 2, 'profesor1', 3, '2020-05-25 12:08:45.289179', 10),
(2, 3, 'profesor1', 3, '2020-05-25 12:08:45.289179', 10),
(3, 1, 'dana', 10, '2020-05-25 12:08:45.289179', 10),
(3, 2, 'dana', 10, '2020-05-25 12:08:45.289179', 10),
(3, 3, 'profesor1', 10, '2020-05-25 12:08:45.289179', 10);

insert into attendance(student_id, created_at, attendance_info_id) values
('roxana', '2020-05-25 12:10:45.289179', 1),
('student1', '2020-05-25 12:12:45.289179', 1),
('student2', '2020-05-25 12:13:45.289179', 1),
('student3', '2020-05-25 12:10:45.289179', 1),
('roxana', '2020-05-25 12:15:45.289179', 2),
('student2', '2020-05-25 12:15:45.289179', 2),
('student3', '2020-05-25 12:15:45.289179', 2),
('roxana', '2020-05-25 12:11:45.289179', 3),
('student1', '2020-05-25 12:12:45.289179', 3),
('student2', '2020-05-25 12:13:45.289179', 3);
