package gr.aueb.hci.splash;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import gr.aueb.hci.alerts.AirConditionStartupAlert;
import gr.aueb.hci.menu.MainMenu;

public class StartingFrame extends JFrame {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 660117750451006902L;

    /**
     * Content pane.
     */
    private JPanel contentPane;

    /**
     * Font constant.
     */
    private static final String ARIAL = "Arial";

    private static final String HELP_MESSAGE = "Καλωσορίσατε! Βρίσκεστε στην αρχική οθόνη της εφαρμογής.\n"
            + "Επιλέξτε 'Εκκίνηση εφαρμογής' για να ξεκινήσετε το κλιματιστικό.";

    /**
     * Default constructor.
     */
    public StartingFrame() {
        setResizable( false );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        setBounds( 100, 100, 806, 660 );
        this.contentPane = new JPanel();
        this.contentPane.setBackground( Color.WHITE );
        this.contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        setContentPane( this.contentPane );
        this.contentPane.setLayout( null );

        final JLabel welcomeLabel = new JLabel( "\u039A\u03B1\u03BB\u03CE\u03C2 \u03BF\u03C1\u03AF\u03C3\u03B1\u03C4\u03B5!" );
        welcomeLabel.setFont( new Font( StartingFrame.ARIAL, Font.PLAIN, 50 ) );
        welcomeLabel.setBounds( 217, 143, 358, 79 );
        this.contentPane.add( welcomeLabel );

        final JButton goIntoMainMenuButton = new JButton(
                "\u0395\u03BA\u03BA\u03AF\u03BD\u03B7\u03C3\u03B7 \u03B5\u03C6\u03B1\u03C1\u03BC\u03BF\u03B3\u03AE\u03C2" );
        goIntoMainMenuButton.setForeground( Color.WHITE );
        goIntoMainMenuButton.setBackground( new Color( 138, 237, 172 ) );
        goIntoMainMenuButton.setFocusPainted( false );
        goIntoMainMenuButton.setFont( new Font( StartingFrame.ARIAL, Font.PLAIN, 30 ) );
        goIntoMainMenuButton.setBounds( 99, 390, 582, 67 );
        goIntoMainMenuButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                StartingFrame.this.dispose();
                final AirConditionStartupAlert alert = new AirConditionStartupAlert();
                alert.setVisible( true );
                new java.util.Timer().schedule( new java.util.TimerTask() {
                    @Override
                    public void run() {
                        alert.dispose();
                        final MainMenu menu = new MainMenu();
                        menu.setVisible( true );
                    }
                }, 2000 );
            }
        } );
        this.contentPane.add( goIntoMainMenuButton );

        final JLabel needHelpLabel = new JLabel( "\u0398\u03AD\u03BB\u03C9 \u03B2\u03BF\u03AE\u03B8\u03B5\u03B9\u03B1" );
        needHelpLabel.setFont( new Font( "Arial", Font.PLAIN, 30 ) );
        needHelpLabel.setBounds( 420, 536, 201, 61 );
        this.contentPane.add( needHelpLabel );

        final JButton infoButton = new JButton( "" );
        infoButton.setBackground( Color.WHITE );
        infoButton.setBounds( 631, 514, 131, 85 );
        infoButton.setIcon( new ImageIcon( "icons8-info-64.png" ) );
        infoButton.setBorder( null );
        infoButton.setFocusPainted( false );
        infoButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                JOptionPane.showMessageDialog( null, StartingFrame.HELP_MESSAGE );
            }
        } );
        this.contentPane.add( infoButton );
    }

    /**
     * Launch the application.
     */
    public static void main( final String[] args ) {
        EventQueue.invokeLater( new Runnable() {
            @Override
            public void run() {
                try {
                    final StartingFrame startingFrame = new StartingFrame();
                    startingFrame.setVisible( true );
                }
                catch ( final Exception e ) {
                    e.printStackTrace();
                }
            }
        } );
    }
}
