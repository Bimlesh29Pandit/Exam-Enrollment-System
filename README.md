# 🎓 Exam Enrollment System - Spring Boot + PostgreSql

This is a RESTful API project for managing **Students**, **Subjects**, and **Exams** in a Learning Management System (LMS). The project uses **Spring Boot**, **PostgreSql**, **JPA**, and includes a fun **Easter Egg** feature that fetches random number facts from the [Numbers API](http://numbersapi.com/).

---

## 🚀 Features

- CRUD operations for:
  - Students
  - Subjects
  - Exams
- Student exam registration with validation
- Many-to-many and one-to-many relationships handled via JPA
- Global exception handling with `@ControllerAdvice`
- Easter Egg hidden feature using Numbers API
- Preloaded database with `data.sql`

---

## 🔧 Technologies Used

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- MySQL
- JUnit 5 & Mockito
- REST APIs
- Maven

---

## 🔗 API Endpoints

### 📚 Student

- `GET /students` - Get all students
- `GET /students/{id}` - Get a specific student
- `POST /students` - Add a new student
- `PUT /students` - Update a student
- `DELETE /students/{id}` - Delete a student
- `GET /student/subjectEnrollment?studentId={studentId}&subjectId={subjectId} ` - Student enroll in paticular subject

### 📘 Subject

- `GET /subjects` - Get all the subject
- `GET /subjects/{subjectId}` - Get the subject by subeject Id
- `POST /subjects`- Add a new subject
- `PUT /subejcts` - update a subject
- ` DELETE /subjects/{subjectId}` - Delete a particual subject

### 📝 Exam

- `GET /exams`
- `POST /exams`
- `POST /exams/{examId}?studentId={studentId}` - Register student for exam (must be enrolled in subject)
- `PUT

### 🥚 Easter Egg

- `GET /hidden-feature/{number}` - Returns a fun fact about the number

---

## 💾 Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/Bimlesh29Pandit/Exam-Enrollment-System.git
cd Exam-Enrollment-System

##Run the Project
./mvnw spring-boot:run (mac, linux based cmd)
mvnw.cmd spring-boot:run (window based cmd)

```
