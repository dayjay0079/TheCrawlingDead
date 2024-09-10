import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {
    public static final int SCREENSIZE = 1;
    boolean fullscreen = false;
    public static int playerSpeed = 1;
    public Canvas background;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 1280*SCREENSIZE, 960*SCREENSIZE, Color.DARKMAGENTA);
        Background background = new Background();
        this.background = background.paintBackground();

        // Initial window setup
        Image icon = new Image("icon.png");
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("The Crawling Dead with ABRAHAM FORD");
        primaryStage.setFullScreen(fullscreen);

        // Add background to root
        root.getChildren().add(this.background);






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

        MyTimer timer = new MyTimer();
        timer.start();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private class MyTimer extends AnimationTimer {
        private final int FPS = 60;
        private final long FRAME_NANOSECONDS = (int)1e9/FPS;
        private long prevFrame = 0;

        @Override
        public void handle(long now) {
            long dt = now - prevFrame;
            if (dt > FRAME_NANOSECONDS) {
                prevFrame = now;
                //background.set();
            }
        }
    }
}