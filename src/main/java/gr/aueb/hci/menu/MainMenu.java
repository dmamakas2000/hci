package gr.aueb.hci.menu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import gr.aueb.hci.alerts.CoolingAlert;
import gr.aueb.hci.alerts.HeatingAlert;
import gr.aueb.hci.splash.StartingFrame;

public class MainMenu extends JFrame {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 7391903381566791295L;

    /**
     * Icons.
     */
    private ImageIcon fireIcon = new ImageIcon( "assets/images/heat/fire.png" );
    private ImageIcon fireIconForButton = new ImageIcon( "assets/images/heat/fire_icon.png" );
    private ImageIcon snowFlakeIconForButton = new ImageIcon( "assets/images/cool/snowflake_icon.png" );
    private ImageIcon needHelpIconForButton = new ImageIcon( "assets/images/help/info.png" );
    private ImageIcon shutDownIcon = new ImageIcon( "assets/images/shutdown/shutdown_icon.png" );

    /**
     * Font constant.
     */
    private static final String ARIAL = "Arial";

    /**
     * Starting temperature constant.
     */
    private static final int START_TEMPERATURE = 0;

    /**
     * Date-time attribute.
     */
    private String dateTimeString;
    /**
     * Content pane.
     */
    private JPanel contentPane;

    /**
     * Help message appeared.
     */
    private static final String HELP_MESSAGE = "Βρίσκεστε στην κεντρική οθόνη ελέγχου του κλιματιστικού.\n"
            + "· Πατήστε θέρμανση για να ζεσταθείτε.\n" + "· Πατήστε 'Ψύξη' για να δροσιστείτε.\n"
            + "· Πατήστε 'Ρύθμιση θερμοκρασίας' για να προσαρμόσετε την θερμοκρασία εκεί που επιθυμείτε.";

    /**
     * Main constructor (parsing temperature).
     */
    public MainMenu( final int temp ) {
        init();

        final JLabel temperatureLabel = new JLabel( String.valueOf( temp ) );
        temperatureLabel.setFont( new Font( MainMenu.ARIAL, Font.PLAIN, 78 ) );
        temperatureLabel.setBounds( 32, 191, 141, 93 );
        this.contentPane.add( temperatureLabel );

        this.createMainMenuComponents();
    }

    /**
     * Default constructor.
     */
    public MainMenu() {
        init();

        final JLabel temperatureLabel = new JLabel( String.valueOf( MainMenu.START_TEMPERATURE ) );
        temperatureLabel.setFont( new Font( MainMenu.ARIAL, Font.PLAIN, 78 ) );
        temperatureLabel.setBounds( 32, 127, 141, 93 );
        this.contentPane.add( temperatureLabel );

        this.createMainMenuComponents();
    }

    /**
     * Initializes main common components.
     */
    private void init() {
        setResizable( false );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        setBounds( 100, 100, 806, 660 );
        this.contentPane = new JPanel();
        this.contentPane.setBackground( Color.WHITE );
        this.contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        setContentPane( this.contentPane );
        this.contentPane.setLayout( null );

        // Current date-time initialization
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "E, MMM dd yyyy HH:mm" );
        final String formattedDate = LocalDateTime.now().format( formatter );
        final String day = formattedDate.substring( 0, 3 );
        final String month = formattedDate.substring( 5, 8 );
        final String dayNum = formattedDate.substring( 9, 11 );
        final String yearAndTime = formattedDate.substring( 12 );
        this.dateTimeString = translator( day, month, dayNum, yearAndTime );
    }

    /**
     * Creates more main common components.
     */
    private void createMainMenuComponents() {
        final JLabel cityLabel = new JLabel( "\u0391\u03B8\u03AE\u03BD\u03B1" );
        cityLabel.setFont( new Font( MainMenu.ARIAL, Font.PLAIN, 40 ) );
        cityLabel.setBounds( 32, 9, 131, 62 );
        this.contentPane.add( cityLabel );

        final JLabel dateLabel = new JLabel( this.dateTimeString );
        dateLabel.setFont( new Font( "Arial", Font.PLAIN, 20 ) );
        dateLabel.setBounds( 32, 71, 737, 53 );
        this.contentPane.add( dateLabel );

        final JLabel celciusLabel = new JLabel( "\u00B0C" );
        celciusLabel.setFont( new Font( MainMenu.ARIAL, Font.PLAIN, 52 ) );
        celciusLabel.setBounds( 128, 155, 71, 53 );
        this.contentPane.add( celciusLabel );

        final JButton heatingButton = new JButton( "\u0398\u03AD\u03C1\u03BC\u03B1\u03BD\u03C3\u03B7     " );
        heatingButton.setBackground( Color.WHITE );
        heatingButton.setFont( new Font( MainMenu.ARIAL, Font.PLAIN, 26 ) );
        heatingButton.setBounds( 141, 337, 517, 57 );
        heatingButton.setIcon( this.fireIconForButton );
        heatingButton.setVerticalTextPosition( SwingConstants.CENTER );
        heatingButton.setHorizontalTextPosition( SwingConstants.LEADING );
        heatingButton.setFocusPainted( false );
        heatingButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                final HeatingAlert heatingAlert = new HeatingAlert();
                heatingAlert.setVisible( true );
                MainMenu.this.setVisible( false );
                new java.util.Timer().schedule( new java.util.TimerTask() {
                    @Override
                    public void run() {
                        heatingAlert.setVisible( false );
                        MainMenu.this.setVisible( true );
                        MainMenu.this.contentPane.setBackground( new Color( 255, 245, 204 ) );
                    }
                }, 2000 );
            }
        } );
        this.contentPane.add( heatingButton );

        final JLabel inActionLabel = new JLabel( "\u03A3\u03B5 \u03BB\u03B5\u03B9\u03C4\u03BF\u03C5\u03C1\u03B3\u03AF\u03B1" );
        inActionLabel.setFont( new Font( MainMenu.ARIAL, Font.PLAIN, 40 ) );
        inActionLabel.setBounds( 32, 222, 302, 47 );
        this.contentPane.add( inActionLabel );

        final JLabel needHelpLabel = new JLabel( "\u0398\u03AD\u03BB\u03C9 \u03B2\u03BF\u03AE\u03B8\u03B5\u03B9\u03B1" );
        needHelpLabel.setFont( new Font( MainMenu.ARIAL, Font.PLAIN, 25 ) );
        needHelpLabel.setBounds( 520, 553, 185, 30 );
        this.contentPane.add( needHelpLabel );

        final JLabel fireLabelIcon = new JLabel( "" );
        fireLabelIcon.setBounds( 325, 85, 292, 241 );
        fireLabelIcon.setIcon( this.fireIcon );
        this.contentPane.add( fireLabelIcon );

        final JButton coolingButton = new JButton( "\u03A8\u03CD\u03BE\u03B7      " );
        coolingButton.setFont( new Font( MainMenu.ARIAL, Font.PLAIN, 26 ) );
        coolingButton.setBackground( Color.WHITE );
        coolingButton.setBounds( 141, 405, 517, 57 );
        coolingButton.setIcon( this.snowFlakeIconForButton );
        coolingButton.setVerticalTextPosition( SwingConstants.CENTER );
        coolingButton.setHorizontalTextPosition( SwingConstants.LEADING );
        coolingButton.setFocusPainted( false );
        coolingButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                final CoolingAlert coolingAlert = new CoolingAlert();
                coolingAlert.setVisible( true );
                MainMenu.this.setVisible( false );
                new java.util.Timer().schedule( new java.util.TimerTask() {
                    @Override
                    public void run() {
                        coolingAlert.setVisible( false );
                        MainMenu.this.setVisible( true );
                        MainMenu.this.contentPane.setBackground( new Color( 212, 242, 255 ) );
                    }
                }, 2000 );
            }
        } );
        this.contentPane.add( coolingButton );

        final JButton needHelpButton = new JButton( "" );
        needHelpButton.setBackground( Color.WHITE );
        needHelpButton.setBounds( 674, 529, 94, 73 );
        needHelpButton.setIcon( this.needHelpIconForButton );
        needHelpButton.setFocusPainted( false );
        needHelpButton.setBorder( null );
        needHelpButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                JOptionPane.showMessageDialog( null, MainMenu.HELP_MESSAGE, "Κεντρικό μενού", 1 );
            }
        } );
        this.contentPane.add( needHelpButton );

        final JButton temperatureAdjustButton = new JButton(
                "\u03A1\u03CD\u03B8\u03BC\u03B9\u03C3\u03B7 \u03B8\u03B5\u03C1\u03BC\u03BF\u03BA\u03C1\u03B1\u03C3\u03AF\u03B1\u03C2" );
        temperatureAdjustButton.setVerticalTextPosition( SwingConstants.CENTER );
        temperatureAdjustButton.setHorizontalTextPosition( SwingConstants.LEADING );
        temperatureAdjustButton.setFont( new Font( MainMenu.ARIAL, Font.PLAIN, 26 ) );
        temperatureAdjustButton.setBackground( Color.WHITE );
        temperatureAdjustButton.setBounds( 141, 473, 517, 57 );
        temperatureAdjustButton.setFocusPainted( false );
        temperatureAdjustButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                final TemperatureAdjustMenu temperatureAdjustMenu = new TemperatureAdjustMenu();
                temperatureAdjustMenu.setVisible( true );
                MainMenu.this.dispose();
            }
        } );
        this.contentPane.add( temperatureAdjustButton );

        final JButton switchOffButton = new JButton( "" );
        switchOffButton.setBackground( Color.WHITE );
        switchOffButton.setBounds( 669, 155, 100, 100 );
        switchOffButton.setIcon( this.shutDownIcon );
        switchOffButton.setFocusPainted( false );
        switchOffButton.setBorder( null );
        switchOffButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                final StartingFrame startingFrame = new StartingFrame();
                MainMenu.this.dispose();
                startingFrame.setVisible( true );
            }
        } );
        this.contentPane.add( switchOffButton );
    }

    /**
     * Translates a given String constants into the preferred format.
     *
     * @param day Current day.
     * @param month Current month.
     * @param numDate Current date.
     * @param yearTime Current year.
     * @return Concatenated string containing all those attributes.
     */
    private String translator( final String day, final String month, final String numDate, final String yearTime ) {
        String translatedDay = "";
        switch ( day ) {
            case "Δευ":
                translatedDay = "Δευτέρα";
                break;

            case "Τρι":
                translatedDay = "Τρίτη";
                break;

            case "Τετ":
                translatedDay = "Τετάρτη";
                break;

            case "Πεμ":
                translatedDay = "Πέμπτη";
                break;

            case "Παρ":
                translatedDay = "Παρασκευή";
                break;

            case "Σαβ":
                translatedDay = "Σάββατο";
                break;

            case "Κυρ":
                translatedDay = "Κυριακή";
                break;

            default:
                translatedDay = day;
                break;
        }

        String translatedMonth = "";
        switch ( month ) {
            case "Απρ":
                translatedMonth = "Απριλίου";
                break;

            case "Μαι":
                translatedMonth = "Μαίου";
                break;

            case "Ιουν":
                translatedMonth = "Ιουνίου";
                break;

            case "Ιουλ":
                translatedMonth = "Ιουλίου";
                break;

            case "Αυγ":
                translatedMonth = "Αυγούστου";
                break;

            case "Σεπ":
                translatedMonth = "Σεπτεμβρίου";
                break;

            case "Οκτ":
                translatedMonth = "Οκτωβρίου";
                break;

            case "Νοε":
                translatedMonth = "Νοεμβρίου";
                break;

            case "Δεκ":
                translatedMonth = "Δεκεμβρίου";
                break;

            default:
                translatedMonth = month;
                break;
        }
        return translatedDay + ", " + numDate + " " + translatedMonth + " " + yearTime;
    }

    /**
     * Launch the application.
     */
    public static void main( final String[] args ) {
        EventQueue.invokeLater( new Runnable() {
            @Override
            public void run() {
                try {
                    final MainMenu mainMenu = new MainMenu();
                    mainMenu.setVisible( true );
                }
                catch ( final Exception e ) {
                    e.printStackTrace();
                }
            }
        } );
    }
}
