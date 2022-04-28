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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import gr.aueb.hci.alerts.CoolingAlert;
import gr.aueb.hci.alerts.HeatingAlert;

public class MainMenu extends JFrame {

    private ImageIcon snowFlakeIcon = new ImageIcon( "fire4.png" );

    private JPanel contentPane;

    private static MainMenu mainMenu;

    /**
     * Launch the application.
     */
    public static void main( final String[] args ) {
        EventQueue.invokeLater( new Runnable() {
            @Override
            public void run() {
                try {
                    MainMenu.mainMenu = new MainMenu();
                    MainMenu.mainMenu.setVisible( true );
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
    public MainMenu( final int temp ) {
        setResizable( false );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        setBounds( 100, 100, 806, 660 );
        this.contentPane = new JPanel();
        this.contentPane.setBackground( Color.WHITE );
        this.contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        setContentPane( this.contentPane );
        this.contentPane.setLayout( null );

        final JLabel lblNewLabel = new JLabel( "\u0391\u03B8\u03AE\u03BD\u03B1" );
        lblNewLabel.setFont( new Font( "Arial", Font.PLAIN, 40 ) );
        lblNewLabel.setBounds( 32, 29, 148, 87 );
        this.contentPane.add( lblNewLabel );

        final JLabel lblNewLabel_1 = new JLabel(
                "\u0394\u03B5\u03C5\u03C4\u03AD\u03C1\u03B1 28 \u039C\u03B1\u03C1\u03C4\u03AF\u03BF\u03C5, 19:18 \u039C\u039C" );
        lblNewLabel_1.setFont( new Font( "Arial", Font.PLAIN, 28 ) );
        lblNewLabel_1.setBounds( 32, 107, 560, 73 );
        this.contentPane.add( lblNewLabel_1 );

        final JLabel lblNewLabel_2 = new JLabel( String.valueOf( temp ) );
        lblNewLabel_2.setFont( new Font( "Arial", Font.PLAIN, 88 ) );
        lblNewLabel_2.setBounds( 32, 191, 141, 93 );
        this.contentPane.add( lblNewLabel_2 );

        final JLabel lblNewLabel_3 = new JLabel( "\u00B0C" );
        lblNewLabel_3.setFont( new Font( "Arial", Font.PLAIN, 52 ) );
        lblNewLabel_3.setBounds( 141, 222, 71, 53 );
        this.contentPane.add( lblNewLabel_3 );

        final JButton heatingButton = new JButton( "\u0398\u03AD\u03C1\u03BC\u03B1\u03BD\u03C3\u03B7     " );
        heatingButton.setBackground( Color.WHITE );
        heatingButton.setFont( new Font( "Arial", Font.PLAIN, 26 ) );
        heatingButton.setBounds( 141, 349, 517, 57 );
        heatingButton.setIcon( new ImageIcon( "icon2.png" ) );
        heatingButton.setVerticalTextPosition( SwingConstants.CENTER );
        heatingButton.setHorizontalTextPosition( SwingConstants.LEADING );
        this.contentPane.add( heatingButton );

        final JLabel lblNewLabel_4 = new JLabel( "\u03A3\u03B5 \u03BB\u03B5\u03B9\u03C4\u03BF\u03C5\u03C1\u03B3\u03AF\u03B1" );
        lblNewLabel_4.setFont( new Font( "Arial", Font.PLAIN, 40 ) );
        lblNewLabel_4.setBounds( 32, 258, 302, 47 );
        this.contentPane.add( lblNewLabel_4 );

        final JLabel lblNewLabel_5 = new JLabel(
                "\u03A7\u03C1\u03B5\u03B9\u03AC\u03B6\u03B5\u03C3\u03C4\u03B5 \u03B2\u03BF\u03AE\u03B8\u03B5\u03B9\u03B1;" );
        lblNewLabel_5.setFont( new Font( "Arial", Font.PLAIN, 25 ) );
        lblNewLabel_5.setBounds( 24, 571, 225, 30 );
        this.contentPane.add( lblNewLabel_5 );

        final JLabel lblNewLabel_6 = new JLabel( "" );
        lblNewLabel_6.setBounds( 452, 89, 292, 241 );
        lblNewLabel_6.setIcon( this.snowFlakeIcon );
        this.contentPane.add( lblNewLabel_6 );

        final JButton coolingButton = new JButton( "\u03A8\u03CD\u03BE\u03B7      " );
        coolingButton.setFont( new Font( "Arial", Font.PLAIN, 26 ) );
        coolingButton.setBackground( Color.WHITE );
        coolingButton.setBounds( 141, 417, 517, 57 );
        coolingButton.setIcon( new ImageIcon( "snowflake3.png" ) );
        coolingButton.setVerticalTextPosition( SwingConstants.CENTER );
        coolingButton.setHorizontalTextPosition( SwingConstants.LEADING );
        this.contentPane.add( coolingButton );

        final JButton btnNewButton_2 = new JButton( "" );
        btnNewButton_2.setBackground( Color.WHITE );
        btnNewButton_2.setBounds( 674, 555, 94, 47 );
        btnNewButton_2.setIcon( new ImageIcon( "question1.png" ) );
        this.contentPane.add( btnNewButton_2 );

        final JButton temperatureAdjustButton = new JButton(
                "\u03A1\u03CD\u03B8\u03BC\u03B9\u03C3\u03B7 \u03B8\u03B5\u03C1\u03BC\u03BF\u03BA\u03C1\u03B1\u03C3\u03AF\u03B1\u03C2" );
        temperatureAdjustButton.setVerticalTextPosition( SwingConstants.CENTER );
        temperatureAdjustButton.setHorizontalTextPosition( SwingConstants.LEADING );
        temperatureAdjustButton.setFont( new Font( "Arial", Font.PLAIN, 26 ) );
        temperatureAdjustButton.setBackground( Color.WHITE );
        temperatureAdjustButton.setBounds( 141, 485, 517, 57 );
        temperatureAdjustButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                final TemperatureAdjustMenu temperatureAdjustMenu = new TemperatureAdjustMenu();
                temperatureAdjustMenu.setVisible( true );
                MainMenu.mainMenu.dispose();
            }
        } );
        this.contentPane.add( temperatureAdjustButton );
    }

    public MainMenu() {
        setResizable( false );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        setBounds( 100, 100, 806, 660 );
        this.contentPane = new JPanel();
        this.contentPane.setBackground( Color.WHITE );
        this.contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        setContentPane( this.contentPane );
        this.contentPane.setLayout( null );

        final JLabel lblNewLabel = new JLabel( "\u0391\u03B8\u03AE\u03BD\u03B1" );
        lblNewLabel.setFont( new Font( "Arial", Font.PLAIN, 40 ) );
        lblNewLabel.setBounds( 32, 11, 148, 87 );
        this.contentPane.add( lblNewLabel );

        final JLabel lblNewLabel_1 = new JLabel(
                "\u0394\u03B5\u03C5\u03C4\u03AD\u03C1\u03B1 28 \u039C\u03B1\u03C1\u03C4\u03AF\u03BF\u03C5, 19:18 \u039C\u039C" );
        lblNewLabel_1.setFont( new Font( "Arial", Font.PLAIN, 28 ) );
        lblNewLabel_1.setBounds( 32, 89, 560, 73 );
        this.contentPane.add( lblNewLabel_1 );

        final JLabel lblNewLabel_2 = new JLabel( "26" );
        lblNewLabel_2.setFont( new Font( "Arial", Font.PLAIN, 78 ) );
        lblNewLabel_2.setBounds( 32, 154, 141, 93 );
        this.contentPane.add( lblNewLabel_2 );

        final JLabel lblNewLabel_3 = new JLabel( "\u00B0C" );
        lblNewLabel_3.setFont( new Font( "Arial", Font.PLAIN, 52 ) );
        lblNewLabel_3.setBounds( 141, 185, 71, 53 );
        this.contentPane.add( lblNewLabel_3 );

        final JButton heatingButton = new JButton( "\u0398\u03AD\u03C1\u03BC\u03B1\u03BD\u03C3\u03B7     " );
        heatingButton.setBackground( Color.WHITE );
        heatingButton.setFont( new Font( "Arial", Font.PLAIN, 26 ) );
        heatingButton.setBounds( 141, 349, 517, 57 );
        heatingButton.setIcon( new ImageIcon( "icon2.png" ) );
        heatingButton.setVerticalTextPosition( SwingConstants.CENTER );
        heatingButton.setHorizontalTextPosition( SwingConstants.LEADING );
        heatingButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                final HeatingAlert alert = new HeatingAlert();
                alert.setVisible( true );
                MainMenu.mainMenu.dispose();
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
        this.contentPane.add( heatingButton );

        final JLabel lblNewLabel_4 = new JLabel( "\u03A3\u03B5 \u03BB\u03B5\u03B9\u03C4\u03BF\u03C5\u03C1\u03B3\u03AF\u03B1" );
        lblNewLabel_4.setFont( new Font( "Arial", Font.PLAIN, 40 ) );
        lblNewLabel_4.setBounds( 32, 258, 302, 47 );
        this.contentPane.add( lblNewLabel_4 );

        final JLabel lblNewLabel_5 = new JLabel(
                "\u03A7\u03C1\u03B5\u03B9\u03AC\u03B6\u03B5\u03C3\u03C4\u03B5 \u03B2\u03BF\u03AE\u03B8\u03B5\u03B9\u03B1;" );
        lblNewLabel_5.setFont( new Font( "Arial", Font.PLAIN, 25 ) );
        lblNewLabel_5.setBounds( 24, 571, 225, 30 );
        this.contentPane.add( lblNewLabel_5 );

        final JLabel lblNewLabel_6 = new JLabel( "" );
        lblNewLabel_6.setBounds( 452, 89, 292, 241 );
        lblNewLabel_6.setIcon( this.snowFlakeIcon );
        this.contentPane.add( lblNewLabel_6 );

        final JButton coolingButton = new JButton( "\u03A8\u03CD\u03BE\u03B7      " );
        coolingButton.setFont( new Font( "Arial", Font.PLAIN, 26 ) );
        coolingButton.setBackground( Color.WHITE );
        coolingButton.setBounds( 141, 417, 517, 57 );
        coolingButton.setIcon( new ImageIcon( "snowflake3.png" ) );
        coolingButton.setVerticalTextPosition( SwingConstants.CENTER );
        coolingButton.setHorizontalTextPosition( SwingConstants.LEADING );
        coolingButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                final CoolingAlert alert = new CoolingAlert();
                alert.setVisible( true );
                MainMenu.mainMenu.dispose();
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
        this.contentPane.add( coolingButton );

        final JButton btnNewButton_2 = new JButton( "" );
        btnNewButton_2.setBackground( Color.WHITE );
        btnNewButton_2.setBounds( 674, 555, 94, 47 );
        btnNewButton_2.setIcon( new ImageIcon( "question1.png" ) );
        this.contentPane.add( btnNewButton_2 );

        final JButton temperatureAdjustButton = new JButton(
                "\u03A1\u03CD\u03B8\u03BC\u03B9\u03C3\u03B7 \u03B8\u03B5\u03C1\u03BC\u03BF\u03BA\u03C1\u03B1\u03C3\u03AF\u03B1\u03C2" );
        temperatureAdjustButton.setVerticalTextPosition( SwingConstants.CENTER );
        temperatureAdjustButton.setHorizontalTextPosition( SwingConstants.LEADING );
        temperatureAdjustButton.setFont( new Font( "Arial", Font.PLAIN, 26 ) );
        temperatureAdjustButton.setBackground( Color.WHITE );
        temperatureAdjustButton.setBounds( 141, 485, 517, 57 );
        temperatureAdjustButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                final TemperatureAdjustMenu temperatureAdjustMenu = new TemperatureAdjustMenu();
                temperatureAdjustMenu.setVisible( true );
                MainMenu.mainMenu.dispose();
            }
        } );
        this.contentPane.add( temperatureAdjustButton );
    }
}
