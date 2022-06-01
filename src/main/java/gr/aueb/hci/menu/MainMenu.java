package gr.aueb.hci.menu;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
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
import gr.aueb.hci.panels.MainMenuPanel;
import gr.aueb.hci.service.DateTimeTranslatorService;
import gr.aueb.hci.singleton.Singleton;
import gr.aueb.hci.singleton.Singleton.State;
import gr.aueb.hci.splash.StartingFrame;

/**
 * Main frame implementation.
 *
 */
public class MainMenu extends JFrame {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 7391903381566791295L;

    /**
     * Date & time translator service.
     */
    DateTimeTranslatorService translatorService = new DateTimeTranslatorService();

    /**
     * Icons.
     */
    private ImageIcon fireIcon = new ImageIcon( getClass().getClassLoader().getResource( "assets/images/heat/fire.png" ) );
    private ImageIcon snowFlakeIcon = new ImageIcon( getClass().getClassLoader().getResource( "assets/images/cool/snowflake.png" ) );
    private ImageIcon fireIconForButton = new ImageIcon(
            getClass().getClassLoader().getResource( "assets/images/heat/fire_icon.png" ) );
    private ImageIcon snowFlakeIconForButton = new ImageIcon(
            getClass().getClassLoader().getResource( "assets/images/cool/snowflake_icon.png" ) );
    private ImageIcon needHelpIconForButton = new ImageIcon(
            getClass().getClassLoader().getResource( "assets/images/help/info.png" ) );
    private ImageIcon shutDownIcon = new ImageIcon(
            getClass().getClassLoader().getResource( "assets/images/shutdown/shutdown_icon.png" ) );
    private ImageIcon adjustIcon = new ImageIcon( getClass().getClassLoader().getResource( "assets/images/adjust/adjust-icon.png" ) );
    private ImageIcon settingIcon = new ImageIcon( getClass().getClassLoader().getResource( "assets/images/setting/setting.png" ) );

    /**
     * Starting temperature constant.
     */
    private static final int START_TEMPERATURE = 25;

    /**
     * Font.
     */
    private static final String FONT = Singleton.getInstance().getFont();

    /**
     * Date-time attribute.
     */
    private String dateTimeString;

    /**
     * Buttons.
     */
    private JButton needHelpButton;
    private JButton switchOffButton;
    private JButton heatingButton;
    private JButton coolingButton;

    /**
     * Labels.
     */
    private JLabel statusLabelIcon;
    private JLabel inActionLabel;
    private JLabel temperatureLabel;

    /**
     * Content pane.
     */
    private MainMenuPanel contentPane;

    /**
     * Help message.
     */
    private static final String HELP_MESSAGE = "��������� ���� �������� ����� ������� ��� �������������. \n \n"
            + "� ��� ������ �� �������������� ��� ���������� ��������� ��� ������������� ���, ������� ���������. \n"
            + "� ��� ������ �� �������������� ��� ���������� ����� ��� ������������� ���, ������� �����. \n"
            + "� ��� ������ �� ����������� ��� ������� ����������� ��� ������������� ��� �������� �������� ������������. \n"
            + "� ��� ������������ ��� ��� �������� ����������� �������� �� ����� ������������� �����������. \n \n"
            + "��������, ������ ����� ��� � ����������� ��� ������������� ���� �������� ����� ����������� \n���� ����������� ��� ������������� ��� ��� ��� ���������� �������������! \n \n"
            + "�����, ��� ������ �� ���������������� �� ������������ �������� �� ������� ������ ��� ��������� ��� ����� ��� ������ ��� �����.";

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
        setTitle( "\u039A\u03B5\u03BD\u03C4\u03C1\u03B9\u03BA\u03CC \u03BC\u03B5\u03BD\u03BF\u03CD" );
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
        setIconImage( Toolkit.getDefaultToolkit()
                .getImage( getClass().getClassLoader().getResource( Singleton.getInstance().getFrameIcon() ) ) );
        setDefaultCloseOperation( WindowConstants.DO_NOTHING_ON_CLOSE );
        setBounds( 100, 100, Singleton.getInstance().getWindowSizeWidth(), Singleton.getInstance().getWindowSizeHeight() );

        if ( Singleton.getInstance().getState().equals( State.HEAT ) ) {
            this.contentPane = new MainMenuPanel( State.HEAT );
        }
        else if ( Singleton.getInstance().getState().equals( State.COOL ) ) {
            this.contentPane = new MainMenuPanel( State.COOL );
        }
        else {
            this.contentPane = new MainMenuPanel( State.START );
        }

        this.contentPane.setBackground( Color.WHITE );
        this.contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        setContentPane( this.contentPane );
        this.contentPane.setLayout( null );

        // Current date-time initialization
        final LocalDateTime dateTimeNow = LocalDateTime.now();
        this.dateTimeString = this.translatorService.dateTimeTranslator( dateTimeNow.getDayOfWeek().toString(),
                dateTimeNow.getMonth().toString(), dateTimeNow.getDayOfMonth(), dateTimeNow.getHour(), dateTimeNow.getMinute(),
                dateTimeNow.getYear() );
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
        dateLabel.setFont( new Font( MainMenu.FONT, Font.PLAIN, 20 ) );
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
                    JOptionPane.showMessageDialog( null, "�� ������������ ��������� ��� �� ��������� ���������",
                            "����� ����� - ������ ����������", 1 );
                }
                else if ( Singleton.getInstance().getState().equals( State.COOL ) ) {
                    final Object[] options1 = { "���", "���" };

                    final JPanel panel = new JPanel();
                    panel.add( new JLabel(
                            "���� �� ������ ��������� �� ���������� �����. ������ �� ��������� �� ��������� ���������;" ) );

                    final int result = JOptionPane.showOptionDialog( null, panel, "���������� ������������",
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
                                MainMenu.this.contentPane.setState( State.HEAT );
                                MainMenu.this.needHelpButton.setBackground( new Color( 255, 245, 204 ) );
                                MainMenu.this.heatingButton.setBackground( new Color( 255, 255, 255 ) );
                                MainMenu.this.coolingButton.setBackground( new Color( 255, 255, 255 ) );
                                MainMenu.this.switchOffButton.setBackground( new Color( 255, 245, 204 ) );
                                MainMenu.this.inActionLabel.setText( "�� ���������� ���������" );
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
                            MainMenu.this.contentPane.setState( State.HEAT );
                            MainMenu.this.statusLabelIcon.setIcon( MainMenu.this.fireIcon );
                            MainMenu.this.contentPane.setBackground( new Color( 255, 245, 204 ) );
                            MainMenu.this.needHelpButton.setBackground( new Color( 255, 245, 204 ) );
                            MainMenu.this.heatingButton.setBackground( new Color( 255, 255, 255 ) );
                            MainMenu.this.coolingButton.setBackground( new Color( 255, 255, 255 ) );
                            MainMenu.this.switchOffButton.setBackground( new Color( 255, 245, 204 ) );
                            MainMenu.this.inActionLabel.setText( "�� ���������� ���������" );
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
                    JOptionPane.showMessageDialog( null, "�� ������������ ��������� ��� �� ��������� �����",
                            "����� ����� - ������ ����������", 1 );
                }
                else if ( Singleton.getInstance().getState().equals( State.HEAT ) ) {
                    final Object[] options1 = { "���", "���" };

                    final JPanel panel = new JPanel();
                    panel.add( new JLabel(
                            "���� �� ������ ��������� �� ���������� ���������. ������ �� ��������� �� ��������� �����;" ) );

                    final int result = JOptionPane.showOptionDialog( null, panel, "���������� ������������",
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
                                MainMenu.this.contentPane.setState( State.COOL );
                                MainMenu.this.needHelpButton.setBackground( new Color( 212, 242, 255 ) );
                                MainMenu.this.switchOffButton.setBackground( new Color( 212, 242, 255 ) );
                                MainMenu.this.heatingButton.setBackground( new Color( 255, 255, 255 ) );
                                MainMenu.this.coolingButton.setBackground( new Color( 255, 255, 255 ) );
                                MainMenu.this.inActionLabel.setText( "�� ���������� �����" );
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
                            MainMenu.this.contentPane.setState( State.COOL );
                            MainMenu.this.needHelpButton.setBackground( new Color( 212, 242, 255 ) );
                            MainMenu.this.switchOffButton.setBackground( new Color( 212, 242, 255 ) );
                            MainMenu.this.heatingButton.setBackground( new Color( 255, 255, 255 ) );
                            MainMenu.this.coolingButton.setBackground( new Color( 255, 255, 255 ) );
                            MainMenu.this.inActionLabel.setText( "�� ���������� �����" );
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
                JOptionPane.showMessageDialog( null, MainMenu.HELP_MESSAGE, "�������� �������� ��������� �����", 1 );
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
        temperatureAdjustButton.setIcon( this.adjustIcon );
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
                Singleton.getInstance().setState( State.START );
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
                    MainMenu.this.inActionLabel.setText( "�� ���������� ���������" );
                    this.heatingButton.setBackground( new Color( 255, 255, 255 ) );
                    this.coolingButton.setBackground( new Color( 255, 255, 255 ) );
                    break;

                case COOL:
                    MainMenu.this.statusLabelIcon.setIcon( MainMenu.this.snowFlakeIcon );
                    MainMenu.this.contentPane.setBackground( new Color( 212, 242, 255 ) );
                    MainMenu.this.needHelpButton.setBackground( new Color( 212, 242, 255 ) );
                    MainMenu.this.switchOffButton.setBackground( new Color( 212, 242, 255 ) );
                    MainMenu.this.inActionLabel.setText( "�� ���������� �����" );
                    this.heatingButton.setBackground( new Color( 255, 255, 255 ) );
                    this.coolingButton.setBackground( new Color( 1, 1, 1 ) );
                    break;

                default:
                    this.heatingButton.setBackground( new Color( 255, 245, 204 ) );
                    this.coolingButton.setBackground( new Color( 212, 242, 255 ) );
                    MainMenu.this.contentPane.setBackground( new Color( 255, 255, 255 ) );
                    MainMenu.this.inActionLabel.setText( "�� ������� �����������" );
                    break;

            }
        }

        this.contentPane.add( this.switchOffButton );

        final JButton extraFunctionsButton = new JButton(
                "\u03A0\u03B5\u03C1\u03B9\u03C3\u03C3\u03CC\u03C4\u03B5\u03C1\u03B5\u03C2 \u03BB\u03B5\u03B9\u03C4\u03BF\u03C5\u03C1\u03B3\u03AF\u03B5\u03C2    " );
        extraFunctionsButton.setVerticalTextPosition( SwingConstants.CENTER );
        extraFunctionsButton.setHorizontalTextPosition( SwingConstants.LEADING );
        extraFunctionsButton.setFont( new Font( MainMenu.FONT, Font.PLAIN, 26 ) );
        extraFunctionsButton.setFocusPainted( false );
        extraFunctionsButton.setBackground( Color.WHITE );
        extraFunctionsButton.setBounds( 172, 495, 450, 57 );
        extraFunctionsButton.setIcon( this.settingIcon );
        extraFunctionsButton.setContentAreaFilled( false );
        extraFunctionsButton.setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ) );
        extraFunctionsButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                if ( Singleton.getInstance().getState().equals( State.START ) ) {
                    JOptionPane.showMessageDialog( null, "��� �� ���������, ������ ����� �� ��������� ���������� ��������� � �����.",
                            "�������� �����", 1 );
                }
                else {
                    final ExtraFunctionsMenu extraFunctionsMenu = new ExtraFunctionsMenu(
                            Integer.valueOf( MainMenu.this.temperatureLabel.getText() ) );
                    extraFunctionsMenu.setVisible( true );
                    MainMenu.this.dispose();
                }
            }
        } );
        this.contentPane.add( extraFunctionsButton );

        switch ( Singleton.getInstance().getExtraState() ) {
            case ECONOMY:
                MainMenu.this.inActionLabel.setText( MainMenu.this.inActionLabel.getText() + " (����������)" );
                break;

            case INVERTER:
                MainMenu.this.inActionLabel.setText( MainMenu.this.inActionLabel.getText() + " (����������)" );
                break;

            case TURBO:
                MainMenu.this.inActionLabel.setText( MainMenu.this.inActionLabel.getText() + " (���������)" );
                break;

            case SWING:
                MainMenu.this.inActionLabel.setText( MainMenu.this.inActionLabel.getText() + " (�����������)" );
                break;

            default:
                MainMenu.this.inActionLabel.setText( MainMenu.this.inActionLabel.getText() );
                break;
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
