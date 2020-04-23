package cc.kako.examples.jni;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

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
        return String.format("%d ns", Duration.between(from, to).toNanos());
    }
    
    public static long calculateNanoDuration(final Instant from, final Instant to) {
        return Duration.between(from, to).toNanos();
    }

    public static String rotateString(final String s) {
        /** Strings are immutable in Java, this is not an exact replica of the C form */
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        char c;
        int i;

        for (i = len - 1; i >= 0; i--) {
            c = s.charAt(i);
            sb.append(c);
        }

        return sb.toString();
    }
}
