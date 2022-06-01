package gr.aueb.hci.alerts;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import gr.aueb.hci.singleton.Singleton;

/**
 * Start frame alert implementation.
 *
 */
public class AirConditionStartupAlert extends JFrame {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = -2371099651394848321L;

    /**
     * Icon.
     */
    private ImageIcon verificationIcon = new ImageIcon(
            getClass().getClassLoader().getResource( "assets/images/verification/verification_icon.png" ) );

    /**
     * Content pane.
     */
    private JPanel contentPane;

    /**
     * Default constructor.
     */
    public AirConditionStartupAlert() {
        setBackground( Color.WHITE );
        setResizable( false );
        setIconImage( Toolkit.getDefaultToolkit()
                .getImage( getClass().getClassLoader().getResource( Singleton.getInstance().getFrameIcon() ) ) );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        setBounds( 100, 100, Singleton.getInstance().getWindowSizeWidth(), Singleton.getInstance().getWindowSizeHeight() );
        this.contentPane = new JPanel();
        this.contentPane.setBackground( Color.WHITE );
        this.contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        setContentPane( this.contentPane );
        this.contentPane.setLayout( null );

        final JLabel verificationMessageLabel = new JLabel(
                "\u03A4\u03BF \u03BA\u03BB\u03B9\u03BC\u03B1\u03C4\u03B9\u03C3\u03C4\u03B9\u03BA\u03CC \u03B5\u03BA\u03BA\u03AF\u03BD\u03B7\u03C3\u03B5 " );
        verificationMessageLabel.setFont( new Font( Singleton.getInstance().getFont(), Font.PLAIN, 50 ) );
        verificationMessageLabel.setBounds( 111, 55, 635, 125 );
        this.contentPane.add( verificationMessageLabel );

        final JLabel verificationMessageLabel1 = new JLabel( "\u03B5\u03C0\u03B9\u03C4\u03C5\u03C7\u03CE\u03C2!" );
        verificationMessageLabel1.setFont( new Font( Singleton.getInstance().getFont(), Font.PLAIN, 50 ) );
        verificationMessageLabel1.setBounds( 285, 143, 250, 68 );
        this.contentPane.add( verificationMessageLabel1 );

        final JLabel verificationIconLabel = new JLabel( "" );
        verificationIconLabel.setBounds( 301, 258, 262, 213 );
        verificationIconLabel.setIcon( this.verificationIcon );
        this.contentPane.add( verificationIconLabel );

        /*
         * Sound functionality.
         */
        try {
            final AudioInputStream audio = AudioSystem
                    .getAudioInputStream( getClass().getClassLoader().getResource( "assets/sound/start.wav" ) );
            final Clip clip = AudioSystem.getClip();
            clip.open( audio );
            clip.start();
        }
        catch ( final Exception e ) {
            e.printStackTrace();
        }
    }

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
}
