public class WangLProj5 
{
    public static void main(String[] args) 
    {
        //testing
        //q1
        String[] a1 = {"hola","word","night"};
        System.out.println("comesBefore = " + comesBefore(a1, "xenomorph"));
        
        //q2
        int[] a2 = {1,2,3,4,5,8,9,10,2,7};
        System.out.print("noAdjInc = ");
        print(noAdjInc(a2));
        
        //q3
        int[] a3 = {12,10,-13,4,20,15};
        System.out.println("maxAdjDist = " + maxAdjDist(a3));
        
        //q4
        String[] a4a = {"I","HATE","EVIL","ES"};
        String[] a4b = {"THIS","IS","BETTER"};
        String[] a4c = {"No, ","this","is","better"};
        
        //q4a
        System.out.println("countStringsWithE = " + countStringsWithE(a4c));
        
        //q4b
        System.out.print("noMoreEvilEsPLEASE = ");
        print(noMoreEvilEsPLEASE(a4c));
        
        //q5
        double[] a5 = {5.0,2.2,3.8,9.1};
        
        System.out.print("randomlyRemoveElement = ");
        print(randomlyRemoveElement(a5));
        
        System.out.print("randomlyRemoveNElements = ");
        print(randomlyRemoveNElements(a5,2));
        
        //q6
        String[] a6 = {"AP","COMP","SCI","ROCKS"};
        String[] a7 = {"GREEN","EGGS","AND","HAM"};
        String[] a8 = {"BEACH","BALL"};
        String[] a9 = {"A","B","C"};
        
        System.out.println("totalLetters = " + totalLetters(a9));
        
        System.out.println("basicGapWidth = " + basicGapWidth(a9,20));
        
        System.out.println("leftOverSpaces = " + leftOverSpaces(a9,20));
        
        dramaticPrint(format(a9,20));
    }
    
    //q1
    public static boolean comesBefore(String[] words, String str)
    {
        for(int i = 0; i < words.length; i++)
        {
            if(words[i].compareTo(str) >= 0)
                return false;
        }
        
        return true;
    }
    
    //q2
    public static int[] noAdjInc(int[] nums)
    {
        for(int i = 0; i < nums.length - 2; i++)
        {
            if(nums[i] + 1 == nums[i + 1] && nums[i] + 2 == nums[i + 2])
            {
                nums[i] = -99;
                nums[i + 1] = -99;
                nums[i + 2] = -99;
            }
        }
        return nums;
    }
    
    //q3
    public static int maxAdjDist(int[] nums)
    {
        int max = Math.abs(nums[0] - nums[1]);
        
        for(int i = 0; i < nums.length - 1; i++)
        {
            int dist = Math.abs(nums[i] - nums[i + 1]);
            if(dist >= max)
                max = dist;
        }
        return max;
    }
    
    //q4a
    public static int countStringsWithE(String[] strs)
    {
        int count = 0; 
        
        for(int i = 0; i < strs.length; i++)
        {
            if(strs[i].indexOf("E") != -1)
                count++;
        }
        return count;
    }
    
    //q4b
    public static String[] noMoreEvilEsPLEASE(String[] strs)
    {
        String[] result = new String[strs.length - countStringsWithE(strs)];
        int rIndex = 0;
        
        for(int i = 0; i < strs.length; i++)
        {
            if(strs[i].indexOf("E") == -1)
            {
                result[rIndex] = strs[i];
                rIndex++;
            }
        }
        return result;
    }

    //q5a
    public static double[] randomlyRemoveElement(double[] nums) 
    {
        double[] result = new double[nums.length - 1];
        int resultIndex = 0;
        int randomIndex = (int)(Math.random() * nums.length);
        
        for(int i = 0; i < nums.length; i++)
        {
            if(i != randomIndex)
            {
                result[resultIndex] = nums[i];
                resultIndex++;
            }
        }
        return result;
    }

    //q5b
    public static double[] randomlyRemoveNElements(double[] nums, int n)
    {
        double[] result = randomlyRemoveElement(nums);
        
        for(int i = 0; i < n - 1; i++)
        {
            result = randomlyRemoveElement(result);
        }
        return result;
    }

    //q6a
    public static int totalLetters(String[] wordList)
    {
        int totalLets = 0;
        
        for(int i = 0; i < wordList.length; i++)
        {
            totalLets += wordList[i].length();
        }
        
        return totalLets;
    }
    
    //q6b
    public static int basicGapWidth(String[] wordList, int formattedLen)
    {
        int totalLets = totalLetters(wordList);
        int letCount = wordList.length;
        
        int gapWidth = (formattedLen - totalLets)/(letCount - 1);
        
        return gapWidth;
    }
    
    //q6c
    public static int leftOverSpaces(String[] wordList, int formattedLen)
    {
        int totalLets = totalLetters(wordList);
        int gapWidth = basicGapWidth(wordList, formattedLen);
        int letCount = wordList.length;
        
        int leftOvers = formattedLen - (totalLets + gapWidth * (letCount - 1));
        
        return leftOvers;
    }
    
    //q6d
    public static String format(String[] wordList, int formattedLen)
    {
        int gapWidth = basicGapWidth(wordList, formattedLen);
        int leftOvers = leftOverSpaces(wordList, formattedLen);
        String output = "";
        
        for(int i = 0; i < wordList.length; i++)
        {
            output += wordList[i];
            
            //adding gaps
            if(i != wordList.length - 1)
            {
                for(int j = 0; j < gapWidth; j++)
                    output += " ";
            }
            
            //distributing leftOvers
            if(leftOvers != 0)
            {
                output += " ";
                leftOvers--;
            }
        }
                    
        return output;
    }
    
    //proper printing int[] edition
    public static void print(int[] arr)
    {        
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i]);

            if(i != arr.length - 1)
                System.out.print(", ");
        }
        
        System.out.println("");
    }
    
    //proper printing String[] edition
    public static void print(String[] arr)
    {        
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print("\"" + arr[i] + "\"");

            if(i != arr.length - 1)
                System.out.print(", ");
        }
        
        System.out.println("");
    }
    
    //proper printing double[] edition
    public static void print(double[] arr)
    {        
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i]);

            if(i != arr.length - 1)
                System.out.print(", ");
        }
        
        System.out.println("");
    }
    
    //special printing q6 edition
    public static void dramaticPrint(String word)
    {
        System.out.print("|");
        for(int i = 0; i < word.length(); i++)
        {
            System.out.print(word.charAt(i) + "|");
        }
        System.out.println("");
    }
}
