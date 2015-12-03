package io.jadengiordano.windows;

/**
 * Created by Jaden on 11/29/2015.
 */
public class Vector3 {

    public float x, y, z;

    protected Vector3() {
        this.x = this.y = this.z = 0;
    }

    public Vector3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3(Vector2 v, float z) {
        this.x = v.x;
        this.y = v.y;
        this.z = z;
    }

    public Vector3 add(Vector3 a) {
        return new Vector3(this.x + a.x, this.y + a.y, this.z + a.z);
    }

    public Vector3 sub(Vector3 s) {
        return new Vector3(this.x + s.x, this.y + s.y, this.z + s.z);
    }

    public Vector3 mul(float m) {
        return new Vector3(this.x * m, this.y * m, this.z * m);
    }

    public Vector3 div(float d) {
        if (d == 0) {
            return new Vector3(this.x, this.y, this.z);
        }
        return new Vector3(this.x / d, this.y / d, this.z / d);
    }

    public boolean equals(Vector3 v) {
        return (this.x == v.x && this.y == v.y && this.z == v.z);
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getX() {
        return x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getY() {
        return y;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getZ() {
        return z;
    }
}
