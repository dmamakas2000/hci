package gr.aueb.hci.splash;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import gr.aueb.hci.singleton.Singleton;
import lombok.Getter;

@Getter
public class SplashScreenFrame extends JFrame {

    /**
     * Generated version UID.
     */
    private static final long serialVersionUID = 6823520611301615602L;

    private JPanel contentPane;

    private JProgressBar progressBar;

    private JLabel percentage;

    /**
     * Launch the application.
     */
    public static void main( final String[] args ) {
        EventQueue.invokeLater( new Runnable() {
            @Override
            public void run() {
                try {
                    final SplashScreenFrame frame = new SplashScreenFrame();
                    frame.setVisible( true );
                    try {
                        for ( int i = 0; i < 101; i++ ) {
                            Thread.sleep( 100 );
                            frame.getPercentage().setText( String.valueOf( i ) );
                            frame.getProgressBar().setValue( i );
                        }

                    }
                    catch ( final InterruptedException e ) {
                        e.printStackTrace();
                    }
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
    public SplashScreenFrame() {
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        setBounds( 100, 100, Singleton.getInstance().getWindowSizeWidth(), Singleton.getInstance().getWindowSizeHeight() );
        this.contentPane = new JPanel();
        this.contentPane.setBackground( Color.WHITE );
        this.contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        setContentPane( this.contentPane );
        this.contentPane.setLayout( null );

        this.progressBar = new JProgressBar();
        this.progressBar.setForeground( Color.BLACK );
        this.progressBar.setBounds( 122, 473, 562, 50 );
        this.contentPane.add( this.progressBar );

        this.percentage = new JLabel( "0" );
        this.percentage.setFont( new Font( "Arial", Font.PLAIN, 50 ) );
        this.percentage.setBounds( 381, 365, 55, 73 );
        this.contentPane.add( this.percentage );
    }
}
