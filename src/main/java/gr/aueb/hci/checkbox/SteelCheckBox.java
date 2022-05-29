package gr.aueb.hci.checkbox;

import javax.swing.JCheckBox;

public class SteelCheckBox extends JCheckBox {

    private boolean colored = false;
    private boolean rised = false;
    private ColorDef selectedColor = ColorDef.JUG_GREEN;
    protected static final String COLORED_PROPERTY = "colored";
    protected static final String COLOR_PROPERTY = "color";
    protected static final String RISED_PROPERTY = "rised";

    public SteelCheckBox() {
        super();
        setPreferredSize( new java.awt.Dimension( 100, 26 ) );
    }

    public boolean isColored() {
        return this.colored;
    }

    public void setColored( final boolean COLORED ) {
        final boolean OLD_STATE = this.colored;
        this.colored = COLORED;
        firePropertyChange( SteelCheckBox.COLORED_PROPERTY, OLD_STATE, COLORED );
        repaint();
    }

    public boolean isRised() {
        return this.rised;
    }

    public void setRised( final boolean RISED ) {
        final boolean OLD_VALUE = this.rised;
        this.rised = RISED;
        firePropertyChange( SteelCheckBox.RISED_PROPERTY, OLD_VALUE, RISED );
    }

    public ColorDef getSelectedColor() {
        return this.selectedColor;
    }

    public void setSelectedColor( final ColorDef SELECTED_COLOR ) {
        final ColorDef OLD_COLOR = this.selectedColor;
        this.selectedColor = SELECTED_COLOR;
        firePropertyChange( SteelCheckBox.COLOR_PROPERTY, OLD_COLOR, SELECTED_COLOR );
        repaint();
    }

    @Override
    public void setUI( final javax.swing.plaf.ButtonUI BUI ) {
        super.setUI( new SteelCheckBoxUI( this ) );
    }

    public void setUi( final javax.swing.plaf.ComponentUI UI ) {
        this.ui = new SteelCheckBoxUI( this );
    }

    @Override
    protected void setUI( final javax.swing.plaf.ComponentUI UI ) {
        super.setUI( new SteelCheckBoxUI( this ) );
    }

    @Override
    public String toString() {
        return "SteelCheckBox";
    }
}
