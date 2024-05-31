package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable
{
    String host;
    int port;
    String thName;
    public Client(String host, int port,String thName)
    {
        this.host = host;
        this.port = port;
        this.thName = thName;
    }

    public String getThname()
    {
        return thName;
    }

    @Override
    public void run() {
                // establish a connection by providing host and port 
        // number 
        try (Socket socket = new Socket(host,port)) { 
            
            // writing to server 
            PrintWriter out = new PrintWriter( 
                socket.getOutputStream(), true); 
  
            // reading from server 
            BufferedReader in 
                = new BufferedReader(new InputStreamReader( 
                    socket.getInputStream())); 
  
            // object of scanner class 
            String send = "Client:" + thName + "send text";
            String line = null; 
  
            while (!"exit".equalsIgnoreCase(line)) { 
                
                // reading from user 
                line = send; 
  
                // sending the user input to server 
                out.println(line); 
                out.flush(); 
  
                // displaying server reply 
                System.out.println("Thread Client " + thName + " send line: "
                                   + in.readLine()); 
                Thread.sleep(1000);
            } 
            
            // closing the scanner object 
        } 
        catch (IOException e) { 
            e.printStackTrace(); 
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}