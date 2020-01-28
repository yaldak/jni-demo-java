package cc.kako.examples.jni;

import java.util.List;
import java.util.Map;

public class NativeSampler {
    // TODO: Make this better
    private static final String SO_PATH = "/tmp/libExample.so";

    static {
        System.load(SO_PATH);
    }
    
    private NativeSampler() {
    }
    
    /* General */
    public static native void nativeMethodWithArguments(final int a, final int b);
    
    /* void */
    public static native void nativePrint();
    
    /* String */
    public static native String nativeString();
    
    /* boolean & Boolean */
    public static native boolean nativeBoolean();
    public static native Boolean nativeBooleanBoxed();
    
    /* char & Character */
    public static native char nativeChar();
    public static native Character nativeCharBoxed();
    
    /* Numbers */
    public static native int nativeInt();
    public static native Integer nativeIntBoxed();
    
    public static native long nativeLong();
    public static native Long nativeLongBoxed();
    
    public static native short nativeShort();
    public static native Short nativeShortBoxed();
    
    public static native double nativeDouble();
    public static native Double nativeDoubleBoxed();
    
    public static native float nativeFloat();
    public static native Float nativeFloatBoxed();
    
    /* null */
    public static native Object nativeNull();
    
    /* Arrays & Collections */
    public static native int[] nativeIntArray();
    public static native int[][] nativeIntArray2D();
    public static native char[] nativeCharArray();
    public static native List<String> nativeStringList();
    public static native Map<String, String> nativeStringMap();
    
    /* Exceptions */
    public static native void nativeException();
    // public static native void nativeCheckedException() throws Exception();
    
    /* Object structures */
    // TODO 
    // private native SimpleObject nativeSimpleObject();
}
