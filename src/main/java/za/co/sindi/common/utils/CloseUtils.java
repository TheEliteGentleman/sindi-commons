/**
 * 
 */
package za.co.sindi.common.utils;

import java.io.Closeable;
import java.io.IOException;

import javax.naming.Context;
import javax.naming.NamingException;

/**
 * This utility class will contain all methods that contain a <code>close()</code> method.
 * 
 * @author Bienfait Sindi
 * @since 10 August 2014
 *
 */
public final class CloseUtils {

	private CloseUtils() {
		throw new AssertionError("Private constructor.");
	}
	
	public static final void close(AutoCloseable o) throws Exception {
		if (o != null) {
			o.close();
		}
	}
	
	public static final void close(Closeable o) throws IOException {
		if (o != null) {
			o.close();
		}
	}
	
	public static final void close(Context context) throws NamingException {
		if (context != null) {
			context.close();
		}
	}
}
