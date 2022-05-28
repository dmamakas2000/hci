package gr.aueb.hci.alerts;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import gr.aueb.hci.singleton.Singleton;
import gr.aueb.hci.singleton.Singleton.ExtraState;

public class ExtraFunctionalityAlert extends JFrame {

    /**
     * Generated serial version UID.
     */
    private static final long serialVersionUID = -8775861957547811528L;

    private JPanel contentPane;

    private ImageIcon verificationIcon = new ImageIcon( "assets/images/verification/verification_icon.png" );

    /**
     * Launch the application.
     */
    public static void main( final String[] args ) {
        EventQueue.invokeLater( new Runnable() {
            @Override
            public void run() {
                try {
                    final ExtraFunctionalityAlert frame = new ExtraFunctionalityAlert( ExtraState.TURBO );
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
    public ExtraFunctionalityAlert( final ExtraState state ) {
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        setBounds( 100, 100, Singleton.getInstance().getWindowSizeWidth(), Singleton.getInstance().getWindowSizeHeight() );
        this.contentPane = new JPanel();
        this.contentPane.setBackground( Color.WHITE );
        this.contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );

        setContentPane( this.contentPane );
        this.contentPane.setLayout( null );

        final JLabel labelFirst = new JLabel(
                "\u0388\u03C7\u03B5\u03C4\u03B5 \u03B5\u03BD\u03B5\u03C1\u03B3\u03BF\u03C0\u03BF\u03B9\u03AE\u03C3\u03B5\u03B9 \u03C4\u03B7\u03BD \u03BB\u03B5\u03B9\u03C4\u03BF\u03C5\u03C1\u03B3\u03AF\u03B1" );
        labelFirst.setFont( new Font( "Arial", Font.PLAIN, 45 ) );
        labelFirst.setBounds( 30, 48, 752, 73 );
        this.contentPane.add( labelFirst );

        final JLabel labelSecond = new JLabel( "" );
        labelSecond.setFont( new Font( "Arial", Font.PLAIN, 45 ) );
        labelSecond.setBounds( 165, 132, 581, 73 );
        this.contentPane.add( labelSecond );

        final JLabel imageLabel = new JLabel( "" );
        imageLabel.setBounds( 279, 251, 314, 243 );
        imageLabel.setIcon( this.verificationIcon );
        this.contentPane.add( imageLabel );

        switch ( state ) {
            case INVERTER:
                labelSecond.setText( "���������� ��������!" );
                break;

            case ECONOMY:
                labelSecond.setText( "���������� ��������!" );
                break;

            case TURBO:
                labelSecond.setText( "��������� ��������!" );
                break;

            case SWING:
                labelSecond.setText( "����������� ��������!" );
                break;

            default:
                labelSecond.setText( "" );
                break;
        }
    }
}