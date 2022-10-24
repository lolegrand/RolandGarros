# syntaxe mysql
# Account(login,password,role)
DROP TABLE IF EXISTS account;
CREATE TABLE account (
                         idAccount INT NOT NULL AUTO_INCREMENT,
                         login VARCHAR(20) NOT NULL,
                         password VARCHAR(20) NOT NULL,
                         role VARCHAR(30) NOT NULL,
                         PRIMARY KEY (idAccount,login)
);

# PERSON(lastname,firstname,birthDate,birthPlace)
DROP TABLE IF EXISTS person;
CREATE TABLE person (
                        idP INT NOT NULL AUTO_INCREMENT,
                        lastname VARCHAR(40) NOT NULL,
                        firstname VARCHAR(30) NOT NULL,
                        birthDate DATE NOT NULL,
                        birthPlace VARCHAR(20) NOT NULL,
                        PRIMARY KEY (idP)
);



#Player (ranking, bestRanking, nationality, height, weight, startCareer, hand, trainer)
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



#DoubleGame (teamOnePlayerOne, teamOnePlayerTwo, teamTwoPlayerOne, teamTwoPlayerTwo, scoreOne, scoreTwo, genre, court,endDate, startDate)
DROP TABLE IF EXISTS doubleGame CASCADE;
CREATE TABLE doubleGame
(
    idGame        INT               NOT NULL ,
    teamOnePlayerOneId  INT         NOT NULL references player(idP),
    teamOnePlayerTwoId  INT         NOT NULL references player(idP),
    teamTwoPlayerOneId  INT         NOT NULL references player(idP),
    teamTwoPlayerTwoId  INT         NOT NULL references player(idP),
    scoreOne            VARCHAR(50) NOT NULL,
    scoreTwo            VARCHAR(50) NOT NULL,
    genre               VARCHAR(30) NOT NULL,
    court               INT         NOT NULL references court(idT),
    endDate             DATE        NOT NULL,
    startDate           DATE        NOT NULL,
    PRIMARY KEY (idGame)
);

#SingleGame (PlayerOne, PlayerTwo, scoreOne, scoreTwo, genre, court,endDate, startDate)
DROP TABLE IF EXISTS singleGame CASCADE;
CREATE TABLE singleGame
(
    idGame        INT                   NOT NULL,
    playerOneId         INT             NOT NULL references player(idP),
    playerTwoId         INT             NOT NULL references player(idP),
    scoreOne            VARCHAR(50)     NOT NULL,
    scoreTwo            VARCHAR(50)     NOT NULL,
    genre               VARCHAR(30)     NOT NULL,
    court               VARCHAR(30)     NOT NULL references court(idT),
    endDate             DATE            NOT NULL,
    startDate           DATE            NOT NULL,
    PRIMARY KEY (idGame)
);

#TrainingGame (booker, endDate, startDate)
DROP TABLE IF EXISTS trainingGame CASCADE;
CREATE TABLE trainingGame
(
    idTrainingGame  INT         NOT NULL AUTO_INCREMENT,
    bookerId        INT         NOT NULL references person(idP),
    endDate         DATE        NOT NULL,
    startDate       DATE        NOT NULL,
    PRIMARY KEY (idTrainingGame)
);

#Court (name)
DROP TABLE IF EXISTS court CASCADE;
CREATE TABLE court
(
    idT     INT         NOT NULL,
    name    VARCHAR(30) NOT NULL,
    PRIMARY KEY (idT)
);

# # # insert trainer as person
INSERT INTO person (idP,lastname, firstname, birthDate, birthPlace) VALUES (1,'Fefe', 'the trainer', '1987-05-22', 'Algerie');

insert into person (idP, lastname, firstname, birthDate, birthPlace) values (2, 'la gazelle', 'the player', '1987-05-22', 'Algerie');
# # # insert trainer as player
insert into player (idP,ranking, bestRanking, nationality, height, weight,startCareer, hand, trainerId) values (2, 1, 1, 'Algerie', 1, 1,'2019-05-22', 'right', 1);




