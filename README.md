# JDBC preparedStatment
# Projet :gestion des employee

## Objectif du TP
Le but de ce Tp est de suivre la hiérarchie des employer  au sein d'une entreprise, en se 
concentrant sur celle qui manage ces employer. Ces données sont collectées et stockées dans 
un système de gestion de base de données (SGBD) afin de faciliter le suivi et l'analyse de la 
progression du projet. On va maitriser l’utilisation des fichiers .properties  afin d’établir la 
connexion avec la base de donne.
## Structure du projet
Le projet est organisé de la manière suivante :

![pp](https://github.com/user-attachments/assets/8225979f-a5cf-441a-8b72-81eab0ffdfa0)

  - `src/` : Contient le code source Java : 
     - `projet ` : contient les pachage utulise
     - `Test` : le test de l'application
     - ` connexion` : contient  une class connexion qui va faire liee la connexion avec 
la base de donnee. 
     - `dao ` : contient  une interface générique qui contrôle le comportement du 
service de chaque entité. 
     - ` entité `: contient les entités utulise dans le projet. 
     - ` service `: contient les services que cette application offre, les classes 
présente dans ce package son implémente d’interface dao. 
     - `Test` : ou on va effectuer les test. 

![structure](https://github.com/user-attachments/assets/8af647d3-ba2c-4a48-948b-50795be4ada2)

## Méthodes utilisées



  - ` creat (T o) ` :  crée des enregistrements dans la base de donnée. 
  
  - `  delete (T o) `: supprimer des enregistrements dans la base de donne.

  - `update (T o) `:  modifié un enregistrement. 
    
  - ` T findById (int o) `: trouver un  enregistrement à partir de son id. 

   - `getAll () `:récupérer toute les enregistrements

## Vue relationnel 

 ![hibb](https://github.com/user-attachments/assets/24f6666c-0364-4e60-bc63-dde574572968)

## Test
Pour tester le projet :
1. Assurez-vous que votre serveur MySQL ou Oracle est en cours d'exécution.
3. Compilez et exécutez `Main.java` pour insérer et récupérer des données.





[explication.webm](https://github.com/user-attachments/assets/f599c0a1-2b7e-4f6d-b4e4-c76884cf450e)



## Auteurs

uête SQL suivante :
 

 
