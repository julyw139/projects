
public class WangLProj6 
{
    public static void main(String[] args) 
    {
        //testing
        //q1
        double[][] mat = {{0.3, 0.7, 0.8},
                          {1.1, 1.4, 0.4},
                          {0.2, 0.5, 0.1},
                          {0.9, 0.6, 1.6}};

        System.out.println("minFromSection = " + minFromSection(mat,1,3,0,1));
        
        //q2
        String[][] t = new String[2][3];
        String[] a2 = {"hello", "blah", "boom", "elephant"};
        System.out.println("twoCharsTO2D = ");
        print(twoCharsTo2D(t, a2));
        
        //q3a
        int[] a3 = {90, 60, 75, 80, 80};
        System.out.println("findAverage = " + findAverage(a3));
        
        //q3b
        int[][] g = {{80, 90, 90, 100, 70},
                     {90, 60, 75, 80, 80},
                     {100, 90, 96, 98, 99}};
        
        System.out.println("rowAvg = ");
        print(rowAvg(g));
        
        //q3c
        String[] r = {"Joe", "Kim", "Chris"};
        System.out.println("bestAverage = " + bestAverage(r,g));
        System.out.println("");
        
        //q4a
        int[][] g1 ={{9, 8, 7, 6}, //THIS IS CORRECT SYNTAX
                     {5, 4, 12, 1},
                     {3, 19, 2, 13}};
        
        int[][] g2 ={{-3, 4, -8}, //THIS IS CORRECT SYNTAX
                     {14, 2, 21},
                     {3, 32, -3}};
        System.out.println("removeRow = ");
        print(removeRow(g2, 1));
        
        //q4b
        System.out.println("removeCol = ");
        print(removeCol(g2, 1));
        
        //q4c
        System.out.println("removeRowCol = ");
        print(removeRolCol(g2, 1, 1));
        
        //q5 test case formatting
        String tableRaw = "String[][] table ={{“X”, “O”, “O”, “X”, “X”, “X”, “O”, “O”, “O”},\n" +
                          " {“O”, “O”, “O”, “O”, “X”, “O”, “O”, “O”, “O”},\n" +
                          " {“O”, “O”, “O”, “O”, “O”, “O”, “X”, “X”, “X”},\n" +
                          " {“O”, “O”, “X”, “O”, “O”, “O”, “X”, “O”, “O”},\n" +
                          " {“X”, “X”, “X”, “O”, “O”, “O”, “O”, “O”, “O”},\n" +
                          " {“O”, “O”, “O”, “O”, “X”, “O”, “O”, “O”, “O”},\n" +
                          " {“O”, “O”, “O”, “X”, “X”, “X”, “O”, “O”, “X”}};";
        format(tableRaw);

        //copied from output
        String[][] table ={{"X", "O", "O", "X", "X", "X", "O", "O", "O"},
                           {"O", "O", "O", "O", "X", "O", "O", "O", "O"},
                           {"O", "O", "O", "O", "O", "O", "X", "X", "X"},
                           {"O", "O", "X", "O", "O", "O", "X", "O", "O"},
                           {"X", "X", "X", "O", "O", "O", "O", "O", "O"},
                           {"O", "O", "O", "O", "X", "O", "O", "O", "O"},
                           {"O", "O", "O", "X", "X", "X", "O", "O", "X"}};
        
        //q5a
        System.out.println("toBeChanged = " + toBeChanged(3,3,table));
        
        //q5b
        System.out.println("change2DArray = ");
        print(change2DArray(table));
        
        //q6
        int[][] g3 ={{9, 8, 7, 6},
                     {5, 4, 2, 1},
                     {3, 9, 2, 3}};
        System.out.println("reverseColMajor = ");
        print(reverseColMajor(g3));
        
        //q7
        int[][] g4 = {{9, 8, 7, 6, 2, 4, 5}, //THIS IS CORRECT SYNTAX
                      {5, 4, 2, 1, 9, 3, 1},
                      {3, 9, 2, 3, 5, 1, 2},
                      {8, 7, 6, 3, 2, 5, 5},
                      {1, 2, 3, 3, 2, 1, 4},
                      {9, 8, 7, 6, 7, 8, 9}};
        System.out.println("get5x5At = ");
        print(get5x5At(g4, 5, 6));
        
        //q8
        int[][] sudokuPuzz1 = {{4,3,5,2,6,9,7,8,1},
                               {6,8,2,5,7,1,4,9,3},
                               {1,9,7,8,3,4,5,6,2},
                               {8,2,6,1,9,5,3,4,7},
                               {3,7,4,6,8,2,9,1,5},
                               {9,5,1,7,4,3,6,2,8},
                               {5,1,9,3,2,6,8,7,4},
                               {2,4,8,9,5,7,1,3,6},
                               {7,6,3,4,1,8,2,5,9}};
        
        int[][] sudokuPuzz2 = {{1,3,5,2,6,9,7,8,1},
                               {6,8,2,5,7,1,4,9,3},
                               {1,9,7,8,3,4,5,6,2},
                               {8,2,6,1,9,5,3,4,7},
                               {3,7,4,6,8,2,9,1,5},
                               {9,5,1,7,4,3,6,2,8},
                               {5,1,9,3,2,6,8,9,4},
                               {2,4,8,9,5,7,1,3,6},
                               {7,6,3,4,1,8,2,5,9}};
        
        //q8a
        System.out.println("checkRow = " + checkRow(sudokuPuzz1, 0));
        
        //q8b
        System.out.println("checkCol = " + checkCol(sudokuPuzz1, 8));
        
        //q8c
        System.out.println("check3x3 = " + check3x3(sudokuPuzz1, 0, 3));
        
        //q8d
        System.out.println("checkPuzzle = " + checkPuzzle(sudokuPuzz2));
    }
    
    //q1
    public static double minFromSection(double[][] nums, int startRow, int endRow, int startCol, int endCol)
    {
        double min = nums[0][0];
        
        for(int r = startRow; r <= endRow; r++)
        {
            for(int c = startCol; c <= endCol; c++)
            {
                if(nums[r][c] < min)
                    min = nums[r][c];
            }
        }
        
        return min;
    }
    
    //q2
    public static String[][] twoCharsTo2D(String[][]table, String[] words)
    {
        int strIndex = 0;
        for(int r = 0; r < table.length; r++)
        {
            for(int c = 0; c < table[0].length; c++)
            {
                if(strIndex < words.length)
                {
                    table[r][c] = words[strIndex].substring(0,2);
                    strIndex++;
                }
                else
                    table[r][c] = "$$";
            }
        }
        
        return table;
    }
    
    //q3a
    public static double findAverage(int[] nums)
    {
        double sum = 0;
        
        for(int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
        }
        
        return sum/nums.length;
    }
    
    //q3b
    public static double[] rowAvg(int[][] nums)
    {
        double[] output = new double[nums.length];
        
        for(int r = 0; r < nums.length; r++)
        {
            output[r] = findAverage(nums[r]);
        }
        
        return output;
    }
    
    //q3c
    public static String bestAverage(String[] roster, int[][] grades)
    {
        double[] avgs = rowAvg(grades);
        int maxIndex = 0;
        
        for(int i = 0; i < avgs.length; i++)
        {
            if(avgs[i] > avgs[maxIndex])
                maxIndex = i;
        }
        
        return roster[maxIndex];
    }
    
    //q4a
    public static int[][] removeRow(int[][] mat, int row)
    {
        int[][] output = new int[mat.length - 1][mat[0].length];
        int opRow = 0;
        
        for(int r = 0; r < mat.length; r++)
        {
            if(r != row)
            {
                output[opRow] = mat[r];
                opRow++;
            }
        }
        
        return output;
    }
       
    //q4b
    public static int[][] removeCol(int[][] mat, int col)
    {
        int[][] output = new int[mat.length][mat[0].length - 1];
        
        for(int r = 0; r < mat.length; r++)
        {
            int opCol = 0;
            
            for(int c = 0; c < mat[0].length; c++)
            {
                if(c != col)
                {
                    output[r][opCol] = mat[r][c];
                    opCol++;
                }
            }
        }
        
        return output;
    }
    
    //q4c
    public static int[][] removeRolCol(int[][] mat, int row, int col)
    {        
        return removeRow(removeCol(mat, col), row);
    }
    
    //q5a
    public static boolean toBeChanged(int r, int c, String[][] grid)
    {
        if(grid[r][c].equals("O"))
        {
            boolean hasLeftO = false;
            boolean hasTopO =  false;
        
            if(r != 0) //checkLeft
                hasLeftO = grid[r - 1][c].equals("O");
            if(c != 0) //checkTop
                hasTopO = grid[r][c - 1].equals("O");
            
            return !hasLeftO || !hasTopO;
        }
        else
            return false;
    }
    
    //q5b
    public static String[][] change2DArray(String[][] grid)
    {
        String[][] output = new String[grid.length][grid[0].length];
        
        for(int r = 0; r < grid.length; r++)
        {
            for(int c = 0; c < grid[0].length; c++)
            {
                if(toBeChanged(r,c,grid))
                    output[r][c] = "#";
                else
                    output[r][c] = grid[r][c];
            }
        }
        
        return output;
    }
    
    //q6
    public static int[][] reverseColMajor(int[][] mat)
    {
        int[][] output = new int[mat.length][mat[0].length];
        int matRow = 0;
        
        for(int r = output.length - 1; r >= 0; r--)
        {
            int matCol = 0;
            
            for(int c = output[0].length - 1; c >= 0; c--)
            {
                output[r][c] = mat[matRow][matCol];
                matCol++;
            }
            
            matRow++;
        }
        
        return output;
    }
    
    //q7 helper method 1
    //check whether an index is valid
    public static boolean isValid(int[][] grid, int r, int c)
    {
        if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length)
            return true;
        else
            return false;
    }
    
    //q7 helper method 2
    //count how many indexes are valid
    public static int countValid(int[][] grid, int row, int col)
    {
        int count = 0;
        
        for(int r = row - 2; r <= row + 2; r++)
        {
            for(int c = col - 2; c <= col + 2; c++)
            {
                if(isValid(grid, r, c))
                    count++;
            }
        }
        
        return count;
    }
    
    //q7
    public static int[] get5x5At(int[][] grid, int row, int col)
    {
        int[] output = new int[countValid(grid, row, col)];
        int opIndex = 0;
        
        for(int r = row - 2; r <= row + 2; r++)
        {
            for(int c = col - 2; c <= col + 2; c++)
            {
                if(isValid(grid, r, c))
                {
                    output[opIndex] = grid[r][c];
                    opIndex++;
                }
            }
        }
        
        return output;
    }
    
    //q8a
    public static boolean checkRow(int[][] puzzle, int currRow)
    {
        //I paired the indexes with the digits
        //whether currRow has the digit n would be represented by hasDigit[n - 1]
        //for example
        //whether currRow has number 1 would be represented by hasDigit[0]
        //whether currRow has number 2 would be represented by hasDigit[1]
        //and so on
        boolean[] hasDigit = new boolean[9]; //all false by default
        
        //populating the boolean[]
        for(int c = 0; c < puzzle[0].length; c++)
        {
            int currNum = puzzle[currRow][c];
            int index = currNum - 1;
            hasDigit[index] = true;
        }
        
        //going through the boolean[]
        for(int i = 0; i < hasDigit.length; i++)
        {
            if(!hasDigit[i])
                return false;
        }
        
        return true;
    }
    
    //q8b
    //same logic as q8a
    public static boolean checkCol(int[][] puzzle, int currCol)
    {
        boolean[] hasDigit = new boolean[9];
        
        for(int r = 0; r < puzzle.length; r++)
        {
            hasDigit[puzzle[r][currCol] - 1] = true;
        }
        
        for(int i = 0; i < hasDigit.length; i++)
        {
            if(!hasDigit[i])
                return false;
        }
        
        return true;
    }
    
    //q8c
    //same logic as q8a
    public static boolean check3x3(int[][] puzzle, int currRow, int currCol)
    {
        boolean[] hasDigit = new boolean[9];
        
        for(int r = currRow; r <= currRow + 2; r++)
        {
            for(int c = currCol; c <= currCol + 2; c++)
            {
                hasDigit[puzzle[r][c] - 1] = true;
            }    
        }
        
        for(int i = 0; i < hasDigit.length; i++)
        {
            if(!hasDigit[i])
                return false;
        }
        
        return true;
    }
    
    //q8d
    public static boolean checkPuzzle(int[][] puzzle)
    {
        //isSolved[0] = checkRow
        //isSolved[1] = checkCol
        //isSolved[2] = check3x3
        boolean[] isSolved = {true, true, true};
        
        for(int r = 0; r < puzzle.length; r++)
        {
            if(!checkRow(puzzle, r))
                isSolved[0] = false;
        }
        
        for(int c = 0; c < puzzle[0].length; c++)
        {
            if(!checkCol(puzzle, c))
                isSolved[1] = false;
        }
        
        for(int r = 0; r < puzzle.length; r += 3)
        {
            for(int c = 0; c < puzzle[0].length; c += 3)
            {
                if(!check3x3(puzzle, r, c))
                    isSolved[2] = false;
            }
        }
        
        for(int i = 0; i < isSolved.length; i++)
        {
            if(!isSolved[i])
                return false;
        }
        
        return true;
    }
    
    //proper printing String[][] edition
    public static void print(String[][] arr2D)
    {        
        for(int r = 0; r < arr2D.length; r++)
        {
            System.out.print("{");
            
            for(int c = 0; c < arr2D[r].length; c++)
            {
                System.out.print("\"" + arr2D[r][c] + "\"");
                
                if(c != arr2D[0].length - 1)
                    System.out.print(", ");
            }
            
            System.out.println("}");
        }
        
        System.out.println("");
    }
    
    //proper printing double[] edition
    public static void print(double[] arr)
    {     
        System.out.print("{");
        
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i]);

            if(i != arr.length - 1)
                System.out.print(", ");
        }
        
        System.out.println("}");
    }
    
    //proper printing int[][] edition
    public static void print(int[][] arr2D)
    {     
        for(int r = 0; r < arr2D.length; r++)
        {
            System.out.print("{");
            
            for(int c = 0; c < arr2D[0].length; c++)
            {
                System.out.print(arr2D[r][c]);
                
                if(c != arr2D[0].length - 1)
                    System.out.print(", ");
            }
            
            System.out.println("}");
        }
        
        System.out.println("");
    }
    
    //changing “ and ” into "
    public static void format(String str)
    {
        String output = "";
        
        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) == '“' || str.charAt(i) == '”')
                output += "\"";
            else
                output += str.charAt(i);
        }
        
        System.out.println(output + "\n");
    }
    
    //proper printing int[] edition
    public static void print(int[] arr)
    {     
        System.out.print("{");
        
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i]);

            if(i != arr.length - 1)
                System.out.print(", ");
        }
        
        System.out.println("}\n");
    }
}