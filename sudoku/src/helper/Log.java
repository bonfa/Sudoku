package helper;

import com.sun.istack.internal.NotNull;

import static com.oracle.tools.packager.Log.*;

/**
 * Created by bonfa on 10/12/15.
 *
 */
public class Log {

    private static final String SEPARATOR = " - ";

    public static void d(final @NotNull String tag, final @NotNull String message) {

        debug(tag + SEPARATOR + message);
    }
}
