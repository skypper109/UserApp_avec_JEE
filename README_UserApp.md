# 📦 UserApp - Java EE Web Application

UserApp est une application web Java EE déployable sur un serveur Apache Tomcat. Elle permet la gestion des utilisateurs via un formulaire web avec traitement côté serveur à l’aide des Servlets, JSP, filtres, et fichiers CSS/JS.

---

## 🔧 Technologies Utilisées

- Java EE (Servlets, JSP)
- Apache Tomcat (serveur d’exécution)
- HTML/CSS + JavaScript
- WAR Packaging
- JDBC (si base de données intégrée)
- Filtres de validation (UserInsertionFilter)

---

## 📁 Structure du Projet

```
UserApp.war
│
├── WEB-INF/
│   ├── web.xml                 ← Fichier de configuration (mapping servlet, filtre, etc.)
│   └── classes/
│       ├── model/User.class
│       └── servlet/UserServlet.class
│           └── UserInsertionFilter.class
│
├── views/
│   ├── UserForm.jsp            ← Formulaire pour ajouter un utilisateur
│   ├── UserDetails.jsp         ← Vue des détails utilisateur
│   ├── script.js               ← JS (validation ou logique client)
│   └── style.css               ← Style de l'application
│
├── Error404.jsp                ← Page personnalisée pour erreurs 404
└── Errors.jsp                  ← Gestion des erreurs générales
```

---

## 🚀 Déploiement

1. Télécharger et installer [Apache Tomcat](https://tomcat.apache.org/).
2. Copier le fichier `UserApp.war` dans le dossier `webapps/` de Tomcat.
3. Démarrer Tomcat (`startup.bat` ou `catalina.sh`).
4. Accéder à l'application via `http://localhost:8080/UserApp/`.

---

## ✅ Fonctionnalités

- ➕ Ajouter un utilisateur via formulaire JSP.
- 📄 Affichage des détails utilisateur.
- 🔒 Filtrage/validation via `UserInsertionFilter`.
- ❌ Pages d’erreur personnalisées (404, globales).

---

## 📌 Auteurs & Contributeurs

Développé par [TonNomIci]  
Contact : [ton.email@example.com]