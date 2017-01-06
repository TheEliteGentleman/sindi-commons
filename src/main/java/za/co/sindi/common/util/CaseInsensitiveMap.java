/**
 * 
 */
package za.co.sindi.common.util;

import java.util.Map;

/**
 * A {@link Map} where the key is of type {@link String} and value is parameterized.
 * The key string is case insensitive, i.e., key like "Code"/"code" are considered equal.
 * 
 * @author Bienfait Sindi
 * @since 02 April 2014
 *
 */
public interface CaseInsensitiveMap<V> extends Map<String, V> {

}
