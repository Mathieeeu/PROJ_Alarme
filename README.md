Mini-Projet INFO641 : Simulateur pour gestion des alarmes
=========================================================
Problème proposé
----------------
Un grand laboratoire de physique fait face à plusieurs risques liés aux :
- incendies qui peuvent surgir dans chacun des bâtiments qui le composent,
- émission de radiations,
- émission de gaz toxiques.
Le service de sécurité du laboratoire veut mettre en place un systeme de capteurs lui permettant de détecter les incendies, une réfrigération défectueuse, des radiations ou émissions de gaz au dessus du seuil de sécurité.

La décision est prise d’utiliser un système à évènements Java.

Les capteurs sont spécifiques à chaque risque mentionné et génèrent des alarmes concernant les anomalies. Pour toutes les anomalies, on indique la date de l’apparition, la localisation et le niveau d’importance (variant de 1 à 3). En plus de ces informations : 
- Pour l’émission de gaz il faut indiquer le type émis (hydrogène, hélium, CO2, etc.).
- Pour les radiations il faut indiquer le niveau de radiation (variant entre 1 et 100).

Le service de sécurité veut mettre en place différents types de moniteurs dans ses salles de contrôle :
- Les moniteurs de type A sont capables de gérer des alarmes de type gaz et feu (destinés aux pompiers).
- Les moniteurs de type B sont capables de gérer des alarmes de type gaz et radiation (service environnement).

Fonctionnement
--------------
Lors de l'execution du programme, deux interfaces graphiques s'ouvrent :
- La première interface permet de simuler l'apparition d'une anomalie (incendie, fuite de gaz ou radiations) dans un bâtiment du laboratoire. Il est possible de choisir le type d'anomalie, le bâtiment et le niveau d'importance de l'anomalie, ainsi que les informations spécifiques à chaque type d'anomalie (type de gaz émis ou niveau de radiation par exemple). Lorsqu'une anomalie est simulée, une alarme est générée et envoyée à tous les moniteurs de type A et B.
- La deuxième interface permet de visualiser les alarmes reçues par les moniteurs de type A et B. Les alarmes sont affichées dans une liste selon le moniteur choisi. Il est possible d'afficher les détails de chaque alarme en cliquant dessus et de les supprimer de la liste si elles sont traitées.
