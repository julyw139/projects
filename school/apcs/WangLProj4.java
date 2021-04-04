
import javax.swing.JOptionPane;

public class WangLProj4 
{
    public static void main(String[] args) 
    {
        System.out.println("iCJava = " + iCJava("none here"));
        System.out.println("differentNeighbors = " + differentNeighbors("baboon"));
        System.out.println("reverse = " + reverse("ha"));
        System.out.println("mirrorM = " + mirrorM("xyMabc"));
        System.out.println("mockMeme = " + mockMeme("!a,b,c d e,!f"));
        System.out.println("getHint = " + getHint("HAPPY", "HEART"));
        playGuessingGame("HAPPY");
        System.out.println("theEvilestE = " + theEvilestE("xeEex"));
    }
    
    //q1
    public static boolean iCJava(String str)
    {
        int count = 0;
        
        for(int i = 0; i < str.length() - 3; i++)
        {
            if(str.substring(i, i + 4).equals("java"))
            {
                count++;
                i += 3;
            }
        }

        if(count > 0 && count % 2 == 0)
            return true;
        
        return false;
    }
    
    //q2
    public static boolean differentNeighbors(String str)
    {        
        for(int i = 1; i < str.length() - 1; i++)
        {
            char left = str.charAt(i - 1);
            char right = str.charAt(i + 1);
            char now = str.charAt(i);
            
            if(left == now || right == now)
                return false;
        }
        
        return true;
    }
    
    //q3a
    public static String reverse(String str)
    {
        String reversed = "";
        
        for(int i = str.length() - 1; i >= 0; i--)
        {
            reversed += str.charAt(i);
        }
        
        return reversed;
    }
    
    //q3b
    public static String mirrorM(String str)
    {
        int indexM = str.indexOf('M');
        
        //M is closer to the beginning
        if(indexM < str.length() / 2)
        {
            String left = str.substring(0, indexM);
            String right = str.substring(indexM + 1, indexM + left.length() + 1);
            String rest = str.substring(indexM + left.length() + 1);
            
            String result = reverse(right) + "M" + reverse(left) + rest;
            
            return result;
        }
        else //M is closer to the end
        {
            String right = str.substring(indexM + 1);
            String left = str.substring(indexM - right.length(), indexM);
            String rest = str.substring(0, indexM - right.length());
            
            String result = rest + reverse(right) + "M" + reverse(left);
            
            return result;
        }
    }
    
    //q4
    public static String mockMeme(String phrase)
    {
        String result = "";
        
        for(int i = 0; i < phrase.length(); i++)
        {
            char c  = phrase.charAt(i);
            if(Character.isLetter(c))
            {
                if(i % 2 == 0)
                    result += Character.toUpperCase(c);
                else
                    result += Character.toLowerCase(c);
            }
            else
            {
                if(c == ' ')
                    result += c;
                else
                    result += "";
            }
        }
        
        return result;
    }
    
    //q5a
    public static String getHint(String hiddenWord, String guess)
    {
        String hint = "";
        int len = hiddenWord.length();
        
        for(int i = 0; i < len; i++)
        {
            if(guess.charAt(i) == hiddenWord.charAt(i))
                hint += guess.charAt(i);
            else
            {
                boolean isInWord = false;
                for(int j = 0; j < len; j++)
                {
                    if(guess.charAt(i) == hiddenWord.charAt(j))
                        isInWord = true;
                }
                
                if(isInWord)
                    hint += "+";
                else
                    hint += "*";
            }
        }
        
        return hint;
    }
    
    //q5b
    public static void playGuessingGame(String hiddenWord)
    {
        String msg = "Enter your guess with all caps. You have 10 tries. "
                + "\n" + "The length is " + hiddenWord.length();
        String guess = JOptionPane.showInputDialog(msg);
        
        int counter = 1;
        
        while(!guess.equals(hiddenWord))
        {
            counter++;
            
            if(counter > 10)
            {
                System.out.println("It looks like you've run out of tries.");
                return;
            }
            else
            {
                guess = JOptionPane.showInputDialog("Oops, please try again. "
                        + "\n" + "You entered: " + guess + "\n"
                        + "The hint is: " + getHint(hiddenWord, guess));
            }
        }
        
        System.out.println("Congrats! You did it on the " + counter + " th try");
    }
    
    //q6
    public static String theEvilestE(String str)
    {
        //the total amount of 'E' in str
        int total = countChar('E', str);
        
        //there's an odd # of 'E' and more than 1 'E'
        if(total % 2 == 1 && total > 1)
        {
            int count = 0;
            int midEIndex = -1;
            
            //see if the first char is 'E'
            if(str.charAt(0) == 'E')
                count++;
            
            //iterate through str, excluding the first and last char
            for(int i = 1; i < str.length() - 1; i++) 
            {
                if(str.charAt(i) == 'E') 
                {
                    //keeping track of which 'E' this is
                    count++;
                    
                    //the middle 'E' has been found
                    if(count == total / 2 + 1)
                    {
                        //the middle 'E' is surrounded by 2 'e'
                        if(str.charAt(i - 1) == 'e' && str.charAt(i + 1) == 'e')
                            midEIndex = i;
                        else
                            return str;
                    }
                }
            }
            
            //there is a 'E' satisfying all the conditions
            if(midEIndex != -1)
            {
                String result = "";
                for(int i = 0; i < str.length(); i++)
                {
                    if(i == midEIndex)
                        result += "E";
                    else
                        result += "-";
                }
                
                return result;
            }
        }
        
        //every other case
        return str;
    }
    
    //q6 helper method
    //count the occurences of a given char in the given String
    public static int countChar(char c, String str)
    {
        int total = 0;
        
        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) == c)
                total++;
        }
        
        return total;
    }
}
