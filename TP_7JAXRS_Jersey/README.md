# TP 7 : JAX-RS / Jersey

## 📋 Description du projet

Ce projet est une application Spring Boot qui implémente une API REST avec JAX-RS/Jersey pour gérer des comptes bancaires. L'application utilise une base de données H2 en mémoire et supporte les formats JSON et XML.

## 🛠️ Technologies utilisées

- **Spring Boot** 3.2.0
- **JAX-RS / Jersey** pour les services REST
- **Spring Data JPA** pour l'accès aux données
- **H2 Database** (base de données en mémoire)
- **JAXB** pour la sérialisation XML
- **Lombok** (remplacé par des getters/setters manuels)

## 📁 Structure du projet

```
jaxrs/
├── pom.xml
├── src/main/java/ma/ws/jaxrs/
│   ├── JaxrsApplication.java          # Application principale Spring Boot
│   ├── config/
│   │   └── MyConfig.java              # Configuration Jersey
│   ├── controllers/
│   │   └── CompteRestJaxRSAPI.java    # Contrôleur REST
│   ├── entities/
│   │   ├── Compte.java                # Entité JPA
│   │   └── TypeCompte.java            # Énumération
│   └── repositories/
│       └── CompteRepository.java      # Repository JPA
└── src/main/resources/
    └── application.properties         # Configuration H2
```

## 🚀 Installation et démarrage

### Prérequis
- Java 17 ou supérieur
- Maven 3.6+

### Étapes d'installation

1. **Cloner ou télécharger le projet**

2. **Compiler le projet**
```bash
mvn clean compile
```

3. **Lancer l'application**
```bash
mvn spring-boot:run
```

L'application sera accessible sur `http://localhost:8082`

## 📸 Captures d'écran

### 1. Console H2 - Base de données

**Accès :** `http://localhost:8082/h2-console`

**Configuration de connexion :**
- JDBC URL : `jdbc:h2:mem:banque`
- User : `sa`
- Password : (vide)

![Console H2](screenshots/h2-console.png)

*Capture d'écran : Console H2 montrant les comptes créés dans la base de données*

### 2. Test avec SoapUI - Format JSON

**URL :** `http://localhost:8082/banque/comptes`  
**Method :** GET  
**Headers :** `Accept: application/json`

![SoapUI JSON](screenshots/soapui-json.png)

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

## 🔌 Endpoints API

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

## 🧪 Tests avec cURL

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

## 📝 Configuration

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

## 🎯 Fonctionnalités

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

## 📄 Licence

Ce projet est un travail pratique éducatif.

---

**Note :** N'oubliez pas d'ajouter vos captures d'écran dans le dossier `screenshots/` pour illustrer ce README.

