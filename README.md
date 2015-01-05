gwtjerseyjpaexample
===================

This provide an example for the integration of a GWT web app that call a json restfull webservices developped using jersey. 

It uses autobean to do the marshalling/unmarshalling of JSON Object

To run it

```bash
mvn clean compile gwt:compile  package tomcat7:run-war-only

===================

Angularjs

Mon projet permet la création d'une personne.
Un rafraîchissement de la page permet d'afficher la base
de donnée avec les modifications apportées.
La fonction delete devrait effacer une personne mais elle efface toute la base de donnée.
(sûrement un souci avec l'instanciation de l'EntityManager)

GWT

Tentative d'implantation de la sélection d'une personne par l'ID.
