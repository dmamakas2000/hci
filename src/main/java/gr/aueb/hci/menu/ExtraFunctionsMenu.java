package gr.aueb.hci.menu;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
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

import gr.aueb.hci.alerts.ExtraFunctionalityAlert;
import gr.aueb.hci.singleton.Singleton;
import gr.aueb.hci.singleton.Singleton.ExtraState;

public class ExtraFunctionsMenu extends JFrame {

    /**
     * Generated version UID.
     */
    private static final long serialVersionUID = 4096472432248884379L;

    /**
     * Content pane.
     */
    private JPanel contentPane;

    /**
     * Help button.
     */
    private JButton needHelpButton;

    /**
     * Icons.
     */
    private ImageIcon needHelpIconForButton = new ImageIcon( "assets/images/help/info.png" );

    /**
     * Help message.
     */
    private static final String HELP_MESSAGE = "Βρίσκεστε στην οθόνη σύνθετων λειτουργιών. \n Έχετε τις εξής διαθέσιμες επιλογές: \n \n"
            + "· <<Επιλογή λειτουργίας περιστροφής>> \t Εάν επιθυμείτε να ενεργοποιήσετε την περιοδική περιστροφή του φτερού του κλιματιστικού σας. \n \n"
            + "· <<Επιλογή λειρουργίας αφύγρανσης>> \t Εάν επιθυμείτε το κλιματιστικό σας να αφαιρεί την υγρασία κατά την διάρκεια της λειτουργίας του. \n \n"
            + "· <<Επιλογή λειτουργίας ενίσχυσης>> \t \t \t \t \t  Εάν επιθυμείτε το κλιματιστικό σας να λειτουργεί πιο έντονα και γρήγορα. \n \n"
            + "· <<Επιλογή λειτουργίας οικονομίας>> \t \t \t \t  Εάν επιθυμείτε το κλιματιστικό να λειτουργεί πραγματοποιώντας εξοικονόμηση ρεύματος. \n \n \n"
            + "Σε περίπτωση που θέλετε να απενεργοποιήσετε κάποια σύνθετη λειτουργία που έχετε ήδη ενεργοποιήσει, πατήστε <<Απενεργοποίηση σύνθετης λειτουργίας>>. \n \n"
            + "Σε περίπτωση που θέλετε να επιστρέψετε στην αρχική οθόνη χωρίς κάποια επιπλέον αλλαγή πατήστε <<Πήγαινε με πίσω>>"
            + "· \n";

    /**
     * Default constructor.
     */
    public ExtraFunctionsMenu( final int temp ) {
        setBackground( Color.WHITE );
        setIconImage( Toolkit.getDefaultToolkit().getImage( Singleton.getInstance().getFrameIcon() ) );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        setBounds( 100, 100, Singleton.getInstance().getWindowSizeWidth(), Singleton.getInstance().getWindowSizeHeight() );
        this.contentPane = new JPanel();
        this.contentPane.setBackground( Color.WHITE );
        this.contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        setContentPane( this.contentPane );
        this.contentPane.setLayout( null );

        final JLabel mainLabel1 = new JLabel(
                "\u039C\u03C0\u03BF\u03C1\u03B5\u03AF\u03C4\u03B5 \u03BD\u03B1 \u03B5\u03C0\u03B9\u03BB\u03AD\u03BE\u03B5\u03C4\u03B5 \u03BC\u03AF\u03B1 \u03B1\u03C0\u03CC \u03C4\u03B9\u03C2" );
        mainLabel1.setFont( new Font( "Arial", Font.PLAIN, 30 ) );
        mainLabel1.setBounds( 162, 35, 491, 51 );
        this.contentPane.add( mainLabel1 );

        final JLabel mainLabel2 = new JLabel(
                "\u03C0\u03B1\u03C1\u03B1\u03BA\u03AC\u03C4\u03C9 \u03B4\u03B9\u03B1\u03B8\u03AD\u03C3\u03B9\u03BC\u03B5\u03C2 \u03BB\u03B5\u03B9\u03C4\u03BF\u03C5\u03C1\u03B3\u03AF\u03B5\u03C2" );
        mainLabel2.setFont( new Font( "Arial", Font.PLAIN, 30 ) );
        mainLabel2.setBounds( 162, 81, 456, 58 );
        this.contentPane.add( mainLabel2 );

        final JButton inverterMode = new JButton(
                "\u039B\u03B5\u03B9\u03C4\u03BF\u03C5\u03C1\u03B3\u03AF\u03B1 \u03B1\u03C6\u03CD\u03B3\u03C1\u03B1\u03BD\u03C3\u03B7\u03C2" );
        inverterMode.setBackground( Color.WHITE );
        inverterMode.setFont( new Font( "Arial", Font.PLAIN, 25 ) );
        inverterMode.setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ) );
        inverterMode.setFocusPainted( false );
        inverterMode.setBounds( 31, 211, 332, 65 );
        inverterMode.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                if ( Singleton.getInstance().getState().toString().equals( "START" ) ) {
                    // Do not let switch into swing mode
                    JOptionPane.showMessageDialog( null,
                            "Βρίσκεστε σε κατάσταση αναμονής λειτουργίας, και για να επιλέξετε την συγκεκριμένη επιλογή πρέπει πρώτα να εισέρθετε σε κατάσταση θέρμανσης ή ψύξης.",
                            "Μενού σύνθετων επιλογών", 1 );
                }
                else {
                    // Switch into inverter mode
                    Singleton.getInstance().setExtraState( ExtraState.INVERTER );
                    final ExtraFunctionalityAlert alert = new ExtraFunctionalityAlert( ExtraState.INVERTER );
                    ExtraFunctionsMenu.this.dispose();
                    alert.setVisible( true );
                    new java.util.Timer().schedule( new java.util.TimerTask() {
                        @Override
                        public void run() {
                            alert.dispose();
                            final MainMenu menu = new MainMenu( temp );
                            menu.setVisible( true );
                        }
                    }, 3000 );
                }
            }
        } );
        this.contentPane.add( inverterMode );

        final JButton turboMode = new JButton( "\u039B\u03B5\u03B9\u03C4\u03BF\u03C5\u03C1\u03B3\u03AF\u03B1 TURBO" );
        turboMode.setBackground( Color.WHITE );
        turboMode.setFont( new Font( "Arial", Font.PLAIN, 25 ) );
        turboMode.setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ) );
        turboMode.setFocusPainted( false );
        turboMode.setBounds( 31, 313, 332, 65 );
        turboMode.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                if ( Singleton.getInstance().getState().toString().equals( "START" ) ) {
                    // Do not let switch into swing mode
                    JOptionPane.showMessageDialog( null,
                            "Βρίσκεστε σε κατάσταση αναμονής λειτουργίας, και για να επιλέξετε την συγκεκριμένη επιλογή πρέπει πρώτα να εισέρθετε σε κατάσταση θέρμανσης ή ψύξης.",
                            "Μενού σύνθετων επιλογών", 1 );
                }
                else {
                    // Switch into turbo mode
                    Singleton.getInstance().setExtraState( ExtraState.TURBO );
                    final ExtraFunctionalityAlert alert = new ExtraFunctionalityAlert( ExtraState.TURBO );
                    ExtraFunctionsMenu.this.dispose();
                    alert.setVisible( true );
                    new java.util.Timer().schedule( new java.util.TimerTask() {
                        @Override
                        public void run() {
                            alert.dispose();
                            final MainMenu menu = new MainMenu( temp );
                            menu.setVisible( true );
                        }
                    }, 3000 );
                }
            }
        } );
        this.contentPane.add( turboMode );

        final JButton economyMode = new JButton(
                "\u039B\u03B5\u03B9\u03C4\u03BF\u03C5\u03C1\u03B3\u03AF\u03B1 \u03BF\u03B9\u03BA\u03BF\u03BD\u03BF\u03BC\u03AF\u03B1\u03C2" );
        economyMode.setBackground( Color.WHITE );
        economyMode.setFont( new Font( "Arial", Font.PLAIN, 25 ) );
        economyMode.setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ) );
        economyMode.setFocusPainted( false );
        economyMode.setBounds( 450, 211, 332, 65 );
        economyMode.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                if ( Singleton.getInstance().getState().toString().equals( "START" ) ) {
                    // Do not let switch into swing mode
                    JOptionPane.showMessageDialog( null,
                            "Βρίσκεστε σε κατάσταση αναμονής λειτουργίας, και για να επιλέξετε την συγκεκριμένη επιλογή πρέπει πρώτα να εισέρθετε σε κατάσταση θέρμανσης ή ψύξης.",
                            "Μενού σύνθετων επιλογών", 1 );
                }
                else {
                    // Switch into economy mode
                    Singleton.getInstance().setExtraState( ExtraState.ECONOMY );
                    final ExtraFunctionalityAlert alert = new ExtraFunctionalityAlert( ExtraState.ECONOMY );
                    ExtraFunctionsMenu.this.dispose();
                    alert.setVisible( true );
                    new java.util.Timer().schedule( new java.util.TimerTask() {
                        @Override
                        public void run() {
                            alert.dispose();
                            final MainMenu menu = new MainMenu( temp );
                            menu.setVisible( true );
                        }
                    }, 3000 );
                }
            }
        } );
        this.contentPane.add( economyMode );

        final JButton goBackButton = new JButton( "\u03A0\u03AE\u03B3\u03B1\u03B9\u03BD\u03B5 \u03BC\u03B5 \u03C0\u03AF\u03C3\u03C9" );
        goBackButton.setBackground( Color.WHITE );
        goBackButton.setFont( new Font( "Arial", Font.PLAIN, 25 ) );
        goBackButton.setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ) );
        goBackButton.setFocusPainted( false );
        goBackButton.setBounds( 31, 533, 332, 65 );
        goBackButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                final MainMenu menu = new MainMenu( temp );
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
                JOptionPane.showMessageDialog( null, ExtraFunctionsMenu.HELP_MESSAGE, "Μενού βοήθειας σύνθετων επιλογών", 1 );
            }
        } );
        this.contentPane.add( this.needHelpButton );

        final JLabel needHelpLabel = new JLabel( "\u0398\u03AD\u03BB\u03C9 \u03B2\u03BF\u03AE\u03B8\u03B5\u03B9\u03B1" );
        needHelpLabel.setFont( new Font( "Arial", Font.PLAIN, 25 ) );
        needHelpLabel.setBounds( 524, 553, 203, 43 );
        this.contentPane.add( needHelpLabel );

        final JButton swingMode = new JButton(
                "\u039B\u03B5\u03B9\u03C4\u03BF\u03C5\u03C1\u03B3\u03AF\u03B1 \u03C0\u03B5\u03C1\u03B9\u03C3\u03C4\u03C1\u03BF\u03C6\u03AE\u03C2" );
        swingMode.setFont( new Font( "Arial", Font.PLAIN, 25 ) );
        swingMode.setFocusPainted( false );
        swingMode.setBackground( Color.WHITE );
        swingMode.setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ) );
        swingMode.setBounds( 450, 313, 332, 65 );
        swingMode.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                if ( Singleton.getInstance().getState().toString().equals( "START" ) ) {
                    // Do not let switch into swing mode
                    JOptionPane.showMessageDialog( null,
                            "Βρίσκεστε σε κατάσταση αναμονής λειτουργίας, και για να επιλέξετε την συγκεκριμένη επιλογή πρέπει πρώτα να εισέρθετε σε κατάσταση θέρμανσης ή ψύξης.",
                            "Μενού σύνθετων λειτουργιών", 1 );
                }
                else {
                    // Switch into swing mode
                    Singleton.getInstance().setExtraState( ExtraState.SWING );
                    final ExtraFunctionalityAlert alert = new ExtraFunctionalityAlert( ExtraState.SWING );
                    ExtraFunctionsMenu.this.dispose();
                    alert.setVisible( true );
                    new java.util.Timer().schedule( new java.util.TimerTask() {
                        @Override
                        public void run() {
                            alert.dispose();
                            final MainMenu menu = new MainMenu( temp );
                            menu.setVisible( true );
                        }
                    }, 3000 );
                }
            }
        } );
        this.contentPane.add( swingMode );

        final JButton disconnectExtraFunction = new JButton(
                "\u0391\u03C0\u03B5\u03BD\u03B5\u03C1\u03B3\u03BF\u03C0\u03BF\u03AF\u03B7\u03C3\u03B7 \u03C3\u03CD\u03BD\u03B8\u03B5\u03C4\u03B7\u03C2 \u03BB\u03B5\u03B9\u03C4\u03BF\u03C5\u03C1\u03B3\u03AF\u03B1\u03C2" );
        disconnectExtraFunction.setFont( new Font( "Arial", Font.PLAIN, 25 ) );
        disconnectExtraFunction.setFocusPainted( false );
        disconnectExtraFunction.setBackground( Color.WHITE );
        disconnectExtraFunction.setBounds( 175, 423, 478, 65 );
        disconnectExtraFunction.setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ) );
        disconnectExtraFunction.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                if ( Singleton.getInstance().getExtraState().toString().equals( "START" ) ) {
                    JOptionPane.showMessageDialog( null, "Δεν έχετε ενεργοποιήσει κάποια επιπλέον λειτουργία!",
                            "Μενού πρόσθετων επιλογών", 1 );
                }
                else {
                    Singleton.getInstance().setExtraState( ExtraState.START );
                    JOptionPane.showMessageDialog( null, "Έχετε απενεργοποιήσει τις επιπλέον λειτουργίες επιτυχώς!",
                            "Μενού πρόσθετων επιλογών", 1 );
                }
            }
        } );
        this.contentPane.add( disconnectExtraFunction );
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
