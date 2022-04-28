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

public class CoolingAlert extends JFrame {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = -6648662630435458748L;

    /**
     * Icon.
     */
    private ImageIcon snowFlakeIcon = new ImageIcon( "assets/images/cool/snowflake_icon_big.png" );

    /**
     * Content pane.
     */
    private JPanel contentPane;

    /**
     * Default constructor.
     */
    public CoolingAlert() {
        setResizable( false );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        setBounds( 100, 100, 806, 660 );
        this.contentPane = new JPanel();
        this.contentPane.setBackground( Color.WHITE );
        this.contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        setContentPane( this.contentPane );
        this.contentPane.setLayout( null );

        final JLabel textMessageLabel = new JLabel(
                "\u0397 \u03BB\u03B5\u03B9\u03C4\u03BF\u03C5\u03C1\u03B3\u03AF\u03B1 \u03C8\u03CD\u03BE\u03B7\u03C2 \u03B5\u03BD\u03B5\u03C1\u03B3\u03BF\u03C0\u03BF\u03B9\u03AE\u03B8\u03B7\u03BA\u03B5" );
        textMessageLabel.setFont( new Font( "Arial", Font.PLAIN, 40 ) );
        textMessageLabel.setBounds( 69, 78, 650, 69 );
        this.contentPane.add( textMessageLabel );

        final JLabel textMessageLabel1 = new JLabel( "\u03B5\u03C0\u03B9\u03C4\u03C5\u03C7\u03CE\u03C2!" );
        textMessageLabel1.setFont( new Font( "Arial", Font.PLAIN, 40 ) );
        textMessageLabel1.setBounds( 296, 135, 192, 47 );
        this.contentPane.add( textMessageLabel1 );

        final JLabel iconLabel = new JLabel( "" );
        iconLabel.setBounds( 296, 252, 248, 202 );
        iconLabel.setIcon( this.snowFlakeIcon );
        this.contentPane.add( iconLabel );
    }

    /**
     * Launch the application.
     */
    public static void main( final String[] args ) {
        EventQueue.invokeLater( new Runnable() {
            @Override
            public void run() {
                try {
                    final CoolingAlert frame = new CoolingAlert();
                    frame.setVisible( true );
                }
                catch ( final Exception e ) {
                    e.printStackTrace();
                }
            }
        } );
    }
}
