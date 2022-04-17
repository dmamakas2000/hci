package gr.aueb.hci.menu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class MainMenu extends JFrame {

    private ImageIcon snowFlakeIcon = new ImageIcon( "fire4.png" );

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main( final String[] args ) {
        EventQueue.invokeLater( new Runnable() {
            @Override
            public void run() {
                try {
                    final MainMenu frame = new MainMenu();
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
    public MainMenu() {
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        setBounds( 100, 100, 911, 709 );
        this.contentPane = new JPanel();
        this.contentPane.setBackground( Color.WHITE );
        this.contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        setContentPane( this.contentPane );
        this.contentPane.setLayout( null );

        final JLabel lblNewLabel = new JLabel( "\u0391\u03B8\u03AE\u03BD\u03B1" );
        lblNewLabel.setFont( new Font( "Arial", Font.PLAIN, 40 ) );
        lblNewLabel.setBounds( 32, 29, 148, 87 );
        this.contentPane.add( lblNewLabel );

        final JLabel lblNewLabel_1 = new JLabel(
                "\u0394\u03B5\u03C5\u03C4\u03AD\u03C1\u03B1 28 \u039C\u03B1\u03C1\u03C4\u03AF\u03BF\u03C5, 19:18 \u039C\u039C" );
        lblNewLabel_1.setFont( new Font( "Arial", Font.PLAIN, 28 ) );
        lblNewLabel_1.setBounds( 32, 107, 560, 73 );
        this.contentPane.add( lblNewLabel_1 );

        final JLabel lblNewLabel_2 = new JLabel( "26" );
        lblNewLabel_2.setFont( new Font( "Arial", Font.PLAIN, 88 ) );
        lblNewLabel_2.setBounds( 32, 191, 141, 93 );
        this.contentPane.add( lblNewLabel_2 );

        final JLabel lblNewLabel_3 = new JLabel( "\u00B0C" );
        lblNewLabel_3.setFont( new Font( "Arial", Font.PLAIN, 52 ) );
        lblNewLabel_3.setBounds( 141, 222, 71, 53 );
        this.contentPane.add( lblNewLabel_3 );

        final JButton btnNewButton = new JButton( "\u0398\u03AD\u03C1\u03BC\u03B1\u03BD\u03C3\u03B7" );
        btnNewButton.setBackground( new Color( 244, 164, 96 ) );
        btnNewButton.setFont( new Font( "Arial", Font.PLAIN, 26 ) );
        btnNewButton.setBounds( 60, 443, 766, 41 );
        this.contentPane.add( btnNewButton );

        final JButton btnNewButton_1 = new JButton( "\u03A8\u03CD\u03BE\u03B7" );
        btnNewButton_1.setBackground( new Color( 30, 144, 255 ) );
        btnNewButton_1.setFont( new Font( "Arial", Font.PLAIN, 26 ) );
        btnNewButton_1.setBounds( 60, 515, 766, 41 );
        this.contentPane.add( btnNewButton_1 );

        final JToggleButton tglbtnNewToggleButton = new JToggleButton( "\u039A\u03BB\u03B5\u03AF\u03C3\u03B9\u03BC\u03BF" );
        tglbtnNewToggleButton.setBackground( new Color( 255, 0, 0 ) );
        tglbtnNewToggleButton.setFont( new Font( "Arial", Font.PLAIN, 25 ) );
        tglbtnNewToggleButton.setBounds( 647, 321, 179, 41 );
        this.contentPane.add( tglbtnNewToggleButton );

        final JLabel lblNewLabel_4 = new JLabel( "\u03A3\u03B5 \u03BB\u03B5\u03B9\u03C4\u03BF\u03C5\u03C1\u03B3\u03AF\u03B1" );
        lblNewLabel_4.setFont( new Font( "Arial", Font.PLAIN, 40 ) );
        lblNewLabel_4.setBounds( 32, 319, 302, 33 );
        this.contentPane.add( lblNewLabel_4 );

        final JLabel lblNewLabel_5 = new JLabel(
                "\u03A7\u03C1\u03B5\u03B9\u03AC\u03B6\u03B5\u03C3\u03C4\u03B5 \u03B2\u03BF\u03AE\u03B8\u03B5\u03B9\u03B1;" );
        lblNewLabel_5.setFont( new Font( "Arial", Font.PLAIN, 25 ) );
        lblNewLabel_5.setBounds( 32, 610, 225, 30 );
        this.contentPane.add( lblNewLabel_5 );

        final JLabel lblNewLabel_6 = new JLabel( "" );
        lblNewLabel_6.setBounds( 329, 174, 292, 241 );
        lblNewLabel_6.setIcon( this.snowFlakeIcon );
        this.contentPane.add( lblNewLabel_6 );
    }
}
