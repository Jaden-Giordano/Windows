package io.jadengiordano.windows;

import org.lwjgl.glfw.GLFWKeyCallback;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;

/**
 * Created by Jaden on 11/29/2015.
 */
public class KeyInputHandler {

    protected class CallbackContainer {
        public int key;
        public int action;
        public Runnable function;

        public CallbackContainer(int key, int action, Runnable function) {
            this.key = key;
            this.action = action;
            this.function = function;
        }
    }

    GLFWKeyCallback keyCallback;

    List<CallbackContainer> callbacks;

    public KeyInputHandler() {
        this.callbacks = new ArrayList<CallbackContainer>();

        glfwSetKeyCallback(Windows.instance.window, keyCallback = new GLFWKeyCallback() {
            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                for (CallbackContainer i : callbacks) {
                    if (i.key == key && i.action == action)
                        i.function.run();
                }
            }
        });
    }

    public void registerKeyCallback(int key, int action, Runnable function) {
        this.callbacks.add(new CallbackContainer(key, action, function));
    }

    public void release() {
        keyCallback.release();
    }

}
