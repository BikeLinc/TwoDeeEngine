package components;

import java.awt.Color;
import java.awt.Dimension;

public class SingleColorBlock extends GameObject {
    
    private Dimension dimension = new Dimension(0,0);
    private Color color = new Color(0,0,0);
    
    public SingleColorBlock(int _ID, String _name) {
        super(_ID, _name);
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
}
