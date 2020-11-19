package _02_Chat_Application;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Server extends Thread {
    private Socket connection;
    private ChatApp chatApp;
    private ObjectOutputStream os;
    private ObjectInputStream is;

    public Server(ChatApp app, Socket socket) {
        this.chatApp = app;
        this.connection = socket;
    }

    public void run() {

        try {
            os = new ObjectOutputStream( this.connection.getOutputStream() );
            is = new ObjectInputStream( this.connection.getInputStream() );

            os.flush();
        } catch( Exception e ) {
            e.printStackTrace();
        }

        while( connection.isConnected() ) {
            try {
                // This method blocks until there is data to read 
                String message = (String)is.readObject();
                
                chatApp.addMessageToWindow( true, message );
            } catch( ClassNotFoundException | IOException e ) {
                JOptionPane.showMessageDialog( null, "Connection Lost" );
                e.printStackTrace();
            }
        }
    }

    public static String getIPAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch( UnknownHostException e ) {
            return "ERROR!!!!!";
        }
    }

    public void sendMessage(String message) {
        try {
            if( os != null ) {
                os.writeObject( message );
                os.flush();
            }
        } catch( IOException e ) {
            e.printStackTrace();
        }
    }
}
