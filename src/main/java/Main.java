import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String... args) {
        BufferedImage image;
        File file = new File(args[0]);
        Scope scope = new Scope();
        try {
            image = ImageIO.read(file);
            scope.left = getLeftScope(image);
            scope.bottom = getBottomScope(image);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get lower scope system of coords
     */
    private static int getBottomScope(BufferedImage image) {
        int[] colorForY = new int[image.getWidth()];
        for (int i = 0; i < image.getWidth(); i++) {
            int j = 0;
            int color = image.getRGB(i, j);
            while (color > getColorScope()) {
                i++;
                color = image.getRGB(i, j);
            }
            colorForY[i] = color;
        }


        return max(colorForY);
    }

    /**
     * Get left scope system of coords
     */
    private static int getLeftScope(BufferedImage image) {
        int[] colorForX = new int[image.getHeight()];
        for (int j = 0; j < image.getHeight(); j++) {
            int i = 0;
            int color = image.getRGB(i, j);
            while (color > getColorScope()) {
                i++;
                color = image.getRGB(i, j);
            }
            colorForX[j] = color;
        }
        return max(colorForX);
    }


    /**
     * Get max value of scope coords
     */
    //TODO find max algo
    private static int max(int[] colorForX) {
        return colorForX[0];
    }

    /**
     * Get color of scope
     */
    //TODO color of scope value
    private static int getColorScope() {
        return 0x000000;
    }
}