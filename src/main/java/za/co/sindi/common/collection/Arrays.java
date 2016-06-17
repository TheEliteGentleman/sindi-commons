/**
 * 
 */
package za.co.sindi.common.collection;

/**
 * @author Bienfait Sindi
 * @since 02 March 2015
 *
 */
public class Arrays {

	private Arrays() {
		throw new AssertionError("Private Constructor.");
	}
	
	public static <T> T[] append(T[] array, T value) {
		int length = ((array == null) ? 0 : array.length) + 1;
		T[] result = java.util.Arrays.copyOf(array, length);
		result[length - 1] = value;
		return result;
	}
	
	@SafeVarargs
	public static <T> T[] concat(T[] first, T[]... arrays) {
		//Source copied from: http://stackoverflow.com/questions/80476/how-to-concatenate-two-arrays-in-java/784842#784842
		int totalLength = first.length;
		for (T[] array : arrays) {
			totalLength += array.length;
		}
		T[] result = java.util.Arrays.copyOf(first, totalLength);
		int offset = first.length;
		for (T[] array : arrays) {
			System.arraycopy(array, 0, result, offset, array.length);
			offset += array.length;
		}
		
		return result;
	}
	
	@SafeVarargs
	public static <T> T[] toArray(T... args) {
		return args;
	}
}
