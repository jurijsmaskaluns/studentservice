create schema student_service;
drop table courses;

create table courses(
    c_id bigint not null auto_increment,
    c_name varchar(150) not null,
    primary key (c_id)
);

insert into courses(c_name) value ('Java 1');
insert into courses(c_name) value ('Java 2');
insert into courses(c_name) value ('Java 3');

create table studentCourse(
    id bigint not null auto_increment,
    student_id varchar(255),
    course_id bigint(255),
    primary key (id),
    foreign key (course_id) references courses(c_id),
    foreign key (student_id) references students(s_id)

);

create table students(
    s_id varchar(255) not null
    lastname varchar(150) not null,
    name     varchar(40)  not null,
    primary key (s_id)

);