DROP TABLE IF EXISTS teacher CASCADE;
create table teacher
(
  id        bigint serial not null,
  name      varchar2(255),
  school_id bigint
);

DROP TABLE IF EXISTS student CASCADE;
create table student
(
  id        bigint serial not null,
  name      varchar2(255),
  class_id  bigint,
  school_id bigint
);

DROP TABLE IF EXISTS class CASCADE;
create table class
(
  id        bigint serial not null,
  name      varchar2(255),
  school_id bigint
);

DROP TABLE IF EXISTS school CASCADE;
create table school
(
  id   bigint serial not null,
  name varchar2(255)
);

DROP TABLE IF EXISTS class_teacher CASCADE;
create table class_teacher
(
  teacher_id bigint not null,
  class_id   bigint not null
);

