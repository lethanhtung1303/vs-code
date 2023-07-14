import java.io.*;
import java.net.*;

public class PortScannerServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started and listening on port 5000...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String request = in.readLine();
                System.out.println("Received request: " + request);

                // Phân tích yêu cầu từ client để lấy địa chỉ IP, cổng bắt đầu và cổng kết thúc
                String[] requestParts = request.split(" ");
                if (requestParts.length != 3) {
                    out.println("Invalid request format. Please provide IP address, start port, and end port.");
                    clientSocket.close();
                    continue;
                }

                String ipAddress = requestParts[0];
                int startPort, endPort;
                try {
                    startPort = Integer.parseInt(requestParts[1]);
                    endPort = Integer.parseInt(requestParts[2]);
                } catch (NumberFormatException e) {
                    out.println(
                            "Invalid port number. Please provide valid integer values for start port and end port.");
                    clientSocket.close();
                    continue;
                }

                // Quét cổng và gửi kết quả về client
                String openPorts = scanPorts(ipAddress, startPort, endPort);
                out.println(openPorts);

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String scanPorts(String ipAddress, int startPort, int endPort) {
        StringBuilder openPorts = new StringBuilder();
        for (int port = startPort; port <= endPort; port++) {
            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(ipAddress, port), 1000);
                socket.close();
                openPorts.append(port).append(" ");
            } catch (IOException e) {
                // Port không mở
            }
        }
        return openPorts.toString().trim();
    }
}
