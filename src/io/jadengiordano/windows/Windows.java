package io.jadengiordano.windows;

import io.jadengiordano.windows.handlers.KeyInputHandler;
import io.jadengiordano.windows.handlers.MouseInputHandler;
import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

/**
 * Created by Jaden on 11/29/2015.
 */
public class Windows {

    public static Windows instance;

    public static int WIDTH = 1280, HEIGHT = 720;

    // We need to strongly reference callback instances.
    private GLFWErrorCallback errorCallback;
    private KeyInputHandler keyCallback;
    private MouseInputHandler mouseCallback;

    // The window handle
    public long window;

    Game game;

    public void run() {
        System.out.println("Hello LWJGL " + Version.getVersion() + "!");

        try {
            init();
            loop();

            // Release window and window callbacks
            glfwDestroyWindow(window);
            keyCallback.release();
            mouseCallback.release();
        } finally {
            // Terminate GLFW and release the GLFWErrorCallback
            glfwTerminate();
            errorCallback.release();
        }
    }

    private void init() {
        // Setup an error callback. The default implementation
        // will print the error message in System.err.
        glfwSetErrorCallback(errorCallback = GLFWErrorCallback.createPrint(System.err));

        // Initialize GLFW. Most GLFW functions will not work before doing this.
        if (glfwInit() != GLFW_TRUE)
            throw new IllegalStateException("Unable to initialize GLFW");

        // Configure our window
        glfwDefaultWindowHints(); // optional, the current window hints are already the default
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable

        // Create the window
        window = glfwCreateWindow(WIDTH, HEIGHT, "Hello World!", NULL, NULL);
        if (window == NULL)
            throw new RuntimeException("Failed to create the GLFW window");

        // Setup keycallback
        keyCallback = new KeyInputHandler();
        mouseCallback = new MouseInputHandler();

        // Get the resolution of the primary monitor
        GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        // Center our window
        glfwSetWindowPos(
                window,
                (vidmode.width() - WIDTH) / 2,
                (vidmode.height() - HEIGHT) / 2
        );

        // Make the OpenGL context current
        glfwMakeContextCurrent(window);
        // Enable v-sync
        glfwSwapInterval(1);

        // Make the window visible
        glfwShowWindow(window);
    }

    public Game getGame() {
        return this.game;
    }

    private void loop() {
        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.
        GL.createCapabilities();

        glMatrixMode(GL_PROJECTION);
        glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
        glMatrixMode(GL_MATRIX_MODE);

        // Set the clear color
        glClearColor(1.0f, 1.0f, 1.0f, 1.0f);

        game = new Game();

        double oldTime = ((double) System.currentTimeMillis()) / 1000;

        // Run the rendering loop until the user has attempted to close
        // the window or has pressed the ESCAPE key.
        while (glfwWindowShouldClose(window) == GLFW_FALSE) {
            double newTime = ((double) System.currentTimeMillis()) / 1000;
            double dt = newTime - oldTime;
            Timer.deltaTime = dt;
            oldTime = newTime;
            game.update();

            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer

            game.draw();

            glfwSwapBuffers(window); // swap the color buffers

            // Poll for window events. The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }

    public KeyInputHandler getKeyInputHandler() {
        return this.keyCallback;
    }

    public MouseInputHandler getMouseCallback() {
        return this.mouseCallback;
    }

    public static void main(String[] args) {
        instance = new Windows();
        instance.run();
    }

}
