# Student Data Entry System with MySQL (Java + JDBC)

A clean, modular Java application to manage student data with persistent storage using MySQL and JDBC.

## 👩‍🎓 Student Info

- **Name:** Pranjali Vishwakarma  
- **PRN:** 2307126092  
- **Batch:** SY AIML B1  

---

## 📌 Functionalities

- Add Student  
- View All Students  
- Search Student by Roll No  
- Delete Student  

All data is stored and retrieved from a MySQL database using JDBC.

---

## 📁 File Descriptions

- `StudentMain.java` – Entry point of the application  
- `Student.java` – POJO class for student data  
- `DBConnection.java` – Handles DB connection logic  
- `StudentDAO.java` – Interface for operations  
- `StudentDAOImpl.java` – Actual implementation using JDBC

---

## ⚙️ How to Run

1. Setup MySQL and create database:
```sql
CREATE DATABASE studentdb;
USE studentdb;
CREATE TABLE students (
    roll_no INT PRIMARY KEY,
    name VARCHAR(50),
    age INT
);
