package specmath;

public class Fade {
    public static float Fade(float t) {
        return t*t*t*(t*(t*(float)6.0 - (float)15.0) + (float)10.0);
    }
}