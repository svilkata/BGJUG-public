package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = null;
        try {
            Executor threadPool = Executors.newFixedThreadPool(100);
            socket = new ServerSocket(9000);

            while (true) {  //the so-called busy wait server
                final Socket clientSocket = socket.accept();
                threadPool.execute(() -> {
                    BufferedReader reader = null;
                    BufferedWriter writer = null;
                    try {
                        reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        do {
                            String message = reader.readLine();
                            System.out.println(message);
                            if ("stop".equals(message)) {
                                writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                                writer.write("Hey Client - request finished!\n");
                                writer.flush();
                                break;
                            }
                        } while (true);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } finally {
                        try {
                            reader.close();
                            writer.close();
                            clientSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                });
            }
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
