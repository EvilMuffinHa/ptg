
package specmath;
import org.spm.pixelMap;

public class NoiseMap {
    private int x;
    private int y;
    private int wrap;
    private float frequency;
    private int octaves;
    private float persistence;
    private float lacunarity;
    private float amplitude;
    private long seed;
    public NoiseMap(int x, int y, int wrap, float frequency, int octaves, float persistence, float lacunarity, float amplitude) {
        this.x = x;
        this.y = y;
        this.wrap = wrap;
        this.octaves = octaves;
        this.frequency = frequency;
        this.persistence = persistence;
        this.lacunarity = lacunarity;
        this.amplitude = amplitude;
    }
    public pixelMap getMap() {
        Perlin perlin = new Perlin(this.wrap);
        this.seed = perlin.getSeed();
        pixelMap map = new pixelMap(this.x, this.y);
        float a;
        float f;
        for (int i = 0; i < this.x; i ++ ) {
            for (int j = 0; j < this.y; j ++ ) {
                float value = 0;
                a = this.amplitude;
                f = this.frequency;
                for (int o = 0; o < this.octaves; o ++ ) {
                    float result = a * perlin.Perlin2D((float) i * f, (float) j * f);
                    value += result;
                    a *= this.persistence;
                    f *= this.lacunarity;

                }
                value /= this.amplitude;
                value += 1;
                value /= 2;
                map.setPixel(i, j, value, value, value);
            }
        }
        return map;
    }

    public pixelMap getMap(long seed) {
        Perlin perlin = new Perlin(this.wrap, seed);
        this.seed = perlin.getSeed();
        pixelMap map = new pixelMap(this.x, this.y);
        float a;
        float f;
        for (int i = 0; i < this.x; i ++ ) {
            for (int j = 0; j < this.y; j ++ ) {
                float value = 0;
                a = this.amplitude;
                f = this.frequency;
                for (int o = 0; o < this.octaves; o ++ ) {
                    float result = a * perlin.Perlin2D((float) i * f, (float) j * f);
                    value += result;
                    a *= this.persistence;
                    f *= this.lacunarity;

                }
                value /= this.amplitude;
                value += 1;
                value /= 2;
                map.setPixel(i, j, value, value, value);
            }
        }
        return map;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWrap() {
        return wrap;
    }

    public void setWrap(int wrap) {
        this.wrap = wrap;
    }

    public float getFrequency() {
        return frequency;
    }

    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }

    public int getOctaves() {
        return octaves;
    }

    public void setOctaves(int octaves) {
        this.octaves = octaves;
    }

    public float getPersistence() {
        return persistence;
    }

    public void setPersistence(float persistence) {
        this.persistence = persistence;
    }

    public float getLacunarity() {
        return lacunarity;
    }

    public void setLacunarity(float lacunarity) {
        this.lacunarity = lacunarity;
    }

    public float getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(float amplitude) {
        this.amplitude = amplitude;
    }

    public long getSeed() {
        return this.seed;
    }
}
