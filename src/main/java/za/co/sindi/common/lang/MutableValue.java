/**
 * 
 */
package za.co.sindi.common.lang;

/**
 * @author Bienfait Sindi
 * @since 16 March 2014
 *
 */
public interface MutableValue<T> {

	public T getValue();
	
	public void setValue(T value);
}
