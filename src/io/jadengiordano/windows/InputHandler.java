package io.jadengiordano.windows;

/**
 * Created by Jaden on 12/6/2015.
 */
public interface InputHandler {

    public class CallbackContainer {
        public int key;
        public int action;
        public Runnable function;

        public CallbackContainer(int key, int action, Runnable function) {
            this.key = key;
            this.action = action;
            this.function = function;
        }
    }

    void registerCallback(int b, int a, Runnable function);

    void release();

}
