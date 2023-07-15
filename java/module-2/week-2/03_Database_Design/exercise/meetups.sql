--** Drop tables 


--**Tables

CREATE TABLE member(
	member_number serial NOT NULL,
	last_name varchar(100) NOT NULL,
	first_name varchar(100) NOT NULL,
	email_address varchar(100) NOT NULL,
	phone_number Bigint Null,
	birthdate date NOT null,
	email_reminders boolean
	);


CREATE TABLE member_interest (
	member_number int NOT NULL,
	group_number int NOT NULL
	);

CREATE TABLE interest_group (
	group_number serial NOT NULL,
	group_name varchar(100) NOT NULL UNIQUE
	);

CREATE TABLE member_event (
	member_number int NOT NULL,
	event_number int NOT NULL
	);

CREATE TABLE event(
	event_number serial NOT NULL,
	event_name varchar(100) NOT NULL,
	description varchar(300) NULL,
	start_date date NOT NULL,
	time time NOT NULL,
	duration_min int NOT null CHECK (duration_min >= 30),
	num_of_members int Null 
	);

--**Inserts 

INSERT INTO member (last_name, first_name, email_address, phone_number, birthdate, email_reminders)
VALUES('Smith','John', 'John@smith.com', 5555555555,'2000-01-01', false),
	('Griffin','Stewie', 'SG@aol.com', 5555555555,'2000-01-01', false),
	('Blue','Bell', 'bellb@gmail.com', 5555555555,'2000-01-01', false),
	('Wilson','Sara', '123@yahoo.com', 5555555555,'2000-01-01', false),
	('Apple','Christy', 'fakeemail@outlook.com', 5555555555,'2000-01-01', false),
	('Berry','Mary', 'gamergirl12@hotmail.com', 5555555555,'2000-01-01', false),
	('Lee','Sammy', 'idontknow@google.com', 5555555555,'2000-01-01', false),
	('Simpson','Homer', 'tvshows19@fake.com', 5555555555,'2000-01-01', false);

INSERT INTO interest_group (group_name)
VALUES ('I'll Eat That),
	('Movie Goers'),
	('Sports Fans');

INSERT INTO event (event_name, description, )
VALUES ('I'll Eat That),
	('Movie Goers'),
	('Sports Fans');
	