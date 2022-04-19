package gr.aueb.hci.alerts;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class AirConditionStartupAlert extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main( final String[] args ) {
        EventQueue.invokeLater( new Runnable() {
            @Override
            public void run() {
                try {
                    final AirConditionStartupAlert frame = new AirConditionStartupAlert();
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
    public AirConditionStartupAlert() {
        setBackground( Color.WHITE );
        setResizable( false );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        setBounds( 100, 100, 806, 660 );
        this.contentPane = new JPanel();
        this.contentPane.setBackground( Color.WHITE );
        this.contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        setContentPane( this.contentPane );
        this.contentPane.setLayout( null );

        final JLabel lblNewLabel = new JLabel(
                "\u03A4\u03BF \u03BA\u03BB\u03B9\u03BC\u03B1\u03C4\u03B9\u03C3\u03C4\u03B9\u03BA\u03CC \u03B5\u03BA\u03BA\u03AF\u03BD\u03B7\u03C3\u03B5 " );
        lblNewLabel.setFont( new Font( "Arial", Font.PLAIN, 50 ) );
        lblNewLabel.setBounds( 111, 55, 635, 125 );
        this.contentPane.add( lblNewLabel );

        final JLabel lblNewLabel_1 = new JLabel( "\u03B5\u03C0\u03B9\u03C4\u03C5\u03C7\u03CE\u03C2!" );
        lblNewLabel_1.setFont( new Font( "Arial", Font.PLAIN, 50 ) );
        lblNewLabel_1.setBounds( 285, 143, 250, 68 );
        this.contentPane.add( lblNewLabel_1 );

        final JLabel lblNewLabel_2 = new JLabel( "" );
        lblNewLabel_2.setBounds( 301, 258, 262, 213 );
        lblNewLabel_2.setIcon( new ImageIcon( "verification1.png" ) );
        this.contentPane.add( lblNewLabel_2 );
    }
}
