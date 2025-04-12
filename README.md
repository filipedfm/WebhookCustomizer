# Webhook Customizer

This project is a Java-based application designed to act as an intermediary for handling webhook requests. It is built using Spring Boot and aims to provide customizable handling of webhook payloads for various applications.

## Features

- **Webhook Handling**: The application can receive and process incoming webhook requests.
- **Custom Payload Processing**: It allows for manipulation of the incoming data to suit the needs of downstream services.
- **Forwarding to Downstream Services**: After processing, the application forwards the modified payload to a specified downstream service.
- **Authentication Support**: Includes support for adding an authentication token to requests sent to downstream services.
- **Spring Boot Framework**: Utilizes Spring Boot for easy setup and configuration.

## Project Structure

```
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── webhookcustomizer
│   │   │           ├── controller
│   │   │           │   └── WebhookController.java
│   │   │           ├── service
│   │   │           │   └── WebhookService.java
│   │   │           └── Application.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── logback.xml
│   └── test
│       └── java
│           └── com
│               └── webhookcustomizer
│                   └── WebhookControllerTest.java
├── pom.xml
├── LICENSE
└── README.md
```

## Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd <repository-root>
   ```

2. **Build the Project**:
   Ensure you have Maven installed, then run:
   ```bash
   mvn clean install
   ```

3. **Run the Application**:
   You can run the application using:
   ```bash
   mvn spring-boot:run
   ```

4. **Configure Webhook Endpoint**:
   Update the `application.properties` file to set the desired server port and other configurations:
   ```properties
   downstream.service.url=http://example.com/endpoint
   downstream.service.token=<your_token_here>
   ```

## Usage Guidelines

- The application listens for incoming webhook requests at the `/webhook` endpoint.
- Implement your custom logic in the `WebhookService` class to handle the incoming data as needed.
- The processed payload is forwarded to a downstream service, which can be configured in the `application.properties` file.
- The `downstream.service.token` is included in the `Authorization` header of requests sent to the downstream service.
- Unit tests are provided in the `WebhookControllerTest` class to ensure the functionality of the webhook handling.

## Contributing

Contributions are welcome! Please feel free to submit a pull request or open an issue for any enhancements or bug fixes.

## License

This project is licensed under the MIT License - see the LICENSE file for details.