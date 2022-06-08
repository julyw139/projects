package thequest;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * Make a button
 */
public class Button
{
    /**
     * The width of button
     */
    private int w;
    
    /**
     * The height of button
     */
    private int h;
    
    /**
     * X-coordinate of start point of button
     */
    private int x;
    
    /**
     * Y-coordinate of start point of button
     */
    private final int y;
    
    /**
     * Color of Button
     */
    private Color c;
    
    /**
     * Constructor of Button
     * 
     * @param x x-coordinate of Button
     * @param y y-coordinate of Button
     * @param w width of Button
     * @param h height of Button
     * @param c color of Button
     */
    public Button(int x, int y, int w, int h, Color c)
    {
       this.x=x;
       this.y=y;
       this.w=w;
       this.h=h;
       this.c=c;
    }

    /**
     *Display white text on Button
     * @param g Graphics
     * @param s text to be displayed
     * @param f font
     */
    public void type(Graphics g, String s, Font f)
    {
        g.setColor(Color.WHITE);
        g.setFont(f);
        g.drawString(s,x+w/4,y+h*2/3);
    }
    
    public void drawSelf(Graphics g)
    {
        g.setColor(c);
        g.fillRect(x, y, w, h);
    }
    
    /**
     *Returns the x-coordinate of the starting point of Button
     * @return x
     */
    public int getX()
    {
        return x;
    }
    
    /**
     *
     * @return the y-coordinate of the starting point of Button
     */
    public int getY()
    {
        return y;
    }
    
    /**
     *
     * @return the width of Button
     */
    public int getWidth()
    {
        return w;
    }
    
    /**
     *
     * @return the height of Button
     */
    public int getHeight()
    {
        return h;
    }
    

}
