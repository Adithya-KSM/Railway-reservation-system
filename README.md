# 🎫 Ticket Reservation System

A Java-based console application for managing ticket bookings for trains. The system supports user registration, login, ticket booking, cancellations, schedule management, and admin operations.

---

## 📌 Features

### 👤 User Management
- Register and login
- View and update profile
- Admin and Customer roles

### 🎟️ Ticket Booking
- Search trains by station and date
- Book tickets by selecting coach and seat
- Cancel or modify bookings

### 💳 Payments
- Choose payment method: Card, UPI, or NetBanking
- Automatically assign seat upon successful booking

### 📅 Schedule Management
- View station-wise timing
- Admin can add new trains, coaches, and schedules

---

## 💻 Technologies Used

- **Java 17+**
- Console-based UI (no GUI)
- Java Collections (Map, List)
- Object-Oriented Programming (OOP)

---

## 📂 Folder Structure

```plaintext
TicketReservationSystem/
│
├── src/
│   ├── App.java           # Main class (entry point)
│   ├── User.java          # User class with enum UserType
│   ├── Profile.java       # Profile details and payment method enum
│   ├── Train.java         # Train class with schedule & coaches
│   ├── Coach.java         # Coach with seat availability logic
│   ├── Booking.java       # Booking details and status
│
├── README.md              # You're here!
├── .gitignore             # Optional, to ignore compiled files
└── bin/                   # Compiled .class files (can be ignored in Git)

```
---

## 🚀 Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/Adithya-KSM/Railway-reservation-system.git
cd Railway-reservation-system
```

### 2. Compile and Run

Using terminal:
```bash
javac src/*.java
java src.App
```
Or run from an IDE like VS Code or Eclipse.

## 🧪 Sample Test Flow

Register a new user
View profile and add address/payment method
Search for available trains
Book a seat
View booking details
Cancel the booking
