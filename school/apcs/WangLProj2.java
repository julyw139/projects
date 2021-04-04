public class WangLProj2 
{
    public static void main(String[] args) 
    {
        int minOrMax = minOrMax(3,9,1,false);
        System.out.println("minOrMax = " + minOrMax);
        
        double rawGrade = calcRawGrade(90,67);
        System.out.println("rawGrade = " + rawGrade);
        
        int rCardGrade = calcRCardGrade(67.8);
        System.out.println("rCardGrade = " + rCardGrade);   
        
        String gradeFor = calcGradeFor("Kim Gamello", 90, 67);
        System.out.println(gradeFor);
        
        int nextFloor = nextFloor(5,3,4);
        System.out.println("nextFloor = " + nextFloor);
        
        String annoyingChar = annoyingChar("aCe", 'e');
        System.out.println("annoyingChar = " + annoyingChar);
    }
    
    public static int minOrMax(int a, int b, int c, boolean max)
    {
        int output;
        int maxNum;
        int minNum;
        
        if(a >= b)
        {
            if(b >= c)
            {
                maxNum = a;
                minNum = c;
            }
            else //b < c && b < a
            {
                minNum = b;
                
                if(a >= c)
                {
                    maxNum = a;
                }
                else
                {
                    maxNum = c;
                }
            }
        }
        else //a < b
        {
            if(b <= c)
            {
                minNum = a;
                maxNum = c;
            }
            else //b > c && b > a
            {
                maxNum = b;
                
                if(a <= c)
                {
                    minNum = a;
                }
                else
                {
                    minNum = c;
                }
            }
        }
        
        if(max)
        {
            output = maxNum;
        }
        else
        {
            output = minNum;
        }
        
        return output;
    }
    
    public static double calcRawGrade(double cwAvg,double testAvg)
    {
        double output;
        
        output = cwAvg*35/100 + testAvg*65/100;
        
        return output;
    }
    
    public static int calcRCardGrade(double raw)
    {
        int output;
        int grade;
        
        if(raw <= 55)
        {
            grade = 55;
        }
        else if(raw >= 100)
        {
            grade = 100;
        }
        else 
        {
            //rounding to the nearest whole number
            double decPt = raw - (int)raw;
            
            if(decPt >= 0.5)
            {
                grade = (int)raw + 1;
            }
            else
            {
                grade = (int)raw;
            }
            
            if(raw >= 90)
            {
                //exit conditionals
            }
            else if(raw == 88)
            {
                grade = 88;
            }
            else
            {
                //rounding to the nearest multiple of 5
                int dig1 = grade % 10;
                int mod5 = dig1 % 5;
                
                if(mod5 >= 3) // mod5 = 3,4
                {
                    grade = grade + (5 - mod5);
                }
                else //mod5 = 0, 1, 2
                {
                    grade = grade - mod5;
                }
            }
        }
        
        output = grade;
        
        return output;
    }
    
    public static String calcGradeFor(String name, double cwAvg, double testAvg)
    {
        String output;
        
        double rawGrade = calcRawGrade(cwAvg, testAvg);
        
        int rCardGrade = calcRCardGrade(rawGrade);
        
        output = name + ": " + rCardGrade;
        
        return output;
    }
    
    public static int nextFloor(int current, int button1, int button2)
    {
        int output;
        
        int delta1 = Math.abs(button1 - current);
        int delta2 = Math.abs(button2 - current);
        
        if(delta1*delta2 < 0) //opposite direction
        {
            output = button1;
        }
        else //same direction
        {
            if(delta1 < delta2)
            {
                output = button1;
            }
            else
            {
                output = button2;
            }
        }
        
        return output;
    }
    
    public static String annoyingChar(String str, char c)
    {
        String output = str;
        
        int index = str.indexOf(c);
        
        if(index != -1 && index != str.length() - 1)
        {
            char right = str.charAt(index + 1);
            
            if (Character.isLowerCase(c)) 
            {
                right = Character.toLowerCase(right);
            }
            
            if (Character.isUpperCase(c)) 
            {
                right = Character.toUpperCase(right);
            }
            
            output = str.substring(0, index) + c + right 
                    + str.substring(index + 2);
        }
        
        return output;
    }
}
