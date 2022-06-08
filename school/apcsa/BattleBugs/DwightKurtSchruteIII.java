package BattleBugs;

import java.util.ArrayList;
import info.gridworld.grid.Location;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 * Basic info:
 *  Name: DwightKurtSchruteIII
 *  Species: BattleBug
 *  Date of Entry: May 21, 2021
 *  Date of Graduation: Jun 2, 2021
 *  Mentor: Lihan Wang
 * Honors and Awards:
 *  1. Getting the nearest PowerUp | getFlLocs()
 *  2. Getting to where it wants to go efficiently | getGoTo()
 *  3. Avoiding the rocks | act() + getRockLocs()
 *  4. Getting around obstacles | act()
 *  5. Attack/chase an enemy | act()
 *  6. Running away from an enemy | act()
 *  7. Victory GUI pop up | victory() + gui()
 */
public class DwightKurtSchruteIII extends BattleBug2012
{
    private Location centerLoc;
    private Location goal;
    private int actNum;
    private ArrayList<Location> flLocs;

    public DwightKurtSchruteIII(int s, int d, int sp, String n, Color co, String kS, String vM)
    {
            super(s,d,sp,n,co,kS,vM);
            
            centerLoc = new Location(13,13);
            flLocs = new ArrayList<>();
            goal = centerLoc;
            actNum = 0;
    }
    
    @Override
    public void act()
    {
        //rocks precedes canMove precedes run precedes kill precedes level up
        
        //check if can attack before moving/turning
        if(!getToKill(getEnemies()).equals(this)) //there is something to kill
        {
            Location weakLoc = getToKill(getEnemies()).getLocation();
            boolean sameDir = getDirection() == getDirectionToward(weakLoc);
            boolean inRange;
            double dist = getDist(getLocation(), weakLoc);
            if(getStrength() >= 20)
                inRange = dist == 3 || dist == 3 * sqrt2();
            else if(getStrength() >= 10)
                inRange = dist == 2 || dist == 2 * sqrt2();
            else
                inRange = dist == 1 || dist == 1 * sqrt2();
            
            if (sameDir && inRange)
                attack();
        }
        
        updateGoal();
        
        if(getDirection() != getDirectionToward(getGoTo(goal)))
            turnTo(getDirectionToward(getGoTo(goal)));
        else if(!canMove())
        {
            //use boolean update?
            actNum = getNumAct();
            goal = getMinLoc(goal, getEmptyAdjacentLocations());
            turnTo(getDirectionToward(goal));
        }
        else
            move2();
        
        //check if can attack after moving/turning
        if(!getToKill(getEnemies()).equals(this)) //there is something to kill
        {
            Location weakLoc = getToKill(getEnemies()).getLocation();
            boolean sameDir = getDirection() == getDirectionToward(weakLoc);
            boolean inRange;
            double dist = getDist(getLocation(), weakLoc);
            if(getStrength() >= 20)
                inRange = dist == 3 || dist == 3 * sqrt2();
            else if(getStrength() >= 10)
                inRange = dist == 2 || dist == 2 * sqrt2();
            else
                inRange = dist == 1 || dist == 1 * sqrt2();
            
            if (sameDir && inRange)
                attack();
        }
        //checking twice because what if the enemy moved between the acts
    }
    
    public void updateGoal()
    {
        Location curr = getLocation();
        boolean onAct38 = (getNumAct() + 2) % 40 == 0;
        boolean onAct39 = (getNumAct() + 1) % 40 == 0;
        ArrayList<BattleBug2012> enemies = getEnemies();
        BattleBug2012 strong = getRunFrom(enemies);
        BattleBug2012 weak = getToKill(enemies);
        Location strongLoc = strong.getLocation();
        Location weakLoc = weak.getLocation();
        boolean ignore = false;
        
        if(onAct38 && getMinDist(curr, getRockLocs()) <= 2) //avoid rocks
        {
            //go to the empty adjacent loc that is farthest from rocks
            goal = getMaxLoc(getEmptyAdjacentLocations(), getRockLocs());
        }
        else if(onAct39)
        {
            //do not update goal
            
            //handle rocks when move2()
            if(getMinDist(curr, getRockLocs()) <= 2)
                goal = getMaxLoc(getEmptyAdjacentLocations(), getRockLocs());
        }
        else if(getNumAct() == actNum + 1)
        {
            //do not update goal
            //because 1 turn and 1 move
        }
        else if(!getEnemies().isEmpty())
        {
            if(!strong.equals(this)) //run
            {
                if(strong.getAmmo() == 0)
                    ignore = true;
                else
                    goal = getMaxLoc(strongLoc, getEmptyAdjacentLocations());
            }
            else if(!weak.equals(this)) //chase
            {
                if(this.getAmmo() == 0)
                    ignore = true;
                else
                    goal = getMinLoc(weakLoc, getEmptyAdjacentLocations());
            }
            else //no bug is strong or weak enough
                ignore = true;
            
            if(ignore)
                goal = getFlLoc();
        }
        else
            goal = getFlLoc();
    }
    
    //tested
    public double sqrt2()
    {
        return Math.pow(2, 0.5);
    }
    
    //get the BattleBug it should run from
    //if there are two then there's no helping it
    //we can't run away from 2 bugs at the same time
    public BattleBug2012 getRunFrom(ArrayList<BattleBug2012> bugs)
    {
        for(BattleBug2012 b : bugs)
            if(b.getStrength() >= this.getDefense() + 3)
                return b;
        return this;
    }
    
    //return this as a placeholder
    public BattleBug2012 getToKill(ArrayList<BattleBug2012> bugs)
    {
        for(BattleBug2012 b: bugs)
            if(this.getStrength() >= b.getDefense() + 3)
                return b;
        return this;
    }
    
    //tested
    public ArrayList<BattleBug2012> getEnemies()
    {
        ArrayList enemies = getActors();
        for(int i = enemies.size() - 1; i >= 0; i--)
        {
            boolean isBattleBug2012 = enemies.get(i) instanceof BattleBug2012;
            if(!isBattleBug2012)
                enemies.remove(i);
        }
        return enemies;
    }
    public Location getFlLoc()
    {
        flLocs = getPowerUpLocs();
        return getMinLoc(getLocation(), flLocs);
    }
    public double getMinDist(Location loc, ArrayList<Location> locs)
    {
        return getDist(loc, getMinLoc(loc, locs));
    }
    
    //efficiently get to goal
    public Location getGoTo(Location goal)
    {
        Location curr = getLocation();
        
        //go diagonal first, then straight
        //get the locs on diagonal of curr
        ArrayList<Location> diag = getDiagonal(curr);
        
        //find and store the ones on the same row || col as goal
        ArrayList<Location> posLocs = new ArrayList(); //possibleLocs
        for(Location l : diag)
        {
            if(l.getCol() == goal.getCol() || l.getRow() == goal.getRow())
                posLocs.add(l);
        }
        
        //handle if it's already on row or col
        if(curr.getRow() == goal.getRow() || curr.getCol() == goal.getCol())
            return goal;
        else if(onDiagonal(goal, curr))
            return goal;
        else
            return getMinLoc(goal, posLocs);
    }
    
    //tested
    //returns the innermost perimeter of rocks
    public ArrayList<Location> getRockLocs()
    {
        //+ 1 because we are calling it at Act 38
        //numRockRow will always >= 1
        int numRockRow = getNumAct() / 40 + 1;
        
        ArrayList<Location> rocks1 = new ArrayList<>();
        
        int rNum = this.getGrid().getNumRows();
        int cNum = this.getGrid().getNumCols();
        
        //getting the top and bottom row
        for(int c = numRockRow - 1; c < cNum - (numRockRow - 1); c++)
        {
            rocks1.add(new Location(numRockRow - 1, c));
            rocks1.add(new Location((rNum - 1) - (numRockRow - 1), c));
        }
        
        //getting the first and last col
        for(int r = numRockRow - 1; r < rNum - (numRockRow - 1); r++)
        {
            rocks1.add(new Location(r, numRockRow - 1));
            rocks1.add(new Location(r, cNum - 1 - (numRockRow - 1)));
        }
        
        //doesnt really matter if there are repeated locs
        return removeRepeated(rocks1);
    }
    
    //returns the Location in locs that is nearest to from
    //helper to getGoTo()
    //handy when chasing bugs too
    public Location getMinLoc(Location from, ArrayList<Location> locs)
    {
        if(locs.isEmpty())
            locs.add(centerLoc);
        Location minTo = locs.get(0);
        
        for(Location to : locs)
        {
            if(getDist(from, to) < getDist(from, minTo))
                minTo = to;
        }
        
        return minTo;
    }
    
    //get the location in locs that is farthest from from
    public Location getMaxLoc(Location from, ArrayList<Location> locs)
    {
        //<runFrom.loc, emptyAdjLocs>
        if(locs.isEmpty())
            locs.add(centerLoc);
        Location maxTo = locs.get(0);
        
        for(Location to : locs)
        {
            if(getDist(from, to) > getDist(from, maxTo))
                maxTo = to;
        }
        
        return maxTo;
    }
    
    //get the location in from<> whose minDist to to<> is largest
    public Location getMaxLoc(ArrayList<Location> from, ArrayList<Location> to)
    {
        //from: emptyAdjLocs
        //to: rockLocs
        //<adjLocs, minDistToRockLocs>
        
        if(from.isEmpty())
            from.add(centerLoc); //prevent exceptions
        Location maxDist = from.get(0);
        
        for(Location c : from)
        {
            double dist = getMinDist(c, to);
            if(dist > getMinDist(maxDist, to))
                maxDist = c;
        }
        
        return maxDist;
    }
    
    //tested
    //helper to getDiagonal()
    public boolean isValid(Location c)
    {
        //not out of bounds
        int row = c.getRow();
        int col = c.getCol();
        
        int numRows = getGrid().getNumRows();
        int numCols = getGrid().getNumCols();
        
        return row >= 0 && row < numRows && col >=0 && col < numCols;
    }
    
    //tested
    //helper to getRockLocs()
    public ArrayList<Location> removeRepeated(ArrayList<Location> locs)
    {
        ArrayList<Location> newLocs = new ArrayList();
        for(int i = 0; i < locs.size(); i++)
        {
            //this is fine because there are always rocks
            //i.e. rockLocs is never empty
            if(!newLocs.contains(locs.get(i)))
                newLocs.add(locs.get(i));
        }
        return newLocs;
    }
    
    //tested
    //check if loc is on the diagonal of origin
    public boolean onDiagonal(Location loc, Location origin)
    {
        ArrayList<Location> diagonal = getDiagonal(origin);
        
        return diagonal.contains(loc);
    }
    
    //tested
    public ArrayList<Location> getDiagonal(Location loc)
    {
        ArrayList<Location> line = new ArrayList<>();
        Location adj = loc;
        line.add(adj);
       
       //45
       while(isValid(adj))
       {
           if(!line.contains(adj))
               line.add(adj);
           adj = adj.getAdjacentLocation(45);
       }
       
       //reset adj
       adj = loc;
       
       //225
       while(isValid(adj))
       {
           if(!line.contains(adj))
               line.add(adj);
           adj = adj.getAdjacentLocation(225);
       }
       
       //reset adj
       adj = loc;
       
       //135
       while(isValid(adj))
       {
           if(!line.contains(adj))
               line.add(adj);
           adj = adj.getAdjacentLocation(135);
       }
       
       //reset adj
       adj = loc;
       
       //315
       while(isValid(adj))
       {
           if(!line.contains(adj))
               line.add(adj);
           adj = adj.getAdjacentLocation(315);
       }
       
       return line;
    }
    
    //tested
    public double getDist(Location loc1, Location loc2)
    {
        double row1 = loc1.getRow();
        double row2 = loc2.getRow();
        
        double col1 = loc1.getCol();
        double col2 = loc2.getCol();
        
        double dist = Math.sqrt(Math.pow(row1 - row2, 2) + Math.pow(col1 - col2, 2));
        
        return dist;
    }
    
    @Override
    public String victory()
    {
        //remember this code I found off StackOverflow? ;p
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // handle exception
        }
        
        gui();
                
        return "$$\\   $$\\           $$\\ $$\\                 $$\\      $$\\                     $$\\       $$\\ \n" +
"$$ |  $$ |          $$ |$$ |                $$ | $\\  $$ |                    $$ |      $$ |\n" +
"$$ |  $$ | $$$$$$\\  $$ |$$ | $$$$$$\\        $$ |$$$\\ $$ | $$$$$$\\   $$$$$$\\  $$ | $$$$$$$ |\n" +
"$$$$$$$$ |$$  __$$\\ $$ |$$ |$$  __$$\\       $$ $$ $$\\$$ |$$  __$$\\ $$  __$$\\ $$ |$$  __$$ |\n" +
"$$  __$$ |$$$$$$$$ |$$ |$$ |$$ /  $$ |      $$$$  _$$$$ |$$ /  $$ |$$ |  \\__|$$ |$$ /  $$ |\n" +
"$$ |  $$ |$$   ____|$$ |$$ |$$ |  $$ |      $$$  / \\$$$ |$$ |  $$ |$$ |      $$ |$$ |  $$ |\n" +
"$$ |  $$ |\\$$$$$$$\\ $$ |$$ |\\$$$$$$  |      $$  /   \\$$ |\\$$$$$$  |$$ |      $$ |\\$$$$$$$ |\n" +
"\\__|  \\__| \\_______|\\__|\\__| \\______/       \\__/     \\__| \\______/ \\__|      \\__| \\_______|\n" +
"                                                                                           \n" +
"                                                                                           \n" +
"                                                                                           ";
    }
    
    //make gui pop-up
    //(ooooh fancy anonymous classes *wiggles hands*
    public void gui()
    {
        JFrame f1 = new JFrame();
        JFrame f2 = new JFrame();
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setPreferredSize(new Dimension(500, 500));
        f2.setPreferredSize(new Dimension(600, 600));
        f1.setTitle("This is Dwight");
        f2.setTitle("All Hail The Winner");
        
        JButton button1 = new JButton("Go to next gif");
        JButton button2 = new JButton("Go to previous gif");
        button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(false);
                JOptionPane.showMessageDialog(f2, "Lihan is the best!!");
                f2.setVisible(true);
            }
        });
        button2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(true);
                f2.setVisible(false);
            }
        });
        
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        p1.add(button1, BorderLayout.PAGE_START);
        p2.add(button2, BorderLayout.PAGE_START);
        
        try {
            ImageIcon icon1 = new ImageIcon(getClass().getResource("VictoryDance1.gif"));
            JLabel label1 = new JLabel();
            label1.setIcon(icon1);
            p1.add(label1, BorderLayout.CENTER);
            
            ImageIcon icon2 = new ImageIcon(getClass().getResource("VictoryDance2.gif"));
            JLabel label2 = new JLabel();
            label2.setIcon(icon2);
            p2.add(label2, BorderLayout.CENTER);
            
        } catch(Exception e) {
            // handle exception
        }
        
        f1.add(p1);
        f2.add(p2);
        f1.pack();
        f2.pack();
        f1.setLocationRelativeTo(null);
        f2.setLocationRelativeTo(null);
        f1.setVisible(true);
    }
}