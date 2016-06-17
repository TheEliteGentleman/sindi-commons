/**
 * 
 */
package za.co.sindi.common.utils;

/**
 * @author Bienfait Sindi
 * @sine 18 March 2015
 *
 */
public final class Varargs {

	private Varargs() {
		throw new AssertionError("Private constructor.");
	}
	
	@SafeVarargs
	public static <V> V[] toArray(V... values) {
		return values;
	}
}
