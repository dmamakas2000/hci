package gr.aueb.hci.menu;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class TestPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = -3486180005084278822L;

    @Override
    protected void paintComponent( final Graphics g ) {
        super.paintComponent( g );
        final Graphics2D g2d = ( Graphics2D ) g;
        g2d.setRenderingHint( RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY );
        final int w = getWidth(), h = getHeight();
        final Color color1 = new Color( 255, 255, 255 );
        final Color color2 = new Color( 171, 222, 237 );
        final GradientPaint gp = new GradientPaint( 0, 0, color1, w, h, color2 );
        g2d.setPaint( gp );
        g2d.fillRect( 0, 0, w, h );
    }

}
