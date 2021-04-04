
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Name: Project 1 Part 2
 * 
 * Purpose: Calculate the minimum, maximum, and the mean of the list of numbers 
 * entered by the user as prompted
 * 
 * Notes: Please feel free to go into "programmer test mode", I would love to 
 * know what I missed.
 * 
 * Time Spent Log: 
 *  Main logic: 30 min
 *  Side logic: 7 h
 *  Revision: 5 h
 *  Total: 12.5 h
 * 
 * Date Finished:
 *  16 October 2020
 * 
 * @author Lihan Wang
 */
public class WangLProj1Part2 
{
    public static void main(String[] args) 
    {
        //making the GUI look like system popup instead of java popup
        try 
        {
            UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
        } 
        catch (UnsupportedLookAndFeelException | ClassNotFoundException | 
                InstantiationException | IllegalAccessException e) 
        {
            // handle exception
        }
        
        //getting user input
        String numList = getInput();
        
        //initializing variables needed
        boolean isNew = true; //true if input is new
        int min = 0;
        int max = 0;
        int numCount = 0;
        int sum = 0;
        String delimiter = ","; //the designated delimiter
        
        /*
        Operating on numList to output the max, min, and mean of the list of 
        numbers the user entered while preventing them from entering any bad 
        input
        */
        while(numList != null) //program can close when clicked "Cancel"
        {
            while(numList.length() == 0) //input is empty
            {
                //handling when user did not enter anything
                numList = handleEmptyInput();
                isNew = true;
                
                //handling when user clicked cancel
                if(numList == null) break;
            }
            
            //handling when user clicked cancel after entering nothing
            if(numList == null) break;
            
            //declaring more variables needed
            int num; //the number to be evaluated
            int index; //index of the delimiter
            String numStr; //the String representation of num
            int mean;
            
            /*
            handling when user only entered one number and when there is only 
            one number left to be evaluated
            */
            try
            {
                //checking if numList only contains one number
                num = Integer.parseInt(numList);
                
                /*
                updating min and max or setting them to num when user only 
                entered one number
                */
                if(num < min || isNew) min = num;
                if(num > max || isNew) max = num;
                
                //updating sum and numCount
                sum += num;
                numCount++;
                
                //calculating the mean
                mean = sum/numCount;
                
                //custom button text
                Object[] options = {"Done", 
                                    "Try Again"};
                
                /*
                showing the user their results and ask if they want to enter
                other numbers to be evaluated
                */
                int choice = JOptionPane.showOptionDialog(null, 
                          "The min is "  + min  + ".\n"
                        + "The max is "  + max  + ".\n"
                        + "The mean is " + mean + ".\n", 
                        "Results", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.PLAIN_MESSAGE, 
                        null, 
                        options, 
                        options[0]);
                
                //"Done" is clicked
                if(choice == 0) 
                    break; //exit
                
                //"Try Again" is clicked
                if(choice == 1) 
                {
                    //letting the user enter again
                    numList = getInput();
                    
                    //resetting the values
                    isNew = true;
                    numCount = 0;
                    sum = 0;
                }
            }
            
            //handling when user enters more than one number
            catch(NumberFormatException e)
            {
                try
                {
                    //getting the index of the specified delimiter
                    index = numList.indexOf(delimiter);
                    
                    /*
                    handling when there is no delimeter or when there's an 
                    extra one at the end
                    */
                    if(index == -1 || index == numList.length()-1)
                    {
                        /*
                        skipping current try block to the corresponding catch 
                        block to handle bad input
                        */
                        throw new NumberFormatException();
                    }
                    
                    //main logic
                    //separating the number before the delimiter
                    numStr = numList.substring(0, index);

                    /*
                    updating numList to be the rest of itself after the 
                    delimiter
                    */
                    numList = numList.substring(index + 1);

                    //converting the separated number into int
                    num = Integer.parseInt(numStr);
                    
                    //updating values
                    numCount++;
                    sum += num;
                                        
                    //handling the first iteration
                    if(isNew)
                    {
                        //giving min and max an initial value to compare to
                        min = num; 
                        max = num;
                        
                        //making sure this if-block only executes once
                        isNew = false;
                    }
                    
                    //updating min and max
                    if(num < min) min = num;
                    if(num > max) max = num;
                    
                }
                
                //handling when user input has bad syntax
                catch(NumberFormatException e2)
                {
                    //calling handleBadInput to handle bad user inpuy
                    numList = handleBadInput();
                    
                    //updating values
                    isNew = true;
                }
            }
        }
    }
    
    /**
     * get user input
     * 
     * @return a String containing user input
     */
    public static String getInput()
    {
        //prompting the user to enter input
        String numList = JOptionPane.showInputDialog(null, 
                "Please enter a list of numbers separated by commas. \n"
                + "For example: 1,1,2,3,5,8,13", 
                "Number Analyzer", 
                JOptionPane.PLAIN_MESSAGE);
        
        return numList;
    }
    
    /**
     * handle when user did not enter anything
     *
     * @return a String containing new user input
     */
    public static String handleEmptyInput()
    {
        //telling the user they did not enter anything
        JOptionPane.showMessageDialog(null, 
                "Looks like you did not enter anything. \n"
                + "Please try again.", 
                "Oops",
                JOptionPane.WARNING_MESSAGE);
        
        //letting the user try again
        String numList = getInput();
        
        return numList;
    }
    
    /**
     * handle when user input is not a list of integers separated by commas
     * 
     * @return a String containing new user input
     */
    public static String handleBadInput()
    {                    
        //telling the user the input was bad
        JOptionPane.showMessageDialog(null, 
                "Looks like you have entered some wacky symbols. \n" 
                + "Please try again.", 
                "Oops", 
                JOptionPane.WARNING_MESSAGE);
        
        //letting the user try again
        String numList = getInput();
        
        return numList;
    }
    
}