package plugins.geolocation;

import functional.tests.core.basetest.BaseTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TelnetClient extends BaseTest {

    private Socket socket = null;
    private PrintWriter out = null;
    private BufferedReader in = null;

    public void connect(String host, int port) throws IOException {
        try {
            this.socket = new Socket(host, port);
            this.out = new PrintWriter(this.socket.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            if (read() == false) {
                throw new IOException("IOException");
            }
             this.log.info("Telnet client connected!");
        } catch (UnknownHostException e) {
             this.log.fatal("Unknown host " + host + "!");
        } catch (IOException e) {
             this.log.fatal("Telnet client failed to connect!");
        }
    }

    public void write(String str) throws IOException {
         this.log.info("write: " + str);
        if (read() == false) {
            throw new IOException("IOException");
        }
    }

    public Boolean read() throws IOException {
        Boolean result;
        while (true) {
            String response = this.in.readLine();
             this.log.info("read: " + response);

            if (response.contains("OK")) {
                 this.log.info("Command accepted!");
                result = true;
                break;
            } else if (response.contains("KO")) {
                 this.log.error("Command rejected");
                result = false;
                break;
            } else {
                continue;
            }
        }
        return result;
    }

    public void disconnect() throws IOException {
        this.in.close();
        this.out.close();
        this.socket.close();
         this.log.info("Telnet client disconnected!");
    }
}
