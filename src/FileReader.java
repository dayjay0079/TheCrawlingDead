import java.util.*;
import java.io.*;

public class FileReader {
    public static String[] readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner fileScanner = new Scanner(file);
        
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
