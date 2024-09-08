import java.util.*;
import java.io.*;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.paint.*;

public class TilemapViewer extends Application {
    private static final int PIXELSIZE = 1;
    private String filename;

    public String[] readFile() {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter filename (0 to exit): ");
        Scanner fileScanner;
        while(true) {
            try {
                this.filename = userInput.nextLine();
                if(this.filename.equals("0")) {
                    System.exit(0);
                }
                
                if(!this.filename.contains(".mem")) {
                    this.filename += ".mem";
                }

                fileScanner = new Scanner(new File(filename));
                break;
            } catch (Exception e) {
                System.out.print("Not a valid filename, try again (0 to exit): ");
            }
        }
        userInput.close();

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

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        Group tiles = new Group();
        for(int k = 0; k < 10; k++) {
            String[] tileArray = readFile();
            
            for(int i = 0; i < tileArray.length; i++) {
                Rectangle pixel = new Rectangle();
                String currentPixel = tileArray[i];
                int a = 1 - Integer.parseInt(currentPixel.charAt(0) + "");
                int r = Integer.parseInt(currentPixel.charAt(1) + "" + currentPixel.charAt(2), 2);
                int g = Integer.parseInt(currentPixel.charAt(3) + "" + currentPixel.charAt(4), 2);
                int b = Integer.parseInt(currentPixel.charAt(5) + "" + currentPixel.charAt(6), 2);
    
    
    
                pixel.setHeight(PIXELSIZE);
                pixel.setWidth(PIXELSIZE);
                pixel.setX((i % 32) * PIXELSIZE + 40*k);
                pixel.setY((i / 32) * PIXELSIZE);
                pixel.setFill(Color.rgb(85*r, 85*g, 85*b, (double) a));
                tiles.getChildren().add(pixel);
            }
        }


        Scene scene = new Scene(tiles, 32*PIXELSIZE*10, 32*PIXELSIZE);
        primaryStage.setScene(scene);
        primaryStage.setTitle(this.filename);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
