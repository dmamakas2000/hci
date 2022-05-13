package gr.aueb.hci.splash;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import gr.aueb.hci.singleton.Singleton;

public class SplashScreenFrame extends JFrame {

    /**
     * Generated version UID.
     */
    private static final long serialVersionUID = 6823520611301615602L;

    /**
     * Content pane.
     */
    private JPanel contentPane;

    /**
     * Progress bar.
     */
    private JProgressBar progressBar;

    /**
     * Percentage.
     */
    private JLabel percentage;

    /**
     * Welcome label
     */
    private JLabel welcomeLabel;

    /**
     * Creates the GUI.
     */
    public void createGUI() {
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        setIconImage( Toolkit.getDefaultToolkit().getImage( Singleton.getInstance().getFrameIcon() ) );
        setBounds( 100, 100, Singleton.getInstance().getWindowSizeWidth(), Singleton.getInstance().getWindowSizeHeight() );
        this.contentPane = new JPanel();
        this.contentPane.setBackground( Color.WHITE );
        this.contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        setContentPane( this.contentPane );
        this.contentPane.setLayout( null );

        this.progressBar = new JProgressBar();
        this.progressBar.setForeground( Color.BLACK );
        this.progressBar.setBorder( null );
        this.progressBar.setBounds( 122, 473, 562, 50 );
        this.contentPane.add( this.progressBar );

        this.percentage = new JLabel( "0" );
        this.percentage.setFont( new Font( "Arial", Font.PLAIN, 50 ) );
        this.percentage.setBounds( 352, 365, 147, 73 );
        this.contentPane.add( this.percentage );

        this.welcomeLabel = new JLabel( "\u039A\u03B1\u03BB\u03CE\u03C2 \u03BF\u03C1\u03AF\u03C3\u03B1\u03C4\u03B5!" );
        this.welcomeLabel.setFont( new Font( "Arial", Font.PLAIN, 50 ) );
        this.welcomeLabel.setBounds( 219, 169, 429, 59 );
        this.contentPane.add( this.welcomeLabel );
        this.setVisible( true );
    }

    /**
     * Updates the status bar.
     */
    public void runningPBar() {
        int i = 0;

        while ( i <= 100 ) {
            try {
                Thread.sleep( 50 );
                this.progressBar.setValue( i );
                this.percentage.setText( Integer.toString( i ) + "%" );
                i++;
                if ( i == 100 ) {
                    // Start the application
                    final StartingFrame frame = new StartingFrame();
                    this.dispose();
                    frame.setVisible( true );
                }
            }
            catch ( final Exception e ) {
                e.printStackTrace();
            }

        }
    }

    /**
     * Default constructor.
     */
    public SplashScreenFrame() {
        setResizable( false );
        createGUI();
        runningPBar();
    }

    /**
     * Launch the application.
     */
    public static void main( final String[] args ) {
        new SplashScreenFrame();
    }
}
