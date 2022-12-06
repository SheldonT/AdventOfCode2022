import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files

          /*
            A, X = Rock = 1     loose = 0
            B, Y = Paper = 2    draw = 3
            C, Z = Sissor = 3   win = 6
          */


public class Day2 {

  static int shapePoints (char shape){
    int total = 0;

    if ((shape == 'A') || (shape =='X')) total = 1;
    if ((shape == 'B') || (shape =='Y')) total = 2;
    if ((shape == 'C') || (shape =='Z')) total = 3;

    return total;
  }

//run for each player. First run is me as player, second is elf.
  static int outcome (char pl, char op){

    int res = 0;

    if ( ((pl == 'A') || (pl == 'X')) && ((op == 'C') || (op == 'Z')) ) { //win
      res = 6; // 6 for pl
    }
    if ( ((pl == 'B') || (pl == 'Y')) && ((op == 'A') || (op == 'X')) ) { //win
      res = 6;
    }
    if ( ((pl == 'C') || (pl == 'Z')) && ((op == 'B') || (op == 'Y')) ) { //win
      res = 6;
    }

    if (((pl == 'A') && (op == 'X')) || ((pl == 'B') && (op == 'Y')) || ((pl == 'C') && (op == 'Z' ))) {
      res = 3;
    }

     if (((op == 'A') && (pl == 'X')) || ((op == 'B') && (pl == 'Y')) || ((op == 'C') && (pl == 'Z' ))) {
      res = 3;
    }


    return res;

  }

  
  public static void main(String[] args) {
    try {
      File myObj = new File("day2.txt");
      Scanner myReader = new Scanner(myObj);

      int[][] roundScores; // [0][...] is the opponent
      int myScore = 0;
      int oppScore = 0;

      while (myReader.hasNextLine()) {

        String data = myReader.nextLine();
        

        char[] round = data.toCharArray(); // [0] = elf, [2] = me

       
        oppScore = oppScore + shapePoints(round[0]);
        myScore = myScore + shapePoints(round[2]);

        oppScore = oppScore + outcome(round[0], round[2]);
        myScore = myScore + outcome(round[2], round[0]);

        System.out.println(round);
      }

      myReader.close();

      System.out.println("Elf Score: " + oppScore);

      System.out.println("My Score: " + myScore);


      } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}