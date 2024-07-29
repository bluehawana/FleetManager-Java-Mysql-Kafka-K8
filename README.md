# Fleet Manager Project

## Project Overview
The Fleet Manager is a comprehensive fleet management system that includes a backend built using Java, MySQL, Kafka, Kubernetes, and Docker, as well as a frontend dashboard built with React, TypeScript, and Tailwind CSS. It provides a suite of features to help organizations effectively manage and monitor their vehicle fleets.

## Key Features

1. **Vehicle Tracking**: The system integrates with GPS devices and sensors in the vehicles to track their real-time positions, speeds, and other telemetry data.
2. **Fuel Management**: The application calculates the fuel consumption and costs for each vehicle based on distance traveled and fuel prices.
3. **Temperature Monitoring**: The system monitors the temperature inside the vehicles, allowing fleet managers to ensure proper environmental conditions for transported goods.
4. **Analytics Dashboard**: The frontend dashboard built with React, TypeScript, and Tailwind CSS provides a user-friendly interface for fleet managers to visualize and analyze various fleet-related data.
5. **API for Fleet Analytics**: The project exposes a RESTful API that allows users to retrieve various analytics and reports about the fleet, such as:
   - Vehicle positions and routes
   - Fuel consumption and costs
   - Temperature data

## Technologies Used

### Backend
- **Java**: The core of the application is built using Java, leveraging frameworks like Spring Boot for web development and data management.
- **MySQL**: The application uses MySQL as the primary database for storing vehicle, driver, and fleet-related data.
- **Kafka**: Apache Kafka is used as the message broker, handling real-time data streams from the vehicles and integrating with the core application.
- **Kubernetes**: The application is containerized using Docker and deployed on a Kubernetes cluster, ensuring scalability and high availability.
- **Heroku**: The entire application is deployed on the Heroku cloud platform, providing a seamless and scalable hosting solution.

### Frontend
- **React**: The frontend dashboard is built using the React JavaScript library for building user interfaces.
- **TypeScript**: TypeScript is used to add static typing to the codebase, improving maintainability and developer productivity.
- **Tailwind CSS**: The Tailwind CSS utility-first CSS framework is used for styling the frontend components, providing a consistent and responsive design.

## API Endpoints

The Fleet Manager project exposes the following API endpoints:

1. **Vehicle Position**: `GET /api/vehicles/{id}/position`
   - Retrieves the current position, speed, and other telemetry data for a specific vehicle.
2. **Fuel Consumption**: `GET /api/vehicles/{id}/fuel`
   - Calculates the fuel consumption and costs for a specific vehicle over a given time period.
3. **Temperature Data**: `GET /api/vehicles/{id}/temperature`
   - Retrieves the temperature data for a specific vehicle over a given time period.

## Getting Started

To set up the Fleet Manager project locally, follow these steps:

1. Clone the repository: `git clone https://github.com/your-username/fleet-manager.git`
2. Set up the MySQL database and configure the connection details in the application.properties file.
3. Configure the Kafka broker settings in the application.properties file.
4. Build and run the Java backend application:
   - `cd backend`
   - `mvn clean install`
   - `java -jar target/fleet-manager.jar`
5. Set up the frontend development environment:
   - `cd frontend`
   - `npm install`
   - `npm start`
6. (Optional) Set up the Kubernetes deployment and Heroku hosting following the provided documentation.

## Contributing
Contributions to the Fleet Manager project are welcome. Please follow the standard GitHub workflow of forking the repository, creating a new branch, making your changes, and submitting a pull request.

## License
This project is licensed under the [MIT License](LICENSE).