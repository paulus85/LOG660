
/* Paul Rivière - Thomas Blondet - Christian Cardin // Equipe 26 */

DROP TABLE Artist CASCADE CONSTRAINT;
DROP TABLE Film CASCADE CONSTRAINT;
DROP TABLE ActorFilmRole CASCADE CONSTRAINT;
DROP TABLE FilmCountry CASCADE CONSTRAINT;
DROP TABLE Country CASCADE CONSTRAINT;
DROP TABLE FilmScenarist CASCADE CONSTRAINT;
DROP TABLE FilmGenre CASCADE CONSTRAINT;
DROP TABLE Scenarist CASCADE CONSTRAINT;
DROP TABLE Genre CASCADE CONSTRAINT;
DROP TABLE Adresse CASCADE CONSTRAINT;
DROP TABLE Utilisateur CASCADE CONSTRAINT;
DROP TABLE EmployeeUserInfo CASCADE CONSTRAINT;
DROP TABLE Plan CASCADE CONSTRAINT;
DROP TABLE ClientUserInfo CASCADE CONSTRAINT;
DROP TABLE RentalCharacteristics CASCADE CONSTRAINT;
DROP TABLE Copy CASCADE CONSTRAINT;


/* Création des tables */
CREATE TABLE Artist (
    artistId        INTEGER         NOT NULL,
    nom            VARCHAR2(100)    NOT NULL,
    birthday        DATE,
    birthPlace      VARCHAR2(100),
    biography       VARCHAR2(4000),
    PRIMARY KEY (artistId)  
);

CREATE TABLE Film (
    filmId          INTEGER         NOT NULL,
    title           VARCHAR2(100)    NOT NULL,
    year            INTEGER         NOT NULL,
    language        VARCHAR2(100)   ,
    duration        INTEGER         NOT NULL,
    originalCopyNumber      INTEGER      DEFAULT 0       NOT NULL        CHECK (originalCopyNumber >=0),
    summary         VARCHAR2(4000),
    directorId      INTEGER         ,
    PRIMARY KEY (filmId),
    FOREIGN KEY (directorId) REFERENCES Artist(artistId)    
);


CREATE TABLE ActorFilmRole (
    artistId        INTEGER         NOT NULL,
    filmId          INTEGER         NOT NULL,
    characterName   VARCHAR2(100)    NOT NULL,
    PRIMARY KEY (artistId,filmId)  
);

CREATE TABLE FilmCountry (
    countryId       INTEGER         NOT NULL,
    filmId          INTEGER         NOT NULL,
    PRIMARY KEY (countryId,filmId)  
);

CREATE TABLE Country (
    countryId       INTEGER         NOT NULL,
    countryName     VARCHAR2(100)    NOT NULL,
    PRIMARY KEY (countryId)  
);

CREATE TABLE FilmScenarist (
    scenaristId     INTEGER         NOT NULL,
    filmId          INTEGER         NOT NULL,
    PRIMARY KEY (scenaristId,filmId)  
);

CREATE TABLE Scenarist (
    scenaristId     INTEGER         NOT NULL,
    name            VARCHAR2(100)    NOT NULL,
    PRIMARY KEY (scenaristId)  
);

CREATE TABLE FilmGenre (
    genreId         INTEGER         NOT NULL,
    filmId          INTEGER         NOT NULL,
    PRIMARY KEY (genreId,filmId)  
);

CREATE TABLE Genre (
    genreId         INTEGER         NOT NULL,
    genreName       VARCHAR2(100)    NOT NULL,
    PRIMARY KEY (genreId)  
);



CREATE TABLE Adresse (
    adresseId       INTEGER     NOT NULL,
    rue     VARCHAR2(100)        NOT NULL,
    ville       VARCHAR2(100)        NOT NULL,
    province        VARCHAR2(100)        NOT NULL,
    codePostal      VARCHAR2(10)            CHECK (REGEXP_LIKE(codePostal,'^[[:alpha:]]{1}[[:digit:]]{1}[[:alpha:]]{1}[ |-][[:digit:]]{1}[[:alpha:]]{1}[[:digit:]]{1}$')),
    PRIMARY KEY (adresseId)
);

CREATE TABLE Utilisateur(
    userId          INTEGER     NOT NULL,
    lastName        VARCHAR2(100)    NOT NULL,
    firstName       VARCHAR2(100)    NOT NULL,
    PhoneNumber     VARCHAR2(100)    NOT NULL,
    birthday        DATE            NOT NULL,
    email           VARCHAR2(100)    NOT NULL,
    password        VARCHAR2(100)    NOT NULL        CHECK(REGEXP_LIKE(password, '^[a-zA-Z0-9]*$') and length(password) >= 5) ,
    adresseId       INTEGER         NOT NULL,
    PRIMARY KEY (userId),
    FOREIGN KEY (adresseId) REFERENCES Adresse,
    CONSTRAINT email_unique UNIQUE (email)
);

CREATE TABLE EmployeeUserInfo (
    userId          INTEGER         NOT NULL,
    matricule       INTEGER         NOT NULL,
    PRIMARY KEY (userId)
);

CREATE TABLE Plan (
    planId          INTEGER         NOT NULL,
    name            VARCHAR2(100)    NOT NULL,
    cost            INTEGER         NOT NULL,
    maxDuration     INTEGER         NOT NULL,
    maxLocation     INTEGER         NOT NULL,
    PRIMARY KEY (planId)
);

CREATE TABLE ClientUserInfo (
    userId          INTEGER         NOT NULL,
    planId          INTEGER         NOT NULL,
    cardNumber      VARCHAR2(20)      NOT NULL,
    expirationMonth INTEGER         NOT NULL,
    expirationYear  INTEGER         NOT NULL,
    cvv             NUMBER(3),
    creditCardType  VARCHAR2(100)    NOT NULL,
    PRIMARY KEY (userId),
    FOREIGN KEY (planId) REFERENCES Plan
);

CREATE TABLE RentalCharacteristics (
    userId          INTEGER         NOT NULL,
    copyId          INTEGER         NOT NULL,
    dateLoc            DATE            NOT NULL,
    PRIMARY KEY (userId, copyId)
);

CREATE TABLE Copy (
    copyId          INTEGER         NOT NULL,
    filmId          INTEGER         NOT NULL,
    rented          NUMBER(1)       NOT NULL,
    PRIMARY KEY (copyId),
    FOREIGN KEY (filmId) REFERENCES Film
);



/* Insertion des données statiques */

--Plan
INSERT INTO Plan(planId,name,cost,maxDuration,maxLocation) VALUES (1,'D',5,10,1);
INSERT INTO Plan(planId,name,cost,maxDuration,maxLocation) VALUES (2,'I',10,30,5);
INSERT INTO Plan(planId,name,cost,maxDuration,maxLocation) VALUES (3,'A',15,0,10);



/* Séquences pour l'incrémentation des IDs */
DROP SEQUENCE UserSeq;
CREATE SEQUENCE UserSeq
    START WITH 1
    INCREMENT BY 1;


DROP SEQUENCE AddressSeq;
CREATE SEQUENCE AddressSeq
    START WITH 1
    INCREMENT BY 1;

DROP SEQUENCE ArtistSeq;
CREATE SEQUENCE ArtistSeq
    START WITH 1
    INCREMENT BY 1;

DROP SEQUENCE FilmSeq;
CREATE SEQUENCE FilmSeq
    START WITH 1
    INCREMENT BY 1;

DROP SEQUENCE CountrySeq;
CREATE SEQUENCE CountrySeq
    START WITH 1
    INCREMENT BY 1;

DROP SEQUENCE GenreSeq;
CREATE SEQUENCE GenreSeq
    START WITH 1
    INCREMENT BY 1;

DROP SEQUENCE ScenaristSeq;
CREATE SEQUENCE ScenaristSeq
    START WITH 1
    INCREMENT BY 1;

DROP SEQUENCE CopySeq;
CREATE SEQUENCE CopySeq
    START WITH 1
    INCREMENT BY 1;


/* Procédures */

--Ajout d'un nouvel utilisateur
CREATE OR REPLACE PROCEDURE AddUserProc (
    add_lastName        VARCHAR2,
    add_firstName       VARCHAR2,
    add_PhoneNumber     VARCHAR2,
    add_birthday        DATE,
    add_email           VARCHAR2,
    add_password        VARCHAR2,
    add_rue             VARCHAR2,
    add_ville           VARCHAR2,
    add_province        VARCHAR2,
    add_codePostal      VARCHAR2,
    add_planName        VARCHAR2,
    add_cardNumber      VARCHAR2,
    add_expirationMonth INTEGER,
    add_expirationYear  INTEGER,
    add_cvv             NUMBER,
    add_creditCardType  VARCHAR2)
    IS
    codePostal VARCHAR2(10);
    plan INTEGER;
    BEGIN

        SELECT planId INTO plan
        FROM Plan
        WHERE name = add_planName;

        IF NOT REGEXP_LIKE(add_codePostal,'^[[:alpha:]]{1}[[:digit:]]{1}[[:alpha:]]{1}[ |-][[:digit:]]{1}[[:alpha:]]{1}[[:digit:]]{1}$') THEN
            codePostal := null;
            ELSE codePostal := add_codePostal;
        END IF;

        INSERT INTO Adresse (
            adresseId,
            rue,
            ville,
            province,
            codePostal)
        VALUES (
            AddressSeq.NEXTVAL,
            add_rue,
            add_ville,
            add_province,
            codePostal);

        INSERT INTO Utilisateur(
            userId,
            lastName,
            firstName,
            PhoneNumber,
            birthday,
            email,
            password,
            adresseId)
        VALUES (
            UserSeq.NEXTVAL,
            add_lastName,
            add_firstName,
            add_PhoneNumber,
            add_birthday,
            add_email,
            add_password,
            AddressSeq.CURRVAL);

        INSERT INTO ClientUserInfo (
            userId,
            planId ,
            cardNumber,
            expirationMonth,
            expirationYear,
            cvv,
            creditCardType)
        VALUES (
            UserSeq.CURRVAL,
            plan,
            add_cardNumber,
            add_expirationMonth,
            add_expirationYear,
            add_cvv,
            add_creditCardType);

        

    END AddUserProc;



--Ajout d'un Artiste

CREATE OR REPLACE FUNCTION AddArtistFunc (
    add_name            VARCHAR2,
    add_birthday        DATE,
    add_birthPlace      VARCHAR2,
    add_biography       VARCHAR2)
    RETURN INTEGER
    IS 
      cnt NUMBER;
      res INTEGER;
    BEGIN 
        SELECT COUNT(*) INTO cnt
        FROM Artist
        WHERE nom = add_name;

        IF (cnt > 0) THEN
            SELECT artistId INTO res FROM Artist WHERE nom = add_name;
            RETURN res;

        ELSE
            INSERT INTO Artist (
                artistId,
                nom,
                birthday,
                birthPlace,
                biography)
            VALUES (
                ArtistSeq.NEXTVAL,
                add_name,
                add_birthday,
                add_birthPlace,
                add_biography
                );
            RETURN (ArtistSeq.CURRVAL);
        END IF;
    END AddArtistFunc;




--Attribution d'un role à un acteur
CREATE OR REPLACE PROCEDURE AddActorRoleFunc (add_actorName VARCHAR2, add_filmId INTEGER, add_charcName VARCHAR2)
    IS actorId INTEGER;
    BEGIN
        SELECT artistId INTO actorId
        FROM Artist
        WHERE nom = add_actorName;

        INSERT INTO ActorFilmRole(
            artistId,
            filmId,
            characterName)
        VALUES (
            actorId,
            add_filmId,
            add_charcName);
        EXCEPTION
            WHEN NO_DATA_FOUND THEN
                RAISE_APPLICATION_ERROR(-20001,'No data found');
    END AddActorRoleFunc;




--Ajout de pays
CREATE OR REPLACE FUNCTION AddCountryFunc (add_countryName VARCHAR2)
    RETURN INTEGER
    IS 
        cnt NUMBER;
        res NUMBER;
    BEGIN
        SELECT COUNT(*) INTO cnt
        FROM Country
        WHERE countryName = add_countryName;

        IF (cnt > 0) THEN
            SELECT countryId INTO res FROM Country WHERE countryName = add_countryName;
            RETURN res;
        ELSE
            INSERT INTO Country(
                countryId,
                countryName)
            VALUES (
                CountrySeq.NEXTVAL,
                add_countryName);
            RETURN (CountrySeq.CURRVAL);
        END IF;
    END AddCountryFunc;



--Ajout d'un genre de film
CREATE OR REPLACE FUNCTION AddGenreFunc (add_genreName VARCHAR2)
    RETURN INTEGER
    IS 
        cnt NUMBER;
        res NUMBER;
    BEGIN
        SELECT COUNT(*) INTO cnt
        FROM Genre
        WHERE genreName = add_genreName;

        IF (cnt > 0) THEN
            SELECT genreId INTO res FROM Genre WHERE genreName = add_genreName;
            RETURN res;
        ELSE
            INSERT INTO Genre(
                genreId,
                genreName)
            VALUES (
                GenreSeq.NEXTVAL,
                add_genreName);
            RETURN (GenreSeq.CURRVAL);
        END IF;
    END AddGenreFunc;



--Ajout d'un scénariste
CREATE OR REPLACE FUNCTION AddScenaristFunc (add_scenaristName VARCHAR2)
    RETURN INTEGER
    IS 
        cnt NUMBER;
        res NUMBER;
    BEGIN
        SELECT COUNT(*) INTO cnt
        FROM Scenarist
        WHERE name = add_scenaristName;

        IF (cnt = 1) THEN
            SELECT scenaristId INTO res FROM Scenarist WHERE name = add_scenaristName;
            RETURN res;
        ELSE
            INSERT INTO Scenarist(
                scenaristId,
                name)
            VALUES (
                ScenaristSeq.NEXTVAL,
                add_scenaristName);
            RETURN (ScenaristSeq.CURRVAL);
        END IF;
    END AddScenaristFunc;





--Ajout d'un film dans la base de donnée
CREATE OR REPLACE FUNCTION AddFilmFunc (
    add_title           VARCHAR2,
    add_year            INTEGER,
    add_language        VARCHAR2,
    add_duration        INTEGER,
    add_originalCopyNumber      INTEGER,
    add_summary         VARCHAR2,
    add_directorName    VARCHAR2)
    RETURN INTEGER
    IS dirId INTEGER;
    BEGIN
        BEGIN
            SELECT artistId INTO dirId
            FROM Artist
            WHERE nom = add_directorName;
        EXCEPTION 
            WHEN NO_DATA_FOUND THEN
            dirId := null;
        END;

        INSERT INTO Film (
            filmId,
            title,
            year,
            language,
            duration,
            originalCopyNumber,
            summary,
            directorId)
        VALUES (
            FilmSeq.NEXTVAL,
            add_title,
            add_year,
            add_language,
            add_duration,
            add_originalCopyNumber,
            add_summary,
            dirId);

        FOR indice IN 1..add_originalCopyNumber
        LOOP
            INSERT INTO Copy(copyId,rented,filmId) VALUES (CopySeq.NEXTVAL,0,FilmSeq.CURRVAL);
        END LOOP;

        RETURN (FilmSeq.CURRVAL);
	
    END AddFilmFunc;




/* Trigger */

-- Vérification de l'âge de l'utilisateur
CREATE OR REPLACE TRIGGER BIUVerifAge
BEFORE INSERT OR UPDATE OF birthday ON Utilisateur
FOR EACH ROW

WHEN (MONTHS_BETWEEN(SYSDATE, new.birthday)/12 < 18) 
    BEGIN
        RAISE_APPLICATION_ERROR(-20001, 'Age non reglementaire');
    END;


-- Vérification de la validité de la carte
CREATE OR REPLACE TRIGGER BIUVerifCarte
BEFORE INSERT OR UPDATE OF expirationMonth, expirationYear ON ClientUserInfo
FOR EACH ROW
BEGIN
    IF (TO_DATE(:NEW.expirationYear || '-' || :NEW.expirationMonth, 'YYYY-MM') < TO_DATE(TO_CHAR(SYSDATE, 'YYYY-MM'), 'YYYY-MM')) THEN
    
          RAISE_APPLICATION_ERROR(-20101, 'Carte de credit expiree');
    END IF;
END;



/* Ajouts de contraintes supplémentaires après coup (correction) */
ALTER TABLE ClientUserInfo
ADD CONSTRAINT fk_CUO_Delegation
FOREIGN KEY (userId) REFERENCES Utilisateur(userId);

ALTER TABLE EmployeeUserInfo
ADD CONSTRAINT fk_EUO_Delegation
FOREIGN KEY (userId) REFERENCES Utilisateur(userId);

ALTER TABLE ClientUserInfo
ADD CHECK CreditCardType IN ('Visa','MasterCard','Amex');



