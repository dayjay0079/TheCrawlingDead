import javafx.scene.paint.Color;

public class Tile {
    protected Color[][] pixelMap;

    public Tile(String filename) {
        // Read .mem file
        String[] fileContents = FileReader.readFile(filename);

        // Convert to 2D colormap
        Color[][] pixelMap = new Color[32][32];
        for(int i = 0; i < fileContents.length; i++) {
            String currentPixel = fileContents[i];
            int a = 1 - Integer.parseInt(currentPixel.charAt(0) + "");
            int r = 85 * Integer.parseInt(currentPixel.charAt(1) + "" + currentPixel.charAt(2), 2);
            int g = 85 * Integer.parseInt(currentPixel.charAt(3) + "" + currentPixel.charAt(4), 2);
            int b = 85 * Integer.parseInt(currentPixel.charAt(5) + "" + currentPixel.charAt(6), 2);
            pixelMap[i % 32][i / 32] = Color.rgb(r, g, b, a);
        }

        this.pixelMap = pixelMap;
    }

    public Color[][] getPixelMap() {
        return this.pixelMap;
    }
}