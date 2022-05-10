package gr.aueb.hci.alerts;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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

public class HeatingAlert extends JFrame {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 4768419325003211817L;

    /**
     * Content pane.
     */
    private JPanel contentPane;

    ImageIcon fireIcon = new ImageIcon( "assets/images/heat/fire.png" );

    /**
     * Create the frame.
     */
    public HeatingAlert() {
        setResizable( false );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        setBounds( 100, 100, Singleton.getInstance().getWindowSizeWidth(), Singleton.getInstance().getWindowSizeHeight() );
        this.contentPane = new JPanel();
        this.contentPane.setBackground( Color.WHITE );
        this.contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        setContentPane( this.contentPane );
        this.contentPane.setLayout( null );

        final JLabel textMessageLabel = new JLabel(
                "\u0397 \u03BB\u03B5\u03B9\u03C4\u03BF\u03C5\u03C1\u03B3\u03AF\u03B1 \u03B8\u03AD\u03C1\u03BC\u03B1\u03BD\u03C3\u03B7\u03C2 \u03B5\u03BD\u03B5\u03C1\u03B3\u03BF\u03C0\u03BF\u03B9\u03AE\u03B8\u03B7\u03BA\u03B5" );
        textMessageLabel.setFont( new Font( Singleton.getInstance().getFont(), Font.PLAIN, 40 ) );
        textMessageLabel.setBounds( 27, 113, 734, 46 );
        this.contentPane.add( textMessageLabel );

        final JLabel textMessageLabel1 = new JLabel( "\u03B5\u03C0\u03B9\u03C4\u03C5\u03C7\u03CE\u03C2!" );
        textMessageLabel1.setFont( new Font( Singleton.getInstance().getFont(), Font.PLAIN, 40 ) );
        textMessageLabel1.setBounds( 291, 161, 195, 46 );
        this.contentPane.add( textMessageLabel1 );

        final JLabel fire = new JLabel( "" );
        fire.setBounds( 291, 244, 241, 198 );
        fire.setIcon( this.fireIcon );
        this.contentPane.add( fire );

        try {
            final AudioInputStream audio = AudioSystem.getAudioInputStream( new File( "./assets/sound/heat.wav" ) );
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
                    final HeatingAlert frame = new HeatingAlert();
                    frame.setVisible( true );
                }
                catch ( final Exception e ) {
                    e.printStackTrace();
                }
            }
        } );
    }
}
