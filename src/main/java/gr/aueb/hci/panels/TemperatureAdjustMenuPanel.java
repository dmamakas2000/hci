package gr.aueb.hci.panels;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import gr.aueb.hci.singleton.Singleton;
import gr.aueb.hci.singleton.Singleton.State;

/**
 * Panel used on {@code gr.aueb.hci.menu.TemperatureAdjustMenu.java} in order to create gradient.
 *
 */
public class TemperatureAdjustMenuPanel extends JPanel {

    /**
     * Generated serial version UID.
     */
    private static final long serialVersionUID = -3486180005084278822L;

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
        Color color2 = new Color( 255, 255, 255 );
        if ( Singleton.getInstance().getState().equals( State.HEAT ) ) {
            color2 = new Color( 232, 206, 121 );
        }
        else if ( Singleton.getInstance().getState().equals( State.COOL ) ) {
            color2 = new Color( 171, 222, 237 );
        }
        final GradientPaint gp = new GradientPaint( 0, 0, color1, w, h, color2 );
        g2d.setPaint( gp );
        g2d.fillRect( 0, 0, w, h );
    }
}
