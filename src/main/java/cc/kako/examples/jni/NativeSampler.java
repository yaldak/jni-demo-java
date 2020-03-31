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
    
    /* Basic Types */
    public static native String nativeString();
    public static native int nativeInt();
    public static native int[] nativeIntArray();
    public static native Integer nativeIntegerObject();
    
    public static native String nativeRotateString(String input);
    public static native int nativeArraySumParallel(int[] values);
    public static native void nativeOpenGLTriangle();
    public static native void nativeRaiseException();
}
