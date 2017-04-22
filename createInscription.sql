#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: Candidat
#------------------------------------------------------------
DROP DATABASE inscription2017;
CREATE DATABASE inscription2017;
USE inscription2017;
CREATE TABLE Candidat(
        NumCandidat  Int NOT NULL ,
        NomCandidat  Varchar (25) ,
        MailCandidat Varchar (25) ,
        PRIMARY KEY (NumCandidat )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Equipe
#------------------------------------------------------------

CREATE TABLE Equipe(
        NumCandidat Int NOT NULL ,
        PRIMARY KEY (NumCandidat )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Personne
#------------------------------------------------------------

CREATE TABLE Personne(
        PrenomPersonne Varchar (25) ,
        NumCandidat    Int NOT NULL ,
        PRIMARY KEY (NumCandidat )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Competition
#------------------------------------------------------------

CREATE TABLE Competition(
        LabelComp   Varchar (25) NOT NULL ,
        NomComp     Varchar (25) ,
        DateCloture Date ,
        EnEquipe    Bool ,
        PRIMARY KEY (LabelComp )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Participer
#------------------------------------------------------------

CREATE TABLE Participer(
        NumCandidat Int NOT NULL ,
        LabelComp   Varchar (25) NOT NULL ,
        PRIMARY KEY (NumCandidat ,LabelComp )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: ETRE DANS
#------------------------------------------------------------

CREATE TABLE ETRE_DANS(
        NumCandidat_Equipe   Int NOT NULL ,
        NumCandidat_Personne Int NOT NULL ,
        PRIMARY KEY (NumCandidat_Personne ,NumCandidat_Equipe )
)ENGINE=InnoDB;

ALTER TABLE Equipe ADD CONSTRAINT FK_Equipe_NumCandidat FOREIGN KEY (NumCandidat) REFERENCES Candidat(NumCandidat);
ALTER TABLE Personne ADD CONSTRAINT FK_Personne_NumCandidat FOREIGN KEY (NumCandidat) REFERENCES Candidat(NumCandidat);
ALTER TABLE Participer ADD CONSTRAINT FK_Participer_NumCandidat FOREIGN KEY (NumCandidat) REFERENCES Candidat(NumCandidat);
ALTER TABLE Participer ADD CONSTRAINT FK_Participer_LabelComp FOREIGN KEY (LabelComp) REFERENCES Competition(LabelComp);
ALTER TABLE ETRE_DANS ADD CONSTRAINT FK_ETRE_DANS_NumCandidat FOREIGN KEY (NumCandidat_Equipe) REFERENCES Equipe(NumCandidat);
ALTER TABLE ETRE_DANS ADD CONSTRAINT FK_ETRE_DANS_NumCandidat_1 FOREIGN KEY (NumCandidat_Personne) REFERENCES Personne(NumCandidat);
