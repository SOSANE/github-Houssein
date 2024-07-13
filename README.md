# github-Houssein
Ceci est le répertoire de Sosane Mahamoud Houssein pour le devoir et projet final du cours INF1163 pendant le trimestre d'été 2024.

## Table des matières
[Introduction des systèmes](#introduction)

[Description](#description)

[Installation](#installation)

## Introduction 
TimeLog est un logiciel offre une assistance automatisé de calcul de temps, de salaires, et de contrôle de budget de ses projets. Ce système est installé sur une machine dédiée sur laquelle tout employé peut se connecter pour signaler des opérations divers.
Payroll est un sous-système appartenant à TimeLog qui produit et imprime (affiche dans ce projet) des chèques de paie aux deux semaines en lui envoyant en argument une liste d'objets.

## Description
Le projet a été écrit en java en utilisant le IDE Eclipse. Vous trouverez tous les fichiers à télécharger au préalable ainsi que les documents et les diagrammes décrivant le système TimeLog et le sous-système Payroll.
Le projet utilise des fichiers JSON pour stocker ses données.

## Installation
### Cloner le répertoire sur git
```bash
 git clone https://github.com/SOSANE/github-Houssein.git
```

### JSON comme éditeur de texte
*Si vous avez des difficultés à ouvrir, modifier ou utiliser les fichiers JSON, veuillez suivre les consignes ci-dessous en utilisant Eclipse IDE.*

Afin d'ouvrir des fichiers JSON sur Eclipse IDE, veuillez **cliquer Windows > Preferences > General > Editors > File association > Add (dans la section File types:)**

Une nouvelle fenêtre s'affichera, veuillez écrire dans l'espace texte ***.json** et **cliquez sur OK**

Dans la section **Associated editors:**, veuillez **cliquer sur Add...**

Une nouvelle fenêtre s'affichera, prenez l'option **Internal editors** et veuillez choisir **Text Editor** dans la liste d'éléments à choisir. **Cliquez sur OK sur les deux fenêtres.**

Si vous avez encore des difficultés, vous pouvez consulter la [vidéo suivante](https://youtu.be/16itKhkYh_A?si=fnAZifQsFt1KyQFQ)



À présent, vous devriez être en mesure d'ouvrir, modifier ou utiliser les fichiers JSON du projet.

### Json-simple
Le projet utilise [**json-simple**](https://code.google.com/archive/p/json-simple/) comme outil pour modifier ou décoder les fichiers JSON pour Java. 

Vous trouverez dans le dossier [External JARs](https://gitfront.io/r/SOSANE/kPwaKFRPRaNW/github-Houssein/tree/External%20JARs/) le fichier json-simple-1.1.1.jar. Pour faire fonctionner le code, veuillez télécharger ce fichier afin de pouvoir utilier les fichier JSON.

En utilisant Eclipse IDE, **clique droit sur le JAVA project ProjetFinal_INF1163 > Build Path > Configure Build Path > Libraries > Classpath > Add External JARs... > Apply and Close**.

