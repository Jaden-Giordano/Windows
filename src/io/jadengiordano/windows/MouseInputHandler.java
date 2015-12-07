package io.jadengiordano.windows;

import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.glfw.GLFW.glfwSetCursorPosCallback;
import static org.lwjgl.glfw.GLFW.glfwSetMouseButtonCallback;

/**
 * Created by Jaden on 12/6/2015.
 */
public class MouseInputHandler implements InputHandler {

    GLFWMouseButtonCallback mouseCallback;

    List<CallbackContainer> callbacks;

    private Vector2 pos;

    public MouseInputHandler() {
        this.callbacks = new ArrayList<CallbackContainer>();

        this.pos = new Vector2(0, 0);

        glfwSetCursorPosCallback(Windows.instance.window, new GLFWCursorPosCallback() {
            @Override
            public void invoke(long window, double xpos, double ypos) {
                pos = new Vector2((float) xpos, (float) ypos);
            }
        });

        glfwSetMouseButtonCallback(Windows.instance.window, mouseCallback = new GLFWMouseButtonCallback() {
            @Override
            public void invoke(long window, int button, int action, int mods) {
                for (CallbackContainer i : callbacks) {
                    if (i.key == button && i.action == action)
                        i.function.run();
                }
            }
        });
    }

    @Override
    public void registerCallback(int b, int a, Runnable function) {
        this.callbacks.add(new CallbackContainer(b, a, function));
    }

    @Override
    public void release() {
        this.mouseCallback.release();
    }

    public Vector2 getMousePosition() {
        return this.pos;
    }

}
