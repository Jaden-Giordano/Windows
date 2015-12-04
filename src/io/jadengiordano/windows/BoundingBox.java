package io.jadengiordano.windows;

/**
 * Created by Jaden on 12/3/2015.
 */
public class BoundingBox {

    public Vector3 pos;
    public Vector2 size;

    protected BoundingBox() {
        this.pos = new Vector3(0, 0, 0);
        this.size = new Vector2(1, 1);
    }

    public BoundingBox(Vector3 pos, Vector2 size) {
        this.pos = pos;
        this.size = size;
    }

    public boolean overlaps(BoundingBox b) {
        boolean topLeftCorner = (this.pos.x >= b.pos.x && this.pos.x <= b.pos.x + b.size.x) && (this.pos.y >= b.pos.y && this.pos.y <= b.pos.y + b.size.y);
        boolean topRightCorner = (this.pos.x + this.size.x >= b.pos.x && this.pos.x + this.size.x <= b.pos.x + b.size.x) && (this.pos.y >= b.pos.y && this.pos.y <= b.pos.y + b.size.y);
        boolean bottomRightCorner = (this.pos.x + this.size.x >= b.pos.x && this.pos.x + this.size.x <= b.pos.x + b.size.x) && (this.pos.y + this.size.y >= b.pos.y && this.pos.y + this.size.y <= b.pos.y + b.size.y);
        boolean bottomLeftCorner = (this.pos.x >= b.pos.x && this.pos.x <= b.pos.x + b.size.x) && (this.pos.y + this.size.y >= b.pos.y && this.pos.y + this.size.y <= b.pos.y + b.size.y);

        return topLeftCorner || topRightCorner || bottomRightCorner || bottomLeftCorner;
    }

}
