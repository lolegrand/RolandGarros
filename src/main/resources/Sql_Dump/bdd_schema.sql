# syntaxe mysql
DROP TABLE IF EXISTS account;
CREATE TABLE account (
                         idAccount INT NOT NULL AUTO_INCREMENT,
                         login VARCHAR(20) NOT NULL,
                         password VARCHAR(20) NOT NULL,
                         role VARCHAR(30) NOT NULL,
                         PRIMARY KEY (idAccount,login)
);

DROP TABLE IF EXISTS player CASCADE;
DROP TABLE IF EXISTS person;
CREATE TABLE person (
                        idP INT NOT NULL AUTO_INCREMENT,
                        lastname VARCHAR(40) NOT NULL,
                        firstname VARCHAR(30) NOT NULL,
                        birthDate DATE NOT NULL,
                        birthPlace VARCHAR(20) NOT NULL,
                        PRIMARY KEY (idP)
);

DROP TABLE IF EXISTS player CASCADE;
CREATE TABLE player
(
    idP    INT         NOT NULL AUTO_INCREMENT references person(idP),
    ranking     INT         NOT NULL,
    bestRanking INT         NOT NULL,
    nationality VARCHAR(20) NOT NULL,
    height      INT         NOT NULL,
    weight      INT         NOT NULL ,
    startCareer DATE        NOT NULL,
    hand        VARCHAR(30) NOT NULL,
    trainerId   INT         NOT NULL references person(idP),
    PRIMARY KEY (idP)
);


DROP TABLE IF EXISTS doubleGame CASCADE;
CREATE TABLE doubleGame
(
    idT        INT               NOT NULL auto_increment,
    teamOnePlayerOneId  INT         NOT NULL references player(idP),
    teamOnePlayerTwoId  INT         NOT NULL references player(idP),
    teamTwoPlayerOneId  INT         NOT NULL references player(idP),
    teamTwoPlayerTwoId  INT         NOT NULL references player(idP),
    scoreOne            VARCHAR(50) ,
    scoreTwo            VARCHAR(50) ,
    genre               VARCHAR(30) NOT NULL,
    courtId             INT         NOT NULL references court(idT),
    endDate             TIMESTAMP        ,
    startDate           TIMESTAMP        NOT NULL,
    PRIMARY KEY (idT)
);

DROP TABLE IF EXISTS singleGame CASCADE;
CREATE TABLE singleGame
(
    idT        INT                   NOT NULL auto_increment,
    playerOneId         INT             NOT NULL references player(idP),
    playerTwoId         INT             NOT NULL references player(idP),
    scoreOne            VARCHAR(50)     ,
    scoreTwo            VARCHAR(50)     ,
    genre               VARCHAR(30)     NOT NULL,
    courtId             INT     NOT NULL references court(idT),
    endDate             TIMESTAMP            ,
    startDate           TIMESTAMP            NOT NULL,
    PRIMARY KEY (idT)
);

DROP TABLE IF EXISTS trainingGame CASCADE;
CREATE TABLE trainingGame
(
    idT  INT         NOT NULL auto_increment,
    bookerId        INT         NOT NULL references person(idP),
    endDate         TIMESTAMP ,
    startDate       TIMESTAMP not null,
    PRIMARY KEY (idT)
);

DROP TABLE IF EXISTS court CASCADE;
CREATE TABLE court
(
    idT     INT         NOT NULL auto_increment,
    name    VARCHAR(30) NOT NULL,
    PRIMARY KEY (idT)
);

DROP TABLE IF EXISTS SEQUENCE;
CREATE TABLE SEQUENCE (
                          next_val INT NOT NULL default 1,
                          sequence_name VARCHAR(255) NOT NULL,
                          PRIMARY KEY (sequence_name)
);

truncate table SEQUENCE;
truncate table account;
truncate table person;
truncate table player;
truncate table doubleGame;
truncate table singleGame;
truncate table trainingGame;
truncate table court;


