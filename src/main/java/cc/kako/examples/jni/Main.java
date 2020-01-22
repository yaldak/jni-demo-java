/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.kako.examples.jni;

/**
 *
 * @author yalda
 */
public class Main {
    private static final String SO_PATH = "/tmp/libExample.so";

    static {
        System.load(SO_PATH);
    }

    public static void main(final String[] args) {
        System.out.println("Hello World from Java");
        
        new Main().nativePrint();
    }

    private native void nativePrint();
}
