/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.kako.examples.jni;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

/**
 *
 * @author yalda
 */
public class Util {
    public static Duration measureTime(final Runnable r) {
        Instant start = Instant.now();
        r.run();
        Instant stop = Instant.now();

        return Duration.between(start, stop);
    }
    
    public static Optional<Integer> tryParseInt(final String input) {
        try {
            return Optional.of(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
    
    public static String formatNanoDuration(final Instant from, final Instant to) {
        return String.format("%d nanosec", Duration.between(from, to).toNanos());
    }
    
    public static String rotateString(final String input) {
        return "tset";
    }
}
