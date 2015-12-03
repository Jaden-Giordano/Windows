package io.jadengiordano.windows;

/**
 * Created by Jaden on 11/29/2015.
 */
public class Transform {

    private Vector3 position;
    private Vector2 scale;
    private float rotation;

    protected Transform() {
        this.position = new Vector3(0, 0, 0);
        this.scale = new Vector2(1, 1);
        this.rotation = 0;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    public void setPosition(float x, float y, float z) {
        this.setPosition(new Vector3(x, y, z));
    }

    public Vector3 getPosition() {
        return this.position;
    }

    public void setScale(Vector2 scale) {
        this.scale = scale;
    }

    public void setScale(float x, float y) {
        this.setScale(new Vector2(x, y));
    }

    public Vector2 getScale() {
        return this.scale;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public float getRotation() {
        return this.rotation;
    }

}
