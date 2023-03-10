# CompStore-App
_____________________________
This web application imitates the simple computer market work with JWT user authentication.

Project structure
-----------
Application is designed according to SOLID, REST principles, using DI and N-Tier Architecture patterns with next layers:
1. controllers layer;
2. services layer;
3. repositories layer;

Features
-----------
1. Register/Login
2. Display all items
3. Display items by concrete category
4. Display items by concrete id
5. Add items to shopping cart
6. Complete orders
7. Display all own orders(for users) or all orders (for admin)
8. Display all users etc.

Technologies
-----------
* Java 11
* Spring Stack (Boot, WEB, Data JPA, Security)
* Apache Maven
* Swagger
* MySQL
* Mapstruct

Usage
-----------
1. Install IntelliJ IDEA;
2. Clone this project from GitHub and make sure that an absolute path doesn't include any white spaces and/or non-latin
   symbols;
3. Install MySQL and MySQL Workbench;
4. Configure application.properties file to make a connection to your DB;
5. Run application;
6. Test application using Swagger-ui or Postman.
   1. There are some embedded users you can use for testing this app:

      user with ADMIN role:
         login: admin@i.ua
         password: admin1234
   
      users with USER role:
         login: userjohn@i.ua
         password: user1234
   
         login: userjane@i.ua
         password("user1234

List of allowed http methods with available endpoints
-----------
```
POST:/register
POST:/ login
POST: /users
GET: /users/{id}
GET: /users
PUT: /users/{id}
PATCH: /users/{id}
GET: /shopping-carts/by-user
POST: /orders
GET: /orders/{id}
GET: /orders
DELETE: /orders/{id}
PUT: /orders/{id}
GET: /items/{id}
GET: /items
DELETE: /items/{id}
GET: /computers/
GET: /computers/{id}
GET: /laptops; /desktops; /all-in-one;
GET: /laptops/{id}; /desktops/{id}; /all-in-one{id};
POST: /laptops; /desktops; /all-in-one;
PUT: /laptops/{id}; /desktops/{id}; /all-in-one{id};
DELETE: /laptops/{id}; /desktops/{id}; /all-in-one{id};
GET: /laptops/{id}/buy; /desktops/{id}/buy; /all-in-one{id}/buy;
