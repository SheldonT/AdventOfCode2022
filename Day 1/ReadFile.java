import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files


public class ReadFile {
  
  public static void main(String[] args) {
    try {
      File myObj = new File("adventOfCode1.txt");
      Scanner myReader = new Scanner(myObj);

      int[] elfCalorie = new int[0];
      int calorie = 0;

      while (myReader.hasNextLine()) {

        String data = myReader.nextLine();
        if (data != "") {
          calorie = calorie + Integer.parseInt(data);
        } else {
          elfCalorie = Arrays.copyOf(elfCalorie, elfCalorie.length + 1);
          elfCalorie[elfCalorie.length - 1] = calorie;
          calorie = 0;
        }
        
      }
      myReader.close();

      int[] mostCal = elfCalorie;

      Arrays.sort(mostCal);

      System.out.println("High: " + mostCal[mostCal.length - 1] + ", Low: " + mostCal[0]);

      for (int i = 0; i < elfCalorie.length; i++){

        System.out.println(mostCal[i] + " " + elfCalorie[i]);

        if (elfCalorie[i] == mostCal[mostCal.length - 1]){
          System.out.println("Elf #" + (i + 1) + " has the most calories (" + mostCal[mostCal.length - 1] + ").");
        }

      }

      System.out.println("The top 3 elves have a total of " + (mostCal[mostCal.length - 1] + mostCal[mostCal.length - 2] + mostCal[mostCal.length - 3]) + " calories");

    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}