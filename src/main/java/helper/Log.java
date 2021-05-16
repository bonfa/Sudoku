package helper;

/**
 * Created by bonfa on 10/12/15.
 *
 */
public class Log {

    private static final String SEPARATOR = " - ";

    public static void d(final String tag, final String message) {

        System.out.println(tag + SEPARATOR + message);
    }
}
