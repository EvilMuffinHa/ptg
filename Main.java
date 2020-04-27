import org.spm.pixelMap;
import specmath.NoiseMap;

import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i ++ ) {
            NoiseMap perlinMap = new NoiseMap(500, 500, 256, (float) 0.005, 8, (float) 0.5, (float) 2.0, 1);
            pixelMap map = perlinMap.getMap();
            for (int x = 0; x < map.getX(); x++) {
                for (int y = 0; y < map.getY(); y++) {
                    int[] rgb = map.getHexPixelAt(x, y);
                    if (map.getPixelAt(x, y)[0] < 0.5) {
                        map.setPixel(x, y, 0, 0, rgb[2] * 2 / (float) 255);
                    } else if (map.getPixelAt(x, y)[0] < 0.501) {
                        map.setPixel(x, y, rgb[2] * (float) 1.3 / (float) 255, rgb[2] * (float) 1.2 / (float) 255, 0);
                    } else if (map.getPixelAt(x, y)[0] < 0.7) {
                        map.setPixel(x, y, 0, rgb[2] / (float) 255, Math.round((rgb[2] * 0.5)) / (float) 255);
                    } else if (map.getPixelAt(x, y)[0] < 0.9) {
                        map.setPixel(x, y, rgb[2] / (float)255, (float)rgb[2]/2 / (float) 255, (float)rgb[2]/4 / (float) 255);
                    } else {
                    }
                }
            }
            map.lwjglRender();
        }
    }
}