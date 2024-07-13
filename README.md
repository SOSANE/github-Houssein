# github-Houssein
Ceci est le répertoire de Sosane Mahamoud Houssein pour le devoir et projet final du cours INF1163 pendant le trimestre d'été 2024.

**Ce travail est toujours en cours**

## Table des matières
[Introduction des systèmes](#introduction)

[Description](#description)

[Installation](#installation)

## Introduction 
TimeLog est un logiciel qui offre une assistance automatisée de calcul de temps, de salaires et de contrôle de budget de ses projets. Ce système est installé sur une machine dédiée sur laquelle tout employé peut se connecter pour signaler des opérations diverses.
Payroll est un sous-système appartenant à TimeLog qui produit et imprime (affiche dans le cadre de ce projet) des chèques de paie toutes les deux semaines en lui envoyant en argument une liste d'objets. 

Le but du système TimeLog est de permettre à l'utilisateur de naviguer dans le système de menu à l'aide d'une interface de ligne de commande. **L'interface ne sera pas graphique**, mais elle sera interactive et elle permettra à l'utilisateur de choisir des opérations dans un menu et de fournir des valeurs à partir de listes d'options.

## Description
Le projet a été écrit en Java en utilisant [Eclipse IDE](https://eclipseide.org/). Vous trouverez tous les fichiers à télécharger au préalable ainsi que les documents et les diagrammes décrivant le système TimeLog et le sous-système Payroll.

### TimeLogCode
#### FichierJSON
Le projet utilise des fichiers JSON pour stocker ses données. Tous les fichiers JSON se trouvent dans le dossier [FichierJSON](https://gitfront.io/r/SOSANE/kPwaKFRPRaNW/github-Houssein/tree/TimeLogCode/src/FichierJSON/)

#### PayRoll
Le package [PayRoll](https://gitfront.io/r/SOSANE/kPwaKFRPRaNW/github-Houssein/tree/TimeLogCode/src/PayRoll/) contient les classes PayInfo.java et Payroll.java ainsi que l'interface PayrollInterface.java

#### TimeLog
Le package [TimeLog](https://gitfront.io/r/SOSANE/kPwaKFRPRaNW/github-Houssein/tree/TimeLogCode/src/TimeLog/) contient les classes Activite.java, Administrateur.java, Employe.java, Projet.java, RapportEtat.java et TimeLog.java

**Concernant la classe *TimeLog.java***: Assurez-vous d'avoir modifié le chemin d'accès des variables *employeJSON* et *projetJSON* afin de pouvoir utiliser les fichiers JSON correctement.

### Externals JARs
Le fichier json-simple.jar est disponible pour téléchargement. Le dossier contient aussi le lien Internet de ma source. Veuillez consulter [Installation](#installation) pour plus de précision.

### Documents
Tous les fichiers PDF pertinents à la documentation se retrouvent dans le dossier [Documents](https://gitfront.io/r/SOSANE/kPwaKFRPRaNW/github-Houssein/tree/Documents/)

### Diagrammes
Les diagrammes de ce projet ont été conçus à l'aide du site [draw.io](https://app.diagrams.net/). Tous les diagrammes en format drawio pertinents sont inclus dans ce dossier. Les sous-dossiers [Diagramme initial](https://gitfront.io/r/SOSANE/kPwaKFRPRaNW/github-Houssein/tree/Diagrammes/Diagramme%20initial/) et [diags](). [Diagramme initial](https://gitfront.io/r/SOSANE/kPwaKFRPRaNW/github-Houssein/tree/Diagrammes/Diagramme%20initial/) contient plusieurs diagrammes qui représentent un croquis du projet et la phase initiale de la conception. Ces diagrammes sont à risque de modification tout au long de la conception du système. Le dossier [diags]() contient tous les diagrammes pour le livrable du projet final.


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

