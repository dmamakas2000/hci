package gr.aueb.hci.components;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

public class RoundedButton implements Border {

    private int r;

    public RoundedButton( final int r ) {
        this.r = r;
    }

    @Override
    public Insets getBorderInsets( final Component c ) {
        return new Insets( this.r + 1, this.r + 1, this.r + 2, this.r );
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }

    @Override
    public void paintBorder( final Component c, final Graphics g, final int x, final int y, final int width, final int height ) {
        g.drawRoundRect( x, y, width - 1, height - 1, this.r, this.r );
    }
}
