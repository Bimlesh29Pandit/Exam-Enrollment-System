-- Insert Subjects
--INSERT INTO subject (subject_id, subject_name) VALUES ('S101', 'Java Programming');
--INSERT INTO subject (subject_id, subject_name) VALUES ('S102', 'Database Systems');
--INSERT INTO subject (subject_id, subject_name) VALUES ('S103', 'Operating Systems');

-- Insert Students
--INSERT INTO student (registration_id, student_name) VALUES ('U101', 'Alice');
--INSERT INTO student (registration_id, student_name) VALUES ('U102', 'Bob');
--INSERT INTO student (registration_id, student_name) VALUES ('U103', 'Charlie');

---- Link Students to Subjects (Enrollments)
--INSERT INTO student_subjects (student_registration_id, subjects_subject_id) VALUES ('U101', 'S101');
--INSERT INTO student_subjects (student_registration_id, subjects_subject_id) VALUES ('U101', 'S102');
--INSERT INTO student_subjects (student_registration_id, subjects_subject_id) VALUES ('U102', 'S101');
--INSERT INTO student_subjects (student_registration_id, subjects_subject_id) VALUES ('U103', 'S103');

-- Insert Exams
INSERT INTO exam (exam_id, subejct_subject_id) VALUES ('E1001', 'S101');
INSERT INTO exam (exam_id, subejct_subject_id) VALUES ('E1002', 'S102');
INSERT INTO exam (exam_id, subejct_subject_id) VALUES ('E1003', 'S103');

---- Register Students for Exams
--INSERT INTO exam_students (exam_exam_id, students_registration_id) VALUES ('E1001', 'U101');
--INSERT INTO exam_students (exam_exam_id, students_registration_id) VALUES ('E1001', 'U102');
--INSERT INTO exam_students (exam_exam_id, students_registration_id) VALUES ('E1003', 'U103');
--
---- Update Student exam list as well (for bidirectional mapping)
--INSERT INTO student_exams (student_registration_id, exams_exam_id) VALUES ('U101', 'E1001');
--INSERT INTO student_exams (student_registration_id, exams_exam_id) VALUES ('U102', 'E1001');
--INSERT INTO student_exams (student_registration_id, exams_exam_id) VALUES ('U103', 'E1003');
