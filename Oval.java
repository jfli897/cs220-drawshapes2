package knox.drawshapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

//feature 1 creates a new shape
public class Oval extends AbstractShape
{
    private int diameter;
    
    public Oval(Color color, Point center, int diameter) {
    	super(center, color);
        boundingBox = new BoundingBox(center.x - diameter/2, center.x + diameter/2, center.y - diameter/2, center.y + diameter/2);
        this.diameter = diameter;
    }

    @Override
    public void draw(Graphics g) {
        if (isSelected()){
            g.setColor(getColor().darker());
        } else {
            g.setColor(getColor());
        }
        Random rand = new Random();
        rand.nextDouble();
      
        g.fillOval((int)getAnchorPoint().getX() - diameter/2,
                (int)getAnchorPoint().getY() - diameter/2,
                diameter,
                (int) (diameter*(rand.nextDouble()+1)));
    }
    
    public String toString() {
        return String.format("Oval %d %d %d %s %s", 
                this.getAnchorPoint().x, 
                this.getAnchorPoint().y,
                this.diameter,
                Util.colorToString(this.getColor()),
                this.isSelected());
    }

	@Override
	public void scale(double factor) {
		this.diameter = (int)(factor * this.diameter);
	}

}

