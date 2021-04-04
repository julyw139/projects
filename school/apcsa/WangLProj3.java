
import javax.swing.JOptionPane;

public class WangLProj3 
{
    public static void main(String[] args) 
    {
        //getting input
        String in1 = JOptionPane.showInputDialog("Enter point A "
                + "in the format (x,y)");
        Point a = toPoint(in1);
        
        String in2 = JOptionPane.showInputDialog("Enter point B "
                + "in the format (x,y)");
        Point b = toPoint(in2);
        
        String in3 = JOptionPane.showInputDialog("Enter point C "
                + "in the format (x,y)");
        Point c = toPoint(in3);
        
        String in4 = JOptionPane.showInputDialog("Enter point D "
                + "in the format (x,y)");
        Point d = toPoint(in4);
        
        System.out.println("Your Quadrilateral is : A" + a + ", B" + b 
                + ", C" + c + ", D" + d);
        
        boolean isPrlgrm = isParallelogram(a, b, c, d);
        boolean isRhombus = isRhombus(a, b, c, d);
        boolean isRectangle = isRectangle(a, b, c, d);
        boolean isSquare = isSquare(a, b, c, d);
        
        if(isPrlgrm)
        {
            System.out.println("ABCD is a parallelogram because its diagonals "
                    + "are divided by each other.");
            
            if(isRectangle)
            {
                System.out.println("ABCD is a rectangle because it is a "
                        + "parallelogram with a right angle.");
            }
            else
            {
                System.out.println("ABCD is NOT a rectangle.");
            }
            
            if(isRhombus)
            {
                System.out.println("ABCD is a rhombus because its a "
                        + "parallelogram whose adjacent sides are of equal length.");
            }
            else
            {
                System.out.println("ABCD is NOT a rhombus.");
            }
            
            if(isSquare)
            {
                System.out.println("ABCD is a square because it's both a "
                        + "rhombus and a rectangle.");
            }
            else
            {
                System.out.println("ABCD is NOT a square.");
            }
        }
        else
        {
            System.out.println("ABCD is NOT a parallelogram or a rectangle "
                    + "or a rhombus or a square.");
        }
    }
    
    public static Point toPoint(String str)
    {
        int len = str.length();
        int deliId = str.indexOf(','); //the index of the delimeter
        
        double x = Double.parseDouble(str.substring(1, deliId));
        double y = Double.parseDouble(str.substring(deliId + 1, len - 1));
        
        Point p = new Point(x,y);
        
        return p;
    }
        
    public static double distanceBetween(Point a, Point b)
    {
        double x1 = a.getX();
        double y1 = a.getY();
        
        double x2 = b.getX();
        double y2 = b.getY();
        
        double dist = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        
        return dist;
    }
    
    public static Point midPoint(Point a, Point b)
    {
        double x1 = a.getX();
        double y1 = a.getY();
        
        double x2 = b.getX();
        double y2 = b.getY();
        
        double midx = (x1 + x2) / 2;
        double midy = (y1 + y2) / 2;
        
        Point p = new Point(midx, midy);
        
        return p;
    }
    
    public static double slope(Point a, Point b)
    {
        double x1 = a.getX();
        double y1 = a.getY();
        
        double x2 = b.getX();
        double y2 = b.getY();
        
        double slope = (y2 - y1) / (x2 - x1);
        
        return slope;
    }
    
    public static boolean isParallelogram(Point a, Point b, Point c, Point d)
    {
        //check if midpoints are the same
        Point mid1 = midPoint(a, c);
        Point mid2 = midPoint(b, d);
                
        if(mid1.equals(mid2))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static boolean isRhombus(Point a, Point b,  Point c, Point d)
    {
        boolean isPrlgrm = isParallelogram(a, b, c, d);
        
        if(isPrlgrm)
        {
            //check if adjacent sides are the same
            double ab = distanceBetween(a, b);
            double ad = distanceBetween(a, d);
            
            if(ab == ad)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }

    }
    
    public static boolean isRectangle(Point a, Point b,  Point c, Point d)
    {
        boolean isPrlgrm = isParallelogram(a, b, c, d);
        
        if(isPrlgrm)
        {
            //check if abc = 90
            //i.e. if ab*bc = -1 (slope)
            double slope1 = slope(a, b);
            double slope2 = slope(b, c);
            
            if(slope1 * slope2 == -1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
    
    public static boolean isSquare(Point a, Point b,  Point c, Point d)
    {
        boolean isRhombus = isRhombus(a, b, c, d);
        boolean isRectangle = isRectangle(a, b, c, d);
        
        if(isRhombus && isRectangle)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
