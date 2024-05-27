package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket  = null;
        BufferedWriter writer = null;

        try {
            socket = new Socket("localhost", 9000);
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write("message1\n");
            writer.write("message2\n");
            writer.write("stop\n");
            writer.flush(); //за да изпратом съобщението към сървъра

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = reader.readLine();
            System.out.println(message);
            writer.close();
            reader.close();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
