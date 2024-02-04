\c postgres

drop database meuble;

create database meuble;

\c meuble

CREATE TABLE Meuble(
    id serial PRIMARY KEY,
    nommeuble VARCHAR(50)
);

CREATE TABLE Matiere(
    id SERIAL PRIMARY KEY,
    nommatiere VARCHAR(120)
);

CREATE TABLE Style(
    id SERIAL PRIMARY KEY,
    nomstyle VARCHAR(100)
);

CREATE TABLE Volume(
    id SERIAL PRIMARY KEY,
    nomvolume VARCHAR(50),
    coeff decimal(18,2) UNIQUE
);

CREATE TABLE Ouvrier(
    id SERIAL PRIMARY KEY,
    nomouvrier VARCHAR(50)
);

CREATE TABLE Genre(
    id serial primary key,
    nomgenre VARCHAR(50)
);

CREATE TABLE Client(
    id serial primary key,
    nomclient VARCHAR(50),
    idgenre int,
    FOREIGN KEY (idgenre) REFERENCES Genre(id)
);

CREATE TABLE OuvrierExp(
    id serial primary key,
    idouvrier int,
    expdebut int,
    expfin int,
    dateinsertion timestamp,
    FOREIGN KEY (idouvrier) REFERENCES Ouvrier(id)
);

CREATE TABLE Poste(
    id serial primary key,
    nomposte VARCHAR(50)
);

CREATE TABLE Postesalaire(
    id serial primary key,
    idposte int,
    salairebase decimal(18,2),
    dateinsertion timestamp,
    FOREIGN KEY (idposte) REFERENCES Poste(id)
);

CREATE TABLE Employe(
    id serial primary key,
    nomemploye VARCHAR(50),
    idposte int,
    dateembauche timestamp,
    FOREIGN KEY (idposte) REFERENCES Poste(id)
);

CREATE TABLE MatiereStyle(
    id SERIAL PRIMARY KEY,
    idstyle int,
    idmatiere int,
    FOREIGN KEY (idstyle) REFERENCES Style(id),
    FOREIGN KEY (idmatiere) REFERENCES Matiere(id),
    CONSTRAINT cms UNIQUE (idstyle, idmatiere)
);

CREATE TABLE PrixMatiere(
    id SERIAL PRIMARY KEY,
    idmatiere int,
    prix decimal(18,2),
    dateinsertion timestamp,
    FOREIGN KEY (idmatiere) REFERENCES Matiere(id)
);

CREATE TABLE OuvrierSalaire(
    id SERIAL PRIMARY KEY,
    idouvrier int,
    salairecoeff decimal(18,2),
    dateinsertion timestamp,
    FOREIGN KEY (idouvrier) REFERENCES Ouvrier(id)
);

CREATE TABLE FormuleOuvrier(
    id serial primary key,
    idvolume int,
    ouvriermin int,
    dateinsertion timestamp,
    FOREIGN KEY (idvolume) REFERENCES Volume(id)
);

CREATE TABLE TravailOuvrier(
    id serial primary key,
    idmeuble int,
    idstyle int,
    idvolume int,
    idouvrier int,
    idposte int,
    nombre int,
    heuretravail decimal(18,2),
    dateinsertion timestamp,
    FOREIGN KEY (idouvrier) REFERENCES Ouvrier(id),
    FOREIGN KEY (idvolume) REFERENCES Volume(id),
    FOREIGN KEY (idstyle) REFERENCES Style(id),
    FOREIGN KEY (idmeuble) REFERENCES Meuble(id),
    FOREIGN KEY (idposte) REFERENCES Poste(id)
);

CREATE TABLE PrixVente(
    id SERIAL PRIMARY KEY,
    idmeuble int,
    idstyle int,
    idvolume int,
    prix decimal(18,2),
    dateinsertion timestamp,
    FOREIGN KEY (idmeuble) REFERENCES Meuble(id),
    FOREIGN KEY (idstyle) REFERENCES Style(id),
    FOREIGN KEY (idvolume) REFERENCES Volume(id)
);

CREATE OR REPLACE VIEW V_MatiereStyle AS 
SELECT MatiereStyle.*, Matiere.nommatiere, Style.nomstyle FROM MatiereStyle 
join Style on MatiereStyle.idstyle = Style.id
join Matiere on MatiereStyle.idmatiere = Matiere.id;


CREATE TABLE Fabrication(
    idfabrication serial PRIMARY KEY,
    idmeuble int,
    idstyle int,
    idvolume int,
    idmatiere int,
    qte int,
    FOREIGN KEY (idstyle) REFERENCES Style(id),
    FOREIGN KEY (idmatiere) REFERENCES Matiere(id),
    FOREIGN KEY (idvolume) REFERENCES Volume(id),
    FOREIGN KEY (idmeuble) REFERENCES Meuble(id),
    CONSTRAINT cf UNIQUE (idvolume,idstyle, idmatiere, idmeuble)
);


CREATE OR REPLACE VIEW V_LastPrixMatiere AS
SELECT DISTINCT ON (idmatiere) id, idmatiere, prix, dateinsertion
FROM PrixMatiere
ORDER BY idmatiere, dateinsertion DESC;

CREATE OR REPLACE VIEW V_Fabrication AS
SELECT Fabrication.*, Meuble.nommeuble, Style.nomstyle, Volume.nomvolume, V_LastPrixMatiere.prix
FROM Fabrication
join Meuble on Fabrication.idmeuble = Meuble.id
join Style on Fabrication.idstyle = Style.id
join Volume on Fabrication.idvolume = Volume.id
join V_LastPrixMatiere on Fabrication.idmatiere = V_LastPrixMatiere.idmatiere;

CREATE OR REPLACE VIEW V_SumPrix AS
SELECT nommeuble, nomstyle, nomvolume, sum(qte*prix) as prixtotal
from v_fabrication 
group by nommeuble, nomstyle, nomvolume;

CREATE TABLE StockMatiere(
    id serial PRIMARY KEY,
    idmatiere int,
    entree int,
    sortie int,
    dateachat timestamp,
    FOREIGN KEY (idmatiere) REFERENCES Matiere(id)
);

CREATE OR REPLACE VIEW V_Stock AS
SELECT Matiere.nommatiere, Matiere.id as idmatiere, coalesce(sum(entree)-sum(sortie),0) as totalqte
from Matiere 
left join StockMatiere on Matiere.id = StockMatiere.idmatiere
group by Matiere.nommatiere, Matiere.id;

CREATE TABLE CommandeMeuble(
    id serial PRIMARY KEY,
    idmeuble int,
    idstyle int,
    idvolume int,
    datecommande timestamp,
    qte int,
    idclient int,
    FOREIGN KEY (idmeuble) REFERENCES Meuble(id),
    FOREIGN KEY (idstyle) REFERENCES Style(id),
    FOREIGN KEY (idvolume) REFERENCES Volume(id),
    FOREIGN KEY (idclient) REFERENCES Client(id)
);


CREATE OR REPLACE VIEW V_stat AS
select CommandeMeuble.*, Meuble.nommeuble, Style.nomstyle, Volume.nomvolume, Client.idgenre
from CommandeMeuble
join Meuble on CommandeMeuble.idmeuble = Meuble.id
join Style on CommandeMeuble.idstyle = Style.id
join Volume on CommandeMeuble.idvolume = Volume.id
join Client on CommandeMeuble.idclient = Client.id;

CREATE OR REPLACE VIEW V_stat_nom AS
select V_stat.*, Genre.nomgenre
from V_stat
join Genre on V_stat.idgenre = Genre.id;

CREATE OR REPLACE VIEW V_stat_complet AS
select count(idmeuble) as nbvente , idgenre, nomgenre, idmeuble, nomMeuble, idstyle, nomStyle, idvolume, nomvolume 
from V_stat_nom 
group by nomgenre, nommeuble, nomstyle, nomvolume, idgenre, idmeuble, idstyle, idvolume;



-- view maka ny poste actuel sy ny statut any sy ny salaire any

CREATE OR REPLACE VIEW V_Employe_exp AS
select OuvrierExp.idouvrier, Employe.id as idemploye, Employe.nomemploye, extract(year from AGE(now(), Employe.dateembauche)) as anneeExp
from Employe, OuvrierExp
where extract(year from AGE(now(), Employe.dateembauche)) between OuvrierExp.expdebut and OuvrierExp.expfin;

CREATE OR REPLACE VIEW V_salairecoeff_recent AS
SELECT DISTINCT ON (idouvrier)
    id,
    idouvrier,
    salairecoeff,
    dateinsertion
FROM OuvrierSalaire
ORDER BY idouvrier, dateinsertion DESC;

CREATE OR REPLACE VIEW V_salairebase_recent AS
SELECT DISTINCT ON (idposte)
    id,
    idposte,
    salairebase,
    dateinsertion
FROM PosteSalaire
ORDER BY idposte, dateinsertion DESC;

CREATE OR REPLACE VIEW V_Employe_profil AS
select V_Employe_exp.*, Employe.idposte, V_salairecoeff_recent.salairecoeff
from V_Employe_exp
join Employe on V_Employe_exp.idemploye = Employe.id
join V_salairecoeff_recent on V_Employe_exp.idouvrier = V_salairecoeff_recent.idouvrier;

CREATE OR REPLACE VIEW V_Employe_profil_salaire AS
select V_Employe_profil.*, V_salairebase_recent.salairebase, (V_salairebase_recent.salairebase * V_Employe_profil.salairecoeff) as salaire
from V_Employe_profil
join V_salairebase_recent on  V_Employe_profil.idposte = V_salairebase_recent.idposte;

CREATE OR REPLACE VIEW V_Employe_profil_poste AS
select V_Employe_profil_salaire.idposte, Poste.nomposte, V_Employe_profil_salaire.idouvrier, Ouvrier.nomOuvrier, V_Employe_profil_salaire.idemploye,
V_Employe_profil_salaire.nomemploye, V_Employe_profil_salaire.salaire
from V_Employe_profil_salaire
join Poste on V_Employe_profil_salaire.idposte = Poste.id
join Ouvrier on V_Employe_profil_salaire.idouvrier = Ouvrier.id;


-- benefice

CREATE OR REPLACE VIEW V_prixvente_recent AS
SELECT DISTINCT ON (idmeuble, idstyle, idvolume)
    id,
    idmeuble,
    idstyle,
    idvolume,
    prix,
    dateinsertion
FROM PrixVente
ORDER BY idmeuble, idstyle, idvolume, dateinsertion DESC;


CREATE OR REPLACE VIEW V_travailouvrier AS
select 
    TravailOuvrier.*, 
    (V_salairecoeff_recent.salairecoeff * V_salairebase_recent.salairebase) as tauxhoraire, 
    ((V_salairecoeff_recent.salairecoeff * V_salairebase_recent.salairebase) * TravailOuvrier.heuretravail) as salpers,
    ((V_salairecoeff_recent.salairecoeff * V_salairebase_recent.salairebase) * TravailOuvrier.heuretravail * TravailOuvrier.nombre) as saltotal
from TravailOuvrier
join V_salairecoeff_recent on TravailOuvrier.idouvrier = V_salairecoeff_recent.idouvrier
join V_salairebase_recent on TravailOuvrier.idposte = V_salairebase_recent.idposte;


CREATE OR REPLACE VIEW V_travailouvrier_salaire AS
select idmeuble, idstyle, idvolume, sum(saltotal) as salairetotal
from V_travailouvrier
group by idmeuble, idstyle, idvolume;


CREATE OR REPLACE VIEW V_prixmatiere_recent AS
SELECT DISTINCT ON (idmatiere)
    id,
    idmatiere,
    prix,
    dateinsertion
FROM PrixMatiere
ORDER BY idmatiere, dateinsertion DESC;


CREATE OR REPLACE VIEW V_prixmatiere_produit AS
select 
    Fabrication.idmeuble, 
    Fabrication.idstyle, 
    Fabrication.idvolume, 
    sum((V_prixmatiere_recent.prix * Fabrication.qte)) as prixmatiere
from Fabrication
join V_prixmatiere_recent on Fabrication.idmatiere = V_prixmatiere_recent.idmatiere
group by idmeuble, idstyle, idvolume;


CREATE OR REPLACE VIEW V_benefice AS
select 
    V_travailouvrier_salaire.*, 
    (V_prixvente_recent.prix) as prixvente, 
    V_prixmatiere_produit.prixmatiere, 
    (V_prixvente_recent.prix - (V_prixmatiere_produit.prixmatiere + V_travailouvrier_salaire.salairetotal)) as benefice
from V_travailouvrier_salaire
join V_prixvente_recent 
    ON V_travailouvrier_salaire.idmeuble = V_prixvente_recent.idmeuble 
    AND V_travailouvrier_salaire.idstyle = V_prixvente_recent.idstyle 
    AND V_travailouvrier_salaire.idvolume = V_prixvente_recent.idvolume
join V_prixmatiere_produit 
    ON V_travailouvrier_salaire.idmeuble = V_prixmatiere_produit.idmeuble 
    AND V_travailouvrier_salaire.idstyle = V_prixmatiere_produit.idstyle 
    AND V_travailouvrier_salaire.idvolume = V_prixmatiere_produit.idvolume;


CREATE OR REPLACE VIEW V_benefice_affichage AS
select 
    Meuble.nommeuble, 
    Style.nomstyle, 
    Volume.nomvolume, 
    V_benefice.prixvente,
    V_benefice.salairetotal,
    V_benefice.prixmatiere,
    V_benefice.benefice
from V_benefice
join Meuble on V_benefice.idmeuble = Meuble.id
join Style on V_benefice.idstyle = Style.id
join Volume on V_benefice.idvolume = Volume.id;



