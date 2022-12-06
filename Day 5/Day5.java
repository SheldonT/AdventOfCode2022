
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files

public class Day5 {

    public static void main(String[] args) {

        try {
            File myObj = new File("day5.txt");
            Scanner myReader = new Scanner(myObj);

            String[] crateArr = {
                "FLMW",
                "FMVZB",
                "QLSRVH",
                "JTMPQVSF",
                "WSL",
                "WJRMPVF",
                "FRNPCQJ",
                "BRWZSPHV",
                "WZHGCJMB"
            };

            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                int[] instructions = {0, 0, 0};

                int moveS = data.indexOf(' ') + 1;
                int moveE = data.indexOf('f') - 1;

                instructions[0] = Integer.parseInt(data.substring(moveS, moveE)); //this many crates

                int fromS = data.substring(moveE).indexOf('m') + 2;
                int fromE = data.substring(moveE).indexOf('t') - 1;

                instructions[1] = Integer.parseInt(data.substring(moveE).substring(fromS, fromE)); //from stack

                int toS = data.substring(fromE).indexOf('t') + 3;
                int toE = data.substring(fromE).length();

                instructions[2] = Integer.parseInt(data.substring(fromE).substring(toS, toE)); //to stack

                String removed = crateArr[instructions[1] - 1].substring(0, (instructions[0]));  // used removed.reverse() for part 1

                crateArr[instructions[1] - 1] = crateArr[instructions[1] - 1].substring(instructions[0]);

                crateArr[instructions[2] - 1] = removed + crateArr[instructions[2] - 1];

            }

            for (int i = 0; i < crateArr.length; i++) {
                System.out.println((i + 1) + ": " + crateArr[i]);
            }

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
