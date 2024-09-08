import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    final int SCREENSIZE = 2;
    boolean fullscreen = false;

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
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(fullscreen);

            // Showing some text on screen
            Text text = new Text();
            text.setText("Yooooo, we ballin'");
            text.setX(320*SCREENSIZE - 150);
            text.setY(240*SCREENSIZE);
            text.setFont(Font.font("Verdana", 50));
            text.setFill(Color.WHITE);

            // Showing a line on screen
            Line line = new Line();
            line.setStartX(200);
            line.setStartY(200);
            line.setEndX(400);
            line.setEndY(400);
            line.setStrokeWidth(5);
            line.setStroke(Color.GOLD);
            line.setOpacity(0.5);


            root.getChildren().add(text);
            root.getChildren().add(line);
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