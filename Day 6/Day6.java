
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files

public class Day6 {

    public static void main(String[] args) {

        try {
            File myObj = new File("day6.txt");
            Scanner myReader = new Scanner(myObj);

            String markerEnd = "";

            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();

                int j = 0;

                for (int i = 0; i < data.length(); i++) {

                    HashSet<Character> markerChar = new HashSet<Character>();

                    if (j < data.length() - 14) { // changed 4 to 14 for part 1.
                        for (j = i; j < (i + 14); j++) {
                            markerChar.add(data.charAt(j));
                        }

                        if (markerChar.size() == data.substring(i, j).length()) {
                            //System.out.println("Message Start: " + (j));
                            markerEnd = markerEnd + j + "\n";
                            break;
                        }

                    }

                }

            }
            System.out.println(markerEnd);
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
