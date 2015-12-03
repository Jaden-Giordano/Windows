package io.jadengiordano.windows;

/**
 * Created by Jaden on 12/2/2015.
 */
public class Vector4 {

    public float x, y, z, a;

    protected Vector4() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.a = 0;
    }

    public Vector4(float x, float y, float z, float a) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.a = a;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

}
