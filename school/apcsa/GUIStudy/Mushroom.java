package TheQuest;

import java.awt.Graphics;
import java.awt.Color;



public class Mushroom
{
    
    private int x;
    private int y;
    private int vX;
    private int vY;
    private int diam;
    private Color col;
    private final int gravity=1;
    private int maxSpeed = 5;
    
    public Mushroom(int xCoor, int yCoor, int d, Color c)
    {
        x=xCoor;
        y=yCoor;
        diam=d;
        col=c;
        vX=8;
        vY=0;
    }
    public String toString()
    {
        String s="The diameter of this bubble is "+diam+"\n"+
                 "The color is "+col+"\n";
        return s;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public int getDiam()
    {
        return diam;
    }
    private double distance(int x1, int y1, int x2, int y2)
    {
        double dist=Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
        return dist;
    }
    public int getCenterX()
    {
        int centerX=x+diam/2;
        return centerX;
    }
    public int getCenterY()
    {
        int centerY=y+diam/2;
        return centerY;
    }
    public void act(int w, int h)
    {
        //updating x and y
        x+=vX;
        
        vY+=gravity;
        if(vY>maxSpeed)
        {
            vY=maxSpeed;
        }
        y=y+vY;
        //get the next x and y coordinates
        int nextX=x+vX;
        int nextY=y+vY;
        
        //if-statements to handle the Bubble bouncing off of the 4 walls
        if (nextX+diam>w||nextX<0) 
        {
            x+=vX;
            vX*=-1;
        }
        if (nextY+diam>h||nextY<0) 
        {
            y+=vY;
            vY*=-1;
        }
        
        
    }
    public void drawSelf(Graphics g)    
    {
        g.setColor(col);
        g.fillOval(x, y, diam, diam);
    }
    public void handleCollision(Mushroom that)
    {
        //Getting the center of this Bubble and that Bubble
        int xC1=this.getCenterX();
        int yC1=this.getCenterY();
        int xC2=that.getCenterX();
        int yC2=that.getCenterY();
        
        //getting the radius of this Bubble and that Bubble
        int rad1=this.getDiam()/2;
        int rad2=that.getDiam()/2;
        
        //checking if this Bubble Collided with this Bubble
        double dist = distance(xC1,yC1,xC2,yC2);
        if(dist<=rad1+rad2)
        {
            /*this.vX*=-1;
            x+=vX;
            this.vY*=-1;
            y+=vY;*/
            //calculating the velocities of this Bubble after colliding with anotherBubble
            vX = xC1-xC2;
            vY = yC1-yC2;
            
            //Slowing down the velocities.  otherwise they go crazy
            //int maxSpeed = 5;
            
            if(vX<=-maxSpeed)
                vX = -maxSpeed;
            else if(vX>=maxSpeed)
                vX = maxSpeed;
            
            if(vY <= -maxSpeed)
                vY = -maxSpeed;
            else if(vY >= maxSpeed)
                vY = maxSpeed;

        }
    }
}
