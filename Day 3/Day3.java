
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files

public class Day3 {

    public static void main(String[] args) {
        try {
            File myObj = new File("day3.txt");
            Scanner myReader = new Scanner(myObj);

            String items = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

            String allPriorityItems = "";

            int totalPriority = 0;

            while (myReader.hasNextLine()) {

                String pouch1 = "";
                String pouch2 = "";

                String pouchCommon = "";

                int lineLen = 0;

                String data = myReader.nextLine();

                lineLen = data.length();

                pouch1 = data.substring(0, (lineLen / 2));
                pouch2 = data.substring((lineLen / 2), lineLen);

                for (int i = 0; i < pouch1.length(); i++) {
                    for (int j = 0; j < pouch2.length(); j++) {
                        if (pouch1.charAt(i) == pouch2.charAt(j)) {
                            pouchCommon = pouchCommon + pouch1.charAt(i);
                        }
                    }
                }
//remove duplicates
                if (pouchCommon.length() != 0) {
                    for (int i = 0; i < pouchCommon.length(); i++) {

                        int j;

                        for (j = 0; j < pouchCommon.length(); j++) {
                            if (pouchCommon.charAt(i) == pouchCommon.charAt(j)) {
                                break;
                            }
                        }

                        if (i == j) {
                            totalPriority = totalPriority + items.indexOf(pouchCommon.charAt(j)) + 1;
                        }
                    }
                }

            }

//remove duplicates
            System.out.println("Backpack Item Priority Sum: " + totalPriority);

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
