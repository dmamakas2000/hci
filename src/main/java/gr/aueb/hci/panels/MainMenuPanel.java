package gr.aueb.hci.panels;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import gr.aueb.hci.singleton.Singleton.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Panel used on {@code gr.aueb.hci.menu.MainMenu.java} in order to create gradient.
 *
 */
@AllArgsConstructor
@Getter
@Setter
public class MainMenuPanel extends JPanel {

    /**
     * Generated serial version UID.
     */
    private static final long serialVersionUID = 3552956647717203346L;

    /**
     * Color changing depending on the state.
     */
    private State state;

    /**
     * Paints the panel using gradient.
     */
    @Override
    protected void paintComponent( final Graphics g ) {
        super.paintComponent( g );
        final Graphics2D g2d = ( Graphics2D ) g;
        g2d.setRenderingHint( RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY );
        final int w = getWidth(), h = getHeight();

        final Color color1 = new Color( 255, 255, 255 );

        final Color color2 = new Color( 232, 206, 121 ); // Heat
        final Color color3 = new Color( 212, 242, 255 ); // Cool

        if ( this.state.equals( State.HEAT ) ) {
            final GradientPaint gp = new GradientPaint( 0, 0, color1, w, h, color2 );
            g2d.setPaint( gp );
            g2d.fillRect( 0, 0, w, h );
        }
        else if ( this.state.equals( State.COOL ) ) {
            final GradientPaint gp = new GradientPaint( 0, 0, color1, w, h, color3 );
            g2d.setPaint( gp );
            g2d.fillRect( 0, 0, w, h );
        }
        else {
            final GradientPaint gp = new GradientPaint( 0, 0, color1, w, h, color1 );
            g2d.setPaint( gp );
            g2d.fillRect( 0, 0, w, h );
        }
    }
}
