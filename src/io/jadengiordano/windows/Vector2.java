package io.jadengiordano.windows;

/**
 * Created by Jaden on 11/29/2015.
 */
public class Vector2 {

    public float x, y;

    protected Vector2() {
        this.x = this.y = 0;
    }

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2 add(Vector2 a) {
        return new Vector2(this.x + a.x, this.y + a.y);
    }

    public Vector2 sub(Vector2 s) {
        return new Vector2(this.x - s.x, this.y - s.y);
    }

    public Vector2 mul(float m) {
        return new Vector2(this.x * m, this.y * m);
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getX() {
        return this.x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getY() {
        return this.y;
    }

}
