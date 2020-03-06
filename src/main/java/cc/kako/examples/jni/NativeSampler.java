package cc.kako.examples.jni;

public class NativeSampler {
    // TODO: Make this better
    private static final String SO_PATH = "/tmp/libExample.so";

    static {
        System.load(SO_PATH);
    }
    
    private NativeSampler() {
    }

    /* void */
    public static native void nativePrint();
}
