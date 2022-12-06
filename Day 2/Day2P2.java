import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files

          /*
            A, X = Rock = 1     loose = 0
            B, Y = Paper = 2    draw = 3
            C, Z = Sissor = 3   win = 6
          */


public class Day2P2 {

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

  static int plannedOutcome (char outcome){
    int total = 0;

    if (outcome == 'X') total = 0;
    if (outcome == 'Y') total = 3;
    if (outcome == 'Z') total = 6;

    return total;
  }
  
  static int requiredShape (char elfShape, char outcome){
    int total = 0;

    if(outcome == 'X'){
      if(elfShape == 'A') total = 3; //my shape has to be sissors
      if(elfShape == 'B') total = 1;
      if(elfShape == 'C') total = 2;
    }

    if(outcome == 'Y'){
      if(elfShape == 'A') total = 1; //my shape has to be sissors
      if(elfShape == 'B') total = 2;
      if(elfShape == 'C') total = 3;
    }
    
    if(outcome == 'Z'){
      if(elfShape == 'A') total = 2; //my shape has to be sissors
      if(elfShape == 'B') total = 3;
      if(elfShape == 'C') total = 1;
    }

    return total;

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

       
        //oppScore = oppScore + shapePoints(round[0]);
        //myScore = myScore + shapePoints(round[2]);
        myScore = myScore + plannedOutcome(round[2]);

        //oppScore = oppScore + outcome(round[0], round[2]);
        //myScore = myScore + outcome(round[2], round[0]);

        myScore = myScore + requiredShape(round[0], round[2]);

      }

      myReader.close();

      System.out.println("My Score: " + myScore);


      } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}