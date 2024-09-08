import java.util.*;
import java.io.*;

public class FileReader {
    public static String[] readFile(String fileName) {
        Scanner fileScanner;
        while(true) {
            try {
                fileScanner = new Scanner(new File(fileName));
                break;
            } catch (FileNotFoundException e) {
                e.getStackTrace();
            }
        }

        ArrayList<String> stringArrayList = new ArrayList<>();
        while (fileScanner.hasNextLine()) {
            stringArrayList.add(fileScanner.nextLine());
        }

        fileScanner.close();

        String[] stringArray = new String[stringArrayList.size()];
        for(int i = 0; i < stringArrayList.size(); i++) {
            stringArray[i] = stringArrayList.get(i);
        }

        return stringArray;
    }
}
