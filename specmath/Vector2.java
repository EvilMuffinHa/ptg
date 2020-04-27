package specmath;

public class Vector2 {
    private float iHatModifier;
    private float jHatModifier;
    public Vector2 (float iHatModifier, float jHatModifier) {
        this.iHatModifier = iHatModifier;
        this.jHatModifier = jHatModifier;
    }

    public float getiHatModifier() {
        return iHatModifier;
    }

    public void setiHatModifier(float iHatModifier) {
        this.iHatModifier = iHatModifier;
    }

    public float getjHatModifier() {
        return jHatModifier;
    }

    public void setjHatModifier(float jHatModifier) {
        this.jHatModifier = jHatModifier;
    }

    public float[] getVector() {
        float[] returned = {this.iHatModifier, this.jHatModifier};
        return returned;
    }
    public void setVector(float iHatModifier, float jHatModifier) {
        this.iHatModifier = iHatModifier;
        this.jHatModifier = jHatModifier;
    }
    public float dotProduct(Vector2 other) {
        return this.iHatModifier * other.getiHatModifier() + this.jHatModifier * other.getjHatModifier();
    }

    public String toString() {
        return "(" + this.iHatModifier + ", " + this.jHatModifier + ")";
    }

}

