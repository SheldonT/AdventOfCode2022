
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files

public class Day3P2 {

    public static void main(String[] args) {
        try {
            File myObj = new File("day3.txt");
            Scanner myReader = new Scanner(myObj);

            String items = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

            String[] elfGroup = {"", "", ""};
            int totalPriority = 0;
            int lineCount = 0;

            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();

                elfGroup[lineCount] = data;
                lineCount++;
                char b = ' ';

                if ((lineCount) % 3 == 0) {

                    for (int i = 0; i < elfGroup[0].length(); i++) {
                        for (int j = 0; j < elfGroup[1].length(); j++) {
                            if (elfGroup[0].charAt(i) == elfGroup[1].charAt(j)) {
                                for (int k = 0; k < elfGroup[2].length(); k++) {
                                    if (elfGroup[1].charAt(j) == elfGroup[2].charAt(k)) {

                                        b = elfGroup[2].charAt(k);

                                    }
                                }
                            }
                        }
                    }
                    totalPriority = totalPriority + items.indexOf(b) + 1;

                    lineCount = 0;
                }

            }

//remove duplicates
            System.out.println("Badges Priority: " + totalPriority);

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
