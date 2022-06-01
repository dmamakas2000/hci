package gr.aueb.hci.menu;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import gr.aueb.hci.panels.TemperatureAdjustMenuPanel;
import gr.aueb.hci.singleton.Singleton;

/**
 * Temperature adjust frame implementation.
 *
 */
public class TemperatureAdjustMenu extends JFrame {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 4749057480869479912L;

    /**
     * Content pane.
     */
    private TemperatureAdjustMenuPanel contentPane;

    /**
     * Icons.
     */
    private ImageIcon needHelpIcon = new ImageIcon( getClass().getClassLoader().getResource( "assets/images/help/info.png" ) );
    private ImageIcon thermometerIcon = new ImageIcon(
            getClass().getClassLoader().getResource( "assets/images/thermometer/thermometer_icon.png" ) );
    private ImageIcon goBackIcon = new ImageIcon( getClass().getClassLoader().getResource( "assets/images/back/go-back.png" ) );
    private ImageIcon saveChangesIcon = new ImageIcon(
            getClass().getClassLoader().getResource( "assets/images/verification/check.png" ) );

    /**
     * Font.
     */
    private static final String FONT = Singleton.getInstance().getFont();

    /**
     * Temperature constants.
     */
    private static final int MAX_TEMPERATURE = 35;
    private static final int MIN_TEMPERATURE = 15;

    /**
     * Attributes.
     */
    private int temperature;

    /**
     * Help message.
     */
    private static final String HELP_MESSAGE = "Βρίσκεστε στην οθόνη ρύθμισης θερμοκρασίας. \n \n"
            + "Στην οθόνη απεικονίζεται η θερμοκρασία που αυτή τη στιγμή έχει επιλεγεί. \nΜπορείτε να την αυξομειώσετε πατώντας στις επιλογές \n<<+>> και <<->>, οι οποίες βρίσκονται τοποθετημένες πάνω και \nκάτω από την θερμοκρασία αντίστοιχα. "
            + "Αφότου επιλέξετε την επιθυμητή θερμοκρασία, \nμπορείτε να πατήσετε <<Επιβεβαίωση αλλαγών>> προκειμένου να ρυθμιστεί \nη θερμορασία του κλιματιστικού σας αντίστοιχα.\n\n"
            + "Εάν δεν επιθυμείτε να πραγματοποιήσετε κάποια αλλαγή μπορείτε να πατήσετε την επιλογή \n<<Πήγαινε με πίσω>> προκειμένου να ανακατευθυνθείτε ξανά στο κεντρικό μενού";

    /**
     * Initializes main common components.
     */
    private void init() {
        setResizable( false );
        setIconImage( Toolkit.getDefaultToolkit()
                .getImage( getClass().getClassLoader().getResource( Singleton.getInstance().getFrameIcon() ) ) );
        setBackground( Color.WHITE );
        setDefaultCloseOperation( WindowConstants.DO_NOTHING_ON_CLOSE );
        setBounds( 100, 100, Singleton.getInstance().getWindowSizeWidth(), Singleton.getInstance().getWindowSizeHeight() );
        this.contentPane = new TemperatureAdjustMenuPanel();
        this.contentPane.setBackground( Color.WHITE );
        this.contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        setContentPane( this.contentPane );
        this.contentPane.setLayout( null );

    }

    /**
     * Creates more main common components.
     *
     * @param temperatureLabel Temperature's label.
     * @param temperature Temperature to start with.
     */
    private void createTemperatureAdjustMenuComponents( final JLabel temperatureLabel, final int temperature ) {
        final JLabel celciusLabel = new JLabel( "\u00B0C" );
        celciusLabel.setFont( new Font( Singleton.getInstance().getFont(), Font.PLAIN, 50 ) );
        celciusLabel.setBounds( 325, 232, 56, 68 );
        this.contentPane.add( celciusLabel );

        final JButton increaseTempButton = new JButton( "+" );
        increaseTempButton.setFont( new Font( TemperatureAdjustMenu.FONT, Font.PLAIN, 50 ) );
        increaseTempButton.setBounds( 239, 127, 89, 46 );
        increaseTempButton.setFocusPainted( false );
        increaseTempButton.setOpaque( false );
        increaseTempButton.setContentAreaFilled( false );
        increaseTempButton.setBorder( null );
        increaseTempButton.setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ) );
        increaseTempButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                TemperatureAdjustMenu.this.temperature += 1;
                if ( TemperatureAdjustMenu.this.temperature < TemperatureAdjustMenu.MAX_TEMPERATURE
                        && TemperatureAdjustMenu.this.temperature > TemperatureAdjustMenu.MIN_TEMPERATURE ) {
                    temperatureLabel.setText( String.valueOf( TemperatureAdjustMenu.this.temperature ) );
                }
                else if ( TemperatureAdjustMenu.this.temperature >= TemperatureAdjustMenu.MAX_TEMPERATURE ) {
                    // Temperature greater than 35 degrees
                    JOptionPane.showMessageDialog( null, "Φτάσατε στην μέγιστη δυνατή θερμοκρασία!" );
                }
                else if ( TemperatureAdjustMenu.this.temperature <= TemperatureAdjustMenu.MIN_TEMPERATURE ) {
                    // Temperature less than 15 degrees
                    JOptionPane.showMessageDialog( null, "Φτάσατε στην ελάχιστη δυνατή θερμοκρασία!" );
                }
            }
        } );
        this.contentPane.add( increaseTempButton );

        final JButton decreaseTempButton = new JButton( "-" );
        decreaseTempButton.setFont( new Font( TemperatureAdjustMenu.FONT, Font.PLAIN, 50 ) );
        decreaseTempButton.setBounds( 239, 348, 89, 46 );
        decreaseTempButton.setFocusPainted( false );
        decreaseTempButton.setBorder( null );
        decreaseTempButton.setOpaque( false );
        decreaseTempButton.setContentAreaFilled( false );
        decreaseTempButton.setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ) );
        decreaseTempButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                TemperatureAdjustMenu.this.temperature -= 1;
                if ( TemperatureAdjustMenu.this.temperature < TemperatureAdjustMenu.MAX_TEMPERATURE
                        && TemperatureAdjustMenu.this.temperature > TemperatureAdjustMenu.MIN_TEMPERATURE ) {
                    temperatureLabel.setText( String.valueOf( TemperatureAdjustMenu.this.temperature ) );
                }
                else if ( TemperatureAdjustMenu.this.temperature >= TemperatureAdjustMenu.MAX_TEMPERATURE ) {
                    // Temperature greater than 35 degrees
                    JOptionPane.showMessageDialog( null, "Φτάσατε στην μέγιστη δυνατή θερμοκρασία!" );
                }
                else if ( TemperatureAdjustMenu.this.temperature <= TemperatureAdjustMenu.MIN_TEMPERATURE ) {
                    // Temperature less than 15 degrees
                    JOptionPane.showMessageDialog( null, "Φτάσατε στην ελάχιστη δυνατή θερμοκρασία!" );
                }
            }
        } );
        this.contentPane.add( decreaseTempButton );

        final JButton goBackButton = new JButton(
                " \u03A0\u03AE\u03B3\u03B1\u03B9\u03BD\u03B5 \u03BC\u03B5 \u03C0\u03AF\u03C3\u03C9" );
        goBackButton.setBackground( Color.WHITE );
        goBackButton.setFont( new Font( TemperatureAdjustMenu.FONT, Font.PLAIN, 25 ) );
        goBackButton.setBounds( 32, 539, 300, 55 );
        goBackButton.setFocusPainted( false );
        goBackButton.setIcon( this.goBackIcon );
        goBackButton.setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ) );
        goBackButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                if ( temperatureLabel.getText().equals( String.valueOf( temperature ) ) ) {
                    // Temperature was not modified
                    TemperatureAdjustMenu.this.dispose();
                    final MainMenu mainMenu = new MainMenu();
                    mainMenu.setVisible( true );

                }
                else {
                    // Temperature was modified
                    final Object[] options1 = { "Ναι", "Όχι" };

                    final JPanel panel = new JPanel();
                    panel.add( new JLabel(
                            "Έχετε επιλέξει νέα θερμοκρασία για το κλιματιστικό. Θέλετε να αποθηκεύσετε αυτή την αλλαγή;" ) );

                    final int result = JOptionPane.showOptionDialog( null, panel, "Προσαρμογή θερμοκρασίας",
                            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options1, null );
                    if ( result == JOptionPane.YES_OPTION ) {
                        TemperatureAdjustMenu.this.dispose();
                        final MainMenu mainMenu = new MainMenu( TemperatureAdjustMenu.this.temperature );
                        mainMenu.setVisible( true );
                    }
                    else {
                        TemperatureAdjustMenu.this.dispose();
                        final MainMenu mainMenu = new MainMenu();
                        mainMenu.setVisible( true );
                    }
                }
            }
        } );
        this.contentPane.add( goBackButton );

        final JButton saveChangesButton = new JButton();
        saveChangesButton.setBackground( Color.WHITE );
        saveChangesButton.setFont( new Font( TemperatureAdjustMenu.FONT, Font.PLAIN, 25 ) );
        saveChangesButton.setFocusPainted( false );
        saveChangesButton.setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ) );
        saveChangesButton.setBounds( 563, 208, 100, 100 );
        saveChangesButton.setFocusPainted( false );
        saveChangesButton.setIcon( this.saveChangesIcon );
        saveChangesButton.setVerticalTextPosition( SwingConstants.CENTER );
        saveChangesButton.setHorizontalTextPosition( SwingConstants.RIGHT );
        saveChangesButton.setOpaque( false );
        saveChangesButton.setContentAreaFilled( false );
        saveChangesButton.setBorder( null );
        saveChangesButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                final Object[] options1 = { "Ναι, άλλαξε την θερμοκρασία", "Όχι, μην την αλλάξεις" };

                final JPanel panel = new JPanel();
                panel.add( new JLabel( "Είστε βέβαιοι πως θέλετε να αλλάξετε την θερμοκρασία;" ) );

                final int result = JOptionPane.showOptionDialog( null, panel, "Προσαρμογή θερμοκρασίας",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options1, null );
                if ( result == JOptionPane.YES_OPTION ) {
                    TemperatureAdjustMenu.this.dispose();
                    final MainMenu mainMenu = new MainMenu( TemperatureAdjustMenu.this.temperature );
                    mainMenu.setVisible( true );
                }
            }
        } );
        this.contentPane.add( saveChangesButton );

        final JLabel needHelpLabel = new JLabel( "\u0398\u03AD\u03BB\u03C9 \u03B2\u03BF\u03AE\u03B8\u03B5\u03B9\u03B1" );
        needHelpLabel.setFont( new Font( TemperatureAdjustMenu.FONT, Font.PLAIN, 25 ) );
        needHelpLabel.setBounds( 472, 539, 182, 46 );
        this.contentPane.add( needHelpLabel );

        final JButton needHelpButton = new JButton( "" );
        needHelpButton.setBounds( 649, 528, 98, 73 );
        needHelpButton.setFocusPainted( false );
        needHelpButton.setBorder( null );
        needHelpButton.setOpaque( false );
        needHelpButton.setContentAreaFilled( false );
        needHelpButton.setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ) );
        needHelpButton.setIcon( this.needHelpIcon );
        needHelpButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                JOptionPane.showMessageDialog( null, TemperatureAdjustMenu.HELP_MESSAGE, "Μενού βοήθειας ρύθμισης θερμοκρασίας", 1 );
            }
        } );
        this.contentPane.add( needHelpButton );

        final JLabel thermometerLabel = new JLabel( "" );
        thermometerLabel.setBounds( 112, 190, 96, 128 );
        thermometerLabel.setIcon( this.thermometerIcon );
        this.contentPane.add( thermometerLabel );
    }

    /**
     * Main constructor.
     *
     * @param temp The temperature to start the frame with.
     */
    public TemperatureAdjustMenu( final int temp ) {
        this.temperature = temp;
        init();

        final JLabel temperatureLabel = new JLabel( String.valueOf( temp ) );
        temperatureLabel.setFont( new Font( Singleton.getInstance().getFont(), Font.PLAIN, 80 ) );
        temperatureLabel.setBounds( 218, 181, 110, 151 );
        this.contentPane.add( temperatureLabel );

        createTemperatureAdjustMenuComponents( temperatureLabel, temp );
    }

    /**
     * Default constructor.
     */
    public TemperatureAdjustMenu() {
        this.temperature = 25;
        init();

        final JLabel temperatureLabel = new JLabel( String.valueOf( 25 ) );
        temperatureLabel.setFont( new Font( Singleton.getInstance().getFont(), Font.PLAIN, 80 ) );
        temperatureLabel.setBounds( 218, 181, 110, 151 );
        this.contentPane.add( temperatureLabel );

        createTemperatureAdjustMenuComponents( temperatureLabel, 25 );

        final JLabel lblNewLabel = new JLabel(
                "\u0395\u03C0\u03B9\u03B2\u03B5\u03B2\u03B1\u03AF\u03C9\u03C3\u03B7 \u03B1\u03BB\u03BB\u03B1\u03B3\u03CE\u03BD" );
        lblNewLabel.setFont( new Font( TemperatureAdjustMenu.FONT, Font.PLAIN, 25 ) );
        lblNewLabel.setBounds( 478, 319, 269, 39 );
        this.contentPane.add( lblNewLabel );
    }

    /**
     * Launch the application.
     */
    public static void main( final String[] args ) {
        EventQueue.invokeLater( new Runnable() {
            @Override
            public void run() {
                try {
                    final TemperatureAdjustMenu menu = new TemperatureAdjustMenu();
                    menu.setVisible( true );
                }
                catch ( final Exception e ) {
                    e.printStackTrace();
                }
            }
        } );
    }
}
