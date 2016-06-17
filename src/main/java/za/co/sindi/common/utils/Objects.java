/**
 * 
 */
package za.co.sindi.common.utils;

/**
 * @author Bienfait Sindi
 * @since 26 April 2014
 *
 */
public final class Objects {

	private Objects() {
		throw new AssertionError("Private constructor.");
	}
	
	@SafeVarargs
	public static <T> T coalesce(T... values) {
		if (values != null) {
			for (T value : values) {
				if (value != null) {
					return value;
				}
			}
		}
		
		return null;
	}
	
	/**
	 * Checks if 2 values are equal.
	 * 
	 * @param value1
	 * @param value2
	 * @return <code>true</code> if <code>value1 === value2</code>, <code>false</code> otherwise. 
	 */
	public static boolean equals(Object value1, Object value2) {
		if (value1 == value2) {
			return true;
		}
		
		if (value1 == null || value2 == null) {
			return false;
		}
		
		return value1.equals(value2);
//		if (value1 == null && value2 == null) {
//			return true;
//		}
//		
//		if (value1 == null || value2 == null) {
//			return false;
//		}
//		
//		if (value1.getClass() != value2.getClass()) {
//			return false;
//		}
//		
//		if (value1 instanceof Comparable) {
//			return ((Comparable<Object>)value1).compareTo(value2) == 0;
//		}
//		
//		return value1.equals(value2);
	}
	
	public static boolean isNull(Object o) {
		return o == null;
	}
}
