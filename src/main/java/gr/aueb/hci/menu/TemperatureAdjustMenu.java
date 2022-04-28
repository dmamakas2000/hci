package gr.aueb.hci.menu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class TemperatureAdjustMenu extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private static TemperatureAdjustMenu menu;

    private static final int STARTING_TEMPERATURE = 25;
    private static final int MAX_TEMPERATURE = 35;
    private static final int MIN_TEMPERATURE = 15;

    private int temperature = TemperatureAdjustMenu.STARTING_TEMPERATURE;

    /**
     * Launch the application.
     */
    public static void main( final String[] args ) {
        EventQueue.invokeLater( new Runnable() {
            @Override
            public void run() {
                try {
                    TemperatureAdjustMenu.menu = new TemperatureAdjustMenu();
                    TemperatureAdjustMenu.menu.setVisible( true );
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
    public TemperatureAdjustMenu() {
        setResizable( false );
        setBackground( Color.WHITE );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        setBounds( 100, 100, 872, 731 );
        this.contentPane = new JPanel();
        this.contentPane.setBackground( Color.WHITE );
        this.contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        setContentPane( this.contentPane );
        this.contentPane.setLayout( null );

        final JLabel lblNewLabel = new JLabel( String.valueOf( TemperatureAdjustMenu.STARTING_TEMPERATURE ) );
        lblNewLabel.setFont( new Font( "Arial", Font.PLAIN, 80 ) );
        lblNewLabel.setBounds( 355, 11, 110, 151 );
        this.contentPane.add( lblNewLabel );

        final JLabel lblNewLabel_1 = new JLabel( "\u00B0C" );
        lblNewLabel_1.setFont( new Font( "Arial", Font.PLAIN, 50 ) );
        lblNewLabel_1.setBounds( 462, 62, 56, 68 );
        this.contentPane.add( lblNewLabel_1 );

        final JButton increaseTempButton = new JButton(
                "\u0391\u03BD\u03AD\u03B2\u03B1\u03C3\u03B5 \u03B8\u03B5\u03C1\u03BC\u03BF\u03BA\u03C1\u03B1\u03C3\u03AF\u03B1 (+)" );
        increaseTempButton.setFont( new Font( "Arial", Font.PLAIN, 30 ) );
        increaseTempButton.setBounds( 450, 283, 386, 46 );
        increaseTempButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                TemperatureAdjustMenu.this.temperature += 1;
                if ( TemperatureAdjustMenu.this.temperature < TemperatureAdjustMenu.MAX_TEMPERATURE
                        && TemperatureAdjustMenu.this.temperature > TemperatureAdjustMenu.MIN_TEMPERATURE ) {
                    lblNewLabel.setText( String.valueOf( TemperatureAdjustMenu.this.temperature ) );
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
        decreaseTempButton.setFont( new Font( "Arial", Font.PLAIN, 30 ) );
        decreaseTempButton.setBounds( 34, 283, 371, 46 );
        decreaseTempButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                TemperatureAdjustMenu.this.temperature -= 1;
                if ( TemperatureAdjustMenu.this.temperature < TemperatureAdjustMenu.MAX_TEMPERATURE
                        && TemperatureAdjustMenu.this.temperature > TemperatureAdjustMenu.MIN_TEMPERATURE ) {
                    lblNewLabel.setText( String.valueOf( TemperatureAdjustMenu.this.temperature ) );
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
        goBackButton.setFont( new Font( "Arial", Font.PLAIN, 30 ) );
        goBackButton.setBounds( 34, 535, 327, 54 );
        goBackButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                TemperatureAdjustMenu.menu.dispose();
                final MainMenu mainMenu = new MainMenu( TemperatureAdjustMenu.this.temperature );
                mainMenu.setVisible( true );
            }
        } );
        this.contentPane.add( goBackButton );
    }
}
