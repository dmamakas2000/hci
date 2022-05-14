package gr.aueb.hci.menu;

import java.awt.Color;
import java.awt.Cursor;
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

public class ExtraFunctionsMenu extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 4096472432248884379L;

    private JPanel contentPane;

    private JButton needHelpButton;

    private ImageIcon needHelpIconForButton = new ImageIcon( "assets/images/help/info.png" );

    private static final String HELP_MESSAGE = "";

    /**
     * Launch the application.
     */
    public static void main( final String[] args ) {
        EventQueue.invokeLater( new Runnable() {
            @Override
            public void run() {
                try {
                    final ExtraFunctionsMenu frame = new ExtraFunctionsMenu();
                    frame.setVisible( true );
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
    public ExtraFunctionsMenu() {
        setBackground( Color.WHITE );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        setBounds( 100, 100, Singleton.getInstance().getWindowSizeWidth(), Singleton.getInstance().getWindowSizeHeight() );
        this.contentPane = new JPanel();
        this.contentPane.setBackground( Color.WHITE );
        this.contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        setContentPane( this.contentPane );
        this.contentPane.setLayout( null );

        final JLabel lblNewLabel = new JLabel(
                "\u039C\u03C0\u03BF\u03C1\u03B5\u03AF\u03C4\u03B5 \u03BD\u03B1 \u03B5\u03C0\u03B9\u03BB\u03AD\u03BE\u03B5\u03C4\u03B5 \u03BC\u03AF\u03B1 \u03B1\u03C0\u03CC \u03C4\u03B9\u03C2" );
        lblNewLabel.setFont( new Font( "Arial", Font.PLAIN, 30 ) );
        lblNewLabel.setBounds( 162, 35, 491, 51 );
        this.contentPane.add( lblNewLabel );

        final JLabel lblNewLabel_1 = new JLabel(
                "\u03C0\u03B1\u03C1\u03B1\u03BA\u03AC\u03C4\u03C9 \u03B4\u03B9\u03B1\u03B8\u03AD\u03C3\u03B9\u03BC\u03B5\u03C2 \u03BB\u03B5\u03B9\u03C4\u03BF\u03C5\u03C1\u03B3\u03AF\u03B5\u03C2" );
        lblNewLabel_1.setFont( new Font( "Arial", Font.PLAIN, 30 ) );
        lblNewLabel_1.setBounds( 162, 81, 456, 58 );
        this.contentPane.add( lblNewLabel_1 );

        final JButton inverterMode = new JButton(
                "\u039B\u03B5\u03B9\u03C4\u03BF\u03C5\u03C1\u03B3\u03AF\u03B1 \u03B1\u03C6\u03CD\u03B3\u03C1\u03B1\u03BD\u03C3\u03B7\u03C2" );
        inverterMode.setFont( new Font( "Arial", Font.PLAIN, 25 ) );
        inverterMode.setBounds( 31, 266, 332, 65 );
        this.contentPane.add( inverterMode );

        final JButton turboMode = new JButton( "\u039B\u03B5\u03B9\u03C4\u03BF\u03C5\u03C1\u03B3\u03AF\u03B1 TURBO" );
        turboMode.setFont( new Font( "Arial", Font.PLAIN, 25 ) );
        turboMode.setBounds( 31, 368, 332, 65 );
        this.contentPane.add( turboMode );

        final JButton economyMode = new JButton(
                "\u039B\u03B5\u03B9\u03C4\u03BF\u03C5\u03C1\u03B3\u03AF\u03B1 \u03BF\u03B9\u03BA\u03BF\u03BD\u03BF\u03BC\u03AF\u03B1\u03C2" );
        economyMode.setFont( new Font( "Arial", Font.PLAIN, 25 ) );
        economyMode.setBounds( 450, 266, 332, 65 );
        this.contentPane.add( economyMode );

        final JButton goBackButton = new JButton( "\u03A0\u03AE\u03B3\u03B1\u03B9\u03BD\u03B5 \u03BC\u03B5 \u03C0\u03AF\u03C3\u03C9" );
        goBackButton.setFont( new Font( "Arial", Font.PLAIN, 25 ) );
        goBackButton.setBounds( 31, 533, 332, 65 );
        goBackButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                final MainMenu menu = new MainMenu();
                ExtraFunctionsMenu.this.dispose();
                menu.setVisible( true );
            }
        } );
        this.contentPane.add( goBackButton );

        this.needHelpButton = new JButton( "" );
        this.needHelpButton.setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ) );
        this.needHelpButton.setBackground( Color.WHITE );
        this.needHelpButton.setBounds( 688, 539, 94, 73 );
        this.needHelpButton.setIcon( this.needHelpIconForButton );
        this.needHelpButton.setFocusPainted( false );
        this.needHelpButton.setBorder( null );
        this.needHelpButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                JOptionPane.showMessageDialog( null, ExtraFunctionsMenu.HELP_MESSAGE, "Κεντρικό μενού", 1 );
            }
        } );
        this.contentPane.add( this.needHelpButton );

        final JLabel lblNewLabel_2 = new JLabel( "\u0398\u03AD\u03BB\u03C9 \u03B2\u03BF\u03AE\u03B8\u03B5\u03B9\u03B1" );
        lblNewLabel_2.setFont( new Font( "Arial", Font.PLAIN, 25 ) );
        lblNewLabel_2.setBounds( 524, 553, 203, 43 );
        this.contentPane.add( lblNewLabel_2 );
    }
}
