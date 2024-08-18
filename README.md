# github-Houssein
Ceci est le répertoire de Sosane Mahamoud Houssein pour le devoir et projet final du cours INF1163 pendant le trimestre d'été 2024.

**Le travail n’est pas d’implémenter tout le système TimeLog, mais plutôt correspond essentiellement à une partie de la phase d’élaboration et du codage. Veuillez se référer au [document du projet-devoir](https://github.com/SOSANE/github-Houssein/blob/main/Documents/Projet-Devoir-ete-2024.pdf)**

## Table des matières
[Introduction des systèmes](#introduction)

[Description](#description)

[Installation](#installation)

## Introduction 
TimeLog est un logiciel qui offre une assistance automatisée de calcul de temps, de salaires et de contrôle de budget de ses projets. Ce système est installé sur une machine dédiée sur laquelle tout employé peut se connecter pour signaler des opérations diverses.
Payroll est un sous-système appartenant à TimeLog qui produit et imprime (affiche dans le cadre de ce projet) des chèques de paie toutes les deux semaines en lui envoyant en argument une liste d'objets. 

Le but du système TimeLog est de permettre à l'utilisateur de naviguer dans le système de menu à l'aide d'une interface de ligne de commande. **L'interface ne sera pas graphique**, mais elle sera interactive et elle permettra à l'utilisateur de choisir des opérations dans un menu et de fournir des valeurs à partir de listes d'options.

  ***Afin d'utiliser le logiciel, veuillez exécuter la classe [TimeLog.java](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/TimeLog/TimeLog.java) dans le projet [TimeLogCode](https://github.com/SOSANE/github-Houssein/tree/main/TimeLogCode).***

## Description
Le projet a été écrit en Java en utilisant [Eclipse IDE](https://eclipseide.org/). Vous trouverez tous les fichiers à télécharger au préalable ainsi que les documents et les diagrammes décrivant le système TimeLog et le sous-système Payroll. 

### TimeLogCode
#### FichierJSON
Le projet utilise des fichiers JSON pour stocker ses données. Tous les fichiers JSON se trouvent dans le dossier [FichierJSON](https://github.com/SOSANE/github-Houssein/tree/main/TimeLogCode/src/FichierJSON). Le contenu des fichiers JSON peuvent être modifié par les utilisateurs lors de l'exécution du logiciel. Un [utilisateur](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/TimeLog/Utilisateur.java) qui est l'instance d'un [administrateur](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/TimeLog/Administrateur.java) peut modifier tous les fichiers. Un [utilisateur](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/TimeLog/Utilisateur.java) qui est l'instance d'un [employé](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/TimeLog/Employe.java) peut seulement modifier le fichier [activite.json](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/FichierJSON/activite.json). Le fichier [employe.json](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/FichierJSON/employe.json) contient un tableau d'objet. Chaque objet représente un employé. Pour s'authentifier, un utilisateur doit valider son nom d'usager et son mot de passe. Le mot de passe est l'ID de l'employé. Toutes ces données se retrouvent dans [employe.json](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/FichierJSON/employe.json). Le fichier [activite.json](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/FichierJSON/activite.json) contient tous les objets "activité". Une [activité](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/TimeLog/Activite.java) est caractérisée par sa discipline de travail, le projet associé et le ou les employés associés. Ce fichier est souvent modifié par les [employés](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/TimeLog/Employe.java). Le fichier [projet.json](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/FichierJSON/projet.json) stocke tous les [projets](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/TimeLog/Projet.java) et leurs détails pertinents associés. Un [projet](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/TimeLog/Projet.java) peut être assigné à des [employés](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/TimeLog/Employe.java) par l'[administrateur](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/TimeLog/Administrateur.java).

#### PayRoll
Le package [PayRoll](https://github.com/SOSANE/github-Houssein/tree/main/TimeLogCode/src/PayRoll) contient les classes [PayInfo.java](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/PayRoll/PayInfo.java) et [Payroll.java](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/PayRoll/Payroll.java) ainsi que l'interface [PayrollInterface.java](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/PayRoll/PayrollInterface.java). La classe [Payroll.java](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/PayRoll/Payroll.java) implémente l'interface [PayrollInterface.java](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/PayRoll/PayrollInterface.java). Leurs méthodes sont: [netFromBrute](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/PayRoll/Payroll.java#L27) et [DeductionsReport](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/PayRoll/Payroll.java#L33). Il y aussi la méthode supplémentaire [afficherPaie](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/PayRoll/Payroll.java#L10) qui est utilisé pour afficher les chèques de paie d'un employé. La classe [PayInfo.java](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/PayRoll/PayInfo.java) contient les attributs pertinents d'un chèque de paie.


Afin d'obtenir plus de détails concernant les classes de PayRoll, veuillez se référer au [document du projet-devoir](https://github.com/SOSANE/github-Houssein/blob/main/Documents/Projet-Devoir-ete-2024.pdf).

#### TimeLog
Le package [TimeLog](https://github.com/SOSANE/github-Houssein/tree/main/TimeLogCode/src/TimeLog) contient les classes [Utilisateur.java](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/TimeLog/Utilisateur.java), [Activite.java](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/TimeLog/Activite.java), [Menu.java](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/TimeLog/Menu.java), [Operation.java](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/TimeLog/Operation.java), [Administrateur.java](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/TimeLog/Administrateur.java), [Employe.java](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/TimeLog/Employe.java), [Projet.java](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/TimeLog/Projet.java), [RapportEtat.java](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/TimeLog/RapportEtat.java) et [TimeLog.java](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/TimeLog/TimeLog.java). Les attributs et méthodes pertinentes à l'exécution sont dans ces classes. Je vous invite à consulter le [package](https://github.com/SOSANE/github-Houssein/tree/main/TimeLogCode/src/TimeLog) et à jeter un oeil au code pour tous les détails.

**Concernant la classe *[TimeLog.java](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/TimeLog/TimeLog.java)***: Assurez-vous d'avoir modifié le chemin d'accès des variables *[employeJSON](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/TimeLog/TimeLog.java#L18)*, *[activiteJSON](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/TimeLog/TimeLog.java#L20)* et *[projetJSON](https://github.com/SOSANE/github-Houssein/blob/main/TimeLogCode/src/TimeLog/TimeLog.java#L19)* afin de pouvoir utiliser les fichiers JSON correctement. ***De plus, le projet s'exécute et compile sur cette classe***

### Externals JARs
Le fichier [json-simple.jar](https://github.com/SOSANE/github-Houssein/blob/main/External%20JARs/json-simple-1.1.1.jar) est disponible pour téléchargement. Le dossier contient aussi le [lien Internet](https://github.com/SOSANE/github-Houssein/blob/main/External%20JARs/Lien%20internet%20de%20JSON%20simple.url) de ma source. Veuillez consulter [Installation](#installation) pour plus de précision.

### Documents
Tous les fichiers PDF pertinents à la documentation se retrouvent dans le dossier [Documents](https://github.com/SOSANE/github-Houssein/tree/main/Documents). Le document [Projet-Devoir-ete-2024.pdf](https://github.com/SOSANE/github-Houssein/blob/main/Documents/Projet-Devoir-ete-2024.pdf) a été remis par le professeur, ce document contient toutes les instructions du projet et il décrit les livrables. Le document [Devoir_INF1163_SosaneMahamoudHoussein.pdf](https://github.com/SOSANE/github-Houssein/blob/main/Documents/Devoir_INF1163_SosaneMahamoudHoussein.pdf) est le fichier du devoir qui a été remis au professeur. Le fichier [Projet_INF1163_SosaneMahamoudHoussein.pdf](https://github.com/SOSANE/github-Houssein/blob/main/Documents/Projet_INF1163_SosaneMahamoudHoussein.pdf) est le document final du projet qui a été remis au professeur. Tous les détails des livrables des deux derniers documents sont aussi décrit dans le document [Projet-Devoir-ete-2024.pdf](https://github.com/SOSANE/github-Houssein/blob/main/Documents/Projet-Devoir-ete-2024.pdf).

### Diagrammes
Tous les diagrammes en format png pertinents sont inclus dans [Diagrammes](https://github.com/SOSANE/github-Houssein/tree/main/Diagrammes). Le sous-dossier [Diagramme initial](https://github.com/SOSANE/github-Houssein/tree/main/Diagrammes/Diagramme%20initial) contient plusieurs diagrammes qui représentent un croquis du projet et la phase initiale de la conception. Ces diagrammes sont à risque de modification tout au long de la conception du système. Le dossier [diags](https://github.com/SOSANE/github-Houssein/tree/main/Diagrammes/diags) contient tous les diagrammes pour le livrable du projet final. Le [diagramme de classe initial](https://github.com/SOSANE/github-Houssein/blob/main/Diagrammes/Diagramme%20initial/TimeLog-Diagramme-Diagramme%20de%20classe%20initial.drawio.png), le [modèle de domaine](https://github.com/SOSANE/github-Houssein/blob/main/Diagrammes/diags/modeleDuDomaine.png) et le [diagramme de cas d'utilisation](https://github.com/SOSANE/github-Houssein/blob/main/Diagrammes/Diagramme%20initial/TimeLog-Diagramme-Cas%20d'utilisation.drawio.png) de ce projet ont été conçus à l'aide du site [draw.io](https://app.diagrams.net/). Les diagrammes de séquences ([DS1.png](https://github.com/SOSANE/github-Houssein/blob/main/Diagrammes/diags/DS1.png) et [DS2.png](https://github.com/SOSANE/github-Houssein/blob/main/Diagrammes/diags/DS2.png)) et le [diagramme de classe final](https://github.com/SOSANE/github-Houssein/blob/main/Diagrammes/diags/diagClasses.png) ont été conçus à l'aide de [Modelio](https://www.modelio.org/index.htm). 

## Installation
### Cloner le répertoire sur git
```bash
 git clone https://github.com/SOSANE/github-Houssein.git
```

### JSON comme éditeur de texte
*Si vous avez des difficultés à ouvrir, modifier ou utiliser les fichiers JSON, veuillez suivre les consignes ci-dessous en utilisant Eclipse IDE.*

Afin d'ouvrir des fichiers JSON sur Eclipse IDE, veuillez **cliquer Windows > Preferences > General > Editors > File association > Add (dans la section File types:)**

Une nouvelle fenêtre s'affichera, veuillez **écrire dans l'espace texte "*.json"** et **cliquez sur OK**

Dans la section **Associated editors:**, veuillez **cliquer sur Add...**

Une nouvelle fenêtre s'affichera, prenez l'option **Internal editors** et veuillez choisir **Text Editor** dans la liste d'éléments à choisir. **Cliquez sur OK sur les deux fenêtres.**

Si vous avez encore des difficultés, vous pouvez consulter la [vidéo suivante](https://youtu.be/16itKhkYh_A?si=fnAZifQsFt1KyQFQ).



À présent, vous devriez être en mesure d'ouvrir, de modifier ou d'utiliser les fichiers JSON du projet.

### Json-simple
Le projet utilise [**json-simple**](https://code.google.com/archive/p/json-simple/) comme outil pour modifier ou décoder les fichiers JSON pour Java. 

Vous trouverez dans le dossier [External JARs](https://gitfront.io/r/SOSANE/kPwaKFRPRaNW/github-Houssein/tree/External%20JARs/) le fichier json-simple-1.1.1.jar. Pour faire fonctionner le code, veuillez télécharger ce fichier afin de pouvoir utiliser les fichier JSON.

En utilisant Eclipse IDE, **clique droit sur le JAVA project ProjetFinal_INF1163 > Build Path > Configure Build Path > Libraries > Classpath > Add External JARs... > Apply and Close**.

