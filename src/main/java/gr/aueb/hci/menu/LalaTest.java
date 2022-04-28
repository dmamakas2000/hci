package gr.aueb.hci.menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class LalaTest extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main( String[] args ) {
        EventQueue.invokeLater( new Runnable() {
            public void run() {
                try {
                    LalaTest frame = new LalaTest();
                    frame.setVisible( true );
                }
                catch ( Exception e ) {
                    e.printStackTrace();
                }
            }
        } );
    }

    /**
     * Create the frame.
     */
    public LalaTest() {
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setBounds( 100, 100, 450, 300 );
        contentPane = new JPanel();
        contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        contentPane.setLayout( new BorderLayout( 0, 0 ) );
        setContentPane( contentPane );
    }

}
