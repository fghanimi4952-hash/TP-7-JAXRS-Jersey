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





*Capture d'écran : Test de l'API avec SoapUI en format JSON*

### 3. Test avec SoapUI - Format XML

**URL :** `http://localhost:8082/banque/comptes`  
**Method :** GET  
**Headers :** `Accept: application/xml`

![SoapUI XML](screenshots/soapui-xml.png)

*Capture d'écran : Test de l'API avec SoapUI en format XML*

### 4. Test avec Postman

**GET - Tous les comptes :**
![Postman GET](screenshots/postman-get.png)

**POST - Créer un compte :**
![Postman POST](screenshots/postman-post.png)

**PUT - Modifier un compte :**
![Postman PUT](screenshots/postman-put.png)

**DELETE - Supprimer un compte :**
![Postman DELETE](screenshots/postman-delete.png)

### 5. Test dans le navigateur

**URL :** `http://localhost:8082/banque/comptes`

![Navigateur](screenshots/navigateur.png)

*Capture d'écran : Résultat dans le navigateur (format JSON)*

##  Endpoints API

### GET - Récupérer tous les comptes

```http
GET http://localhost:8082/banque/comptes
Accept: application/json
```

**Réponse JSON :**
```json
[
  {
    "id": 1,
    "solde": 8828.19,
    "dateCreation": "2025-11-05",
    "type": "EPARGNE"
  },
  {
    "id": 2,
    "solde": 1497.70,
    "dateCreation": "2025-11-05",
    "type": "COURANT"
  }
]
```

**Réponse XML :**
```xml
<List>
  <item>
    <id>1</id>
    <solde>8828.19</solde>
    <dateCreation>2025-11-05</dateCreation>
    <type>EPARGNE</type>
  </item>
</List>
```

### GET - Récupérer un compte par ID

```http
GET http://localhost:8082/banque/comptes/1
Accept: application/json
```

### POST - Créer un nouveau compte

```http
POST http://localhost:8082/banque/comptes
Content-Type: application/json

{
  "solde": 5000,
  "dateCreation": "2025-11-05",
  "type": "COURANT"
}
```

### PUT - Modifier un compte

```http
PUT http://localhost:8082/banque/comptes/1
Content-Type: application/json

{
  "solde": 8000,
  "dateCreation": "2025-11-05",
  "type": "EPARGNE"
}
```

### DELETE - Supprimer un compte

```http
DELETE http://localhost:8082/banque/comptes/1
```

##  Tests avec cURL

### Récupérer tous les comptes (JSON)
```bash
curl http://localhost:8082/banque/comptes
```

### Récupérer tous les comptes (XML)
```bash
curl -H "Accept: application/xml" http://localhost:8082/banque/comptes
```

### Récupérer un compte par ID
```bash
curl http://localhost:8082/banque/comptes/1
```

### Créer un nouveau compte
```bash
curl -X POST http://localhost:8082/banque/comptes \
  -H "Content-Type: application/json" \
  -d '{"solde":5000,"dateCreation":"2025-11-05","type":"COURANT"}'
```

### Modifier un compte
```bash
curl -X PUT http://localhost:8082/banque/comptes/1 \
  -H "Content-Type: application/json" \
  -d '{"solde":8000,"dateCreation":"2025-11-05","type":"EPARGNE"}'
```

### Supprimer un compte
```bash
curl -X DELETE http://localhost:8082/banque/comptes/1
```

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

- ✅ API REST complète (CRUD)
- ✅ Support JSON et XML
- ✅ Base de données H2 en mémoire
- ✅ Initialisation automatique des données
- ✅ Configuration Jersey pour JAX-RS
- ✅ Entité JPA avec annotations
- ✅ Repository Spring Data JPA

## 📚 Ressources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Jersey Documentation](https://eclipse-ee4j.github.io/jersey/)
- [JAX-RS Specification](https://jakarta.ee/specifications/restful-ws/)
- [H2 Database](https://www.h2database.com/)

## 👤 Auteur

Projet réalisé dans le cadre du cours **Architecture Microservices : Conception, Déploiement et Orchestration**



Ce projet est un travail pratique éducatif.

---

**Note :** N'oubliez pas d'ajouter vos captures d'écran dans le dossier `screenshots/` pour illustrer ce README.

