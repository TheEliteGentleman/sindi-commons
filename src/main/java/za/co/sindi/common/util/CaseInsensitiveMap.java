/**
 * 
 */
package za.co.sindi.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * A {@link Map} where the key is of type {@link String} and value is parameterized.
 * The key string is case insensitive, i.e., key like "Code"/"code" are considered equal.
 * 
 * <br />A null or empty key string is permitted, and a null value is permitted.
 * 
 * <p /><b>This map is not synchronized.</b>
 * 
 * @author Bienfait Sindi
 * @since 02 April 2014
 *
 */
public class CaseInsensitiveMap<V> extends HashMap<String, V> implements Map<String, V> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7479076804274968383L;

	/**
	 * 
	 */
	public CaseInsensitiveMap() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param initialCapacity
	 * @param loadFactor
	 */
	public CaseInsensitiveMap(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param initialCapacity
	 */
	public CaseInsensitiveMap(int initialCapacity) {
		super(initialCapacity);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param m
	 */
	public CaseInsensitiveMap(Map<? extends String, ? extends V> m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.util.HashMap#get(java.lang.Object)
	 */
	@Override
	public V get(Object key) {
		// TODO Auto-generated method stub
		String keyString = null;
		if (key != null) {
			if (key instanceof String) {
				keyString = (String) key;
			} else {
				keyString = key.toString();
			}
		}
		
		return super.get(keyString == null ? null : keyString.toLowerCase());
	}

	/* (non-Javadoc)
	 * @see java.util.HashMap#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V put(String key, V value) {
		// TODO Auto-generated method stub
		return super.put(key == null ? null : key.toLowerCase(), value);
	}
}
