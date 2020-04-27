package specmath;

public class Lerp {
    public static float Lerp(float t, float a1, float a2) {
        return a1 + t*(a2-a1);
    }
}
