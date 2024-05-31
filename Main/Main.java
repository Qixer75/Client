package Main;

import Client.Client;
public class Main {
    public static void main(String[] args) {
        int listClients = 10;
        Thread lisThread[] = new Thread[listClients];
        String name = "localhost";
        int port = 1234;
        
        for(int i = 0; i<listClients;i++)
        {
            lisThread[i] = new Thread(new Client(name, port,Integer.toString(i)));
            lisThread[i].start();
        }
    }
}
