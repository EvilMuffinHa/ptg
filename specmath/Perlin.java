package specmath;

import java.util.ArrayList;

public class Perlin {
    private ArrayList<Integer> permutationTable;
    private int wrap;

    public Perlin (int wrap) {
        this.wrap = wrap;
        permutationTable = new ArrayList();
        for (int i = 0; i < this.wrap+1; i ++ ) {
            permutationTable.add(i);
        }
        Shuffle.Shuffle(permutationTable);
        for (int i = 0; i < this.wrap+1; i++) {
            permutationTable.add(permutationTable.get(i));
        }


    }

    public float Perlin2D(float x, float y) {
        int X = (int)Math.floor(x) % this.wrap;
        int Y = (int)Math.floor(y) % this.wrap;

        float xDifference = x - (float)Math.floor(x);
        float yDifference = y - (float)Math.floor(y);

        Vector2 topRight = new Vector2(xDifference - (float)1.0, yDifference - (float)1.0);
        Vector2 topLeft = new Vector2(xDifference, yDifference - (float)1.0);
        Vector2 bottomRight = new Vector2(xDifference - (float)1.0, yDifference);
        Vector2 bottomLeft = new Vector2(xDifference, yDifference);

        int valueTopRight = this.permutationTable.get(this.permutationTable.get(X+1) + Y + 1);
        int valueTopLeft = this.permutationTable.get(this.permutationTable.get(X) + Y + 1);
        int valueBottomRight = this.permutationTable.get(this.permutationTable.get(X+1) + Y);
        int valueBottomLeft = this.permutationTable.get(this.permutationTable.get(X) + Y);

        Vector2 v1 = getCVector(valueTopRight);
        Vector2 v2 = getCVector(valueTopLeft);
        Vector2 v3 = getCVector(valueBottomRight);
        Vector2 v4 = getCVector(valueBottomLeft);

        float dpTopRight = topRight.dotProduct(v1);
        float dpTopLeft = topLeft.dotProduct(v2);
        float dpBottomRight = bottomRight.dotProduct(v3);
        float dpBottomLeft = bottomLeft.dotProduct(v4);


        float u = Fade.Fade(xDifference);
        float v = Fade.Fade(yDifference);


        return Lerp.Lerp(u, Lerp.Lerp(v, dpBottomLeft, dpTopLeft), Lerp.Lerp(v, dpBottomRight, dpTopRight));
    }


    public static Vector2 getCVector(int permValue) {
        Vector2[] cVectorTable = {new Vector2((float)1.0, (float)1.0), new Vector2((float)-1.0, (float)1.0),
                new Vector2((float)-1.0, (float)-1.0), new Vector2((float)1.0, (float)-1.0),
                new Vector2(0, (float)Math.sqrt(2)/2), new Vector2((float)Math.sqrt(2)/2, 0),
        new Vector2(0, (float)-Math.sqrt(2)/2), new Vector2((float)-Math.sqrt(2)/2, 0)};

        int h = permValue % cVectorTable.length;
        return cVectorTable[h];
    }
}
