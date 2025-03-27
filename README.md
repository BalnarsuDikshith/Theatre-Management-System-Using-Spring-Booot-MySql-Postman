# Theatre-Management-System-Using-Spring-Booot-MySql-Postman
A Spring Boot-based backend system for managing theatres, movies, ticket bookings, food ordering, and multiple theatre branches, with MySQL for database storage and Postman for API testing.

📌 Features
✅ User Management – Register, login, and view movies
✅ Movie Management – Add, update, and delete movies
✅ Theatre Management – Add, update, assign movies to theatres, and manage branches
✅ Ticket Booking – Book and cancel tickets, manage seat availability
✅ Food Ordering – Add food items, place orders, and manage menu
✅ Branch & Address Management – Multiple branches with addresses
✅ Admin Controls – Manage movies, theatres, food, and bookings

🛠️ Tech Stack
Backend: Spring Boot, Spring Data JPA

Database: MySQL

API Testing: Postman

ORM: Hibernate

Security: (Optional) JWT Authentication

🚀 API Endpoints

🎬 Movies & Theatres
Method	Endpoint	Description
POST	/movies	Add a new movie (Admin)
GET	/movies	Fetch all movies
POST	/theatres	Add a new theatre (Admin)
GET	/theatres	Fetch all theatres

🎟 Booking System
Method	Endpoint	Description
POST	/bookings	Book a ticket
DELETE	/bookings/{id}	Cancel a booking

🍔 Food Ordering
Method	Endpoint	Description
POST	/food	Add a new food item
GET	/food	Fetch available food items
POST	/orders	Place a food order

🏢 Branches & Address Management
Method	Endpoint	Description
POST	/branches	Add a new branch
GET	/branches	Fetch all branches
GET	/branches/{id}/address	Get branch address

--> Test APIs in Postman using http://localhost:8080
