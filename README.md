# Live-Class Application


Welcome to the **Live-Class Application**! This project implements a dynamic system using **Spring Boot** for scheduling and managing live classes. The goal is to create, manage, and schedule live classes while avoiding conflicts in user schedules. It is optimized with in-memory data structures for performance, modularity, and ease of use.


## 🚀 Features


### Functional Features:
1. **Create and Manage Live Classes**:
   - Easily create live classes with specific schedules.
   - Assign multiple users to a class while avoiding schedule conflicts.


2. **Real-time User Assignment**:
   - Assign users to multiple classes without overlapping their schedules.
   - Ensure no user is double-booked at any given time.


### Bonus Features:
1. **Display Users in a Live Class**:
   - Retrieve and display a list of all users assigned to a particular live class.


2. **User Schedule Display**:
   - View a user's current schedule categorized into:
     - **Upcoming Classes**
     - **In-Progress Classes**
     - **Historical Classes**


## 🛠️ Technologies Used
- **Spring Boot**: For building a robust backend.
- **In-Memory Data Structures**: Efficient use of `HashMap`, `Set`, `List` to store and retrieve data.
- **RESTful APIs**: For seamless interaction with the system.


## 📚 API Documentation


### Live-Class Creation:
- **POST** `/live-class/create`
  - Request Body: `{ "className": "Math Class", "startTime": "2024-10-25T09:00", "endTime": "2024-10-25T11:00" }`
  - Response: `{ "classId": "1", "message": "Live class created successfully." }`


### Assign Users:
- **POST** `/live-class/assign`
  - Request Body: `{ "classId": 1, "userId": 101 }`
  - Response: `{ "message": "User assigned successfully." }`
  - Error: `{ "error": "Schedule conflict!" }`


### Display Users in a Live Class:
- **GET** `/live-class/users/{classId}`
  - Response: `[ { "userId": 101, "userName": "John Doe" }, ... ]`


### Display User's Schedule:
- **GET** `/user/schedule/{userId}`
  - Response: `{ "upcoming": [ ... ], "inProgress": [ ... ], "historical": [ ... ] }`


## ⚙️ Non-Functional Requirements
- **Optimized Performance**: Leveraging in-memory data structures for fast schedule conflict checking.
- **Modular Design**: The application follows a modular structure for easy future extension (e.g., adding notifications, recurring classes).
- **Error Handling**: Comprehensive error handling, especially for schedule conflicts.


## 💡 Extensibility Ideas
- **Notification System**: Send notifications to users when they are assigned to a class.
- **Recurring Classes**: Add functionality for recurring live classes on a daily/weekly basis.


## 📦 Installation & Setup


1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/live-class-app.git
   ```
2. Navigate to the project directory:
   ```bash
   cd live-class-app
   ```
3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Access the APIs at `http://localhost:8080`.


## THANK YOU :)