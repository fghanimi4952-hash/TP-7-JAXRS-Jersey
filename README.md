[README.md](https://github.com/user-attachments/files/23357741/README.md)
# TP 7 : JAX-RS / Jersey

## Description du projet

Ce projet est une application Spring Boot qui implémente une API REST avec JAX-RS/Jersey pour gérer des comptes bancaires. L'application utilise une base de données H2 en mémoire et supporte les formats JSON et XML.

## Technologies utilisées

- **Spring Boot** 3.2.0
- **JAX-RS / Jersey** pour les services REST
- **Spring Data JPA** pour l'accès aux données
- **H2 Database** (base de données en mémoire)
- **JAXB** pour la sérialisation XML
- **Lombok** (remplacé par des getters/setters manuels)

##  Structure du projet

<img width="596" height="628" alt="Capture d’écran 2025-11-05 à 11 46 41" src="https://github.com/user-attachments/assets/8215af5c-105b-483c-b021-f981ae00fa49" />


## Captures d'écran

### 1. Console H2 - Base de données

**Accès :** `http://localhost:8082/h2-console`
<img width="755" height="504" alt="Capture d’écran 2025-11-05 à 13 15 31" src="https://github.com/user-attachments/assets/022c741a-b1bb-4500-bb10-50c5ba33b2fc" />
<img width="1273" height="399" alt="Capture d’écran 2025-11-05 à 13 07 55" src="https://github.com/user-attachments/assets/ef000a5d-cd8e-4872-89d2-49fb484d2d98" />



![Console H2](screenshots/h2-console.png)


### 2. Test avec SoapUI - Format JSON

**URL :** `http://localhost:8082/banque/comptes`  
**Method :** GET  
**Headers :** `Accept: application/json`

<img width="1216" height="711" alt="Capture d’écran 2025-11-05 à 13 20 19" src="https://github.com/user-attachments/assets/2ff8c6dc-faad-4c75-b6dc-cb884979e936" />



**URL :** `http://localhost:8082/banque/comptes`

![Navigateur](screenshots/navigateur.png)

*Capture d'écran : Résultat dans le navigateur (format JSON)*



##  Configuration

### application.properties

```properties
spring.datasource.url=jdbc:h2:mem:banque
server.port=8082
```

### Données initiales

L'application crée automatiquement 3 comptes au démarrage :
- 2 comptes EPARGNE
- 1 compte COURANT

Les soldes sont générés aléatoirement entre 0 et 9000.

##  Fonctionnalités

-  API REST complète (CRUD)
-  Support JSON et XML
-  Base de données H2 en mémoire
-  Initialisation automatique des données
-  Configuration Jersey pour JAX-RS
-  Entité JPA avec annotations
-  Repository Spring Data JPA

## 📚 Ressources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Jersey Documentation](https://eclipse-ee4j.github.io/jersey/)
- [JAX-RS Specification](https://jakarta.ee/specifications/restful-ws/)
- [H2 Database](https://www.h2database.com/)



Projet réalisé dans le cadre du cours **Architecture Microservices : Conception, Déploiement et Orchestration**




