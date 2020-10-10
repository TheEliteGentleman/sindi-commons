/**
 * 
 */
package za.co.sindi.common.utils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Bienfait Sindi
 * @since 05 October 2015
 *
 */
public final class Arrays {

	private static final int[] EMPTY_INT_PRIMITIVE_ARRAY = new int[0];
	private static final long[] EMPTY_LONG_PRIMITIVE_ARRAY = new long[0];
	private static final Integer[] EMPTY_INTEGER_OBJECT_ARRAY = new Integer[0];
	private static final Long[] EMPTY_LONG_OBJECT_ARRAY = new Long[0];
	
	private Arrays() {
		throw new AssertionError("Private constructor.");
	}
	
	@SafeVarargs
	public static <T> Set<T> asSet(T... t) {
		return new HashSet<>(java.util.Arrays.asList(t));
	}
	
	public static byte[] append(final byte[] array, final byte b) {
		byte[] newArray = new byte[array.length + 1];
		System.arraycopy(array, 0, newArray, 0, array.length);
		newArray[newArray.length - 1] = b;
		
		return newArray;
	}
	
	public static byte[] concat(final byte[] array1, final byte[] array2) {
		byte[] newArray = new byte[array1.length + array2.length];
		System.arraycopy(array1, 0, newArray, 0, array1.length);
		System.arraycopy(array2, 0, newArray, array1.length, array2.length);
		
		return newArray;
	}

	public static byte[] prepend(final byte[] array, final byte b) {
		byte[] newArray = new byte[array.length + 1];
		newArray[0] = b;
		System.arraycopy(array, 0, newArray, 1, array.length);
		
		return newArray;
	}
	
	public static int[] toPrimitives(Integer[] array) {
		if (array == null) {
			return null;
		}
		
		if (array.length == 0) {
			return EMPTY_INT_PRIMITIVE_ARRAY;
		}
		
		int[] newArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i].intValue();
		}
		
		return newArray;
	}
	
	public static int[] toPrimitives(Integer[] array, int defaultValueForNull) {
		if (array == null) {
			return null;
		}
		
		if (array.length == 0) {
			return EMPTY_INT_PRIMITIVE_ARRAY;
		}
		
		int[] newArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			Integer value = array[i];
			newArray[i] = value == null ? defaultValueForNull : value.intValue();
		}
		
		return newArray;
	}
	
	public static long[] toPrimitives(Long[] array) {
		if (array == null) {
			return null;
		}
		
		if (array.length == 0) {
			return EMPTY_LONG_PRIMITIVE_ARRAY;
		}
		
		long[] newArray = new long[array.length];
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i].longValue();
		}
		
		return newArray;
	}
	
	public static long[] toPrimitives(Long[] array, long defaultValueForNull) {
		if (array == null) {
			return null;
		}
		
		if (array.length == 0) {
			return EMPTY_LONG_PRIMITIVE_ARRAY;
		}
		
		long[] newArray = new long[array.length];
		for (int i = 0; i < array.length; i++) {
			Long value = array[i];
			newArray[i] = value == null ? defaultValueForNull : value.longValue();
		}
		
		return newArray;
	}
	
	public static long[] toPrimitiveArray(Long[] array, long defaultValueForNull) {
		if (array == null) {
			return null;
		}
		
		if (array.length == 0) {
			return EMPTY_LONG_PRIMITIVE_ARRAY;
		}
		
		long[] newArray = new long[array.length];
		for (int i = 0; i < array.length; i++) {
			Long value = array[i];
			newArray[i] = value == null ? defaultValueForNull : value.longValue();
		}
		
		return newArray;
	}
	
	public static Integer[] toObject(int[] array) {
		if (array == null) {
			return null;
		}
		
		if (array.length == 0) {
			return EMPTY_INTEGER_OBJECT_ARRAY;
		}
		
		Integer[] newArray = new Integer[array.length];
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		
		return newArray;
	}
	
	public static Long[] toObject(long[] array) {
		if (array == null) {
			return null;
		}
		
		if (array.length == 0) {
			return EMPTY_LONG_OBJECT_ARRAY;
		}
		
		Long[] newArray = new Long[array.length];
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		
		return newArray;
	}
}
