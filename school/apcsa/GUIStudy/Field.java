package TheQuest;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Font;

public class Field extends JComponent implements KeyListener, MouseListener, MouseMotionListener{
    //instance variables
    private int WIDTH;
    private int HEIGHT;
//    private int rX;
//    private int rY;
//    private int rW;
//    private int rH;
    private int cX;
    private int cY;
    private int diam;
    private int cVx;
    private int cVy;
    private ArrayList<Mushroom>mushrooms;
    private int mX;
    private int mY;
    //Bubble bub=new Bubble(100,100,50,Color.RED);
//    Mushroom[] bubs = createBubs((int)Math.random()*10);
    
    //Default Constructor
    public Field()
    {
        //initializing instance variables
        
        mushrooms=new ArrayList<Mushroom>();
        WIDTH = 1000;
        HEIGHT = 500;
//        rX=300;
//        rY=300;
//        rW=50;
//        rH=100;
        cX=500;
        cY=300;
        cVx=5;
        cVy=5;
        diam=70;
        mX=(int)Math.random()*1000;
        mY=(int)Math.random()*1000;
        
        
//        //Setting up the GUI
//        JFrame gui=new JFrame();//makes the gui box
//        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//program can close
//        gui.setTitle("LearnGraphics");//TitleOfTheGame
//        gui.setPreferredSize(new Dimension(WIDTH+5,HEIGHT+30));//Setting the Size
//        gui.setResizable(false);
//        gui.getContentPane().add(this);//AddThisClassToTheGUI
//        
//        //DeclareButtonsHere
//        
//        gui.pack();//PacksThingsTogether
//        gui.setLocationRelativeTo(null);//OpensInCenter
//        gui.setVisible(true);//Visible
//        gui.addKeyListener(this);//ObjectListensToKeyboard
//        gui.addMouseListener(this);//ObjectListensToMouse
//        gui.addMouseMotionListener(this);//AcknowledgesMouseMovement
        

    }
    
    //Initialize an array of Bubbles
//    public Mushroom[] createBubs(int n)
//    {
//        Mushroom[] mBub=new Mushroom[n];
//        for (int i=0; i<mBub.length; i++) 
//        {
//            double d =100*Math.random();
//            int r=(int)d;
//            mBub[i] =new Mushroom(r+200,r+100,r,Color.BLUE);
//            
//        }
//        return mBub;
//        
//    }
    
    //getArrayBubbleLength
    public int getLength(Mushroom[] bubs)
    {
       int l=bubs.length;
       return l;
    }

    //This method will acknowledge user input
    public void keyPressed(KeyEvent e) 
    {
        //getting the key pressed
        int key=e.getKeyCode();
        //System.out.println(key);
        //moving the rectangle
//        if (key==38) rY-=10;
//        if (key==40) rY+=10;
//        if (key==37) rX-=10;
//        if (key==39) rX+=10;
    }   
    //All your UI drawing goes in here
    public void paintComponent(Graphics g)
    {
        //Drawing a nice rectangle to be the background
        Color muted=new Color(131,173,181);
        g.setColor(muted);
        g.fillRect(0,0,WIDTH,HEIGHT);
        
        //Drawing Hello World!! at the center of the GUI
//        Font font = new Font("Times New Roman", Font.PLAIN, 50);
//        g.setFont(font);
//        g.setColor(Color.BLACK);
//        g.drawString("Hello,world!", WIDTH/2, HEIGHT/2);
        
        //Drawing the user-controlled rectangle
//        g.setColor(Color.RED);
//        g.fillRect(rX, rY, rW, rH);
        
        //Drawing the autonomous circle
//        g.setColor(Color.YELLOW);
//        g.fillOval(cX, cY, diam, diam);
        
        //DrawTheBubble
//        bub.drawSelf(g);
        //bubs[2].drawSelf(g);
        
        
        for (int i=0; i<mushrooms.size();i++)
       {
           
           mushrooms.get(i).drawSelf(g);
            
       }
//        for (int i=0; i<bubs.length;i++)
//       {
//           
//           bubs[i].drawSelf(g);
//            
//       }

    }
    public void loop()
    {
        //making the autonomous circle move
        cX+=cVx;
        cY+=cVy;
        
        //handling when the circle collides with the edges
        int nextX;
        int nextY;
        nextX=cX+cVx;
        nextY=cY+cVy;
        if((nextY+diam)>HEIGHT||cY<0) cVy*=(-1);
        if((nextX+diam)>WIDTH||cX<0)  cVx*=(-1);
        
        //handling the collision of the circle with the rectangle
        if(detectCollision()==true)
        {
            cVx*=-1;
            cVy*=-1;
        }
        
        //bubble collisions
        for (int m=0; m<mushrooms.size();m++)
       {
           for(int n=m+1;n<mushrooms.size();n++)
           {
               mushrooms.get(m).handleCollision(mushrooms.get(n));
               mushrooms.get(n).handleCollision(mushrooms.get(m));
           }
       }
        
        //movingBubble
//        bub.act(WIDTH,HEIGHT);
        //bubs[2].act(WIDTH, HEIGHT);
        
        //moving bubbles
         for (int i=0; i<mushrooms.size();i++)
       {
           mushrooms.get(i).act(WIDTH, HEIGHT);
       }
        for(int t=(int)Math.random()*100/5; t<(int)Math.random()*100/3; t++)
        {
           Mushroom bub1=new Mushroom(mX,mY,75,Color.MAGENTA);
           mushrooms.add(bub1); 
        }
        //Do not write below this
        repaint();
    }
    //These methods are required by the compiler.  
    //You might write code in these methods depending on your goal.
    public void keyTyped(KeyEvent e) 
    {
    }
    public void keyReleased(KeyEvent e) 
    {
    }
    public void mousePressed(MouseEvent e)
    {
    }
    public void mouseReleased(MouseEvent e)
    {
    }
    public void mouseClicked(MouseEvent e)
    {
        int x=e.getX();
        int y=e.getY();
//        Bubble bub1=new Bubble(x,y,75,Color.MAGENTA);
//        bubbles.add(bub1);
    }
    public void mouseEntered(MouseEvent e)
    {
    }
    public void mouseExited(MouseEvent e)
    {
    }
    public void mouseMoved(MouseEvent e)
    {
    }
    public void mouseDragged(MouseEvent e)
    {
    }
    public double distance(int x1, int y1, int x2, int y2)
    {
        double dist=Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
        return dist;
    }
    
    public boolean detectCollision()
    {
        boolean output=false;
        int radius;
        int centerX;
        int centerY;
        int nextX;
        int nextY;
        nextX=cX+cVx;
        nextY=cY+cVy;
        radius=diam/2;
        centerX = (2*nextX + diam)/2;
        centerY = (2*nextY + diam)/2;
//        for(int x=rX; x<+rX+rW; x++)
//        {
//            for(int y=rY; y<rY+rH; y++)
//            {
//              if (distance(x,y,centerX,centerY)==radius) output=true;
//            }
//        }
        
        return output;
    }
    
    public void start(final int ticks){
        Thread gameThread = new Thread(){
            public void run(){
                while(true){
                    loop();
                    try{
                        Thread.sleep(1000 / ticks);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        };	
        gameThread.start();
    }

//    public static void main(String[] args)
//    {
//        Field g = new Field();
//        g.start(60);
//    }
}

