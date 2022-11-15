DROP TABLE IF EXISTS account CASCADE;
DROP TABLE IF EXISTS doubleGame CASCADE;
DROP TABLE IF EXISTS singleGame CASCADE;
DROP TABLE IF EXISTS trainingGame CASCADE;
DROP TABLE IF EXISTS court CASCADE;
DROP TABLE IF EXISTS player CASCADE;
DROP TABLE IF EXISTS person CASCADE;
DROP TABLE IF EXISTS sequences CASCADE;


CREATE TABLE account
(
    idAccount INT NOT NULL AUTO_INCREMENT,
    login VARCHAR(30) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(30) NOT NULL,
    PRIMARY KEY (idAccount,login),
    UNIQUE (login)
);
CREATE TABLE person
(
    idP INT NOT NULL,
    lastname VARCHAR(40) NOT NULL,
    firstname VARCHAR(30) NOT NULL,
    birthDate DATE NOT NULL,
    birthPlace VARCHAR(255) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    PRIMARY KEY (idP)
);
CREATE TABLE player
(
    idP    INT         NOT NULL,
    ranking     INT         NOT NULL,
    bestRanking INT         NOT NULL,
    nationality VARCHAR(20) NOT NULL,
    height      INT         NOT NULL,
    weight      INT         NOT NULL ,
    startCareer DATE        NOT NULL,
    hand        VARCHAR(30) NOT NULL,
    trainerId   INT         ,
    PRIMARY KEY (idP),
    FOREIGN KEY (idP) REFERENCES person(idP) ON DELETE CASCADE,
    FOREIGN KEY (trainerId) REFERENCES person(idP) ON DELETE CASCADE
);

CREATE TABLE court
(
    idC     INT         NOT NULL auto_increment,
    name    VARCHAR(30) NOT NULL,
    PRIMARY KEY (idC)
);

CREATE TABLE doubleGame
(
    idT        INT               NOT NULL auto_increment,
    teamOnePlayerOneId  INT         NOT NULL,
    teamTwoPlayerOneId  INT         NOT NULL,
    teamOnePlayerTwoId  INT         NOT NULL,
    teamTwoPlayerTwoId  INT         NOT NULL,
    scoreOne            VARCHAR(100) ,
    scoreTwo            VARCHAR(100) ,
    gender               VARCHAR(10) NOT NULL,
    courtId             INT         NOT NULL,
    endDate             TIMESTAMP   ,
    startDate           TIMESTAMP   NOT NULL,
    PRIMARY KEY (idT),
    FOREIGN KEY (teamOnePlayerOneId) REFERENCES player (idP) ON DELETE CASCADE,
    FOREIGN KEY (teamTwoPlayerOneId) REFERENCES player (idP) ON DELETE CASCADE,
    FOREIGN KEY (teamOnePlayerTwoId) REFERENCES player (idP) ON DELETE CASCADE,
    FOREIGN KEY (teamTwoPlayerTwoId) REFERENCES player (idP) ON DELETE CASCADE,
    FOREIGN KEY (courtId) REFERENCES court (idC) ON DELETE CASCADE
);
CREATE TABLE singleGame
(
    idT        INT                      NOT NULL AUTO_INCREMENT,
    playerOneId         INT             NOT NULL ,
    playerTwoId         INT             NOT NULL ,
    scoreOne            VARCHAR(100)    ,
    scoreTwo            VARCHAR(100)    ,
    gender              VARCHAR(10)     NOT NULL,
    courtId             INT             NOT NULL ,
    endDate             TIMESTAMP       ,
    startDate           TIMESTAMP       NOT NULL,
    PRIMARY KEY (idT),
    FOREIGN KEY (playerOneId) REFERENCES player(idP) ON DELETE CASCADE,
    FOREIGN KEY (playerTwoId) REFERENCES player(idP) ON DELETE CASCADE,
    FOREIGN KEY (courtId) REFERENCES court(idC) ON DELETE CASCADE

);
CREATE TABLE trainingGame
(
    idT  INT         NOT NULL auto_increment,
    bookerId        INT         NOT NULL,
    courtId         INT         NOT NULL,
    isValidated     BOOLEAN,
    endDate         TIMESTAMP ,
    startDate       TIMESTAMP not null,
    PRIMARY KEY (idT),
    FOREIGN KEY (bookerId) REFERENCES person(idP) ON DELETE CASCADE,
    FOREIGN KEY (courtId) REFERENCES court(idC) ON DELETE CASCADE,
    UNIQUE (courtId,startDate)
);

CREATE TABLE sequences (
                           next_val INT NOT NULL DEFAULT 1,
                           sequence_name VARCHAR(255) NOT NULL,
                           PRIMARY KEY (sequence_name)
);






