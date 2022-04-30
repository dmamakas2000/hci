package gr.aueb.hci.menu;

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

import gr.aueb.hci.singleton.Singleton;

public class TemperatureAdjustMenu extends JFrame {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 4749057480869479912L;

    /**
     * Content pane.
     */
    private JPanel contentPane;

    /**
     * Temperature constants.
     */
    private static final int STARTING_TEMPERATURE = 25;
    private static final int MAX_TEMPERATURE = 35;
    private static final int MIN_TEMPERATURE = 15;

    /**
     * Attributes.
     */
    private int temperature = TemperatureAdjustMenu.STARTING_TEMPERATURE;

    /**
     * Help message.
     */
    private static final String HELP_MESSAGE = "Βρίσκεστε στην οθόνη ρύθμισης θερμοκρασίας."
            + "· Επιλέξτε την επιθυμητή θερμοκρασία και στην συνέχεια πατήστε αποθήκευση για να την επιλέξετε.";

    /**
     * Default constructor.
     */
    public TemperatureAdjustMenu() {
        setResizable( false );
        setBackground( Color.WHITE );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        setBounds( 100, 100, Singleton.getInstance().getWindowSizeWidth(), Singleton.getInstance().getWindowSizeHeight() );
        this.contentPane = new JPanel();
        this.contentPane.setBackground( Color.WHITE );
        this.contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        setContentPane( this.contentPane );
        this.contentPane.setLayout( null );

        final JLabel temperatureLabel = new JLabel( String.valueOf( TemperatureAdjustMenu.STARTING_TEMPERATURE ) );
        temperatureLabel.setFont( new Font( Singleton.getInstance().getFont(), Font.PLAIN, 80 ) );
        temperatureLabel.setBounds( 323, 11, 110, 151 );
        this.contentPane.add( temperatureLabel );

        final JLabel celciusLabel = new JLabel( "\u00B0C" );
        celciusLabel.setFont( new Font( Singleton.getInstance().getFont(), Font.PLAIN, 50 ) );
        celciusLabel.setBounds( 430, 62, 56, 68 );
        this.contentPane.add( celciusLabel );

        final JButton increaseTempButton = new JButton(
                "\u0391\u03BD\u03AD\u03B2\u03B1\u03C3\u03B5 \u03B8\u03B5\u03C1\u03BC\u03BF\u03BA\u03C1\u03B1\u03C3\u03AF\u03B1 (+)" );
        increaseTempButton.setBackground( Color.WHITE );
        increaseTempButton.setFont( new Font( Singleton.getInstance().getFont(), Font.PLAIN, 30 ) );
        increaseTempButton.setBounds( 396, 283, 386, 46 );
        increaseTempButton.setFocusPainted( false );
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

        final JButton decreaseTempButton = new JButton(
                "\u039C\u03B5\u03AF\u03C9\u03C3\u03B5 \u03B8\u03B5\u03C1\u03BC\u03BF\u03BA\u03C1\u03B1\u03C3\u03AF\u03B1 (-)" );
        decreaseTempButton.setBackground( Color.WHITE );
        decreaseTempButton.setFont( new Font( Singleton.getInstance().getFont(), Font.PLAIN, 30 ) );
        decreaseTempButton.setBounds( 15, 283, 371, 46 );
        decreaseTempButton.setFocusPainted( false );
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

        final JButton goBackButton = new JButton( "\u03A0\u03AE\u03B3\u03B1\u03B9\u03BD\u03B5 \u03BC\u03B5 \u03C0\u03AF\u03C3\u03C9" );
        goBackButton.setBackground( Color.WHITE );
        goBackButton.setFont( new Font( Singleton.getInstance().getFont(), Font.PLAIN, 30 ) );
        goBackButton.setBounds( 15, 539, 327, 54 );
        goBackButton.setFocusPainted( false );
        goBackButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                TemperatureAdjustMenu.this.dispose();
                final MainMenu mainMenu = new MainMenu();
                mainMenu.setVisible( true );
            }
        } );
        this.contentPane.add( goBackButton );

        final JButton saveChangesButton = new JButton(
                "\u0395\u03C0\u03B9\u03B2\u03B5\u03B2\u03B1\u03AF\u03C9\u03C3\u03B7 \u03B1\u03BB\u03BB\u03B1\u03B3\u03CE\u03BD" );
        saveChangesButton.setBackground( Color.WHITE );
        saveChangesButton.setFont( new Font( "Arial", Font.PLAIN, 30 ) );
        saveChangesButton.setFocusPainted( false );
        saveChangesButton.setBounds( 220, 340, 360, 54 );
        saveChangesButton.setFocusPainted( false );
        saveChangesButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                TemperatureAdjustMenu.this.dispose();
                final MainMenu mainMenu = new MainMenu( TemperatureAdjustMenu.this.temperature );
                mainMenu.setVisible( true );
            }
        } );
        this.contentPane.add( saveChangesButton );

        final JLabel needHelpLabel = new JLabel( "\u0398\u03AD\u03BB\u03C9 \u03B2\u03BF\u03AE\u03B8\u03B5\u03B9\u03B1" );
        needHelpLabel.setFont( new Font( "Arial", Font.PLAIN, 30 ) );
        needHelpLabel.setBounds( 453, 543, 202, 46 );
        this.contentPane.add( needHelpLabel );

        final JButton needHelpButton = new JButton( "" );
        needHelpButton.setBackground( Color.WHITE );
        needHelpButton.setBounds( 649, 528, 98, 73 );
        needHelpButton.setFocusPainted( false );
        needHelpButton.setBorder( null );
        needHelpButton.setIcon( new ImageIcon( "icons8-info-64.png" ) );
        needHelpButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                JOptionPane.showMessageDialog( null, TemperatureAdjustMenu.HELP_MESSAGE, "Μενού τηλεκοντρόλ", 1 );
            }
        } );
        this.contentPane.add( needHelpButton );
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
