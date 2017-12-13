# myRetail
Technologies
1. Java 1.8
2. Maven 3.3.9
3. MongoDB 3.6
4. SpringBoots 1.5.7 - Release
5. Feign (Rest Client) for external API
6. Swagger-UI 2.6.1
7. Mokito/Junits
8. Postman

Initial Setup
1. Install Java 1.8
2. Install Maven 3.3.9
3. Install MongoDB 3.6
4. Install Intellij IDE 2016.3.2
5. Install Git

Start With the module
1. Git clone the module.
2. Run the "mvn clean install" in cmd in the module folder
3. Import it to the intellij IDE
4. Run the MongoDB instance by trigger the mongod.exe and mongo.exe in the bin folder of the MongoDB
5. Trigger the application through "mvn spring-boot:run"

Application
There are 2 user in this application 
1. admin/admin - administrative privilege (read and write)
2. user/user - only read access.

For document path Swagger2 is used:
http://localhost:8080/swagger-ui.html

RESTful service 
1. GET: http://localhost:8080/products/{productId}
2. PUT: http://localhost:8080/products/{productId} (bonus)

Junit
Trigger "mvn test"


