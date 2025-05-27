import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        int port = 12345; // Server port
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started. Waiting for clients on port " + port + "...");
            Socket clientSocket = serverSocket.accept(); // Accept client connection
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            // Set up streams for communication
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            String clientMsg, serverMsg;

            // Loop to read client messages and send responses
            while (true) {
                // Read from client
                clientMsg = in.readLine();
                if (clientMsg == null || clientMsg.equalsIgnoreCase("bye")) {
                    System.out.println("Client disconnected.");
                    break;
                }
                System.out.println("Client: " + clientMsg);

                // Read input from server user
                System.out.print("Server: ");
                serverMsg = stdIn.readLine();
                out.println(serverMsg);

                if (serverMsg.equalsIgnoreCase("bye")) {
                    System.out.println("Connection closed by server.");
                    break;
                }
            }

            // Close everything
            in.close();
            out.close();
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
