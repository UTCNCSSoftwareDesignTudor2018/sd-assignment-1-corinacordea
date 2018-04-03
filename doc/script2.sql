INSERT INTO `studentsdb`.`students` (`idstudents`, `students_name`, `students_card_number`, `students_personal_numerical_code`, `students_address`, `students_group`, `students_username`, `students_password`) VALUES ('1', 'Cordea Corina', '1100', '4747', 'Ponor', '30432', 'corina', '123');
INSERT INTO `studentsdb`.`students` (`idstudents`, `students_name`, `students_card_number`, `students_personal_numerical_code`, `students_address`, `students_group`, `students_username`, `students_password`) VALUES ('2', 'Luca Matei', '1524', '5412', 'Bistrita', '30432', 'matei', '123');
INSERT INTO `studentsdb`.`students` (`idstudents`, `students_name`, `students_card_number`, `students_personal_numerical_code`, `students_address`, `students_group`, `students_username`, `students_password`) VALUES ('3', 'Pop Ioana', '2156', '4025', 'Cluj-Napoca', '30434', 'ioana', '123');
INSERT INTO `studentsdb`.`students` (`idstudents`, `students_name`, `students_card_number`, `students_personal_numerical_code`, `students_address`, `students_group`, `students_username`, `students_password`) VALUES ('4', 'Dan Mihai', '1343', '5412', 'Alba-Iulia', '30431', 'mihai', '123');

INSERT INTO `studentsdb`.`teachers` (`idteachers`, `teachers_name`, `teachers_username`, `teachers_password`) VALUES ('1', 'Ivan Mircea', 'ivan', '123');
INSERT INTO `studentsdb`.`teachers` (`idteachers`, `teachers_name`, `teachers_username`, `teachers_password`) VALUES ('2', 'Pop Claudia', 'pop', '123');
INSERT INTO `studentsdb`.`teachers` (`idteachers`, `teachers_name`, `teachers_username`, `teachers_password`) VALUES ('3', 'Colesa Adrian', 'colesa', '123');

INSERT INTO `studentsdb`.`exams` (`idexams`, `grade`) VALUES ('1', '1');
INSERT INTO `studentsdb`.`exams` (`idexams`, `grade`) VALUES ('2', '2');
INSERT INTO `studentsdb`.`exams` (`idexams`, `grade`) VALUES ('3', '3');
INSERT INTO `studentsdb`.`exams` (`idexams`, `grade`) VALUES ('4', '4');
INSERT INTO `studentsdb`.`exams` (`idexams`, `grade`) VALUES ('5', '5');
INSERT INTO `studentsdb`.`exams` (`idexams`, `grade`) VALUES ('6', '6');
INSERT INTO `studentsdb`.`exams` (`idexams`, `grade`) VALUES ('7', '7');
INSERT INTO `studentsdb`.`exams` (`idexams`, `grade`) VALUES ('8', '8');
INSERT INTO `studentsdb`.`exams` (`idexams`, `grade`) VALUES ('9', '9');
INSERT INTO `studentsdb`.`exams` (`idexams`, `grade`) VALUES ('10', '10');
INSERT INTO `studentsdb`.`exams` (`idexams`, `grade`) VALUES ('11', '0');

INSERT INTO `studentsdb`.`courses` (`idcourses`, `name`, `teachers_idteachers`) VALUES ('1', 'NC', '1');
INSERT INTO `studentsdb`.`courses` (`idcourses`, `name`, `teachers_idteachers`) VALUES ('2', 'PT', '2');
INSERT INTO `studentsdb`.`courses` (`idcourses`, `name`, `teachers_idteachers`) VALUES ('3', 'OS', '3');

INSERT INTO `studentsdb`.`enrolments` (`courses_idcourses`, `students_idstudents`, `exams_idexams`) VALUES ('1', '1', '8');
INSERT INTO `studentsdb`.`enrolments` (`courses_idcourses`, `students_idstudents`, `exams_idexams`) VALUES ('1', '2', '7');
INSERT INTO `studentsdb`.`enrolments` (`courses_idcourses`, `students_idstudents`, `exams_idexams`) VALUES ('1', '3', '8');
INSERT INTO `studentsdb`.`enrolments` (`courses_idcourses`, `students_idstudents`, `exams_idexams`) VALUES ('2', '1', '10');
INSERT INTO `studentsdb`.`enrolments` (`courses_idcourses`, `students_idstudents`, `exams_idexams`) VALUES ('3', '2', '9');
INSERT INTO `studentsdb`.`enrolments` (`courses_idcourses`, `students_idstudents`, `exams_idexams`) VALUES ('3', '4', '6');