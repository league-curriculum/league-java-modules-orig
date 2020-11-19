package _02_Chat_Application;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class ChatApp implements KeyListener {
    static final int WIDTH = 400;
    static final int HEIGHT = 300;

    boolean isServer;
    ServerSocket serverSocket = null;
    int port = 8080;

    Client client = null;
    ArrayList<Server> servers = null;
    Boolean previousMessageIncoming = null;

    Font textFieldFont = new Font( "Arial", Font.PLAIN, 18 );
    String message = "";
    String oldMessages = "<html>";
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JTextField textField = new JTextField();
    JTextPane area = new JTextPane();
    JScrollPane scroll = new JScrollPane( area, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED );

    public static void main(String[] args) {
        new ChatApp();
    }

    public ChatApp() {
        this.servers = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        int response = JOptionPane.showConfirmDialog( null, "Would you like to host a connection?", "Buttons!",
                JOptionPane.YES_NO_OPTION );

        if( response == JOptionPane.YES_OPTION ) {
            isServer = true;            

            try {
                this.serverSocket = new ServerSocket( port, 100 );
                setupServerApp();
                
                String date = formatter.format( LocalDateTime.now() );
                System.out.println( date + " - Server started at: " + "Port " + port );
            } catch( IOException e1 ) {
                e1.printStackTrace();
            }

            // Stay in loop and handle any incoming connections from clients
            while( this.serverSocket != null ) {
                try {
                    // This instruction blocks/listens until a connection from the client
                    Socket socket = this.serverSocket.accept();

                    // Connection is made, start a new server thread
                    Server server = new Server( this, socket );
                    this.servers.add( server );
                    server.start();

                } catch( Exception e ) {
                    e.printStackTrace();
                }
            }
        } else {
            isServer = false;

            setupClientApp();
            client = new Client( this, Server.getIPAddress(), this.port );
            client.start();
            
            String date = formatter.format( LocalDateTime.now() );
            System.out.println( date + " - Client started at: " + Server.getIPAddress() + ", Port: " + port );
        }
    }

    private void setupServerApp() {
        frame.setTitle( "SERVER" );
        setupWindow();
    }

    private void setupClientApp() {
        frame.setTitle( "CLIENT" );
        setupWindow();
    }

    private void setupWindow() {
        // Setup frame
        frame.setVisible( true );
        frame.setSize( ChatApp.WIDTH, ChatApp.HEIGHT );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // Setup panel
        panel.setLayout( new BoxLayout( panel, BoxLayout.Y_AXIS ) );
        panel.setPreferredSize( new Dimension( ChatApp.WIDTH, ChatApp.HEIGHT ) );
        frame.add( panel );

        // Setup label and text field
        area.setEditable( true );
        // area.setLineWrap(true);
        area.setFont( new Font( "Arial", Font.BOLD, 12 ) );
        scroll.setPreferredSize( new Dimension( ChatApp.WIDTH, ( ChatApp.HEIGHT * 3 ) / 4 ) );

        textField.setFont( textFieldFont );
        textField.setPreferredSize( new Dimension( ChatApp.WIDTH, ChatApp.HEIGHT / 4 ) );
        textField.setBorder( BorderFactory.createLineBorder( Color.GREEN, 2 ) );
        textField.addKeyListener( this );

        panel.add( scroll );
        panel.add( textField );

        frame.pack();
    }

    public void addMessageToWindow(boolean isIncomingMessage, String message) {
        message = message + "\n";
        
        // Add new line to separate server and client message blocks
        if( previousMessageIncoming != null && previousMessageIncoming != isIncomingMessage ) {
            appendToPane( area, "\n", Color.WHITE );
        }
        
        previousMessageIncoming = isIncomingMessage;
        
        if( isIncomingMessage ) {
            int hex = 0xFF0000;              // Red
            int r = (hex & 0xFF0000) >> 16;
            int g = (hex & 0xFF00) >> 8;
            int b = (hex & 0xFF);
            int alpha = 127;
            appendToPane( area, message, new Color( r, g, b, alpha ) );
        } else {
            int hex = 0x0000FF;              // Blue
            int r = (hex & 0xFF0000) >> 16;
            int g = (hex & 0xFF00) >> 8;
            int b = (hex & 0xFF);
            int alpha = 127;
            appendToPane( area, "          ", Color.WHITE );
            appendToPane( area, message, new Color( r, g, b, alpha ) );
        }
        
        frame.pack();
    }

    private void appendToPane(JTextPane tp, String message, Color bgColor) {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute( SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.BLACK );

        aset = sc.addAttribute( aset, StyleConstants.FontFamily, "Arial" );
        aset = sc.addAttribute( aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED );
        aset = sc.addAttribute( aset, StyleConstants.Background, bgColor );
        aset = sc.addAttribute( aset, StyleConstants.FontSize, 18 );
        
        int len = tp.getDocument().getLength();
        tp.setCaretPosition( len );
        tp.setCharacterAttributes( aset, false );
        tp.replaceSelection( message );
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if( keyCode == KeyEvent.VK_ENTER ) {
            message = textField.getText();

            addMessageToWindow( false, message );

            if( isServer ) {
                // Send messages to all clients
                for( Server server : servers ) {
                    server.sendMessage( message );
                }
            } else {
                client.sendMessage( message );
            }

            // Reset
            message = "";
            textField.setText( "" );
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
    }
}
