package gr.aueb.hci.menu;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import gr.aueb.hci.alerts.AirConditionShutdownAlert;
import gr.aueb.hci.alerts.CoolingAlert;
import gr.aueb.hci.alerts.HeatingAlert;
import gr.aueb.hci.singleton.Singleton;
import gr.aueb.hci.singleton.Singleton.State;
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
    private ImageIcon snowFlakeIcon = new ImageIcon( "assets/images/cool/snowflake.png" );
    private ImageIcon fireIconForButton = new ImageIcon( "assets/images/heat/fire_icon.png" );
    private ImageIcon snowFlakeIconForButton = new ImageIcon( "assets/images/cool/snowflake_icon.png" );
    private ImageIcon needHelpIconForButton = new ImageIcon( "assets/images/help/info.png" );
    private ImageIcon shutDownIcon = new ImageIcon( "assets/images/shutdown/shutdown_icon.png" );
    private ImageIcon adjustIcon = new ImageIcon( "assets/images/adjust/adjust-icon.png" );

    /**
     * Starting temperature constant.
     */
    private static final int START_TEMPERATURE = 25;

    /**
     * Date-time attribute.
     */
    private String dateTimeString;

    private JLabel statusLabelIcon;

    private JButton needHelpButton;
    private JButton switchOffButton;
    private JButton heatingButton;
    private JButton coolingButton;

    private JLabel inActionLabel;
    private JLabel temperatureLabel;

    /**
     * Content pane.
     */
    private JPanel contentPane;

    /**
     * Help message.
     */
    private static final String HELP_MESSAGE = "Βρίσκεστε στην κεντρική οθόνη ελέγχου του κλιματιστικού. \n \n"
            + "· Εάν θέλετε να ενεργοποιήσετε την λειτουργία θέρμανσης του κλιματιστικού σας, πατήστε <<Θέρμανση>>. \n"
            + "· Εάν θέλετε να ενεργοποιήσετε την λειτουργία ψύξης του κλιματιστικού σας, πατήστε <<Ψύξη>>. \n"
            + "· Εάν θέλετε να μεταβάλλετε την παρούσα θερμοκρασία του κλιματιστικού σας επιλέξτε <<Ρύθμιση θερμοκρασίας>>. \n"
            + "· Για περισσότερες και πιο σύνθετες λειτουργίες επιλέξτε το μενού <<Περισσότερες λειτουργίες>>. \n \n"
            + "Παρακαλώ, λάβετε υπόψη πως η θερμοκρασία που απεικονίζεται στην κεντρική οθόνη αντιστοιχεί \nστην θερμοκρασία του κλιματιστικού και όχι του εξωτερικού περιβάλλοντος! \n \n"
            + "Τέλος, εάν θέλετε να απενεργοποιήσετε το κλιματιστικό επιλέξτε το κόκκινο κουμπί στο ενδιάμεσο και δεξιά της οθόνης του μενού.";

    /**
     * Main constructor (parsing temperature).
     */
    public MainMenu( final int temp ) {
        init();

        this.temperatureLabel = new JLabel( String.valueOf( temp ) );
        this.temperatureLabel.setFont( new Font( Singleton.getInstance().getFont(), Font.PLAIN, 78 ) );
        this.temperatureLabel.setBounds( 32, 127, 141, 93 );
        this.contentPane.add( this.temperatureLabel );

        this.createMainMenuComponents( Integer.valueOf( this.temperatureLabel.getText() ) );
    }

    /**
     * Default constructor.
     */
    public MainMenu() {
        init();

        this.temperatureLabel = new JLabel( String.valueOf( MainMenu.START_TEMPERATURE ) );
        this.temperatureLabel.setFont( new Font( Singleton.getInstance().getFont(), Font.PLAIN, 78 ) );
        this.temperatureLabel.setBounds( 32, 127, 141, 93 );
        this.contentPane.add( this.temperatureLabel );

        this.createMainMenuComponents( Integer.valueOf( this.temperatureLabel.getText() ) );
    }

    /**
     * Initializes main common components.
     */
    private void init() {
        setResizable( false );
        setIconImage( Toolkit.getDefaultToolkit().getImage( Singleton.getInstance().getFrameIcon() ) );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        setBounds( 100, 100, Singleton.getInstance().getWindowSizeWidth(), Singleton.getInstance().getWindowSizeHeight() );
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
    private void createMainMenuComponents( final int temp ) {
        final JLabel cityLabel = new JLabel( "\u0391\u03B8\u03AE\u03BD\u03B1" );
        cityLabel.setFont( new Font( Singleton.getInstance().getFont(), Font.PLAIN, 40 ) );
        cityLabel.setBounds( 32, 9, 131, 62 );
        this.contentPane.add( cityLabel );

        final JLabel dateLabel = new JLabel( this.dateTimeString );
        dateLabel.setFont( new Font( "Arial", Font.PLAIN, 20 ) );
        dateLabel.setBounds( 32, 71, 737, 53 );
        this.contentPane.add( dateLabel );

        final JLabel celciusLabel = new JLabel( "\u00B0C" );
        celciusLabel.setFont( new Font( Singleton.getInstance().getFont(), Font.PLAIN, 52 ) );
        celciusLabel.setBounds( 128, 155, 71, 53 );
        this.contentPane.add( celciusLabel );

        this.heatingButton = new JButton( "\u0398\u03AD\u03C1\u03BC\u03B1\u03BD\u03C3\u03B7     " );
        this.heatingButton.setBackground( Color.WHITE );
        this.heatingButton.setFont( new Font( Singleton.getInstance().getFont(), Font.PLAIN, 26 ) );
        this.heatingButton.setBounds( 172, 291, 450, 57 );
        this.heatingButton.setIcon( this.fireIconForButton );
        this.heatingButton.setVerticalTextPosition( SwingConstants.CENTER );
        this.heatingButton.setHorizontalTextPosition( SwingConstants.LEADING );
        this.heatingButton.setFocusPainted( false );
        this.heatingButton.setContentAreaFilled( false );
        this.heatingButton.setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ) );
        this.heatingButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                if ( Singleton.getInstance().getState().equals( State.HEAT ) ) {
                    // If we already are in a heating state
                    JOptionPane.showMessageDialog( null, "Το κλιματιστικό βρίσκεται ήδη σε κατάσταση θέρμανσης",
                            "Κύριο μενού - Αλλαγή κατάστασης", 1 );
                }
                else if ( Singleton.getInstance().getState().equals( State.COOL ) ) {
                    final Object[] options1 = { "Ναι", "Όχι" };

                    final JPanel panel = new JPanel();
                    panel.add( new JLabel(
                            "Αυτή τη στιγμή βρίσκεστε σε λειτουργία ψύξης. Θέλετε να μεταβείτε σε κατάσταση θέρμανσης;" ) );

                    final int result = JOptionPane.showOptionDialog( null, panel, "Προσαρμογή θερμοκρασίας",
                            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options1, null );
                    if ( result == JOptionPane.YES_OPTION ) {
                        Singleton.getInstance().setState( State.HEAT );
                        final HeatingAlert heatingAlert = new HeatingAlert();
                        heatingAlert.setVisible( true );
                        MainMenu.this.setVisible( false );
                        new java.util.Timer().schedule( new java.util.TimerTask() {
                            @Override
                            public void run() {
                                heatingAlert.setVisible( false );
                                MainMenu.this.setVisible( true );
                                MainMenu.this.statusLabelIcon.setIcon( MainMenu.this.fireIcon );
                                MainMenu.this.contentPane.setBackground( new Color( 255, 245, 204 ) );
                                MainMenu.this.needHelpButton.setBackground( new Color( 255, 245, 204 ) );
                                MainMenu.this.heatingButton.setBackground( new Color( 255, 255, 255 ) );
                                MainMenu.this.coolingButton.setBackground( new Color( 255, 255, 255 ) );
                                MainMenu.this.switchOffButton.setBackground( new Color( 255, 245, 204 ) );
                                MainMenu.this.inActionLabel.setText( "Σε λειτουργία θέρμανσης" );
                            }
                        }, 3000 );
                    }
                }
                else {
                    Singleton.getInstance().setState( State.HEAT );
                    final HeatingAlert heatingAlert = new HeatingAlert();
                    heatingAlert.setVisible( true );
                    MainMenu.this.setVisible( false );
                    new java.util.Timer().schedule( new java.util.TimerTask() {
                        @Override
                        public void run() {
                            heatingAlert.setVisible( false );
                            MainMenu.this.setVisible( true );
                            MainMenu.this.statusLabelIcon.setIcon( MainMenu.this.fireIcon );
                            MainMenu.this.contentPane.setBackground( new Color( 255, 245, 204 ) );
                            MainMenu.this.needHelpButton.setBackground( new Color( 255, 245, 204 ) );
                            MainMenu.this.heatingButton.setBackground( new Color( 255, 255, 255 ) );
                            MainMenu.this.coolingButton.setBackground( new Color( 255, 255, 255 ) );
                            MainMenu.this.switchOffButton.setBackground( new Color( 255, 245, 204 ) );
                            MainMenu.this.inActionLabel.setText( "Σε λειτουργία θέρμανσης" );
                        }
                    }, 3000 );
                }
            }
        } );
        this.contentPane.add( this.heatingButton );

        this.inActionLabel = new JLabel(
                "\u03A3\u03B5 \u03B1\u03BD\u03B1\u03BC\u03BF\u03BD\u03AE \u03BB\u03B5\u03B9\u03C4\u03BF\u03C5\u03C1\u03B3\u03AF\u03B1\u03C2" );
        this.inActionLabel.setFont( new Font( Singleton.getInstance().getFont(), Font.PLAIN, 40 ) );
        this.inActionLabel.setBounds( 32, 222, 737, 47 );
        this.contentPane.add( this.inActionLabel );

        final JLabel needHelpLabel = new JLabel( "\u0398\u03AD\u03BB\u03C9 \u03B2\u03BF\u03AE\u03B8\u03B5\u03B9\u03B1" );
        needHelpLabel.setFont( new Font( Singleton.getInstance().getFont(), Font.PLAIN, 25 ) );
        needHelpLabel.setBounds( 523, 563, 185, 30 );
        this.contentPane.add( needHelpLabel );

        this.statusLabelIcon = new JLabel( "" );
        this.statusLabelIcon.setBounds( 330, 9, 292, 241 );
        this.contentPane.add( this.statusLabelIcon );

        this.coolingButton = new JButton( "     \u03A8\u03CD\u03BE\u03B7        " );
        this.coolingButton.setFont( new Font( Singleton.getInstance().getFont(), Font.PLAIN, 26 ) );
        this.coolingButton.setBackground( Color.WHITE );
        this.coolingButton.setBounds( 172, 359, 450, 57 );
        this.coolingButton.setIcon( this.snowFlakeIconForButton );
        this.coolingButton.setVerticalTextPosition( SwingConstants.CENTER );
        this.coolingButton.setHorizontalTextPosition( SwingConstants.LEADING );
        this.coolingButton.setFocusPainted( false );
        this.coolingButton.setContentAreaFilled( false );
        this.coolingButton.setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ) );
        this.coolingButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                if ( Singleton.getInstance().getState().equals( State.COOL ) ) {
                    // If we already are in a cooling state
                    JOptionPane.showMessageDialog( null, "Το κλιματιστικό βρίσκεται ήδη σε κατάσταση ψύξης",
                            "Κύριο μενού - Αλλαγή κατάστασης", 1 );
                }
                else if ( Singleton.getInstance().getState().equals( State.HEAT ) ) {
                    final Object[] options1 = { "Ναι", "Όχι" };

                    final JPanel panel = new JPanel();
                    panel.add( new JLabel(
                            "Αυτή τη στιγμή βρίσκεστε σε λειτουργία θέρμανσης. Θέλετε να μεταβείτε σε κατάσταση ψύξης;" ) );

                    final int result = JOptionPane.showOptionDialog( null, panel, "Προσαρμογή θερμοκρασίας",
                            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options1, null );
                    if ( result == JOptionPane.YES_OPTION ) {
                        final CoolingAlert coolingAlert = new CoolingAlert();
                        coolingAlert.setVisible( true );
                        MainMenu.this.setVisible( false );
                        new java.util.Timer().schedule( new java.util.TimerTask() {
                            @Override
                            public void run() {
                                Singleton.getInstance().setState( State.COOL );
                                coolingAlert.setVisible( false );
                                MainMenu.this.setVisible( true );
                                MainMenu.this.coolingButton.setBackground( new Color( 255, 255, 255 ) );
                                MainMenu.this.statusLabelIcon.setIcon( MainMenu.this.snowFlakeIcon );
                                MainMenu.this.contentPane.setBackground( new Color( 212, 242, 255 ) );
                                MainMenu.this.needHelpButton.setBackground( new Color( 212, 242, 255 ) );
                                MainMenu.this.switchOffButton.setBackground( new Color( 212, 242, 255 ) );
                                MainMenu.this.heatingButton.setBackground( new Color( 255, 255, 255 ) );
                                MainMenu.this.coolingButton.setBackground( new Color( 255, 255, 255 ) );
                                MainMenu.this.inActionLabel.setText( "Σε λειτουργία ψύξης" );
                            }
                        }, 3000 );
                    }
                }
                else {
                    final CoolingAlert coolingAlert = new CoolingAlert();
                    coolingAlert.setVisible( true );
                    MainMenu.this.setVisible( false );
                    new java.util.Timer().schedule( new java.util.TimerTask() {
                        @Override
                        public void run() {
                            Singleton.getInstance().setState( State.COOL );
                            coolingAlert.setVisible( false );
                            MainMenu.this.setVisible( true );
                            MainMenu.this.statusLabelIcon.setIcon( MainMenu.this.snowFlakeIcon );
                            MainMenu.this.contentPane.setBackground( new Color( 212, 242, 255 ) );
                            MainMenu.this.needHelpButton.setBackground( new Color( 212, 242, 255 ) );
                            MainMenu.this.switchOffButton.setBackground( new Color( 212, 242, 255 ) );
                            MainMenu.this.heatingButton.setBackground( new Color( 255, 255, 255 ) );
                            MainMenu.this.coolingButton.setBackground( new Color( 255, 255, 255 ) );
                            MainMenu.this.inActionLabel.setText( "Σε λειτουργία ψύξης" );
                        }
                    }, 3000 );
                }
            }
        } );
        this.contentPane.add( this.coolingButton );

        this.needHelpButton = new JButton( "" );
        this.needHelpButton.setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ) );
        this.needHelpButton.setBackground( Color.WHITE );
        this.needHelpButton.setBounds( 688, 539, 94, 73 );
        this.needHelpButton.setIcon( this.needHelpIconForButton );
        this.needHelpButton.setFocusPainted( false );
        this.needHelpButton.setBorder( null );
        this.needHelpButton.setContentAreaFilled( false );
        this.needHelpButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                JOptionPane.showMessageDialog( null, MainMenu.HELP_MESSAGE, "Παράθυρο βοήθειας κεντρικού μενού", 1 );
            }
        } );
        this.contentPane.add( this.needHelpButton );

        final JButton temperatureAdjustButton = new JButton(
                "\u03A1\u03CD\u03B8\u03BC\u03B9\u03C3\u03B7 \u03B8\u03B5\u03C1\u03BC\u03BF\u03BA\u03C1\u03B1\u03C3\u03AF\u03B1\u03C2     " );
        temperatureAdjustButton.setVerticalTextPosition( SwingConstants.CENTER );
        temperatureAdjustButton.setHorizontalTextPosition( SwingConstants.LEADING );
        temperatureAdjustButton.setFont( new Font( Singleton.getInstance().getFont(), Font.PLAIN, 26 ) );
        temperatureAdjustButton.setBackground( Color.WHITE );
        temperatureAdjustButton.setBounds( 172, 427, 450, 57 );
        temperatureAdjustButton.setFocusPainted( false );
        temperatureAdjustButton.setIcon( new ImageIcon( "icons8-hot-48.png" ) );
        temperatureAdjustButton.setContentAreaFilled( false );
        temperatureAdjustButton.setVerticalTextPosition( SwingConstants.CENTER );
        temperatureAdjustButton.setHorizontalTextPosition( SwingConstants.LEADING );
        temperatureAdjustButton.setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ) );
        temperatureAdjustButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                final TemperatureAdjustMenu temperatureAdjustMenu = new TemperatureAdjustMenu( temp );
                temperatureAdjustMenu.setVisible( true );
                MainMenu.this.dispose();
            }
        } );
        this.contentPane.add( temperatureAdjustButton );

        this.switchOffButton = new JButton( "" );
        this.switchOffButton.setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ) );
        this.switchOffButton.setBackground( Color.WHITE );
        this.switchOffButton.setBounds( 669, 108, 100, 100 );
        this.switchOffButton.setIcon( this.shutDownIcon );
        this.switchOffButton.setFocusPainted( false );
        this.switchOffButton.setContentAreaFilled( false );
        this.switchOffButton.setBorder( null );
        this.switchOffButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                MainMenu.this.dispose();
                final AirConditionShutdownAlert alert = new AirConditionShutdownAlert();
                alert.setVisible( true );
                new java.util.Timer().schedule( new java.util.TimerTask() {
                    @Override
                    public void run() {
                        final StartingFrame startingFrame = new StartingFrame();
                        startingFrame.setVisible( true );
                        alert.dispose();
                    }
                }, 3000 );
            }
        } );

        if ( Objects.nonNull( Singleton.getInstance().getState() ) ) {
            switch ( Singleton.getInstance().getState() ) {
                case HEAT:
                    MainMenu.this.statusLabelIcon.setIcon( MainMenu.this.fireIcon );
                    MainMenu.this.contentPane.setBackground( new Color( 255, 245, 204 ) );
                    MainMenu.this.needHelpButton.setBackground( new Color( 255, 245, 204 ) );
                    MainMenu.this.switchOffButton.setBackground( new Color( 255, 245, 204 ) );
                    MainMenu.this.inActionLabel.setText( "Σε λειτουργία θέρμανσης" );
                    this.heatingButton.setBackground( new Color( 255, 255, 255 ) );
                    this.coolingButton.setBackground( new Color( 255, 255, 255 ) );
                    break;

                case COOL:
                    MainMenu.this.statusLabelIcon.setIcon( MainMenu.this.snowFlakeIcon );
                    MainMenu.this.contentPane.setBackground( new Color( 212, 242, 255 ) );
                    MainMenu.this.needHelpButton.setBackground( new Color( 212, 242, 255 ) );
                    MainMenu.this.switchOffButton.setBackground( new Color( 212, 242, 255 ) );
                    MainMenu.this.inActionLabel.setText( "Σε λειτουργία ψύξης" );
                    this.heatingButton.setBackground( new Color( 255, 255, 255 ) );
                    this.coolingButton.setBackground( new Color( 1, 1, 1 ) );
                    break;

                default:
                    this.heatingButton.setBackground( new Color( 255, 245, 204 ) );
                    this.coolingButton.setBackground( new Color( 212, 242, 255 ) );
                    MainMenu.this.contentPane.setBackground( new Color( 255, 255, 255 ) );
                    MainMenu.this.inActionLabel.setText( "Σε αναμονή λειτουργίας" );
                    break;

            }
        }

        this.contentPane.add( this.switchOffButton );

        final JButton extraFunctionsButton = new JButton(
                "\u03A0\u03B5\u03C1\u03B9\u03C3\u03C3\u03CC\u03C4\u03B5\u03C1\u03B5\u03C2 \u03BB\u03B5\u03B9\u03C4\u03BF\u03C5\u03C1\u03B3\u03AF\u03B5\u03C2    " );
        extraFunctionsButton.setVerticalTextPosition( SwingConstants.CENTER );
        extraFunctionsButton.setHorizontalTextPosition( SwingConstants.LEADING );
        extraFunctionsButton.setFont( new Font( "Arial", Font.PLAIN, 26 ) );
        extraFunctionsButton.setFocusPainted( false );
        extraFunctionsButton.setBackground( Color.WHITE );
        extraFunctionsButton.setBounds( 172, 495, 450, 57 );
        extraFunctionsButton.setIcon( new ImageIcon( "icons8-setting-64.png" ) );
        extraFunctionsButton.setContentAreaFilled( false );
        extraFunctionsButton.setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ) );
        extraFunctionsButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                final ExtraFunctionsMenu extraFunctionsMenu = new ExtraFunctionsMenu(
                        Integer.valueOf( MainMenu.this.temperatureLabel.getText() ) );
                extraFunctionsMenu.setVisible( true );
                MainMenu.this.dispose();
            }
        } );
        this.contentPane.add( extraFunctionsButton );

        switch ( Singleton.getInstance().getExtraState() ) {
            case ECONOMY:
                MainMenu.this.inActionLabel.setText( MainMenu.this.inActionLabel.getText() + " (οικονομίας)" );
                break;

            case INVERTER:
                MainMenu.this.inActionLabel.setText( MainMenu.this.inActionLabel.getText() + " (ιονιστή)" );
                break;

            case TURBO:
                MainMenu.this.inActionLabel.setText( MainMenu.this.inActionLabel.getText() + " (ενίσχυσης)" );
                break;

            case SWING:
                MainMenu.this.inActionLabel.setText( MainMenu.this.inActionLabel.getText() + " (περιστροφής)" );
                break;

            default:
                MainMenu.this.inActionLabel.setText( MainMenu.this.inActionLabel.getText() );
                break;
        }
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
