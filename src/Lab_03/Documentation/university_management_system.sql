DROP DATABASE IF EXISTS university_management_system;
CREATE DATABASE IF NOT EXISTS university_management_system;
USE university_management_system;

CREATE TABLE `course` (
  `course_code` varchar(10) NOT NULL,
  `course_name` varchar(30) NOT NULL,
  `lecturer` int NOT NULL,
  `course_id` int NOT NULL
);


INSERT INTO `course` (`course_code`, `course_name`, `lecturer`, `course_id`) VALUES
('SENG 11111', 'Introduction to Programming', 11001, 1),
('SENG 11112', 'Fndamantales of Engineering', '11002', 2),
('SENG 11123', 'Project Management', 11002, 3)
;

CREATE TABLE `studentsubject` (
  `course_id` varchar(10) NOT NULL,
  `ids` int(11) NOT NULL
);

INSERT INTO `studentsubject` (`course_id`, `ids`) VALUES
('1', '2'),
('1', '3'),
('2', '2'),
('3', '3'),
('3', '1'),
('4', '3'),
('4', '1'),
('5', '3'),
('5', '2'),
('6', '3'),
('6', '2'),
('7', '3')
;

CREATE TABLE `lecturer` (
  `ids` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `age` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `course` varchar(30) DEFAULT NULL
);



INSERT INTO `lecturer` (`ids`, `name`, `age`, `username`, `password`, `course`) VALUES
(11001, 'Dr. Nalin Warnajith', 0, 'nwarnajith', '123456', '1'),
(11002, 'Dr. Tiroshan Madushanka', 0, 'Tiroshan', '123456', '2'),
(11003, 'Dr. Isuru Hewapathirana', 0, 'Isuru', '123456', '3'),
(11004, 'Dr. Lankeshwara Munasinghe', 0, 'Munasinghe', '123456', '3');


CREATE TABLE `student` (
  `ids` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `age` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
);



INSERT INTO `student` (`ids`, `name`,`age`,`username`, `password`) VALUES
(1, 'Padma Gnanapriya',23, 'Padma', '123456'),
(2, 'Chintha Chathuranga', 21, 'Chinthaka', '123456'),
(3, 'Pasindu Chinthana', 22, 'pasindu', '123456'),
(4, 'Chamodi Jayodya',23, 'Chamodi', '123456'),
(5, 'Bimali Karunageewa', 20, 'Bimali', '123456'),
(6, 'Githmi Anjana', 22, 'Githmi', '123456'),
(7, 'Sunanda Karunajeewa', 24, 'sunanda', '123456');


ALTER TABLE `studentsubject`
  ADD PRIMARY KEY (`course_id`, `ids`);


ALTER TABLE `course`
  ADD PRIMARY KEY (`course_code`),
  ADD KEY `lecturer` (`lecturer`);


ALTER TABLE `lecturer`
  ADD PRIMARY KEY (`ids`);

ALTER TABLE `student`
  ADD PRIMARY KEY (`ids`);


ALTER TABLE `course`
  ADD CONSTRAINT `course_ibfk_1` FOREIGN KEY (`lecturer`) REFERENCES `lecturer` (`ids`);
