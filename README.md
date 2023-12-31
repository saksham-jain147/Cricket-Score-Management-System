# Cricket-Score-Management-System
## Overview
The Cricket Score Management System is a Java application that allows users to manage and display cricket scores. It utilizes a MySQL database to store and retrieve score data. The system provides functionalities for viewing the scoreboard, inserting new records, updating existing records, and deleting records.

## Prerequisites
Before using this application, make sure you have the following prerequisites:

- **Java Development Kit (JDK):** Ensure you have a Java Development Kit (JDK) installed on your system.

- **MySQL Database:** You need a MySQL database server installed and running.

- **MySQL Connector/J (JDBC Driver):** Download and include the MySQL Connector/J (JDBC Driver) JAR file in your project.

- **Integrated Development Environment (IDE):** You can use any Java IDE, such as Eclipse, IntelliJ IDEA, or Visual Studio Code.

## Getting Started

1. **Clone or Download the Project:**
   Clone the project repository to your local machine using Git, or download it as a ZIP file from the project repository.

2. **Open the Project in Your IDE:**
   Import the project into your chosen Java IDE.

3. **Database Setup:**
   - Create a MySQL database named "cricket".
   - Create a table named "scoretable" with the following structure:

```sql
CREATE TABLE scoretable (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    runs INT,
    balls INT
);
