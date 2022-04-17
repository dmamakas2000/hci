package gr.aueb.hci.splash;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class StartingFrame extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main( final String[] args ) {
        EventQueue.invokeLater( new Runnable() {
            @Override
            public void run() {
                try {
                    final StartingFrame frame = new StartingFrame();
                    frame.setVisible( true );
                }
                catch ( final Exception e ) {
                    e.printStackTrace();
                }
            }
        } );
    }

    /**
     * Create the frame.
     */
    public StartingFrame() {
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        setBounds( 100, 100, 942, 739 );
        this.contentPane = new JPanel();
        this.contentPane.setBackground( Color.WHITE );
        this.contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        setContentPane( this.contentPane );
        this.contentPane.setLayout( null );

        final JLabel lblNewLabel = new JLabel( "\u039A\u03B1\u03BB\u03CE\u03C2 \u03BF\u03C1\u03AF\u03C3\u03B1\u03C4\u03B5!" );
        lblNewLabel.setFont( new Font( "Arial", Font.PLAIN, 50 ) );
        lblNewLabel.setBounds( 279, 143, 358, 79 );
        this.contentPane.add( lblNewLabel );

        final JButton btnNewButton = new JButton(
                "\u0395\u03BA\u03BA\u03AF\u03BD\u03B7\u03C3\u03B7 \u03B5\u03C6\u03B1\u03C1\u03BC\u03BF\u03B3\u03AE\u03C2" );
        btnNewButton.setBackground( new Color( 144, 238, 144 ) );
        btnNewButton.setFont( new Font( "Arial", Font.PLAIN, 30 ) );
        btnNewButton.setBounds( 74, 545, 779, 65 );
        this.contentPane.add( btnNewButton );
    }
}
