CREATE TABLE USER (	
	User_ID int PRIMARY KEY NOT NULL auto_increment,
    Username varchar(45) NOT NULL unique,	
    Password varchar(45) NOT NULL,
    Balance int default 0    
);

CREATE TABLE CUPCAKE_BOTTOM (
	B_ID int primary key NOT NULL auto_increment,
    Bottom varchar(45) NOT NULL,
	Price int NOT NULL
);

CREATE TABLE CUPCAKE_TOPPING (
	T_ID int primary key Not null auto_increment,
	Topping varchar(45) NOT NULL,
	Price int NOT NULL
    );