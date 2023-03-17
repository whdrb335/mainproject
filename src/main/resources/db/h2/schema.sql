CREATE TABLE IF NOT EXISTS GYM (
    gym_id bigint NOT NULL AUTO_INCREMENT,
    gymName varchar(100) NOT NULL ,
    address varchar(100) NOT NULL,
    phoneNumber varchar(100) NOT NULL,
    businessHours varchar(100) NOT NULL,
    latitude double NOT NULL,
    longitude double NOt NULL,
    PRIMARY KEY (gym_id)
);