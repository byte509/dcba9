import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        final int PORT = 5000;

        System.out.println("Starting Server...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            System.out.println("Server is listening on port " + PORT);

            // Accept client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress());

            // Input and Output streams
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            // Read message from client
            String clientMessage = input.readLine();
            System.out.println("Client says: " + clientMessage);

            // Send response to client
            output.println("Hello from Server!");

            // Close connection
            socket.close();
            System.out.println("Connection closed.");

        } catch (IOException e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}



code2:
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PORT = 5000;

        System.out.println("Starting Client...");

        try (Socket socket = new Socket(HOST, PORT)) {

            System.out.println("Connected to Server");

            // Input and Output streams
            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // Send message to server
            output.println("Hello Server!");

            // Receive response from server
            String serverResponse = input.readLine();
            System.out.println("Server says: " + serverResponse);

        } catch (IOException e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}