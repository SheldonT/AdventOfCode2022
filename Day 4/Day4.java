
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files

public class Day4 {

    static boolean checkRange(int[] range, int[] contained) {

        boolean inRange = false;
        boolean high = false;
        boolean low = false;

        for (int i = range[0]; i <= range[1]; i++) {
            if (i == contained[0]) {
                low = true;
            }
            if (i == contained[1]) {
                high = true;
            }
        }

        if (high && low) {
            inRange = true;
        }

        return inRange;
    }

    public static void main(String[] args) {

        try {
            File myObj = new File("day4.txt");
            Scanner myReader = new Scanner(myObj);

            int rangeContainCount = 0;

            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                String elf1Sect = "";
                String elf2Sect = "";
                int[] elf1Range = {0, 0};
                int[] elf2Range = {0, 0};

                int seperatorIndex = data.indexOf(',');

                elf1Sect = data.substring(0, seperatorIndex);
                elf2Sect = data.substring((seperatorIndex + 1), data.length());

                seperatorIndex = elf1Sect.indexOf('-');

                elf1Range[0] = Integer.parseInt(elf1Sect.substring(0, seperatorIndex));
                elf1Range[1] = Integer.parseInt(elf1Sect.substring((seperatorIndex + 1), elf1Sect.length()));

                seperatorIndex = elf2Sect.indexOf('-');

                elf2Range[0] = Integer.parseInt(elf2Sect.substring(0, seperatorIndex));
                elf2Range[1] = Integer.parseInt(elf2Sect.substring((seperatorIndex + 1), elf2Sect.length()));

                if (checkRange(elf1Range, elf2Range) || checkRange(elf2Range, elf1Range)) {
                    rangeContainCount = rangeContainCount + 1;
                }
            }

            System.out.println("There are " + rangeContainCount + " complete assignment overlaps.");

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
