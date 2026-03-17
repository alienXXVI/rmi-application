# Measurement Converter RMI
## Description
This project is a distributed Measurement Converter application built in Java using Remote Method Invocation (RMI). It allows a client to perform various unit conversions (temperature, distance, weight, time, and height) by invoking methods on a remote server.

## Technologies
-   **Java SE**
-   **Java RMI (Remote Method Invocation)**
-   **TCP/IP** (Protocol used by RMI for network communication)

## Features
-   **Distributed Architecture:** Decouples the user interface (client) from the business logic (server).
-   **Multiple Conversion Categories:** Supports Celsius/Fahrenheit, Kilometers/Miles, Kilograms/Pounds, and more.
-   **Remote Logging:** The server logs every requested operation to its console for monitoring.
-   **Network Support:** Can be executed on a single machine via `localhost` or across different machines in a local network.

## How to Run

### 1. Compile the Project
Open your terminal in the project root and run:

    javac *.java

### 2. Start the Server
Run the server application:

    java ServerConverter

The server will initialize the RMI registry on port **2001** and wait for connections.

### 3. Start the Client
In a new terminal, run the client:

    java ClientConverter

If you are running across a network, provide the server's IP address as an argument:

    java ClientConverter <SERVER_IP>

## Project Structure

-   **`Converter.java`**: The Remote Interface that defines the available conversion methods.
    
-   **`ServerConverter.java`**: The server implementation that contains the math logic for conversions and exports the remote object.
    
-   **`ClientConverter.java`**: The client application providing a command-line interface for the user to input values.
    
-   **`.gitignore`**: Specifies files and directories (like `.class` files or IDE configs) to be ignored by Git.
    
-   **`README.md`**: Project documentation.

## What I Learned

-   **Distributed Systems Concepts:** Implementing the RMI lifecycle, including defining interfaces, exporting remote objects, and using the RMI Registry.
-   **Network Programming:** Configuring system properties (like `java.rmi.server.hostname`) to allow communication between different hosts on a LAN.
-   **Stub/Skeleton Mechanism:** Understanding how Java handles proxy objects to make remote calls feel like local method calls.


## Future Improvements

-   **GUI Implementation:** Replace the command-line interface with a JavaFX or Swing graphical interface.
-   **Dynamic Port Allocation:** Allow the port number to be passed as a command-line argument instead of being hardcoded to 2001.
-   **Enhanced Security:** Implement a Security Manager or SSL/TLS for encrypted RMI communication.
