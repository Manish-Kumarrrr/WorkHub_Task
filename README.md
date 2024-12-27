# WorkHub_Task_Service

WorkHub_Task_Service is a microservice responsible for managing tasks within the **WorkHub** ecosystem. It handles the creation, modification, and management of tasks, ensuring scalability and efficiency with the integration of Kafka for messaging and MongoDB for storage.

## Key Responsibilities

- **Task Management**: 
  - Create and update tasks.
  - Support pagination for efficient task retrieval.
- **Messaging**: Uses Kafka as a message queue for scalable and asynchronous task processing.
- **Database**: Stores and retrieves task data in MongoDB.

## Technology Stack

- **Backend**: Spring Boot
- **Database**: MongoDB
- **Messaging**: Apache Kafka
- **Pagination**: Built-in support for efficient data retrieval.

## Prerequisites

Ensure the following are installed and configured:

- **Java**: Version 19
- **MongoDB**: Running and accessible.
- **Kafka**: Running with configured topics for task processing.
## Getting Started

Follow the steps below to set up and run WorkHub locally:

### Step 1: Clone the Repository

```bash
git clone https://github.com/Manish-Kumarrrr/WorkHub_Task_Service.git
cd WorkHub_Task_Service
```
### Step 2: Configuration

#### `application.yml`

```yaml
server:
  port: 8082

spring:
  data:
    mongodb:
      host: localhost
      port: 27017
      database: taskdb

kafka:
  bootstrap-servers: localhost:9092
  topics:
    task-topic: workhub-task
```
## Step 3: Start the application
Run the following commands to start the server:
```bash
./mvnw spring-boot:run
```

This `README.md` provides a high-level overview of the service and its features without delving into specific API endpoint details.

