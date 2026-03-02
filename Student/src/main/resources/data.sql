
INSERT INTO department (id, name) VALUES (1, 'Computer Science');
INSERT INTO department (id, name) VALUES (2, 'Information Technology');
INSERT INTO department (id, name) VALUES (3, 'Data Science');


-- Students in Computer Science (Dept 1)
INSERT INTO student (id, name, department_id) VALUES (1, 'Siddharth', 1);
INSERT INTO student (id, name, department_id) VALUES (2, 'Rahul', 1);
INSERT INTO student (id, name, department_id) VALUES (3, 'Priya', 1);

-- Students in Information Technology (Dept 2)
INSERT INTO student (id, name, department_id) VALUES (4, 'Amit', 2);
INSERT INTO student (id, name, department_id) VALUES (5, 'Neha', 2);

-- Students in Data Science (Dept 3)
INSERT INTO student (id, name, department_id) VALUES (6, 'Vikram', 3);


-- Courses for (Student 1)
INSERT INTO course (id, title, student_id) VALUES (1, 'Spring Boot & Microservices', 1);
INSERT INTO course (id, title, student_id) VALUES (2, 'Advanced Java Multithreading', 1);
INSERT INTO course (id, title, student_id) VALUES (3, 'Event-Driven Architecture with Kafka', 1);
INSERT INTO course (id, title, student_id) VALUES (4, 'React Frontend Development', 1);

-- Courses for (Student 2)
INSERT INTO course (id, title, student_id) VALUES (5, 'Database Normalization', 2);
INSERT INTO course (id, title, student_id) VALUES (6, 'Operating Systems Concepts', 2);

-- Courses for (Student 3)
-- no courses

-- Courses for (Student 4)
INSERT INTO course (id, title, student_id) VALUES (7, 'Django Web Framework', 4);
INSERT INTO course (id, title, student_id) VALUES (8, 'Python Data Structures', 4);

-- Courses for Neha (Student 5)
INSERT INTO course (id, title, student_id) VALUES (9, 'Enterprise Security', 5);

-- Courses for Vikram (Student 6)
INSERT INTO course (id, title, student_id) VALUES (10, 'DBMS & Keys', 6);