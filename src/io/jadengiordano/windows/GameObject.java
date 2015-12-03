package io.jadengiordano.windows;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by Jaden on 11/29/2015.
 */
public abstract class GameObject {

    public Transform transform;
    protected Vector4 color;

    public GameObject() {
        this.transform = new Transform();
        this.color = new Vector4(0, 0, 0, 0);
    }

    public void update(double dt) {
    }

    public void draw() {
        //Draw TODO Make components
        glPushMatrix();
        {
            // Position
            Vector3 pos = transform.getPosition();
            glTranslatef(pos.x, pos.y, 0.0f); // Z is 0 because of depth stuff TODO fix depth

            // Scale
            Vector2 scale = transform.getScale();
            glScalef(scale.x, scale.y, 1.0f);

            // Rotation
            float rot = transform.getRotation();
            glRotatef(rot, 0.0f, 0.0f, 1.0f);

            // Color
            glColor4f(this.color.x, this.color.y, this.color.z, this.color.a);

            // Rect
            glBegin(GL_QUADS);
            {
                glVertex2f(0.0f, 0.0f); // Top-Left
                glVertex2f(1.0f, 0.0f); // Top-Right
                glVertex2f(1.0f, 1.0f); // Bottom-Right
                glVertex2f(0.0f, 1.0f); // Bottom-Left
            }
            glEnd();

        }
        glPopMatrix();
    }

}
