package gr.aueb.hci.menu;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import gr.aueb.hci.checkbox.ColorDef;
import gr.aueb.hci.checkbox.SteelCheckBox;
import gr.aueb.hci.panels.ExtraFunctionsMenuPanel;
import gr.aueb.hci.singleton.Singleton;
import gr.aueb.hci.singleton.Singleton.ExtraState;

/**
 * Extra functions frame implementation.
 *
 */
public class ExtraFunctionsMenu extends JFrame {

    /**
     * Generated serial version UID.
     */
    private static final long serialVersionUID = 7579920525804346619L;

    /**
     * Container.
     */
    Container c;

    /**
     * Panel.
     */
    private ExtraFunctionsMenuPanel pan = new ExtraFunctionsMenuPanel();

    /**
     * Button.
     */
    private JButton needHelpButton;

    /**
     * Checkboxes.
     */
    private SteelCheckBox economyMode = new SteelCheckBox();
    private SteelCheckBox inverterMode = new SteelCheckBox();
    private SteelCheckBox turboMode = new SteelCheckBox();
    private SteelCheckBox swingMode = new SteelCheckBox();

    /**
     * Font.
     */
    private static final String FONT = Singleton.getInstance().getFont();

    /**
     * Icons.
     */
    private ImageIcon needHelpIconForButton = new ImageIcon(
            getClass().getClassLoader().getResource( "assets/images/help/info.png" ) );
    private ImageIcon goBackIcon = new ImageIcon( getClass().getClassLoader().getResource( "assets/images/back/go-back.png" ) );

    /**
     * Help message.
     */
    private static final String HELP_MESSAGE = "��������� ���� ����� �������� �����������. \n����� ��� ���� ���������� ��������: \n \n"
            + "� �������� ����������� ����������� \t ��� ���������� �� �������������� ��� ��������� ���������� ��� ������ ��� ������������� ���. \n \n"
            + "� �������� ����������� ���������� \t ��� ���������� �� ������������ ��� �� ������� ��� ������� ���� ��� �������� ��� ����������� ���. \n \n"
            + "� �������� ����������� ��������� \t \t \t \t \t  ��� ���������� �� ������������ ��� �� ���������� ��� ������ ��� �������. \n \n"
            + "� �������� ����������� ���������� \t \t \t \t  ��� ���������� �� ������������ �� ���������� ���������������� ������������ ��������. \n \n \n"
            + "�� ��������� ��� ������ �� ���������������� ������ ������� ���������� ��� ����� ��� �������������, ������� ��������������� �������� �����������. \n \n"
            + "�� ��������� ��� ������ �� ����������� ���� ������ ����� ����� ������ �������� ������ ������� �������� �� �����"
            + "� \n";

    /**
     * Labels.
     */
    private final JLabel economyLabel = new JLabel(
            "\u039B\u03B5\u03B9\u03C4\u03BF\u03C5\u03C1\u03B3\u03AF\u03B1 \u03BF\u03B9\u03BA\u03BF\u03BD\u03BF\u03BC\u03AF\u03B1\u03C2" );
    private final JLabel turboLabel = new JLabel(
            "\u039B\u03B5\u03B9\u03C4\u03BF\u03C5\u03C1\u03B3\u03AF\u03B1 \u03B5\u03BD\u03AF\u03C3\u03C7\u03C5\u03C3\u03B7\u03C2" );
    private final JLabel swingLabel = new JLabel(
            "\u039B\u03B5\u03B9\u03C4\u03BF\u03C5\u03C1\u03B3\u03AF\u03B1 \u03C0\u03B5\u03C1\u03B9\u03C3\u03C4\u03C1\u03BF\u03C6\u03AE\u03C2" );
    private final JLabel inverterLabel = new JLabel(
            "\u039B\u03B5\u03B9\u03C4\u03BF\u03C5\u03C1\u03B3\u03AF\u03B1 \u03B1\u03C6\u03CD\u03B3\u03C1\u03B1\u03BD\u03C3\u03B7\u03C2" );

    /**
     * Create the frame.
     */
    public ExtraFunctionsMenu( final int temp ) {
        /*
         * Basic frame settings.
         */
        setTitle(
                "\u039C\u03B5\u03BD\u03BF\u03CD \u03C3\u03CD\u03BD\u03B8\u03B5\u03C4\u03C9\u03BD \u03B5\u03C0\u03B9\u03BB\u03BF\u03B3\u03CE\u03BD" );
        setResizable( false );
        setIconImage( Toolkit.getDefaultToolkit()
                .getImage( getClass().getClassLoader().getResource( Singleton.getInstance().getFrameIcon() ) ) );
        this.c = getContentPane();
        setDefaultCloseOperation( WindowConstants.DO_NOTHING_ON_CLOSE );
        setBounds( 100, 100, Singleton.getInstance().getWindowSizeWidth(), Singleton.getInstance().getWindowSizeHeight() );
        this.pan.setBackground( Color.WHITE );
        this.pan.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        this.pan.setLayout( null );

        /*
         * Checkboxes settings.
         */
        this.economyMode.setBounds( 485, 217, 206, 26 );
        this.economyMode.setColored( true );
        this.economyMode.setFocusPainted( false );
        this.economyMode.setContentAreaFilled( false );
        this.economyMode.setSelectedColor( ColorDef.GREEN_LCD );
        this.economyMode.setText( "(����������������)" );
        this.pan.add( this.economyMode );

        this.turboMode.setBounds( 485, 267, 206, 26 );
        this.turboMode.setColored( true );
        this.turboMode.setFocusPainted( false );
        this.turboMode.setContentAreaFilled( false );
        this.turboMode.setSelectedColor( ColorDef.RED );
        this.turboMode.setRised( false );
        this.turboMode.setText( "(����������������)" );
        this.pan.add( this.turboMode );

        this.swingMode.setBounds( 485, 317, 206, 26 );
        this.swingMode.setColored( true );
        this.swingMode.setFocusPainted( false );
        this.swingMode.setContentAreaFilled( false );
        this.swingMode.setSelectedColor( ColorDef.YELLOW );
        this.swingMode.setRised( false );
        this.swingMode.setText( "(����������������)" );
        this.pan.add( this.swingMode );

        this.inverterMode.setBounds( 485, 367, 206, 26 );
        this.inverterMode.setColored( true );
        this.inverterMode.setFocusPainted( false );
        this.inverterMode.setContentAreaFilled( false );
        this.inverterMode.setSelectedColor( ColorDef.CYAN );
        this.inverterMode.setRised( false );
        this.inverterMode.setText( "(����������������)" );
        this.pan.add( this.inverterMode );
        this.c.add( this.pan );

        checkForCheckboxes();

        final JLabel lblNewLabel = new JLabel(
                "\u039C\u03C0\u03BF\u03C1\u03B5\u03AF\u03C4\u03B5 \u03BD\u03B1 \u03B5\u03C0\u03B9\u03BB\u03AD\u03BE\u03B5\u03C4\u03B5 \u03BC\u03AF\u03B1 \u03B1\u03C0\u03CC \u03C4\u03B9\u03C2 \u03C0\u03B1\u03C1\u03B1\u03BA\u03AC\u03C4\u03C9" );
        lblNewLabel.setFont( new Font( ExtraFunctionsMenu.FONT, Font.PLAIN, 30 ) );
        lblNewLabel.setBounds( 94, 70, 612, 36 );
        this.pan.add( lblNewLabel );

        final JLabel lblNewLabel_1 = new JLabel(
                "\u03B4\u03B9\u03B1\u03B8\u03AD\u03C3\u03B9\u03BC\u03B5\u03C2 \u03BB\u03B5\u03B9\u03C4\u03BF\u03C5\u03C1\u03B3\u03AF\u03B5\u03C2" );
        lblNewLabel_1.setFont( new Font( ExtraFunctionsMenu.FONT, Font.PLAIN, 30 ) );
        lblNewLabel_1.setBounds( 245, 99, 329, 36 );
        this.pan.add( lblNewLabel_1 );

        this.economyLabel.setFont( new Font( ExtraFunctionsMenu.FONT, Font.PLAIN, 25 ) );
        this.economyLabel.setBounds( 94, 217, 273, 26 );

        this.pan.add( this.economyLabel );
        this.turboLabel.setFont( new Font( ExtraFunctionsMenu.FONT, Font.PLAIN, 25 ) );
        this.turboLabel.setBounds( 94, 267, 273, 26 );

        this.pan.add( this.turboLabel );
        this.swingLabel.setFont( new Font( ExtraFunctionsMenu.FONT, Font.PLAIN, 25 ) );
        this.swingLabel.setBounds( 94, 317, 273, 26 );

        this.pan.add( this.swingLabel );
        this.inverterLabel.setFont( new Font( ExtraFunctionsMenu.FONT, Font.PLAIN, 25 ) );
        this.inverterLabel.setBounds( 94, 367, 273, 26 );

        this.pan.add( this.inverterLabel );

        /*
         * Checkboxes functionality.
         */
        this.economyMode.addItemListener( new ItemListener() {
            @Override
            public void itemStateChanged( final ItemEvent e ) {
                if ( e.getStateChange() == ItemEvent.SELECTED ) {
                    // Economy mode has been selected
                    ExtraFunctionsMenu.this.economyMode.setText( "(����������)" );

                    ExtraFunctionsMenu.this.swingMode.setText( "(����������������)" );
                    ExtraFunctionsMenu.this.inverterMode.setText( "(����������������)" );
                    ExtraFunctionsMenu.this.turboMode.setText( "(����������������)" );

                    ExtraFunctionsMenu.this.swingMode.setSelected( false );
                    ExtraFunctionsMenu.this.inverterMode.setSelected( false );
                    ExtraFunctionsMenu.this.turboMode.setSelected( false );
                }
                else {
                    // Economy mode has been deselected
                    ExtraFunctionsMenu.this.economyMode.setText( "(����������������)" );

                    ExtraFunctionsMenu.this.swingMode.setText( "(����������������)" );
                    ExtraFunctionsMenu.this.inverterMode.setText( "(����������������)" );
                    ExtraFunctionsMenu.this.turboMode.setText( "(����������������)" );

                    ExtraFunctionsMenu.this.swingMode.setSelected( false );
                    ExtraFunctionsMenu.this.inverterMode.setSelected( false );
                    ExtraFunctionsMenu.this.turboMode.setSelected( false );
                }
            }
        } );

        this.swingMode.addItemListener( new ItemListener() {
            @Override
            public void itemStateChanged( final ItemEvent e ) {
                if ( e.getStateChange() == ItemEvent.SELECTED ) {
                    // Economy mode has been selected
                    ExtraFunctionsMenu.this.swingMode.setText( "(����������)" );

                    ExtraFunctionsMenu.this.economyMode.setText( "(����������������)" );
                    ExtraFunctionsMenu.this.inverterMode.setText( "(����������������)" );
                    ExtraFunctionsMenu.this.turboMode.setText( "(����������������)" );

                    ExtraFunctionsMenu.this.economyMode.setSelected( false );
                    ExtraFunctionsMenu.this.inverterMode.setSelected( false );
                    ExtraFunctionsMenu.this.turboMode.setSelected( false );

                }
                else {
                    // Economy mode has been deselected
                    ExtraFunctionsMenu.this.swingMode.setText( "(����������������)" );

                    ExtraFunctionsMenu.this.economyMode.setText( "(����������������)" );
                    ExtraFunctionsMenu.this.inverterMode.setText( "(����������������)" );
                    ExtraFunctionsMenu.this.turboMode.setText( "(����������������)" );

                    ExtraFunctionsMenu.this.economyMode.setSelected( false );
                    ExtraFunctionsMenu.this.inverterMode.setSelected( false );
                    ExtraFunctionsMenu.this.turboMode.setSelected( false );
                }
            }
        } );

        this.turboMode.addItemListener( new ItemListener() {
            @Override
            public void itemStateChanged( final ItemEvent e ) {
                if ( e.getStateChange() == ItemEvent.SELECTED ) {
                    // Economy mode has been selected
                    ExtraFunctionsMenu.this.turboMode.setText( "(����������)" );

                    ExtraFunctionsMenu.this.swingMode.setText( "(����������������)" );
                    ExtraFunctionsMenu.this.inverterMode.setText( "(����������������)" );
                    ExtraFunctionsMenu.this.economyMode.setText( "(����������������)" );

                    ExtraFunctionsMenu.this.swingMode.setSelected( false );
                    ExtraFunctionsMenu.this.inverterMode.setSelected( false );
                    ExtraFunctionsMenu.this.economyMode.setSelected( false );
                }
                else {
                    // Economy mode has been deselected
                    ExtraFunctionsMenu.this.turboMode.setText( "(����������������)" );

                    ExtraFunctionsMenu.this.swingMode.setText( "(����������������)" );
                    ExtraFunctionsMenu.this.inverterMode.setText( "(����������������)" );
                    ExtraFunctionsMenu.this.economyMode.setText( "(����������������)" );

                    ExtraFunctionsMenu.this.swingMode.setSelected( false );
                    ExtraFunctionsMenu.this.inverterMode.setSelected( false );
                    ExtraFunctionsMenu.this.economyMode.setSelected( false );
                }
            }
        } );

        this.inverterMode.addItemListener( new ItemListener() {
            @Override
            public void itemStateChanged( final ItemEvent e ) {
                if ( e.getStateChange() == ItemEvent.SELECTED ) {
                    // Economy mode has been selected
                    ExtraFunctionsMenu.this.inverterMode.setText( "(����������)" );

                    ExtraFunctionsMenu.this.swingMode.setText( "(����������������)" );
                    ExtraFunctionsMenu.this.economyMode.setText( "(����������������)" );
                    ExtraFunctionsMenu.this.turboMode.setText( "(����������������)" );

                    ExtraFunctionsMenu.this.swingMode.setSelected( false );
                    ExtraFunctionsMenu.this.economyMode.setSelected( false );
                    ExtraFunctionsMenu.this.turboMode.setSelected( false );
                }
                else {
                    // Economy mode has been deselected
                    ExtraFunctionsMenu.this.inverterMode.setText( "(����������������)" );

                    ExtraFunctionsMenu.this.swingMode.setText( "(����������������)" );
                    ExtraFunctionsMenu.this.economyMode.setText( "(����������������)" );
                    ExtraFunctionsMenu.this.turboMode.setText( "(����������������)" );

                    ExtraFunctionsMenu.this.swingMode.setSelected( false );
                    ExtraFunctionsMenu.this.economyMode.setSelected( false );
                    ExtraFunctionsMenu.this.turboMode.setSelected( false );
                }
            }
        } );

        final JButton goBackButton = new JButton( "\u03A0\u03AE\u03B3\u03B1\u03B9\u03BD\u03B5 \u03BC\u03B5 \u03C0\u03AF\u03C3\u03C9" );
        goBackButton.setBackground( Color.WHITE );
        goBackButton.setFont( new Font( ExtraFunctionsMenu.FONT, Font.PLAIN, 25 ) );
        goBackButton.setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ) );
        goBackButton.setFocusPainted( false );
        goBackButton.setBounds( 31, 553, 273, 45 );
        goBackButton.setIcon( this.goBackIcon );
        goBackButton.setContentAreaFilled( false );
        goBackButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                if ( !getSelectedState().equals( Singleton.getInstance().getExtraState() ) ) {
                    // Changes have been performed
                    final Object[] options1 = { "���", "���" };

                    final JPanel panel = new JPanel();
                    panel.add( new JLabel(
                            "����� �������� ��� ������� ���������� ��� �� ������������. ������ �� ������������ ���� ��� ������;" ) );

                    final int result = JOptionPane.showOptionDialog( null, panel, "������� �������� �����������",
                            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options1, null );
                    if ( result == JOptionPane.YES_OPTION ) {
                        // Yes, perform the change
                        updateCurrentExtraState(); // Update extra state
                    }
                }
                // Go back in main menu
                final MainMenu menu = new MainMenu( temp );
                ExtraFunctionsMenu.this.dispose();
                menu.setVisible( true );
            }
        } );
        this.pan.add( goBackButton );

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
                JOptionPane.showMessageDialog( null, ExtraFunctionsMenu.HELP_MESSAGE, "����� �������� �������� ��������", 1 );
            }
        } );
        this.pan.add( this.needHelpButton );

        final JLabel needHelpLabel = new JLabel( "\u0398\u03AD\u03BB\u03C9 \u03B2\u03BF\u03AE\u03B8\u03B5\u03B9\u03B1" );
        needHelpLabel.setFont( new Font( ExtraFunctionsMenu.FONT, Font.PLAIN, 25 ) );
        needHelpLabel.setBounds( 524, 553, 203, 43 );
        this.pan.add( needHelpLabel );
    }

    /**
     * Checks the equilavent checkbox at the UI based on the current extra state selected.
     */
    private void checkForCheckboxes() {
        switch ( Singleton.getInstance().getExtraState() ) {
            case ECONOMY:
                this.economyMode.setSelected( true );
                break;

            case INVERTER:
                this.inverterMode.setSelected( true );
                break;

            case SWING:
                this.swingMode.setSelected( true );
                break;

            case TURBO:
                this.turboMode.setSelected( true );
                break;

            case START:
                this.economyMode.setSelected( false );
                this.inverterMode.setSelected( false );
                this.swingMode.setSelected( false );
                this.turboMode.setSelected( false );
                break;

            default:
                break;
        }
    }

    /**
     * Retrieves the extra function selected from the UI.
     *
     * @return ExtraState instance indicating the extra function selected.
     */
    private ExtraState getSelectedState() {
        if ( this.economyMode.isSelected() ) {
            return ExtraState.ECONOMY;
        }
        else if ( this.inverterMode.isSelected() ) {
            return ExtraState.INVERTER;
        }
        else if ( this.swingMode.isSelected() ) {
            return ExtraState.SWING;
        }
        else if ( this.turboMode.isSelected() ) {
            return ExtraState.TURBO;
        }
        else {
            return ExtraState.START;
        }
    }

    /**
     * Updates Singleton's extra state field based on user's selection.
     */
    private void updateCurrentExtraState() {
        if ( this.economyMode.isSelected() ) {
            Singleton.getInstance().setExtraState( ExtraState.ECONOMY );
        }
        else if ( this.inverterMode.isSelected() ) {
            Singleton.getInstance().setExtraState( ExtraState.INVERTER );
        }
        else if ( this.swingMode.isSelected() ) {
            Singleton.getInstance().setExtraState( ExtraState.SWING );
        }
        else if ( this.turboMode.isSelected() ) {
            Singleton.getInstance().setExtraState( ExtraState.TURBO );
        }
        else {
            Singleton.getInstance().setExtraState( ExtraState.START );
        }
    }

    /**
     * Launch the application.
     */
    public static void main( final String[] args ) {
        EventQueue.invokeLater( new Runnable() {
            @Override
            public void run() {
                try {
                    final ExtraFunctionsMenu frame = new ExtraFunctionsMenu( 25 );
                    frame.setVisible( true );
                }
                catch ( final Exception e ) {
                    e.printStackTrace();
                }
            }
        } );
    }
}
