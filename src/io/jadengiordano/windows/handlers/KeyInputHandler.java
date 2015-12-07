package io.jadengiordano.windows.handlers;

import io.jadengiordano.windows.InputHandler;
import io.jadengiordano.windows.Windows;
import org.lwjgl.glfw.GLFWKeyCallback;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;

/**
 * Created by Jaden on 11/29/2015.
 */
public class KeyInputHandler implements InputHandler {

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

    public void registerCallback(int key, int action, Runnable function) {
        this.callbacks.add(new CallbackContainer(key, action, function));
    }

    public void release() {
        keyCallback.release();
    }

}
