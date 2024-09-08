import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application {
    final int SCREENSIZE = 2;
    boolean fullscreen = false;

    private String[] readMemFile(String filename) {
        // Construct fileScanner object
        Scanner fileScanner;
        while(true) {
            try {
                if(!filename.contains(".mem")) {
                    filename += ".mem";
                }
                fileScanner = new Scanner(new File(filename));
                break;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Not a valid filename");
            }
        }

        // Go through file and add each line to an ArrayList
        ArrayList<String> stringArrayList = new ArrayList<>();
        while (fileScanner.hasNextLine()) {
            stringArrayList.add(fileScanner.nextLine());
        }

        fileScanner.close();

        // Convert ArrayList to String[]
        String[] stringArray = new String[stringArrayList.size()];
        for(int i = 0; i < stringArrayList.size(); i++) {
            stringArray[i] = stringArrayList.get(i);
        }

        return stringArray;
    }

    private Canvas background() {
        String[] backbuffer_init = readMemFile("./src/memory_init/backbuffer_init.mem");
        Canvas canvas = new Canvas(640*SCREENSIZE, 480*SCREENSIZE);
        for(int i = 0; i < backbuffer_init.length; i++) {
            Text text = new Text();
            text.setText(backbuffer_init[i]);
            text.setFont(Font.font("Verdana", 5));
            text.setFill(Color.BLACK);
            canvas.getGraphicsContext2D().drawImage(text.snapshot(null, null), i%40*32, i/40*32);
        }
        return canvas;

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try{
            Group root = new Group();
            Scene scene = new Scene(root, Color.DARKMAGENTA);

            // Initial window setup
            Image icon = new Image("icon.png");
            primaryStage.getIcons().add(icon);
            primaryStage.setTitle("The Crawling Dead with ABRAHAM FORD");
            primaryStage.setWidth(640*SCREENSIZE);
            primaryStage.setHeight(480*SCREENSIZE);
//            primaryStage.setResizable(false);
            primaryStage.setFullScreen(fullscreen);

            // Add background to root
            root.getChildren().add(background());






//            // Showing some text on screen
//            Text text = new Text();
//            text.setText("Yooooo, we ballin'");
//            text.setX(320*SCREENSIZE - 150);
//            text.setY(240*SCREENSIZE);
//            text.setFont(Font.font("Verdana", 50));
//            text.setFill(Color.WHITE);
//
//            // Showing a line on screen
//            Line line = new Line();
//            line.setStartX(200);
//            line.setStartY(200);
//            line.setEndX(400);
//            line.setEndY(400);
//            line.setStrokeWidth(5);
//            line.setStroke(Color.GOLD);
//            line.setOpacity(0.5);
//
//            root.getChildren().add(text);
//            root.getChildren().add(line);

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}