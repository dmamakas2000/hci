package gr.aueb.hci.singleton;

import lombok.Getter;
import lombok.Setter;

/**
 * Singleton class containing basic settings used among all frames.
 *
 */
@Getter
@Setter
public final class Singleton {
    private static Singleton instance;

    /**
     * Window size.
     */
    private final int windowSizeWidth = 806;
    private final int windowSizeHeight = 660;

    /**
     * Main font.
     */
    private final String font = "Arial";

    /**
     * Frame icon.
     */
    private final String frameIcon = "assets/images/window/hermes.png";

    /**
     * Wing degree.
     */
    private int wingDegree = 45;

    /**
     * Main states.
     *
     */
    public enum State {
        COOL, HEAT, START
    }

    /**
     * Extra function states.
     *
     */
    public enum ExtraState {
        ECONOMY, INVERTER, SWING, TURBO, START
    }

    /**
     * Current states.
     */
    private State state = State.START;
    private ExtraState extraState = ExtraState.START;

    /**
     * Default constructor.
     */
    private Singleton() {
    }

    /**
     * Gets unique Singleton's instance.
     *
     * @return Singleton instance.
     */
    public static Singleton getInstance() {
        if ( Singleton.instance == null ) {
            Singleton.instance = new Singleton();
        }
        return Singleton.instance;
    }
}
