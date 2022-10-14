# creer la table joueur
create table joueur (
    id_joueur int not null auto_increment,
    nom varchar(50) not null,
    prenom varchar(50) not null,
    date_naissance date not null,
    primary key (id_joueur)
);