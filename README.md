# Movie Ticket System - Spring Boot Project

This project is a movie ticket booking system implemented using **Spring Boot**. The system is designed to handle concurrent requests using **Java concurrency** features such as synchronization, locks, and thread management. The application provides functionalities for movie management, seat selection, ticket booking, and payment (optional).

## Project Overview

The Movie Ticket System allows users to:

* View available movies and showtimes.
* Select seats for booking.
* View available seats in real-time to avoid double booking.
* Cancel a booking and release the seat.

This system utilizes Java's concurrency features to handle multiple booking requests from customers simultaneously without data inconsistencies such as double booking.

## Features

1. **Movie and ShowTime Management** (Optional):

   * Manage a list of available movies and showtimes.
   * Admins can add, delete, or update movie and showtime details.

2. **Seat Selection and Ticket Booking**:

   * Customers can choose a movie, select a showtime (optional), and pick available seats.
   * The system ensures that no seat is sold twice concurrently.

3. **Ticket Payment and Confirmation** (Optional):

   * Customers can pay for tickets after selecting seats.
   * The system confirms booking success or failure based on seat availability.

4. **Seat Status Management**:

   * Customers can cancel a booking and free up the seat for other users.
   * Changes to seat status (booked or cancelled) are synchronized to prevent race conditions.

## Technologies Used

* **Java 17.0.14+7-Ubuntu-124.04**
* **Spring Boot**: For building the web application.
* **Maven**: Apache Maven 3.8.7.
* **Thymeleaf**: For rendering dynamic web pages.
* **Spring Web**: For building the web services.
* **JSP** (optional): For server-side rendering of HTML (if used).

## Setup and Installation

### 1. Clone the repository:

Open your terminal and run the following commands:

```
git clone https://github.com/KhaiBoiPho/MovieTicketSystem.git
cd MovieTicketSystem
```

### 2. Install Dependencies:

Ensure you have **Java 17** and **Maven** installed. Then, run the following command to install project dependencies:

```
mvn clean install
```

### 3. Run the Application:

To run the project, execute:

```
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`.

## Project Structure

The project consists of the following key components:

* **Controllers**: Handle HTTP requests and interact with services.
* **Services**: Business logic for ticket booking and seat management.
* **Models**: Define entities such as Movies, Showtimes, and Seats.
* **Repositories**: Interface with the database to store movie and seat data.
* **Templates**: Dynamic views rendered using Thymeleaf.

## Notes

* This application uses **Java concurrency** features (synchronized blocks, locks) to handle concurrent ticket booking.
* If you face any issues or have suggestions for improvement, feel free to create an issue on GitHub.

---

Enjoy booking your movie tickets! 🎬

---
