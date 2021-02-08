--Creating the database
CREATE DATABASE BeranaUsers
--Creating users table
CREATE TABLE users(
firstname varchar(25) not null,
lastname varchar (25) not null,
email varchar(25) not null primary key,
password varchar(25) not null,
gender char not null,
postNo int DEFAULT 0
)
--Creating posts table
CREATE TABLE posts(
postID int not null IDENTITY(1,1) primary key
,email varchar(25) not null foreign key references users(email)
,post varchar(max) DEFAULT 'Nothing here...',
postDate datetime DEFAULT GETDATE(),

)
--Creating follow table
CREATE TABLE follow(
 followID int not null IDENTITY(1,1) primary key
,email varchar(25) not null foreign key references users(email)
,followEmail varchar(25) not null
)
--Creating profilePictures table
CREATE TABLE profilePictures
(
    picID INT IDENTITY(1,1) NOT NULL,
    email varchar(25) not null foreign key references users(email),
    Files VARBINARY(MAX) NOT NULL
)