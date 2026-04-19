import java.io.*;
import java.util.*;

public class SudokuBoard {
   // notes: organize indentation (17/4)
   //notes: code shells made (15/4)
   private char[][] board;

   public SudokuBoard(String file) {
      board = new char[9][9];
         try {
            Scanner fileScanner = new Scanner(new File(file));
            
            int row = 0;
            
            while (fileScanner.hasNextLine() && row < board.length) {
               String line = fileScanner.nextLine();
               
               for (int col = 0; col < board[row].length; col++) {
                  char c = line.charAt(col);
                  board[row][col] = (c == '.') ? ' ' : c;
               }
               
               row++;
               
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file);
        }
   }

   public String toString() {
       // notes: finished roughly, try usign simpler code (16/4)
       String line = "        ===============================";
       String result = "";
       String newLine = "\n";
       
       for (int row = 0; row < board.length; row++) {
         if (row % 3 == 0) {
            result += line + "\n";
         }
         
         result += "row = " + (row + 1) + " | ";
         
         for (int col = 0; col < board[row].length; col++) {
            result += (board[row][col] == ' ' ? "." : board[row][col]) + "  ";
            
            if ((col + 1) % 3 == 0) {
            result += "| ";
            }
            
         }
         
         result += newLine;
         
       }
       
       result += line + newLine;
       result += "col =     1  2  3    4  5  6    7  8  9";
       return result;
   }

}

// make the change log

/*
CHANGE LOG: 
Entry |                Summary                                    |                  Change
-------------------------------------------------------------------------------------------------------------------------------------
  1   |    forgot  try-catch needs a FileNotFoundException in it  | Added FileNotFoundException(e) {} 
  2   |    forgot to put int row = 0 to initiate row variable     | added int row in addition to row++
  3   |    try to imrpove the if-function in line 21              | change the traditional if to ternary if 
  4   |    difficulty in producing new line for the product       | added newline variable so it can be assigned to "\n" to return 
  5   |    have no idea of how to process the sdk data            | decided to use .hasNextLine
  6   |    contemplating whether to use modulus or make count var | used modulus instead of count++; if (count == 3) {result.append("| ");count = 0;}
  7   |    lacks curly braces after all modification              | fixed and organize all indentations
 
*/ 


// RESULT
/*  ----jGRASP exec: java SudokuMain
         ===============================
 row = 1 | 2  .  .  | 1  .  5  | .  .  3  | 
 row = 2 | .  5  4  | .  .  .  | 7  1  .  | 
 row = 3 | .  1  .  | 2  .  3  | .  8  .  | 
         ===============================
 row = 4 | 6  .  2  | 8  .  7  | 3  .  4  | 
 row = 5 | .  .  .  | .  .  .  | .  .  .  | 
 row = 6 | 1  .  5  | 3  .  9  | 8  .  6  | 
         ===============================
 row = 7 | .  2  .  | 7  .  1  | .  6  .  | 
 row = 8 | .  8  1  | .  .  .  | 2  4  .  | 
 row = 9 | 7  .  .  | 4  .  2  | .  .  1  | 
         ===============================
 col =     1  2  3    4  5  6    7  8  9
 
  ----jGRASP: Operation complete.
*/ 