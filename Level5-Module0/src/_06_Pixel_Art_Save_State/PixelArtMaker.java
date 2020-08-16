package _06_Pixel_Art_Save_State;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PixelArtMaker implements MouseListener, ActionListener {
    private JFrame window;
    private GridInputPanel gip;
    private GridPanel gp;
    ColorSelectionPanel csp;
    JButton save;
    JButton load;
    private final String SAVE_FILE_LOCATION = "src/_06_Pixel_Art_Save_State/saveState.dat";

    public void start() {
        gip = new GridInputPanel( this );
        window = new JFrame( "Pixel Art" );
        window.setLayout( new FlowLayout() );
        window.setResizable( false );
        save = new JButton( "Save" );
        save.addActionListener( this );
        
        load = new JButton("load");
        load.addActionListener(this);

        window.add( gip );
        window.pack();
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        window.setVisible( true );
    }

    public void setupGrid() {
        csp = new ColorSelectionPanel();
        window.remove( gip );
        window.add( gp );
        window.add( csp );
        window.add( save );
        window.add( load );
        gp.repaint();
        gp.addMouseListener( this );
        window.pack();
    }
    
    public void loadGridData() {
        if( new File( SAVE_FILE_LOCATION ).exists() ) {
            gp = load();
            setupGrid();
        } else {
        	System.out.println( "ERROR: No file located at: " + SAVE_FILE_LOCATION);
        }
    }
    
    public void submitGridData(int w, int h, int r, int c) {
        gp = new GridPanel( w, h, r, c );
        setupGrid();
    }
    
    public static void main(String[] args) {
        new PixelArtMaker().start();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        gp.setColor( csp.getSelectedColor() );
        gp.clickPixel( e.getX(), e.getY() );
        gp.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if( arg0.getSource() == this.save ) {
            saveState( gp );
        } else if( arg0.getSource() == this.load ) {
        	window.getContentPane().removeAll();
        	loadGridData();
        }
    }

    private boolean saveState(GridPanel grid) {
        boolean success = false;

        try( FileOutputStream fos = new FileOutputStream( new File( SAVE_FILE_LOCATION ) );
            ObjectOutputStream oos = new ObjectOutputStream( fos ) ) {
            oos.writeObject( grid );
            System.out.println( "Saving file: " + SAVE_FILE_LOCATION );
            success = true;
        } catch( IOException e ) {
            e.printStackTrace();
        }

        return success;
    }

    private GridPanel load() {
        GridPanel savedGrid = null;

        try( FileInputStream fis = new FileInputStream( new File( SAVE_FILE_LOCATION ) );
            ObjectInputStream ois = new ObjectInputStream( fis ) ) {
            savedGrid = (GridPanel)ois.readObject();
            System.out.println( "Loading file: " + SAVE_FILE_LOCATION );
        } catch( IOException e ) {
            System.out.println( "Previous save file not found" );
        } catch( ClassNotFoundException ignore ) {
            // This can occur if the object we read from the file is not
            // an instance of any recognized class
            // Don't error if the state was never saved.
            // e.printStackTrace();
        }

        return savedGrid;
    }
}
