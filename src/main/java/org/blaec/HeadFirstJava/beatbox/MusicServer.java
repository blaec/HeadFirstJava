package org.blaec.HeadFirstJava.beatbox;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MusicServer {
    List<ObjectOutputStream> clientOutputStream;

    public static void main(String[] args) {
        new MusicServer().go();
    }

    public class ClientHandler implements Runnable {
        ObjectInputStream in;
        Socket clientSocket;

        public ClientHandler(Socket socket) {
            try {
                this.clientSocket = socket;
                in = new ObjectInputStream(clientSocket.getInputStream());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            Object o2;
            Object o1;
            try {

                while ((o1 = in.readObject()) != null) {
                    
                    o2 = in.readObject();

                    System.out.println("read two objects");
                    tellEveryone(o1,o2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void go() {
        clientOutputStream = new ArrayList<>();

        try {
            ServerSocket serverSocket = new ServerSocket(4242);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                clientOutputStream.add(out);

                Thread t = new Thread(new ClientHandler(clientSocket));
                t.start();

                System.out.println("got a connection");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void tellEveryone(Object one, Object two) {
        Iterator it = clientOutputStream.iterator();
        while (it.hasNext()) {
            try {
                ObjectOutputStream out = (ObjectOutputStream) it.next();
                out.writeObject(one);
                out.writeObject(two);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
