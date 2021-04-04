package PracticeProjectAP2020;

import javax.swing.JOptionPane;

public class WangLProj1Practice
{
    public static void main(String[] args)
    {
        //getting the input
        String input = JOptionPane.showInputDialog("Enter a word or sentence");
        
        //check if input has at least 5 characters
        while(input.length() < 5)
        {
            //getting the input again
            input = JOptionPane.showInputDialog("Too short, try again");
        }
        
        //1. printing the input
        System.out.println("The String being worked on is " + input + ".");
        
        //2. getting and printing the first letter
        char firstChar = input.charAt(0);
        System.out.println("The first letter is " + firstChar + ".");
        
        //3. getting and printing the 3rd letter
        char thirdChar = input.charAt(2);
        System.out.println("The third letter is " + thirdChar + ".");
        
        //4. getting and printing the first 4 chars
        String sub4 = input.substring(0,4);
        System.out.println("The first 4 chars are " + sub4 + ".");
        
        //5. getting and printing a String from the third letter to the end
        String sub3 = input.substring(2);
        System.out.println("The String from the third letter on is " + sub3 + ".");
        
        //6. getting and printing the length of input
        int length = input.length();
        System.out.println("The length of the String is " + length + ".");
        
        //7. getting the position of the first occurence of a 
        int index = input.indexOf('a');
        System.out.println("The position of a is " + index + ".");
        
        //8. getting and printing the last letter
        char endChar = input.charAt(length - 1);
        System.out.println("The last letter is " + endChar + ".");
        
        //9. getting and printing the last 3 chars
        String last3 = input.substring(length - 3, length);
        System.out.println("The last 3 chars are " + last3 + ".");
    }
}
