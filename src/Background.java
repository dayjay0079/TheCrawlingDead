import javafx.scene.canvas.Canvas;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

public class Background {
    private Tile[][] background;
    private int xView;
    private int yView;

    public Background() {
        background = new Tile[40][30];
        xView = 0;
        yView = 0;

        String[] backbuffer_init = FileReader.readFile("./src/memory_init/backbuffer_init.mem");

        for(int y = 0; y < 30; y++) {
            for(int x = 0; x < 40; x++) {
                String filepath = "./src/memory_init/backtile_init_" + Integer.parseInt(backbuffer_init[x + 40*y], 2) + ".mem";
                this.background[x][y] = new Tile(filepath);
            }
        }
    }

    public Canvas paintBackground() {
        Canvas backgroundCanvas = new Canvas(1280*Main.SCREENSIZE, 960*Main.SCREENSIZE);
        PixelWriter pw = backgroundCanvas.getGraphicsContext2D().getPixelWriter();
        int tileScaling = 32*Main.SCREENSIZE;

        for(int yTile = 0; yTile < 30; yTile++) {
            for(int xTile = 0; xTile < 40; xTile++) {
                Color[][] colormap = this.background[xTile][yTile].getPixelMap();
                for(int yPixel = 0; yPixel < 32*Main.SCREENSIZE; yPixel++) {
                    for (int xPixel = 0; xPixel < 32*Main.SCREENSIZE; xPixel++) {
                        int x = xTile*32*Main.SCREENSIZE + xPixel - this.xView;
                        int y = yTile*32*Main.SCREENSIZE + yPixel - this.yView;
                        pw.setColor(x, y, colormap[xPixel/Main.SCREENSIZE][yPixel/Main.SCREENSIZE]);
                    }
                }
            }
        }

        return backgroundCanvas;
    }

    public void viewUp() {
        this.xView -= Main.playerSpeed;
    }
    public void viewDown() {
        this.xView += Main.playerSpeed;
    }
    public void viewLeft() {
        this.yView -= Main.playerSpeed;
    }
    public void viewRight() {
        this.yView += Main.playerSpeed;
    }
}
