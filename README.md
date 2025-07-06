# Employee-DB-App
# Task 7: Employee Database App

### 👩‍💻 By Aanchal Srivastav

---

## 📌 Objective

To create a **Java console-based application** using **JDBC** that connects to a **MySQL database** and performs basic **CRUD (Create, Read, Update, Delete)** operations on employee data.

---

## 🧰 Tools & Technologies

- Java  
- MySQL  
- JDBC (Java Database Connectivity)  
- VS Code / IntelliJ IDEA  
- MySQL Workbench or XAMPP (for DB)

---

## 🗂️ Features

- 🔄 Add new employees to the database  
- 📋 View all employee records  
- ✏️ Update an employee's salary  
- ❌ Delete employee data by ID  
- ✅ Uses `PreparedStatement`, `Connection`, and `ResultSet`

---

## 🛠️ Setup Instructions

### 1. MySQL Database Setup

Run the following SQL in your MySQL server:

```sql
CREATE DATABASE employee_db;

USE employee_db;

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    position VARCHAR(100),
    salary DOUBLE
);

