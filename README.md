💼 Payroll Management System

A simple Java-based Payroll System that allows users to manage employee records efficiently.
The system supports Full-Time and Part-Time employees and works with a MySQL database.

📌 Features

✔ Add Full-Time Employee
✔ Add Part-Time Employee
✔ Store employee details in MySQL
✔ View all employees
✔ Search employee by ID
✔ Object-Oriented structure (Inheritance, Classes, Methods, Encapsulation)

🛠️ Technologies Used
Component	Technology
Language	Java
Database	MySQL
IDE	VS Code
Concepts Used	OOP, JDBC, CRUD

📂 Project Structure
Payroll System
 ┣ 📁 src
 ┃ ┣ Employee.java
 ┃ ┣ FullTimeEmployee.java
 ┃ ┣ PartTimeEmployee.java
 ┃ ┣ Database.java
 ┃ ┗ Main.java
 ┣ README.md
 ┗lib
   ┣ mysql-connector-j-X.X.0.jar
   ┗ payroll.sql

🔧 Setup Instructions
1️⃣ Install Requirements
-Java JDK (17 or above recommended)
-MySQL Server
-VS Code or any Java IDE

2️⃣ Create Database
-Open MySQL and run:
-CREATE DATABASE payroll;
-USE payroll;
-CREATE TABLE employees (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50),
  type VARCHAR(20),
  salary DOUBLE
);

3️⃣ Update Database Credentials
In Database.java, edit:
String url = "jdbc:mysql://localhost:3306/payroll";
String user = "root";
String password = "your_mysql_password";

4️⃣ Compile & Run
javac src/*.java
java src.Main

🖥️ Sample Output
===== PAYROLL SYSTEM =====
1. Add Full-Time Employee
2. Add Part-Time Employee
3. View All Employees
4. Search Employee by ID
5. Exit
Enter choice:

📚 Concepts Demonstrated
-Inheritance: FullTimeEmployee & PartTimeEmployee extend Employee
-Polymorphism: Method overriding for salary handling
-Encapsulation: Private fields with constructors
-JDBC CRUD operations

🚀 Future Improvements
🔹 GUI using JavaFX or Swing
🔹 Export salary slips to PDF
🔹 User authentication
🔹 Web-based version using Spring Boot

👩‍💻 Author

Aarushi Patel
📍 BCA Student - 3rd Sem
📌 Project for learning Java, DBMS, and OOP

⭐ Support

If you like this project, please ⭐ the repository!
