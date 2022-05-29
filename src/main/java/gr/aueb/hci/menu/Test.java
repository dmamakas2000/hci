package gr.aueb.hci.menu;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import gr.aueb.hci.checkbox.ColorDef;
import gr.aueb.hci.checkbox.SteelCheckBox;

public class Test extends JFrame {

    Container c;
    private JPanel pan = new JPanel();

    SteelCheckBox b1 = new SteelCheckBox();

    /**
     * Create the frame.
     */
    public Test() {
        this.c = getContentPane();
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        setBounds( 100, 100, 655, 473 );
        this.pan.setBackground( Color.WHITE );
        this.pan.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        this.pan.setLayout( null );
        this.b1.setBounds( 210, 212, 100, 26 );
        this.b1.setFont( new Font( "Tahoma", Font.PLAIN, 33 ) );
        this.b1.setForeground( Color.BLACK );
        this.b1.setBackground( Color.WHITE );

        this.b1.setColored( true );
        this.b1.setSelectedColor( ColorDef.RED );
        this.b1.setRised( false );
        this.b1.setText( "Blue" );
        this.pan.add( this.b1 );

        this.c.add( this.pan );
    }

    /**
     * Launch the application.
     */
    public static void main( final String[] args ) {
        EventQueue.invokeLater( new Runnable() {
            @Override
            public void run() {
                try {
                    final Test frame = new Test();
                    frame.setVisible( true );
                }
                catch ( final Exception e ) {
                    e.printStackTrace();
                }
            }
        } );
    }
}
