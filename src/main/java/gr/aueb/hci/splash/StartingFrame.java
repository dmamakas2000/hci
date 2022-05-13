package gr.aueb.hci.splash;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
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
import gr.aueb.hci.singleton.Singleton;

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
     * Icons.
     */
    private ImageIcon needHelpIcon = new ImageIcon( "assets/images/help/info.png" );
    private ImageIcon hermes = new ImageIcon( "./assets/images/hermes/3_AUEB-emblem-HR.png" );

    /**
     * Help message.
     */
    private static final String HELP_MESSAGE = "Καλωσορίσατε! Βρίσκεστε στην αρχική οθόνη της εφαρμογής.\n"
            + "Επιλέξτε 'Εκκίνηση εφαρμογής' για να ξεκινήσετε το κλιματιστικό.";

    /**
     * Default constructor.
     */
    public StartingFrame() {
        setIconImage( Toolkit.getDefaultToolkit().getImage( Singleton.getInstance().getFrameIcon() ) );
        setResizable( false );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        setBounds( 100, 100, Singleton.getInstance().getWindowSizeWidth(), Singleton.getInstance().getWindowSizeHeight() );
        this.contentPane = new JPanel();
        this.contentPane.setBackground( Color.WHITE );
        this.contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        setContentPane( this.contentPane );
        this.contentPane.setLayout( null );

        final JButton goIntoMainMenuButton = new JButton(
                "\u0395\u03BA\u03BA\u03AF\u03BD\u03B7\u03C3\u03B7 \u03BA\u03BB\u03B9\u03BC\u03B1\u03C4\u03B9\u03C3\u03C4\u03B9\u03BA\u03BF\u03CD" );
        goIntoMainMenuButton.setForeground( new Color( 118, 33, 36 ) );
        goIntoMainMenuButton.setBackground( Color.WHITE );
        goIntoMainMenuButton.setFocusPainted( false );

        goIntoMainMenuButton.setBorder( BorderFactory.createLineBorder( new Color( 118, 33, 36 ), 1 ) );
        goIntoMainMenuButton.setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ) );

        goIntoMainMenuButton.setFont( new Font( Singleton.getInstance().getFont(), Font.PLAIN, 30 ) );
        goIntoMainMenuButton.setBounds( 132, 331, 503, 67 );
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
                }, 3000 );
            }
        } );

        goIntoMainMenuButton.addMouseListener( new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered( final java.awt.event.MouseEvent evt ) {
                goIntoMainMenuButton.setBorder( BorderFactory.createLineBorder( new Color( 118, 33, 36 ), 2 ) );
            }

            @Override
            public void mouseExited( final java.awt.event.MouseEvent evt ) {
                goIntoMainMenuButton.setBorder( BorderFactory.createLineBorder( new Color( 118, 33, 36 ), 1 ) );
            }
        } );

        this.contentPane.add( goIntoMainMenuButton );

        final JLabel needHelpLabel = new JLabel( "\u0398\u03AD\u03BB\u03C9 \u03B2\u03BF\u03AE\u03B8\u03B5\u03B9\u03B1" );
        needHelpLabel.setFont( new Font( Singleton.getInstance().getFont(), Font.PLAIN, 30 ) );
        needHelpLabel.setBounds( 420, 536, 201, 61 );
        this.contentPane.add( needHelpLabel );

        final JButton infoButton = new JButton( "" );
        infoButton.setBackground( Color.WHITE );
        infoButton.setBounds( 631, 514, 131, 85 );
        infoButton.setIcon( this.needHelpIcon );
        infoButton.setBorder( null );
        infoButton.setFocusPainted( false );
        infoButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                JOptionPane.showMessageDialog( null, StartingFrame.HELP_MESSAGE, "Αρχική οθόνη", 1 );
            }
        } );
        this.contentPane.add( infoButton );

        final Panel panel = new Panel();
        panel.setBounds( 0, 0, 792, 163 );
        panel.setBackground( new Color( 118, 33, 36 ) );
        this.contentPane.add( panel );
        panel.setLayout( null );

        final JLabel welcomeLabel = new JLabel( "Aueb Condition" );
        welcomeLabel.setBounds( 411, 53, 371, 59 );
        panel.add( welcomeLabel );
        welcomeLabel.setFont( new Font( Singleton.getInstance().getFont(), Font.ITALIC, 50 ) );
        welcomeLabel.setForeground( new Color( 255, 255, 255 ) );

        final JLabel hermesLabel = new JLabel( "" );
        hermesLabel.setBounds( 29, 0, 186, 163 );
        hermesLabel.setIcon( this.hermes );
        panel.add( hermesLabel );
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
