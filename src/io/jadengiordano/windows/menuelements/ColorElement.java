package io.jadengiordano.windows.menuelements;

import io.jadengiordano.windows.*;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by Jaden on 12/22/2015.
 */
public class ColorElement extends MenuElement {

    protected Vector4 color;

    public ColorElement(Menu menu, Vector4 color) {
        super(menu);

        this.color = color;
    }

    @Override
    public void draw() {
        super.draw();

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
