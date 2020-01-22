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
    public static void main(final String[] args) {
        System.out.println("Hello");
    }
    
    private native void nativePrint();
}
