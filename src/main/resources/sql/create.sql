CREATE TABLE account (
                         idAccount INT NOT NULL AUTO_INCREMENT,
                         login VARCHAR(20) NOT NULL UNIQUE,
                         password VARCHAR(255) NOT NULL,
                         role VARCHAR(30) NOT NULL,
                         PRIMARY KEY (idAccount,login)
);
CREATE TABLE person (
                        idP INT NOT NULL,
                        lastname VARCHAR(40) NOT NULL,
                        firstname VARCHAR(30) NOT NULL,
                        birthDate DATE NOT NULL,
                        birthPlace VARCHAR(20) NOT NULL,
                        gender VARCHAR(10) NOT NULL,
                        PRIMARY KEY (idP)
);
CREATE TABLE player
(
    idP    INT         NOT NULL references person(idP),
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
CREATE TABLE doubleGame
(
    idT        INT               NOT NULL auto_increment,
    teamOnePlayerOneId  INT         NOT NULL references player(idP),
    teamOnePlayerTwoId  INT         NOT NULL references player(idP),
    teamTwoPlayerOneId  INT         NOT NULL references player(idP),
    teamTwoPlayerTwoId  INT         NOT NULL references player(idP),
    scoreOne            VARCHAR(50) ,
    scoreTwo            VARCHAR(50) ,
    gender               VARCHAR(10) NOT NULL,
    courtId             INT         NOT NULL references court(idC),
    endDate             TIMESTAMP        ,
    startDate           TIMESTAMP        NOT NULL,
    PRIMARY KEY (idT)
);
CREATE TABLE court
(
    idC     INT         NOT NULL auto_increment,
    name    VARCHAR(30) NOT NULL,
    PRIMARY KEY (idC)
);
CREATE TABLE singleGame
(
    idT        INT                   NOT NULL auto_increment,
    playerOneId         INT             NOT NULL references player(idP),
    playerTwoId         INT             NOT NULL references player(idP),
    scoreOne            VARCHAR(50)     ,
    scoreTwo            VARCHAR(50)     ,
    gender               VARCHAR(10)     NOT NULL,
    courtId             INT     NOT NULL references court(idC),
    endDate             TIMESTAMP            ,
    startDate           TIMESTAMP            NOT NULL,
    PRIMARY KEY (idT)
);
CREATE TABLE trainingGame
(
    idT  INT         NOT NULL auto_increment,
    bookerId        INT         NOT NULL references person(idP),
    endDate         TIMESTAMP ,
    startDate       TIMESTAMP not null,
    PRIMARY KEY (idT)
);

CREATE TABLE sequences (
                           next_val INT NOT NULL default 1,
                           sequence_name VARCHAR(255) NOT NULL,
                           PRIMARY KEY (sequence_name)
);

insert into account (login, password, role) values ('admin', 'admin', 'admin');
insert into account (login, password, role) values ('user', 'user', 'user');



