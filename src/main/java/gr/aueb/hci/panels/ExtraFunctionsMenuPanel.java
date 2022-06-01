package gr.aueb.hci.panels;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

/**
 * Panel used on {@code gr.aueb.hci.menu.ExtraFunctionsMenu.java} in order to create gradient.
 *
 */
public class ExtraFunctionsMenuPanel extends JPanel {

    /**
     * Generated serial version UID.
     */
    private static final long serialVersionUID = -1813449087016414410L;

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
        final Color color2 = new Color( 247, 243, 230 );
        final GradientPaint gp = new GradientPaint( 2, 345, color1, w, h, color2 );
        g2d.setPaint( gp );
        g2d.fillRect( 0, 0, w, h );
    }
}
