create table activity (
    id serial,
    type varchar(100),
    constraint pk_activity_id primary key (id)
);

create table specialization (
  id serial,
  name varchar(256),
  language varchar(256),
  constraint pk_specialization_id primary key (id)
);

create table subject (
  id serial,
  name varchar(256),
  credits int,
  year int,
  specialization_id serial,
  constraint pk_subject_id primary key (id),
  constraint fk_subject_spec_id foreign key (specialization_id) references specialization (id)
);


create table attendance_info (
  id serial,
  course_id int,
  activity_id int,
  professor_id varchar(128),
  week int,
  created_at timestamp,
  remaining_time int, --minutes
  constraint pk_attendance_info primary key (id),
  constraint fk_attendance_info_activity foreign key (activity_id) references activity(id),
  constraint fk_attendance_info_subject foreign key (course_id) references subject(id)

);

create table attendance (
  id serial,
  student_id varchar(128),
  created_at timestamp,
  attendance_info_id serial,
  constraint pk_attendance primary key (id),
  constraint fk_attendance_info foreign key (attendance_info_id) references attendance_info(id)
);


