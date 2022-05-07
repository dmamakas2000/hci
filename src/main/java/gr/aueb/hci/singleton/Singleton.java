package gr.aueb.hci.singleton;

import lombok.Getter;
import lombok.Setter;

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

    public enum State {
        COOL, HEAT, START
    }

    private State state = State.START;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if ( Singleton.instance == null ) {
            Singleton.instance = new Singleton();
        }
        return Singleton.instance;
    }
}
