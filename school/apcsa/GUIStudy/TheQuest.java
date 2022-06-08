//package thequest;
//
//import TheQuest.Mushroom;
//import java.awt.Color;
//import java.util.ArrayList;
//import java.awt.Dimension;
//import java.awt.Graphics;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseMotionListener;
//import javax.swing.JComponent;
//import javax.swing.JFrame;
//import java.awt.Font;
////imports for drawing Images
//import java.awt.Graphics2D;
//import java.awt.Image;
//import javax.swing.ImageIcon;
//
//public class TheQuest extends JComponent implements KeyListener, MouseListener, MouseMotionListener {
//    
//    
//   //instance variables
//    private int WIDTH;
//    private int HEIGHT;
//    private int level;
//    private ArrayList<Mushroom>mushrooms;
//    Font tnr;
//    private int mX;
//    private int mY;
//    
//    //Default Constructor
//    public TheQuest()
//    {
//        this.tnr = new Font("Times New Roman", Font.PLAIN, 25);
//        //initializing instance variables
//        WIDTH = 1200;
//        HEIGHT = 800;
//        level=1;
//        mushrooms = new ArrayList<Mushroom>();
//        mX=(int)Math.random()*1000;
//        mY=(int)Math.random()*1000;
//        
//       //Setting up the GUI
//        JFrame gui=new JFrame();//makes the gui box
//        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//program can close
//        gui.setTitle("The Quest");//TitleOfTheGame
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
//
//    }
//    //This method will acknowledge user input
//    public void keyPressed(KeyEvent e) 
//    {
//        
//
//    }   
//    //All your UI drawing goes in here
//    public void paintComponent(Graphics g)
//    {
//        // new graphics2D object
//        Graphics2D g2d= (Graphics2D)g;
//        //Drawing a Nice Rectangle to be the background
//        
//        
//        if (level==1)
//        {
//            Color muted=new Color(131,173,181);
//            g.setColor(muted);
//            g.fillRect(0,0,WIDTH,HEIGHT);
//            
//            //draw mushrooms
//            for (int i=0; i<mushrooms.size();i++)
//            {
//           
//                mushrooms.get(i).drawSelf(g);
//            
//            }
//        }
//        
//        
//        
//
//    }
//    public void loop()
//    {   
//        if(level==1)
//        {
//            //new mushroom
//            for (int t = 0; t < 5; t++) 
//            {
//                Mushroom bub1 = new Mushroom(mX, mY, 75, Color.MAGENTA);
//                mushrooms.add(bub1);
//            }
//
//            //mushroom collision
//            for (int m = 0; m < mushrooms.size(); m++) 
//            {
//                for (int n = m + 1; n < mushrooms.size(); n++) 
//                {
//                    mushrooms.get(m).handleCollision(mushrooms.get(n));
//                    mushrooms.get(n).handleCollision(mushrooms.get(m));
//                }
//            }
//            
//            //move mushroom
//            for (int i = 0; i < mushrooms.size(); i++) 
//            {
//                mushrooms.get(i).act(WIDTH, HEIGHT);
//            }
//            
//        }
//        //changeLevel();
//        //Do not write below this
//        repaint();
//    }
//    
//    public void changeLevel()
//    {
//        
//    }
//    //These methods are required by the compiler.  
//    //You might write code in these methods depending on your goal.
//    public void keyTyped(KeyEvent e) 
//    {
//    }
//    public void keyReleased(KeyEvent e) 
//    {
//    }
//    public void mousePressed(MouseEvent e)
//    {
//    }
//    public void mouseReleased(MouseEvent e)
//    {
//    }
//    public void mouseClicked(MouseEvent e)
//    {
//    }
//    public void mouseEntered(MouseEvent e)
//    {
//    }
//    public void mouseExited(MouseEvent e)
//    {
//    }
//    public void mouseMoved(MouseEvent e)
//    {
//    }
//    public void mouseDragged(MouseEvent e)
//    {
//    }
//    public void start(final int ticks){
//        Thread gameThread = new Thread(){
//            public void run(){
//                while(true){
//                    loop();
//                    try{
//                        Thread.sleep(1000 / ticks);
//                    }catch(Exception e){
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };	
//        gameThread.start();
//    }
//
//    public static void main(String[] args)
//    {
//        TheQuest q = new TheQuest();
//        q.start(60);
////        if (q.level==1)
////        {
////            Field f = new Field();
////            f.start(60);
////        }
////        else if(q.level==2)
////        {
////            Battle.test();
////        }
//    }
//}
