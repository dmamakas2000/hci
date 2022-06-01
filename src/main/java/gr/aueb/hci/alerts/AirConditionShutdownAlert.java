package gr.aueb.hci.alerts;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;

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

public class AirConditionShutdownAlert extends JFrame {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 8338748296265743292L;

    /**
     * Content pane.
     */
    private JPanel contentPane;

    /**
     * Icon.
     */
    private ImageIcon verificationIcon = new ImageIcon( "assets/images/verification/verification_icon.png" );

    /**
     * Font.
     */
    private static final String FONT = Singleton.getInstance().getFont();

    /**
     * Create the frame.
     */
    public AirConditionShutdownAlert() {
        setIconImage( Toolkit.getDefaultToolkit().getImage( Singleton.getInstance().getFrameIcon() ) );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        setBounds( 100, 100, Singleton.getInstance().getWindowSizeWidth(), Singleton.getInstance().getWindowSizeHeight() );
        this.contentPane = new JPanel();
        this.contentPane.setBackground( Color.WHITE );
        this.contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        setContentPane( this.contentPane );
        this.contentPane.setLayout( null );

        final JLabel verificationMessage1 = new JLabel(
                "\u03A4\u03BF \u03BA\u03BB\u03B9\u03BC\u03B1\u03C4\u03B9\u03C3\u03C4\u03B9\u03BA\u03CC \u03B1\u03C0\u03B5\u03BD\u03B5\u03C1\u03B3\u03BF\u03C0\u03BF\u03B9\u03AE\u03B8\u03B7\u03BA\u03B5" );
        verificationMessage1.setFont( new Font( AirConditionShutdownAlert.FONT, Font.PLAIN, 45 ) );
        verificationMessage1.setBounds( 34, 67, 721, 69 );
        this.contentPane.add( verificationMessage1 );

        final JLabel verificationMessage2 = new JLabel( "\u03B5\u03C0\u03B9\u03C4\u03C5\u03C7\u03CE\u03C2!" );
        verificationMessage2.setFont( new Font( AirConditionShutdownAlert.FONT, Font.PLAIN, 45 ) );
        verificationMessage2.setBounds( 285, 128, 225, 52 );
        this.contentPane.add( verificationMessage2 );

        final JLabel verificationLabel = new JLabel( "" );
        verificationLabel.setBounds( 293, 202, 263, 213 );
        verificationLabel.setIcon( this.verificationIcon );
        this.contentPane.add( verificationLabel );

        /*
         * Sound functionality.
         */
        try {
            final AudioInputStream audio = AudioSystem.getAudioInputStream( new File( "./assets/sound/end.wav" ) );
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
                    final AirConditionShutdownAlert frame = new AirConditionShutdownAlert();
                    frame.setVisible( true );
                }
                catch ( final Exception e ) {
                    e.printStackTrace();
                }
            }
        } );
    }
}
